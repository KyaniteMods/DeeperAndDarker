package com.kyanite.deeperdarker.client.render;

import com.google.common.collect.ImmutableMap;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.blocks.entity.GloomslatePotBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mojang.math.Transformation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SpriteMapper;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.DecoratedPotRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

import java.util.Map;
import java.util.Optional;

@SuppressWarnings("NullableProblems")
public class GloomslatePotRenderer implements BlockEntityRenderer<GloomslatePotBlockEntity, DecoratedPotRenderState> {
    public static final Identifier GLOOMSLATE_POT_ATLAS = DeeperDarker.rl("textures/atlas/gloomslate_pot.png");
    private static final SpriteMapper GLOOMSLATE_POT_MAPPER = new SpriteMapper(GLOOMSLATE_POT_ATLAS, "entity/gloomslate_pot");
    private static final SpriteId GLOOMSLATE_POT_BASE = createSprite("gloomslate_pot_base");
    private static final SpriteId GLOOMSLATE_POT_SIDE = createSprite("gloomslate_pot_side");
    private static final Map<Direction, Transformation> TRANSFORMATIONS = Util.makeEnumMap(Direction.class, GloomslatePotRenderer::createModelTransformation);
    private final SpriteGetter sprites;
    private static final Map<Item, String> PATTERNS = ImmutableMap.of(
            DDItems.GLOOMSHERD.asItem(), "gloomslate_pot_side",
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
        this.sprites = context.sprites();

        ModelPart baseModel = context.bakeLayer(ModModelLayers.GLOOMSLATE_POT_BASE);
        this.neck = baseModel.getChild("neck");
        this.top = baseModel.getChild("top");
        this.bottom = baseModel.getChild("bottom");
        ModelPart sideModel = context.bakeLayer(ModModelLayers.GLOOMSLATE_POT_SIDES);
        this.frontSide = sideModel.getChild("front");
        this.backSide = sideModel.getChild("back");
        this.leftSide = sideModel.getChild("left");
        this.rightSide = sideModel.getChild("right");
    }

    @Override
    public DecoratedPotRenderState createRenderState() {
        return new DecoratedPotRenderState();
    }

    @Override
    public void extractRenderState(GloomslatePotBlockEntity blockEntity, DecoratedPotRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.direction = blockEntity.getDirection();
        state.decorations = blockEntity.getDecorations();
        state.wobbleStyle = blockEntity.lastWobbleStyle;
        if (state.wobbleStyle != null && blockEntity.getLevel() != null) {
            state.wobbleProgress = ((float)(blockEntity.getLevel().getGameTime() - blockEntity.wobbleStartedAtTick) + partialTicks) / state.wobbleStyle.duration;
        } else {
            state.wobbleProgress = 0.0F;
        }
    }

    @Override
    public void submit(DecoratedPotRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.mulPose(modelTransformation(state.direction));
        if (state.wobbleProgress >= 0.0F && state.wobbleProgress <= 1.0F) {
            if (state.wobbleStyle == DecoratedPotBlockEntity.WobbleStyle.POSITIVE) {
                float amplitude = 0.015625F;
                float deltaTime = state.wobbleProgress * (float) (Math.PI * 2);
                float tiltX = -1.5F * (Mth.cos(deltaTime) + 0.5F) * Mth.sin(deltaTime / 2.0F);
                poseStack.rotateAround(Axis.XP.rotation(tiltX * amplitude), 0.5F, 0.0F, 0.5F);
                float tiltZ = Mth.sin(deltaTime);
                poseStack.rotateAround(Axis.ZP.rotation(tiltZ * amplitude), 0.5F, 0.0F, 0.5F);
            } else {
                float turnAngle = Mth.sin(-state.wobbleProgress * 3.0F * (float) Math.PI) * 0.125F;
                float linearDecayFactor = 1.0F - state.wobbleProgress;
                poseStack.rotateAround(Axis.YP.rotation(turnAngle * linearDecayFactor), 0.5F, 0.0F, 0.5F);
            }
        }

        this.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, state.decorations, 0);
        poseStack.popPose();
    }

    public static Transformation modelTransformation(Direction facing) {
        return TRANSFORMATIONS.get(facing);
    }

    private static Transformation createModelTransformation(Direction entityDirection) {
        return new Transformation(new Matrix4f().rotateAround(Axis.YP.rotationDegrees(180.0F - entityDirection.toYRot()), 0.5F, 0.5F, 0.5F));
    }

    public void submit(
            PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, int overlayCoords, PotDecorations decorations, int outlineColor
    ) {
        RenderType renderType = GLOOMSLATE_POT_BASE.renderType(RenderTypes::entitySolid);
        TextureAtlasSprite sprite = this.sprites.get(GLOOMSLATE_POT_BASE);
        submitNodeCollector.submitModelPart(this.neck, poseStack, renderType, lightCoords, overlayCoords, sprite, false, false, -1, null, outlineColor);
        submitNodeCollector.submitModelPart(this.top, poseStack, renderType, lightCoords, overlayCoords, sprite, false, false, -1, null, outlineColor);
        submitNodeCollector.submitModelPart(this.bottom, poseStack, renderType, lightCoords, overlayCoords, sprite, false, false, -1, null, outlineColor);
        SpriteId frontSprite = getSideSprite(decorations.front());
        submitNodeCollector.submitModelPart(
                this.frontSide,
                poseStack,
                frontSprite.renderType(RenderTypes::entitySolid),
                lightCoords,
                overlayCoords,
                this.sprites.get(frontSprite),
                false,
                false,
                -1,
                null,
                outlineColor
        );
        SpriteId backSprite = getSideSprite(decorations.back());
        submitNodeCollector.submitModelPart(
                this.backSide,
                poseStack,
                backSprite.renderType(RenderTypes::entitySolid),
                lightCoords,
                overlayCoords,
                this.sprites.get(backSprite),
                false,
                false,
                -1,
                null,
                outlineColor
        );
        SpriteId leftSprite = getSideSprite(decorations.left());
        submitNodeCollector.submitModelPart(
                this.leftSide,
                poseStack,
                leftSprite.renderType(RenderTypes::entitySolid),
                lightCoords,
                overlayCoords,
                this.sprites.get(leftSprite),
                false,
                false,
                -1,
                null,
                outlineColor
        );
        SpriteId rightSprite = getSideSprite(decorations.right());
        submitNodeCollector.submitModelPart(
                this.rightSide,
                poseStack,
                rightSprite.renderType(RenderTypes::entitySolid),
                lightCoords,
                overlayCoords,
                this.sprites.get(rightSprite),
                false,
                false,
                -1,
                null,
                outlineColor
        );
    }

    private static SpriteId createSprite(String path) {
        return GLOOMSLATE_POT_MAPPER.apply(DeeperDarker.rl(path));
    }

    private static SpriteId getSideSprite(Optional<Item> item) {
        if(item.isPresent()) {
            String pattern = PATTERNS.get(item.get());
            if(pattern != null) {
                return createSprite(pattern);
            }
        }

//        return item.map(value -> createSprite(PATTERNS.get(value))).orElse(GLOOMSLATE_POT_SIDE);
        return GLOOMSLATE_POT_SIDE;
    }
}
