package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.kyanite.deeperdarker.world.structures.DDStructures;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

@SuppressWarnings("NullableProblems")
public class DDAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        String id = "advancements." + DeeperDarker.MOD_ID + ".";

        Advancement root = Advancement.Builder.advancement().display(Blocks.SCULK, Component.translatable(id + "root.title"), Component.translatable(id + "root.description"), new ResourceLocation(DeeperDarker.MOD_ID, "textures/gui/advancements/root.png"), FrameType.TASK, false, false, false)
                .addCriterion("deep_dark", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(Biomes.DEEP_DARK))).save(saver, path("root"), existingFileHelper);

        Advancement findAncientCity = Advancement.Builder.advancement().parent(root).display(Blocks.DEEPSLATE_TILES, Component.translatable(id + "find_ancient_city.title"), Component.translatable(id + "find_ancient_city.description"), null, FrameType.GOAL, true, true, false)
                .addCriterion("ancient_city", PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(BuiltinStructures.ANCIENT_CITY)))
                .rewards(AdvancementRewards.Builder.experience(50)).save(saver, path("find_ancient_city"), existingFileHelper);

        Advancement killWarden = Advancement.Builder.advancement().parent(findAncientCity).display(DDItems.HEART_OF_THE_DEEP.get(), Component.translatable(id + "kill_warden.title"), Component.translatable(id + "kill_warden.description"), null, FrameType.CHALLENGE, true, true, false)
                .addCriterion("warden", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.WARDEN)))
                .rewards(AdvancementRewards.Builder.experience(100)).save(saver, path("kill_warden"), existingFileHelper);

        Advancement enterOtherside = Advancement.Builder.advancement().parent(killWarden).display(Blocks.REINFORCED_DEEPSLATE, Component.translatable(id + "enter_otherside.title"), Component.translatable(id + "enter_otherside.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("otherside", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(OthersideDimension.OTHERSIDE_LEVEL)).save(saver, path("enter_otherside"), existingFileHelper);

        Advancement findAncientTemple = Advancement.Builder.advancement().parent(enterOtherside).display(DDBlocks.CUT_SCULK_STONE.get(), Component.translatable(id + "find_ancient_temple.title"), Component.translatable(id + "find_ancient_temple.description"), null, FrameType.GOAL, true, true, false)
                .addCriterion("ancient_temple", PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(DDStructures.ANCIENT_TEMPLE)))
                .rewards(AdvancementRewards.Builder.experience(50)).save(saver, path("find_ancient_temple"), existingFileHelper);

        Advancement.Builder.advancement().parent(findAncientTemple).display(DDItems.SCULK_TRANSMITTER.get(), Component.translatable(id + "obtain_sculk_transmitter.title"), Component.translatable(id + "obtain_sculk_transmitter.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("sculk_transmitter", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.SCULK_TRANSMITTER.get())).save(saver, path("obtain_sculk_transmitter"), existingFileHelper);

        Advancement.Builder.advancement().parent(enterOtherside).display(DDItems.SONOROUS_STAFF.get(), Component.translatable(id + "obtain_warden_staff.title"), Component.translatable(id + "obtain_warden_staff.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("warden_staff", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.SONOROUS_STAFF.get())).save(saver, path("obtain_warden_staff"), existingFileHelper);

        Advancement.Builder.advancement().parent(enterOtherside).display(DDItems.WARDEN_BOOTS.get(), Component.translatable(id + "explore_otherside.title"), Component.translatable(id + "explore_otherside.description"), null, FrameType.CHALLENGE, true, true, false)
                .addCriterion("deeplands", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(OthersideBiomes.DEEPLANDS)))
                .addCriterion("echoing_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(OthersideBiomes.ECHOING_FOREST)))
                .addCriterion("blooming_caverns", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(OthersideBiomes.BLOOMING_CAVERNS)))
                .addCriterion("overcast_columns", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(OthersideBiomes.OVERCAST_COLUMNS)))
                .requirements(RequirementsStrategy.AND).rewards(AdvancementRewards.Builder.experience(300)).save(saver, path("explore_otherside"), existingFileHelper);

        Advancement.Builder.advancement().parent(enterOtherside).display(DDItems.WARDEN_SWORD.get(), Component.translatable(id + "kill_all_sculk_mobs.title"), Component.translatable(id + "kill_all_sculk_mobs.description"), null, FrameType.CHALLENGE, true, true, false)
                .addCriterion("phantom", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.PHANTOM)))
                .addCriterion("warden", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.WARDEN)))
                .addCriterion("sculk_centipede", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SCULK_CENTIPEDE.get())))
                .addCriterion("sculk_leech", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SCULK_LEECH.get())))
                .addCriterion("sculk_snapper", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SCULK_SNAPPER.get())))
                .addCriterion("shattered", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SHATTERED.get())))
                .addCriterion("shriek_worm", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.SHRIEK_WORM.get())))
                .addCriterion("stalker", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(DDEntities.STALKER.get())))
                .requirements(RequirementsStrategy.AND).rewards(AdvancementRewards.Builder.experience(100)).save(saver, path("kill_all_sculk_mobs"), existingFileHelper);

        Advancement obtainReinforcedEchoShard = Advancement.Builder.advancement().parent(killWarden).display(DDItems.REINFORCED_ECHO_SHARD.get(), Component.translatable(id + "obtain_reinforced_echo_shard.title"), Component.translatable(id + "obtain_reinforced_echo_shard.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("reinforced_echo_shard", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.REINFORCED_ECHO_SHARD.get())).save(saver, path("obtain_reinforced_echo_shard"), existingFileHelper);

        Advancement.Builder.advancement().parent(obtainReinforcedEchoShard).display(DDItems.WARDEN_CHESTPLATE.get(), Component.translatable(id + "warden_armor.title"), Component.translatable(id + "warden_armor.description"), null, FrameType.CHALLENGE, true, true, false)
                .addCriterion("warden_armor", InventoryChangeTrigger.TriggerInstance.hasItems(DDItems.WARDEN_HELMET.get(), DDItems.WARDEN_CHESTPLATE.get(), DDItems.WARDEN_LEGGINGS.get(), DDItems.WARDEN_BOOTS.get()))
                .rewards(AdvancementRewards.Builder.experience(100)).save(saver, path("warden_armor"), existingFileHelper);
    }

    private ResourceLocation path(String name) {
        return new ResourceLocation(DeeperDarker.MOD_ID, "main/" + name);
    }
}
