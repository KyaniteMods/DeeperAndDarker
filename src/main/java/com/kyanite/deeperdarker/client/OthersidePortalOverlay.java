package com.kyanite.deeperdarker.client;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDDataAttachments;
import com.kyanite.deeperdarker.content.misc.PortalData;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Mth;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;

public class OthersidePortalOverlay implements LayeredDraw.Layer {
    @Override
    public void render(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        if(player == null) return;

        PortalData data = player.getData(DDDataAttachments.PORTAL_DATA);
        float alpha = Mth.lerp(deltaTracker.getGameTimeDeltaPartialTick(false), data.oPortalIntensity, data.portalIntensity);
        if(alpha <= 0) return;

        if(alpha < 1) {
            alpha *= alpha;
            alpha *= alpha;
            alpha = alpha * 0.8f + 0.2f;
        }

        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        guiGraphics.setColor(1f, 1f, 1f, alpha);

        TextureAtlasSprite atlas = minecraft.getBlockRenderer().getBlockModelShaper().getBlockModel(DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState()).getParticleIcon(ModelData.EMPTY);
        guiGraphics.blit(0, 0, -90, guiGraphics.guiWidth(), guiGraphics.guiHeight(), atlas);

        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        guiGraphics.setColor(1f, 1f, 1f, 1f);
    }
}
