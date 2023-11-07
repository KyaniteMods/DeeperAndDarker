package com.kyanite.deeperdarker.content.blocks;

import com.google.common.collect.Sets;
import com.kyanite.deeperdarker.util.DDConfig;
import net.kyrptonaught.customportalapi.portal.frame.PortalFrameTester;
import net.kyrptonaught.customportalapi.portal.frame.VanillaPortalAreaHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

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
        Direction.Axis rotatedAxis = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
        for (int i = -1; i < DDConfig.HANDLER.instance().portalMinHeight + 1; i++) {
            world.setBlockAndUpdate(pos.above(i).relative(axis, -1), frameBlock);
            world.setBlockAndUpdate(pos.above(i).relative(axis, DDConfig.HANDLER.instance().portalMinWidth), frameBlock);
            if (i >= 0) {
                fillAirAroundPortal(world, pos.above(i).relative(axis, -1).relative(rotatedAxis, 1));
                fillAirAroundPortal(world, pos.above(i).relative(axis, DDConfig.HANDLER.instance().portalMinWidth).relative(rotatedAxis, 1));
                fillAirAroundPortal(world, pos.above(i).relative(axis, -1).relative(rotatedAxis, -1));
                fillAirAroundPortal(world, pos.above(i).relative(axis, DDConfig.HANDLER.instance().portalMinWidth).relative(rotatedAxis, -1));
            }
        }
        for (int i = -1; i < DDConfig.HANDLER.instance().portalMinWidth + 1; i++) {
            world.setBlockAndUpdate(pos.above(-1).relative(axis, i), frameBlock);
            world.setBlockAndUpdate(pos.above(DDConfig.HANDLER.instance().portalMinHeight).relative(axis, i), frameBlock);

            fillAirAroundPortal(world, pos.above(DDConfig.HANDLER.instance().portalMinHeight).relative(axis, i).relative(rotatedAxis, 1));
            fillAirAroundPortal(world, pos.above(DDConfig.HANDLER.instance().portalMinHeight).relative(axis, i).relative(rotatedAxis, -1));
        }
        for (int i = 0; i < DDConfig.HANDLER.instance().portalMinWidth; i++) {
            placeLandingPad(world, pos.below().relative(axis, i).relative(rotatedAxis, 1), frameBlock);
            placeLandingPad(world, pos.below().relative(axis, i).relative(rotatedAxis, -1), frameBlock);
        }

        for (int i = 0; i < DDConfig.HANDLER.instance().portalMinWidth; i++) {
            for (int j = 0; j < DDConfig.HANDLER.instance().portalMinHeight; j++) {
                fillAirAroundPortal(world, pos.relative(axis, i).above(j).relative(rotatedAxis, 1));
                fillAirAroundPortal(world, pos.relative(axis, i).above(j).relative(rotatedAxis, -1));
            }
        }
        //inits this instance based off of the newly created portal;
        this.lowerCorner = pos;
        this.width = DDConfig.HANDLER.instance().portalMinWidth;
        this.height = DDConfig.HANDLER.instance().portalMinHeight;
        this.axis = axis;
        this.world = world;
        this.foundPortalBlocks = this.width * this.height;

        lightPortal(frameBlock.getBlock());
    }

    @Override
    public boolean isValidFrame() {
        return this.lowerCorner != null && this.width >= DDConfig.HANDLER.instance().portalMinWidth && this.width <= DDConfig.HANDLER.instance().portalMaxWidth && this.height >= DDConfig.HANDLER.instance().portalMinHeight && this.height <= DDConfig.HANDLER.instance().portalMaxHeight;
    }
}
