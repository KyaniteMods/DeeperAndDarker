package com.kyanite.deeperdarker.mixin;

import com.google.common.collect.ImmutableMap;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.ShatteredHeadModel;
import com.kyanite.deeperdarker.content.blocks.ShatteredHeadBlock;
import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SkullBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
@Mixin(SkullBlockRenderer.class)
public class ShatteredHeadRenderMixin {
    @Unique
    private final ShatteredHeadModel shatteredHeadModel = new ShatteredHeadModel(Minecraft.getInstance().getEntityModels().bakeLayer(DDModelLayers.SHATTERED_HEAD));
    @Unique
    private static final ResourceLocation shatteredTexture = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/shattered.png");

    @Inject(method = "method_3580", at = @At("TAIL"))
    private static void addModel(HashMap<SkullBlock.Type, ResourceLocation> hashMap, CallbackInfo ci) {
        hashMap.put(ShatteredHeadBlock.SHATTERED, new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/shattered.png"));
    }

    @Inject(method = "createSkullRenderers", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;", shift = At.Shift.BEFORE))
    private static void addLayer(EntityModelSet entityModelSet, CallbackInfoReturnable<Map<SkullBlock.Type, SkullModelBase>> cir, @Local(ordinal = 0) ImmutableMap.Builder builder) {
        builder.put(ShatteredHeadBlock.SHATTERED, new ShatteredHeadModel(Minecraft.getInstance().getEntityModels().bakeLayer(DDModelLayers.SHATTERED_HEAD)));
    }
}
