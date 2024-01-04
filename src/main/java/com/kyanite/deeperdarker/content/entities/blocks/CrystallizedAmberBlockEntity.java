package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CrystallizedAmberBlockEntity extends BlockEntity {
    public boolean fossilizedEntity;
    public float rotation;

    public CrystallizedAmberBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(DDBlockEntities.CRYSTALLIZED_AMBER, pPos, pBlockState);
        if(pBlockState.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
            // TODO: too predictable (based on block pos)
            // TODO: make it so silk touch preserves item inside
            RandomSource random = RandomSource.create(pPos.asLong());
            rotation = random.nextFloat() * 180;
            if(random.nextFloat() < 0.5f) fossilizedEntity = true;
        }
        System.out.println(fossilizedEntity);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    public ItemStack getFossilizedLoot() {
        return new ItemStack(Items.DIAMOND_AXE);
    }
}
