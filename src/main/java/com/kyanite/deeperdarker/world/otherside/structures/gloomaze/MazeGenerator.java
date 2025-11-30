package com.kyanite.deeperdarker.world.otherside.structures.gloomaze;

import com.mojang.datafixers.util.Pair;
import net.minecraft.util.RandomSource;
import org.joml.Vector3i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class MazeGenerator {
    public abstract TileType[][][] generate(RandomSource random);

    protected int[][] weightedOrder(RandomSource random, int[][] arr, float[] weights) {
        int[][] result = new int[arr.length][];

        List<Pair<int[], Float>> pool = new ArrayList<>();
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

    public enum TileType {
        PATH,
        WALL,
        ENDPOINT,
        DEBUG
    }
}
