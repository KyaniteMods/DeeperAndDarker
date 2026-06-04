package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.DeeperDarkerConfig;
import com.kyanite.deeperdarker.content.DDItems;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

public record SoulElytraBoostPacket(boolean bool) implements CustomPacketPayload {
    public static final StreamCodec<ByteBuf, SoulElytraBoostPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, SoulElytraBoostPacket::bool,
            SoulElytraBoostPacket::new
    );

    public static final Identifier ID = DeeperDarker.rl("soul_elytra_boost");
    public static final Type<SoulElytraBoostPacket> TYPE = new Type<>(ID);

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            Level level = player.level();

            if (DeeperDarkerConfig.CONFIG.soulElytraCooldown.get() == -1) {
                player.sendOverlayMessage(Component.translatable("item." + DeeperDarker.MOD_ID + ".soul_elytra.no_cooldown"));
                return;
            }

            ItemStack chestItem = player.getInventory().getItem(38);
            if (player.isFallFlying() && chestItem.is(DDItems.SOUL_ELYTRA.get()) && !player.getCooldowns().isOnCooldown(chestItem)) {
                FireworkRocketEntity rocket = new FireworkRocketEntity(level, new ItemStack(Items.FIREWORK_ROCKET), player);
                level.addFreshEntity(rocket);
                player.getCooldowns().addCooldown(chestItem, DeeperDarkerConfig.CONFIG.soulElytraCooldown.get());
            }
        });
    }
}
