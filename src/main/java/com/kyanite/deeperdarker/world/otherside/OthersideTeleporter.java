package com.kyanite.deeperdarker.world.otherside;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.OthersidePortalBlock;
import com.kyanite.deeperdarker.util.DeeperDarkerConfig;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

public class OthersideTeleporter implements ITeleporter {
    private static final int PORTAL_BASE = 2;
    private static final int PORTAL_WIDTH = DeeperDarkerConfig.othersidePortalWidth;
    private static final int PORTAL_HEIGHT = DeeperDarkerConfig.othersidePortalHeight;
    private final ServerLevel level;

    public OthersideTeleporter(ServerLevel level) {
        this.level = level;
    }

    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        if(entity.level().dimension() != OthersideDimension.OTHERSIDE_LEVEL && destWorld.dimension() != OthersideDimension.OTHERSIDE_LEVEL) return null;

        WorldBorder border = destWorld.getWorldBorder();
        double minX = Math.max(-2.9999872E7d, border.getMinX() + 16);
        double minZ = Math.max(-2.9999872E7d, border.getMinZ() + 16);
        double maxX = Math.min(2.9999872E7d, border.getMaxX() - 16);
        double maxZ = Math.min(2.9999872E7d, border.getMaxZ() - 16);
        double coordinateRatio = DimensionType.getTeleportationScale(entity.level().dimensionType(), destWorld.dimensionType());
        BlockPos destPos = new BlockPos((int) Mth.clamp(entity.getX() * coordinateRatio, minX, maxX), (int) entity.getY(), (int) Mth.clamp(entity.getZ() * coordinateRatio, minZ, maxZ));

        return this.getOrMakePortal(entity, destPos).map((rectangle) -> {
            BlockState state = entity.level().getBlockState(entity.portalEntrancePos);
            Direction.Axis axis;
            Vec3 vector3d;
            if(state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
                axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
                vector3d = PortalShape.getRelativePosition(rectangle, axis, entity.position(), entity.getDimensions(entity.getPose()));
            } else {
                axis = Direction.Axis.X;
                vector3d = new Vec3(0.5, 0, 0);
            }

            return PortalShape.createPortalInfo(destWorld, rectangle, axis, vector3d, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
        }).orElse(null);
    }

    private Optional<BlockUtil.FoundRectangle> getOrMakePortal(Entity entity, BlockPos pos) {
        Optional<BlockUtil.FoundRectangle> existingPortal = this.getExistingPortal(pos);
        if(existingPortal.isPresent()) {
            return existingPortal;
        } else {
            Direction.Axis portalAxis = this.level.getBlockState(entity.portalEntrancePos).getOptionalValue(OthersidePortalBlock.AXIS).orElse(Direction.Axis.X);
            return this.makePortal(pos, portalAxis);
        }
    }

    public Optional<BlockUtil.FoundRectangle> getExistingPortal(BlockPos pos) {
        PoiManager manager = this.level.getPoiManager();
        manager.ensureLoadedAndValid(this.level, pos, 64);
        Optional<PoiRecord> optional = manager.getInSquare((poiType) -> poiType.is(OthersideDimension.OTHERSIDE_PORTAL.getKey()), pos, 64, PoiManager.Occupancy.ANY)
                .sorted(Comparator.<PoiRecord>comparingDouble((poi) -> poi.getPos().distSqr(pos)).thenComparingInt((poi) -> poi.getPos().getY()))
                .filter((poi) -> this.level.getBlockState(poi.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS)).findFirst();
        return optional.map((poi) -> {
            BlockPos blockpos = poi.getPos();
            this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
            BlockState blockstate = this.level.getBlockState(blockpos);
            return BlockUtil.getLargestRectangleAround(blockpos, blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (posIn) -> this.level.getBlockState(posIn) == blockstate);
        });
    }

    public Optional<BlockUtil.FoundRectangle> makePortal(BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1;
        double d1 = -1;
        BlockPos finalPos = null;
        BlockPos destPos = null;
        WorldBorder worldBorder = this.level.getWorldBorder();
        int levelHeight = this.level.getHeight() - 1;
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for(BlockPos.MutableBlockPos portalPos : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int min = Math.min(levelHeight, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, portalPos.getX(), portalPos.getZ()));
            if(worldBorder.isWithinBounds(portalPos) && worldBorder.isWithinBounds(portalPos.move(direction, 1))) {
                portalPos.move(direction.getOpposite(), 1);

                for(int i = min; i >= 0; i--) {
                    portalPos.setY(i);
                    if(this.level.isEmptyBlock(portalPos)) {
                        int y = i;
                        while (i > 0 && this.level.isEmptyBlock(portalPos.move(Direction.DOWN))) i--;

                        if(i + 4 <= levelHeight) {
                            int j = y - i;
                            if(j <= 0 || j >= 3) {
                                portalPos.setY(i);
                                if(this.checkRegionForPlacement(portalPos, mutablePos, direction, 0)) {
                                    double d2 = pos.distSqr(portalPos);
                                    if(this.checkRegionForPlacement(portalPos, mutablePos, direction, -1) && this.checkRegionForPlacement(portalPos, mutablePos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
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
            finalPos = new BlockPos(pos.getX(), Mth.clamp(pos.getY(), 16, this.level.getHeight() - 20), pos.getZ()).immutable();
            Direction direction1 = direction.getClockWise();
            if(!worldBorder.isWithinBounds(finalPos)) {
                return Optional.empty();
            }

            int yDiff = 0;
            BlockPos.MutableBlockPos blockPos = finalPos.mutable();
            while(!this.level.getBlockState(blockPos).isAir() && !this.level.isOutsideBuildHeight(blockPos)) {
                blockPos.move(0, 1, 0);
                yDiff++;
            }
            if(!this.level.isOutsideBuildHeight(blockPos)) finalPos = blockPos;
            else {
                blockPos.move(0, -yDiff, 0);
                while(!this.level.getBlockState(blockPos).isAir() && !this.level.isOutsideBuildHeight(blockPos)) {
                    blockPos.move(0, -1, 0);
                }
                if(!this.level.isOutsideBuildHeight(blockPos)) finalPos = blockPos;
            }

            blockPos = finalPos.mutable();
            while(this.level.getBlockState(blockPos.below()).isAir()) {
                blockPos.move(0, -1, 0);
            }
            finalPos = blockPos;

            for(int i = -PORTAL_BASE; i < PORTAL_BASE + 1; i++) {
                for(int j = 0; j < PORTAL_WIDTH; j++) {
                    for(int k = -1; k < PORTAL_HEIGHT; k++) {
                        mutablePos.setWithOffset(finalPos, j * direction.getStepX() + i * direction1.getStepX(), k, j * direction.getStepZ() + i * direction1.getStepZ());
                        if(k < 0 && (i == -PORTAL_BASE || i == PORTAL_BASE)) continue;
                        this.level.setBlockAndUpdate(mutablePos, k < 0 ? Blocks.REINFORCED_DEEPSLATE.defaultBlockState() : Blocks.AIR.defaultBlockState());
                    }
                }
            }
        }

        for(int i = -1; i < PORTAL_WIDTH + 1; i++) {
            for(int j = -1; j < PORTAL_HEIGHT + 1; j++) {
                if(i == -1 || i == PORTAL_WIDTH || j == -1 || j == PORTAL_HEIGHT) {
                    mutablePos.setWithOffset(finalPos, i * direction.getStepX(), j, i * direction.getStepZ());
                    this.level.setBlock(mutablePos, Blocks.REINFORCED_DEEPSLATE.defaultBlockState(), 3);
                }
            }
        }

        for(int i = 0; i < PORTAL_WIDTH; i++) {
            for(int j = 0; j < PORTAL_HEIGHT; j++) {
                mutablePos.setWithOffset(finalPos, i * direction.getStepX(), j, i * direction.getStepZ());
                this.level.setBlock(mutablePos, DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState().setValue(OthersidePortalBlock.AXIS, axis), 18);
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(finalPos.immutable(), 2, 3));
    }

    private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.MutableBlockPos offsetPos, Direction directionIn, int offsetScale) {
        Direction direction = directionIn.getClockWise();

        for(int i = -1; i < 3; i++) {
            for(int j = -1; j < 4; j++) {
                offsetPos.setWithOffset(originalPos, directionIn.getStepX() * i + direction.getStepX() * offsetScale, j, directionIn.getStepZ() * i + direction.getStepZ() * offsetScale);
                if(j < 0 && !this.level.getBlockState(offsetPos).isAir()) return false;
                if(j >= 0 && !this.level.isEmptyBlock(offsetPos)) return false;
            }
        }

        return true;
    }
}
