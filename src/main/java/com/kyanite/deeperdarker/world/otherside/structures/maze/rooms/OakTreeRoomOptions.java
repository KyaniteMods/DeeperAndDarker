package com.kyanite.deeperdarker.world.otherside.structures.maze.rooms;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public record OakTreeRoomOptions(Optional<ResourceLocation> leavesLootTable,
                                 Optional<ResourceLocation> secretLootTable) implements RoomOptions<OakTreeRoomOptions> {
    public static final Codec<OakTreeRoomOptions> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.optionalFieldOf("leaves_loot_table").forGetter(OakTreeRoomOptions::leavesLootTable), ResourceLocation.CODEC.optionalFieldOf("secret_loot_table").forGetter(OakTreeRoomOptions::secretLootTable)).apply(instance, OakTreeRoomOptions::new));

    @Override
    public RoomType<OakTreeRoomOptions> getType() {
        return RoomTypeRegistry.OAK_TREE_ROOM;
    }
}
