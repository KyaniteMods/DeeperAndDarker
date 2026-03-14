package com.kyanite.deeperdarker.util;

public class DDUtil {
    public static float lerpLog(float t, float a, float b) {
        // https://www.cmu.edu/biolphys/deserno/pdf/log_interpol.pdf
        return (int) (Math.pow(a, t) * Math.pow(b, 1.0f - t));
    }
}
