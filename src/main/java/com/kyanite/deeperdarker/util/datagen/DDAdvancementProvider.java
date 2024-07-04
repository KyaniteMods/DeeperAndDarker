package com.kyanite.deeperdarker.util.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.kyanite.deeperdarker.world.structures.DDStructures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class DDAdvancementProvider extends FabricAdvancementProvider {
    public DDAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        String id = "advancements." + DeeperDarker.MOD_ID + ".";
        HolderLookup.RegistryLookup<Biome> biomeHolderGetter = registryLookup.lookupOrThrow(Registries.BIOME);
        HolderLookup.RegistryLookup<Structure> structureHolderGetter = registryLookup.lookupOrThrow(Registries.STRUCTURE);

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
                ).addCriterion("deep_dark", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeHolderGetter.getOrThrow(Biomes.DEEP_DARK))))
                .save(consumer, path("root"));

        AdvancementHolder findAncientCity = Advancement.Builder.advancement().parent(root)
                .display(
                        Blocks.DEEPSLATE_TILES,
                        Component.translatable(id + "find_ancient_city.title"),
                        Component.translatable(id + "find_ancient_city.description"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                ).addCriterion("ancient_city", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inStructure(structureHolderGetter.getOrThrow(BuiltinStructures.ANCIENT_CITY))))
                .rewards(AdvancementRewards.Builder.experience(50))
                .save(consumer, path("find_ancient_city"));

        AdvancementHolder killWarden = Advancement.Builder.advancement().parent(findAncientCity)
                .display(
                        DDItems.HEART_OF_THE_DEEP,
                        Component.translatable(id + "kill_warden.title"),
                        Component.translatable(id + "kill_warden.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                ).addCriterion("warden", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.WARDEN)))
                .rewards(AdvancementRewards.Builder.experience(100))
                .save(consumer, path("kill_warden"));

        AdvancementHolder enterOtherside = Advancement.Builder.advancement().parent(killWarden)
                .display(
                        Blocks.REINFORCED_DEEPSLATE,
                        Component.translatable(id + "enter_otherside.title"),
                        Component.translatable(id + "enter_otherside.description"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                ).addCriterion("otherside", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(OthersideDimension.OTHERSIDE_LEVEL))
                .save(consumer, path("enter_otherside"));

        AdvancementHolder findAncientTemple = Advancement.Builder.advancement().parent(enterOtherside)
                .display(
                        DDBlocks.CUT_SCULK_STONE,
                        Component.translatable(id + "find_ancient_temple.title"),
                        Component.translatable(id + "find_ancient_temple.description"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                ).addCriterion("ancient_temple", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inStructure(structureHolderGetter.getOrThrow(DDStructures.ANCIENT_TEMPLE))))
                .rewards(AdvancementRewards.Builder.experience(50))
                .save(consumer, path("find_ancient_temple"));

        Advancement.Builder.advancement().parent(findAncientTemple)
                .display(
                        DDItems.SCULK_TRANSMITTER,
                        Component.translatable(id + "obtain_sculk_transmitter.title"),
                        Component.translatable(id + "obtain_sculk_transmitter.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("sculk_transmitter", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.SCULK_TRANSMITTER))
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
                .addCriterion("deeplands", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeHolderGetter.getOrThrow(OthersideBiomes.DEEPLANDS))))
                .addCriterion("echoing_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeHolderGetter.getOrThrow(OthersideBiomes.ECHOING_FOREST))))
                .addCriterion("blooming_caverns", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeHolderGetter.getOrThrow(OthersideBiomes.BLOOMING_CAVERNS))))
                .addCriterion("overcast_columns", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeHolderGetter.getOrThrow(OthersideBiomes.OVERCAST_COLUMNS))))
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(300))
                .save(consumer, path("explore_otherside"));

        Advancement.Builder.advancement().parent(enterOtherside)
                .display(
                        DDItems.WARDEN_SWORD,
                        Component.translatable(id + "kill_all_sculk_mobs.title"),
                        Component.translatable(id + "kill_all_sculk_mobs.description"),
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
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(100))
                .save(consumer, path("kill_all_sculk_mobs"));

        AdvancementHolder obtainReinforcedEchoShard = Advancement.Builder.advancement().parent(killWarden)
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
