package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("unused")
@Mixin(Painting.class)
public abstract class PaintingMixin extends HangingEntity {
    protected PaintingMixin(EntityType<? extends HangingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow
    public abstract Holder<PaintingVariant> getVariant();

    @Shadow
    public abstract void setVariant(Holder<PaintingVariant> variant);

    @Inject(method = "dropItem", at = @At("HEAD"), cancellable = true)
    public void dropItem(Entity entity, CallbackInfo cir) {
        if(getVariant().is(DDTags.Misc.ANCIENT_PAINTING) && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            this.playSound(SoundEvents.PAINTING_BREAK, 1, 1);
            if(entity instanceof Player player && player.getAbilities().instabuild) return;

            CompoundTag tag = new CompoundTag();
            Painting.VARIANT_CODEC.encodeStart(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), this.getVariant()).ifSuccess(tag1 -> tag.merge((CompoundTag) tag1));
            tag.putString("id", "minecraft:painting");

            ItemEntity itemEntity = this.spawnAtLocation(Items.PAINTING);
            itemEntity.getItem().set(DataComponents.ENTITY_DATA, CustomData.of(tag));
            cir.cancel();
        }
    }

    @Inject(method = "getPickResult", at = @At("RETURN"), cancellable = true)
    public void getPickResult(CallbackInfoReturnable<ItemStack> cir) {
        if(getVariant().is(DDTags.Misc.ANCIENT_PAINTING)) {
            CompoundTag tag = cir.getReturnValue().getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY).copyTag();
            Painting.VARIANT_CODEC.encodeStart(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), this.getVariant()).ifSuccess(tag1 -> tag.merge((CompoundTag) tag1));
            tag.putString("id", "minecraft:painting");

            ItemStack stack = new ItemStack(Items.PAINTING);
            stack.set(DataComponents.ENTITY_DATA, CustomData.of(tag));
            cir.setReturnValue(stack);
        }
    }
}
