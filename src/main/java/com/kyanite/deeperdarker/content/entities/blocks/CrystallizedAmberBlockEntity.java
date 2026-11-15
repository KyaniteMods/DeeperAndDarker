package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberContent;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberEntity;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberItemStack;
import com.kyanite.deeperdarker.content.items.components.DDDataComponents;
import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
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
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class CrystallizedAmberBlockEntity extends BlockEntity {
    public @Nullable CrystallizedAmberContent<?> content;

    public static final String LEGACY_ITEM_TAG = "item";
    public static final String LEGACY_LEECH_TAG = "leech";
    public static final String LEGACY_ROTATION_TAG = "rotation";

    public static final String CONTENT_TAG = "content";

    public CrystallizedAmberBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(DDBlockEntities.CRYSTALLIZED_AMBER, pPos, pBlockState);
    }

    // maybe remove if crash isn't fixed? (Accessing LegacyRandomSource from multiple threads)
    public void generateFossil(Level level, BlockPos pos) {
        if (content != null) return;

        RandomSource random = RandomSource.create(pos.asLong());
        float rotation = random.nextFloat() * 180.0f;
        if(random.nextFloat() < 0.15f) {
            content = new CrystallizedAmberEntity(DDEntities.SCULK_LEECH, rotation);
            return;
        }

        LootTable table = level.getServer().reloadableRegistries().getLootTable(DDChestLootTableProvider.CRYSTALLIZED_AMBER);
        List<ItemStack> list = table.getRandomItems(new LootParams.Builder((ServerLevel) level).withParameter(LootContextParams.ORIGIN, getBlockPos().getCenter()).create(LootContextParamSets.CHEST), pos.asLong());
        ItemStack loot = list.isEmpty() ? ItemStack.EMPTY : list.get(0);
        if (!loot.isEmpty()) {
            content = new CrystallizedAmberItemStack(loot, rotation);
        }
        setChanged();
    }

    public @Nullable CrystallizedAmberContent<?> getContent() {
        return content;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        if (content != null) {
            CrystallizedAmberContent.CODEC.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), content)
                    .resultOrPartial(string -> DeeperDarker.LOGGER.error("Error saving crystallized amber content: '{}'", string))
                    .ifPresent(result -> tag.put(CONTENT_TAG, result));
        }
        return tag;
    }

    @Override
    public void loadAdditional(CompoundTag pTag, HolderLookup.Provider provider) {
        if (pTag.contains(CONTENT_TAG)) {
            CrystallizedAmberContent.CODEC.parse(provider.createSerializationContext(NbtOps.INSTANCE), pTag.getCompound(CONTENT_TAG))
                    .resultOrPartial(string -> DeeperDarker.LOGGER.error("Invalid crystallized amber content: '{}'", string))
                    .ifPresent(content -> this.content = content);
        } else {
            if (pTag.contains(LEGACY_ITEM_TAG)) {
                ItemStack.parse(provider, pTag.getCompound(LEGACY_ITEM_TAG)).ifPresent(result -> content = new CrystallizedAmberItemStack(result, pTag.getFloat(LEGACY_ROTATION_TAG)));
            } else if (pTag.getBoolean(LEGACY_LEECH_TAG)) {
                content = new CrystallizedAmberEntity(DDEntities.SCULK_LEECH, pTag.getFloat(LEGACY_ROTATION_TAG));
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider provider) {
        if (content != null) {
            CrystallizedAmberContent.CODEC.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), content)
                    .resultOrPartial(string -> DeeperDarker.LOGGER.error("Error saving crystallized amber content: '{}'", string))
                    .ifPresent(result -> pTag.put(CONTENT_TAG, result));
        }
    }

    @Override
    protected void applyImplicitComponents(DataComponentInput dataComponentInput) {
        super.applyImplicitComponents(dataComponentInput);
        content = dataComponentInput.get(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT);
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder builder) {
        super.collectImplicitComponents(builder);
        builder.set(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT, content);
    }

    @Override
    public void removeComponentsFromTag(CompoundTag compoundTag) {
        compoundTag.remove(CONTENT_TAG);
    }
}
