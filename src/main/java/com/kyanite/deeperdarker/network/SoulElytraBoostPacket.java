package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.DeeperDarkerConfig;
import com.kyanite.deeperdarker.content.DDItems;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SoulElytraBoostPacket {
    public SoulElytraBoostPacket() {
    }

    public SoulElytraBoostPacket(ByteBuf buf) {
    }

    public void toBytes(ByteBuf buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayer player = context.get().getSender();
            Level level = player.level();
            if (DeeperDarkerConfig.soulElytraCooldown == -1) {
                player.displayClientMessage(Component.translatable("item." + DeeperDarker.MOD_ID + ".soul_elytra.no_cooldown"), true);
                return;
            }

            if (player.isFallFlying() && player.getInventory().armor.get(2).is(DDItems.SOUL_ELYTRA.get()) && !player.getCooldowns().isOnCooldown(DDItems.SOUL_ELYTRA.get())) {
                FireworkRocketEntity rocket = new FireworkRocketEntity(level, new ItemStack(Items.FIREWORK_ROCKET), player);
                level.addFreshEntity(rocket);
                player.getCooldowns().addCooldown(DDItems.SOUL_ELYTRA.get(), DeeperDarkerConfig.soulElytraCooldown);
            }
        });

        context.get().setPacketHandled(true);
    }
}
