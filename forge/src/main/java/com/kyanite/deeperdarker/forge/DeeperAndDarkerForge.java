package com.kyanite.deeperdarker.forge;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.client.rendering.armor.WardenArmorRenderer;
import com.kyanite.deeperdarker.client.rendering.entity.*;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.miscellaneous.DDWoodTypes;
import com.kyanite.deeperdarker.platform.forge.PlatformHelperImpl;
import com.kyanite.deeperdarker.registry.blocks.entity.DDBlockEntityTypes;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.custom.WardenArmorItem;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod(DeeperAndDarker.MOD_ID)
public class DeeperAndDarkerForge {
    public DeeperAndDarkerForge() {
        DeeperAndDarker.init();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        PlatformHelperImpl.BLOCKS.register(bus);
        PlatformHelperImpl.ITEMS.register(bus);
        PlatformHelperImpl.ENCHANTMENTS.register(bus);
        PlatformHelperImpl.MOB_EFFECTS.register(bus);
        PlatformHelperImpl.SOUND_EVENTS.register(bus);
        PlatformHelperImpl.POTIONS.register(bus);
        PlatformHelperImpl.ENTITY_TYPES.register(bus);
        PlatformHelperImpl.BIOMES.register(bus);
        PlatformHelperImpl.FEATURES.register(bus);
        PlatformHelperImpl.CONFIGURED_FEATURES.register(bus);
        PlatformHelperImpl.PLACED_FEATURES.register(bus);
    }

    @Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class DeeperDarkerClient {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            EntityRenderers.register(DDEntities.SCULK_LEECH, SculkLeechRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_SNAPPER, SculkSnapperRenderer::new);
            EntityRenderers.register(DDEntities.SHATTERED, ShatteredRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_WORM, SculkWormRenderer::new);
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(DDEntities.BOAT, context -> new DDBoatRenderer<>(context, false));
            event.registerEntityRenderer(DDEntities.CHEST_BOAT, context -> new DDBoatRenderer<>(context, true));
        }

        @SubscribeEvent
        public static void entityRenderers(final EntityRenderersEvent.AddLayers event) {
            GeoArmorRenderer.registerArmorRenderer(WardenArmorItem.class, WardenArmorRenderer::new);
        }
    }
}