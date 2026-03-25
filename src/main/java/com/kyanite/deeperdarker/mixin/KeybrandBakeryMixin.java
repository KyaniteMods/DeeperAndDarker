package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarkerClient;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ModelBakery.class)
public abstract class KeybrandBakeryMixin {
    @Mixin(ModelBakery.class)
    private interface ModelBakeryAccessor {
        @Invoker("loadTopLevel")
        void callLoadTopLevel(ModelResourceLocation location);
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/ModelBakery;loadTopLevel(Lnet/minecraft/client/resources/model/ModelResourceLocation;)V", ordinal = 3))
    private void deeperdarker$loadKeybrandModel(BlockColors blockColors, ProfilerFiller profilerFiller, Map map, Map map2, CallbackInfo ci) {
        ((ModelBakeryAccessor) this).callLoadTopLevel(DeeperDarkerClient.KEYBRAND_IN_HAND_MODEL);
    }
}
