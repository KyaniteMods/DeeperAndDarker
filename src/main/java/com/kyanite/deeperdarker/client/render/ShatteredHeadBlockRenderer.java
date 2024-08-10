package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.ShatteredHeadModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;

public class ShatteredHeadBlockRenderer extends SkullBlockRenderer {
    private final ShatteredHeadModel model;

    public ShatteredHeadBlockRenderer(BlockEntityRendererProvider.Context ctx) {
        super(ctx);
        this.model = new ShatteredHeadModel(ctx.bakeLayer(DDModelLayers.SHATTERED_HEAD));
    }

    @Override
    public void render(SkullBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        float delta = blockEntity.getAnimation(f);
        BlockState blockState = blockEntity.getBlockState();
        boolean wall = blockState.getBlock() instanceof WallSkullBlock;
        Direction direction = wall ? blockState.getValue(WallSkullBlock.FACING) : null;
        int rotation = wall ? RotationSegment.convertToSegment(direction.getOpposite()) : blockState.getValue(SkullBlock.ROTATION);
        float yaw = RotationSegment.convertToDegrees(rotation);
        renderSkull(direction, yaw, delta, poseStack, multiBufferSource, light, this.model, RenderType.entityTranslucent(DeeperDarker.rl("textures/entity/shattered.png")));
    }
}
