package com.kyanite.deeperdarker.forge;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.client.rendering.entity.*;
import com.kyanite.deeperdarker.config.DDClientConfig;
import com.kyanite.deeperdarker.forge.client.SoulElytraItem;
import com.kyanite.deeperdarker.forge.client.elytra.SoulElytraArmorStandLayer;
import com.kyanite.deeperdarker.forge.client.elytra.SoulElytraLayer;
import com.kyanite.deeperdarker.forge.client.warden_armor.WardenArmorItem;
import com.kyanite.deeperdarker.forge.client.warden_armor.WardenArmorRenderer;
import com.kyanite.deeperdarker.forge.datagen.advancements.DDAdvancementsProvider;
import com.kyanite.deeperdarker.forge.datagen.lang.ENLanguageProvider;
import com.kyanite.deeperdarker.forge.datagen.loot.DDLootTableProvider;
import com.kyanite.deeperdarker.forge.datagen.models.DDBlockStateProvider;
import com.kyanite.deeperdarker.forge.datagen.models.DDItemModelProvider;
import com.kyanite.deeperdarker.forge.datagen.recipes.CraftingRecipesProvider;
import com.kyanite.deeperdarker.forge.datagen.recipes.SmeltingRecipesProvider;
import com.kyanite.deeperdarker.forge.datagen.recipes.StonecuttingRecipesProvider;
import com.kyanite.deeperdarker.forge.datagen.tags.DDBlockTagsProvider;
import com.kyanite.deeperdarker.forge.datagen.tags.DDEntityTypeTagsProvider;
import com.kyanite.deeperdarker.forge.datagen.tags.DDItemTagsProvider;
import com.kyanite.deeperdarker.forge.datagen.tags.DDStructureTagsProvider;
import com.kyanite.deeperdarker.forge.world.DDPoiTypes;
import com.kyanite.deeperdarker.forge.world.biomes.DDBiomeModifiers;
import com.kyanite.deeperdarker.miscellaneous.DDWoodTypes;
import com.kyanite.deeperdarker.platform.forge.RegistryHelperImpl;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.potions.DDPotions;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import com.kyanite.paragon.api.ConfigManager;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Mod(DeeperAndDarker.MOD_ID)
public class DeeperAndDarkerForge {
    public DeeperAndDarkerForge() {
        DeeperAndDarker.init(() -> {
            GeckoLibMod.DISABLE_IN_DEV = true;
            GeckoLib.initialize();
        });

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        RegistryHelperImpl.SOUND_EVENTS.register(bus);
        RegistryHelperImpl.ITEMS.register(bus);
        RegistryHelperImpl.BLOCKS.register(bus);
        RegistryHelperImpl.ENCHANTMENTS.register(bus);
        RegistryHelperImpl.MOB_EFFECTS.register(bus);
        RegistryHelperImpl.POTIONS.register(bus);
        RegistryHelperImpl.ENTITY_TYPES.register(bus);
        RegistryHelperImpl.FEATURES.register(bus);
        RegistryHelperImpl.CONFIGURED_FEATURES.register(bus);
        RegistryHelperImpl.PLACED_FEATURES.register(bus);
        RegistryHelperImpl.BIOMES.register(bus);
        DDBiomeModifiers.BIOME_MODIFIERS.register(bus);
        DDPoiTypes.POI.register(bus);
        RegistryHelperImpl.BLOCK_ENTITIES.register(bus);

        bus.addListener(this::attributes);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void generateData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new ForgeAdvancementProvider(packOutput, CompletableFuture.supplyAsync(VanillaRegistries::createLookup, Util.backgroundExecutor()), fileHelper, List.of(new DDAdvancementsProvider())));

        generator.addProvider(event.includeClient(), new ENLanguageProvider(packOutput, "en_us", false));
        generator.addProvider(event.includeClient(), new ENLanguageProvider(packOutput, "en_ud", true));

        generator.addProvider(event.includeServer(), new DDLootTableProvider(packOutput));

        generator.addProvider(event.includeClient(), new DDBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new DDItemModelProvider(packOutput, fileHelper));

        generator.addProvider(event.includeServer(), new CraftingRecipesProvider(packOutput));
        generator.addProvider(event.includeServer(), new SmeltingRecipesProvider(packOutput));
//        generator.addProvider(event.includeServer(), new SmithingRecipesProvider(packOutput));
        generator.addProvider(event.includeServer(), new StonecuttingRecipesProvider(packOutput));


        DDBlockTagsProvider blockTags = new DDBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DDItemTagsProvider(packOutput, blockTags.contentsGetter(), fileHelper));
        generator.addProvider(event.includeServer(), new DDEntityTypeTagsProvider(packOutput, event.getLookupProvider(), fileHelper));
        generator.addProvider(event.includeServer(), new DDStructureTagsProvider(packOutput, event.getLookupProvider(), fileHelper));

//        generator.addProvider(event.includeServer(), new DDWorldGen(packOutput, event.getLookupProvider()));
    }

    public void attributes(EntityAttributeCreationEvent event) {
        Map<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> attributes = new HashMap<>();
        DeeperAndDarker.attributes(attributes);
        attributes.forEach((entity, builder) -> event.put(entity, builder.build()));
    }

    @Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class DeeperDarkerCommon {
        @SubscribeEvent
        public static void commonSetup(final FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                Sheets.addWoodType(DDWoodTypes.ECHO);
                DeeperAndDarker.spawnPlacements();
            });

            ComposterBlock.COMPOSTABLES.put(DDBlocks.ECHO_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_VINES.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_TENDRILS.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_GLEAM.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.GLOOM_SCULK.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.GLOOM_CACTUS.get().asItem(), 0.4f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.GLOOMY_GRASS.get().asItem(), 0.2f);

            PotionBrewing.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.SCULK_AFFINITY.get());
            PotionBrewing.addMix(DDPotions.SCULK_AFFINITY.get(), Items.REDSTONE, DDPotions.LONG_SCULK_AFFINITY.get());
        }
    }

    @Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class DeeperDarkerClient {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            ConfigManager.register("deeperdarker", new DDClientConfig());

            WoodType.register(DDWoodTypes.ECHO);
            EntityRenderers.register(DDEntities.SCULK_CENTIPEDE.get(), CentipedeRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_LEECH.get(), SculkLeechRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
            EntityRenderers.register(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_WORM.get(), SculkWormRenderer::new);
            EntityRenderers.register(DDEntities.STALKER.get(), StalkerRenderer::new);

            ItemProperties.register(DDItems.SOUL_ELYTRA.get(), new ResourceLocation(DeeperAndDarker.MOD_ID, "broken"),
                    (stack, arg1, arg2, arg3) -> SoulElytraItem.isUseable(stack) ? 0 : 1);
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(DDEntities.SHRIEK_PROJECTILE.get(), context -> new ShriekRenderer<>(context));
            event.registerEntityRenderer(DDEntities.BOAT.get(), context -> new DDBoatRenderer<>(context, false));
            event.registerEntityRenderer(DDEntities.CHEST_BOAT.get(), context -> new DDBoatRenderer<>(context, true));

           // event.registerBlockEntityRenderer(DDBlockEntityTypes.DEEPSLATE_CHEST.get(), AncientChestRenderer::new);
          //  event.registerBlockEntityRenderer(DDBlockEntityTypes.ANCIENT_CHEST.get(), AncientChestRenderer::new);
        }

        @SubscribeEvent
        public static void entityRenderers(final EntityRenderersEvent.AddLayers event) {
            GeoArmorRenderer.registerArmorRenderer(WardenArmorItem.class, WardenArmorRenderer::new);

            EntityModelSet entityModels = event.getEntityModels();
            event.getSkins().forEach(s -> {
                LivingEntityRenderer<? extends Player, ? extends EntityModel<? extends Player>> livingEntityRenderer = event.getSkin(s);
                if(livingEntityRenderer instanceof PlayerRenderer playerRenderer){
                    playerRenderer.addLayer(new SoulElytraLayer(playerRenderer, entityModels));
                }
            });
            LivingEntityRenderer<ArmorStand, ? extends EntityModel<ArmorStand>> livingEntityRenderer = event.getRenderer(EntityType.ARMOR_STAND);
            if(livingEntityRenderer instanceof ArmorStandRenderer armorStandRenderer){
                armorStandRenderer.addLayer(new SoulElytraArmorStandLayer(armorStandRenderer, entityModels));
            }

        }
    }


    @Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID)
    public static class DeeperDarkerEvents {
        @SubscribeEvent
        public static void playerTick(final TickEvent.PlayerTickEvent event) {
            if(!event.player.level.isClientSide()) {
                if(event.player.getLevel().dimension() == DDDimensions.OTHERSIDE_LEVEL) {
                    if(!event.player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(DDItems.WARDEN_HELMET.get()) && !event.player.isCreative() && !event.player.isSpectator()) {
                        event.player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 25, 0));
                    }
                }
            }
        }
    }
}
