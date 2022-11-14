package com.kyanite.deeperdarker.registry.entities.custom.ai;

import com.kyanite.deeperdarker.miscellaneous.ActionAnimatedEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;

public class GoToDisturbanceGoal extends Goal {
    private final ActionAnimatedEntity entity;

    public GoToDisturbanceGoal(ActionAnimatedEntity entity) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void tick() {
        if(entity instanceof IDisturbanceListener disturbanceListener) {
            if(disturbanceListener.getDisturbanceLocation() != null && !entity.getNavigation().isInProgress()) {
                Path path = entity.getNavigation().createPath(disturbanceListener.getDisturbanceLocation(), 0);
                entity.getNavigation().moveTo(path, 1);
            }

            if(disturbanceListener.getDisturbanceLocation() != null && entity.getNavigation().isDone()) {
                disturbanceListener.setDisturbanceLocation(null);
            }
        }
    }

    @Override
    public void start() {

    }
}
