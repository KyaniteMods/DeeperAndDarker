package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.entities.*;
import com.kyanite.deeperdarker.datagen.assets.DDBlockStateProvider;
import com.kyanite.deeperdarker.datagen.assets.DDItemModelProvider;
import com.kyanite.deeperdarker.datagen.assets.DDSoundDefinitions;
import com.kyanite.deeperdarker.datagen.assets.ENLanguageProvider;
import com.kyanite.deeperdarker.datagen.data.DDAdvancements;
import com.kyanite.deeperdarker.datagen.data.DDBlockTagsProvider;
import com.kyanite.deeperdarker.datagen.data.DDItemTagsProvider;
import com.kyanite.deeperdarker.datagen.data.DDRecipeProvider;
import com.kyanite.deeperdarker.datagen.data.loot.DDLootModifierProvider;
import com.kyanite.deeperdarker.datagen.data.loot.DDLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("unused")
@Mod(DeeperDarker.MOD_ID)
public class DeeperDarker {
    public static final String MOD_ID = "deeperdarker";

    public DeeperDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDItems.ITEMS.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDEntities.ENTITIES.register(eventBus);
        DDBlockEntities.BLOCK_ENTITIES.register(eventBus);
        DDEnchantments.ENCHANTMENTS.register(eventBus);
        DDLootModifiers.LOOT_MODIFIERS.register(eventBus);
        DDSounds.SOUND_EVENTS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::generateData);
        eventBus.addListener(this::registerAttributes);
        eventBus.addListener(this::registerSpawnPlacements);
    }

    private void generateData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // assets
        generator.addProvider(event.includeClient(), new ENLanguageProvider(generator));
        generator.addProvider(event.includeClient(), new DDBlockStateProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new DDItemModelProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new DDSoundDefinitions(generator, fileHelper));

        // data
        DDBlockTagsProvider blockTags = new DDBlockTagsProvider(generator, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DDItemTagsProvider(generator, blockTags, fileHelper));

        generator.addProvider(event.includeServer(), new DDAdvancements(generator, fileHelper));
        generator.addProvider(event.includeServer(), new DDLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new DDLootModifierProvider(generator));
        generator.addProvider(event.includeServer(), new DDRecipeProvider(generator));
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
            if(!event.getState().is(DDBlocks.ANCIENT_VASE.get())) return;
            if(event.getPlayer().getMainHandItem().getEnchantmentLevel(Enchantments.SILK_TOUCH) > 0) return;

            if(event.getLevel() instanceof ServerLevel level) {
                RandomSource random = level.getRandom();
                if(random.nextFloat() < 0.1f) {
                    if(random.nextFloat() < 0.953f) {
                        for(int i = 0; i < random.nextInt(1, 4); i++) {
                            DDEntities.SCULK_LEECH.get().spawn(level, null, null, null, event.getPos(), MobSpawnType.TRIGGERED, false, false);
                        }
                    } else {
                        DDEntities.STALKER.get().spawn(level, null, null, null, event.getPos(), MobSpawnType.TRIGGERED, false, false);
                    }
                }
            }
        }
    }
}
