package com.kyanite.deeperdarker.world.otherside;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.DeeperDarkerConfig;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.OthersidePortalBlock;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.Optional;

public class OthersideTeleporter {
    public static final int MIN_WIDTH = 2;
    public static final int MIN_HEIGHT = 2;
    public static final int MAX_WIDTH = 21;
    public static final int MAX_HEIGHT = 21;
    private static final int PORTAL_BASE = 2;
    private static final int PORTAL_WIDTH = DeeperDarkerConfig.CONFIG.othersidePortalWidth.get();
    private static final int PORTAL_HEIGHT = DeeperDarkerConfig.CONFIG.othersidePortalHeight.get();

    public static DimensionTransition getExitPortal(ServerLevel destLevel, Entity entity, BlockPos pos, BlockPos exitPos, WorldBorder destBorder) {
        Optional<BlockPos> existingPortalPos = findExistingPortal(destLevel, exitPos, destBorder);
        BlockUtil.FoundRectangle portal;
        DimensionTransition.PostDimensionTransition transition;

        if(existingPortalPos.isPresent()) {
            BlockPos blockPos = existingPortalPos.get();
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
            Optional<BlockUtil.FoundRectangle> newPortal = makePortal(destLevel, exitPos, direction);
            if(newPortal.isEmpty()) {
                DeeperDarker.LOGGER.error("Unable to create a Otherside portal: target out of world border");
                return null;
            }

            portal = newPortal.get();
            transition = DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET);
        }

        return transitionFromExit(entity, pos, portal, destLevel, transition);
    }

    private static Optional<BlockPos> findExistingPortal(ServerLevel level, BlockPos exitPos, WorldBorder worldBorder) {
        PoiManager poimanager = level.getPoiManager();
        poimanager.ensureLoadedAndValid(level, exitPos, 128);
        return poimanager.getInSquare(poi -> poi == OthersideDimension.OTHERSIDE_PORTAL.getDelegate(), exitPos, 128, PoiManager.Occupancy.ANY)
                .map(PoiRecord::getPos)
                .filter(worldBorder::isWithinBounds)
                .filter(pos -> level.getBlockState(pos).hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                .min(Comparator.<BlockPos>comparingDouble(pos -> pos.distSqr(exitPos)).thenComparingInt(Vec3i::getY));
    }

    private static DimensionTransition transitionFromExit(Entity entity, BlockPos pos, BlockUtil.FoundRectangle rectangle, ServerLevel level, DimensionTransition.PostDimensionTransition postTransition) {
        BlockState state = entity.level().getBlockState(pos);
        Direction.Axis axis;
        Vec3 vec3;
        if(state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
            axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
            BlockUtil.FoundRectangle portal = BlockUtil.getLargestRectangleAround(pos, axis, MAX_WIDTH, Direction.Axis.Y, MAX_HEIGHT, blockPos -> entity.level().getBlockState(blockPos) == state);
            vec3 = entity.getRelativePortalPosition(axis, portal);
        } else {
            axis = Direction.Axis.X;
            vec3 = new Vec3(0.5, 0.0, 0.0);
        }

        return createTransition(level, rectangle, axis, vec3, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), postTransition);
    }

    private static DimensionTransition createTransition(ServerLevel level, BlockUtil.FoundRectangle rectangle, Direction.Axis axis, Vec3 offset, Entity entity, Vec3 speed, float yRot, float xRot, DimensionTransition.PostDimensionTransition postTransition) {
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

    public static Optional<BlockUtil.FoundRectangle> makePortal(ServerLevel level, BlockPos origin, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        BlockPos finalPos = null;
        WorldBorder worldBorder = level.getWorldBorder();
        int levelHeight = level.getMaxBuildHeight() - PORTAL_HEIGHT - 1;

        for(BlockPos.MutableBlockPos pos : BlockPos.spiralAround(origin, 16, Direction.EAST, Direction.SOUTH)) {
            if(worldBorder.isWithinBounds(pos) && worldBorder.isWithinBounds(pos.move(direction))) {
                pos.move(direction.getOpposite());

                for(int i = levelHeight; i > level.getMinBuildHeight(); i--) {
                    pos.setY(i);
                    if(!level.isEmptyBlock(pos)) continue;

                    int ceilingY = i;
                    while(i > level.getMinBuildHeight() && !Heightmap.Types.MOTION_BLOCKING.isOpaque().test(level.getBlockState(pos.move(Direction.DOWN)))) i--;

                    if(ceilingY - i > PORTAL_HEIGHT) {
                        pos.setY(i);

                        if(checkRegionForPlacement(level, pos, direction)) {
                            finalPos = pos.immutable();
                            break;
                        }
                    }
                }
            }

            if(finalPos != null) break;
        }

        BlockPos.MutableBlockPos mutablePos = origin.mutable();

        if(finalPos == null) {
            if(!worldBorder.isWithinBounds(origin)) return Optional.empty();

            if(origin.getY() < 0) finalPos = origin.atY(64);
            else finalPos = origin.atY(Mth.clamp(origin.getY(), 16, levelHeight - 20));
            Direction clockWise = direction.getClockWise();

            for(int i = -PORTAL_BASE; i < PORTAL_BASE + 1; i++) {
                for(int j = 0; j < PORTAL_WIDTH; j++) {
                    for(int k = -1; k < PORTAL_HEIGHT; k++) {
                        mutablePos.setWithOffset(finalPos, j * direction.getStepX() + i * clockWise.getStepX(), k, j * direction.getStepZ() + i * clockWise.getStepZ());
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

    private static boolean checkRegionForPlacement(ServerLevel level, BlockPos portalPos, Direction direction) {
        for(int x = -1; x < PORTAL_WIDTH + 1; x++) {
            for(int y = -1; y < PORTAL_HEIGHT + 1; y++) {
                BlockPos pos = portalPos.offset(direction.getStepX() * x, y, direction.getStepZ() * x);
                if(y < 0 && level.isEmptyBlock(pos)) return false;
                if(y >= 0 && level.getBlockState(pos).blocksMotion()) return false;
            }
        }

        return true;
    }
}
