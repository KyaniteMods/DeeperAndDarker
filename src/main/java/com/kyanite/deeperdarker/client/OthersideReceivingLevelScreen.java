package com.kyanite.deeperdarker.client;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;

import java.util.function.BooleanSupplier;

public class OthersideReceivingLevelScreen extends ReceivingLevelScreen {
    private TextureAtlasSprite cachedPortalSprite;

    public OthersideReceivingLevelScreen(BooleanSupplier levelReceived, Reason reason) {
        super(levelReceived, reason);
    }

    @Override
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        guiGraphics.blit(0, 0, -90, guiGraphics.guiWidth(), guiGraphics.guiHeight(), portalSprite());
    }

    private TextureAtlasSprite portalSprite() {
        if(cachedPortalSprite == null) cachedPortalSprite = Minecraft.getInstance().getBlockRenderer().getBlockModelShaper().getBlockModel(DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState()).getParticleIcon(ModelData.EMPTY);
        return cachedPortalSprite;
    }
}
