package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

import java.util.*;

public abstract class MazeGenerator {
    public abstract MazeResult generate(RandomSource random);

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
}
