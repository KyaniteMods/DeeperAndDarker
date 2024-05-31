package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientPaintingVariants {
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(Registries.PAINTING_VARIANT, DeeperDarker.MOD_ID);

    public static final DeferredHolder<PaintingVariant, PaintingVariant> ABSTRACTION = PAINTINGS.register("abstraction", () -> new PaintingVariant(32, 32));
    public static final DeferredHolder<PaintingVariant, PaintingVariant> ADVENTURE = PAINTINGS.register("adventure", () -> new PaintingVariant(64, 16));
    public static final DeferredHolder<PaintingVariant, PaintingVariant> CARROT = PAINTINGS.register("carrot", () -> new PaintingVariant(32, 16));
    public static final DeferredHolder<PaintingVariant, PaintingVariant> CLOUDS = PAINTINGS.register("clouds", () -> new PaintingVariant(64, 16));
    public static final DeferredHolder<PaintingVariant, PaintingVariant> ECHOER = PAINTINGS.register("echoer", () -> new PaintingVariant(16, 16));
    public static final DeferredHolder<PaintingVariant, PaintingVariant> MILLIPEDE = PAINTINGS.register("millipede", () -> new PaintingVariant(32, 32));
    public static final DeferredHolder<PaintingVariant, PaintingVariant> OOZE = PAINTINGS.register("ooze", () -> new PaintingVariant(16, 16));
}
