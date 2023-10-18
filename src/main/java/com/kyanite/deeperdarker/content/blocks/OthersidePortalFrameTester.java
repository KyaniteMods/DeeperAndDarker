package com.kyanite.deeperdarker.content.blocks;

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
    public boolean isRequestedSize(int attemptWidth, int attemptHeight) {
        return (this.width >= attemptWidth) && (this.height >= attemptHeight);
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
        for (int i = -1; i < 5; i++) {
            world.setBlockAndUpdate(pos.above(i).relative(axis, -1), frameBlock);
            world.setBlockAndUpdate(pos.above(i).relative(axis, 8), frameBlock);
            if (i >= 0) {
                fillAirAroundPortal(world, pos.above(i).relative(axis, -1).relative(rotatedAxis, 1));
                fillAirAroundPortal(world, pos.above(i).relative(axis, 8).relative(rotatedAxis, 1));
                fillAirAroundPortal(world, pos.above(i).relative(axis, -1).relative(rotatedAxis, -1));
                fillAirAroundPortal(world, pos.above(i).relative(axis, 8).relative(rotatedAxis, -1));
            }
        }
        for (int i = -1; i < 9; i++) {
            world.setBlockAndUpdate(pos.above(-1).relative(axis, i), frameBlock);
            world.setBlockAndUpdate(pos.above(4).relative(axis, i), frameBlock);

            fillAirAroundPortal(world, pos.above(4).relative(axis, i).relative(rotatedAxis, 1));
            fillAirAroundPortal(world, pos.above(4).relative(axis, i).relative(rotatedAxis, -1));
        }
        for (int i = 0; i < 8; i++) {
            placeLandingPad(world, pos.below().relative(axis, i).relative(rotatedAxis, 1), frameBlock);
            placeLandingPad(world, pos.below().relative(axis, i).relative(rotatedAxis, -1), frameBlock);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                fillAirAroundPortal(world, pos.relative(axis, i).above(j).relative(rotatedAxis, 1));
                fillAirAroundPortal(world, pos.relative(axis, i).above(j).relative(rotatedAxis, -1));
            }
        }
        //inits this instance based off of the newly created portal;
        this.lowerCorner = pos;
        this.width = 8;
        this.height = 4;
        this.axis = axis;
        this.world = world;
        this.foundPortalBlocks = 32;

        lightPortal(frameBlock.getBlock());
    }
}
