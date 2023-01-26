package com.kyanite.deeperdarker.registry.blocks.custom.entity;

import com.kyanite.deeperdarker.registry.blocks.custom.AncientChestBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class AncientChestEntity extends RandomizableContainerBlockEntity implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public AncientChestBlock ancientChestBlock;
    private NonNullList<ItemStack> items;

    public int lidAttempts = 0;
    public int wiggleTicks = 0;
    public int closeTicks = 0;
    public int cooldownTicks = 0;

    protected AncientChestEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.items = NonNullList.withSize(36, ItemStack.EMPTY);
        this.ancientChestBlock = (AncientChestBlock) blockState.getBlock();
    }


    public static int getWiggleTicks(BlockPos blockPos, BlockGetter blockGetter) {
        BlockState blockState = blockGetter.getBlockState(blockPos);
        if(blockState.hasBlockEntity()) {
            BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
            if(blockEntity instanceof AncientChestEntity ancientChestEntity) {
                return ancientChestEntity.wiggleTicks;
            }
        }

        return 0;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.closeTicks > 3;
    }

    public void tick() {
        if(this.cooldownTicks != 0) {
            this.cooldownTicks = this.cooldownTicks - 1;
        }

        if(this.closeTicks != 0) {
            this.closeTicks = this.closeTicks - 1;
            if(this.closeTicks < 1) {
                if(level.isClientSide()) {
                    level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.DEEPSLATE_TILES.defaultBlockState()), getBlockPos().getX() + 0.5d, getBlockPos().getY() + 0.6d, getBlockPos().getZ() + 0.5d, 0.05d, 0.05d, 0.05d);
                }
                this.lidAttempts = 0;
                this.cooldownTicks = 65;
            }
        }

        if(this.wiggleTicks != 0) {
            this.wiggleTicks = this.wiggleTicks - 1;
            if(level.isClientSide()) {
                level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.DEEPSLATE_TILES.defaultBlockState()), getBlockPos().getX() + 0.5d, getBlockPos().getY() + 0.6d, getBlockPos().getZ() + 0.5d, 0.05d, 0.05d, 0.05d);
            }
        }
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<AncientChestEntity>
                (this, "controller", 13, this::predicate));
    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().transitionLengthTicks = 13;
        if(this.wiggleTicks != 0)  {
            event.getController().transitionLengthTicks = 2;
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ancient_chest.wiggle", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }

        if(this.closeTicks > 3) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ancient_chest.idle_open", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ancient_chest.idle", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);

        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if(!this.tryLoadLootTable(compoundTag)) {
            ContainerHelper.loadAllItems(compoundTag, this.items);
        }

        this.cooldownTicks = compoundTag.getInt("Cooldown");
        this.lidAttempts = compoundTag.getInt("Attempts");
        this.closeTicks = compoundTag.getInt("CloseTicks");

    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);

        if(!this.trySaveLootTable(compoundTag)) {
            ContainerHelper.saveAllItems(compoundTag, this.items);
        }

        compoundTag.putInt("Cooldown", this.cooldownTicks);
        compoundTag.putInt("Attempts", this.lidAttempts);
        compoundTag.putInt("CloseTicks", this.closeTicks);
    }

    @Override
    protected Component getDefaultName() {
        return this.getBlockState().getValue(AncientChestBlock.POLISHED) ?
                Component.translatable("block.deeperdarker.deepslate_chest") :
                Component.translatable("block.deeperdarker.ancient_chest");
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return ChestMenu.fourRows(i, inventory);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public int getContainerSize() {
        return 36;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {
        this.items = nonNullList;
    }
}
