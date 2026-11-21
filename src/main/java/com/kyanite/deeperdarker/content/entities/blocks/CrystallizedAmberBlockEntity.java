package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberContent;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberEntity;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberItemStack;
import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class CrystallizedAmberBlockEntity extends BlockEntity {
    private @Nullable CrystallizedAmberContent<?> content;

    public static final String LEGACY_ITEM_TAG = "item";
    public static final String LEGACY_LEECH_TAG = "leech";
    public static final String LEGACY_ROTATION_TAG = "rotation";

    public static final String CONTENT_TAG = "content";

    public CrystallizedAmberBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(DDBlockEntities.CRYSTALLIZED_AMBER, pPos, pBlockState);
    }

    public @Nullable CrystallizedAmberContent<?> getContent() {
        return content;
    }

    public void setContent(@Nullable CrystallizedAmberContent<?> content) {
        this.content = content;
        setChanged();
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        if (content != null) {
            CrystallizedAmberContent.CODEC.encodeStart(NbtOps.INSTANCE, content)
                    .resultOrPartial(string -> DeeperDarker.LOGGER.error("Error saving crystallized amber content: '{}'", string))
                    .ifPresent(result -> tag.put(CONTENT_TAG, result));
        }
        return tag;
    }

    @Override
    public void load(CompoundTag pTag) {
        if (pTag.contains(CONTENT_TAG)) {
            CrystallizedAmberContent.CODEC.parse(NbtOps.INSTANCE, pTag.getCompound(CONTENT_TAG))
                    .resultOrPartial(string -> DeeperDarker.LOGGER.error("Invalid crystallized amber content: '{}'", string))
                    .ifPresent(content -> this.content = content);
        } else {
            if (pTag.contains(LEGACY_ITEM_TAG)) {
                ItemStack stack = ItemStack.of(pTag.getCompound(LEGACY_ITEM_TAG));
                if (!stack.isEmpty()) {
                    content = new CrystallizedAmberItemStack(stack, pTag.getFloat(LEGACY_ROTATION_TAG));
                }
            } else if (pTag.getBoolean(LEGACY_LEECH_TAG)) {
                content = new CrystallizedAmberEntity(DDEntities.SCULK_LEECH, pTag.getFloat(LEGACY_ROTATION_TAG));
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        if (content != null) {
            CrystallizedAmberContent.CODEC.encodeStart(NbtOps.INSTANCE, content)
                    .resultOrPartial(string -> DeeperDarker.LOGGER.error("Error saving crystallized amber content: '{}'", string))
                    .ifPresent(result -> pTag.put(CONTENT_TAG, result));
        }
    }
}
