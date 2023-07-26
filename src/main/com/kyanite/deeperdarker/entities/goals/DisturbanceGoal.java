package com.kyanite.deeperdarker.entities.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.mob.PathAwareEntity;

import java.util.EnumSet;

public class DisturbanceGoal extends Goal {
    private final PathAwareEntity mob;
    private final double speedModifier;

    public DisturbanceGoal(PathAwareEntity mob, double speedModifier) {
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        if(mob instanceof DisturbanceListener listener) {
            return listener.getDisturbanceLocation() != null;
        }
        return false;
    }

    @Override
    public boolean shouldContinue() {
        assert mob instanceof DisturbanceListener;
        if (this.mob.getNavigation().isIdle()) {
            ((DisturbanceListener) mob).setDisturbanceLocation(null);
            return false;
        }
        return this.mob.getNavigation().getTargetPos() == ((DisturbanceListener) mob).getDisturbanceLocation();
    }

    @Override
    public void start() {
        this.mob.getNavigation().startMovingAlong(mob.getNavigation().findPathTo(((DisturbanceListener) mob).getDisturbanceLocation(), 0), this.speedModifier);
    }

    @Override
    public void stop() {
        this.mob.getNavigation().stop();
    }
}