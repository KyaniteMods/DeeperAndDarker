package com.kyanite.deeperdarker.content.blocks.entity;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.datagen.data.loot.DDChestLoot;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class CrystallizedAmberBlockEntity extends BlockEntity {
    private boolean fossilizedEntity;
    private ItemStack loot = ItemStack.EMPTY;

    public CrystallizedAmberBlockEntity(BlockPos pos, BlockState blockState) {
        super(DDBlockEntities.CRYSTALLIZED_AMBER.get(), pos, blockState);
    }

    public void generateFossil(ServerLevel level, BlockPos pos) {
        if (fossilizedEntity || !loot.isEmpty())
            return;

        RandomSource random = new XoroshiroRandomSource(pos.asLong());
        fossilizedEntity = random.nextFloat() < 0.2f;
        if (!fossilizedEntity) {
            LootTable table = level.getServer().reloadableRegistries().getLootTable(DDChestLoot.CRYSTALLIZED_AMBER);
            LootParams lootParams = new LootParams.Builder(level)
                    .withParameter(LootContextParams.ORIGIN, this.getBlockPos().getCenter())
                    .withParameter(LootContextParams.BLOCK_ENTITY, this)
                    .create(LootContextParamSets.CHEST);
            List<ItemStack> list = table.getRandomItems(lootParams);
            if (!list.isEmpty()) {
                this.loot = list.getFirst();
            } else {
                fossilizedEntity = true;
            }
        }

        this.setChanged();
        level.sendBlockUpdated(pos, this.getBlockState(), this.getBlockState(), 3);
    }

    public boolean hasLeech() {
        return fossilizedEntity;
    }

    public ItemStack getLoot() {
        return loot;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        tag.put("item", this.loot.saveOptional(registries));
        tag.putBoolean("leech", this.fossilizedEntity);
        return tag;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("item"))
            this.loot = ItemStack.parseOptional(registries, tag.getCompound("item"));
        if (tag.contains("leech"))
            this.fossilizedEntity = tag.getBoolean("leech");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("item", this.loot.saveOptional(registries));
        tag.putBoolean("leech", this.fossilizedEntity);
    }
}
