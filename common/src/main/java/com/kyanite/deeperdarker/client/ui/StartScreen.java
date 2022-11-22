package com.kyanite.deeperdarker.client.ui;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class StartScreen extends Screen {
    public StartScreen() {
        super(Component.literal("Start"));
    }

    @Override
    public void render(PoseStack poseStack, int i, int j, float f) {
        this.renderBackground(poseStack);
        poseStack.pushPose();
        poseStack.scale(1.6f, 1.6f, 1.6f);
        drawString(poseStack, this.font, "Welcome to Deeper and Darker", 30, 15, 16777215);
        poseStack.popPose();
        drawString(poseStack, this.font, "You are using v" + DeeperAndDarker.VERSION , 50, 45, 16777215);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/gui/kyanite.png"));
        RenderSystem.enableBlend();
        GuiComponent.blit(poseStack, 15, 20, 0.0F, 0.0F, 32, 32, 32, 32);
        RenderSystem.disableBlend();

        super.render(poseStack, i, j, f);
    }

    @Override
    public void renderBackground(PoseStack poseStack) {
        overlayBackground(0, 0, this.width, this.height, 64, 64, 64, 255, 255);
    }

    public void overlayBackground(int x1, int y1, int x2, int y2, int red, int green, int blue, int startAlpha, int endAlpha) {
        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder buffer = tessellator.getBuilder();
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GuiComponent.BACKGROUND_LOCATION);
        buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        buffer.vertex(x1, y2, 0.0D).uv(x1 / 32.0F, y2 / 32.0F).color(red, green, blue, endAlpha).endVertex();
        buffer.vertex(x2, y2, 0.0D).uv(x2 / 32.0F, y2 / 32.0F).color(red, green, blue, endAlpha).endVertex();
        buffer.vertex(x2, y1, 0.0D).uv(x2 / 32.0F, y1 / 32.0F).color(red, green, blue, startAlpha).endVertex();
        buffer.vertex(x1, y1, 0.0D).uv(x1 / 32.0F, y1 / 32.0F).color(red, green, blue, startAlpha).endVertex();
        tessellator.end();
    }
}
