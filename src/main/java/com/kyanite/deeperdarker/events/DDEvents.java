package com.kyanite.deeperdarker.events;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID)
public class DDEvents {
    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        if(!event.player.level.isClientSide()) {
            if(event.player.getLevel().dimension() == DDDimensions.OTHERSIDE_LEVEL) {
                if(!event.player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(DDItems.WARDEN_HELMET.get()) && !event.player.isCreative() && !event.player.isSpectator()) {
                    event.player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 25, 0));
                }
            }
        }
    }
}
