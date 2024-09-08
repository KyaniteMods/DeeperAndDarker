package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.entities.blocks.DDHangingSignBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.HangingSignEditScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class ShowHangingSignScreenMixin {
    @Mixin(LocalPlayer.class)
    private interface ClientAccessor {
        @Accessor("minecraft")
        Minecraft minecraft();
    }

    @Inject(method = "openTextEdit", at = @At("HEAD"), cancellable = true)
    public void openTextEdit(SignBlockEntity sign, boolean front, CallbackInfo ci) {
        if (sign instanceof DDHangingSignBlockEntity hangingSignBlockEntity) {
            ((ClientAccessor)((LocalPlayer)(Object)this)).minecraft().setScreen(new HangingSignEditScreen(hangingSignBlockEntity, front, ((ClientAccessor)((LocalPlayer)(Object)this)).minecraft().isTextFilteringEnabled()));
            ci.cancel();
        }
    }
}
