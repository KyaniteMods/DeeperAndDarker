package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

@SuppressWarnings("NullableProblems")
public class DDAdvancements extends AdvancementProvider {
    public DDAdvancements(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, existingFileHelper);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {
        String id = "advancements." + DeeperDarker.MOD_ID + ".";

        Advancement root = Advancement.Builder.advancement().display(Blocks.SCULK, Component.translatable(id + "root.title"), Component.translatable(id + "root.description"), new ResourceLocation(DeeperDarker.MOD_ID, "textures/gui/advancements/root.png"), FrameType.TASK, false, false, false)
                .addCriterion("deep_dark", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(Biomes.DEEP_DARK))).save(consumer, path("root"));

        Advancement findAncientCity = Advancement.Builder.advancement().parent(root).display(Blocks.DEEPSLATE_TILES, Component.translatable(id + "find_ancient_city.title"), Component.translatable(id + "find_ancient_city.description"), null, FrameType.GOAL, true, true, false)
                .addCriterion("ancient_city", PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(BuiltinStructures.ANCIENT_CITY)))
                .rewards(AdvancementRewards.Builder.experience(50)).save(consumer, path("find_ancient_city"));

        Advancement killWarden = Advancement.Builder.advancement().parent(findAncientCity).display(DDItems.HEART_OF_THE_DEEP.get(), Component.translatable(id + "kill_warden.title"), Component.translatable(id + "kill_warden.description"), null, FrameType.CHALLENGE, true, true, false)
                .addCriterion("warden", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.WARDEN)))
                .rewards(AdvancementRewards.Builder.experience(100)).save(consumer, path("kill_warden"));

        /*Advancement enterOtherside = Advancement.Builder.advancement().parent(killWarden).display(Blocks.REINFORCED_DEEPSLATE, Component.translatable(id + "enter_otherside.title"), Component.translatable(id + "enter_otherside.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("otherside", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(OthersideDimension.OTHERSIDE_LEVEL)).save(consumer, path("enter_otherside"));

        Advancement findAncientTemple = Advancement.Builder.advancement().parent(enterOtherside).display(DDBlocks.CUT_SCULK_STONE.get(), Component.translatable(id + "find_ancient_temple.title"), Component.translatable(id + "find_ancient_temple.description"), null, FrameType.GOAL, true, true, false)
                .addCriterion("ancient_temple", PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(DDStructures.ANCIENT_TEMPLE.getKey())))
                .rewards(AdvancementRewards.Builder.experience(50)).save(consumer, path("find_ancient_temple"));

        Advancement.Builder.advancement().parent(findAncientTemple).display(DDItems.SCULK_TRANSMITTER.get(), Component.translatable(id + "obtain_sculk_transmitter.title"), Component.translatable(id + "obtain_sculk_transmitter.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("sculk_transmitter", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.SCULK_TRANSMITTER.get())).save(consumer, path("obtain_sculk_transmitter"));

        Advancement.Builder.advancement().parent(enterOtherside).display(DDItems.WARDEN_BOOTS.get(), Component.translatable(id + "explore_otherside.title"), Component.translatable(id + "explore_otherside.description"), null, FrameType.CHALLENGE, true, true, false)
                .addCriterion("deeplands", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(OthersideBiomes.DEEPLANDS.getKey())))
                .addCriterion("echoing_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(OthersideBiomes.ECHOING_FOREST.getKey())))
                .addCriterion("overcast_columns", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(OthersideBiomes.OVERCAST_COLUMNS.getKey())))
                .requirements(RequirementsStrategy.AND).rewards(AdvancementRewards.Builder.experience(300)).save(consumer, path("explore_otherside"));

        Advancement.Builder.advancement().parent(enterOtherside).display(DDItems.WARDEN_SWORD.get(), Component.translatable(id + "kill_all_sculk_mobs.title"), Component.translatable(id + "kill_all_sculk_mobs.description"), null, FrameType.CHALLENGE, true, true, false)
                .addCriterion("phantom", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.PHANTOM)))
                .addCriterion("warden", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.WARDEN)))
                .addCriterion("sculk_centipede", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SCULK_CENTIPEDE.get())))
                .addCriterion("sculk_leech", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SCULK_LEECH.get())))
                .addCriterion("sculk_snapper", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SCULK_SNAPPER.get())))
                .addCriterion("shattered", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SHATTERED.get())))
                .addCriterion("shriek_worm", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SHRIEK_WORM.get())))
                .addCriterion("stalker", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.STALKER.get())))
                .requirements(RequirementsStrategy.AND).rewards(AdvancementRewards.Builder.experience(100)).save(consumer, path("kill_all_sculk_mobs"));

        Advancement obtainReinforcedEchoShard = Advancement.Builder.advancement().parent(killWarden).display(DDItems.REINFORCED_ECHO_SHARD.get(), Component.translatable(id + "obtain_reinforce_echo_shard.title"), Component.translatable(id + "obtain_reinforce_echo_shard.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("reinforce_echo_shard", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.REINFORCED_ECHO_SHARD.get())).save(consumer, path("obtain_reinforce_echo_shard"));

        Advancement.Builder.advancement().parent(obtainReinforcedEchoShard).display(DDItems.WARDEN_CHESTPLATE.get(), Component.translatable(id + "warden_armor.title"), Component.translatable(id + "warden_armor.description"), null, FrameType.CHALLENGE, true, true, false)
                .addCriterion("warden_armor", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.WARDEN_HELMET.get(), DDItems.WARDEN_CHESTPLATE.get(), DDItems.WARDEN_LEGGINGS.get(), DDItems.WARDEN_BOOTS.get()))
                .rewards(AdvancementRewards.Builder.experience(100)).save(consumer, path("warden_armor"));*/
    }

    private String path(String name) {
        return DeeperDarker.MOD_ID + ":main/" + name;
    }
}
