package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class OvercastVessel extends AbstractGolemBoss {
    public OvercastVessel(EntityType<? extends AbstractGolem> entityType, Level level) {
        super(entityType, level);
        xpReward = 50;
    }

    public OvercastVessel(Level level, double x, double y, double z) {
        this(DDEntities.OVERCAST_VESSEL, level);
        setPos(x, y, z);
        xo = x;
        yo = y;
        zo = z;
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 1000).add(Attributes.ATTACK_DAMAGE, 40).add(Attributes.ARMOR, 12).add(Attributes.ARMOR_TOUGHNESS, 4).add(Attributes.FOLLOW_RANGE, 100).build();
    }

    @Override
    protected void golemServerAiStep() {

    }
}
