package com.kyanite.deeperdarker.content.items.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.Level;

import java.util.Optional;

public record TransmitterData(Optional<GlobalPos> linkedPos, String savedBlock) {
    public static final Codec<TransmitterData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    GlobalPos.CODEC.optionalFieldOf("linked_pos").forGetter(TransmitterData::linkedPos),
                    Codec.STRING.optionalFieldOf("saved_block", "empty").forGetter(TransmitterData::savedBlock)
            ).apply(instance, TransmitterData::new)
    );
    public static final StreamCodec<ByteBuf, TransmitterData> STREAM_CODEC = StreamCodec.composite(GlobalPos.STREAM_CODEC.apply(ByteBufCodecs::optional), TransmitterData::linkedPos, ByteBufCodecs.STRING_UTF8, TransmitterData::savedBlock, TransmitterData::new);

    public TransmitterData newConnection(Level level, BlockPos pos) {
        Optional<GlobalPos> globalPos = pos != null ? Optional.of(GlobalPos.of(level.dimension(), pos)) : Optional.empty();
        String blockName = pos != null ? level.getBlockState(pos).getBlock().getDescriptionId() : "empty";
        return new TransmitterData(globalPos, blockName);
    }

    public static TransmitterData empty() {
        return new TransmitterData(Optional.empty(), "empty");
    }
}