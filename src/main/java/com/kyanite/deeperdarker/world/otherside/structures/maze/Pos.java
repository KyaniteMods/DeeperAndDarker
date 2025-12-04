package com.kyanite.deeperdarker.world.otherside.structures.maze;

import net.minecraft.core.Vec3i;

public record Pos(int x, int y, int z) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pos pos = (Pos) o;

        if (x != pos.x) return false;
        if (y != pos.y) return false;
        return z == pos.z;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    @Override
    public String toString() {
        return "Pos{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public Pos add(Vec3i vec3i) {
        return new Pos(x() + vec3i.getX(), y() + vec3i.getY(), z() + vec3i.getZ());
    }
}
