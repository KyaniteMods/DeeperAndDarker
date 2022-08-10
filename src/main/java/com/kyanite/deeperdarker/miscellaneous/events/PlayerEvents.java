package com.kyanite.deeperdarker.miscellaneous.events;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID)
public class PlayerEvents {
    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent e) {
        if(e.side != LogicalSide.SERVER) return;

        if(e.player.getLevel().dimension() == DDDimensions.OTHERSIDE_LEVEL) {
            if(!e.player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(DDItems.WARDEN_HELMET.get()) && !e.player.isCreative() && !e.player.isSpectator()) {
                e.player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 25, -10));
            }
        }
    }
}
