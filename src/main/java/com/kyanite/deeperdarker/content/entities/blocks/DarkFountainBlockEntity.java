package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDDamageTypes;
import com.kyanite.deeperdarker.content.blocks.DarkFountainBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DarkFountainBlockEntity extends BlockEntity {
    private int fountainTicksLeftOld = 0;
    private int fountainTicksLeft = 0;
    private boolean createdFountainThisTick = false;
    private int beamBlocksUp = 0;
    private int beamBlocksDown = 0;
    private AABB fountainBeam = null;

    public DarkFountainBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public DarkFountainBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(DDBlockEntities.DARK_FOUNTAIN, blockPos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, DarkFountainBlockEntity blockEntity) {
        blockEntity.fountainTicksLeftOld = blockEntity.fountainTicksLeft;
        blockEntity.createdFountainThisTick = false;
        if (blockEntity.fountainTicksLeft == 0) {
            if (!level.isClientSide()) {
                if (level.getRandom().nextFloat() < 0.01f) {
                    blockEntity.fountainTicksLeft = level.getRandom().nextInt(50, 80);
                    blockEntity.fountainTicksLeftOld = blockEntity.fountainTicksLeft;
                    blockEntity.createdFountainThisTick = true;
                    level.setBlock(blockPos, blockState.setValue(DarkFountainBlock.HAS_BEAM, true), Block.UPDATE_ALL);
                } else {
                    level.setBlock(blockPos, blockState.setValue(DarkFountainBlock.HAS_BEAM, false), Block.UPDATE_ALL);
                    return;
                }
            }
        } else {
            blockEntity.calculateBeam(level, blockPos);
            blockEntity.fountainTicksLeft--;
        }

        if (level.isClientSide()) {
            return;
        }

        List<Entity> entities = level.getEntities(null, blockEntity.getFountainBeam());
        for (Entity entity : entities) {
            DamageSource damageSource = level.damageSources().source(DDDamageTypes.DARK_FOUNTAIN);
            if (!entity.hurt(damageSource, 3)) continue;
            float yaw = level.getRandom().nextFloat() * Mth.TWO_PI;
            float pitch = Mth.PI / 8.0f;
            double strength = 1.5;
            double x = Mth.sin(yaw) * Mth.cos(pitch) * strength;
            double y = Mth.sin(pitch) * strength;
            double z = Mth.cos(yaw) * Mth.cos(pitch) * strength;
            entity.setDeltaMovement(x, y, z);
        }
    }

    private void calculateBeam(Level level, BlockPos blockPos) {
        BlockPos.MutableBlockPos mutablePos = blockPos.mutable();
        int beamBlocksUp = 0;
        int beamBlocksDown = 0;
        while (level.isInWorldBounds(mutablePos.above())) {
            mutablePos.move(Direction.UP);
            if (DarkFountainBlock.canBeamPassThrough(level, mutablePos, level.getBlockState(mutablePos))) {
                beamBlocksUp++;
            } else break;
        }
        mutablePos.set(blockPos);
        while (level.isInWorldBounds(mutablePos.below())) {
            mutablePos.move(Direction.DOWN);
            if (DarkFountainBlock.canBeamPassThrough(level, mutablePos, level.getBlockState(mutablePos))) {
                beamBlocksDown++;
            } else break;
        }
        boolean changed = this.beamBlocksUp != beamBlocksUp || this.beamBlocksDown != beamBlocksDown;
        this.beamBlocksUp = beamBlocksUp;
        this.beamBlocksDown = beamBlocksDown;
        if (changed) {
            recalculateFountainBeam();
        }
    }

    public AABB getFountainBeam() {
        if (fountainBeam == null) recalculateFountainBeam();
        return fountainBeam;
    }

    public AABB recalculateFountainBeam() {
        BlockPos bottom = getBlockPos().below(beamBlocksDown);
        BlockPos top = getBlockPos().above(beamBlocksUp).offset(1, 1, 1);
        fountainBeam = new AABB(bottom, top);
        return fountainBeam;
    }

    public int getBeamBlocksUp() {
        return beamBlocksUp;
    }

    public int getBeamBlocksDown() {
        return beamBlocksDown;
    }

    public int getFountainTicksLeft() {
        return fountainTicksLeft;
    }

    public int getFountainTicksLeftOld() {
        return fountainTicksLeftOld;
    }

    public boolean hasCreatedFountainThisTick() {
        return createdFountainThisTick;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    private void markUpdated() {
        this.setChanged();
        this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("fountain_ticks_left", fountainTicksLeft);
        tag.putInt("beam_blocks_up", beamBlocksUp);
        tag.putInt("beam_blocks_down", beamBlocksDown);
        tag.putBoolean("created_fountain_this_tick", createdFountainThisTick);
        return tag;
    }

    @Override
    public void load(CompoundTag pTag) {
        if(pTag.contains("fountain_ticks_left")) fountainTicksLeft = pTag.getInt("fountain_ticks_left");
        if(pTag.contains("beam_blocks_up")) beamBlocksUp = pTag.getInt("beam_blocks_up");
        if(pTag.contains("beam_blocks_down")) beamBlocksDown = pTag.getInt("beam_blocks_down");
        if(pTag.contains("created_fountain_this_tick")) createdFountainThisTick = pTag.getBoolean("created_fountain_this_tick");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.putInt("fountain_ticks_left", fountainTicksLeft);
        pTag.putInt("beam_blocks_up", beamBlocksUp);
        pTag.putInt("beam_blocks_down", beamBlocksDown);
        pTag.putBoolean("created_fountain_this_tick", createdFountainThisTick);
    }
}
