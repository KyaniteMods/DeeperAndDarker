package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.gen.DeeperDarkerBiomes;
import net.minecraft.client.render.entity.PhantomEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomEntityRenderer.class)
public class PhantomTextureInOthersideMixin {
    @Inject(method = "getTexture(Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Identifier;", at = @At("HEAD"), cancellable = true)
    private void getTexture(Entity entity, CallbackInfoReturnable<Identifier> cir) {
        if (entity.getWorld().getBiome(entity.getBlockPos()).getKey().isPresent()) {
            if (entity.getWorld().getBiome(entity.getBlockPos()).getKey().get() == DeeperDarkerBiomes.DEEPLANDS) {
                cir.setReturnValue(new Identifier(DeeperDarker.MOD_ID, "textures/entity/sculk_phantom.png"));
            }
        }
    }
}
