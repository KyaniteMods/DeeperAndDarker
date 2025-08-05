package com.kyanite.deeperdarker.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

public class GloomslatePotExtension implements IClientItemExtensions {
    @Override
    public @NotNull BlockEntityWithoutLevelRenderer getCustomRenderer() {
        return new GloomslatePotWithoutLevelRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }
}
