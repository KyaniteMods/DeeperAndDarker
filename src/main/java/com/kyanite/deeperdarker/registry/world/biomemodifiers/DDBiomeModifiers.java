package com.kyanite.deeperdarker.registry.world.biomemodifiers;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDBiomeModifiers {
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, DeeperAndDarker.MOD_ID);

    public static RegistryObject<Codec<DDVegetalModifier>> VEGETAL_MODIFIER = BIOME_MODIFIERS.register("vegetal", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(DDVegetalModifier::biomes),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(DDVegetalModifier::feature)
            ).apply(builder, DDVegetalModifier::new)));
}
