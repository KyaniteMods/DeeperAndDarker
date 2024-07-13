package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class AncientPaintings {
    public static final ResourceKey<PaintingVariant> ABSTRACTION = create("abstraction");
    public static final ResourceKey<PaintingVariant> ADVENTURE = create("adventure");
    public static final ResourceKey<PaintingVariant> CARROT = create("carrot");
    public static final ResourceKey<PaintingVariant> CLOUDS = create("clouds");
    public static final ResourceKey<PaintingVariant> ECHOER = create("echoer");
    public static final ResourceKey<PaintingVariant> MILLIPEDE = create("millipede");
    public static final ResourceKey<PaintingVariant> OOZE = create("ooze");

    public static void bootstrap(BootstrapContext<PaintingVariant> context) {
        context.register(ABSTRACTION, new PaintingVariant(2, 2, ABSTRACTION.location()));
        context.register(ADVENTURE, new PaintingVariant(4, 1, ADVENTURE.location()));
        context.register(CARROT, new PaintingVariant(2, 1, CARROT.location()));
        context.register(CLOUDS, new PaintingVariant(4, 1, CLOUDS.location()));
        context.register(ECHOER, new PaintingVariant(1, 1, ECHOER.location()));
        context.register(MILLIPEDE, new PaintingVariant(2, 2, MILLIPEDE.location()));
        context.register(OOZE, new PaintingVariant(1, 1, OOZE.location()));
    }

    private static ResourceKey<PaintingVariant> create(String name) {
        return ResourceKey.create(Registries.PAINTING_VARIANT, DeeperDarker.rl(name));
    }
}
