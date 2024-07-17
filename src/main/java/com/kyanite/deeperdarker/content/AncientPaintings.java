package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, DeeperDarker.MOD_ID);

    public static final RegistryObject<PaintingVariant> ABSTRACTION = PAINTINGS.register("abstraction", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> ADVENTURE = PAINTINGS.register("adventure", () -> new PaintingVariant(64, 16));
    public static final RegistryObject<PaintingVariant> CARROT = PAINTINGS.register("carrot", () -> new PaintingVariant(32, 16));
    public static final RegistryObject<PaintingVariant> CLOUDS = PAINTINGS.register("clouds", () -> new PaintingVariant(64, 16));
    public static final RegistryObject<PaintingVariant> ECHOER = PAINTINGS.register("echoer", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> MILLIPEDE = PAINTINGS.register("millipede", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> OOZE = PAINTINGS.register("ooze", () -> new PaintingVariant(16, 16));
}
