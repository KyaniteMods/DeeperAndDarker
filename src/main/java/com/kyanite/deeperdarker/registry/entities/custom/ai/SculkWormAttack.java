package com.kyanite.deeperdarker.registry.entities.custom.ai;

import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
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
        double reach = this.getAttackReachSqr(pEnemy);
        SculkWormEntity sculkWormEntity = (SculkWormEntity) this.mob;
        if(pDistToEnemySqr <= reach && this.getTicksUntilNextAttack() <= 0 && sculkWormEntity.getCurrentState() != SculkWormEntity.EMERGE && sculkWormEntity.getCurrentState() != SculkWormEntity.DESCEND) {
            this.resetAttackCooldown();
            sculkWormEntity.setState(SculkWormEntity.ATTACK);
        }
    }
}
