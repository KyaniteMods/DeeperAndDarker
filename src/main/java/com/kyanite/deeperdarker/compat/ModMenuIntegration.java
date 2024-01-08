package com.kyanite.deeperdarker.compat;

import com.kyanite.deeperdarker.util.DDConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.*;
import net.minecraft.network.chat.Component;

import java.text.DecimalFormat;

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

            Option<Float> geyserLaunchVelocity = Option.<Float>createBuilder()
                    .name(Component.translatable("config.deeperdarker.geyserLaunchVelocity.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.geyserLaunchVelocity.description")))
                    .binding(
                            2.5f,
                            () -> DDConfig.HANDLER.instance().geyserLaunchVelocity,
                            newVal -> DDConfig.HANDLER.instance().geyserLaunchVelocity = newVal
                    )
                    .controller(opt -> FloatSliderControllerBuilder.create(opt)
                            .range(0.0f, 128.0f)
                            .step(0.5f)
                            .formatValue(value -> value == 69.0f ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
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
                            .range(2, 128)
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

            Option<Integer> generatedPortalWidth = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.generatedPortalWidth.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.generatedPortalWidth.description")))
                    .binding(
                            8,
                            () -> DDConfig.HANDLER.instance().generatedPortalWidth,
                            newVal -> DDConfig.HANDLER.instance().generatedPortalWidth = newVal
                    )
                    .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .range(1, 128)
                            .formatValue(value -> value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Integer> generatedPortalHeight = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.generatedPortalHeight.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.generatedPortalHeight.description")))
                    .binding(
                            4,
                            () -> DDConfig.HANDLER.instance().generatedPortalHeight,
                            newVal -> DDConfig.HANDLER.instance().generatedPortalHeight = newVal
                    )
                    .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .range(2, 128)
                            .formatValue(value -> value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Integer> portalMinSearchHeight = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.portalMinSearchHeight.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.portalMinSearchHeight.description")))
                    .binding(
                            Math.min(2, DDConfig.HANDLER.instance().portalMaxSearchHeight),
                            () -> DDConfig.HANDLER.instance().portalMinSearchHeight,
                            newVal -> DDConfig.HANDLER.instance().portalMinSearchHeight = newVal
                    )
                    .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .range(0, 127)
                            .formatValue(value -> value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Integer> portalMaxSearchHeight = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.portalMaxSearchHeight.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.portalMaxSearchHeight.description")))
                    .binding(
                            122,
                            () -> DDConfig.HANDLER.instance().portalMaxSearchHeight,
                            newVal -> DDConfig.HANDLER.instance().portalMaxSearchHeight = newVal
                    )
                    .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .range(0, 127)
                            .formatValue(value -> value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Integer> sonorousStaffRange = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.sonorousStaffRange.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.sonorousStaffRange.description")))
                    .binding(
                            40,
                            () -> DDConfig.HANDLER.instance().sonorousStaffRange,
                            newVal -> DDConfig.HANDLER.instance().sonorousStaffRange = newVal
                    )
                    .controller(opt -> IntegerSliderControllerBuilder.create(opt)
                            .range(1, 128)
                            .step(1)
                            .formatValue(value -> value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Float> sonorousStaffDamage = Option.<Float>createBuilder()
                    .name(Component.translatable("config.deeperdarker.sonorousStaffDamage.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.sonorousStaffDamage.description")))
                    .binding(
                            10.0f,
                            () -> DDConfig.HANDLER.instance().sonorousStaffDamage,
                            newVal -> DDConfig.HANDLER.instance().sonorousStaffDamage = newVal
                    )
                    .controller(opt -> FloatSliderControllerBuilder.create(opt)
                            .range(0.0f, 128.0f)
                            .step(0.5f)
                            .formatValue(value -> value == 69.0f ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Double> sonorousStaffKnockback = Option.<Double>createBuilder()
                    .name(Component.translatable("config.deeperdarker.sonorousStaffKnockback.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.sonorousStaffKnockback.description")))
                    .binding(
                            1.0,
                            () -> DDConfig.HANDLER.instance().sonorousStaffKnockback,
                            newVal -> DDConfig.HANDLER.instance().sonorousStaffKnockback = newVal
                    )
                    .controller(opt -> DoubleSliderControllerBuilder.create(opt)
                            .range(0.0, 128.0)
                            .step(0.5)
                            .formatValue(value -> value == 69.0 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Integer> sonorousStaffCooldown = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.sonorousStaffCooldown.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.sonorousStaffCooldown.description")))
                    .binding(
                            40,
                            () -> DDConfig.HANDLER.instance().sonorousStaffCooldown,
                            newVal -> DDConfig.HANDLER.instance().sonorousStaffCooldown = newVal
                    )
                    .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .range(0, 32767)
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

            Option<Integer> soulElytraCooldown = Option.<Integer>createBuilder()
                    .name(Component.translatable("config.deeperdarker.soulElytraCooldown.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.soulElytraCooldown.description")))
                    .binding(
                            600,
                            () -> DDConfig.HANDLER.instance().soulElytraCooldown,
                            newVal -> DDConfig.HANDLER.instance().soulElytraCooldown = newVal
                    )
                    .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .range(0, 32767)
                            .formatValue(value -> value == 69 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
                    .build();

            Option<Double> soulElytraBoostStrength = Option.<Double>createBuilder()
                    .name(Component.translatable("config.deeperdarker.soulElytraBoostStrength.title"))
                    .description(OptionDescription.of(Component.translatable("config.deeperdarker.soulElytraBoostStrength.description")))
                    .binding(
                            1.0,
                            () -> DDConfig.HANDLER.instance().soulElytraBoostStrength,
                            newVal -> DDConfig.HANDLER.instance().soulElytraBoostStrength = newVal
                    )
                    .controller(opt -> DoubleSliderControllerBuilder.create(opt)
                            .range(0.0, 128.0)
                            .step(0.5)
                            .formatValue(value -> value == 69.0 ? Component.literal(value + "... nice") : Component.literal(String.valueOf(value))))
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
                                    .option(geyserLaunchVelocity)
                                    .option(portalMinWidth)
                                    .option(portalMinHeight)
                                    .option(portalMaxWidth)
                                    .option(portalMaxHeight)
                                    .option(generatedPortalWidth)
                                    .option(generatedPortalHeight)
                                    .option(portalMinSearchHeight)
                                    .option(portalMaxSearchHeight)
                                    .option(sonorousStaffRange)
                                    .option(sonorousStaffDamage)
                                    .option(sonorousStaffKnockback)
                                    .option(sonorousStaffCooldown)
                                    .option(soulElytraCooldown)
                                    .option(soulElytraBoostStrength)
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