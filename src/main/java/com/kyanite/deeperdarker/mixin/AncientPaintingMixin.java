package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Painting.class)
public abstract class AncientPaintingMixin {
    @WrapOperation(method = "dropItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/decoration/Painting;spawnAtLocation(Lnet/minecraft/world/level/ItemLike;)Lnet/minecraft/world/entity/item/ItemEntity;"))
    private ItemEntity deeperdarker$dropIfAncientPainting(Painting instance, ItemLike itemLike, Operation<ItemEntity> original) {
        ItemEntity itemEntity = original.call(instance, itemLike);
        if (instance.getVariant().is(DDTags.Paintings.ANCIENT)) {
            RegistryOps<Tag> registryOps = ((Painting) (Object) this).level().registryAccess().createSerializationContext(NbtOps.INSTANCE);
            CustomData data = itemEntity.getItem().getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY).update(registryOps, Painting.VARIANT_MAP_CODEC, instance.getVariant()).getOrThrow().update(compoundTag -> compoundTag.putString("id", "minecraft:painting"));
            itemEntity.getItem().set(DataComponents.ENTITY_DATA, data);
        }
        return itemEntity;
    }

    @ModifyReturnValue(method = "getPickResult", at = @At("RETURN"))
    private ItemStack deeperdarker$pickAncientPainting(ItemStack original) {
        if (((Painting)(Object)this).getVariant().is(DDTags.Paintings.ANCIENT)) {
            RegistryOps<Tag> registryOps = ((Painting) (Object) this).level().registryAccess().createSerializationContext(NbtOps.INSTANCE);
            CustomData data = original.getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY).update(registryOps, Painting.VARIANT_MAP_CODEC, ((Painting) (Object) this).getVariant()).getOrThrow().update(compoundTag -> compoundTag.putString("id", "minecraft:painting"));
            original.set(DataComponents.ENTITY_DATA, data);
        }
        return original;
    }
}
