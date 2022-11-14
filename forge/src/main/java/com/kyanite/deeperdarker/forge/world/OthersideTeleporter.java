package com.kyanite.deeperdarker.forge.world;

import com.kyanite.deeperdarker.forge.OthersidePortalBlock;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
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

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

public class OthersideTeleporter implements ITeleporter {
    protected final ServerLevel level;

    public OthersideTeleporter(ServerLevel level) {
        this.level = level;
    }

    public Optional<BlockUtil.FoundRectangle> getExistingPortal(BlockPos pos) {
        PoiManager manager = this.level.getPoiManager();
        manager.ensureLoadedAndValid(this.level, pos, 64);
        Optional<PoiRecord> optional = manager.getInSquare((poiType) ->
                poiType.is(DDPoiTypes.OTHERSIDE_PORTAL.getKey()), pos, 64, PoiManager.Occupancy.ANY).sorted(Comparator.<PoiRecord>comparingDouble((poi) ->
                poi.getPos().distSqr(pos)).thenComparingInt((poi) ->
                poi.getPos().getY())).filter((poi) ->
                this.level.getBlockState(poi.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS)).findFirst();
        return optional.map((poi) -> {
            BlockPos blockpos = poi.getPos();
            this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
            BlockState blockstate = this.level.getBlockState(blockpos);
            return BlockUtil.getLargestRectangleAround(blockpos, blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (posIn) ->
                    this.level.getBlockState(posIn) == blockstate);
        });
    }

    public Optional<BlockUtil.FoundRectangle> makePortal(BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0D;
        BlockPos blockPos = null;
        double d1 = -1.0D;
        BlockPos blockPos1 = null;
        WorldBorder worldBorder = this.level.getWorldBorder();
        int dimensionLogicalHeight = this.level.getHeight() - 1;
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for(BlockPos.MutableBlockPos mutableBlockPos : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int min = Math.min(dimensionLogicalHeight, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, mutableBlockPos.getX(), mutableBlockPos.getZ()));
            if(worldBorder.isWithinBounds(mutableBlockPos) && worldBorder.isWithinBounds(mutableBlockPos.move(direction, 1))) {
                mutableBlockPos.move(direction.getOpposite(), 1);

                for(int i = min; i >= 0; i--) {
                    mutableBlockPos.setY(i);
                    if(this.level.isEmptyBlock(mutableBlockPos)) {
                        int y;
                        y = i;
                        while (i > 0 && this.level.isEmptyBlock(mutableBlockPos.move(Direction.DOWN))) {
                            i--;
                        }

                        if(i + 4 <= dimensionLogicalHeight) {
                            int j = y - i;
                            if(j <= 0 || j >= 3) {
                                mutableBlockPos.setY(i);
                                if(this.checkRegionForPlacement(mutableBlockPos, mutablePos, direction, 0)) {
                                    double d2 = pos.distSqr(mutableBlockPos);
                                    if(this.checkRegionForPlacement(mutableBlockPos, mutablePos, direction, -1) && this.checkRegionForPlacement(mutableBlockPos, mutablePos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
                                        d0 = d2;
                                        blockPos = mutableBlockPos.immutable();
                                    }

                                    if(d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
                                        d1 = d2;
                                        blockPos1 = mutableBlockPos.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if(d0 == -1.0D && d1 != -1.0D) {
            blockPos = blockPos1;
            d0 = d1;
        }

        if(d0 == -1.0D) {
            blockPos = (new BlockPos(pos.getX(), Mth.clamp(pos.getY(), 70, this.level.getHeight() - 10), pos.getZ())).immutable();
            Direction direction1 = direction.getClockWise();
            if(!worldBorder.isWithinBounds(blockPos)) {
                return Optional.empty();
            }

            for(int i = -2; i < 3; i++) {
                for(int j = 0; j < 6; j++) {
                    for(int k = -1; k < 3; k++) {
                        BlockState blockstate1 = k < 0 ? Blocks.REINFORCED_DEEPSLATE.defaultBlockState() : Blocks.AIR.defaultBlockState();
                        mutablePos.setWithOffset(blockPos, j * direction.getStepX() + i * direction1.getStepX(), k, j * direction.getStepZ() + i * direction1.getStepZ());
                        this.level.setBlockAndUpdate(mutablePos, blockstate1);
                    }
                }
            }
        }

        for(int i = -1; i < 7; i++) {
            for(int j = -1; j < 4; j++) {
                if(i == -1 || i == 6 || j == -1 || j == 3) {
                    mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                    this.level.setBlock(mutablePos, Blocks.REINFORCED_DEEPSLATE.defaultBlockState(), 3);
                }
            }
        }

        BlockState othersidePortal = DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState().setValue(OthersidePortalBlock.AXIS, axis);

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 3; j++) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                this.level.setBlock(mutablePos, othersidePortal, 18);
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(blockPos.immutable(), 2, 3));
    }

    private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.MutableBlockPos offsetPos, Direction directionIn, int offsetScale) {
        Direction direction = directionIn.getClockWise();

        for(int i = -1; i < 3; i++) {
            for(int j = -1; j < 4; j++) {
                offsetPos.setWithOffset(originalPos, directionIn.getStepX() * i + direction.getStepX() * offsetScale, j, directionIn.getStepZ() * i + direction.getStepZ() * offsetScale);
                if(j < 0 && !this.level.getBlockState(offsetPos).getMaterial().isSolid()) {
                    return false;
                }

                if(j >= 0 && !this.level.isEmptyBlock(offsetPos)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        boolean destinationIsUG = destWorld.dimension() == DDDimensions.OTHERSIDE_LEVEL;
        if(entity.level.dimension() != DDDimensions.OTHERSIDE_LEVEL && !destinationIsUG) {
            return null;
        }
        else {
            WorldBorder border = destWorld.getWorldBorder();
            double minX = Math.max(-2.9999872E7D, border.getMinX() + 16.0D);
            double minZ = Math.max(-2.9999872E7D, border.getMinZ() + 16.0D);
            double maxX = Math.min(2.9999872E7D, border.getMaxX() - 16.0D);
            double maxZ = Math.min(2.9999872E7D, border.getMaxZ() - 16.0D);
            double coordinateDifference = DimensionType.getTeleportationScale(entity.level.dimensionType(), destWorld.dimensionType());
            BlockPos blockpos = new BlockPos(Mth.clamp(entity.getX() * coordinateDifference, minX, maxX), entity.getY(), Mth.clamp(entity.getZ() * coordinateDifference, minZ, maxZ));
            return this.getOrMakePortal(entity, blockpos).map((result) -> {
                BlockState state = entity.level.getBlockState(entity.portalEntrancePos);
                Direction.Axis axis;
                Vec3 vector3d;
                if(state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
                    axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
                    BlockUtil.FoundRectangle rectangle = BlockUtil.getLargestRectangleAround(entity.portalEntrancePos, axis, 21, Direction.Axis.Y, 21, (pos) -> entity.level.getBlockState(pos) == state);
                    vector3d = PortalShape.getRelativePosition(rectangle, axis, entity.position(), entity.getDimensions(entity.getPose()));
                } else {
                    axis = Direction.Axis.X;
                    vector3d = new Vec3(0.5D, 0.0D, 0.0D);
                }

                return PortalShape.createPortalInfo(destWorld, result, axis, vector3d, entity.getDimensions(entity.getPose()), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
            }).orElse(null);
        }
    }

    protected Optional<BlockUtil.FoundRectangle> getOrMakePortal(Entity entity, BlockPos pos) {
        Optional<BlockUtil.FoundRectangle> existingPortal = this.getExistingPortal(pos);
        if(existingPortal.isPresent()) {
            return existingPortal;
        } else {
            Direction.Axis portalAxis = this.level.getBlockState(entity.portalEntrancePos).getOptionalValue(OthersidePortalBlock.AXIS).orElse(Direction.Axis.X);
            return this.makePortal(pos, portalAxis);
        }
    }
}
