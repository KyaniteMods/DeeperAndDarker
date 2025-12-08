package com.kyanite.deeperdarker.world.otherside.structures.maze;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

import java.util.*;

public class WilsonMazeGenerator extends MazeGenerator {
    private boolean makeExit;

    public WilsonMazeGenerator(int width, int height, int depth, boolean makeExit) {
        super(width, height, depth);
        this.makeExit = makeExit;
    }

    private void randomWalk(RandomSource random, MazeState state) {
        Pos currentPos = state.getRemainingPositions().get(random.nextInt(state.getRemainingPositions().size()));

        state.walk(currentPos);

        while (state.get(currentPos.x(), currentPos.y(), currentPos.z()).getType() != Tile.Type.PATH) {
            Direction[] ordered = Direction.allShuffled(random).toArray(new Direction[6]);
            Pos newPos = null;
            for (Direction direction : ordered) {
                Pos candidate = new Pos(currentPos.x() + direction.getNormal().getX() * 2, currentPos.y() + direction.getNormal().getY() * 2, currentPos.z() + direction.getNormal().getZ() * 2);
                if (state.getCurrentWalk().size() >= 2 && state.getCurrentWalk().get(state.getCurrentWalk().size() - 2).equals(candidate)) continue;
                if (candidate.x() < 0 || candidate.y() < 0 || candidate.z() < 0) continue;
                if (candidate.x() >= getWidth() - 1 || candidate.y() >= getHeight() - 1 || candidate.z() >= getDepth() - 1) continue;
                if (state.get(candidate.x(), candidate.y(), candidate.z()).getType() == Tile.Type.ROOM) continue;
                newPos = candidate;
                break;
            }
            if (newPos == null) throw new IllegalStateException("newPos is null");

            int posIndex = state.getCurrentWalk().indexOf(newPos);
            if (posIndex >= 0) {
                while (state.getCurrentWalk().size() > posIndex + 1) {
                    state.revertWalk();
                }
            } else {
                state.walk(newPos);
            }
            currentPos = newPos;
        }

        state.merge();
    }

    @Override
    public MazeResult generate(RandomSource random) {
        MazeState state = new MazeState(getWidth(), getHeight(), getDepth());

        List<Room> rooms = placeRoomEntries(state, random);

        int index = random.nextInt(state.getRemainingPositions().size());
        Pos pos = state.getRemainingPositions().get(index);
        state.set(pos.x(), pos.y(), pos.z(), Tile.path());

        while (!state.getRemainingPositions().isEmpty()) {
            randomWalk(random, state);
        }

        Pos start = new Pos(1, 1, 0);
        state.set(start.x(), start.y(), start.z(), Tile.start());

        if (makeExit) {
            Pos end = new Pos(getWidth() - 2, getHeight() - 2, getDepth() - 1);
            state.set(end.x(), end.y(), end.z(), Tile.end());
        }

        return MazeResult.create(state.getTiles(), rooms, getWidth(), getHeight(), getDepth(), start);
    }
}
