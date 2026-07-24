package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.blocks.SculkAltarBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class SculkAltarBlockEntity extends BlockEntity implements Clearable {
    public static final float ROTATION_TO_DEGREES = 1.0f;
    public static final float ROTATION_TO_ITEM_ROTATION_DEGREES = 10.0f;
    private final NonNullList<ItemStack> items = NonNullList.withSize(10, ItemStack.EMPTY);
    private int rotation;

    public SculkAltarBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(DDBlockEntities.SCULK_ALTAR, blockPos, blockState);
    }

    public static void itemAnimationTick(Level level, BlockPos blockPos, BlockState blockState, SculkAltarBlockEntity blockEntity) {
        blockEntity.rotation++;
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        items.clear();
        ContainerHelper.loadAllItems(compoundTag, items);
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        ContainerHelper.saveAllItems(compoundTag, items, true);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundTag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundTag, items, true);
        return compoundTag;
    }

    public boolean placeStack(@Nullable Entity entity, ItemStack itemStack) {
        for (int j = 0; j < items.size(); ++j) {
            ItemStack itemStack2 = items.get(j);
            if (!itemStack2.isEmpty()) continue;
            items.set(j, itemStack.split(1));
            setHasItems(entity, true);
            markUpdated();
            return true;
        }
        return false;
    }

    public ItemStack remove(@Nullable Entity entity, float angleDegrees) {
        return remove(entity, (int)(angleDegrees / 360.0f * getItems().size()));
    }

    public ItemStack remove(@Nullable Entity entity, int i) {
        i = i % getItems().size();
        ItemStack removed = items.set(i, ItemStack.EMPTY);
        if (getItems().stream().allMatch(ItemStack::isEmpty)) {
            setHasItems(entity, false);
        }
        markUpdated();
        return removed;
    }

    public NonNullList<ItemStack> getItems() {
        return items;
    }

    public int getRotation() {
        return rotation;
    }

    public float getRotationDegrees(float tickDelta) {
        return Mth.wrapDegrees((getRotation() + tickDelta) * ROTATION_TO_DEGREES);
    }

    public float getItemRotationDegrees(float tickDelta) {
        return Mth.wrapDegrees((getRotation() + tickDelta) * ROTATION_TO_ITEM_ROTATION_DEGREES);
    }

    private void markUpdated() {
        setChanged();
        getLevel().sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public void clearContent() {
        items.clear();
    }

    private void setHasItems(@Nullable Entity entity, boolean value) {
        BlockState blockState = getBlockState().setValue(SculkAltarBlock.HAS_ITEMS, value);
        if (hasLevel()) {
            getLevel().setBlock(getBlockPos(), blockState, Block.UPDATE_ALL);
            getLevel().gameEvent(GameEvent.BLOCK_CHANGE, getBlockPos(), GameEvent.Context.of(entity, blockState));
        }
    }
}
