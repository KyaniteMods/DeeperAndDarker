package com.kyanite.deeperdarker.util;

import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class DDUtil {
    public static float lerpLog(float t, float a, float b) {
        // https://www.cmu.edu/biolphys/deserno/pdf/log_interpol.pdf
        return (float) (Math.pow(a, t) * Math.pow(b, 1.0f - t));
    }

    public static List<Direction> randomDirectionsHorizontalFirst(RandomSource source) {
        List<Direction> list = new ArrayList<>(Direction.Plane.HORIZONTAL.shuffledCopy(source));
        list.addAll(Direction.Plane.VERTICAL.shuffledCopy(source));
        return list;
    }

    public static Direction relativeDirection(Vec3 vec3, AABB aabb) {
        return relativeDirection(vec3.x(), vec3.y(), vec3.z(), aabb);
    }

    public static Direction relativeDirection(double x, double y, double z, AABB aabb) {
        if (x > aabb.maxX) {
            return Direction.EAST;
        }
        if (x < aabb.minX) {
            return Direction.WEST;
        }
        if (z > aabb.maxZ) {
            return Direction.SOUTH;
        }
        if (z < aabb.minZ) {
            return Direction.NORTH;
        }
        return y > aabb.maxY ? Direction.UP : Direction.DOWN;
    }

    public static Direction directionFromDelta(Vec3 vec3) {
        return directionFromDelta(vec3.x(), vec3.y(), vec3.z());
    }

    public static Direction directionFromDelta(double x, double y, double z) {
        double absX = Math.abs(x);
        double absY = Math.abs(y);
        double absZ = Math.abs(z);
        if (absX > absY && absX > absZ) {
            return x > 0 ? Direction.EAST : Direction.WEST;
        }
        else if (absY > absZ) {
            return y > 0 ? Direction.UP : Direction.DOWN;
        }
        return z > 0 ? Direction.SOUTH : Direction.NORTH;
    }

    public static Direction directionFromDelta(float x, float y, float z) {
        float absX = Mth.abs(x);
        float absY = Mth.abs(y);
        float absZ = Mth.abs(z);
        if (absX > absY && absX > absZ) {
            return x > 0 ? Direction.EAST : Direction.WEST;
        }
        else if (absY > absZ) {
            return y > 0 ? Direction.UP : Direction.DOWN;
        }
        return z > 0 ? Direction.SOUTH : Direction.NORTH;
    }

    /**
     * Gets the minimum of the absolute value of two numbers, then returns the original number.
     * @param a first number
     * @param b second number
     * @return the number with the smallest absolute value
     */
    public static double absMin(double a, double b) {
        double absA = a < 0.0 ? -a : a;
        double absB = b < 0.0 ? -b : b;
        return Math.min(absA, absB) == absA ? a : b;
    }

    /**
     * Gets the minimum of the absolute value of two numbers, then returns the original number.
     * @param a first number
     * @param b second number
     * @return the number with the smallest absolute value
     */
    public static float absMin(float a, float b) {
        double absA = a < 0.0 ? -a : a;
        double absB = b < 0.0 ? -b : b;
        return Math.min(absA, absB) == absA ? a : b;
    }
}
