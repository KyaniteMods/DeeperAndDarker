package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.world.biomes.DDBiomes;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.client.model.PhantomModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.client.renderer.entity.layers.PhantomEyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Phantom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomRenderer.class)
public class PhantomMixin {
    @Inject(method = "getTextureLocation(Lnet/minecraft/world/entity/monster/Phantom;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    public void getTextureLocation(Phantom pEntity, CallbackInfoReturnable<ResourceLocation> cir) {
        if(pEntity.level.getBiome(pEntity.blockPosition()).is(DDBiomes.OTHERSIDE_LOWLAND.getKey()))
                cir.setReturnValue(new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/sculk_phantom.png"));
    }
}
