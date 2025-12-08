package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;

import java.util.*;
import java.util.stream.Collectors;

public abstract class MazeGenerator {
    private final int width;
    private final int height;
    private final int depth;
    private final List<RoomEntry> roomEntries;

    protected MazeGenerator(int width, int height, int depth) {
        if (width % 2 == 0) throw new IllegalArgumentException("width must be odd");
        this.width = width;
        if (height % 2 == 0) throw new IllegalArgumentException("height must be odd");
        this.height = height;
        if (depth % 2 == 0) throw new IllegalArgumentException("depth must be odd");
        this.depth = depth;
        this.roomEntries = new ArrayList<>();
    }

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

    protected List<Room> placeRoomEntries(MazeState state, RandomSource random) {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < getRoomEntries().size(); i++) {
            RoomEntry entry = getRoomEntries().get(i);
            if (entry.pos().isPresent()) {
                Pos pos = entry.pos().get();
                if (!entry.fits(state.getTiles(), width, height, depth, pos)) throw new IllegalArgumentException("Room " + entry.id().toString() + " does not fit in specified position");

                rooms.add(placeRoom(random, state, entry, pos, i));
                continue;
            }

            if (width - entry.width() < 0 || height - entry.height() < 0 || depth - entry.depth() < 0) {
                DeeperDarker.LOGGER.warn("Room " + entry.id().toString() + " does not fit in maze of size " + width + "x" + height + "x" + depth);
                continue;
            }

            boolean placed = false;
            List<Pos> validRemainingPositions = state.getRemainingPositions().stream().filter(pos -> pos.x() >= 3 || pos.y() >= 3 || pos.z() >= 3).toList();
            for (int attempts = 0; attempts < 10; attempts++) {
                int index = random.nextInt(validRemainingPositions.size());
                Pos pos = validRemainingPositions.get(index);
                if (!entry.fits(state.getTiles(), width, height, depth, pos)) continue;
                rooms.add(placeRoom(random, state, entry, pos, i));
                placed = true;
                break;
            }
            if (placed || !entry.required()) continue;

            for (Pos pos : validRemainingPositions) {
                if (!entry.fits(state.getTiles(), width, height, depth, pos)) continue;
                rooms.add(placeRoom(random, state, entry, pos, i));
                placed = true;
                break;
            }
            if (!placed) throw new IllegalArgumentException("Required room " + entry.id().toString() + " does not fit in maze of size " + width + "x" + height + "x" + depth);
        }
        return rooms;
    }

    protected Room placeRoom(RandomSource random, MazeState stack, RoomEntry entry, Pos pos, int i) {
        Set<Direction> entranceDirections = Arrays.stream(Direction.values()).filter(direction -> direction != Direction.DOWN).collect(Collectors.toSet());
        List<Pos> entrancePositions = new ArrayList<>();
        for (int z = pos.z(); z < pos.z() + entry.depth(); z++) {
            for (int y = pos.y(); y < pos.y() + entry.height(); y++) {
                for (int x = pos.x(); x < pos.x() + entry.width(); x++) {
                    stack.set(x, y, z, Tile.room(i));
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
        stack.set(entrancePos.x(), entrancePos.y(), entrancePos.z(), Tile.entrance(i));

        return entry.toRoom(pos, entrancePos);
    }

    public boolean addRoomEntry(RoomEntry entry) {
        if (entry.required()) {
            roomEntries.add(0, entry);
            return true;
        } else {
            return roomEntries.add(entry);
        }
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

    public List<RoomEntry> getRoomEntries() {
        return roomEntries;
    }
}
