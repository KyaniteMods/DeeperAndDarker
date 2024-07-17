package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Phantom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("unused")
@Mixin(PhantomRenderer.class)
public class PhantomRendererMixin {
    @Inject(method = "getTextureLocation", at = @At("HEAD"), cancellable = true)
    public void deeperdarker_getTextureLocation(Phantom entity, CallbackInfoReturnable<ResourceLocation> cir) {
        if(entity.level().getBiome(entity.blockPosition()).is(OthersideBiomes.DEEPLANDS.location())) {
            cir.setReturnValue(DeeperDarker.rl("textures/entity/sculk_phantom.png"));
        }
    }
}
