package com.kyanite.deeperdarker.content.entities.overseer.phase;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.kyanite.deeperdarker.content.entities.overseer.OverseerCrystal;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class OverseerCrystalsPhase extends OverseerPhase {
    private static final ResourceLocation ARMOR_ATTRIBUTE_MODIFIER_ID = DeeperDarker.id("overseer.overseer_crystals_armor");
    private static final AttributeModifier ARMOR_ATTRIBUTE_MODIFIER = new AttributeModifier(ARMOR_ATTRIBUTE_MODIFIER_ID, 10000, AttributeModifier.Operation.ADD_VALUE);
    private static final ResourceLocation ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_ID = DeeperDarker.id("overseer.overseer_crystals_armor_toughness");
    private static final AttributeModifier ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER = new AttributeModifier(ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_ID, 10000, AttributeModifier.Operation.ADD_VALUE);

    public static final MapCodec<OverseerCrystalsPhase> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.INT.fieldOf("crystals").forGetter(phase -> phase.crystals),
            Codec.INT.fieldOf("idle_time").forGetter(phase -> phase.idleTime),
            Codec.INT.fieldOf("ticks_left").forGetter(phase -> phase.ticksLeft)
    ).apply(instance, OverseerCrystalsPhase::new));
    private final int crystals;
    private final int idleTime;
    private int ticksLeft;

    protected OverseerCrystalsPhase(int crystals, int idleTime, int ticksLeft) {
        this.crystals = crystals;
        this.idleTime = idleTime;
        this.ticksLeft = ticksLeft;
    }

    public OverseerCrystalsPhase(int crystals, int idleTime) {
        this.crystals = crystals;
        this.idleTime = idleTime;
        this.ticksLeft = idleTime;
    }

    @Override
    public void start(Overseer boss) {
        if (boss.level().isClientSide()) return;

        AttributeInstance armor = boss.getAttribute(Attributes.ARMOR);
        if (armor != null) {
            armor.addPermanentModifier(ARMOR_ATTRIBUTE_MODIFIER);
        }
        AttributeInstance armorToughness = boss.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (armorToughness != null) {
            armorToughness.addPermanentModifier(ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER);
        }
        for (int i = 0; i < crystals; i++) {
            OverseerCrystal crystal = new OverseerCrystal(boss);
            crystal.setPos(boss.position());
            boss.level().addFreshEntity(crystal);
            crystal.setDeltaMovement(Vec3.directionFromRotation((boss.getRandom().nextFloat() - 0.5f) * 45.0f, boss.getRandom().nextFloat() * 360.0f).scale(boss.getRandom().nextFloat() * 3.0f + 7.0f));
            crystal.move(MoverType.SELF, crystal.getDeltaMovement());
        }
    }

    @Override
    public boolean shouldContinue(Overseer overseer) {
        return ticksLeft > 0 && ((!overseer.isFirstTick() && !overseer.getCrystals().isEmpty()) || ticksLeft == idleTime);
    }

    @Override
    public void end(Overseer boss) {
        if (boss.level().isClientSide()) return;

        AttributeInstance armor = boss.getAttribute(Attributes.ARMOR);
        if (armor != null) {
            armor.removeModifier(ARMOR_ATTRIBUTE_MODIFIER_ID);
        }
        AttributeInstance armorToughness = boss.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (armorToughness != null) {
            armorToughness.removeModifier(ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_ID);
        }
        if (!boss.getCrystals().isEmpty()) {
            Set<Entity> set = new HashSet<>(boss.getCrystals());
            for (Entity crystal : set) {
                boss.heal(200.0f);
                crystal.discard();
            }
        }
    }

    @Override
    public void tick(Overseer overseer) {
        ticksLeft--;
    }

    @Override
    public MapCodec<? extends OverseerPhase> codec() {
        return CODEC;
    }

    @Override
    public OverseerPhaseType getType() {
        return OverseerPhaseType.CRYSTALS;
    }
}
