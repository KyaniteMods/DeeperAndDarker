package com.kyanite.deeperdarker.world.otherside.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.otherside.structures.maze.*;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Pos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DDStructures {
    public static final ResourceKey<Structure> ANCIENT_TEMPLE = createKey("ancient_temple");
    public static final ResourceKey<Structure> BLOOMAZE = createKey("bloomaze");
    public static final ResourceKey<Structure> GLOOMAZE = createKey("gloomaze");

    public static void bootstrap(BootstapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(ANCIENT_TEMPLE, new JigsawStructure(structure(biomes.getOrThrow(DDTags.Biomes.HAS_ANCIENT_TEMPLE)), pools.getOrThrow(DDPools.TEMPLE_START), 7, UniformHeight.of(VerticalAnchor.aboveBottom(18), VerticalAnchor.aboveBottom(28)), false));

        Map<MobCategory, StructureSpawnOverride> mazeSpawnOverrides = new HashMap<>();
        for (MobCategory category : MobCategory.values()) {
            mazeSpawnOverrides.put(category, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE, WeightedRandomList.create()));
        }
        context.register(BLOOMAZE, new MazeStructure(structure(biomes.getOrThrow(DDTags.Biomes.HAS_BLOOMAZE), mazeSpawnOverrides), new MazeStructureSettings(25, 5, 25, 3, MazeStructurePalette.BLOOMAZE, List.of(new RoomEntry(RoomTypeRegistry.BLOOMAZE_BOSS_ROOM, Optional.of(new Pos(11, 3, 11)), true)), false)));
        context.register(GLOOMAZE, new MazeStructure(structure(biomes.getOrThrow(DDTags.Biomes.HAS_GLOOMAZE), mazeSpawnOverrides), new MazeStructureSettings(29, 5, 29, 3, MazeStructurePalette.GLOOMAZE, List.of(new RoomEntry(RoomTypeRegistry.GLOOMAZE_BOSS_ROOM, Optional.of(new Pos(11, 3, 11)), true)), false)));
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> biomes) {
        return structure(biomes, Map.of());
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> biomes, Map<MobCategory, StructureSpawnOverride> spawnOverrides) {
        return new Structure.StructureSettings(biomes, spawnOverrides, GenerationStep.Decoration.UNDERGROUND_STRUCTURES, TerrainAdjustment.BEARD_BOX);
    }

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
