package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.content.DDItems;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketSoulElytraBoost {
    public PacketSoulElytraBoost(ByteBuf buf) {
    }

    public PacketSoulElytraBoost() {
    }

    public void toBytes(ByteBuf buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayer player = context.get().getSender();
            Level level = context.get().getSender().level();
            if(player.isFallFlying() && player.getInventory().armor.get(2).is(DDItems.SOUL_ELYTRA.get())) {
                FireworkRocketEntity rocket = new FireworkRocketEntity(level, new ItemStack(Items.FIREWORK_ROCKET), player);
                level.addFreshEntity(rocket);
            }
        });

        context.get().setPacketHandled(true);
    }
}
