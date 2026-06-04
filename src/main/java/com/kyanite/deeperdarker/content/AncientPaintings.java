package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

import java.util.Optional;

public class AncientPaintings {
    public static final ResourceKey<PaintingVariant> ABSTRACTION = create("abstraction");
    public static final ResourceKey<PaintingVariant> ADVENTURE = create("adventure");
    public static final ResourceKey<PaintingVariant> CARROT = create("carrot");
    public static final ResourceKey<PaintingVariant> CLOUDS = create("clouds");
    public static final ResourceKey<PaintingVariant> ECHOER = create("echoer");
    public static final ResourceKey<PaintingVariant> MILLIPEDE = create("millipede");
    public static final ResourceKey<PaintingVariant> OOZE = create("ooze");

    public static void bootstrap(BootstrapContext<PaintingVariant> context) {
        register(context, ABSTRACTION, 2, 2);
        register(context, ADVENTURE, 4, 1);
        register(context, CARROT, 2, 1);
        register(context, CLOUDS, 4, 1);
        register(context, ECHOER, 1, 1);
        register(context, MILLIPEDE, 2, 2);
        register(context, OOZE, 1, 1);
    }

    private static ResourceKey<PaintingVariant> create(String name) {
        return ResourceKey.create(Registries.PAINTING_VARIANT, DeeperDarker.rl(name));
    }

    private static void register(BootstrapContext<PaintingVariant> context, ResourceKey<PaintingVariant> id, int width, int height) {
        context.register(
                id,
                new PaintingVariant(
                        width,
                        height,
                        id.identifier(),
                        Optional.of(Component.translatable(id.identifier().toLanguageKey("painting", "title")).withStyle(ChatFormatting.YELLOW)),
                        Optional.of(Component.translatable(id.identifier().toLanguageKey("painting", "author")).withStyle(ChatFormatting.GRAY))
                )
        );
    }
}
