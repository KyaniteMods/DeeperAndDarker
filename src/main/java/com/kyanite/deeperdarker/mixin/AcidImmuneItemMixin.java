package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemEntity.class)
public abstract class AcidImmuneItemMixin extends Entity {
    protected AcidImmuneItemMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean deeperdarker$acidImmune() {
        return super.deeperdarker$acidImmune() || ((ItemEntity) (Object) this).getItem().is(DDTags.Items.ACID_RESISTANT);
    }
}
