package com.kyanite.deeperdarker.compat.create.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.equipment.armor.BacktankBlock;
import com.simibubi.create.content.equipment.armor.BacktankBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.math.AngleHelper;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

@Environment(EnvType.CLIENT)
public class WardenBacktankRenderer extends KineticBlockEntityRenderer<BacktankBlockEntity> {
    public WardenBacktankRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void renderSafe(BacktankBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer,
                              int light, int overlay) {
        super.renderSafe(be, partialTicks, ms, buffer, light, overlay);

        BlockState blockState = be.getBlockState();
        SuperByteBuffer cogs = CachedBuffers.partial(DDCreatePartialModels.COGS_MODEL, blockState);
        cogs.center()
                .rotateYDegrees(180 + AngleHelper.horizontalAngle(blockState.getValue(BacktankBlock.HORIZONTAL_FACING)))
                .uncenter()
                .translate(0, 6.5f / 16, 11f / 16)
                .rotate(AngleHelper.rad(be.getSpeed() / 4f * AnimationTickHolder.getRenderTime(be.getLevel()) % 360),
                        Direction.EAST)
                .translate(0, -6.5f / 16, -11f / 16);
        cogs.light(light)
                .renderInto(ms, buffer.getBuffer(RenderType.solid()));
    }

    @Override
    protected SuperByteBuffer getRotatedModel(BacktankBlockEntity be, BlockState state) {
        return CachedBuffers.partial(DDCreatePartialModels.SHAFT_MODEL, state);
    }
}
