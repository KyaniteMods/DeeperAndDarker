package com.kyanite.deeperdarker.registry.entities.custom.ai;

import com.kyanite.deeperdarker.registry.entities.custom.ShatteredEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;

public class ShatteredGoToDisturbanceGoal extends Goal {
    private final ShatteredEntity entity;

    public ShatteredGoToDisturbanceGoal(ShatteredEntity entity) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void tick() {
        if(entity.disturbanceLocation != null && !entity.getNavigation().isInProgress()) {
            Path path = entity.getNavigation().createPath(entity.disturbanceLocation, 0);
            entity.getNavigation().moveTo(path, 1);
        }

        if(entity.disturbanceLocation != null && entity.getNavigation().isDone()) {
            entity.disturbanceLocation = null;
        }
    }

    @Override
    public void start() {

    }
}
