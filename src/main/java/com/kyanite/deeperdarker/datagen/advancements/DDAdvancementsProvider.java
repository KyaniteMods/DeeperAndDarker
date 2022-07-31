package com.kyanite.deeperdarker.datagen.advancements;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class DDAdvancementsProvider extends AdvancementProvider {
    public DDAdvancementsProvider(DataGenerator pGenerator, ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, pExistingFileHelper);
    }

    @Override
    protected void registerAdvancements(@NotNull Consumer<Advancement> consumer, @NotNull ExistingFileHelper fileHelper) {
        String id = DeeperAndDarker.MOD_ID + ":main/";

        Advancement root = Advancement.Builder.advancement().display(Blocks.SCULK,
                Component.translatable("advancements.deeperdarker.root.title"),
                Component.translatable("advancements.deeperdarker.root.description"),
                new ResourceLocation("textures/block/sculk.png"),
                FrameType.TASK, false, false, false)
                .addCriterion("phantom", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.PHANTOM)))
                .save(consumer, id + "root");

        Advancement obtainMembrane = Advancement.Builder.advancement().parent(root).display(Items.PHANTOM_MEMBRANE,
                Component.translatable("advancements.deeperdarker.obtain_membrane.title"),
                Component.translatable("advancements.deeperdarker.obtain_membrane.description"),
                null, FrameType.TASK, true, true, false)
                .addCriterion("phantom_membrane", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PHANTOM_MEMBRANE))
                .save(consumer, id + "obtain_membrane");

        Advancement locateAncientCity = Advancement.Builder.advancement().parent(obtainMembrane).display(Blocks.DEEPSLATE_TILES,
                Component.translatable("advancements.deeperdarker.locate_ancient_city.title"),
                Component.translatable("advancements.deeperdarker.locate_ancient_city.description"),
                null, FrameType.GOAL, true, true, false)
                .addCriterion("ancient_city", PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(BuiltinStructures.ANCIENT_CITY)))
                .save(consumer, id + "locate_ancient_city");

        Advancement.Builder.advancement().parent(locateAncientCity).display(Items.ECHO_SHARD,
                Component.translatable("advancements.deeperdarker.obtain_echo_shard.title"),
                Component.translatable("advancements.deeperdarker.obtain_echo_shard.description"),
                null, FrameType.TASK, true, true, false)
                .addCriterion("echo_shard", InventoryChangeTrigger.TriggerInstance.hasItems(Items.ECHO_SHARD))
                .save(consumer, id + "obtain_echo_shard");

        Advancement.Builder.advancement().parent(locateAncientCity).display(Blocks.SCULK_SHRIEKER,
                Component.translatable("advancements.deeperdarker.summon_warden.title"),
                Component.translatable("advancements.deeperdarker.summon_warden.description"),
                null, FrameType.GOAL, true, true, false)
                .addCriterion("summon", SummonedEntityTrigger.TriggerInstance.summonedEntity(EntityPredicate.Builder.entity().of(EntityType.WARDEN)))
                .save(consumer, id + "summon_warden");
    }
}
