package com.kyanite.deeperdarker.client;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDDataAttachments;
import com.kyanite.deeperdarker.content.data.PlayerData;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.neoforged.neoforge.client.gui.GuiLayer;

@SuppressWarnings("NullableProblems")
public class OthersidePortalOverlay implements GuiLayer {
    @Override
    public void render(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        if(player == null) return;

        PlayerData data = player.getData(DDDataAttachments.PLAYER_DATA);
        float alpha = Mth.lerp(deltaTracker.getGameTimeDeltaPartialTick(false), data.oPortalIntensity, data.portalIntensity);
        if(alpha <= 0) return;

        if(alpha < 1f) {
            alpha *= alpha;
            alpha *= alpha;
            alpha = alpha * 0.8f + 0.2f;
        }

        int color = ARGB.white(alpha);

        TextureAtlasSprite atlas = minecraft.getModelManager().getBlockStateModelSet().getParticleMaterial(DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState()).sprite();
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, atlas, 0, 0, guiGraphics.guiWidth(), guiGraphics.guiHeight(), color);
    }
}
