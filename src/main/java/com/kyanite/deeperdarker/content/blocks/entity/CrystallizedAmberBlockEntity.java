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
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class CrystallizedAmberBlockEntity extends BlockEntity implements ItemOwner {
    private boolean fossilizedEntity;
    private ItemStack loot = ItemStack.EMPTY;

    public CrystallizedAmberBlockEntity(BlockPos pos, BlockState blockState) {
        super(DDBlockEntities.CRYSTALLIZED_AMBER.get(), pos, blockState);
    }

    public void generateFossil(ServerLevel level, BlockPos pos) {
        if(fossilizedEntity || !loot.isEmpty()) return;

        RandomSource random = new XoroshiroRandomSource(pos.asLong());
        fossilizedEntity = random.nextFloat() < 0.2f;
        if(!fossilizedEntity) {
            LootTable table = level.getServer().reloadableRegistries().getLootTable(DDChestLoot.CRYSTALLIZED_AMBER);
            LootParams lootParams = new LootParams.Builder(level)
                    .withParameter(LootContextParams.ORIGIN, this.getBlockPos().getCenter())
                    .withParameter(LootContextParams.BLOCK_ENTITY, this)
                    .create(LootContextParamSets.CHEST);

            List<ItemStack> list = table.getRandomItems(lootParams);
            if(list.isEmpty()) fossilizedEntity = true;
            else this.loot = list.getFirst();
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
        return this.saveCustomOnly(registries);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if(!this.loot.isEmpty()) output.store("item", ItemStack.CODEC, this.loot);
        output.putBoolean("leech", this.fossilizedEntity);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.loot = input.read("item", ItemStack.CODEC).orElse(ItemStack.EMPTY);
        this.fossilizedEntity = input.getBooleanOr("leech", false);
    }

    @Override
    public Level level() {
        return this.level;
    }

    @Override
    public Vec3 position() {
        return this.getBlockPos().getCenter();
    }

    @Override
    public float getVisualRotationYInDegrees() {
        return 0;
    }
}
