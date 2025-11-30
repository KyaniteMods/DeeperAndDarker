package com.kyanite.deeperdarker.world.otherside.structures.gloomaze;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class MazeGenerator {
    public abstract Tile[][][] generate(RandomSource random);

    protected Direction[] weightedOrder(RandomSource random, Direction[] arr, float[] weights) {
        Direction[] result = new Direction[arr.length];

        List<Pair<Direction, Float>> pool = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            pool.add(Pair.of(arr[i], weights[i]));
        }

        int resultIndex = 0;
        while (!pool.isEmpty()) {
            float total = (float) pool.stream().mapToDouble(Pair::getSecond).sum();
            float r = random.nextFloat() * total;
            int index = 0;

            for (int i = 0; i < pool.size(); i++) {
                if (r < pool.get(i).getSecond()) {
                    index = i;
                    break;
                }
                r -= pool.get(i).getSecond();
            }

            result[resultIndex++] = pool.get(index).getFirst();
            pool.remove(index);
        }

        return result;
    }

    protected int[][] order(RandomSource random, int[][] arr) {
        int[][] result = Arrays.copyOf(arr, arr.length);
        for (int i = result.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            int[] temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        return result;
    }

    public record Pos(int x, int y, int z) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pos pos = (Pos) o;

            if (x != pos.x) return false;
            if (y != pos.y) return false;
            return z == pos.z;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + z;
            return result;
        }
    }

    public enum TileType {
        PATH,
        WALL,
        ENDPOINT,
        DEBUG
    }

    public record Tile(@NotNull TileType type, int data) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tile tile = (Tile) o;

            if (data != tile.data) return false;
            return type == tile.type;
        }

        @Override
        public int hashCode() {
            int result = type.hashCode();
            result = 31 * result + data;
            return result;
        }
    }
}
