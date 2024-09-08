package com.kyanite.deeperdarker.content.entities.goals;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class DisturbanceGoal extends Goal {
    private final PathfinderMob mob;
    private final double speedModifier;

    public DisturbanceGoal(PathfinderMob mob, double speedModifier) {
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if(mob instanceof DisturbanceListener listener) {
            return listener.getDisturbanceLocation() != null;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        assert mob instanceof DisturbanceListener;
        if(this.mob.getNavigation().isDone()) {
            ((DisturbanceListener) mob).setDisturbanceLocation(null);
            return false;
        }
        return this.mob.getNavigation().getTargetPos() == ((DisturbanceListener) mob).getDisturbanceLocation();
    }

    @Override
    public void start() {
        this.mob.getNavigation().moveTo(mob.getNavigation().createPath(((DisturbanceListener) mob).getDisturbanceLocation(), 0), this.speedModifier);
    }

    @Override
    public void stop() {
        this.mob.getNavigation().stop();
    }
}
