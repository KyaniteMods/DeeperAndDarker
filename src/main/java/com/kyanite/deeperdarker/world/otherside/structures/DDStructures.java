package com.kyanite.deeperdarker.world.otherside.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import com.kyanite.deeperdarker.world.otherside.structures.maze.*;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Pos;
import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.OakTreeRoomOptions;
import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.RoomEntry;
import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.RoomTypeRegistry;
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
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
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
    public static final ResourceKey<Structure> CASTLE = createKey("castle");
    public static final ResourceKey<Structure> SCULK_RUINS = createKey("sculk_ruins");
    public static final ResourceKey<Structure> WATCHTOWER = createKey("watchtower");
    public static final ResourceKey<Structure> VILLAGER_CAMP = createKey("villager_camp");

    public static void bootstrap(BootstapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(ANCIENT_TEMPLE, new JigsawStructure(surfaceStructure(biomes.getOrThrow(DDTags.Biomes.HAS_ANCIENT_TEMPLE)), pools.getOrThrow(DDPools.TEMPLE_START), 7, UniformHeight.of(VerticalAnchor.aboveBottom(18), VerticalAnchor.aboveBottom(28)), false));

        Map<MobCategory, StructureSpawnOverride> mazeSpawnOverrides = new HashMap<>();
        for (MobCategory category : MobCategory.values()) {
            mazeSpawnOverrides.put(category, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE, WeightedRandomList.create()));
        }
        context.register(BLOOMAZE, new MazeStructure(stronghold(biomes.getOrThrow(DDTags.Biomes.HAS_BLOOMAZE), mazeSpawnOverrides), new MazeStructureSettings(25, 5, 25, 3, MazeStructurePalette.BLOOMAZE, List.of(
                new RoomEntry(RoomTypeRegistry.BLOOMAZE_BOSS_ROOM, Optional.of(new Pos(11, 3, 11)), true),
                new RoomEntry(RoomTypeRegistry.CREEPER_ROOM, Optional.empty(), false),
                new RoomEntry(new OakTreeRoomOptions(Optional.of(DDChestLootTableProvider.BLOOMAZE_BASIC), Optional.of(DDChestLootTableProvider.BLOOMAZE_SECRET)), Optional.empty(), false)
        ), false)));
        context.register(GLOOMAZE, new MazeStructure(stronghold(biomes.getOrThrow(DDTags.Biomes.HAS_GLOOMAZE), mazeSpawnOverrides), new MazeStructureSettings(29, 5, 29, 3, MazeStructurePalette.GLOOMAZE, List.of(
                new RoomEntry(RoomTypeRegistry.GLOOMAZE_BOSS_ROOM, Optional.of(new Pos(11, 1, 11)), true),
                new RoomEntry(new OakTreeRoomOptions(Optional.of(DDChestLootTableProvider.GLOOMAZE_BASIC), Optional.of(DDChestLootTableProvider.GLOOMAZE_SECRET)), Optional.empty(), false)
        ), false)));

        context.register(CASTLE, new JigsawStructure(stronghold(biomes.getOrThrow(DDTags.Biomes.HAS_CASTLE)), pools.getOrThrow(DDPools.CASTLE_CASTLES), Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.aboveBottom(20)), true, Optional.empty(), 116));
        context.register(SCULK_RUINS, new JigsawStructure(stronghold(biomes.getOrThrow(DDTags.Biomes.HAS_SCULK_RUINS)), pools.getOrThrow(DDPools.SCULK_RUINS_TOP), 7, UniformHeight.of(VerticalAnchor.aboveBottom(18), VerticalAnchor.belowTop(28)), false));
        context.register(WATCHTOWER, new JigsawStructure(surfaceStructure(biomes.getOrThrow(DDTags.Biomes.HAS_WATCHTOWER)), pools.getOrThrow(DDPools.WATCHTOWER), 7, UniformHeight.of(VerticalAnchor.aboveBottom(18), VerticalAnchor.belowTop(28)), false));
        context.register(VILLAGER_CAMP, new JigsawStructure(surfaceStructure(biomes.getOrThrow(DDTags.Biomes.HAS_VILLAGER_CAMP)), pools.getOrThrow(DDPools.VILLAGER_CAMP), 7, UniformHeight.of(VerticalAnchor.aboveBottom(18), VerticalAnchor.belowTop(28)), false));
    }

    private static Structure.StructureSettings surfaceStructure(HolderSet<Biome> biomes) {
        return surfaceStructure(biomes, Map.of());
    }

    private static Structure.StructureSettings surfaceStructure(HolderSet<Biome> biomes, Map<MobCategory, StructureSpawnOverride> spawnOverrides) {
        return new Structure.StructureSettings(biomes, spawnOverrides, GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_BOX);
    }

    private static Structure.StructureSettings stronghold(HolderSet<Biome> biomes) {
        return surfaceStructure(biomes, Map.of());
    }

    private static Structure.StructureSettings stronghold(HolderSet<Biome> biomes, Map<MobCategory, StructureSpawnOverride> spawnOverrides) {
        return new Structure.StructureSettings(biomes, spawnOverrides, GenerationStep.Decoration.STRONGHOLDS, TerrainAdjustment.BEARD_BOX);
    }

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, DeeperDarker.id(name));
    }
}
