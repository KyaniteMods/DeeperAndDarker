package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDConfig;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Phantom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomRenderer.class)
public class PhantomRendererMixin {
    @Inject(method = "getTextureLocation", at = @At("HEAD"), cancellable = true)
    public void getTextureLocation(Phantom entity, CallbackInfoReturnable<ResourceLocation> cir) {
        if(entity.level().getBiome(entity.blockPosition()).is(OthersideBiomes.DEEPLANDS.location()) && DDConfig.HANDLER.instance().changePhantomTextures) {
            cir.setReturnValue(new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/sculk_phantom.png"));
        }
    }
}
