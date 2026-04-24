package com.kyanite.deeperdarker.content.entities.overseer.phase;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.kyanite.deeperdarker.content.entities.overseer.OverseerCrystal;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class OverseerCrystalsPhase extends OverseerPhase {
    public static final Codec<OverseerCrystalsPhase> CODEC = RecordCodecBuilder.create(instance -> instance.group(
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
        for (int i = 0; i < crystals; i++) {
            OverseerCrystal crystal = new OverseerCrystal(boss.level(), boss);
            crystal.setPos(boss.position());
            ;
            crystal.move(MoverType.SELF, Vec3.directionFromRotation((boss.getRandom().nextFloat() - 0.5f) * 45.0f, boss.getRandom().nextFloat() * 360.0f).scale(boss.getRandom().nextFloat() * 3.0f + 7.0f));
            boss.level().addFreshEntity(crystal);
        }
    }

    @Override
    public boolean shouldContinue(Overseer overseer) {
        return ticksLeft > 0 && (!overseer.getCrystals().isEmpty() || ticksLeft == idleTime);
    }

    @Override
    public void end(Overseer boss) {
        if (!boss.getCrystals().isEmpty()) {
            Set<Entity> set = new HashSet<>(boss.getCrystals());
            for (Entity crystal : set) {
                boss.heal(25.0f);
                if (boss.level() instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.AMETHYST_BLOCK.defaultBlockState()), crystal.getX(), crystal.getY(0.5), crystal.getZ(), 5, crystal.getBbWidth() / 4.0f, crystal.getBbHeight() / 4.0f, crystal.getBbWidth() / 4.0f, 0.05);
                }
                crystal.discard();
            }
        }
    }

    @Override
    public void tick(Overseer overseer) {
        ticksLeft--;
    }

    @Override
    public Codec<? extends OverseerPhase> codec() {
        return CODEC;
    }

    @Override
    public OverseerPhaseType getType() {
        return OverseerPhaseType.CRYSTALS;
    }
}
