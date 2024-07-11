package com.kyanite.deeperdarker.world.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

public class DDStructures {
    public static final ResourceKey<Structure> ANCIENT_TEMPLE = createKey("ancient_temple");

    public static void bootstrap(BootstrapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(ANCIENT_TEMPLE, new JigsawStructure(structure(biomes.getOrThrow(DDTags.Misc.HAS_ANCIENT_TEMPLE)), pools.getOrThrow(DDPools.TEMPLE_START), 7, ConstantHeight.of(VerticalAnchor.absolute(18)), false));
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> biomes) {
        return new Structure.StructureSettings.Builder(biomes).generationStep(GenerationStep.Decoration.UNDERGROUND_STRUCTURES).terrainAdapation(TerrainAdjustment.NONE).build();
    }

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, name));
    }
}
