package com.kyanite.deeperdarker.util;

import net.minecraft.core.SectionPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.phys.Vec2;

public class SimpleWorleyNoise {
    private final PositionalRandomFactory random;

    protected SimpleWorleyNoise(RandomSource random) {
        this.random = random.forkPositional();
    }

    public static SimpleWorleyNoise create(RandomSource random) {
        return new SimpleWorleyNoise(random);
    }

    public float get(int x, int z, ReturnValue returnValue) {
        float lowestDistance = 21.213203f; // sqrt(15² + 15²), max distance from a point
        float secondLowestDistance = 21.213203f;
        for (int dz = -1; dz <= 1; dz++) {
            for (int dx = -1; dx <= 1; dx++) {
                Vec2 pointPos = getPointPosition(SectionPos.blockToSectionCoord(x) + dx, SectionPos.blockToSectionCoord(z) + dz);
                float distanceX = x - pointPos.x;
                float distanceZ = z - pointPos.y;
                float distance = Mth.sqrt(distanceX * distanceX + distanceZ * distanceZ);
                if (lowestDistance > distance) {
                    secondLowestDistance = lowestDistance;
                    lowestDistance = distance;
                }
            }
        }
        return returnValue == ReturnValue.VALUE ? lowestDistance / 21.213203f : Mth.abs(secondLowestDistance - lowestDistance) / 21.213203f;
    }

    public Vec2 getPointPosition(int chunkX, int chunkZ) {
        RandomSource random = this.random.at(chunkX, 0, chunkZ);
        return new Vec2(chunkX * 16 + random.nextInt(0, 16), chunkZ * 16 + random.nextInt(0, 16));
    }

    public enum ReturnValue {
        VALUE,
        DISTANCE_TO_EDGE
    }
}
