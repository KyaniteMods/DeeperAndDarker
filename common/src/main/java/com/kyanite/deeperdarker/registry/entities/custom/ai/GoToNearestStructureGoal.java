package com.kyanite.deeperdarker.registry.entities.custom.ai;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.ActionAnimatedEntity;
import com.kyanite.deeperdarker.registry.entities.custom.ScavengerEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;

public class GoToNearestStructureGoal extends Goal {
    private final ScavengerEntity entity;
    final double speedModifier;
    public GoToNearestStructureGoal(ScavengerEntity entity, double d) {
        this.entity = entity;
        this.speedModifier = d;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void tick() {
        if (entity.structureLocation != null && !entity.getNavigation().isInProgress()) {
            entity.getNavigation().setCanFloat(true);
            entity.getNavigation().moveTo(entity.structureLocation.getX(), entity.structureLocation.getY(), entity.structureLocation.getZ(), this.speedModifier);
            entity.setGlowingTag(true);
        }

        if (entity.structureLocation != null && entity.getNavigation().isDone()) {
            DeeperAndDarker.LOGGER.info("ARRIVVED");
            entity.structureLocation = null;
            entity.getNavigation().stop();
            entity.setGlowingTag(false);
        }
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void start() {
        super.start();
    }
}
