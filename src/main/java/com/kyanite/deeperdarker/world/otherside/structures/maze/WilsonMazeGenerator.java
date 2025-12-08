package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;

import java.util.*;
import java.util.stream.Collectors;

public class WilsonMazeGenerator extends MazeGenerator {
    private List<RoomEntry> roomEntries;
    private boolean makeExit;

    public WilsonMazeGenerator(int width, int height, int depth, boolean makeExit) {
        super(width, height, depth);
        this.makeExit = makeExit;
        this.roomEntries = new ArrayList<>();
    }

    public boolean addRoomEntry(RoomEntry entry) {
        if (entry.required()) {
            roomEntries.add(0, entry);
            return true;
        } else {
            return roomEntries.add(entry);
        }
    }

    private static Tile[] deepCopy(Tile[] original) {
        Tile[] copy = new Tile[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].copy();
        }
        return copy;
    }

    private static Tile[][] deepCopy(Tile[][] original) {
        Tile[][] copy = new Tile[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = deepCopy(original[i]);
        }
        return copy;
    }

    private static Tile[][][] deepCopy(Tile[][][] original) {
        Tile[][][] copy = new Tile[original.length][][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = deepCopy(original[i]);
        }
        return copy;
    }

    private Tile[][][] randomWalk(RandomSource random, List<Pos> remainingPositions, Tile[][][] partialResult) {
        Pos start = remainingPositions.get(random.nextInt(remainingPositions.size()));

        MazeStack mazeStack = new MazeStack(deepCopy(partialResult), getWidth(), getHeight(), getDepth());

        Pos currentPos = start;

        mazeStack.push(currentPos);

        while (partialResult[currentPos.x()][currentPos.y()][currentPos.z()].getType() != Tile.Type.PATH) {
            Direction[] ordered = Direction.allShuffled(random).toArray(new Direction[6]);
            Pos newPos = null;
            for (Direction direction : ordered) {
                Pos candidate = new Pos(currentPos.x() + direction.getNormal().getX() * 2, currentPos.y() + direction.getNormal().getY() * 2, currentPos.z() + direction.getNormal().getZ() * 2);
                if (mazeStack.size() >= 2 && mazeStack.get(mazeStack.size() - 2).equals(candidate)) continue;
                if (candidate.x() < 0 || candidate.y() < 0 || candidate.z() < 0) continue;
                if (candidate.x() >= getWidth() - 1 || candidate.y() >= getHeight() - 1 || candidate.z() >= getDepth() - 1) continue;
                if (partialResult[candidate.x()][candidate.y()][candidate.z()].getType() == Tile.Type.ROOM) continue;
                newPos = candidate;
                break;
            }
            if (newPos == null) throw new IllegalStateException("newPos is null");

            int posIndex = mazeStack.indexOf(newPos);
            if (posIndex >= 0) {
                while (mazeStack.size() > posIndex + 1) {
                    mazeStack.pop();
                }
            } else {
                mazeStack.push(newPos);
            }
            currentPos = newPos;
        }

        remainingPositions.removeAll(mazeStack);
        return mazeStack.getTiles();
    }

    @Override
    public MazeResult generate(RandomSource random) {
        List<Pos> remainingPositions = new ArrayList<>();
        Tile[][][] result = new Tile[getWidth()][getHeight()][getDepth()];

        for (int z = 0; z < getDepth(); z++) {
            for (int y = 0; y < getHeight(); y++) {
                for (int x = 0; x < getWidth(); x++) {
                    result[x][y][z] = Tile.wall();
                    if (x % 2 != 0 && y % 2 != 0 && z % 2 != 0) remainingPositions.add(new Pos(x, y, z));
                }
            }
        }

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < roomEntries.size(); i++) {
            RoomEntry entry = roomEntries.get(i);
            if (entry.pos().isPresent()) {
                Pos pos = entry.pos().get();
                if (!entry.fits(result, getWidth(), getHeight(), getDepth(), pos)) throw new IllegalArgumentException("Room " + entry.id().toString() + " does not fit in specified position");

                rooms.add(placeRoom(random, result, remainingPositions, entry, pos, i));
                continue;
            }

            if (getWidth() - entry.width() < 0 || getHeight() - entry.height() < 0 || getDepth() - entry.depth() < 0) {
                DeeperDarker.LOGGER.warn("Room " + entry.id().toString() + " does not fit in maze of size " + getWidth() + "x" + getHeight() + "x" + getDepth());
                continue;
            }

            boolean placed = false;
            List<Pos> validRemainingPositions = remainingPositions.stream().filter(pos -> pos.x() >= 3 || pos.y() >= 3 || pos.z() >= 3).toList();
            for (int attempts = 0; attempts < 10; attempts++) {
                int index = random.nextInt(validRemainingPositions.size());
                Pos pos = validRemainingPositions.get(index);
                if (!entry.fits(result, getWidth(), getHeight(), getDepth(), pos)) continue;
                rooms.add(placeRoom(random, result, remainingPositions, entry, pos, i));
                placed = true;
                break;
            }
            if (placed || !entry.required()) continue;

            for (Pos pos : validRemainingPositions) {
                if (!entry.fits(result, getWidth(), getHeight(), getDepth(), pos)) continue;
                rooms.add(placeRoom(random, result, remainingPositions, entry, pos, i));
                placed = true;
                break;
            }
            if (!placed) throw new IllegalArgumentException("Required room " + entry.id().toString() + " does not fit in maze of size " + getWidth() + "x" + getHeight() + "x" + getDepth());
        }

        int index = random.nextInt(remainingPositions.size());
        Pos pos = remainingPositions.get(index);
        result[pos.x()][pos.y()][pos.z()] = Tile.path();
        remainingPositions.remove(index);

        while (!remainingPositions.isEmpty()) {
            result = randomWalk(random, remainingPositions, result);
        }

        Pos start = new Pos(1, 1, 0);
        result[start.x()][start.y()][start.z()] = Tile.start();

        if (makeExit) {
            Pos end = new Pos(getWidth() - 2, getHeight() - 2, getDepth() - 1);
            result[end.x()][end.y()][end.z()] = Tile.end();
        }

        return MazeResult.createAndNavigate(result, rooms, getWidth(), getHeight(), getDepth(), start);
    }

    private Room placeRoom(RandomSource random, Tile[][][] result, List<Pos> remainingPositions, RoomEntry entry, Pos pos, int i) {
        Set<Direction> entranceDirections = Arrays.stream(Direction.values()).filter(direction -> direction != Direction.DOWN).collect(Collectors.toSet());
        List<Pos> entrancePositions = new ArrayList<>();
        for (int z = pos.z(); z < pos.z() + entry.depth(); z++) {
            for (int y = pos.y(); y < pos.y() + entry.height(); y++) {
                for (int x = pos.x(); x < pos.x() + entry.width(); x++) {
                    result[x][y][z] = Tile.room(i);
                    remainingPositions.remove(new Pos(x, y, z));
                    if (x == pos.x() || x == pos.x() + entry.width() - 1 || y == pos.y() || y == pos.y() + entry.height() - 1 || z == pos.z() || z == pos.z() + entry.depth() - 1) {
                        for (Direction direction : entranceDirections) {
                            Vec3i normal = direction.getNormal();
                            int checkedX = x + normal.getX() * 2;
                            int checkedY = y + normal.getY() * 2;
                            int checkedZ = z + normal.getZ() * 2;
                            if (!(checkedX >= pos.x() && checkedY >= pos.y() && checkedZ >= pos.z() && checkedX <= pos.x() + entry.width() - 1 && checkedY <= pos.y() + entry.height() - 1 && checkedZ <= pos.z() + entry.depth() - 1) && checkedX < getWidth() && checkedX % 2 != 0 && checkedY < getHeight() && checkedY % 2 != 0 && checkedZ < getDepth() && checkedZ % 2 != 0) {
                                entrancePositions.add(new Pos(x + normal.getX(), y + normal.getY(), z + normal.getZ()));
                            }
                        }
                    }
                }
            }
        }
        Pos entrancePos = entrancePositions.get(random.nextInt(entrancePositions.size()));
        result[entrancePos.x()][entrancePos.y()][entrancePos.z()] = Tile.entrance(i);
        remainingPositions.remove(entrancePos);

        return entry.toRoom(pos, entrancePos);
    }
}
