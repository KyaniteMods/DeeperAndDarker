package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.entities.DDSignBlockEntity;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Map;

@SuppressWarnings("NullableProblems")
public class DDSignRenderer implements BlockEntityRenderer<DDSignBlockEntity> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(new ResourceLocation("sign/echo"), "main");
    private final Map<WoodType, SignRenderer.SignModel> signModels;
    private final Font font;

    public DDSignRenderer(BlockEntityRendererProvider.Context pContext) {
        this.signModels = Map.of(DDBlocks.ECHO, new SignRenderer.SignModel(pContext.bakeLayer(MODEL)));
        this.font = pContext.getFont();
    }

    @Override
    public void render(DDSignBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        BlockState state = pBlockEntity.getBlockState();
        pPoseStack.pushPose();

        WoodType woodtype = DDBlocks.ECHO;
        SignRenderer.SignModel signModel = this.signModels.get(woodtype);

        if (state.getBlock() instanceof StandingSignBlock) {
            pPoseStack.translate(0.5D, 0.5D, 0.5D);
            float f1 = -((float)(state.getValue(StandingSignBlock.ROTATION) * 360) / 16.0F);
            pPoseStack.mulPose(Vector3f.YP.rotationDegrees(f1));
            signModel.stick.visible = true;
        } else {
            pPoseStack.translate(0.5D, 0.5D, 0.5D);
            float f4 = -state.getValue(WallSignBlock.FACING).toYRot();
            pPoseStack.mulPose(Vector3f.YP.rotationDegrees(f4));
            pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
            signModel.stick.visible = false;
        }

        pPoseStack.pushPose();
        pPoseStack.scale(0.6666667F, -0.6666667F, -0.6666667F);
        Material material = Sheets.getSignMaterial(woodtype);
        VertexConsumer vertexconsumer = material.buffer(pBufferSource, signModel::renderType);
        signModel.root.render(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay);
        pPoseStack.popPose();

        pPoseStack.translate(0.0D, 0.33333334D, 0.046666667D);
        pPoseStack.scale(0.010416667F, -0.010416667F, 0.010416667F);
        int i = getDarkColor(pBlockEntity);
        FormattedCharSequence[] sequences = pBlockEntity.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), (p_173653_) -> {
            List<FormattedCharSequence> list = this.font.split(p_173653_, 90);
            return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
        });

        int k;
        boolean flag;
        int l;
        if (pBlockEntity.hasGlowingText()) {
            k = pBlockEntity.getColor().getTextColor();
            flag = isOutlineVisible(pBlockEntity, k);
            l = 15728880;
        } else {
            k = i;
            flag = false;
            l = pPackedLight;
        }

        for(int i1 = 0; i1 < 4; ++i1) {
            FormattedCharSequence formattedcharsequence = sequences[i1];
            float f3 = (float)(-this.font.width(formattedcharsequence) / 2);
            if (flag) {
                this.font.drawInBatch8xOutline(formattedcharsequence, f3, (float)(i1 * 10 - 20), k, i, pPoseStack.last().pose(), pBufferSource, l);
            } else {
                this.font.drawInBatch(formattedcharsequence, f3, (float)(i1 * 10 - 20), k, false, pPoseStack.last().pose(), pBufferSource, false, 0, l);
            }
        }

        pPoseStack.popPose();
    }

    private static boolean isOutlineVisible(SignBlockEntity pBlockEntity, int pTextColor) {
        if (pTextColor == DyeColor.BLACK.getTextColor()) {
            return true;
        } else {
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localplayer = minecraft.player;
            if (localplayer != null && minecraft.options.getCameraType().isFirstPerson() && localplayer.isScoping()) {
                return true;
            } else {
                Entity entity = minecraft.getCameraEntity();
                return entity != null && entity.distanceToSqr(Vec3.atCenterOf(pBlockEntity.getBlockPos())) < (double) Mth.square(16);
            }
        }
    }

    private static int getDarkColor(SignBlockEntity pBlockEntity) {
        int i = pBlockEntity.getColor().getTextColor();
        int j = (int)((double) NativeImage.getR(i) * 0.4D);
        int k = (int)((double)NativeImage.getG(i) * 0.4D);
        int l = (int)((double)NativeImage.getB(i) * 0.4D);
        return i == DyeColor.BLACK.getTextColor() && pBlockEntity.hasGlowingText() ? -988212 : NativeImage.combine(0, l, k, j);
    }
}
