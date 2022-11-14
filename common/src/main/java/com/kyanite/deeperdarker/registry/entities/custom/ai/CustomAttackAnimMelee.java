package com.kyanite.deeperdarker.registry.entities.custom.ai;

import com.kyanite.deeperdarker.miscellaneous.ActionAnimatedEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class CustomAttackAnimMelee extends MeleeAttackGoal {
    public int attackInterval;
    public int attackReach;
    public ActionAnimatedEntity.EntityState state;

    public CustomAttackAnimMelee(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen, int attackInterval, int attackReach, ActionAnimatedEntity.EntityState entityState) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.attackInterval = attackInterval;
        this.attackReach = attackReach;
        this.state = entityState;
    }

    @Override
    protected int getAttackInterval() {
        return this.adjustedTickDelay(attackInterval);
    }

    @Override
    protected double getAttackReachSqr(LivingEntity pAttackTarget) {
        return attackReach + pAttackTarget.getBbWidth();
    }

    public boolean checkInRange(float a, float b, double deviation) {
        if(a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }

        return ((a - b) <= deviation || a == b);
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        double d0 = this.getAttackReachSqr(pEnemy);
        ActionAnimatedEntity entity = (ActionAnimatedEntity) this.mob;
        if(pDistToEnemySqr <= d0 && checkInRange(pEnemy.blockPosition().getY(), entity.blockPosition().getY() + 5, 5) && this.getTicksUntilNextAttack() <= 0 && !entity.isMoving) {
            this.resetAttackCooldown();
            entity.setState(state);
        }
    }
}
