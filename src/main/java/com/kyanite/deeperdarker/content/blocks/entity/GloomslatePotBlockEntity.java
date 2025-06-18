package com.kyanite.deeperdarker.content.blocks.entity;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.ticks.ContainerSingleItem;

import java.util.List;

@SuppressWarnings("deprecation, NullableProblems")
public class GloomslatePotBlockEntity extends BlockEntity implements ContainerSingleItem.BlockContainerSingleItem {
    public long wobbleStartedAtTick;
    public DecoratedPotBlockEntity.WobbleStyle lastWobbleStyle;
    private PotDecorations decorations;
    private ItemStack item;

    public GloomslatePotBlockEntity(BlockPos pos, BlockState blockState) {
        super(DDBlockEntities.GLOOMSLATE_POT.get(), pos, blockState);

        this.decorations = PotDecorations.EMPTY;
        this.item = ItemStack.EMPTY;
    }

    @Override
    public BlockEntity getContainerBlockEntity() {
        return this;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        this.decorations.save(tag);
        tag.put("item", this.item.saveOptional(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.decorations = PotDecorations.load(tag);
        this.item = ItemStack.parseOptional(registries, tag.getCompound("item"));
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveCustomOnly(registries);
    }

    @Override
    public ItemStack getTheItem() {
        return this.item;
    }

    @Override
    public void setTheItem(ItemStack item) {
        this.item = item;
    }

    public void setFromItem(ItemStack item) {
        this.applyComponentsFromItemStack(item);
    }

    public ItemStack getPotAsItem() {
        ItemStack stack = DDBlocks.GLOOMSLATE_POT_ITEM.get().getDefaultInstance();
        stack.applyComponents(this.collectComponents());
        return stack;
    }

    public Direction getDirection() {
        return this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
    }

    public PotDecorations getDecorations() {
        return this.decorations;
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        components.set(DataComponents.POT_DECORATIONS, this.decorations);
        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(List.of(this.item)));
    }

    @Override
    protected void applyImplicitComponents(DataComponentInput componentInput) {
        this.decorations = componentInput.getOrDefault(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY);
        this.item = componentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyOne();
    }

    @Override
    public void removeComponentsFromTag(CompoundTag tag) {
        tag.remove("sherds");
        tag.remove("item");
    }

    public void wobble(DecoratedPotBlockEntity.WobbleStyle style) {
        if(this.level != null && !this.level.isClientSide()) {
            this.level.blockEvent(this.getBlockPos(), this.getBlockState().getBlock(), 1, style.ordinal());
        }
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        if(this.level != null && id == 1 && type >= 0 && type < DecoratedPotBlockEntity.WobbleStyle.values().length) {
            this.wobbleStartedAtTick = this.level.getGameTime();
            this.lastWobbleStyle = DecoratedPotBlockEntity.WobbleStyle.values()[type];
            return true;
        }

        return super.triggerEvent(id, type);
    }
}
