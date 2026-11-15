package com.kyanite.deeperdarker.world.otherside.structures.maze.rooms;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Optional;

public record OakTreeRoomOptions(Optional<ResourceKey<LootTable>> leavesLootTable,
                                 Optional<ResourceKey<LootTable>> secretLootTable) implements RoomOptions<OakTreeRoomOptions> {
    public static final MapCodec<OakTreeRoomOptions> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(ResourceKey.codec(Registries.LOOT_TABLE).optionalFieldOf("leaves_loot_table").forGetter(OakTreeRoomOptions::leavesLootTable), ResourceKey.codec(Registries.LOOT_TABLE).optionalFieldOf("secret_loot_table").forGetter(OakTreeRoomOptions::secretLootTable)).apply(instance, OakTreeRoomOptions::new));

    @Override
    public RoomType<OakTreeRoomOptions> getType() {
        return RoomTypeRegistry.OAK_TREE_ROOM;
    }
}
