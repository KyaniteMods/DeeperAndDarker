package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

public record MazeStructureSettings(int width, int height, int depth, int tileSize, MazeStructurePalette palette, List<RoomEntry> rooms, boolean makeExit) {
    public static final Codec<MazeStructureSettings> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("width").forGetter(MazeStructureSettings::width),
            Codec.INT.fieldOf("height").forGetter(MazeStructureSettings::height),
            Codec.INT.fieldOf("depth").forGetter(MazeStructureSettings::depth),
            Codec.INT.fieldOf("tile_size").forGetter(MazeStructureSettings::tileSize),
            MazeStructurePalette.CODEC.fieldOf("palette").forGetter(MazeStructureSettings::palette),
            RoomEntry.CODEC.listOf().optionalFieldOf("rooms", List.of()).forGetter(MazeStructureSettings::rooms),
            Codec.BOOL.optionalFieldOf("make_exit", false).forGetter(MazeStructureSettings::makeExit)).apply(instance, MazeStructureSettings::new));
}
