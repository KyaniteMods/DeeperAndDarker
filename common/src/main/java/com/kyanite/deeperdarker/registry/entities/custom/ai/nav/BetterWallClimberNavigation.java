package com.kyanite.deeperdarker.registry.entities.custom.ai.nav;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import org.jetbrains.annotations.Nullable;

// Credit to AzureDoom for figuring out how to fix Vanilla's spinning bug
public class BetterWallClimberNavigation extends GroundPathNavigation {
    @Nullable
    private BlockPos pathToPosition;

    public BetterWallClimberNavigation(Mob mob, Level level) {
        super(mob, level);
    }

    @Override
    public Path createPath(BlockPos pos, int accuracy) {
        this.pathToPosition = pos;
        return super.createPath(pos, accuracy);
    }

    @Override
    public Path createPath(Entity entity, int i) {
        this.pathToPosition = entity.blockPosition();
        return super.createPath(entity, i);
    }

    @Override
    public boolean moveTo(Entity entity, double speed) {
        Path path = this.createPath(entity, 0);
        if(path != null) {
            return this.moveTo(path, speed);
        } else {
            this.pathToPosition = entity.blockPosition();
            this.speedModifier = speed;
            return true;
        }
    }

    @Override
    public void tick() {
        if(!this.isDone()) {
            super.tick();
        } else {
            if(this.pathToPosition != null) {
                if(!this.pathToPosition.closerToCenterThan(this.mob.position(),
                        Math.max(this.mob.getBbWidth(), 1.0D))
                        && (!(this.mob.getY() > (double) this.pathToPosition.getY())
                        || !(new BlockPos(this.pathToPosition.getX(), this.mob.getY(),
                        this.pathToPosition.getZ())).closerToCenterThan(this.mob.position(),
                        Math.max(this.mob.getBbWidth(), 1.0D)))) {
                    this.mob.getMoveControl().setWantedPosition(this.pathToPosition.getX(), this.pathToPosition.getY(),
                            this.pathToPosition.getZ(), this.speedModifier);
                } else {
                    this.pathToPosition = null;
                }
            }
        }
    }
}
