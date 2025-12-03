package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ReturnStatueBlockEntity extends BlockEntity {
    public BlockPos teleportPos = null;

    public ReturnStatueBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(DDBlockEntities.RETURN_STATUE, blockPos, blockState);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("teleport_pos", Tag.TAG_COMPOUND)) {
            CompoundTag posTag = tag.getCompound("teleport_pos");
            if (posTag.contains("x", Tag.TAG_INT) && posTag.contains("y", Tag.TAG_INT) && posTag.contains("z", Tag.TAG_INT)) {
                teleportPos = new BlockPos(posTag.getInt("x"), posTag.getInt("y"), posTag.getInt("z"));
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (teleportPos != null) {
            CompoundTag posTag = new CompoundTag();
            posTag.putInt("x", teleportPos.getX());
            posTag.putInt("y", teleportPos.getY());
            posTag.putInt("z", teleportPos.getZ());
            tag.put("teleport_pos", posTag);
        }
    }
}
