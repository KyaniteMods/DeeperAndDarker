package com.kyanite.deeperdarker.world.otherside.structures.maze;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BacktrackerMazeGenerator extends MazeGenerator {
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
        super(width, height, depth);
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

    // TODO: rooms
    @Override
    public MazeResult generate(RandomSource random) {
//        Stack<int[]> solution = new Stack<>();
        Pos end;
        if (center == null) {
            end = new Pos(getWidth() - 2, getHeight() - 2, getDepth() - 1);
        } else {
            int x = (center.minX() + center.maxX()) / 2;
            end = new Pos(x + ((x - 1) % 2 == 0 ? 0 : -1), center.minY(), center.minZ() - 1);
        }

        Pos start = new Pos(1, 1, 1);
        MazeStack stack = new MazeStack(getWidth(), getHeight(), getDepth());
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
                if (nx >= getWidth() - 1 || ny >= getHeight() - 1 || nz >= getDepth() - 1) continue;
                if (stack.get(nx, ny, nz).getType() != Tile.Type.WALL) continue;

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

        stack.push(end.x(), end.y(), end.z(), Tile.start());
        stack.push(1, 1, 0, Tile.end());

        for (int ez = center.minZ(); ez < center.maxZ() + 1; ez++) {
            for (int ey = center.minY(); ey < center.maxY() + 1; ey++) {
                for (int ex = center.minX(); ex < center.maxX() + 1; ex++) {
                    stack.push(ex, ey, ez, Tile.room(0));
                }
            }
        }

        return MazeResult.createAndNavigate(stack.getTiles(), List.of(), getWidth(), getHeight(), getDepth(), start);
    }

    @Override
    public boolean addRoomEntry(RoomEntry entry) {
        return false;
    }
}
