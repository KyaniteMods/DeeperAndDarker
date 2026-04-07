package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarkerClient;
import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenEffectRenderer.class)
public abstract class ScreenEffectMixin {
    @Inject(method = "renderScreenEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isEyeInFluid(Lnet/minecraft/tags/TagKey;)Z"))
    private static void deeperdarker$applyAcidScreenEffect(Minecraft minecraft, PoseStack poseStack, CallbackInfo ci, @Local Player player) {
        if (player.isEyeInFluid(DDTags.Fluids.ACID)) {
            deeperdarker$renderAcid(minecraft, poseStack);
        }
    }

    @Unique
    private static void deeperdarker$renderAcid(Minecraft minecraft, PoseStack poseStack) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, DeeperDarkerClient.ACID_SCREEN_EFFECT_TEXTURE);
        BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
        BlockPos blockPos = BlockPos.containing(minecraft.player.getX(), minecraft.player.getEyeY(), minecraft.player.getZ());
        float f = LightTexture.getBrightness(minecraft.player.level().dimensionType(), minecraft.player.level().getMaxLocalRawBrightness(blockPos));
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor(f, f, f, 1.0f);
        float g = 4.0f;
        float h = -1.0f;
        float i = 1.0f;
        float j = -1.0f;
        float k = 1.0f;
        float l = -0.5f;
        float m = -minecraft.player.getYRot() / 64.0f;
        float n = minecraft.player.getXRot() / 64.0f;
        Matrix4f matrix4f = poseStack.last().pose();
        bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilder.vertex(matrix4f, -1.0f, -1.0f, -0.5f).uv(4.0f + m, 4.0f + n).endVertex();
        bufferBuilder.vertex(matrix4f, 1.0f, -1.0f, -0.5f).uv(0.0f + m, 4.0f + n).endVertex();
        bufferBuilder.vertex(matrix4f, 1.0f, 1.0f, -0.5f).uv(0.0f + m, 0.0f + n).endVertex();
        bufferBuilder.vertex(matrix4f, -1.0f, 1.0f, -0.5f).uv(4.0f + m, 0.0f + n).endVertex();
        BufferUploader.drawWithShader(bufferBuilder.end());
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.disableBlend();
    }
}
