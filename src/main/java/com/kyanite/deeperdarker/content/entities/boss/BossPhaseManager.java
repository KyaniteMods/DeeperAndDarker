package com.kyanite.deeperdarker.content.entities.boss;

import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.serialization.Codec;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.LivingEntity;

import java.util.*;

public abstract class BossPhaseManager<T extends LivingEntity, U extends BossPhaseType<T, U, V>, V extends BossPhase<T, U, V>> {
    private final T boss;
    private final Codec<V> phaseCodec;
    private Deque<V> phases = new ArrayDeque<>();

    public BossPhaseManager(T boss, Codec<V> phaseCodec) {
        this.boss = boss;
        this.phaseCodec = phaseCodec;
    }

    public void loadFrom(CompoundTag compoundTag) {
        if (compoundTag.contains("phases", Tag.TAG_LIST)) {
            phases = phaseCodec.listOf().<Deque<V>>xmap(ArrayDeque::new, ArrayList::new).parse(NbtOps.INSTANCE, compoundTag.get("phases")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(new ArrayDeque<>());
            if (!phases.isEmpty()) phases.getFirst().initialize(boss);
        } else {
            populatePhases();
        }
    }

    public void save(CompoundTag compoundTag) {
        if (!phases.isEmpty()) phases.getFirst().dataSaved(boss);
        phaseCodec.listOf().<Deque<V>>xmap(ArrayDeque::new, ArrayList::new).encodeStart(NbtOps.INSTANCE, phases).resultOrPartial(DeeperDarker.LOGGER::error).ifPresent(tag -> compoundTag.put("phases", tag));
    }

    public void tick() {
        if (phases.isEmpty()) {
            if (!populatePhases()) return;
            phases.getFirst().initialize(boss);
            phases.getFirst().start(boss);
        }

        while (!phases.isEmpty() && !phases.getFirst().shouldContinue(boss)) {
            phases.getFirst().end(boss);
            phases.removeFirst();
            if (!phases.isEmpty()) {
                phases.getFirst().initialize(boss);
                phases.getFirst().start(boss);
            }
        }

        if (!phases.isEmpty()) {
            phases.getFirst().tick(boss);
        }
    }

    public abstract boolean populatePhases();

    public Deque<V> getPhases() {
        return phases;
    }

    public T getBoss() {
        return boss;
    }

    public void reset() {
        if (!phases.isEmpty())  {
            phases.getFirst().end(boss);
        }
        phases.clear();
    }
}
