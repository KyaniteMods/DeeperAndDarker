package com.kyanite.deeperdarker.world.otherside.structures.gloomaze;

import net.minecraft.util.RandomSource;
import org.joml.Vector3i;

import java.util.Map;

public abstract class MazeGenerator {
    public abstract TileType[][][] generate(RandomSource randomSource);

    public enum TileType {
        PATH,
        WALL,
        ENDPOINT,
        DEBUG
    }
}
