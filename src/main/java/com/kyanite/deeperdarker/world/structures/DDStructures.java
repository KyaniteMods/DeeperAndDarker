package com.kyanite.deeperdarker.world.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;

public class DDStructures {
    public static final ResourceKey<Structure> ANCIENT_TEMPLE = createKey("ancient_temple");

    public static void bootstrap(BootstapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(ANCIENT_TEMPLE, new JigsawStructure(structure(biomes.getOrThrow(BiomeTags.HAS_VILLAGE_PLAINS)), pools.getOrThrow(DDPools.ANCIENT_TEMPLE), 7, ConstantHeight.of(VerticalAnchor.absolute(18)), false, Heightmap.Types.WORLD_SURFACE_WG));
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> biomes) {
        return new Structure.StructureSettings(biomes, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE);
    }

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
