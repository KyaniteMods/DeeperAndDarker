package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

import java.util.*;

public abstract class MazeGenerator {
    private final int width;
    private final int height;
    private final int depth;

    protected MazeGenerator(int width, int height, int depth) {
        if (width % 2 == 0) throw new IllegalArgumentException("width must be odd");
        this.width = width;
        if (height % 2 == 0) throw new IllegalArgumentException("height must be odd");
        this.height = height;
        if (depth % 2 == 0) throw new IllegalArgumentException("depth must be odd");
        this.depth = depth;
    }

    public abstract MazeResult generate(RandomSource random);

    public abstract boolean addRoomEntry(RoomEntry entry);

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }
}
