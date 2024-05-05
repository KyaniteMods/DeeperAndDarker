package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class DDPaintingVariants {
    public static final ResourceKey<PaintingVariant> ABSTRACTION = create("abstraction", new PaintingVariant(32, 32));
    public static final ResourceKey<PaintingVariant> MILLIPEDE = create("millipede", new PaintingVariant(32, 32));
    public static final ResourceKey<PaintingVariant> CLOUDS = create("clouds", new PaintingVariant(64, 16));

    private static ResourceKey<PaintingVariant> create(String string, PaintingVariant paintingVariant) {
        ResourceKey<PaintingVariant> resourceKey = ResourceKey.create(Registries.PAINTING_VARIANT, new ResourceLocation(DeeperDarker.MOD_ID, string));
        Registry.register(BuiltInRegistries.PAINTING_VARIANT, resourceKey, paintingVariant);
        return resourceKey;
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering ancient paintings");
    }
}
