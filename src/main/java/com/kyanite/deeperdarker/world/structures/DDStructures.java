package com.kyanite.deeperdarker.world.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class DDStructures {
    public static final DeferredRegister<Structure> STRUCTURES = DeferredRegister.create(Registry.STRUCTURE_REGISTRY, DeeperDarker.MOD_ID);

    public static final RegistryObject<Structure> ANCIENT_TEMPLE = STRUCTURES.register("ancient_temple", () -> new JigsawStructure(structure(DDTags.Biomes.HAS_ANCIENT_TEMPLE), DDPools.ANCIENT_TEMPLE.getHolder().get(), 7, ConstantHeight.of(VerticalAnchor.absolute(18)), false));

    private static Structure.StructureSettings structure(TagKey<Biome> biomes) {
        return new Structure.StructureSettings(BuiltinRegistries.BIOME.getOrCreateTag(biomes), Map.of(), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, TerrainAdjustment.NONE);
    }
}
