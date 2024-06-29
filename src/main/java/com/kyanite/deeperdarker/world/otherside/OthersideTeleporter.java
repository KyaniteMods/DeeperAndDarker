package com.kyanite.deeperdarker.world.otherside;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.OthersidePortalBlock;
import com.kyanite.deeperdarker.util.DeeperDarkerConfig;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class OthersideTeleporter {
    public static final int MIN_WIDTH = 2;
    public static final int MIN_HEIGHT = 2;
    public static final int MAX_WIDTH = 21;
    public static final int MAX_HEIGHT = 21;
    private static final int PORTAL_BASE = 2;
    private static final int PORTAL_WIDTH = DeeperDarkerConfig.othersidePortalWidth;
    private static final int PORTAL_HEIGHT = DeeperDarkerConfig.othersidePortalHeight;

    public static DimensionTransition getExitPortal(ServerLevel destLevel, Entity entity, BlockPos pos, BlockPos exitPos, boolean isOtherside, WorldBorder worldBorder) {
        Optional<BlockPos> closestPos = destLevel.getPortalForcer().findClosestPortalPosition(exitPos, isOtherside, worldBorder);
        BlockUtil.FoundRectangle portal;
        DimensionTransition.PostDimensionTransition transition;
        if(closestPos.isPresent()) {
            BlockPos blockPos = closestPos.get();
            BlockState destState = destLevel.getBlockState(blockPos);
            portal = BlockUtil.getLargestRectangleAround(
                    blockPos,
                    destState.getValue(BlockStateProperties.HORIZONTAL_AXIS),
                    MAX_WIDTH,
                    Direction.Axis.Y,
                    MAX_HEIGHT,
                    pos1 -> destLevel.getBlockState(pos1) == destState
            );
            transition = DimensionTransition.PLAY_PORTAL_SOUND.then(entity1 -> entity1.placePortalTicket(blockPos));
        } else {
            Direction.Axis direction = entity.level().getBlockState(pos).getOptionalValue(OthersidePortalBlock.AXIS).orElse(Direction.Axis.X);
            Optional<BlockUtil.FoundRectangle> rectangle = makePortal(destLevel, exitPos, direction);
            if(rectangle.isEmpty()) {
                DeeperDarker.LOGGER.error("Unable to create a portal, likely target out of worldborder");
                return null;
            }

            portal = rectangle.get();
            transition = DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET);
        }

        return getDimensionTransitionFromExit(entity, pos, portal, destLevel, transition);
    }

    private static DimensionTransition getDimensionTransitionFromExit(Entity entity, BlockPos pos, BlockUtil.FoundRectangle rectangle, ServerLevel level, DimensionTransition.PostDimensionTransition postTransition) {
        BlockState state = entity.level().getBlockState(pos);
        Direction.Axis axis;
        Vec3 vec3;
        if(state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
            axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
            BlockUtil.FoundRectangle portal = BlockUtil.getLargestRectangleAround(pos, axis, MAX_WIDTH, Direction.Axis.Y, MAX_HEIGHT, p_351016_ -> entity.level().getBlockState(p_351016_) == state);
            vec3 = entity.getRelativePortalPosition(axis, portal);
        } else {
            axis = Direction.Axis.X;
            vec3 = new Vec3(0.5, 0.0, 0.0);
        }

        return createDimensionTransition(level, rectangle, axis, vec3, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), postTransition);
    }

    private static DimensionTransition createDimensionTransition(ServerLevel level, BlockUtil.FoundRectangle rectangle, Direction.Axis axis, Vec3 offset, Entity entity, Vec3 speed, float yRot, float xRot, DimensionTransition.PostDimensionTransition postTransition) {
        BlockPos cornerPos = rectangle.minCorner;
        BlockState cornerState = level.getBlockState(cornerPos);
        Direction.Axis axis1 = cornerState.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
        double d0 = rectangle.axis1Size;
        double d1 = rectangle.axis2Size;
        EntityDimensions dimensions = entity.getDimensions(entity.getPose());
        int i = axis == axis1 ? 0 : 90;
        Vec3 vec3 = axis == axis1 ? speed : new Vec3(speed.z, speed.y, -speed.x);
        double d2 = (double)dimensions.width() / 2.0 + (d0 - (double)dimensions.width()) * offset.x();
        double d3 = (d1 - (double)dimensions.height()) * offset.y();
        double d4 = 0.5 + offset.z();
        boolean flag = axis1 == Direction.Axis.X;
        Vec3 vec31 = new Vec3((double)cornerPos.getX() + (flag ? d2 : d4), (double)cornerPos.getY() + d3, (double)cornerPos.getZ() + (flag ? d4 : d2));
        Vec3 vec32 = PortalShape.findCollisionFreePosition(vec31, level, entity, dimensions);
        return new DimensionTransition(level, vec32, vec3, yRot + (float)i, xRot, postTransition);
    }

    public static Optional<BlockUtil.FoundRectangle> makePortal(ServerLevel level, BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1;
        double d1 = -1;
        BlockPos finalPos = null;
        BlockPos destPos = null;
        WorldBorder worldBorder = level.getWorldBorder();
        int levelHeight = level.getHeight() - 1;
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for(BlockPos.MutableBlockPos portalPos : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int min = Math.min(levelHeight, level.getHeight(Heightmap.Types.MOTION_BLOCKING, portalPos.getX(), portalPos.getZ()));
            if(worldBorder.isWithinBounds(portalPos) && worldBorder.isWithinBounds(portalPos.move(direction, 1))) {
                portalPos.move(direction.getOpposite(), 1);

                for(int i = min; i >= 0; i--) {
                    portalPos.setY(i);
                    if(level.isEmptyBlock(portalPos)) {
                        int y = i;
                        while (i > 0 && level.isEmptyBlock(portalPos.move(Direction.DOWN))) i--;

                        if(i + 4 <= levelHeight) {
                            int j = y - i;
                            if(j <= 0 || j >= 3) {
                                portalPos.setY(i);
                                if(checkRegionForPlacement(level, portalPos, mutablePos, direction, 0)) {
                                    double d2 = pos.distSqr(portalPos);
                                    if(checkRegionForPlacement(level, portalPos, mutablePos, direction, -1) && checkRegionForPlacement(level, portalPos, mutablePos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
                                        d0 = d2;
                                        finalPos = portalPos.immutable();
                                    }

                                    if(d0 == -1 && (d1 == -1 || d1 > d2)) {
                                        d1 = d2;
                                        destPos = portalPos.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if(d0 == -1 && d1 != -1) {
            finalPos = destPos;
            d0 = d1;
        }

        if(d0 == -1) {
            finalPos = new BlockPos(pos.getX(), Mth.clamp(pos.getY(), 16, level.getHeight() - 20), pos.getZ()).immutable();
            Direction direction1 = direction.getClockWise();
            if(!worldBorder.isWithinBounds(finalPos)) {
                return Optional.empty();
            }

            int yDiff = 0;
            BlockPos.MutableBlockPos blockPos = finalPos.mutable();
            while(!level.getBlockState(blockPos).isAir() && !level.isOutsideBuildHeight(blockPos)) {
                blockPos.move(0, 1, 0);
                yDiff++;
            }
            if(!level.isOutsideBuildHeight(blockPos)) finalPos = blockPos;
            else {
                blockPos.move(0, -yDiff, 0);
                while(!level.getBlockState(blockPos).isAir() && !level.isOutsideBuildHeight(blockPos)) {
                    blockPos.move(0, -1, 0);
                }
                if(!level.isOutsideBuildHeight(blockPos)) finalPos = blockPos;
            }

            blockPos = finalPos.mutable();
            while(level.getBlockState(blockPos.below()).isAir()) {
                blockPos.move(0, -1, 0);
            }
            finalPos = blockPos;

            for(int i = -PORTAL_BASE; i < PORTAL_BASE + 1; i++) {
                for(int j = 0; j < PORTAL_WIDTH; j++) {
                    for(int k = -1; k < PORTAL_HEIGHT; k++) {
                        mutablePos.setWithOffset(finalPos, j * direction.getStepX() + i * direction1.getStepX(), k, j * direction.getStepZ() + i * direction1.getStepZ());
                        if(k < 0 && (i == -PORTAL_BASE || i == PORTAL_BASE)) continue;
                        level.setBlockAndUpdate(mutablePos, k < 0 ? Blocks.REINFORCED_DEEPSLATE.defaultBlockState() : Blocks.AIR.defaultBlockState());
                    }
                }
            }
        }

        for(int i = -1; i < PORTAL_WIDTH + 1; i++) {
            for(int j = -1; j < PORTAL_HEIGHT + 1; j++) {
                if(i == -1 || i == PORTAL_WIDTH || j == -1 || j == PORTAL_HEIGHT) {
                    mutablePos.setWithOffset(finalPos, i * direction.getStepX(), j, i * direction.getStepZ());
                    level.setBlock(mutablePos, Blocks.REINFORCED_DEEPSLATE.defaultBlockState(), 3);
                }
            }
        }

        for(int i = 0; i < PORTAL_WIDTH; i++) {
            for(int j = 0; j < PORTAL_HEIGHT; j++) {
                mutablePos.setWithOffset(finalPos, i * direction.getStepX(), j, i * direction.getStepZ());
                level.setBlock(mutablePos, DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState().setValue(OthersidePortalBlock.AXIS, axis), 18);
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(finalPos.immutable(), 2, 3));
    }

    private static boolean checkRegionForPlacement(ServerLevel level, BlockPos originalPos, BlockPos.MutableBlockPos offsetPos, Direction directionIn, int offsetScale) {
        Direction direction = directionIn.getClockWise();

        for(int i = -1; i < 3; i++) {
            for(int j = -1; j < 4; j++) {
                offsetPos.setWithOffset(originalPos, directionIn.getStepX() * i + direction.getStepX() * offsetScale, j, directionIn.getStepZ() * i + direction.getStepZ() * offsetScale);
                if(j < 0 && !level.getBlockState(offsetPos).isAir()) return false;
                if(j >= 0 && !level.isEmptyBlock(offsetPos)) return false;
            }
        }

        return true;
    }
}
