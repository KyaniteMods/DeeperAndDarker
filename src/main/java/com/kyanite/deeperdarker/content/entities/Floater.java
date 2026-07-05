package com.kyanite.deeperdarker.content.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Floater extends Vex {
    public Floater(EntityType<? extends Vex> entityType, Level level) {
        super(entityType, level);
        moveControl = new FloaterMoveControl(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        removeAllGoals(goal -> goal instanceof LookAtPlayerGoal);
    }

    public static AttributeSupplier createFloaterAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 28.0).add(Attributes.ATTACK_DAMAGE, 8.0).build();
    }

    @Override
    public boolean isCurrentlyGlowing() {
        return true;
    }

    class FloaterMoveControl
            extends MoveControl {
        public FloaterMoveControl(Vex vex2) {
            super(vex2);
        }

        @Override
        public void tick() {
            if (this.operation != MoveControl.Operation.MOVE_TO) {
                return;
            }
            Vec3 vec3 = new Vec3(this.wantedX - Floater.this.getX(), this.wantedY - Floater.this.getY(), this.wantedZ - Floater.this.getZ());
            double d = vec3.length();
            if (d < Floater.this.getBoundingBox().getSize()) {
                this.operation = MoveControl.Operation.WAIT;
                Floater.this.setDeltaMovement(Floater.this.getDeltaMovement().scale(0.5));
            } else {
                Floater.this.setDeltaMovement(Floater.this.getDeltaMovement().add(vec3.scale(this.speedModifier * 0.05 / d)));
            }

            Floater.this.getLookControl().setLookAt(wantedX, wantedY, wantedZ);
            Floater.this.yBodyRot = Floater.this.getYRot();
        }
    }
}
