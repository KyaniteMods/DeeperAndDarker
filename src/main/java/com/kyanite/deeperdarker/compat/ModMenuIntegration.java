package com.kyanite.deeperdarker.compat;

import com.kyanite.deeperdarker.util.DDConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.UUID;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return screen -> {
            Option<Float> spawnSomethingFromAncientVaseChance = Option.<Float>createBuilder()
                .name(Component.translatable("config.deeperdarker.spawnSomethingFromAncientVaseChance.title"))
                .description(OptionDescription.of(Component.translatable("config.deeperdarker.spawnSomethingFromAncientVaseChance.description")))
                .binding(
                    0.16f,
                    () -> DDConfig.HANDLER.instance().spawnSomethingFromAncientVaseChance,
                    newVal -> DDConfig.HANDLER.instance().spawnSomethingFromAncientVaseChance = newVal
                )
                .controller(opt -> FloatSliderControllerBuilder.create(opt)
                        .range(0.0f, 1.0f)
                        .formatValue(value -> {
                            DecimalFormat df = new DecimalFormat("0.##");
                            String formattedNumber = df.format(value * 100.0f) + "%";
                            return Component.literal(formattedNumber);
                        })
                        .step(0.001f)
                )
                .build();

            Option<Double> sculkLeechesFromAncientVaseChance = Option.<Double>createBuilder()
                    .name(Component.translatable("config.deeperdarker.sculkLeechesFromAncientVaseChance.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.sculkLeechesFromAncientVaseChance.description")))
                    .binding(
                            0.7,
                            () -> DDConfig.HANDLER.instance().sculkLeechesFromAncientVaseChance,
                            newVal -> DDConfig.HANDLER.instance().sculkLeechesFromAncientVaseChance = newVal
                    )
                    .controller(opt -> DoubleSliderControllerBuilder.create(opt)
                            .range(0.0, 1.0)
                            .formatValue(value -> {
                                DecimalFormat df = new DecimalFormat("0.##");
                                String formattedNumber = df.format(value * 100.0) + "%";
                                return Component.literal(formattedNumber);
                            })
                            .step(0.001)
                    )
                    .build();

            Option<Boolean> renderWardenHelmetHorns = Option.<Boolean>createBuilder()
                    .name(Component.translatable("config.deeperdarker.renderWardenHelmetHorns.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.renderWardenHelmetHorns.description")))
                    .binding(
                            true,
                            () -> DDConfig.HANDLER.instance().renderWardenHelmetHorns,
                            newVal -> DDConfig.HANDLER.instance().renderWardenHelmetHorns = newVal
                    )
                    .controller(TickBoxControllerBuilder::create)
                    .build();

            Option<Boolean> geysersApplySlowFalling = Option.<Boolean>createBuilder()
                    .name(Component.translatable("config.deeperdarker.geysersApplySlowFalling.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.geysersApplySlowFalling.description")))
                    .binding(
                            false,
                            () -> DDConfig.HANDLER.instance().geysersApplySlowFalling,
                            newVal -> DDConfig.HANDLER.instance().geysersApplySlowFalling = newVal
                    )
                    .controller(TickBoxControllerBuilder::create)
                    .build();

            Option<Integer> portalMinWidth = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.portalMinWidth.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.portalMinWidth.description")))
                    .binding(
                            8,
                            () -> DDConfig.HANDLER.instance().portalMinWidth,
                            newVal -> DDConfig.HANDLER.instance().portalMinWidth = newVal
                    )
                    .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .range(1, 128)
                            .formatValue(value -> value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Integer> portalMinHeight = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.portalMinHeight.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.portalMinHeight.description")))
                    .binding(
                            4,
                            () -> DDConfig.HANDLER.instance().portalMinHeight,
                            newVal -> DDConfig.HANDLER.instance().portalMinHeight = newVal
                    )
                    .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .range(1, 128)
                            .formatValue(value -> value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Integer> portalMaxWidth = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.portalMaxWidth.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.portalMaxWidth.description")))
                    .binding(
                            48,
                            () -> DDConfig.HANDLER.instance().portalMaxWidth,
                            newVal -> DDConfig.HANDLER.instance().portalMaxWidth = newVal
                    )
                    .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .range(1, 128)
                            .formatValue(value -> value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Integer> portalMaxHeight = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.portalMaxHeight.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.portalMaxHeight.description")))
                    .binding(
                            24,
                            () -> DDConfig.HANDLER.instance().portalMaxHeight,
                            newVal -> DDConfig.HANDLER.instance().portalMaxHeight = newVal
                    )
                    .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .range(2, 128)
                            .formatValue(value -> value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Boolean> wardenHeartPulses = Option.<Boolean>createBuilder()
                    .name(Component.translatable("config.deeperdarker.wardenHeartPulses.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.wardenHeartPulses.description")))
                    .binding(
                            true,
                            () -> DDConfig.HANDLER.instance().wardenHeartPulses,
                            newVal -> DDConfig.HANDLER.instance().wardenHeartPulses = newVal
                    )
                    .controller(TickBoxControllerBuilder::create)
                    .build();

            Option<Boolean> changePhantomTextures = Option.<Boolean>createBuilder()
                    .name(Component.translatable("config.deeperdarker.changePhantomTextures.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.changePhantomTextures.description")))
                    .binding(
                            true,
                            () -> DDConfig.HANDLER.instance().changePhantomTextures,
                            newVal -> DDConfig.HANDLER.instance().changePhantomTextures = newVal
                    )
                    .controller(TickBoxControllerBuilder::create)
                    .build();

            Screen screen1 = YetAnotherConfigLib.createBuilder()
                    .title(Component.translatable("config.deeperdarker.title"))
                    .category(ConfigCategory.createBuilder()
                            .name(Component.translatable("config.deeperdarker.title"))
                            .group(OptionGroup.createBuilder()
                                    .name(Component.translatable("config.deeperdarker.server.title"))
                                    .option(spawnSomethingFromAncientVaseChance)
                                    .option(sculkLeechesFromAncientVaseChance)
                                    .option(geysersApplySlowFalling)
                                    .option(portalMinWidth)
                                    .option(portalMinHeight)
                                    .option(portalMaxWidth)
                                    .option(portalMaxHeight)
                                    .build())
                            .group(OptionGroup.createBuilder()
                                    .name(Component.translatable("config.deeperdarker.client.title"))
                                    .option(renderWardenHelmetHorns)
                                    .option(wardenHeartPulses)
                                    .option(changePhantomTextures)
                                    .build())
                            .build())
                    .save(() -> DDConfig.HANDLER.save())
                    .build().generateScreen(screen);

            return screen1;
        };
    }
}
