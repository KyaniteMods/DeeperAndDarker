package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class DDPaintingVariants {
    public static final ResourceKey<PaintingVariant> ABSTRACTION = create("abstraction");
    public static final ResourceKey<PaintingVariant> ADVENTURE = create("adventure");
    public static final ResourceKey<PaintingVariant> CARROT = create("carrot");
    public static final ResourceKey<PaintingVariant> CLOUDS = create("clouds");
    public static final ResourceKey<PaintingVariant> ECHOER = create("echoer");
    public static final ResourceKey<PaintingVariant> MILLIPEDE = create("millipede");
    public static final ResourceKey<PaintingVariant> OOZE = create("ooze");

    private static ResourceKey<PaintingVariant> create(String name) {
        return ResourceKey.create(Registries.PAINTING_VARIANT, ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, name));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering ancient paintings");
    }
}
