package com.kyanite.deeperdarker.util.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

public class DDAdvancementProvider extends FabricAdvancementProvider {
    private final HolderLookup.Provider provider;

    public DDAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
        try {
            this.provider = registryLookup.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        String id = "advancements." + DeeperDarker.MOD_ID + ".";

        HolderLookup.RegistryLookup<Biome> biomeLookup = registryLookup.lookupOrThrow(Registries.BIOME);
        HolderLookup.RegistryLookup<Structure> structureLookup = registryLookup.lookupOrThrow(Registries.STRUCTURE);

        AdvancementHolder root = Advancement.Builder.advancement()
                .display(
                        Blocks.SCULK,
                        Component.translatable(id + "root.title"),
                        Component.translatable(id + "root.description"),
                        DeeperDarker.id("textures/gui/advancements/root.png"),
                        AdvancementType.TASK,
                        false,
                        false,
                        false
                ).addCriterion("deep_dark", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeLookup.getOrThrow(Biomes.DEEP_DARK))))
                .save(consumer, path("root"));

        AdvancementHolder findAncientCity = Advancement.Builder.advancement().parent(root)
                .display(
                        Blocks.DEEPSLATE_TILES,
                        Component.translatable(id + "find_ancient_city.title"),
                        Component.translatable(id + "find_ancient_city.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("ancient_city", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inStructure(structureLookup.getOrThrow(BuiltinStructures.ANCIENT_CITY))))
                .rewards(AdvancementRewards.Builder.experience(50))
                .save(consumer, path("find_ancient_city"));

        AdvancementHolder enterOtherside = Advancement.Builder.advancement().parent(findAncientCity)
                .display(
                        DDItems.OTHERSIDE_FIRE_STRIKER,
                        Component.translatable(id + "enter_otherside.title"),
                        Component.translatable(id + "enter_otherside.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("otherside", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(OthersideDimension.OTHERSIDE_LEVEL))
                .save(consumer, path("enter_otherside"));

        AdvancementHolder killWarden = Advancement.Builder.advancement().parent(findAncientCity)
                .display(
                        DDItems.HEART_OF_THE_DEEP,
                        Component.translatable(id + "kill_warden.title"),
                        Component.translatable(id + "kill_warden.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("warden", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.WARDEN)))
                .rewards(AdvancementRewards.Builder.experience(100))
                .save(consumer, path("kill_warden"));

        Advancement.Builder.advancement().parent(enterOtherside)
                .display(
                        DDItems.FIZZ,
                        Component.translatable(id + "fizz.title"),
                        Component.translatable(id + "fizz.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("fizz", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(DDItems.FIZZ).build()))
                .save(consumer, path("fizz"));

        Advancement.Builder.advancement().parent(enterOtherside)
                .display(
                        DDBlocks.DEAD_MANS_CHEST,
                        Component.translatable(id + "open_dead_mans_chest.title"),
                        Component.translatable(id + "open_dead_mans_chest.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("open_dead_mans_chest", DDCriteriaTriggers.openDeadMansChest(Optional.empty()))
                .save(consumer, path("open_dead_mans_chest"));

        AdvancementHolder findAncientTemple = Advancement.Builder.advancement().parent(enterOtherside)
                .display(
                        DDBlocks.CUT_SCULK_STONE,
                        Component.translatable(id + "find_ancient_temple.title"),
                        Component.translatable(id + "find_ancient_temple.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("ancient_temple", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inStructure(structureLookup.getOrThrow(DDStructures.ANCIENT_TEMPLE))))
                .save(consumer, path("find_ancient_temple"));

        Advancement.Builder.advancement().parent(findAncientTemple)
                .display(
                        DDItems.SCULK_TRANSMITTER,
                        Component.translatable(id + "obtain_sculk_transmitter.title"),
                        Component.translatable(id + "obtain_sculk_transmitter.description"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                ).addCriterion("sculk_transmitter", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(DDTags.Items.SCULK_TRANSMITTERS).build()))
                .save(consumer, path("obtain_sculk_transmitter"));

        Advancement.Builder.advancement().parent(enterOtherside)
                .display(
                        DDItems.SONOROUS_STAFF,
                        Component.translatable(id + "obtain_sonorous_staff.title"),
                        Component.translatable(id + "obtain_sonorous_staff.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("sonorous_staff", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.SONOROUS_STAFF))
                .save(consumer, path("obtain_sonorous_staff"));

        Advancement.Builder.advancement().parent(enterOtherside)
                .display(
                        DDItems.WARDEN_BOOTS,
                        Component.translatable(id + "explore_otherside.title"),
                        Component.translatable(id + "explore_otherside.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false)
                .addCriterion("acid_floes", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeLookup.getOrThrow(OthersideBiomes.ACID_FLOES))))
                .addCriterion("deeplands", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeLookup.getOrThrow(OthersideBiomes.DEEPLANDS))))
                .addCriterion("lush_deeplands", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeLookup.getOrThrow(OthersideBiomes.LUSH_DEEPLANDS))))
                .addCriterion("echoing_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeLookup.getOrThrow(OthersideBiomes.ECHOING_FOREST))))
                .addCriterion("blooming_caverns", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeLookup.getOrThrow(OthersideBiomes.BLOOMING_CAVERNS))))
                .addCriterion("overcast_columns", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeLookup.getOrThrow(OthersideBiomes.OVERCAST_COLUMNS))))
                .addCriterion("darklands", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeLookup.getOrThrow(OthersideBiomes.DARKLANDS))))
                .addCriterion("sculk_spruce_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeLookup.getOrThrow(OthersideBiomes.SCULK_SPRUCE_FOREST))))
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(300))
                .save(consumer, path("explore_otherside"));

        AdvancementHolder killBloomingGolem = Advancement.Builder.advancement().parent(enterOtherside)
                .display(
                        DDBlockItems.PATIENCE_SOUL,
                        Component.translatable(id + "kill_blooming_golem.title"),
                        Component.translatable(id + "kill_blooming_golem.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("blooming_golem", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.BLOOMING_GOLEM)))
                .rewards(AdvancementRewards.Builder.experience(50))
                .save(consumer, path("kill_blooming_golem"));

        AdvancementHolder killAllPots = Advancement.Builder.advancement().parent(killBloomingGolem)
                .display(
                        DDBlocks.GLOOMSLATE_BRICKS,
                        Component.translatable(id + "kill_all_pots.title"),
                        Component.translatable(id + "kill_all_pots.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("potty", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.POTTY)))
                .addCriterion("pot", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.POT)))
                .addCriterion("potter", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.POTTER)))
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(50))
                .save(consumer, path("kill_all_pots"));

        AdvancementHolder killOvercastVessel = Advancement.Builder.advancement().parent(killAllPots)
                .display(
                        DDBlockItems.FORTITUDE_SOUL,
                        Component.translatable(id + "kill_overcast_vessel.title"),
                        Component.translatable(id + "kill_overcast_vessel.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("overcast_vessel", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.OVERCAST_VESSEL)))
                .rewards(AdvancementRewards.Builder.experience(50))
                .save(consumer, path("kill_overcast_vessel"));

        AdvancementHolder killOverseer = Advancement.Builder.advancement().parent(killOvercastVessel)
                .display(
                        DDBlockItems.CORRUPTION_SOUL,
                        Component.translatable(id + "kill_overseer.title"),
                        Component.translatable(id + "kill_overseer.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("kill_overseer", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.OVERSEER)))
                .rewards(AdvancementRewards.Builder.experience(50))
                .save(consumer, path("kill_overseer"));

        AdvancementHolder killSculkMillipede = Advancement.Builder.advancement().parent(killOverseer)
                .display(
                        DDBlockItems.VIRTUE_SOUL,
                        Component.translatable(id + "kill_sculk_millipede.title"),
                        Component.translatable(id + "kill_sculk_millipede.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("kill_sculk_millipede", DDCriteriaTriggers.playerKilledWorm(EntityPredicate.Builder.entity().of(DDEntities.SCULK_MILLIPEDE)))
                .rewards(AdvancementRewards.Builder.experience(100))
                .save(consumer, path("kill_sculk_millipede"));

        Advancement.Builder.advancement().parent(killSculkMillipede)
                .display(
                        DDItems.WARDEN_SWORD,
                        Component.translatable(id + "kill_all_otherside_mobs.title"),
                        Component.translatable(id + "kill_all_otherside_mobs.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false)
                .addCriterion("phantom", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.PHANTOM)))
                .addCriterion("warden", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.WARDEN)))
                .addCriterion("angler_fish", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.ANGLER_FISH)))
                .addCriterion("sculk_centipede", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SCULK_CENTIPEDE)))
                .addCriterion("sculk_leech", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SCULK_LEECH)))
                .addCriterion("sculk_snapper", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SCULK_SNAPPER)))
                .addCriterion("shattered", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SHATTERED)))
                .addCriterion("shriek_worm", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SHRIEK_WORM)))
                .addCriterion("stalker", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.STALKER)))
                .addCriterion("sludge", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SLUDGE)))
                .addCriterion("blooming_golem", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.BLOOMING_GOLEM)))
                .addCriterion("potty", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.POTTY)))
                .addCriterion("pot", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.POT)))
                .addCriterion("potter", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.POTTER)))
                .addCriterion("overcast_vessel", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.OVERCAST_VESSEL)))
                .addCriterion("acid_sprite", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.ACID_SPRITE)))
                .addCriterion("overseer", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDTags.EntityTypes.OVERCASTERS)))
                .addCriterion("floater", DDCriteriaTriggers.playerKilledWorm(EntityPredicate.Builder.entity().of(DDEntities.FLOATER)))
                .addCriterion("sculk_millipede", DDCriteriaTriggers.playerKilledWorm(EntityPredicate.Builder.entity().of(DDEntities.SCULK_MILLIPEDE)))
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(200))
                .save(consumer, path("kill_all_otherside_mobs"));

        AdvancementHolder obtainReinforcedEchoShard = Advancement.Builder.advancement().parent(findAncientCity)
                .display(
                        DDItems.REINFORCED_ECHO_SHARD,
                        Component.translatable(id + "obtain_reinforced_echo_shard.title"),
                        Component.translatable(id + "obtain_reinforced_echo_shard.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("reinforced_echo_shard", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.REINFORCED_ECHO_SHARD))
                .save(consumer, path("obtain_reinforced_echo_shard"));

        Advancement.Builder.advancement().parent(obtainReinforcedEchoShard)
                .display(
                        DDItems.WARDEN_CHESTPLATE,
                        Component.translatable(id + "warden_armor.title"),
                        Component.translatable(id + "warden_armor.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                ).addCriterion("warden_armor", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.WARDEN_HELMET, DDItems.WARDEN_CHESTPLATE, DDItems.WARDEN_LEGGINGS, DDItems.WARDEN_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(100))
                .save(consumer, path("warden_armor"));
    }

    private String path(String name) {
        return DeeperDarker.id("main/" + name).toString();
    }
}
