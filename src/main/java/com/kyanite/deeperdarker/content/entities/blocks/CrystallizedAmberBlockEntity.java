package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
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

@SuppressWarnings("NullableProblems")
public class CrystallizedAmberBlockEntity extends BlockEntity {
    public boolean fossilizedEntity;
    public float rotation;
    private ItemStack loot = ItemStack.EMPTY;

    public static final String ITEM_TAG = "item";
    public static final String LEECH_TAG = "leech";
    public static final String ROTATION_TAG = "rotation";

    public CrystallizedAmberBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(DDBlockEntities.CRYSTALLIZED_AMBER, pPos, pBlockState);
    }

    // maybe remove if crash isn't fixed? (Accessing LegacyRandomSource from multiple threads)
    public void generateFossil(Level level, BlockPos pos) {
        if(fossilizedEntity || !loot.isEmpty()) return;

        RandomSource random = RandomSource.create(pos.asLong());
        rotation = random.nextFloat() * 180;
        if(random.nextFloat() < 0.15f) {
            fossilizedEntity = true;
            return;
        }

        LootTable table = level.getServer().reloadableRegistries().getLootTable(DDChestLootTableProvider.CRYSTALLIZED_AMBER);
        List<ItemStack> list = table.getRandomItems(new LootParams.Builder((ServerLevel) level).withParameter(LootContextParams.ORIGIN, getBlockPos().getCenter()).create(LootContextParamSets.CHEST), pos.asLong());
        loot = list.isEmpty() ? ItemStack.EMPTY : list.get(0);
        setChanged();
    }

    public ItemStack getLoot() {
        return loot;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        if (!loot.isEmpty()) {
            tag.put(ITEM_TAG, loot.save(provider));
        }
        tag.putBoolean(LEECH_TAG, this.fossilizedEntity);
        tag.putFloat(ROTATION_TAG, this.rotation);
        return tag;
    }

    @Override
    public void loadAdditional(CompoundTag pTag, HolderLookup.Provider provider) {
        if(pTag.contains(ITEM_TAG)) ItemStack.parse(provider, pTag.getCompound(ITEM_TAG)).ifPresent(result -> loot = result);
        if(pTag.contains(LEECH_TAG)) fossilizedEntity = pTag.getBoolean(LEECH_TAG);
        if(pTag.contains(ROTATION_TAG)) rotation = pTag.getFloat(ROTATION_TAG);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider provider) {
        if (!loot.isEmpty()) {
            pTag.put(ITEM_TAG, loot.save(provider));
        }
        pTag.putBoolean(LEECH_TAG, this.fossilizedEntity);
        pTag.putFloat(ROTATION_TAG, this.rotation);
    }
}
