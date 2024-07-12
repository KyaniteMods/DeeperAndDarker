package com.kyanite.deeperdarker.content.datacomponents;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.Level;

import java.util.Optional;

public record Transmitter(Optional<GlobalPos> linkedPos, String savedBlock) {
    public static final Codec<Transmitter> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    GlobalPos.CODEC.optionalFieldOf("linked_pos").forGetter(Transmitter::linkedPos),
                    Codec.STRING.optionalFieldOf("saved_block", "empty").forGetter(Transmitter::savedBlock)
            ).apply(instance, Transmitter::new)
    );
    public static final StreamCodec<ByteBuf, Transmitter> STREAM_CODEC = StreamCodec.composite(GlobalPos.STREAM_CODEC.apply(ByteBufCodecs::optional), Transmitter::linkedPos, ByteBufCodecs.STRING_UTF8, Transmitter::savedBlock, Transmitter::new);

    public Transmitter newConnection(Level level, BlockPos pos) {
        Optional<GlobalPos> globalPos = pos != null ? Optional.of(GlobalPos.of(level.dimension(), pos)) : Optional.empty();
        String blockName = pos != null ? level.getBlockState(pos).getBlock().getDescriptionId() : "empty";
        return new Transmitter(globalPos, blockName);
    }

    public static Transmitter empty() {
        return new Transmitter(Optional.empty(), "empty");
    }
}
