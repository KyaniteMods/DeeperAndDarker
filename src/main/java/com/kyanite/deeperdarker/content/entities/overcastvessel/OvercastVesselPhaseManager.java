package com.kyanite.deeperdarker.content.entities.overcastvessel;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselIdlePhase;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselPhase;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselSliderPhase;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselUseItemPhase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.Items;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class OvercastVesselPhaseManager {
    private final OvercastVessel vessel;
    private Deque<OvercastVesselPhase> phases = new ArrayDeque<>();

    public OvercastVesselPhaseManager(OvercastVessel vessel) {
        this.vessel = vessel;
    }

    public void loadFrom(CompoundTag compoundTag) {
        if (compoundTag.contains("phases", Tag.TAG_LIST)) {
            phases = OvercastVesselPhase.CODEC.listOf().<Deque<OvercastVesselPhase>>xmap(ArrayDeque::new, ArrayList::new).parse(NbtOps.INSTANCE, compoundTag.getList("phases", Tag.TAG_LIST)).resultOrPartial(DeeperDarker.LOGGER::error).orElse(new ArrayDeque<>());
            if (!phases.isEmpty()) phases.getFirst().initialize(vessel);
        } else {
            populatePhases();
        }
    }

    public void save(CompoundTag compoundTag) {
        OvercastVesselPhase.CODEC.listOf().<Deque<OvercastVesselPhase>>xmap(ArrayDeque::new, ArrayList::new).encodeStart(NbtOps.INSTANCE, phases).resultOrPartial(DeeperDarker.LOGGER::error).ifPresent(tag -> compoundTag.put("phases", tag));
    }

    public void tick() {
        if (phases.isEmpty()) {
            if (!populatePhases()) return;
            phases.getFirst().initialize(vessel);
            phases.getFirst().start(vessel);
        }

        while (!phases.isEmpty() && !phases.getFirst().shouldContinue(vessel)) {
            phases.getFirst().end(vessel);
            phases.removeFirst();
            if (!phases.isEmpty()) {
                phases.getFirst().initialize(vessel);
                phases.getFirst().start(vessel);
            }
        }

        if (!phases.isEmpty()) {
            phases.getFirst().tick(vessel);
        }
    }

    public boolean populatePhases() {
        float healthPercentage = vessel.getHealth() / vessel.getMaxHealth();
        if (healthPercentage > 0.8f) {
            phases.add(new OvercastVesselUseItemPhase(DDItems.POTTY_SPAWN_EGG.getDefaultInstance()));
            phases.add(new OvercastVesselIdlePhase(200));
            phases.add(new OvercastVesselSliderPhase(200));
            phases.add(new OvercastVesselUseItemPhase(Items.BRICK.getDefaultInstance()));
            return true;
        } else if (healthPercentage > 0.5f) {
            phases.add(new OvercastVesselUseItemPhase(List.of(DDItems.POTTY_SPAWN_EGG.getDefaultInstance(), DDItems.POT_SPAWN_EGG.getDefaultInstance(), DDItems.POTTER_SPAWN_EGG.getDefaultInstance()), 10));
            phases.add(new OvercastVesselIdlePhase(1200));
            return true;
        }
        return false;
    }

    public Deque<OvercastVesselPhase> getPhases() {
        return phases;
    }

    public void reset() {
        phases.clear();
    }
}
