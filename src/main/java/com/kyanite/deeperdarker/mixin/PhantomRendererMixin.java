package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomRenderer.class)
public abstract class PhantomRendererMixin {
    @Inject(method = "getTextureLocation*", at = @At("HEAD"), cancellable = true)
    public void getTextureLocation(Phantom entity, CallbackInfoReturnable<ResourceLocation> cir) {
        Holder<Biome> biome = entity.level().getBiome(entity.blockPosition());
        if(biome.is(DDTags.Biomes.SCULK_PHANTOM_BIOMES) && DeeperDarker.CONFIG.client.changePhantomTextures()) {
            cir.setReturnValue(new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/sculk_phantom.png"));
        }
    }
}
