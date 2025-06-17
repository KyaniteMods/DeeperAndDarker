package com.kyanite.deeperdarker.client.render;

import com.google.common.collect.ImmutableMap;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.blocks.entity.GloomslatePotBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Optional;

public class GloomslatePotRenderer implements BlockEntityRenderer<GloomslatePotBlockEntity> {
    public static final ModelLayerLocation POT_BASE = new ModelLayerLocation(DeeperDarker.rl("gloomslate_pot_base"), "main");
    public static final ModelLayerLocation POT_SIDES = new ModelLayerLocation(DeeperDarker.rl("gloomslate_pot_sides"), "main");
    public static final ResourceLocation GLOOMSLATE_POT = DeeperDarker.rl("textures/atlas/gloomslate_pot.png");
    public static final Material POT_BASE_MATERIAL = createMaterial("gloomslate_pot_base");
    public static final Material POT_SIDE_MATERIAL = createMaterial("gloomslate_pot_side");

    private static final Map<Item, String> PATTERNS = ImmutableMap.of(
            DDItems.BRITTLE_GLOOMSHERD.asItem(), "brittle_pottery_pattern",
            DDItems.DARK_HEART_GLOOMSHERD.asItem(), "dark_heart_pottery_pattern",
            DDItems.LISTENER_GLOOMSHERD.asItem(), "listener_pottery_pattern",
            DDItems.SNAPPER_GLOOMSHERD.asItem(), "snapper_pottery_pattern",
            DDItems.TEMPLE_GLOOMSHERD.asItem(), "temple_pottery_pattern",
            DDItems.TRANSMISSION_GLOOMSHERD.asItem(), "transmission_pottery_pattern",
            DDItems.WARD_GLOOMSHERD.asItem(), "ward_pottery_pattern",
            DDItems.WAYFINDER_GLOOMSHERD.asItem(), "wayfinder_pottery_pattern"
    );
    private final ModelPart neck;
    private final ModelPart frontSide;
    private final ModelPart backSide;
    private final ModelPart leftSide;
    private final ModelPart rightSide;
    private final ModelPart top;
    private final ModelPart bottom;

    public GloomslatePotRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart baseModel = context.bakeLayer(POT_BASE);
        this.neck = baseModel.getChild("neck");
        this.top = baseModel.getChild("top");
        this.bottom = baseModel.getChild("bottom");
        ModelPart sideModel = context.bakeLayer(POT_SIDES);
        this.frontSide = sideModel.getChild("front");
        this.backSide = sideModel.getChild("back");
        this.leftSide = sideModel.getChild("left");
        this.rightSide = sideModel.getChild("right");
    }

    @Override
    public void render(GloomslatePotBlockEntity blockEntity, float partialTick, PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();

        Direction direction = blockEntity.getDirection();
        poseStack.translate(0.5f, 0f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(180f - direction.toYRot()));
        poseStack.translate(-0.5f, 0f, -0.5f);

        DecoratedPotBlockEntity.WobbleStyle wobbleStyle = blockEntity.lastWobbleStyle;
        if(wobbleStyle != null && blockEntity.getLevel() != null) {
            float f = ((float)(blockEntity.getLevel().getGameTime() - blockEntity.wobbleStartedAtTick) + partialTick) / wobbleStyle.duration;
            if(f >= 0 && f <= 1) {
                if(wobbleStyle == DecoratedPotBlockEntity.WobbleStyle.POSITIVE) {
                    float f2 = f * (float) (Math.PI * 2);
                    float f3 = -1.5f * (Mth.cos(f2) + 0.5f) * Mth.sin(f2 / 2);
                    poseStack.rotateAround(Axis.XP.rotation(f3 * 0.015625f), 0.5f, 0f, 0.5f);
                    float f4 = Mth.sin(f2);
                    poseStack.rotateAround(Axis.ZP.rotation(f4 * 0.015625f), 0.5f, 0f, 0.5f);
                } else {
                    float f5 = Mth.sin(-f * 3 * (float) Math.PI) * 0.125f;
                    float f6 = 1 - f;
                    poseStack.rotateAround(Axis.YP.rotation(f5 * f6), 0.5f, 0f, 0.5f);
                }
            }
        }

        VertexConsumer buffer = POT_BASE_MATERIAL.buffer(bufferSource, RenderType::entitySolid);
        this.neck.render(poseStack, buffer, packedLight, packedOverlay);
        this.top.render(poseStack, buffer, packedLight, packedOverlay);
        this.bottom.render(poseStack, buffer, packedLight, packedOverlay);

        PotDecorations decorations = blockEntity.getDecorations();
        renderSide(this.frontSide, poseStack, bufferSource, packedLight, packedOverlay, decorations.front());
        renderSide(this.backSide, poseStack, bufferSource, packedLight, packedOverlay, decorations.back());
        renderSide(this.leftSide, poseStack, bufferSource, packedLight, packedOverlay, decorations.left());
        renderSide(this.rightSide, poseStack, bufferSource, packedLight, packedOverlay, decorations.right());

        poseStack.popPose();
    }

    private void renderSide(ModelPart modelPart, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, Optional<Item> item) {
        Material material = item.map(value -> createMaterial(PATTERNS.get(value))).orElse(POT_SIDE_MATERIAL);
        modelPart.render(poseStack, material.buffer(buffer, RenderType::entitySolid), packedLight, packedOverlay);
    }

    private static Material createMaterial(String path) {
        return new Material(GLOOMSLATE_POT, DeeperDarker.rl("entity/gloomslate_pot/" + path));
    }
}
