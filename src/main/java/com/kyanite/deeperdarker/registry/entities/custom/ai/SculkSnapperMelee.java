package com.kyanite.deeperdarker.registry.entities.custom.ai;

import com.kyanite.deeperdarker.registry.entities.custom.SculkSnapperEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class SculkSnapperMelee extends MeleeAttackGoal {
    public SculkSnapperMelee(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
    }

    @Override
    protected int getAttackInterval() {
        return this.adjustedTickDelay(16);
    }

    @Override
    protected double getAttackReachSqr(LivingEntity pAttackTarget) {
        return 30;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        double d0 = this.getAttackReachSqr(pEnemy);
        SculkSnapperEntity snapperEntity = (SculkSnapperEntity) this.mob;
        if (pDistToEnemySqr <= d0 && this.getTicksUntilNextAttack() <= 0 && snapperEntity.isMoving == false
                && snapperEntity.getCurrentState() != SculkSnapperEntity.DIG
                && snapperEntity.getCurrentState() != SculkSnapperEntity.EMERGE) {
            this.resetAttackCooldown();
            snapperEntity.setState(SculkSnapperEntity.MOUTH_OPEN);
        }
    }
}
