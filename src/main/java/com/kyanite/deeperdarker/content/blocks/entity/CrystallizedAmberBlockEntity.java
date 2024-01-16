package com.kyanite.deeperdarker.content.blocks.entity;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import com.kyanite.deeperdarker.datagen.data.loot.DDChestLoot;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CrystallizedAmberBlockEntity extends BlockEntity {
    public boolean fossilizedEntity;
    public float rotation;
    private ItemStack loot = ItemStack.EMPTY;

    public CrystallizedAmberBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(DDBlockEntities.CRYSTALLIZED_AMBER.get(), pPos, pBlockState);
        if(pBlockState.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
            // TODO: make it so silk touch preserves item inside
            RandomSource random = RandomSource.create(pPos.asLong());
            if(random.nextFloat() < 0.5f) fossilizedEntity = true;
            rotation = random.nextFloat() * 180;
        }
    }

    public void generateLoot(Level level) {
        if(fossilizedEntity) return;
        LootTable table = level.getServer().getLootData().getLootTable(DDChestLoot.CRYSTALLIZED_AMBER);
        List<ItemStack> list = table.getRandomItems(new LootParams.Builder((ServerLevel) level).withParameter(LootContextParams.ORIGIN, this.getBlockPos().getCenter()).create(LootContextParamSets.CHEST));
        this.loot = list.get(0);
        this.setChanged();
    }

    public ItemStack getLoot() {
        return loot;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        tag.put("item", this.loot.save(tag));
        return tag;
    }

    @Override
    public void load(CompoundTag pTag) {
        if(pTag.contains("item")) {
            this.loot = ItemStack.of(pTag.getCompound("item"));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("item", this.loot.save(new CompoundTag()));
    }
}
