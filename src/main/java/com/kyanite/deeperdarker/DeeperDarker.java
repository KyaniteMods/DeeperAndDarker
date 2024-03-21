package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.Keybinds;
import com.kyanite.deeperdarker.client.model.*;
import com.kyanite.deeperdarker.client.render.*;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import com.kyanite.deeperdarker.content.blocks.entity.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.entities.*;
import com.kyanite.deeperdarker.content.items.SoulElytraItem;
import com.kyanite.deeperdarker.datagen.assets.DDBlockStateProvider;
import com.kyanite.deeperdarker.datagen.assets.DDItemModelProvider;
import com.kyanite.deeperdarker.datagen.assets.DDSoundDefinitions;
import com.kyanite.deeperdarker.datagen.assets.ENLanguageProvider;
import com.kyanite.deeperdarker.datagen.data.*;
import com.kyanite.deeperdarker.datagen.data.loot.DDLootModifierProvider;
import com.kyanite.deeperdarker.datagen.data.loot.DDLootTableProvider;
import com.kyanite.deeperdarker.network.Messages;
import com.kyanite.deeperdarker.network.SoulElytraBoostPacket;
import com.kyanite.deeperdarker.network.SoulElytraClientPacket;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.util.DeeperDarkerConfig;
import com.kyanite.deeperdarker.world.DDFeatures;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.PacketDistributor;

import java.util.List;

@SuppressWarnings("unused")
@Mod(DeeperDarker.MOD_ID)
public class DeeperDarker {
    public static final String MOD_ID = "deeperdarker";

    public DeeperDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDCreativeTab.CREATIVE_MODE_TABS.register(eventBus);
        DDItems.ITEMS.register(eventBus);
        DDSounds.SOUND_EVENTS.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDBlockEntities.BLOCK_ENTITIES.register(eventBus);
        DDEntities.ENTITIES.register(eventBus);
        DDEffects.EFFECTS.register(eventBus);
        DDPotions.POTIONS.register(eventBus);
        DDEnchantments.ENCHANTMENTS.register(eventBus);
        DDFeatures.FEATURES.register(eventBus);
        OthersideDimension.POI.register(eventBus);
        DDLootModifiers.LOOT_MODIFIERS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(DDCreativeTab::buildCreativeTab);
        eventBus.addListener(DeeperDarkerConfig::loadConfigs);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::generateData);
        eventBus.addListener(this::registerAttributes);
        eventBus.addListener(this::registerSpawnPlacements);

        Messages.registerMessages(MOD_ID + "_network");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DeeperDarkerConfig.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DDBlocks.ECHO_SAPLING.getId(), DDBlocks.POTTED_ECHO_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DDBlocks.BLOOMING_STEM.getId(), DDBlocks.POTTED_BLOOMING_STEM);
        });

        PotionBrewing.addMix(Potions.AWKWARD, DDItems.SOUL_CRYSTAL.get(), DDPotions.SCULK_AFFINITY.get());
        PotionBrewing.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.SCULK_AFFINITY.get());
        PotionBrewing.addMix(DDPotions.SCULK_AFFINITY.get(), Items.REDSTONE, DDPotions.LONG_SCULK_AFFINITY.get());
        PotionBrewing.addMix(Potions.LONG_INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.LONG_SCULK_AFFINITY.get());
    }

    private void generateData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // assets
        generator.addProvider(event.includeClient(), new ENLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new DDBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new DDItemModelProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new DDSoundDefinitions(packOutput, fileHelper));

        // data
        DDBlockTagsProvider blockTags = new DDBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DDItemTagsProvider(packOutput, event.getLookupProvider(), blockTags, fileHelper));

        generator.addProvider(event.includeServer(), new ForgeAdvancementProvider(packOutput, event.getLookupProvider(), fileHelper, List.of(new DDAdvancements())));
        generator.addProvider(event.includeServer(), new DDRegistriesGenerator(packOutput, event.getLookupProvider()));
        generator.addProvider(event.includeServer(), new DDLootTableProvider(packOutput));
        generator.addProvider(event.includeServer(), new DDLootModifierProvider(packOutput));
        generator.addProvider(event.includeServer(), new DDRecipeProvider(packOutput));
    }

    private void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(DDEntities.SCULK_CENTIPEDE.get(), SculkCentipede.createAttributes());
        event.put(DDEntities.SCULK_LEECH.get(), SculkLeech.createAttributes());
        event.put(DDEntities.SCULK_SNAPPER.get(), SculkSnapper.createAttributes());
        event.put(DDEntities.SHATTERED.get(), Shattered.createAttributes());
        event.put(DDEntities.SHRIEK_WORM.get(), ShriekWorm.createAttributes());
        event.put(DDEntities.STALKER.get(), Stalker.createAttributes());
    }

    private void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(DDEntities.SCULK_CENTIPEDE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(DDEntities.SCULK_SNAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(DDEntities.SHATTERED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class DeeperDarkerEvents {
        @SubscribeEvent
        public static void breakEvent(final BlockEvent.BreakEvent event) {
            boolean silktouch = event.getPlayer().getMainHandItem().getEnchantmentLevel(Enchantments.SILK_TOUCH) > 0;
            Level level = (Level) event.getLevel();
            BlockState state = event.getState();
            BlockPos pos = event.getPos();

            if(state.is(DDBlocks.CRYSTALLIZED_AMBER.get()) && level.getBlockEntity(pos) instanceof CrystallizedAmberBlockEntity blockEntity) {
                if(!silktouch && state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                    if(blockEntity.fossilizedEntity && level instanceof ServerLevel serverLevel) DDEntities.SCULK_LEECH.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                    else Block.popResource(level, pos, blockEntity.getLoot());
                } else if(silktouch && !level.isClientSide() && state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                    CompoundTag tag = new CompoundTag();
                    tag.put("item", blockEntity.getLoot().save(new CompoundTag()));
                    tag.putBoolean("leech", blockEntity.fossilizedEntity);
                    tag.putFloat("rotation", blockEntity.rotation);

                    ItemStack stack = new ItemStack(DDBlocks.CRYSTALLIZED_AMBER.get());
                    BlockItem.setBlockEntityData(stack, DDBlockEntities.CRYSTALLIZED_AMBER.get(), tag);
                    Block.popResource(level, pos, stack);

                    level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                return;
            }

            if(silktouch) return;

            if(state.is(DDBlocks.ANCIENT_VASE.get())) {
                if(level instanceof ServerLevel serverLevel) {
                    RandomSource random = serverLevel.getRandom();
                    if(random.nextDouble() < DeeperDarkerConfig.fakeVaseChance) {
                        if(random.nextDouble() < 1 - DeeperDarkerConfig.stalkerSpawnChance) {
                            for(int i = 0; i < random.nextInt(1, 4); i++) {
                                DDEntities.SCULK_LEECH.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                            }
                        } else {
                            DDEntities.STALKER.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                        }
                        serverLevel.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                }
            }
        }

        @SubscribeEvent
        public static void equipmentChangeEvent(final LivingEquipmentChangeEvent event) {
            if(!event.getSlot().isArmor()) return;
            if(!event.getTo().is(DDItems.SOUL_ELYTRA.get()) || event.getFrom().is(DDItems.SOUL_ELYTRA.get())) return;
            if(event.getEntity() instanceof ServerPlayer player) Messages.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new SoulElytraClientPacket());
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class DeeperDarkerClient {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                Sheets.addWoodType(DDBlocks.ECHO);
                Sheets.addWoodType(DDBlocks.BLOOM);
                ItemProperties.register(DDItems.SOUL_ELYTRA.get(), new ResourceLocation("broken"), (pStack, pLevel, pEntity, pSeed) -> SoulElytraItem.isFlyEnabled(pStack) ? 0 : 1);
                ItemProperties.register(DDItems.SCULK_TRANSMITTER.get(), new ResourceLocation(MOD_ID, "linked"), (pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() && pStack.getTag().contains("blockPos") ? 1 : 0);
            });

            BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_SIGNS.get(), SignRenderer::new);
            BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_HANGING_SIGNS.get(), HangingSignRenderer::new);
            EntityRenderers.register(DDEntities.BOAT.get(), (context) -> new DDBoatRenderer(context, false));
            EntityRenderers.register(DDEntities.CHEST_BOAT.get(), (context) -> new DDBoatRenderer(context, true));
            EntityRenderers.register(DDEntities.SCULK_CENTIPEDE.get(), SculkCentipedeRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_LEECH.get(), SculkLeechRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
            EntityRenderers.register(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
            EntityRenderers.register(DDEntities.SHRIEK_WORM.get(), ShriekWormRenderer::new);
            EntityRenderers.register(DDEntities.STALKER.get(), StalkerRenderer::new);
        }

        @SubscribeEvent
        public static void registerKeybinds(final RegisterKeyMappingsEvent event) {
            event.register(Keybinds.BOOST);
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(DDBlockEntities.CRYSTALLIZED_AMBER.get(), CrystallizedAmberBlockRenderer::new);
        }

        @SubscribeEvent
        public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(DDBoatRenderer.ECHO_BOAT_MODEL, BoatModel::createBodyModel);
            event.registerLayerDefinition(DDBoatRenderer.ECHO_CHEST_BOAT_MODEL, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(DDBoatRenderer.BLOOM_BOAT_MODEL, BoatModel::createBodyModel);
            event.registerLayerDefinition(DDBoatRenderer.BLOOM_CHEST_BOAT_MODEL, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(SculkCentipedeRenderer.MODEL, SculkCentipedeModel::createBodyModel);
            event.registerLayerDefinition(SculkLeechRenderer.MODEL, SculkLeechModel::createBodyModel);
            event.registerLayerDefinition(SculkSnapperRenderer.MODEL, SculkSnapperModel::createBodyModel);
            event.registerLayerDefinition(ShatteredRenderer.MODEL, ShatteredModel::createBodyModel);
            event.registerLayerDefinition(ShriekWormRenderer.MODEL, ShriekWormModel::createBodyModel);
            event.registerLayerDefinition(StalkerRenderer.MODEL, StalkerModel::createBodyModel);
            event.registerLayerDefinition(WardenHelmetRenderer.MODEL, WardenHelmetModel::createBodyModel);
        }

        @SubscribeEvent
        public static void addLayers(final EntityRenderersEvent.AddLayers event) {
            event.getSkins().forEach(name -> {
                if(event.getSkin(name) instanceof PlayerRenderer renderer) {
                    renderer.addLayer(new SoulElytraRenderer<>(renderer, event.getEntityModels()));
                    renderer.addLayer(new WardenHelmetRenderer<>(renderer, event.getEntityModels()));
                }
            });
            if(event.getRenderer(EntityType.ARMOR_STAND) instanceof ArmorStandRenderer renderer) {
                renderer.addLayer(new SoulElytraRenderer<>(renderer, event.getEntityModels()));
                renderer.addLayer(new WardenHelmetRenderer<>(renderer, event.getEntityModels()));
            }
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class DeeperDarkerForgeClient {
        @SubscribeEvent
        public static void keyInput(final InputEvent.Key event) {
            if(Keybinds.BOOST.consumeClick()) Messages.INSTANCE.sendToServer(new SoulElytraBoostPacket());
        }
    }
}
