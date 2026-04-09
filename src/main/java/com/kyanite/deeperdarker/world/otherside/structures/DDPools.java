package com.kyanite.deeperdarker.world.otherside.structures;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;
import java.util.function.Function;

public class DDPools {
    public static final ResourceKey<StructureTemplatePool> TEMPLE_START = createKey("ancient_temple/basement");
    public static final ResourceKey<StructureTemplatePool> CASTLE_CASTLES = createKey("castle/castles");
    public static final ResourceKey<StructureTemplatePool> CASTLE_PATHS = createKey("castle/paths");
    public static final ResourceKey<StructureTemplatePool> CASTLE_DECORATIONS = createKey("castle/decorations");
    public static final ResourceKey<StructureTemplatePool> CASTLE_SMALL_BUILDINGS = createKey("castle/small_buildings");
    public static final ResourceKey<StructureTemplatePool> CASTLE_MEDIUM_BUILDINGS = createKey("castle/medium_buildings");
    public static final ResourceKey<StructureTemplatePool> CASTLE_LARGE_BUILDINGS = createKey("castle/large_buildings");
    public static final ResourceKey<StructureTemplatePool> CASTLE_GIANT_BUILDINGS = createKey("castle/giant_buildings");
    public static final ResourceKey<StructureTemplatePool> SCULK_RUINS_TOP = createKey("sculk_ruins/top");
    public static final ResourceKey<StructureTemplatePool> SCULK_RUINS_BOTTOM = createKey("sculk_ruins/bottom");
    public static final ResourceKey<StructureTemplatePool> WATCHTOWER = createKey("watchtower");

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        Holder<StructureTemplatePool> empty = context.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY);
        Holder<StructureProcessorList> ancientTempleDegradation = context.lookup(Registries.PROCESSOR_LIST).getOrThrow(DDProcessorLists.ANCIENT_TEMPLE_DEGRADATION);

        context.register(TEMPLE_START, new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("ancient_temple/basement/center_0", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/center_1", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/center_2", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/center_3", ancientTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(createKey("ancient_temple/basement/aisles"), new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("ancient_temple/basement/aisles/secret_aisle", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/aisles/aisle_0", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/aisles/aisle_1", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/aisles/aisle_2", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/aisles/aisle_3", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/aisles/aisle_4", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/aisles/aisle_5", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/aisles/aisle_6", ancientTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(createKey("ancient_temple/basement/corners"), new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("ancient_temple/basement/corners/corner_0", ancientTempleDegradation), 3), Pair.of(location("ancient_temple/basement/corners/corner_1", ancientTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(createKey("ancient_temple/basement/rooms"), new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("ancient_temple/basement/rooms/portal_0", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/rooms/portal_1", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/rooms/throne", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/rooms/room_0", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/rooms/room_1", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/rooms/room_2", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/rooms/room_3", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/rooms/room_4", ancientTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(createKey("ancient_temple/basement/stairs"), new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("ancient_temple/basement/stairs/staircase_0", ancientTempleDegradation), 2), Pair.of(location("ancient_temple/basement/stairs/staircase_1", ancientTempleDegradation), 2), Pair.of(location("ancient_temple/basement/stairs/staircase_2", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/stairs/staircase_3", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/stairs/staircase_4", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/basement/stairs/staircase_5", ancientTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(createKey("ancient_temple/upper"), new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("ancient_temple/upper/fountain_0", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/fountain_1", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/fountain_2", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/apex_0", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/apex_1", ancientTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(createKey("ancient_temple/upper/corners"), new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("ancient_temple/upper/corners/corner_0", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/corners/corner_1", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/corners/corner_2", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/corners/corner_3", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/corners/corner_4", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/corners/corner_5", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/corners/corner_6", ancientTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(createKey("ancient_temple/upper/rooms"), new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("ancient_temple/upper/rooms/room_0", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/rooms/room_1", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/rooms/room_2", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/upper/rooms/room_3", ancientTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(createKey("ancient_temple/mobs"), new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("ancient_temple/mobs/shattered", ancientTempleDegradation), 1), Pair.of(location("ancient_temple/mobs/snapper", ancientTempleDegradation), 1)), StructureTemplatePool.Projection.RIGID));

        context.register(CASTLE_CASTLES, new StructureTemplatePool(empty, ImmutableList.of(
                Pair.of(location("castle/paths/castle_1"), 1),
                Pair.of(location("castle/paths/castle_2"), 1)
        ), StructureTemplatePool.Projection.RIGID));
        context.register(CASTLE_PATHS, new StructureTemplatePool(empty, ImmutableList.of(
                Pair.of(location("castle/paths/bridge"), 1),
                Pair.of(location("castle/paths/buildings_1"), 5),
                Pair.of(location("castle/paths/buildings_2"), 5),
                Pair.of(location("castle/paths/buildings_3"), 5),
                Pair.of(location("castle/paths/buildings_4"), 5),
                Pair.of(location("castle/paths/buildings_5"), 5),
                Pair.of(location("castle/paths/path_1"), 5),
                Pair.of(location("castle/paths/wall_1"), 5),
                Pair.of(location("castle/paths/wall_2"), 5)
        ), StructureTemplatePool.Projection.RIGID));
        context.register(CASTLE_DECORATIONS, new StructureTemplatePool(empty, ImmutableList.of(
                Pair.of(location("castle/decoration_1"), 1),
                Pair.of(location("castle/decoration_2"), 1),
                Pair.of(location("castle/decoration_3"), 1),
                Pair.of(location("castle/decoration_4"), 1),
                Pair.of(location("castle/decoration_5"), 1),
                Pair.of(location("castle/decoration_6"), 1),
                Pair.of(location("castle/decoration_7"), 1),
                Pair.of(location("castle/decoration_8"), 1),
                Pair.of(location("castle/decoration_9"), 1),
                Pair.of(location("castle/decoration_10"), 1),
                Pair.of(location("castle/decoration_11"), 1),
                Pair.of(location("castle/decoration_12"), 1),
                Pair.of(location("castle/decoration_13"), 1),
                Pair.of(location("castle/decoration_14"), 1),
                Pair.of(location("castle/decoration_15"), 1),
                Pair.of(location("castle/decoration_16"), 1),
                Pair.of(location("castle/decoration_17"), 1),
                Pair.of(location("castle/decoration_18"), 1)
        ), StructureTemplatePool.Projection.RIGID));
        context.register(CASTLE_SMALL_BUILDINGS, new StructureTemplatePool(empty, ImmutableList.of(
                Pair.of(location("castle/small_building_1"), 1),
                Pair.of(location("castle/small_building_2"), 1),
                Pair.of(location("castle/small_building_3"), 1),
                Pair.of(location("castle/small_building_4"), 1),
                Pair.of(location("castle/small_building_5"), 1),
                Pair.of(location("castle/small_building_6"), 1),
                Pair.of(location("castle/small_building_7"), 1),
                Pair.of(location("castle/small_building_8"), 1)
        ), StructureTemplatePool.Projection.RIGID));
        context.register(CASTLE_MEDIUM_BUILDINGS, new StructureTemplatePool(empty, ImmutableList.of(
                Pair.of(location("castle/medium_building_1"), 1),
                Pair.of(location("castle/medium_building_2"), 1),
                Pair.of(location("castle/medium_building_3"), 1),
                Pair.of(location("castle/medium_building_4"), 1),
                Pair.of(location("castle/medium_building_5"), 1),
                Pair.of(location("castle/medium_building_6"), 1),
                Pair.of(location("castle/medium_building_7"), 1),
                Pair.of(location("castle/medium_building_8"), 1)
        ), StructureTemplatePool.Projection.RIGID));
        context.register(CASTLE_LARGE_BUILDINGS, new StructureTemplatePool(empty, ImmutableList.of(
                Pair.of(location("castle/large_building_1"), 1),
                Pair.of(location("castle/large_building_2"), 1),
                Pair.of(location("castle/large_building_3"), 1),
                Pair.of(location("castle/large_building_4"), 1)
        ), StructureTemplatePool.Projection.RIGID));

        Holder<StructureProcessorList> sculkRuinsDegradation = context.lookup(Registries.PROCESSOR_LIST).getOrThrow(DDProcessorLists.SCULK_RUINS_DEGRADATION);

        context.register(SCULK_RUINS_TOP, new StructureTemplatePool(empty, ImmutableList.of(
                Pair.of(location("sculk_ruins/top", sculkRuinsDegradation), 1)
        ), StructureTemplatePool.Projection.RIGID));
        context.register(SCULK_RUINS_BOTTOM, new StructureTemplatePool(empty, ImmutableList.of(
                Pair.of(location("sculk_ruins/bottom", sculkRuinsDegradation), 1)
        ), StructureTemplatePool.Projection.RIGID));

        context.register(WATCHTOWER, new StructureTemplatePool(empty, ImmutableList.of(
                Pair.of(location("watchtower"), 1)
        ), StructureTemplatePool.Projection.RIGID));
    }

    public static Function<StructureTemplatePool.Projection, SinglePoolElement> location(String name, Holder<StructureProcessorList> processor) {
        return projection -> new SinglePoolElement(Either.left(new ResourceLocation(DeeperDarker.MOD_ID, name)), processor, projection) {};
    }

    public static Function<StructureTemplatePool.Projection, SinglePoolElement> location(String name) {
        return projection -> new SinglePoolElement(Either.left(new ResourceLocation(DeeperDarker.MOD_ID, name)), Holder.direct(new StructureProcessorList(List.of())), projection) {};
    }

    public static ResourceKey<StructureTemplatePool> createKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}