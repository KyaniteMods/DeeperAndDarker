package com.kyanite.deeperdarker.client;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.LevelLoadingScreen;
import net.minecraft.client.multiplayer.LevelLoadTracker;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class OthersideReceivingLevelScreen extends LevelLoadingScreen {
    private TextureAtlasSprite cachedPortalSprite;

    public OthersideReceivingLevelScreen(LevelLoadTracker loadTracker, Reason reason) {
        super(loadTracker, reason);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        graphics.blitSprite(RenderPipelines.GUI_OPAQUE_TEXTURED_BACKGROUND, portalSprite(), 0, 0, graphics.guiWidth(), graphics.guiHeight());
    }

    private TextureAtlasSprite portalSprite() {
        if(cachedPortalSprite == null) cachedPortalSprite = this.minecraft.getModelManager().getBlockStateModelSet().getParticleMaterial(DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState()).sprite();
        return cachedPortalSprite;
    }
}
