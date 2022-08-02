package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.api.EntityState;
import com.kyanite.deeperdarker.client.rendering.entity.SculkSnapperRenderer;
import com.kyanite.deeperdarker.client.rendering.entity.SculkWormRenderer;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.entity.DDBlockEntityTypes;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.world.biomes.OthersideBiomes;
import com.kyanite.deeperdarker.registry.world.features.DDConfiguredFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDPlacedFeatures;
import com.kyanite.deeperdarker.util.DDPoiTypes;
import com.kyanite.deeperdarker.util.DDWoodTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

@Mod(DeeperAndDarker.MOD_ID)
public class DeeperAndDarker {
    public static final String MOD_ID = "deeperdarker";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DeeperAndDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDBlocks.BLOCKS.register(eventBus);
        DDItems.ITEMS.register(eventBus);
        DDBlockEntityTypes.register(eventBus);
        OthersideBiomes.BIOMES.register(eventBus);
        DDConfiguredFeatures.CONFIGURED_FEATURES.register(eventBus);
        DDEntities.ENTITY_TYPES.register(eventBus);
        DDFeatures.FEATURES.register(eventBus);
        DDPlacedFeatures.PLACED_FEATURES.register(eventBus);
        DDPoiTypes.POI.register(eventBus);

        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class DeeperAndDarkerClient {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            WoodType.register(DDWoodTypes.BONE);
            WoodType.register(DDWoodTypes.SCULK_BONE);
            BlockEntityRenderers.register(DDBlockEntityTypes.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);

            EntityRenderers.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_WORM.get(), SculkWormRenderer::new);
        }

        @SubscribeEvent
        public static void commonSetup(final FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                Sheets.addWoodType(DDWoodTypes.BONE);
                Sheets.addWoodType(DDWoodTypes.SCULK_BONE);
            });
        }
    }
}