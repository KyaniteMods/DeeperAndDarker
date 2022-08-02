package com.kyanite.deeperdarker.datagen.advancements;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
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
                .addCriterion("membrane", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PHANTOM_MEMBRANE))
                .save(consumer, id + "obtain_membrane");

        Advancement locateAncientCity = Advancement.Builder.advancement().parent(obtainMembrane).display(Blocks.DEEPSLATE_TILES,
                Component.translatable("advancements.deeperdarker.locate_ancient_city.title"),
                Component.translatable("advancements.deeperdarker.locate_ancient_city.description"),
                null, FrameType.GOAL, true, true, false)
                .addCriterion("ancient_city", PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(BuiltinStructures.ANCIENT_CITY)))
                .save(consumer, id + "locate_ancient_city");

        Advancement killWarden = Advancement.Builder.advancement().parent(locateAncientCity).display(Blocks.SCULK_SHRIEKER,
                Component.translatable("advancements.deeperdarker.kill_warden.title"),
                Component.translatable("advancements.deeperdarker.kill_warden.description"),
                null, FrameType.CHALLENGE, true, true, false)
                .addCriterion("warden", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.WARDEN)))
                .save(consumer, id + "kill_warden");

        Advancement.Builder.advancement().parent(killWarden).display(DDItems.HEART_OF_THE_DEEP.get(),
                Component.translatable("advancements.deeperdarker.enter_otherside.title"),
                Component.translatable("advancements.deeperdarker.enter_otherside.title"),
                null, FrameType.GOAL, true, true, false)
                .addCriterion("otherside", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DDDimensions.OTHERSIDE_LEVEL))
                .save(consumer, "enter_otherside");
    }
}