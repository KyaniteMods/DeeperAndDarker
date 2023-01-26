package com.kyanite.deeperdarker.mixin.client;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.world.biomes.OthersideBiomes;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Phantom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(PhantomRenderer.class)
public class PhantomRendererMixin {
    @Inject(method = "getTextureLocation(Lnet/minecraft/world/entity/monster/Phantom;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    public void getTextureLocation(Phantom pEntity, CallbackInfoReturnable<ResourceLocation> cir) {
        if(pEntity.level.getBiome(pEntity.blockPosition()).is(Objects.requireNonNull(OthersideBiomes.OTHERSIDE_DEEPLANDS.location()))) {
            cir.setReturnValue(new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/sculk_phantom.png"));
        }
    }
}
