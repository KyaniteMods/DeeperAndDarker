package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.SoulItem;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ItemEntityRenderer.class)
public class SoulItemEntityRendererMixin {
    @ModifyArg(method = "render(Lnet/minecraft/world/entity/item/ItemEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ItemRenderer;render(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/resources/model/BakedModel;)V"), index = 5)
    private int deeperdarker$changeSoulRenderingLight(int i, @Local(argsOnly = true) ItemEntity entity) {
        if (entity.getItem().getItem() instanceof SoulItem) {
            return LightTexture.FULL_BRIGHT;
        }
        return i;
    }
}
