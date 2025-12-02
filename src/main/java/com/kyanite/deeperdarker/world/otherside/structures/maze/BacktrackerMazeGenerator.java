package com.kyanite.deeperdarker.world.otherside.structures.maze;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.jetbrains.annotations.Nullable;

public class BacktrackerMazeGenerator extends MazeGenerator {
    private int width;
    private int height;
    private int depth;
    private BoundingBox center;
    boolean weighted; // temporary
    private static final float[] weights = {
            0.25f,  // weight for up
            0.25f,  // weight for down
            1.0f,  // weight for west
            1.0f,   // weight for east
            1.0f,  // weight for south
            1.0f   // weight for north
    };

    public BacktrackerMazeGenerator(int width, int height, int depth, @Nullable BoundingBox center, boolean weighted) {
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
        this.weighted = weighted;
    }

    private boolean isTouchingExit(int x, int y, int z, int[] end) {
        for (Direction direction : Direction.values()) {
            if (end[0] + direction.getNormal().getX() == x && end[1] + direction.getNormal().getY() == y && end[2] + direction.getNormal().getZ() == z) return true;
        }

        return false;
    }

    @Override
    public Tile[][][] generate(RandomSource random) {
//        Stack<int[]> solution = new Stack<>();
        Pos end;
        if (center == null) {
            end = new Pos(width - 2, height - 2, depth - 1);
        } else {
            int x = (center.minX() + center.maxX()) / 2;
            end = new Pos(x + ((x - 1) % 2 == 0 ? 0 : -1), center.minY(), center.minZ() - 1);
        }

        Pos start = new Pos(1, 1, 1);
        MazeStack stack = new MazeStack(width, height, depth);
        stack.push(start);

        while (!stack.isEmpty()) {
            Pos cPos = stack.peek();
            int cx = cPos.x();
            int cy = cPos.y();
            int cz = cPos.z();

            Direction[] ordered = weighted ? weightedOrder(random, Direction.values(), weights) : Direction.allShuffled(random).toArray(new Direction[6]);

            boolean moved = false;

            for (Direction direction : ordered) {
                int dx = direction.getNormal().getX();
                int dy = direction.getNormal().getY();
                int dz = direction.getNormal().getZ();
                int nx = cx + dx * 2;
                int ny = cy + dy * 2;
                int nz = cz + dz * 2;

                if (center != null && center.isInside(nx, ny, nz)) continue;

                if (nx < 0 || ny < 0 || nz < 0) continue;
                if (nx >= width - 1 || ny >= height - 1 || nz >= depth - 1) continue;
                if (stack.get(nx, ny, nz).type() != Tile.Type.WALL) continue;

                stack.push(nx, ny, nz);
//                    if (isTouchingExit(nx, ny, nz, end)) {
//                        solution.addAll(stack);
//                    }
                moved = true;
                break;
            }

            if (!moved) {
                stack.back();
            }
        }

        stack.push(end.x(), end.y(), end.z(), Tile.START);
        stack.push(1, 1, 0, Tile.END);

        for (int ez = center.minZ(); ez < center.maxZ() + 1; ez++) {
            for (int ey = center.minY(); ey < center.maxY() + 1; ey++) {
                for (int ex = center.minX(); ex < center.maxX() + 1; ex++) {
                    stack.push(ex, ey, ez, new Tile(Tile.Type.ROOM, 0));
                }
            }
        }

        return stack.getTiles();
    }
}
