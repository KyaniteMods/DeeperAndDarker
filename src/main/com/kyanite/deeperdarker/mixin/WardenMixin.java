package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.entities.DeeperDarkerEntityGroups;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WardenEntity.class)
public class WardenMixin extends HostileEntity {
    protected WardenMixin(EntityType<? extends HostileEntity> entityType,
                          World world) {
        super(entityType, world);
    }

    @Override
    public EntityGroup getGroup() {
        return DeeperDarkerEntityGroups.SCULK;
    }
}
