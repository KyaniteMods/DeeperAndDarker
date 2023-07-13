package com.kyanite.deeperdarker.content.entities.goals;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;

public class GoToDisturbanceGoal extends Goal {
    private final PathfinderMob mob;

    public GoToDisturbanceGoal(PathfinderMob mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void tick() {
        if(mob instanceof DisturbanceListener listener) {
            if(listener.getDisturbanceLocation() != null && !mob.getNavigation().isInProgress()) {
                Path path = mob.getNavigation().createPath(listener.getDisturbanceLocation(), 0);
                mob.getNavigation().moveTo(path, 1);
            }

            if(listener.getDisturbanceLocation() != null && mob.getNavigation().isDone()) {
                listener.setDisturbanceLocation(null);
            }
        }
    }
}
