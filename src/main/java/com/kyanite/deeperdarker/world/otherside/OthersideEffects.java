package com.kyanite.deeperdarker.world.otherside;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;

public class OthersideEffects extends DimensionSpecialEffects {
    public OthersideEffects() {
        super(624.0f, true, SkyType.NONE, false, false);
    }

    private static final Vec3 WHITE_FOG = new Vec3(1.0, 1.0, 1.0);

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 vec3, float f) {
        return DeeperDarker.CONFIG.client.whiteFog() ? WHITE_FOG : Vec3.ZERO;
    }

    @Override
    public boolean isFoggyAt(int i, int j) {
        return true;
    }

    @Override
    public float[] getSunriseColor(float f, float g) {
        return null;
    }
}
