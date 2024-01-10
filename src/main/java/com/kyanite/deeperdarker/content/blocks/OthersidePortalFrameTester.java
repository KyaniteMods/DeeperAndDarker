package com.kyanite.deeperdarker.content.blocks;

import com.google.common.collect.Sets;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDConfig;
import net.kyrptonaught.customportalapi.portal.frame.PortalFrameTester;
import net.kyrptonaught.customportalapi.portal.frame.VanillaPortalAreaHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Predicate;

public class OthersidePortalFrameTester extends VanillaPortalAreaHelper {
    @Override
    public PortalFrameTester init(LevelAccessor world, BlockPos blockPos, Direction.Axis axis, Block... foundations) {
        VALID_FRAME = Sets.newHashSet(foundations);
        this.world = world;
        this.axis = axis;
        this.lowerCorner = this.getLowerCorner(blockPos, axis, Direction.Axis.Y);
        this.foundPortalBlocks = 0;
        if (lowerCorner == null) {
            lowerCorner = blockPos;
            width = height = 1;
        } else {
            this.width = this.getSize(axis, DDConfig.HANDLER.instance().portalMinWidth, DDConfig.HANDLER.instance().portalMaxWidth);
            if (this.width > 0) {
                this.height = this.getSize(Direction.Axis.Y, DDConfig.HANDLER.instance().portalMinHeight, DDConfig.HANDLER.instance().portalMaxHeight);
                if (checkForValidFrame(axis, Direction.Axis.Y, width, height)) {
                    countExistingPortalBlocks(axis, Direction.Axis.Y, width, height);
                } else {
                    lowerCorner = null;
                    width = height = 1;
                }
            }
        }
        return this;
    }

    @Override
    public boolean isRequestedSize(int attemptWidth, int attemptHeight) {
        return (this.width >= DDConfig.HANDLER.instance().portalMinWidth) && (this.height >= DDConfig.HANDLER.instance().portalMinHeight);
    }

    @Override
    public Optional<PortalFrameTester> getOrEmpty(LevelAccessor worldAccess, BlockPos blockPos, Predicate<PortalFrameTester> predicate, Direction.Axis axis, Block... foundations) {
        Optional<PortalFrameTester> optional = Optional.of(new OthersidePortalFrameTester().init(worldAccess, blockPos, axis, foundations)).filter(predicate);
        if (optional.isPresent()) {
            return optional;
        } else {
            Direction.Axis axis2 = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
            return Optional.of(new OthersidePortalFrameTester().init(worldAccess, blockPos, axis2, foundations)).filter(predicate);
        }
    }

    @Override
    public void createPortal(Level world, BlockPos pos, BlockState frameBlock, Direction.Axis axis) {
        DeeperDarker.LOGGER.info(pos.toShortString());
        Direction.Axis rotatedAxis = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
        for (int i = -1; i < DDConfig.HANDLER.instance().generatedPortalHeight + 1; i++) {
            world.setBlockAndUpdate(pos.above(i).relative(axis, -1), frameBlock);
            world.setBlockAndUpdate(pos.above(i).relative(axis, DDConfig.HANDLER.instance().generatedPortalWidth), frameBlock);
            if (i >= 0) {
                for (int j = 0; j < DDConfig.HANDLER.instance().generatedPortalWidth; j++) {
                    fillAirAroundPortal(world, pos.above(i).relative(axis, -1).relative(rotatedAxis, -1));
                    fillAirAroundPortal(world, pos.above(i).relative(axis, -1).relative(rotatedAxis, 1));
                }
            }
        }
        for (int i = -1; i < DDConfig.HANDLER.instance().generatedPortalWidth + 1; i++) {
            world.setBlockAndUpdate(pos.above(-1).relative(axis, i), frameBlock);
            world.setBlockAndUpdate(pos.above(DDConfig.HANDLER.instance().generatedPortalHeight).relative(axis, i), frameBlock);
        }
        for (int i = 0; i < DDConfig.HANDLER.instance().generatedPortalWidth; i++) {
            placeLandingPad(world, pos.above(-1).relative(axis, i).relative(rotatedAxis, -1), frameBlock);
            placeLandingPad(world, pos.above(-1).relative(axis, i).relative(rotatedAxis, 1), frameBlock);
        }
        this.lowerCorner = pos;
        this.width = DDConfig.HANDLER.instance().generatedPortalWidth;
        this.height = DDConfig.HANDLER.instance().generatedPortalHeight;
        this.axis = axis;
        this.world = world;
        this.foundPortalBlocks = this.width * this.height;

        lightPortal(frameBlock.getBlock());
    }

    @Override
    public boolean isValidFrame() {
        return this.lowerCorner != null && this.width >= DDConfig.HANDLER.instance().portalMinWidth && this.width <= DDConfig.HANDLER.instance().portalMaxWidth && this.height >= DDConfig.HANDLER.instance().portalMinHeight && this.height <= DDConfig.HANDLER.instance().portalMaxHeight;
    }

    @Override
    protected BlockPos getLowerCorner(BlockPos blockPos, Direction.Axis axis1, Direction.Axis axis2) {
        if (!validStateInsidePortal(world.getBlockState(blockPos), VALID_FRAME))
            return null;
        return getLimitForAxis(getLimitForAxis(blockPos, axis1), axis2);
    }

    @Override
    protected BlockPos getLimitForAxis(BlockPos blockPos, Direction.Axis axis) {
        if (blockPos == null || axis == null) return null;
        int offset = 1;
        while (validStateInsidePortal(world.getBlockState(blockPos.relative(axis, -offset)), VALID_FRAME)) {
            offset++;
            if (offset > 20) return null;
            if ((axis.equals(Direction.Axis.Y) && blockPos.getY() - offset < world.getMinBuildHeight()) ||
                    (!axis.equals(Direction.Axis.Y) && !world.getWorldBorder().isWithinBounds(blockPos.relative(axis, -offset))))
                return null;
        }
        return blockPos.relative(axis, -(offset - 1));
    }

    @Override
    protected int getSize(Direction.Axis axis, int minSize, int maxSize) {
        for (int i = 1; i <= maxSize; i++) {
            BlockState blockState = this.world.getBlockState(this.lowerCorner.relative(axis, i));
            if (!validStateInsidePortal(blockState, VALID_FRAME)) {
                if (VALID_FRAME.contains(blockState.getBlock())) {
                    return i >= minSize ? i : 0;

                }
                break;
            }
        }
        return 0;
    }

    public static boolean validStateInsidePortal(BlockState blockState, HashSet<Block> foundations) {
        return PortalFrameTester.validStateInsidePortal(blockState, foundations) || blockState.is(Blocks.SCULK_VEIN);
    }
}
