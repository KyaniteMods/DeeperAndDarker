package com.kyanite.deeperdarker.registry.entities.custom.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class FlyingWanderGoal extends Goal {
    protected final PathfinderMob mob;

    public FlyingWanderGoal(PathfinderMob mob) {
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        return mob.getNavigation().isDone() && mob.getRandom().nextInt(10) == 0;
    }

    @Override
    public boolean canContinueToUse() {
        return mob.getNavigation().isInProgress();
    }

    @Override
    public void start() {
        Vec3 vec3 = this.findPos();
        if(vec3 != null) {
            mob.getNavigation().moveTo(mob.getNavigation().createPath(new BlockPos((int) this.findPos().x, (int) this.findPos().y, (int) this.findPos().z), 1), 1.0D);
        }

    }

    @Nullable
    protected Vec3 findPos() {
        Vec3 viewVector = mob.getViewVector(0.0F);
        Vec3 hoverPos = HoverRandomPos.getPos(mob, 8, 7, viewVector.x, viewVector.z, ((float) Math.PI / 2F), 3, 1);
        return hoverPos != null ? hoverPos : AirAndWaterRandomPos.getPos(mob, 8, 4, -2, viewVector.x, viewVector.z, (float) Math.PI / 2F);
    }
}
