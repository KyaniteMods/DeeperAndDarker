package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SculkSpreader;
import org.jetbrains.annotations.Nullable;

public class SculkPrimedTNT extends PrimedTnt {
    public SculkPrimedTNT(EntityType<? extends PrimedTnt> entityType, Level level) {
        super(entityType, level);
    }

    public SculkPrimedTNT(Level level, double d, double e, double f, @Nullable LivingEntity livingEntity) {
        this(DDEntities.SCULK_TNT, level);
        this.setPos(d, e, f);
        double g = level.random.nextDouble() * 6.2831854820251465;
        this.setDeltaMovement(-Math.sin(g) * 0.02, 0.2f, -Math.cos(g) * 0.02);
        this.setFuse(80);
        this.xo = d;
        this.yo = e;
        this.zo = f;
        this.owner = livingEntity;
    }

    @Override
    public void tick() {
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.04, 0.0));
        }
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.setDeltaMovement(this.getDeltaMovement().scale(0.98));
        if (this.onGround()) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.7, -0.5, 0.7));
        }
        int i = this.getFuse() - 1;
        this.setFuse(i);
        if (i <= 0) {
            this.discard();
            if (!this.level().isClientSide) {
                this.explode();
            }
        } else {
            this.updateInWaterStateAndDoFluidPushing();
            if (this.level().isClientSide) {
                this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5, this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    private void explode() {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 4.0f, (1.0f + (this.level().getRandom().nextFloat() - this.level().getRandom().nextFloat()) * 0.2f) * 0.7f);
        SculkSpreader spreader = SculkSpreader.createLevelSpreader();
        spreader.addCursors(new BlockPos((int) (this.getX() + 0.5 * Direction.UP.getNormal().getX()), (int) (this.getY() + 0.5 * Direction.UP.getNormal().getY()), (int) (this.getZ() + 0.5 * Direction.UP.getNormal().getZ())), 20);
        for(int i = 0; i < 15; i++) {
            spreader.updateCursors(this.level(), this.blockPosition(), this.level().getRandom(), true);
        }
    }
}