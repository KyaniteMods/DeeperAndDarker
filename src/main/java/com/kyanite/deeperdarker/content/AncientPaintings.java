package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class AncientPaintings {
    public static final ResourceKey<PaintingVariant> ABSTRACTION = create("abstraction", new PaintingVariant(32, 32));
    public static final ResourceKey<PaintingVariant> MILLIPEDE = create("millipede", new PaintingVariant(32, 32));
    public static final ResourceKey<PaintingVariant> CLOUDS = create("clouds", new PaintingVariant(64, 16));
    public static final ResourceKey<PaintingVariant> OOZE = create("ooze", new PaintingVariant(16, 16));
    public static final ResourceKey<PaintingVariant> ADVENTURE = create("adventure", new PaintingVariant(64, 16));
    public static final ResourceKey<PaintingVariant> ECHOER = create("echoer", new PaintingVariant(16, 16));
    public static final ResourceKey<PaintingVariant> CARROT = create("carrot", new PaintingVariant(32, 16));
    public static final ResourceKey<PaintingVariant> MAZE = create("maze", new PaintingVariant(64, 48));
    public static final ResourceKey<PaintingVariant> STAR_CATCHER = create("star_catcher", new PaintingVariant(32, 32));

    private static ResourceKey<PaintingVariant> create(String string, PaintingVariant paintingVariant) {
        ResourceKey<PaintingVariant> resourceKey = ResourceKey.create(Registries.PAINTING_VARIANT, DeeperDarker.id(string));
        Registry.register(BuiltInRegistries.PAINTING_VARIANT, resourceKey, paintingVariant);
        return resourceKey;
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering ancient paintings");
    }
}
