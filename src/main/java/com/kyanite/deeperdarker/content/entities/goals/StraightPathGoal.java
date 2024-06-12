package com.kyanite.deeperdarker.content.entities.goals;

import com.kyanite.deeperdarker.content.entities.OvercastVessel;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.StreamSupport;

public class StraightPathGoal extends Goal {
    private final OvercastVessel mob;
    private final double speedModifier;
    private int nextMovement = 0;

    public StraightPathGoal(OvercastVessel mob, double speedModifier) {
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        LivingEntity target = this.mob.getTarget();
        if (target == null || !target.isAlive()) {
            return false;
        }
        return true;
    }

    protected void createPath(LivingEntity target) {
        if (this.nextMovement > 0) {
            this.nextMovement = Math.max(this.nextMovement - 1, 0);
            return;
        }
        var block = this.mob.level().getBlockState(this.mob.blockPosition().below()).getBlock();
        Vec3 difference = target.position().subtract(this.mob.position());

        var slipperiness = block.getFriction();
        var defaultSlipperiness = Blocks.GRASS_BLOCK.getFriction();
        float multiplier = 1.0f;
        if (slipperiness > defaultSlipperiness) {
            multiplier = defaultSlipperiness / slipperiness;
            multiplier *= multiplier;
        }

        if (Math.abs(difference.x()) - Math.abs(difference.z()) > 1.0f) {
            this.mob.addDeltaMovement(new Vec3(Mth.sign(difference.x()) * multiplier * 0.475, 0.0, 0.0));
        } else {
            this.mob.addDeltaMovement(new Vec3(0.0, 0.0, Mth.sign(difference.z()) * multiplier * 0.475));
        }
        double speed = Math.pow(Math.min(this.speedModifier * this.mob.getMaxHealth() / this.mob.getHealth(), 3.0f), 2.5) / 10.0 + 1;
        this.nextMovement = Math.round(10.0f / (float)speed);
    }

    @Override
    public boolean canContinueToUse() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity == null || !livingEntity.isAlive() || !this.mob.isWithinRestriction(livingEntity.blockPosition())) {
            return false;
        }
        return !(livingEntity instanceof Player) || !livingEntity.isSpectator() && !((Player)livingEntity).isCreative() && !this.mob.horizontalCollision && !this.mob.verticalCollision;
    }

    @Override
    public void start() {
        this.mob.setAggressive(true);
    }

    @Override
    public void stop() {
        LivingEntity target = this.mob.getTarget();
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
            this.mob.setTarget(null);
        }
        this.mob.setAggressive(false);
        this.mob.getNavigation().stop();
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        LivingEntity target = this.mob.getTarget();
        if (target == null) {
            return;
        }
        if (this.mob.getSensing().hasLineOfSight(target) && this.mob.getNavigation().isDone()) {
            this.createPath(target);
            this.mob.lookAt(target, 30.0f, 30.0f);
        }
    }
}
