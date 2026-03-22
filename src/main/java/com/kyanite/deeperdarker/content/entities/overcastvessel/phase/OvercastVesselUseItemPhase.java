package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVesselItem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class OvercastVesselUseItemPhase extends OvercastVesselPhase {
    public static final Codec<OvercastVesselUseItemPhase> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ItemStack.CODEC.listOf().<Deque<ItemStack>>xmap(ArrayDeque::new, ArrayList::new).fieldOf("stacks").forGetter(phase -> phase.stacks),
            Codec.INT.fieldOf("ticks_between_uses").forGetter(phase -> phase.ticksBetweenUses),
            Codec.INT.fieldOf("cooldown").forGetter(phase -> phase.cooldown)
    ).apply(instance, OvercastVesselUseItemPhase::new));
    private final Deque<ItemStack> stacks;
    private final int ticksBetweenUses;
    private int cooldown;

    public OvercastVesselUseItemPhase(Deque<ItemStack> stacks, int ticksBetweenUses, int cooldown) {
        this.stacks = stacks;
        this.ticksBetweenUses = ticksBetweenUses;
        this.cooldown = cooldown;
    }

    public OvercastVesselUseItemPhase(List<ItemStack> stacks, int ticksBetweenUses, int cooldown) {
        this(new ArrayDeque<>(stacks), ticksBetweenUses, cooldown);
    }

    public OvercastVesselUseItemPhase(List<ItemStack> stacks, int ticksBetweenUses) {
        this(stacks, ticksBetweenUses, 0);
    }

    public OvercastVesselUseItemPhase(ItemStack stack) {
        this(List.of(stack), 0, 0);
    }

    @Override
    public boolean shouldContinue(OvercastVessel vessel) {
        return !stacks.isEmpty();
    }

    @Override
    public void tick(OvercastVessel vessel) {
        if (cooldown == 0) {
            ItemStack stack = stacks.removeFirst();
            vessel.level().addFreshEntity(new OvercastVesselItem(vessel.level(), stack, vessel));
            vessel.level().players().forEach(player -> player.sendSystemMessage(Component.literal("Spawned item: " + stack.getDisplayName().getString())));
            cooldown = ticksBetweenUses;
        } else {
            cooldown--;
        }
    }

    @Override
    public Codec<? extends OvercastVesselPhase> codec() {
        return CODEC;
    }

    @Override
    public OvercastVesselPhaseType getType() {
        return OvercastVesselPhaseType.USE_ITEM;
    }
}
