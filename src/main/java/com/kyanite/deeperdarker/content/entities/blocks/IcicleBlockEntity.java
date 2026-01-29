package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.blocks.IcicleBlock;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SculkSensorBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.BlockPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Optional;
import java.util.stream.Collectors;

public class IcicleBlockEntity extends BlockEntity implements GameEventListener.Holder<VibrationSystem.Listener>, VibrationSystem {
    private static final Logger LOGGER = LogUtils.getLogger();
    private VibrationSystem.Data vibrationData;
    private final VibrationSystem.Listener vibrationListener;
    private final VibrationSystem.User vibrationUser = this.createVibrationUser();

    protected IcicleBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.vibrationData = new VibrationSystem.Data();
        this.vibrationListener = new VibrationSystem.Listener(this);
    }

    public IcicleBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(DDBlockEntities.ICICLE, blockPos, blockState);
    }

    public VibrationSystem.User createVibrationUser() {
        return new VibrationUser(this.getBlockPos());
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        if (compoundTag.contains("listener", 10)) {
            VibrationSystem.Data.CODEC.parse(new Dynamic<>(NbtOps.INSTANCE, compoundTag.getCompound("listener"))).resultOrPartial(LOGGER::error).ifPresent(data -> {
                this.vibrationData = data;
            });
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        VibrationSystem.Data.CODEC.encodeStart(NbtOps.INSTANCE, this.vibrationData).resultOrPartial(LOGGER::error).ifPresent(tag -> compoundTag.put("listener", tag));
    }

    @Override
    public VibrationSystem.Data getVibrationData() {
        return this.vibrationData;
    }

    @Override
    public VibrationSystem.User getVibrationUser() {
        return this.vibrationUser;
    }

    @Override
    public VibrationSystem.Listener getListener() {
        return this.vibrationListener;
    }

    protected class VibrationUser
            implements VibrationSystem.User {
        public static final int LISTENER_RANGE = 96;
        protected final BlockPos blockPos;
        private final PositionSource positionSource;

        public VibrationUser(BlockPos blockPos) {
            this.blockPos = blockPos;
            this.positionSource = new BlockPositionSource(blockPos);
        }

        @Override
        public int getListenerRadius() {
            return LISTENER_RANGE;
        }

        @Override
        public PositionSource getPositionSource() {
            return this.positionSource;
        }

        @Override
        public boolean canTriggerAvoidVibration() {
            return true;
        }

        @Override
        public boolean canReceiveVibration(ServerLevel serverLevel, BlockPos blockPos, GameEvent gameEvent, @Nullable GameEvent.Context context) {
            int dx = Mth.abs(this.blockPos.getX() - blockPos.getX());
            int dz = Mth.abs(this.blockPos.getZ() - blockPos.getZ());
            BlockState blockState = IcicleBlockEntity.this.getBlockState();
            Block block = blockState.getBlock();
            if (!serverLevel.getBlockState(this.blockPos.above()).is(block) || serverLevel.getBlockState(this.blockPos.above(2)).is(block)) return false;
            if (block instanceof IcicleBlock icicle) {
                Optional<BlockPos> optional = icicle.getStalactiteTip(serverLevel, this.blockPos);
                if (optional.isEmpty() || !serverLevel.getBlockState(optional.get().below()).isAir()) return false;
            }
            return (gameEvent != GameEvent.BLOCK_DESTROY && gameEvent != GameEvent.BLOCK_PLACE) && dx <= 1 && (blockPos.getY() < this.blockPos.getY()) && dz <= 1 && BlockPos.betweenClosedStream(this.blockPos.below(), new BlockPos(this.blockPos.getX(), blockPos.getY(), this.blockPos.getZ())).allMatch(pos -> !serverLevel.getBlockState(pos).isCollisionShapeFullBlock(serverLevel, pos) || serverLevel.getBlockState(pos).is(block));
        }

        @Override
        public void onReceiveVibration(ServerLevel serverLevel, BlockPos blockPos, GameEvent gameEvent, @Nullable Entity entity, @Nullable Entity entity2, float f) {
            BlockState blockState = IcicleBlockEntity.this.getBlockState();
            Block block = blockState.getBlock();
            if (block instanceof IcicleBlock icicle) {
                icicle.spawnFallingStalactite(blockState, serverLevel, this.blockPos);
            }
        }

        @Override
        public boolean requiresAdjacentChunksToBeTicking() {
            return true;
        }
    }
}
