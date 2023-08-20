package com.kyanite.deeperdarker.util.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.kyanite.deeperdarker.world.structures.DDStructures;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;

import java.util.function.Consumer;

public class DDAdvancements implements Consumer<Consumer<Advancement>> {
    @Override
    public void accept(Consumer<Advancement> advancementConsumer) {
        String id = "advancements." + DeeperDarker.MOD_ID + ".";

        Advancement root = Advancement.Builder.advancement()
                .display(
                        Blocks.SCULK,
                        Component.translatable(id + "root.title"),
                        Component.translatable(id + "root.description"),
                        new ResourceLocation(DeeperDarker.MOD_ID, "textures/gui/advancements/root.png"),
                        FrameType.TASK,
                        false,
                        false,
                        false
                ).addCriterion("deep_dark", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(Biomes.DEEP_DARK)))
                .save(advancementConsumer, path("root"));

        Advancement findAncientCity = Advancement.Builder.advancement().parent(root)
                .display(
                        Blocks.DEEPSLATE_TILES,
                        Component.translatable(id + "find_ancient_city.title"),
                        Component.translatable(id + "find_ancient_city.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false
                ).addCriterion("ancient_city", PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(BuiltinStructures.ANCIENT_CITY)))
                .rewards(AdvancementRewards.Builder.experience(50))
                .save(advancementConsumer, path("find_ancient_city"));

        Advancement killWarden = Advancement.Builder.advancement().parent(findAncientCity)
                .display(
                        DDItems.HEART_OF_THE_DEEP,
                        Component.translatable(id + "kill_warden.title"),
                        Component.translatable(id + "kill_warden.description"),
                        null,
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false
                ).addCriterion("warden", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.WARDEN)))
                .rewards(AdvancementRewards.Builder.experience(100))
                .save(advancementConsumer, path("kill_warden"));

        Advancement enterOtherside = Advancement.Builder.advancement().parent(killWarden)
                .display(
                        Blocks.REINFORCED_DEEPSLATE,
                        Component.translatable(id + "enter_otherside.title"),
                        Component.translatable(id + "enter_otherside.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false
                ).addCriterion("otherside", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(OthersideDimension.OTHERSIDE_LEVEL))
                .save(advancementConsumer, path("enter_otherside"));

        Advancement findAncientTemple = Advancement.Builder.advancement().parent(enterOtherside)
                .display(
                        DDBlocks.CUT_SCULK_STONE,
                        Component.translatable(id + "find_ancient_temple.title"),
                        Component.translatable(id + "find_ancient_temple.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false
                ).addCriterion("ancient_temple", PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(DDStructures.ANCIENT_TEMPLE)))
                .rewards(AdvancementRewards.Builder.experience(50))
                .save(advancementConsumer, path("find_ancient_temple"));

        Advancement.Builder.advancement().parent(findAncientTemple)
                .display(
                        DDItems.SCULK_TRANSMITTER,
                        Component.translatable(id + "obtain_sculk_transmitter.title"),
                        Component.translatable(id + "obtain_sculk_transmitter.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("sculk_transmitter", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.SCULK_TRANSMITTER))
                .save(advancementConsumer, path("obtain_sculk_transmitter"));

        Advancement.Builder.advancement().parent(enterOtherside)
                .display(
                        DDItems.WARDEN_BOOTS,
                        Component.translatable(id + "explore_otherside.title"),
                        Component.translatable(id + "explore_otherside.description"),
                        null,
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false)
                .addCriterion("deeplands", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(OthersideBiomes.DEEPLANDS)))
                .addCriterion("echoing_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(OthersideBiomes.ECHOING_FOREST)))
                .addCriterion("overcast_columns", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(OthersideBiomes.OVERCAST_COLUMNS)))
                .requirements(RequirementsStrategy.AND)
                .rewards(AdvancementRewards.Builder.experience(300))
                .save(advancementConsumer, path("explore_otherside"));

        Advancement obtainReinforcedEchoShard = Advancement.Builder.advancement().parent(killWarden)
                .display(
                        DDItems.REINFORCED_ECHO_SHARD,
                        Component.translatable(id + "obtain_reinforce_echo_shard.title"),
                        Component.translatable(id + "obtain_reinforce_echo_shard.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("reinforce_echo_shard", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.REINFORCED_ECHO_SHARD))
                .save(advancementConsumer, path("obtain_reinforce_echo_shard"));

        Advancement.Builder.advancement().parent(obtainReinforcedEchoShard)
                .display(
                        DDItems.WARDEN_CHESTPLATE,
                        Component.translatable(id + "warden_armor.title"),
                        Component.translatable(id + "warden_armor.description"),
                        null,
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false
                ).addCriterion("warden_armor", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.WARDEN_HELMET, DDItems.WARDEN_CHESTPLATE, DDItems.WARDEN_LEGGINGS, DDItems.WARDEN_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(100))
                .save(advancementConsumer, path("warden_armor"));
    }

    private String path(String name) {
        return new ResourceLocation(DeeperDarker.MOD_ID, "main/" + name).toString();
    }
}
