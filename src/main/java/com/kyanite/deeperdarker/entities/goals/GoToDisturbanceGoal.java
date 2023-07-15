package com.kyanite.deeperdarker.entities.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.mob.PathAwareEntity;

import java.util.EnumSet;

public class GoToDisturbanceGoal extends Goal {
    private final PathAwareEntity mob;

    public GoToDisturbanceGoal(PathAwareEntity mob) {
        this.mob = mob;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public void tick() {
        if (this.mob instanceof DisturbanceListener listener) {
            if (listener.getDisturbanceLocation() != null && !this.mob.getNavigation().isFollowingPath()) {
                Path path = this.mob.getNavigation().findPathTo(listener.getDisturbanceLocation(), 0);
                this.mob.getNavigation().startMovingAlong(path, 1);
            }

            if (listener.getDisturbanceLocation() != null && this.mob.getNavigation().isIdle()) {
                listener.setDisturbanceLocation(null);
            }
        }
    }
}
