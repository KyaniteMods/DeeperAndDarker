package com.kyanite.deeperdarker.world.structures;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class DDPools {
    public static final DeferredRegister<StructureTemplatePool> POOLS = DeferredRegister.create(Registry.TEMPLATE_POOL_REGISTRY, DeeperDarker.MOD_ID);
    public static final ResourceLocation EMPTY = Pools.EMPTY.location();

    public static final RegistryObject<StructureTemplatePool> ANCIENT_TEMPLE = POOLS.register("ancient_temple/starts", () -> new StructureTemplatePool(location("ancient_temple/starts"), EMPTY, ImmutableList.of(Pair.of(structure("ancient_temple/basement/center_0"), 1), Pair.of(structure("ancient_temple/basement/center_1"), 1), Pair.of(structure("ancient_temple/basement/center_2"), 1), Pair.of(structure("ancient_temple/basement/center_3"), 1)), StructureTemplatePool.Projection.RIGID));
    public static final RegistryObject<StructureTemplatePool> TEMPLE_BASEMENT_AISLES = POOLS.register("ancient_temple/basement/aisles", () -> new StructureTemplatePool(location("ancient_temple/basement/aisles"), EMPTY, ImmutableList.of(Pair.of(structure("ancient_temple/basement/aisles/secret_aisle"), 1), Pair.of(structure("ancient_temple/basement/aisles/aisle_0"), 1), Pair.of(structure("ancient_temple/basement/aisles/aisle_1"), 1), Pair.of(structure("ancient_temple/basement/aisles/aisle_2"), 1), Pair.of(structure("ancient_temple/basement/aisles/aisle_3"), 1), Pair.of(structure("ancient_temple/basement/aisles/aisle_4"), 1), Pair.of(structure("ancient_temple/basement/aisles/aisle_5"), 1), Pair.of(structure("ancient_temple/basement/aisles/aisle_6"), 1)), StructureTemplatePool.Projection.RIGID));
    public static final RegistryObject<StructureTemplatePool> TEMPLE_BASEMENT_CORNERS = POOLS.register("ancient_temple/basement/corners", () -> new StructureTemplatePool(location("ancient_temple/basement/corners"), EMPTY, ImmutableList.of(Pair.of(structure("ancient_temple/basement/corners/corner_0"), 3), Pair.of(structure("ancient_temple/basement/corners/corner_1"), 1)), StructureTemplatePool.Projection.RIGID));
    public static final RegistryObject<StructureTemplatePool> TEMPLE_BASEMENT_ROOMS = POOLS.register("ancient_temple/basement/rooms", () -> new StructureTemplatePool(location("ancient_temple/basement/rooms"), EMPTY, ImmutableList.of(Pair.of(structure("ancient_temple/basement/rooms/portal_0"), 1), Pair.of(structure("ancient_temple/basement/rooms/portal_1"), 1), Pair.of(structure("ancient_temple/basement/rooms/throne"), 1), Pair.of(structure("ancient_temple/basement/rooms/room_0"), 1), Pair.of(structure("ancient_temple/basement/rooms/room_1"), 1), Pair.of(structure("ancient_temple/basement/rooms/room_2"), 1), Pair.of(structure("ancient_temple/basement/rooms/room_3"), 1), Pair.of(structure("ancient_temple/basement/rooms/room_4"), 1)), StructureTemplatePool.Projection.RIGID));
    public static final RegistryObject<StructureTemplatePool> TEMPLE_BASEMENT_STAIRS = POOLS.register("ancient_temple/basement/stairs", () -> new StructureTemplatePool(location("ancient_temple/basement/stairs"), EMPTY, ImmutableList.of(Pair.of(structure("ancient_temple/basement/stairs/staircase_0"), 2), Pair.of(structure("ancient_temple/basement/stairs/staircase_1"), 2), Pair.of(structure("ancient_temple/basement/stairs/staircase_2"), 1), Pair.of(structure("ancient_temple/basement/stairs/staircase_3"), 1), Pair.of(structure("ancient_temple/basement/stairs/staircase_4"), 1), Pair.of(structure("ancient_temple/basement/stairs/staircase_5"), 1)), StructureTemplatePool.Projection.RIGID));
    public static final RegistryObject<StructureTemplatePool> TEMPLE_UPPER = POOLS.register("ancient_temple/upper", () -> new StructureTemplatePool(location("ancient_temple/upper"), EMPTY, ImmutableList.of(Pair.of(structure("ancient_temple/upper/fountain_0"), 1), Pair.of(structure("ancient_temple/upper/fountain_1"), 1), Pair.of(structure("ancient_temple/upper/fountain_2"), 1), Pair.of(structure("ancient_temple/upper/apex_0"), 1), Pair.of(structure("ancient_temple/upper/apex_1"), 1)), StructureTemplatePool.Projection.RIGID));
    public static final RegistryObject<StructureTemplatePool> TEMPLE_UPPER_CORNERS = POOLS.register("ancient_temple/upper/corners", () -> new StructureTemplatePool(location("ancient_temple/upper/corners"), EMPTY, ImmutableList.of(Pair.of(structure("ancient_temple/upper/corners/corner_0"), 1), Pair.of(structure("ancient_temple/upper/corners/corner_1"), 1), Pair.of(structure("ancient_temple/upper/corners/corner_2"), 1), Pair.of(structure("ancient_temple/upper/corners/corner_3"), 1), Pair.of(structure("ancient_temple/upper/corners/corner_4"), 1), Pair.of(structure("ancient_temple/upper/corners/corner_5"), 1), Pair.of(structure("ancient_temple/upper/corners/corner_6"), 1)), StructureTemplatePool.Projection.RIGID));
    public static final RegistryObject<StructureTemplatePool> TEMPLE_UPPER_ROOMS = POOLS.register("ancient_temple/upper/rooms", () -> new StructureTemplatePool(location("ancient_temple/upper/rooms"), EMPTY, ImmutableList.of(Pair.of(structure("ancient_temple/upper/rooms/room_0"), 1), Pair.of(structure("ancient_temple/upper/rooms/room_1"), 1), Pair.of(structure("ancient_temple/upper/rooms/room_2"), 1), Pair.of(structure("ancient_temple/upper/rooms/room_3"), 1)), StructureTemplatePool.Projection.RIGID));
    public static final RegistryObject<StructureTemplatePool> TEMPLE_MOBS = POOLS.register("ancient_temple/mobs", () -> new StructureTemplatePool(location("ancient_temple/mobs"), EMPTY, ImmutableList.of(Pair.of(structure("ancient_temple/mobs/shattered"), 1), Pair.of(structure("ancient_temple/mobs/snapper"), 1)), StructureTemplatePool.Projection.RIGID));

    private static ResourceLocation location(String location) {
        return new ResourceLocation(DeeperDarker.MOD_ID, location);
    }

    private static Function<StructureTemplatePool.Projection, SinglePoolElement> structure(String location) {
        return (projection) -> new SinglePoolElement(Either.left(new ResourceLocation(DeeperDarker.MOD_ID, location)), DDProcessorLists.ANCIENT_TEMPLE_DEGRADATION.getHolder().get(), projection) {};
    }
}
