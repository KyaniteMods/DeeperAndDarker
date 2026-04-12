package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DDUtil {
    public static final String HAS_HORNS_TAG = "deeperdarker:has_horns";
    public static final String ACID_RESISTANT_TAG = "deeperdarker:acid_resistant";
    public static final String AUGMENTED_TAG = "deeperdarker:augmented";
    public static final String ITEM_TAG = "deeperdarker:item";

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

    public static void renderFlatFace(PoseStack poseStack, VertexConsumer vertexConsumer, int color, float x, float y, float z, float width, float height, float u, float v, int spriteWidth, int spriteHeight, int light, int overlay) {
        PoseStack.Pose last = poseStack.last();
        Matrix4f pose = last.pose();
        Matrix3f normal = last.normal();

        float x1 = x / 16.0f;
        float y1 = y / 16.0f;
        float z1 = z / 16.0f;

        float x2 = x1 + width / 16.0f;
        float y2 = y1 + height / 16.0f;

        float v1 = v + height / spriteHeight;

        float u2n = u + width / spriteWidth;

        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x1, z1, x2, z1, u2n, u, v1, v, light, overlay);
    }

    public static void renderCuboidSides(PoseStack poseStack, VertexConsumer vertexConsumer, int color, float x, float y, float z, float width, float height, float depth, float u, float v, int spriteWidth, int spriteHeight, int light, int overlay) {
        PoseStack.Pose last = poseStack.last();
        Matrix4f pose = last.pose();
        Matrix3f normal = last.normal();

        float x1 = x / 16.0f;
        float y1 = y / 16.0f;
        float z1 = z / 16.0f;

        float x2 = x1 + width / 16.0f;
        float y2 = y1 + height / 16.0f;
        float z2 = z1 + depth / 16.0f;

        float v2 = v + depth / spriteHeight;
        float v1 = v2 + height / spriteHeight;

        float u1w = u;
        float u1n = u1w + depth / spriteWidth;
        float u1e = u1n + width / spriteWidth;
        float u1s = u1e + depth / spriteWidth;

        float u2w = u1w + depth / spriteWidth;
        float u2n = u1n + width / spriteWidth;
        float u2e = u1e + depth / spriteWidth;
        float u2s = u1s + width / spriteWidth;

        // NORTH
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x1, z1, x2, z1, u2n, u1n, v1, v2, light, overlay);
        // SOUTH
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x2, z2, x1, z2, u2s, u1s, v1, v2, light, overlay);
        // WEST
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x1, z2, x1, z1, u2w, u1w, v1, v2, light, overlay);
        // EAST
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x2, z1, x2, z2, u2e, u1e, v1, v2, light, overlay);
    }

    public static void renderQuad(Matrix4f pose, Matrix3f normal, VertexConsumer vertexConsumer, int color, float y2, float y1, float x1, float z1, float x2, float z2, float u2, float u1, float v1, float v2, int light, int overlay) {
        addVertex(pose, normal, vertexConsumer, color, y1, x1, z1, u1, v1, light, overlay);
        addVertex(pose, normal, vertexConsumer, color, y2, x1, z1, u1, v2, light, overlay);
        addVertex(pose, normal, vertexConsumer, color, y2, x2, z2, u2, v2, light, overlay);
        addVertex(pose, normal, vertexConsumer, color, y1, x2, z2, u2, v1, light, overlay);
    }

    public static void addVertex(Matrix4f pose, Matrix3f normal, VertexConsumer vertexConsumer, int color, float y, float x, float z, float u, float v, int light, int overlay) {
        vertexConsumer.vertex(pose, x, y, z).color(color >>> 16 & 0xFF, (color >>> 8) & 0xFF, color & 0xFF, (color >>> 24) & 0xFF).uv(u, v).overlayCoords(overlay).uv2(light).normal(normal, 0.0f, 1.0f, 0.0f).endVertex();
    }

    public static int getLightEmission(int original, BlockState state, BlockGetter blockGetter) {
        if (blockGetter instanceof Level level && level.dimension() == OthersideDimension.OTHERSIDE_LEVEL && !state.is(DDTags.Blocks.SCULK_LIGHT_SOURCES)) {
            return Mth.ceil(original / 8.0f);
        }
        return original;
    }

    public static boolean hasHorns(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains(HAS_HORNS_TAG, CompoundTag.TAG_BYTE)) {
            return true;
        }
        return stack.getOrCreateTag().getBoolean(HAS_HORNS_TAG);
    }

    public static void setHasHorns(ItemStack stack, boolean value) {
        stack.getOrCreateTag().putBoolean(HAS_HORNS_TAG, value);
    }

    public static boolean isAcidResistant(ItemStack stack) {
        return stack.is(DDTags.Items.ACID_RESISTANT) || stack.getOrCreateTag().getBoolean(ACID_RESISTANT_TAG);
    }

    public static void setAcidResistant(ItemStack stack) {
        stack.getOrCreateTag().putBoolean(ACID_RESISTANT_TAG, true);
    }

    public static boolean isAugmented(ItemStack stack) {
        return stack.getOrCreateTag().getBoolean(AUGMENTED_TAG);
    }

    public static boolean isAugmentedShield(ItemStack stack) {
        return stack.is(ConventionalItemTags.SHIELDS) && isAugmented(stack);
    }

    public static void setAugmented(ItemStack stack) {
        stack.getOrCreateTag().putBoolean(AUGMENTED_TAG, true);
    }

    public static ItemStack getAugmentItem(ItemStack shield) {
        if (!isAugmented(shield)) {
            return ItemStack.EMPTY;
        }
        return ItemStack.of(shield.getOrCreateTag().getCompound(ITEM_TAG));
    }
}
