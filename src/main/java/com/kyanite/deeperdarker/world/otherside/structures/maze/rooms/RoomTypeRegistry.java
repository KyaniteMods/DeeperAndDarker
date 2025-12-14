package com.kyanite.deeperdarker.world.otherside.structures.maze.rooms;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.otherside.structures.maze.MazeStructurePieces;
import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.RoomOptions;
import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.RoomType;
import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.SimpleRoomType;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class RoomTypeRegistry {
    public static final ResourceKey<Registry<RoomType<?>>> RESOURCE_KEY = ResourceKey.createRegistryKey(new ResourceLocation(DeeperDarker.MOD_ID, "room_type"));
    public static final Registry<RoomType<?>> REGISTRY = FabricRegistryBuilder.createSimple(RESOURCE_KEY).buildAndRegister();

    public static final SimpleRoomType BLOOMAZE_BOSS_ROOM = (SimpleRoomType) register("bloomaze/boss_room", new SimpleRoomType((options, context, settings, origin, pos, entrance) -> new MazeStructurePieces.BloomazeBossRoomPiece(origin.offset(pos.x() * settings.tileSize(), pos.y() * settings.tileSize(), pos.z() * settings.tileSize()), pos, settings.width(), settings.height(), settings.depth(), settings.tileSize(), settings.palette()), 7, 1, 7));
    public static final SimpleRoomType GLOOMAZE_BOSS_ROOM = (SimpleRoomType) register("gloomaze/boss_room", new SimpleRoomType((options, context, settings, origin, pos, entrance) -> new MazeStructurePieces.GloomazeBossRoomPiece(origin.offset(pos.x() * settings.tileSize(), pos.y() * settings.tileSize(), pos.z() * settings.tileSize()), pos, settings.width(), settings.height(), settings.depth(), settings.tileSize(), settings.palette()), 7, 1, 7));
    public static final OakTreeRoomType OAK_TREE_ROOM = (OakTreeRoomType) register("oak_tree_room", new OakTreeRoomType((options, context, settings, origin, pos, entrance) -> new MazeStructurePieces.OakTreeRoomPiece(origin.offset(pos.x() * settings.tileSize(), pos.y() * settings.tileSize(), pos.z() * settings.tileSize()), pos, settings.width(), settings.height(), settings.depth(), settings.tileSize(), settings.palette(), options.leavesLootTable().orElse(null), options.secretLootTable().orElse(null)), 3, 3, 3));

    public static final Codec<RoomOptions<?>> CODEC = REGISTRY.byNameCodec().dispatch("type", RoomOptions::getType, RoomType::codec);

    public static <T extends RoomOptions<T>> RoomType<T> register(String id, RoomType<T> type) {
        return Registry.register(REGISTRY, new ResourceLocation(DeeperDarker.MOD_ID, id), type);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Initializing room type registry");
    }
}
