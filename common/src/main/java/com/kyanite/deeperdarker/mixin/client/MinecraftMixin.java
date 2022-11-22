package com.kyanite.deeperdarker.mixin.client;

import com.kyanite.deeperdarker.client.ui.StartScreen;
import com.kyanite.deeperdarker.config.DDClientConfig;
import com.kyanite.deeperdarker.miscellaneous.DDUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.main.GameConfig;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Shadow public abstract void setScreen(@Nullable Screen screen);

    @Inject(method = "<init>*", at = @At("TAIL"))
    private void init(GameConfig args, CallbackInfo info) {
        if(DDUtils.isConnected() && DDClientConfig.SHOW_START_SCREEN.get() == true) {
            this.setScreen(new StartScreen());
        }
    }
}
