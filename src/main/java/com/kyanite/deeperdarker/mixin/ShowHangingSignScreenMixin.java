package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.blocks.entity.DeeperDarkerHangingSignBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HangingSignEditScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ShowHangingSignScreenMixin {
    @Mixin(ClientPlayerEntity.class)
    private interface ClientAccessor {
        @Accessor("client")
        MinecraftClient client();
    }

    @Inject(method = "openEditSignScreen", at = @At("TAIL"))
    public void openEditSignScreen(SignBlockEntity sign, boolean front, CallbackInfo ci) {
        if (sign instanceof DeeperDarkerHangingSignBlockEntity deeperDarkerHangingSignBlockEntity) {
            ((ClientAccessor)((ClientPlayerEntity)(Object)this)).client().setScreen(new HangingSignEditScreen(deeperDarkerHangingSignBlockEntity, front, ((ClientAccessor)((ClientPlayerEntity)(Object)this)).client().shouldFilterText()));
        }
    }
}