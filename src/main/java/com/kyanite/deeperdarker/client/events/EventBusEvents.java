package com.kyanite.deeperdarker.client.events;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.client.rendering.armor.renderer.SculkArmorRenderer;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import com.kyanite.deeperdarker.registry.items.SculkArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EventBusEvents {
    @SubscribeEvent
    public static void entityRender(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(SculkArmorItem.class, new SculkArmorRenderer());
    }

    @SubscribeEvent
    public static void entityAttribute(final EntityAttributeCreationEvent event) {
        event.put(DDEntities.SCULK_WORM.get(), SculkWormEntity.attributes());
    }
}