package com.kyanite.deeperdarker.client.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ShatteredAnimation {
    public static final Animation WALK = Animation.Builder.create(1.5f).looping()
            .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(1.19f, -1.3f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(-2.5f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.125f, AnimationHelper.createRotationalVector(1.3f, -1.19f, -2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.125f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("root", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createTranslationalVector(0f, -1f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(2.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 1f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createTranslationalVector(0f, 1f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(-20f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.4375f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createTranslationalVector(0f, 1f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(-35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(20f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation IDLE = Animation.Builder.create(3f).looping()
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0.22f, 2.49f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4167f, AnimationHelper.createRotationalVector(2.5f, 0.22f, 2.49f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5833f, AnimationHelper.createRotationalVector(2.5f, 0.22f, 2.49f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-5f, 0.22f, 2.49f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(9.96f, -0.87f, 4.92f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(11.75f, -0.59f, 3.33f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4167f, AnimationHelper.createRotationalVector(14.91f, -1.51f, 7.34f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5833f, AnimationHelper.createRotationalVector(14.91f, -1.51f, 7.34f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.25f, AnimationHelper.createRotationalVector(12.64f, -0.12f, 1.32f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(9.96f, -0.87f, 4.92f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createRotationalVector(2.64f, -0.12f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4167f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5833f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4167f, AnimationHelper.createRotationalVector(2.94f, -0.13f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(5f, 0.22f, -2.49f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createRotationalVector(2.65f, -0.01f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4167f, AnimationHelper.createRotationalVector(0f, 0.22f, -2.49f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5833f, AnimationHelper.createRotationalVector(0f, 0.22f, -2.49f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4167f, AnimationHelper.createRotationalVector(2.88f, 0.6f, -9.98f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(5f, 0.22f, -2.49f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(2.5f, 0f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(2.5f, 0f, 2.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-2.5f, 0f, -2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-2.5f, 0f, -2.5f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation ATTACK = Animation.Builder.create(0.5f)
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0.22f, 2.49f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.0833f, AnimationHelper.createRotationalVector(-15f, 0.22f, 2.49f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2083f, AnimationHelper.createRotationalVector(12.5f, 0.22f, 2.49f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-5f, 0.22f, 2.49f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(9.96f, -0.87f, 4.92f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.0833f, AnimationHelper.createRotationalVector(-7.54f, -0.87f, 4.92f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2083f, AnimationHelper.createRotationalVector(-2.54f, -0.87f, 4.92f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.3333f, AnimationHelper.createRotationalVector(19.43f, -0.87f, 4.92f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(9.96f, -0.87f, 4.92f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.0833f, AnimationHelper.createRotationalVector(24.67f, -4.21f, 9.08f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(13.47f, -6.96f, 27.22f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2083f, AnimationHelper.createRotationalVector(-55.91f, -5.1f, 31.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2917f, AnimationHelper.createRotationalVector(-77.95f, -44.75f, 4.32f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(5f, 0.22f, -2.49f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.0833f, AnimationHelper.createRotationalVector(19.68f, 3.62f, -11.9f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(16.55f, 3.62f, -11.9f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2083f, AnimationHelper.createRotationalVector(-35.32f, 3.62f, -11.9f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2917f, AnimationHelper.createRotationalVector(-12.82f, 3.62f, -11.9f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(5f, 0.22f, -2.49f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(2.5f, 0f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(2.5f, 0f, 2.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-2.5f, 0f, -2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-2.5f, 0f, -2.5f), Transformation.Interpolations.LINEAR))).build();
}
