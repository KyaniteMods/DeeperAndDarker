package com.kyanite.deeperdarker.world.otherside.structures.maze.generation;

import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.Room;
import net.minecraft.core.Direction;

import java.util.*;

public final class MazeResult {
    private final Tile[][][] result;
    private final List<Room> rooms;
    private final int width;
    private final int height;
    private final int depth;
    private final Pos start;
    private List<Pos> positions;

    private MazeResult(Tile[][][] result, List<Room> rooms, int width, int height, int depth, Pos start) {
        this.result = result;
        this.rooms = rooms;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.start = start;
        positions = new ArrayList<>();
    }

    public Tile get(int x, int y, int z) {
        return result()[x][y][z];
    }

    public Tile get(Pos pos) {
        return get(pos.x(), pos.y(), pos.z());
    }

    public static MazeResult create(Tile[][][] result, List<Room> rooms, int width, int height, int depth, Pos start) {
        MazeResult mazeResult = new MazeResult(result, rooms, width, height, depth, start);
        mazeResult.navigate();
        return mazeResult;
    }

    public void navigate() {
        positions.clear();
        for (int z = 0; z < depth(); z++) {
            for (int y = 0; y < height(); y++) {
                for (int x = 0; x < width(); x++) {
                    Tile tile = get(x, y, z);
                    if (tile.getType() == Tile.Type.PATH) tile.setData(-1);
                    else positions.add(new Pos(x, y, z));
                }
            }
        }

        Queue<Pos> queue = new ArrayDeque<>();
        if (get(start().x(), start().y(), start().z()).getType() == Tile.Type.PATH)
            get(start().x(), start().y(), start().z()).setData(0);
        queue.add(start());
        positions.add(start());

        while (!queue.isEmpty()) {
            Pos pos = queue.remove();
            int distance = get(pos.x(), pos.y(), pos.z()).getData();
            for (Direction direction : Direction.values()) {
                Pos neighbor = pos.add(direction.getNormal());
                if (neighbor.x() < 0 || neighbor.y() < 0 || neighbor.z() < 0 || neighbor.x() >= width() || neighbor.y() >= height() || neighbor.z() >= depth())
                    continue;
                Tile neighborTile = get(neighbor.x(), neighbor.y(), neighbor.z());
                if (neighborTile.getType() == Tile.Type.PATH && neighborTile.getData() == -1) {
                    neighborTile.setData(distance + 1);
                    queue.add(neighbor);
                    positions.add(neighbor);
                }
            }
        }
    }

    public boolean isWithinBounds(Pos pos) {
        return pos.x() >= 0 && pos.y() >= 0 && pos.z() >= 0 && pos.x() <= width() - 1 && pos.y() <= height() - 1 && pos.z() <= depth() - 1;
    }

    public Tile[][][] result() {
        return result;
    }

    public List<Room> rooms() {
        return rooms;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public int depth() {
        return depth;
    }

    public Pos start() {
        return start;
    }

    public List<Pos> getPositions() {
        return positions;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MazeResult) obj;
        return Objects.equals(this.result, that.result) &&
                Objects.equals(this.rooms, that.rooms) &&
                this.width == that.width &&
                this.height == that.height &&
                this.depth == that.depth &&
                Objects.equals(this.start, that.start);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, rooms, width, height, depth, start);
    }

    @Override
    public String toString() {
        return "MazeResult[" +
                "result=" + Arrays.deepToString(result) + ", " +
                "rooms=" + rooms + ", " +
                "width=" + width + ", " +
                "maxFloeHeight=" + height + ", " +
                "depth=" + depth + ", " +
                "start=" + start + ']';
    }

}
