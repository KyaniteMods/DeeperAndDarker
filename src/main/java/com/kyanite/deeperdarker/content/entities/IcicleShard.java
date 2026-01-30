package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class IcicleShard extends AbstractArrow {
    public int age = 0;

    public IcicleShard(EntityType<? extends IcicleShard> entityType, Level level) {
        super(entityType, level);
    }

    public IcicleShard(double d, double e, double f, Level level) {
        super(DDEntities.ICICLE_SHARD, d, e, f, level);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public void tick() {
        super.tick();
        age++;
        if (this.inGroundTime > 4) {
            discard();
        }
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return DDSounds.ICICLE_SHARD_LAND;
    }
}
