package com.kyanite.deeperdarker.util.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class DDAdvancements implements Consumer<Consumer<Advancement>> {
    @Override
    public void accept(Consumer<Advancement> advancementConsumer) {
        Advancement root = Advancement.Builder.advancement()
                .display(
                        DDItems.HEART_OF_THE_DEEP,
                        Component.translatable("advancements.deeperdarker.root.title"),
                        Component.translatable("advancements.deeperdarker.root.description"),
                        new ResourceLocation(DeeperDarker.MOD_ID, "textures/gui/advancements/backgrounds/deeperdarker.png"),
                        FrameType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("entered_otherside", ChangeDimensionTrigger.TriggerInstance.changedDimension(Level.OVERWORLD,
                        OthersideDimension.OTHERSIDE_LEVEL))
                .save(advancementConsumer, DeeperDarker.MOD_ID + "/root");
    }
}
