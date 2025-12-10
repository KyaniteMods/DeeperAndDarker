package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.DeeperDarker;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class RoomTypeRegistry {
    public static final ResourceKey<Registry<RoomType>> RESOURCE_KEY = ResourceKey.createRegistryKey(new ResourceLocation(DeeperDarker.MOD_ID, "room_type"));
    public static final Registry<RoomType> REGISTRY = FabricRegistryBuilder.createSimple(RESOURCE_KEY).buildAndRegister();

    public static final RoomType BLOOMAZE_BOSS_ROOM = register("bloomaze/boss_room", new RoomType((context, settings, origin, pos, entrance) -> new MazeStructurePieces.BloomazeBossRoomPiece(origin.offset(pos.x() * settings.tileSize(), pos.y() * settings.tileSize(), pos.z() * settings.tileSize()), pos, settings.width(), settings.height(), settings.depth(), settings.tileSize(), settings.palette()), 7, 1, 7));
    public static final RoomType GLOOMAZE_BOSS_ROOM = register("gloomaze/boss_room", new RoomType((context, settings, origin, pos, entrance) -> new MazeStructurePieces.GloomazeBossRoomPiece(origin.offset(pos.x() * settings.tileSize(), pos.y() * settings.tileSize(), pos.z() * settings.tileSize()), pos, settings.width(), settings.height(), settings.depth(), settings.tileSize(), settings.palette()), 7, 1, 7));

    public static RoomType register(String id, RoomType type) {
        return Registry.register(REGISTRY, new ResourceLocation(DeeperDarker.MOD_ID, id), type);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Initializing room type registry");
    }
}
