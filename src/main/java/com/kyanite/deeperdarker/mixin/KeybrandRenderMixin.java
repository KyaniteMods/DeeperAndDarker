package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarkerClient;
import com.kyanite.deeperdarker.content.DDItems;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemRenderer.class)
public abstract class KeybrandRenderMixin {
    @WrapOperation(method = "getModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/ItemModelShaper;getItemModel(Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/client/resources/model/BakedModel;"))
    private BakedModel deeperdarker$replaceKeybrandModel(ItemModelShaper instance, ItemStack itemStack, Operation<BakedModel> original) {
        return itemStack.is(DDItems.KEYBRAND) ? instance.getModelManager().getModel(DeeperDarkerClient.KEYBRAND_IN_HAND_MODEL) : original.call(instance, itemStack);
    }

    @WrapOperation(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z", ordinal = 0))
    private boolean deeperdarker$isKeybrand(ItemStack instance, Item item, Operation<Boolean> original) {
        return instance.is(DDItems.KEYBRAND) || original.call(instance, item);
    }

    @WrapOperation(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/ModelManager;getModel(Lnet/minecraft/client/resources/model/ModelResourceLocation;)Lnet/minecraft/client/resources/model/BakedModel;", ordinal = 0))
    private BakedModel deeperdarker$getKeybrandModel(ModelManager instance, ModelResourceLocation modelResourceLocation, Operation<BakedModel> original, @Local(argsOnly = true) ItemStack stack) {
        return original.call(instance, stack.is(DDItems.KEYBRAND) ? DeeperDarkerClient.KEYBRAND_MODEL : modelResourceLocation);
    }

    @Definition(id = "GROUND", field = "Lnet/minecraft/world/item/ItemDisplayContext;GROUND:Lnet/minecraft/world/item/ItemDisplayContext;")
    @Expression("? == GROUND")
    @WrapOperation(method = "render", at = @At(value = "MIXINEXTRAS:EXPRESSION", ordinal = 0))
    private boolean deeperdarker$renderLargeKeybrandOnGround(Object left, Object right, Operation<Boolean> original, @Local(argsOnly = true) ItemStack stack) {
        return original.call(left, right) && !stack.is(DDItems.KEYBRAND);
    }
}
