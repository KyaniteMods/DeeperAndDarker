package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.mojang.serialization.Codec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;

import java.util.stream.IntStream;

public record Pos(int x, int y, int z) {
    public static final Codec<Pos> CODEC = Codec.INT_STREAM.comapFlatMap(intStream -> Util.fixedSize(intStream, 3).map(is -> new Pos(is[0], is[1], is[2])), pos -> IntStream.of(pos.x(), pos.y(), pos.z())).stable();

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
