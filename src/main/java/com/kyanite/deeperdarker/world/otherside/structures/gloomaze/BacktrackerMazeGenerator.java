package com.kyanite.deeperdarker.world.otherside.structures.gloomaze;

import com.mojang.datafixers.util.Pair;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BacktrackerMazeGenerator extends MazeGenerator {
    private int width;
    private int height;
    private int depth;
    private BoundingBox center;

    private static final int[][] directions = {
            {0, 1, 0},  // up
            {0, -1, 0}, // down
            {-1, 0, 0}, // west
            {1, 0, 0},  // east
            {0, 0, 1},  // south
            {0, 0, -1}  // north
    };

    public BacktrackerMazeGenerator(int width, int height, int depth, @Nullable BoundingBox center) {
        if (width % 2 == 0) throw new IllegalArgumentException("width must be odd");
        this.width = width;
        if (height % 2 == 0) throw new IllegalArgumentException("height must be odd");
        this.height = height;
        if (depth % 2 == 0) throw new IllegalArgumentException("depth must be odd");
        this.depth = depth;
//        if (centerSide != 0) {
//            if (centerSide % 2 == 0) throw new IllegalArgumentException("centerSide must be odd");
//            if (((width - centerSide) / 2) % 2 != 0) throw new IllegalArgumentException("(width - centerSide) / 2 must be even");
//            if (((depth - centerSide) / 2) % 2 != 0) throw new IllegalArgumentException("(depth - centerSide) / 2 must be even");
//        }
        this.center = center;
    }

    private int[][] weightedOrder(RandomSource random, int[][] directions, float[] weights) {
        int[][] result = new int[directions.length][];
        List<Pair<int[], Float>> pool = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            pool.add(Pair.of(directions[i], weights[i]));
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

    private boolean isTouchingExit(int x, int y, int z, int[] end) {
        for (int[] direction : directions) {
            if (end[0] + direction[0] == x && end[1] + direction[1] == y && end[2] + direction[2] == z) return true;
        }

        return false;
    }

    @Override
    public TileType[][][] generate(RandomSource random) {
        TileType[][][] result = new TileType[width][height][depth];
//        Stack<int[]> solution = new Stack<>();

        int[] end;
        if (center == null) {
            end = new int[]{width - 2, height - 2, depth - 1};
        } else {
            int x = (center.minX() + center.maxX()) / 2;
            end = new int[]{x + ((x - 1) % 4 == 0 ? 0 : -1), center.minY(), center.minZ() - 1};
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < depth; z++) {
                    result[x][y][z] = TileType.WALL;
                }
            }
        }

        int x = 1;
        int y = 1;
        int z = 1;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y, z});
        result[x][y][z] = TileType.PATH;

        while (!stack.isEmpty()) {
            int[] cPos = stack.peek();
            int cx = cPos[0];
            int cy = cPos[1];
            int cz = cPos[2];

            float[] weights = {
                    0.25f,  // weight for up
                    0.25f,  // weight for down
                    1.0f,  // weight for west
                    1.0f,   // weight for east
                    1.0f,  // weight for south
                    1.0f   // weight for north
            };

            int[][] ordered = weightedOrder(random, directions, weights);

            boolean moved = false;

            for (int[] direction : ordered) {
                int dx = direction[0];
                int dy = direction[1];
                int dz = direction[2];
                int nx = cx + dx * 2;
                int ny = cy + dy * 2;
                int nz = cz + dz * 2;

                if (center != null && center.isInside(nx, ny, nz)) continue;

                if (nx < 0 || ny < 0 || nz < 0) continue;
                if (nx >= width - 1 || ny >= height - 1 || nz >= depth - 1) continue;
                if (result[nx][ny][nz] != TileType.WALL) continue;

                result[cx + dx][cy + dy][cz + dz] = TileType.PATH;
                result[nx][ny][nz] = TileType.PATH;

                stack.push(new int[]{nx, ny, nz});
//                    if (isTouchingExit(nx, ny, nz, end)) {
//                        solution.addAll(stack);
//                    }
                moved = true;
                break;
            }

            if (!moved) {
                stack.pop();
            }
        }

        result[end[0]][end[1]][end[2]] = TileType.ENDPOINT;
        result[1][1][0] = TileType.ENDPOINT;

        for (int ez = center.minZ(); ez < center.maxZ() + 1; ez++) {
            for (int ey = center.minY(); ey < center.maxY() + 1; ey++) {
                for (int ex = center.minX(); ex < center.maxX() + 1; ex++) {
                    result[ex][ey][ez] = TileType.PATH;
                }
            }
        }

        return result;
    }
}
