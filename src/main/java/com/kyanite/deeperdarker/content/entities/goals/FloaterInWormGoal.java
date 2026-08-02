package com.kyanite.deeperdarker.content.entities.goals;

import java.util.EnumSet;

import com.kyanite.deeperdarker.content.entities.Floater;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

public class FloaterInWormGoal
        extends Goal {
    public final Floater floater;

    public FloaterInWormGoal(Floater floater) {
        this.floater = floater;
        setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return floater.inWorm() && (floater.getWormHead() == null || floater.getWormHead().isAlive());
    }

    @Override
    public boolean canContinueToUse() {
        return floater.inWorm() && (floater.getWormHead() == null || floater.getWormHead().isAlive());
    }

    @Override
    public void stop() {
        floater.leaveWorm();
    }

    @Override
    public void tick() {
    }
}


