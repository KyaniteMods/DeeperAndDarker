package com.kyanite.deeperdarker.world.structures;

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

import java.util.function.Function;

public class DDPools {
    public static final ResourceKey<StructureTemplatePool> ANCIENT_TEMPLE = createKey("ancient_temple/starts");

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        Holder<StructureTemplatePool> pool = context.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY);
        Holder<StructureProcessorList> degradation = context.lookup(Registries.PROCESSOR_LIST).getOrThrow(DDProcessorLists.ANCIENT_TEMPLE_DEGRADATION);

        context.register(ANCIENT_TEMPLE, new StructureTemplatePool(pool, ImmutableList.of(Pair.of(location("ancient_temple/basement/center", degradation), 1)), StructureTemplatePool.Projection.RIGID));
        DDPools.register(context, "ancient_temple/basement/aisles", new StructureTemplatePool(pool, ImmutableList.of(Pair.of(location("ancient_temple/basement/aisles/aisle_0", degradation), 1)), StructureTemplatePool.Projection.RIGID));
        DDPools.register(context, "ancient_temple/basement/corners", new StructureTemplatePool(pool, ImmutableList.of(Pair.of(location("ancient_temple/basement/corners/corner_0", degradation), 1)), StructureTemplatePool.Projection.RIGID));
        DDPools.register(context, "ancient_temple/basement/portal", new StructureTemplatePool(pool, ImmutableList.of(Pair.of(location("ancient_temple/basement/portal/portal_room", degradation), 1)), StructureTemplatePool.Projection.RIGID));
        DDPools.register(context, "ancient_temple/basement/rooms", new StructureTemplatePool(pool, ImmutableList.of(Pair.of(location("ancient_temple/basement/rooms/room_0", degradation), 1)), StructureTemplatePool.Projection.RIGID));
        DDPools.register(context, "ancient_temple/basement/stairs", new StructureTemplatePool(pool, ImmutableList.of(Pair.of(location("ancient_temple/basement/stairs/staircase_0", degradation), 1)), StructureTemplatePool.Projection.RIGID));
        DDPools.register(context, "ancient_temple/basement/throne", new StructureTemplatePool(pool, ImmutableList.of(Pair.of(location("ancient_temple/basement/throne/throne_room", degradation), 1)), StructureTemplatePool.Projection.RIGID));

        DDPools.register(context, "ancient_temple/upper", new StructureTemplatePool(pool, ImmutableList.of(Pair.of(location("ancient_temple/upper/fountain_room", degradation), 1), Pair.of(location("ancient_temple/upper/apex", degradation), 1)), StructureTemplatePool.Projection.RIGID));
        DDPools.register(context, "ancient_temple/upper/corners", new StructureTemplatePool(pool, ImmutableList.of(Pair.of(location("ancient_temple/upper/corners/corner_0", degradation), 1)), StructureTemplatePool.Projection.RIGID));
    }

    public static Function<StructureTemplatePool.Projection, SinglePoolElement> location(String name, Holder<StructureProcessorList> processor) {
        return (projection) -> new SinglePoolElement(Either.left(new ResourceLocation(DeeperDarker.MOD_ID, name)), processor, projection) {};
    }

    public static void register(BootstapContext<StructureTemplatePool> context, String name, StructureTemplatePool pool) {
        context.register(createKey(name), pool);
    }

    public static ResourceKey<StructureTemplatePool> createKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}