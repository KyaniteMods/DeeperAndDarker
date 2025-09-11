package com.kyanite.deeperdarker.content.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.Optional;

public record TempleTracker(Optional<GlobalPos> linkedPos) {
    public static final Codec<TempleTracker> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    GlobalPos.CODEC.optionalFieldOf("linked_pos").forGetter(TempleTracker::linkedPos)
            ).apply(instance, TempleTracker::new)
    );
    public static final StreamCodec<ByteBuf, TempleTracker> STREAM_CODEC = StreamCodec.composite(GlobalPos.STREAM_CODEC.apply(ByteBufCodecs::optional), TempleTracker::linkedPos, TempleTracker::new);

    public static TempleTracker empty() {
        return new TempleTracker(Optional.empty());
    }
}
