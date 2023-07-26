package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import com.kyanite.deeperdarker.world.dimension.DeeperDarkerWorlds;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ChangedDimensionCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class DeeperDarkerAdvancements implements Consumer<Consumer<Advancement>> {
    @Override
    public void accept(Consumer<Advancement> advancementConsumer) {
        Advancement root = Advancement.Builder.create()
                .display(
                        DeeperDarkerItems.HEART_OF_THE_DEEP,
                        Text.translatable("advancements.deeperdarker.root.title"),
                        Text.translatable("advancements.deeperdarker.root.description"),
                        new Identifier(DeeperDarker.MOD_ID, "textures/gui/advancements/backgrounds/deeperdarker.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                ).criterion("entered_otherside", ChangedDimensionCriterion.Conditions.create(World.OVERWORLD,
                        DeeperDarkerWorlds.OTHERSIDE))
                .build(advancementConsumer, DeeperDarker.MOD_ID + "/root");
    }
}
