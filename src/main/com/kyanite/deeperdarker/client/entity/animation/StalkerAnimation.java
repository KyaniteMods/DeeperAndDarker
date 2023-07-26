package com.kyanite.deeperdarker.client.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class StalkerAnimation {
    public static final Animation IDLE = Animation.Builder.create(3f).looping()
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.49f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.375f, AnimationHelper.createRotationalVector(12.49f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625f, AnimationHelper.createRotationalVector(12.49f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(7.49f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.375f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-7.49f, 0.33f, -2.52f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(-12.49f, 0.33f, -2.52f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-7.49f, 0.33f, -2.52f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(40f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.375f, AnimationHelper.createRotationalVector(22.5f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625f, AnimationHelper.createRotationalVector(22.5f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(40f, 0f, -45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(30f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.375f, AnimationHelper.createRotationalVector(17.5f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625f, AnimationHelper.createRotationalVector(17.5f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(30f, 0f, 45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -37.5f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.375f, AnimationHelper.createRotationalVector(0f, -30f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625f, AnimationHelper.createRotationalVector(0f, -30f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, -37.5f, -45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-1080f, 40f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.375f, AnimationHelper.createRotationalVector(-1080f, 27.5f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625f, AnimationHelper.createRotationalVector(-1080f, 27.5f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-1080f, 40f, -1035f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-2.39f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-2.39f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("fake_vase", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation WALK = Animation.Builder.create(2f).looping()
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -2f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0.25f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0.51f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.7083f, AnimationHelper.createTranslationalVector(0f, 0.05f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, -3f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.25f, AnimationHelper.createTranslationalVector(0f, -0.25f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createTranslationalVector(0f, 0.51f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.75f, AnimationHelper.createTranslationalVector(0f, 0.26f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, -2f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(17.91f, -12.24f, -1.34f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-16.98f, 1.71f, 2.12f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(3.12f, 15.66f, 5.58f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(30.52f, 1.71f, 2.12f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(17.91f, -12.24f, -1.34f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 12.45f, -1.11f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, -12.55f, -1.11f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(0f, -17.55f, -1.11f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(-33.65f, 0.46f, 8.83f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 12.45f, -1.11f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(16.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(-31.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-17.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-17.49f, 0.33f, -2.52f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(16.25f, 0.16f, -3.76f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-2.5f, 0f, -5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(-28.75f, 0.16f, -3.76f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-17.49f, 0.33f, -2.52f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-1.36f, 31.39f, -59.63f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.125f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-1.36f, 31.39f, -59.63f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.5f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0417f, AnimationHelper.createRotationalVector(58.75f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(7.5f, 0f, 45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-39.35f, -15.4f, -3.82f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.875f, AnimationHelper.createRotationalVector(-53.61f, -35.43f, 17.24f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-39.35f, -15.4f, -3.82f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-1115.06f, 27.18f, -1030.15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.9583f, AnimationHelper.createRotationalVector(-1094.8f, 56.84f, -1046.03f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-1115.06f, 27.18f, -1030.15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(25.11f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-1.14f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-32.39f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(-1.14f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(25.11f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-24.78f, -5f, -2.51f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(0.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(40.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(0.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-24.78f, -5f, -2.51f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("fake_vase", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation ATTACK = Animation.Builder.create(0.5f)
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.49f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.0833f, AnimationHelper.createRotationalVector(-20.01f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(21.54f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(7.49f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(27.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.3333f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(-7.47f, 0.65f, 4.96f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-7.49f, 0.33f, -2.52f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(-7.44f, -0.98f, -12.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-7.49f, 0.33f, -2.52f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(40f, 0f, -45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(30f, 0f, 45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -37.5f, -45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-1080f, 40f, -1035f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-2.39f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-2.39f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(0.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("fake_vase", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation RING_ATTACK = Animation.Builder.create(3f).looping()
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.49f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(11.25f, -0.35f, 2.64f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(5.02f, -5.28f, 1.82f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4375f, AnimationHelper.createRotationalVector(5.63f, -4.22f, -0.56f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5625f, AnimationHelper.createRotationalVector(5.93f, 1.4f, 1.81f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(6.25f, -2.94f, 3.14f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.875f, AnimationHelper.createRotationalVector(6.75f, -9.51f, 2.04f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(11.25f, -0.35f, 2.64f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.125f, AnimationHelper.createRotationalVector(5.02f, -5.28f, 1.82f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.3125f, AnimationHelper.createRotationalVector(5.63f, -4.22f, -0.56f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4375f, AnimationHelper.createRotationalVector(5.93f, 1.4f, 1.81f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625f, AnimationHelper.createRotationalVector(6.25f, -2.94f, 3.14f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.75f, AnimationHelper.createRotationalVector(6.75f, -9.51f, 2.04f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.875f, AnimationHelper.createRotationalVector(11.25f, -0.35f, 2.64f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(5.02f, -5.28f, 1.82f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.1875f, AnimationHelper.createRotationalVector(5.63f, -4.22f, -0.56f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.3125f, AnimationHelper.createRotationalVector(5.93f, 1.4f, 1.81f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.5f, AnimationHelper.createRotationalVector(6.25f, -2.94f, 3.14f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.625f, AnimationHelper.createRotationalVector(6.75f, -9.51f, 2.04f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.875f, AnimationHelper.createRotationalVector(5.93f, 1.4f, 1.81f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(7.49f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.0625f, AnimationHelper.createRotationalVector(-5.02f, 4.98f, -0.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(-3.88f, 14.62f, 3.87f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.1875f, AnimationHelper.createRotationalVector(-5.25f, 16.84f, -1.53f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(-5.42f, 20.94f, -1.95f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.3125f, AnimationHelper.createRotationalVector(-4.35f, -9.61f, -4.24f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(-5.24f, -13.6f, 1.23f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4375f, AnimationHelper.createRotationalVector(-5.09f, -1.82f, 0.17f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-5.02f, 4.98f, -0.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5625f, AnimationHelper.createRotationalVector(-3.88f, 14.62f, 3.87f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.625f, AnimationHelper.createRotationalVector(-5.25f, 16.84f, -1.53f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6875f, AnimationHelper.createRotationalVector(-5.42f, 20.94f, -1.95f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(-4.35f, -9.61f, -4.24f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.8125f, AnimationHelper.createRotationalVector(-5.02f, 4.98f, -0.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.875f, AnimationHelper.createRotationalVector(-3.88f, 14.62f, 3.87f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.9375f, AnimationHelper.createRotationalVector(-5.25f, 16.84f, -1.53f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-5.42f, 20.94f, -1.95f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0625f, AnimationHelper.createRotationalVector(-4.35f, -9.61f, -4.24f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.125f, AnimationHelper.createRotationalVector(-5.24f, -13.6f, 1.23f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1875f, AnimationHelper.createRotationalVector(-5.09f, -1.82f, 0.17f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.25f, AnimationHelper.createRotationalVector(-5.02f, 4.98f, -0.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.3125f, AnimationHelper.createRotationalVector(-3.88f, 14.62f, 3.87f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.375f, AnimationHelper.createRotationalVector(-5.25f, 16.84f, -1.53f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4375f, AnimationHelper.createRotationalVector(-5.42f, 20.94f, -1.95f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(-4.35f, -9.61f, -4.24f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5625f, AnimationHelper.createRotationalVector(-5.02f, 4.98f, -0.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625f, AnimationHelper.createRotationalVector(-3.88f, 14.62f, 3.87f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.6875f, AnimationHelper.createRotationalVector(-5.25f, 16.84f, -1.53f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.75f, AnimationHelper.createRotationalVector(-5.42f, 20.94f, -1.95f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.8125f, AnimationHelper.createRotationalVector(-4.35f, -9.61f, -4.24f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.875f, AnimationHelper.createRotationalVector(-5.24f, -13.6f, 1.23f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.9375f, AnimationHelper.createRotationalVector(-5.09f, -1.82f, 0.17f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-5.02f, 4.98f, -0.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.0625f, AnimationHelper.createRotationalVector(-3.88f, 14.62f, 3.87f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.125f, AnimationHelper.createRotationalVector(-5.25f, 16.84f, -1.53f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.1875f, AnimationHelper.createRotationalVector(-5.42f, 20.94f, -1.95f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.25f, AnimationHelper.createRotationalVector(-4.35f, -9.61f, -4.24f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.3125f, AnimationHelper.createRotationalVector(-5.02f, 4.98f, -0.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.375f, AnimationHelper.createRotationalVector(-3.88f, 14.62f, 3.87f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4375f, AnimationHelper.createRotationalVector(-5.25f, 16.84f, -1.53f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.5f, AnimationHelper.createRotationalVector(-5.42f, 20.94f, -1.95f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.5625f, AnimationHelper.createRotationalVector(-4.35f, -9.61f, -4.24f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.625f, AnimationHelper.createRotationalVector(-5.24f, -13.6f, 1.23f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.6875f, AnimationHelper.createRotationalVector(-5.09f, -1.82f, 0.17f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.75f, AnimationHelper.createRotationalVector(-5.02f, 4.98f, -0.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.8125f, AnimationHelper.createRotationalVector(-3.88f, 14.62f, 3.87f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.875f, AnimationHelper.createRotationalVector(-5.25f, 16.84f, -1.53f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.9375f, AnimationHelper.createRotationalVector(-5.42f, 20.94f, -1.95f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_ear", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(-35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.625f, AnimationHelper.createRotationalVector(-35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.875f, AnimationHelper.createRotationalVector(-35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.125f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.25f, AnimationHelper.createRotationalVector(-35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.375f, AnimationHelper.createRotationalVector(35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625f, AnimationHelper.createRotationalVector(-35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.75f, AnimationHelper.createRotationalVector(35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.875f, AnimationHelper.createRotationalVector(-35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.0625f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.1875f, AnimationHelper.createRotationalVector(-35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.3125f, AnimationHelper.createRotationalVector(35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.5625f, AnimationHelper.createRotationalVector(-35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.6875f, AnimationHelper.createRotationalVector(35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.8125f, AnimationHelper.createRotationalVector(-35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_ear", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(-20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.625f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(-20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.875f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.125f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.25f, AnimationHelper.createRotationalVector(-20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.375f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625f, AnimationHelper.createRotationalVector(-20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.75f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.875f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.125f, AnimationHelper.createRotationalVector(-20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.25f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.375f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.5f, AnimationHelper.createRotationalVector(-20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.625f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.75f, AnimationHelper.createRotationalVector(-20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.875f, AnimationHelper.createRotationalVector(-45f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-7.49f, 0.33f, -2.52f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-7.49f, 0.33f, -2.52f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(40f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(40f, 0f, -45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(30f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(30f, 0f, 45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -37.5f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, -37.5f, -45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-1080f, 40f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-1080f, 40f, -1035f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-2.39f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-2.39f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("fake_vase", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation EMERGE = Animation.Builder.create(3.5f)
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -41f, -10f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -33f, -10f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createTranslationalVector(0f, -33f, -10f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createTranslationalVector(0f, -14f, -10f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4583f, AnimationHelper.createTranslationalVector(0f, -15.98f, -10f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.625f, AnimationHelper.createTranslationalVector(0f, -4.15f, -2f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2083f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-90f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createRotationalVector(-90f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.625f, AnimationHelper.createRotationalVector(-62.7f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2083f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("waist", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(3.2083f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(1.125f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.2083f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5417f, AnimationHelper.createRotationalVector(40.43f, -7.64f, -6.47f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.875f, AnimationHelper.createRotationalVector(41.34f, -13.32f, -11.46f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.5f, AnimationHelper.createRotationalVector(6.97f, -19.74f, -1.93f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(7.49f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(7.49f, -0.33f, 2.48f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.7083f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.1667f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2083f, AnimationHelper.createRotationalVector(32.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(4.2f, -4.42f, 69.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(6.38f, -2.64f, 69.19f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(6.38f, -2.64f, 69.19f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.625f, AnimationHelper.createRotationalVector(-0.92f, 1.16f, 71.68f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createRotationalVector(26.65f, 2.43f, 72.51f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.375f, AnimationHelper.createRotationalVector(36.85f, 5.76f, 57.34f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.6667f, AnimationHelper.createRotationalVector(37.43f, 23.36f, 15.21f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.875f, AnimationHelper.createRotationalVector(36.99f, 24.64f, 18.41f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.125f, AnimationHelper.createRotationalVector(51.24f, 14.42f, 16.68f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.625f, AnimationHelper.createRotationalVector(52.3f, 7.84f, 47.83f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(4.59f, 9.31f, -64.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(4.59f, 9.31f, -64.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(-0.41f, 9.31f, -64.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createRotationalVector(44.59f, 9.31f, -64.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.125f, AnimationHelper.createRotationalVector(51.65f, 10.3f, -3.14f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.625f, AnimationHelper.createRotationalVector(61.41f, 33.18f, -18.82f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(-7.49f, 0.33f, -2.52f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(-1f, 1f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0417f, AnimationHelper.createTranslationalVector(-1f, 1f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-22.5f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(5f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5417f, AnimationHelper.createRotationalVector(86.46f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(86.46f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0417f, AnimationHelper.createRotationalVector(-22.5f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4167f, AnimationHelper.createRotationalVector(7.27f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4167f, AnimationHelper.createRotationalVector(22.5f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.875f, AnimationHelper.createRotationalVector(22.5f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(40f, 0f, -45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_right_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0417f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(1f, 1f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0833f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-17.5f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(-17.5f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(0f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5417f, AnimationHelper.createRotationalVector(87.29f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(87.29f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0833f, AnimationHelper.createRotationalVector(30f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4167f, AnimationHelper.createRotationalVector(1.25f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4167f, AnimationHelper.createRotationalVector(17.5f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.875f, AnimationHelper.createRotationalVector(17.5f, 0f, 45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(30f, 0f, 45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_left_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0833f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(-1f, -1f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0417f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 17.5f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(0f, -7.5f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5417f, AnimationHelper.createRotationalVector(0f, -85.42f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, -85.42f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0417f, AnimationHelper.createRotationalVector(40f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createRotationalVector(0f, -37.5f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4167f, AnimationHelper.createRotationalVector(0f, -9.5f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4167f, AnimationHelper.createRotationalVector(0f, -30f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.875f, AnimationHelper.createRotationalVector(0f, -30f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(0f, -37.5f, -45f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_right_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0417f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(1f, -1f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-1080f, -22.5f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(-1080f, 2.5f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5417f, AnimationHelper.createRotationalVector(-1080f, 85.42f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(-1080f, 85.42f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-1080f, 40f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4167f, AnimationHelper.createRotationalVector(-1080f, 27.5f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.875f, AnimationHelper.createRotationalVector(-1080f, 27.5f, -1035f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(-1080f, 40f, -1035f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_left_tooth", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.7083f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("upper_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(1.1667f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(-1.5f, 1.75f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.7083f, AnimationHelper.createRotationalVector(-9.67f, 2.2f, 87.56f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(7.75f, -7.66f, 89.25f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("lower_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.7083f, AnimationHelper.createRotationalVector(0f, 10f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("middle_back", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(3f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("vase", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.7083f, AnimationHelper.createScalingVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body_top", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 1f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.7083f, AnimationHelper.createTranslationalVector(0f, 1.15f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body_right", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(-2f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.7083f, AnimationHelper.createTranslationalVector(-2f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body_left", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(2f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.7083f, AnimationHelper.createTranslationalVector(2f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body_bottom", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -1f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.7083f, AnimationHelper.createTranslationalVector(0f, -1.15f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(1.1667f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.7917f, AnimationHelper.createTranslationalVector(0f, 0.82f, -8.88f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.2917f, AnimationHelper.createTranslationalVector(0f, 2.11f, -6.71f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.625f, AnimationHelper.createTranslationalVector(0f, 0.6f, -2.91f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2083f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(2.88f, 4.98f, 13.68f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(1.91f, 3.77f, 14.03f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.7083f, AnimationHelper.createRotationalVector(2.88f, 4.98f, 13.68f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createRotationalVector(50.28f, -1.65f, 10.18f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4583f, AnimationHelper.createRotationalVector(18.87f, -0.76f, 10.29f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5833f, AnimationHelper.createRotationalVector(14.61f, -1.65f, 10.18f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.7917f, AnimationHelper.createRotationalVector(50.25f, -1.65f, 10.18f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.2917f, AnimationHelper.createRotationalVector(67.78f, -1.65f, 10.18f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.625f, AnimationHelper.createRotationalVector(67.78f, -1.65f, 10.18f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2083f, AnimationHelper.createRotationalVector(-2.39f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(-2.39f, 2.61f, 2.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(3.2083f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(1.7917f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.2917f, AnimationHelper.createTranslationalVector(0f, 2f, -5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2083f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(10.22f, -4.02f, -16.34f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.375f, AnimationHelper.createRotationalVector(3.35f, -1.78f, -16.44f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.7083f, AnimationHelper.createRotationalVector(2.72f, -1.52f, -16.22f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1667f, AnimationHelper.createRotationalVector(47.72f, -1.52f, -16.22f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4583f, AnimationHelper.createRotationalVector(19.3f, -2.91f, -16.03f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.2917f, AnimationHelper.createRotationalVector(68.85f, -1.52f, -16.22f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2083f, AnimationHelper.createRotationalVector(0.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(0.22f, -5f, -2.51f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(3.2083f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("fake_vase", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.3333f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5417f, AnimationHelper.createTranslationalVector(0f, -16.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("fake_vase", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("fake_vase", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.5417f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5833f, AnimationHelper.createScalingVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createScalingVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createScalingVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();
}
