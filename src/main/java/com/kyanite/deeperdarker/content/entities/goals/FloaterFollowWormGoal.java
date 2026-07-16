package com.kyanite.deeperdarker.content.entities.goals;

import java.util.EnumSet;
import java.util.List;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.Floater;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FloaterFollowWormGoal
        extends Goal {
    public final Floater floater;

    public FloaterFollowWormGoal(Floater floater) {
        this.floater = floater;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return this.floater.inWorm() && this.floater.getWormHead().isAlive();
    }

    @Override
    public boolean canContinueToUse() {
        return this.floater.inWorm() && this.floater.getWormHead().isAlive();
    }

    @Override
    public void stop() {
        this.floater.leaveWorm();
    }

    @Override
    public void tick() {
        if (!this.floater.inWorm()) {
            return;
        }
        Floater floater = this.floater.getWormHead();
        double d = this.floater.distanceTo(floater);
        float f = 0.75f;
        Vec3 vec3 = new Vec3(floater.getX() - this.floater.getX(), floater.getY() - this.floater.getY(), floater.getZ() - this.floater.getZ()).normalize().scale(Math.max(d - f, 0.0));
        this.floater.moveTo(this.floater.getX() + vec3.x, this.floater.getY() + vec3.y, this.floater.getZ() + vec3.z);
        this.floater.getLookControl().setLookAt(floater);
    }
}


