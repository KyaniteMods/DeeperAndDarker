package com.kyanite.deeperdarker.world.otherside.structures.maze.generation;

import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.Room;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

import java.util.List;

public class BacktrackerMazeGenerator extends MazeGenerator {
    boolean makeExit;
    boolean weighted; // temporary
    private static final float[] weights = {
            0.25f,  // weight for up
            0.25f,  // weight for down
            1.0f,  // weight for west
            1.0f,   // weight for east
            1.0f,  // weight for south
            1.0f   // weight for north
    };

    public BacktrackerMazeGenerator(int width, int height, int depth, boolean makeExit, boolean weighted) {
        super(width, height, depth);
        this.makeExit = makeExit;
        this.weighted = weighted;
    }

    private boolean isTouchingExit(int x, int y, int z, int[] end) {
        for (Direction direction : Direction.values()) {
            if (end[0] + direction.getNormal().getX() == x && end[1] + direction.getNormal().getY() == y && end[2] + direction.getNormal().getZ() == z) return true;
        }

        return false;
    }

    @Override
    public MazeResult generate(RandomSource random) {
//        Stack<int[]> solution = new Stack<>();

        Pos start = new Pos(1, 1, 1);
        MazeState state = new MazeState(getWidth(), getHeight(), getDepth());

        List<Room> rooms = placeRoomEntries(state, random);

        state.walk(start);

        while (!state.getCurrentWalk().isEmpty()) {
            Pos cPos = state.getCurrentWalk().peek();
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

                if (state.get(nx, ny, nz).getType() == Tile.Type.ROOM) continue;

                if (nx < 0 || ny < 0 || nz < 0) continue;
                if (nx >= getWidth() - 1 || ny >= getHeight() - 1 || nz >= getDepth() - 1) continue;
                if (state.get(nx, ny, nz).getType() != Tile.Type.WALL) continue;

                state.walk(nx, ny, nz);
//                    if (isTouchingExit(nx, ny, nz, end)) {
//                        solution.addAll(stack);
//                    }
                moved = true;
                break;
            }

            if (!moved) {
                state.walkBack();
            }
        }

        state.merge();
        state.set(1, 1, 0, Tile.start());

        if (makeExit) {
            Pos end = new Pos(getWidth() - 2, getHeight() - 2, getDepth() - 1);
            state.set(end.x(), end.y(), end.z(), Tile.end());
        }

        return MazeResult.create(state.getTiles(), rooms, getWidth(), getHeight(), getDepth(), start);
    }
}
