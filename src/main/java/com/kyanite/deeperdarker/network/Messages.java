package com.kyanite.deeperdarker.network;

public class Messages {
    public static void registerMessages() {
//        ServerPlayNetworking.registerGlobalReceiver(SoulElytraBoostPacket.TYPE, (packet, player, responseSender) -> {
//            Level level = player.level();
//            if (DeeperDarker.CONFIG.server.soulElytraCooldown() == -1) {
//                player.displayClientMessage(Component.translatable(DDItems.SOUL_ELYTRA.getDescriptionId() + ".boost_disabled").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)), true);
//                return;
//            }
//            if(player.isFallFlying() && player.getInventory().armor.get(2).is(DDItems.SOUL_ELYTRA) && !player.getCooldowns().isOnCooldown(DDItems.SOUL_ELYTRA) && DeeperDarker.CONFIG.server.soulElytraCooldown() != -1) {
//                FireworkRocketEntity rocket = new FireworkRocketEntity(level, new ItemStack(Items.FIREWORK_ROCKET), player);
//                level.addFreshEntity(rocket);
//                player.getCooldowns().addCooldown(DDItems.SOUL_ELYTRA, DeeperDarker.CONFIG.server.soulElytraCooldown());
//            }
//        });
//        ServerPlayNetworking.registerGlobalReceiver(UseTransmitterPacket.TYPE, (packet, player, responseSender) -> {
//            for(ItemStack stack : player.getInventory().items) {
//                if(stack.is(DDItems.SCULK_TRANSMITTER) && SculkTransmitterItem.isLinked(stack)) {
//                    SculkTransmitterItem.transmit(player.level(), player, stack, null);
//                    break;
//                }
//            }
//        });
    }
}
