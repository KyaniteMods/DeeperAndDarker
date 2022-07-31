package com.kyanite.deeperdarker.registry.entities.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class SculkWormAttack extends MeleeAttackGoal {
    public SculkWormAttack(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
    }

    @Override
    protected int getAttackInterval() {
        return this.adjustedTickDelay(16);
    }

    @Override
    protected double getAttackReachSqr(LivingEntity pAttackTarget) {
        return 70;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        double d0 = this.getAttackReachSqr(pEnemy);
        SculkWormEntity sculkWormEntity = (SculkWormEntity)this.mob;
        if (pDistToEnemySqr <= d0 && this.getTicksUntilNextAttack() <= 0 && sculkWormEntity.getState() != SculkWormEntity.SculkWormState.EMERGING
        && sculkWormEntity.getState() != SculkWormEntity.SculkWormState.DESCENDING) {
            this.resetAttackCooldown();
            sculkWormEntity.setState(SculkWormEntity.SculkWormState.ATTACKING);
        }
    }
}
