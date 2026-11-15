package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.SoulItem;
import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ItemEntityRenderer.class)
public class SoulItemEntityRendererMixin {
    @ModifyArg(method = "renderMultipleFromCount(Lnet/minecraft/client/renderer/entity/ItemRenderer;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/item/ItemStack;Lnet/minecraft/client/resources/model/BakedModel;ZLnet/minecraft/util/RandomSource;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ItemRenderer;render(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/resources/model/BakedModel;)V"), index = 5)
    private static int deeperdarker$changeSoulRenderingLight(int i, @Local(argsOnly = true) ItemStack stack) {
        if (stack.getItem() instanceof SoulItem || stack.is(DDTags.Items.FULLBRIGHT)) {
            return LightTexture.FULL_BRIGHT;
        }
        return i;
    }
}
