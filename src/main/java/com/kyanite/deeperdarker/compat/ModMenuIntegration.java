package com.kyanite.deeperdarker.compat;

import com.kyanite.deeperdarker.util.DDConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl.api.ConfigCategory;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.api.OptionGroup;
import dev.isxander.yacl.api.YetAnotherConfigLib;
import dev.isxander.yacl.gui.controllers.TickBoxController;
import dev.isxander.yacl.gui.controllers.slider.DoubleSliderController;
import dev.isxander.yacl.gui.controllers.slider.FloatSliderController;
import dev.isxander.yacl.gui.controllers.string.number.IntegerFieldController;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.text.DecimalFormat;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return screen -> {
            Option<Float> spawnSomethingFromAncientVaseChance = Option.createBuilder(Float.class)
                    .name(Component.translatable("config.deeperdarker.spawnSomethingFromAncientVaseChance.title"))
                    .binding(
                            0.16f,
                            () -> DDConfig.HANDLER.getConfig().spawnSomethingFromAncientVaseChance,
                            newVal -> DDConfig.HANDLER.getConfig().spawnSomethingFromAncientVaseChance = newVal
                    )
                    .controller(opt -> new FloatSliderController(opt, 0.0f, 1.0f, 0.001f, value -> {
                        DecimalFormat df = new DecimalFormat("0.##");
                        String formattedNumber = df.format(value * 100.0f) + "%";
                        return Component.literal(formattedNumber);
                    }))
                    .build();

            Option<Double> sculkLeechesFromAncientVaseChance = Option.createBuilder(Double.class)
                    .name(Component.translatable("config.deeperdarker.sculkLeechesFromAncientVaseChance.title"))
                    .binding(
                            0.7,
                            () -> DDConfig.HANDLER.getConfig().sculkLeechesFromAncientVaseChance,
                            newVal -> DDConfig.HANDLER.getConfig().sculkLeechesFromAncientVaseChance = newVal
                    )
                    .controller(opt -> new DoubleSliderController(opt, 0.0, 1.0, 0.001, value -> {
                        DecimalFormat df = new DecimalFormat("0.##");
                        String formattedNumber = df.format(value * 100.0) + "%";
                        return Component.literal(formattedNumber);
                    }))
                    .build();

            Option<Boolean> renderWardenHelmetHorns = Option.createBuilder(Boolean.class)
                    .name(Component.translatable("config.deeperdarker.renderWardenHelmetHorns.title"))
                    .binding(
                            true,
                            () -> DDConfig.HANDLER.getConfig().renderWardenHelmetHorns,
                            newVal -> DDConfig.HANDLER.getConfig().renderWardenHelmetHorns = newVal
                    )
                    .controller(TickBoxController::new)
                    .build();

            Option<Boolean> geysersApplySlowFalling = Option.createBuilder(Boolean.class)
                    .name(Component.translatable("config.deeperdarker.geysersApplySlowFalling.title"))
                    .binding(
                            false,
                            () -> DDConfig.HANDLER.getConfig().geysersApplySlowFalling,
                            newVal -> DDConfig.HANDLER.getConfig().geysersApplySlowFalling = newVal
                    )
                    .controller(TickBoxController::new)
                    .build();

            Option<Float> geyserLaunchVelocity = Option.createBuilder(Float.class)
                    .name(Component.translatable("config.deeperdarker.geyserLaunchVelocity.title"))
                    .binding(
                            2.5f,
                            () -> DDConfig.HANDLER.getConfig().geyserLaunchVelocity,
                            newVal -> DDConfig.HANDLER.getConfig().geyserLaunchVelocity = newVal
                    )
                    .controller(opt -> new FloatSliderController(opt, 0.0f, 32767.0f, 0.25f, value ->
                        value == 69.0f ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))
                    ))
                    .build();

            Option<Integer> portalMinWidth = Option.createBuilder(Integer.class)
                    .name(Component.translatable("config.deeperdarker.portalMinWidth.title"))
                    .binding(
                            8,
                            () -> DDConfig.HANDLER.getConfig().portalMinWidth,
                            newVal -> DDConfig.HANDLER.getConfig().portalMinWidth = newVal
                    )
                    .controller(opt -> new IntegerFieldController(opt, 1, 128, value ->
                            value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))
                    ))
                    .build();

            Option<Integer> portalMinHeight = Option.createBuilder(Integer.class)
                    .name(Component.translatable("config.deeperdarker.portalMinHeight.title"))
                    .binding(
                            4,
                            () -> DDConfig.HANDLER.getConfig().portalMinHeight,
                            newVal -> DDConfig.HANDLER.getConfig().portalMinHeight = newVal
                    )
                    .controller(opt -> new IntegerFieldController(opt, 2, 128, value ->
                            value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))
                    ))
                    .build();

            Option<Integer> portalMaxWidth = Option.createBuilder(Integer.class)
                    .name(Component.translatable("config.deeperdarker.portalMaxWidth.title"))
                    .binding(
                            48,
                            () -> DDConfig.HANDLER.getConfig().portalMaxWidth,
                            newVal -> DDConfig.HANDLER.getConfig().portalMaxWidth = newVal
                    )
                    .controller(opt -> new IntegerFieldController(opt, 1, 128, value ->
                            value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))
                    ))
                    .build();

            Option<Integer> portalMaxHeight = Option.<Integer>createBuilder(Integer.class)
                    .name(Component.translatable("config.deeperdarker.portalMaxHeight.title"))
                    .binding(
                            24,
                            () -> DDConfig.HANDLER.getConfig().portalMaxHeight,
                            newVal -> DDConfig.HANDLER.getConfig().portalMaxHeight = newVal
                    )
                    .controller(opt -> new IntegerFieldController(opt, 2, 128, value ->
                            value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))
                    ))
                    .build();

            Option<Integer> generatedPortalWidth = Option.createBuilder(Integer.class)
                    .name(Component.translatable("config.deeperdarker.generatedPortalWidth.title"))
                    .binding(
                            8,
                            () -> DDConfig.HANDLER.getConfig().generatedPortalWidth,
                            newVal -> DDConfig.HANDLER.getConfig().generatedPortalWidth = newVal
                    )
                    .controller(opt -> new IntegerFieldController(opt, 1, 128, value ->
                            value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))
                    ))
                    .build();

            Option<Integer> generatedPortalHeight = Option.<Integer>createBuilder(Integer.class)
                    .name(Component.translatable("config.deeperdarker.generatedPortalHeight.title"))
                    .binding(
                            4,
                            () -> DDConfig.HANDLER.getConfig().generatedPortalHeight,
                            newVal -> DDConfig.HANDLER.getConfig().generatedPortalHeight = newVal
                    )
                    .controller(opt -> new IntegerFieldController(opt, 2, 128, value ->
                            value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))
                    ))
                    .build();

            Option<Integer> portalMinSearchHeight = Option.createBuilder(Integer.class)
                    .name(Component.translatable("config.deeperdarker.portalMinSearchHeight.title"))
                    .binding(
                            Math.min(2, DDConfig.HANDLER.getConfig().portalMaxSearchHeight),
                            () -> DDConfig.HANDLER.getConfig().portalMinSearchHeight,
                            newVal -> DDConfig.HANDLER.getConfig().portalMinSearchHeight = newVal
                    )
                    .controller(opt -> new IntegerFieldController(opt, 0, 127, value ->
                            value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))
                    ))
                    .build();

            Option<Integer> portalMaxSearchHeight = Option.<Integer>createBuilder(Integer.class)
                    .name(Component.translatable("config.deeperdarker.portalMaxSearchHeight.title"))
                    .binding(
                            122,
                            () -> DDConfig.HANDLER.getConfig().portalMaxSearchHeight,
                            newVal -> DDConfig.HANDLER.getConfig().portalMaxSearchHeight = newVal
                    )
                    .controller(opt -> new IntegerFieldController(opt, 0, 127, value ->
                            value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))
                    ))
                    .build();

            Option<Boolean> wardenHeartPulses = Option.createBuilder(Boolean.class)
                    .name(Component.translatable("config.deeperdarker.wardenHeartPulses.title"))
                    .binding(
                            true,
                            () -> DDConfig.HANDLER.getConfig().wardenHeartPulses,
                            newVal -> DDConfig.HANDLER.getConfig().wardenHeartPulses = newVal
                    )
                    .controller(TickBoxController::new)
                    .build();

            Option<Boolean> changePhantomTextures = Option.createBuilder(Boolean.class)
                    .name(Component.translatable("config.deeperdarker.changePhantomTextures.title"))
                    .binding(
                            true,
                            () -> DDConfig.HANDLER.getConfig().changePhantomTextures,
                            newVal -> DDConfig.HANDLER.getConfig().changePhantomTextures = newVal
                    )
                    .controller(TickBoxController::new)
                    .build();

            return YetAnotherConfigLib.createBuilder()
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
                                    .option(generatedPortalWidth)
                                    .option(generatedPortalHeight)
                                    .option(portalMinSearchHeight)
                                    .option(portalMaxSearchHeight)
                                    .build())
                            .group(OptionGroup.createBuilder()
                                    .name(Component.translatable("config.deeperdarker.client.title"))
                                    .option(renderWardenHelmetHorns)
                                    .option(wardenHeartPulses)
                                    .option(changePhantomTextures)
                                    .build())
                            .build())
                    .save(DDConfig::saveHandler)
                    .build().generateScreen(screen);
        };
    }
}