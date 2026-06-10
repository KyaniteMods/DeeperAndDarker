package com.kyanite.deeperdarker.content.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import net.minecraft.world.level.Level;

import java.util.Optional;
import java.util.function.Consumer;

@SuppressWarnings("NullableProblems")
public record Transmitter(Optional<GlobalPos> linkedPos, String savedBlock) implements TooltipProvider {
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

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag flag, DataComponentGetter components) {
        if(linkedPos.isPresent()) {
            BlockPos pos = linkedPos.get().pos();
            consumer.accept(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.linked", Component.translatable(savedBlock)).withStyle(ChatFormatting.GRAY));
            consumer.accept(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location", pos.getX(), pos.getY(), pos.getZ()).withStyle(ChatFormatting.GRAY));
            consumer.accept(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location_level", linkedPos.get().dimension().identifier().toString()).withStyle(ChatFormatting.GRAY));
        } else {
            consumer.accept(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.not_linked").withStyle(ChatFormatting.GRAY));
        }
    }
}
