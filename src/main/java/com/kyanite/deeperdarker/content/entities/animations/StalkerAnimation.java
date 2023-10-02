package com.kyanite.deeperdarker.content.entities.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class StalkerAnimation {
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(3f).looping()
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.49f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375f, KeyframeAnimations.degreeVec(12.49f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(12.49f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(7.49f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-7.49f, 0.33f, -2.52f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(-12.49f, 0.33f, -2.52f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-7.49f, 0.33f, -2.52f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(40f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375f, KeyframeAnimations.degreeVec(22.5f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(22.5f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(40f, 0f, -45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(30f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375f, KeyframeAnimations.degreeVec(17.5f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(17.5f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(30f, 0f, 45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -37.5f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375f, KeyframeAnimations.degreeVec(0f, -30f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(0f, -30f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, -37.5f, -45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-1080f, 40f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375f, KeyframeAnimations.degreeVec(-1080f, 27.5f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(-1080f, 27.5f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-1080f, 40f, -1035f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-2.39f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-2.39f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR))).build();
    
    public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, -2f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0.25f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0.51f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083f, KeyframeAnimations.posVec(0f, 0.05f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, -3f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25f, KeyframeAnimations.posVec(0f, -0.25f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0.51f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0.26f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, -2f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(17.91f, -12.24f, -1.34f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-16.98f, 1.71f, 2.12f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(3.12f, 15.66f, 5.58f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(30.52f, 1.71f, 2.12f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(17.91f, -12.24f, -1.34f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 12.45f, -1.11f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -12.55f, -1.11f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -17.55f, -1.11f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(-33.65f, 0.46f, 8.83f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 12.45f, -1.11f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(16.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(-31.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-17.49f, 0.33f, -2.52f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(16.25f, 0.16f, -3.76f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-2.5f, 0f, -5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(-28.75f, 0.16f, -3.76f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-17.49f, 0.33f, -2.52f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-1.36f, 31.39f, -59.63f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-1.36f, 31.39f, -59.63f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.5f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417f, KeyframeAnimations.degreeVec(58.75f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(7.5f, 0f, 45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-39.35f, -15.4f, -3.82f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.875f, KeyframeAnimations.degreeVec(-53.61f, -35.43f, 17.24f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-39.35f, -15.4f, -3.82f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-1115.06f, 27.18f, -1030.15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.9583f, KeyframeAnimations.degreeVec(-1094.8f, 56.84f, -1046.03f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-1115.06f, 27.18f, -1030.15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(25.11f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-1.14f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-32.39f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(-1.14f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(25.11f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-24.78f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(40.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(0.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-24.78f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR))).build();
    
    public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(0.5f)
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.49f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.0833f, KeyframeAnimations.degreeVec(-20.01f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(21.54f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(7.49f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.3333f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(-7.47f, 0.65f, 4.96f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-7.49f, 0.33f, -2.52f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(-7.44f, -0.98f, -12.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-7.49f, 0.33f, -2.52f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(40f, 0f, -45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(30f, 0f, 45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -37.5f, -45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-1080f, 40f, -1035f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-2.39f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-2.39f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR))).build();
    
    public static final AnimationDefinition RING_ATTACK = AnimationDefinition.Builder.withLength(3f).looping()
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.49f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(11.25f, -0.35f, 2.64f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(5.02f, -5.28f, 1.82f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4375f, KeyframeAnimations.degreeVec(5.63f, -4.22f, -0.56f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5625f, KeyframeAnimations.degreeVec(5.93f, 1.4f, 1.81f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(6.25f, -2.94f, 3.14f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.875f, KeyframeAnimations.degreeVec(6.75f, -9.51f, 2.04f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(11.25f, -0.35f, 2.64f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.125f, KeyframeAnimations.degreeVec(5.02f, -5.28f, 1.82f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.3125f, KeyframeAnimations.degreeVec(5.63f, -4.22f, -0.56f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4375f, KeyframeAnimations.degreeVec(5.93f, 1.4f, 1.81f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(6.25f, -2.94f, 3.14f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.75f, KeyframeAnimations.degreeVec(6.75f, -9.51f, 2.04f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875f, KeyframeAnimations.degreeVec(11.25f, -0.35f, 2.64f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(5.02f, -5.28f, 1.82f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.1875f, KeyframeAnimations.degreeVec(5.63f, -4.22f, -0.56f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3125f, KeyframeAnimations.degreeVec(5.93f, 1.4f, 1.81f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5f, KeyframeAnimations.degreeVec(6.25f, -2.94f, 3.14f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.625f, KeyframeAnimations.degreeVec(6.75f, -9.51f, 2.04f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.875f, KeyframeAnimations.degreeVec(5.93f, 1.4f, 1.81f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(7.49f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.0625f, KeyframeAnimations.degreeVec(-5.02f, 4.98f, -0.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(-3.88f, 14.62f, 3.87f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1875f, KeyframeAnimations.degreeVec(-5.25f, 16.84f, -1.53f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(-5.42f, 20.94f, -1.95f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.3125f, KeyframeAnimations.degreeVec(-4.35f, -9.61f, -4.24f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(-5.24f, -13.6f, 1.23f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4375f, KeyframeAnimations.degreeVec(-5.09f, -1.82f, 0.17f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-5.02f, 4.98f, -0.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5625f, KeyframeAnimations.degreeVec(-3.88f, 14.62f, 3.87f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.625f, KeyframeAnimations.degreeVec(-5.25f, 16.84f, -1.53f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.6875f, KeyframeAnimations.degreeVec(-5.42f, 20.94f, -1.95f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-4.35f, -9.61f, -4.24f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.8125f, KeyframeAnimations.degreeVec(-5.02f, 4.98f, -0.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.875f, KeyframeAnimations.degreeVec(-3.88f, 14.62f, 3.87f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.9375f, KeyframeAnimations.degreeVec(-5.25f, 16.84f, -1.53f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-5.42f, 20.94f, -1.95f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0625f, KeyframeAnimations.degreeVec(-4.35f, -9.61f, -4.24f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.125f, KeyframeAnimations.degreeVec(-5.24f, -13.6f, 1.23f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1875f, KeyframeAnimations.degreeVec(-5.09f, -1.82f, 0.17f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25f, KeyframeAnimations.degreeVec(-5.02f, 4.98f, -0.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.3125f, KeyframeAnimations.degreeVec(-3.88f, 14.62f, 3.87f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375f, KeyframeAnimations.degreeVec(-5.25f, 16.84f, -1.53f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4375f, KeyframeAnimations.degreeVec(-5.42f, 20.94f, -1.95f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(-4.35f, -9.61f, -4.24f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5625f, KeyframeAnimations.degreeVec(-5.02f, 4.98f, -0.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(-3.88f, 14.62f, 3.87f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6875f, KeyframeAnimations.degreeVec(-5.25f, 16.84f, -1.53f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.75f, KeyframeAnimations.degreeVec(-5.42f, 20.94f, -1.95f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8125f, KeyframeAnimations.degreeVec(-4.35f, -9.61f, -4.24f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875f, KeyframeAnimations.degreeVec(-5.24f, -13.6f, 1.23f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9375f, KeyframeAnimations.degreeVec(-5.09f, -1.82f, 0.17f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-5.02f, 4.98f, -0.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0625f, KeyframeAnimations.degreeVec(-3.88f, 14.62f, 3.87f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.125f, KeyframeAnimations.degreeVec(-5.25f, 16.84f, -1.53f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.1875f, KeyframeAnimations.degreeVec(-5.42f, 20.94f, -1.95f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.25f, KeyframeAnimations.degreeVec(-4.35f, -9.61f, -4.24f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3125f, KeyframeAnimations.degreeVec(-5.02f, 4.98f, -0.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.375f, KeyframeAnimations.degreeVec(-3.88f, 14.62f, 3.87f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4375f, KeyframeAnimations.degreeVec(-5.25f, 16.84f, -1.53f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5f, KeyframeAnimations.degreeVec(-5.42f, 20.94f, -1.95f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5625f, KeyframeAnimations.degreeVec(-4.35f, -9.61f, -4.24f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.625f, KeyframeAnimations.degreeVec(-5.24f, -13.6f, 1.23f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.6875f, KeyframeAnimations.degreeVec(-5.09f, -1.82f, 0.17f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.75f, KeyframeAnimations.degreeVec(-5.02f, 4.98f, -0.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.8125f, KeyframeAnimations.degreeVec(-3.88f, 14.62f, 3.87f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.875f, KeyframeAnimations.degreeVec(-5.25f, 16.84f, -1.53f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.9375f, KeyframeAnimations.degreeVec(-5.42f, 20.94f, -1.95f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_ear", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.625f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.875f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.125f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.75f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0625f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.1875f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3125f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5625f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.6875f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.8125f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_ear", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.625f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.875f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.125f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.75f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.125f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.25f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.375f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.625f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.75f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.875f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-7.49f, 0.33f, -2.52f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-7.49f, 0.33f, -2.52f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(40f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(40f, 0f, -45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(30f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(30f, 0f, 45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -37.5f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, -37.5f, -45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-1080f, 40f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-1080f, 40f, -1035f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-2.39f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-2.39f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR))).build();
    
    public static final AnimationDefinition EMERGE = AnimationDefinition.Builder.withLength(3.5f)
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, -41f, -10f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.posVec(0f, -33f, -10f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.6667f, KeyframeAnimations.posVec(0f, -33f, -10f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.posVec(0f, -14f, -10f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4583f, KeyframeAnimations.posVec(0f, -15.98f, -10f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.625f, KeyframeAnimations.posVec(0f, -4.15f, -2f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2083f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(-90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.625f, KeyframeAnimations.degreeVec(-62.7f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2083f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("waist", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(3.2083f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.2083f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5417f, KeyframeAnimations.degreeVec(40.43f, -7.64f, -6.47f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875f, KeyframeAnimations.degreeVec(41.34f, -13.32f, -11.46f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5f, KeyframeAnimations.degreeVec(6.97f, -19.74f, -1.93f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(7.49f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(7.49f, -0.33f, 2.48f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.1667f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2083f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(4.2f, -4.42f, 69.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(6.38f, -2.64f, 69.19f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(6.38f, -2.64f, 69.19f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.625f, KeyframeAnimations.degreeVec(-0.92f, 1.16f, 71.68f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(26.65f, 2.43f, 72.51f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375f, KeyframeAnimations.degreeVec(36.85f, 5.76f, 57.34f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6667f, KeyframeAnimations.degreeVec(37.43f, 23.36f, 15.21f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875f, KeyframeAnimations.degreeVec(36.99f, 24.64f, 18.41f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.125f, KeyframeAnimations.degreeVec(51.24f, 14.42f, 16.68f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.625f, KeyframeAnimations.degreeVec(52.3f, 7.84f, 47.83f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(4.59f, 9.31f, -64.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(4.59f, 9.31f, -64.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-0.41f, 9.31f, -64.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(44.59f, 9.31f, -64.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.125f, KeyframeAnimations.degreeVec(51.65f, 10.3f, -3.14f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.625f, KeyframeAnimations.degreeVec(61.41f, 33.18f, -18.82f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(-7.49f, 0.33f, -2.52f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(-1f, 1f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417f, KeyframeAnimations.posVec(-1f, 1f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-22.5f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(5f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417f, KeyframeAnimations.degreeVec(86.46f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(86.46f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417f, KeyframeAnimations.degreeVec(-22.5f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4167f, KeyframeAnimations.degreeVec(7.27f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4167f, KeyframeAnimations.degreeVec(22.5f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.875f, KeyframeAnimations.degreeVec(22.5f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(40f, 0f, -45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_right_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(1f, 1f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-17.5f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(-17.5f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417f, KeyframeAnimations.degreeVec(87.29f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(87.29f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0833f, KeyframeAnimations.degreeVec(30f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4167f, KeyframeAnimations.degreeVec(1.25f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4167f, KeyframeAnimations.degreeVec(17.5f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.875f, KeyframeAnimations.degreeVec(17.5f, 0f, 45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(30f, 0f, 45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_left_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0833f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(-1f, -1f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 17.5f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, -7.5f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417f, KeyframeAnimations.degreeVec(0f, -85.42f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -85.42f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417f, KeyframeAnimations.degreeVec(40f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(0f, -37.5f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4167f, KeyframeAnimations.degreeVec(0f, -9.5f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4167f, KeyframeAnimations.degreeVec(0f, -30f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.875f, KeyframeAnimations.degreeVec(0f, -30f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, -37.5f, -45f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_right_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(1f, -1f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-1080f, -22.5f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(-1080f, 2.5f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417f, KeyframeAnimations.degreeVec(-1080f, 85.42f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-1080f, 85.42f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-1080f, 40f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4167f, KeyframeAnimations.degreeVec(-1080f, 27.5f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.875f, KeyframeAnimations.degreeVec(-1080f, 27.5f, -1035f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(-1080f, 40f, -1035f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_left_tooth", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.7083f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upper_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.1667f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(-1.5f, 1.75f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.7083f, KeyframeAnimations.degreeVec(-9.67f, 2.2f, 87.56f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(7.75f, -7.66f, 89.25f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lower_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.7083f, KeyframeAnimations.degreeVec(0f, 10f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("middle_back", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(3f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("vase", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0.7083f, KeyframeAnimations.scaleVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body_top", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083f, KeyframeAnimations.posVec(0f, 1.15f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(-2f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083f, KeyframeAnimations.posVec(-2f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(2f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083f, KeyframeAnimations.posVec(2f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body_bottom", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083f, KeyframeAnimations.posVec(0f, -1.15f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.1667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.7917f, KeyframeAnimations.posVec(0f, 0.82f, -8.88f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.2917f, KeyframeAnimations.posVec(0f, 2.11f, -6.71f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.625f, KeyframeAnimations.posVec(0f, 0.6f, -2.91f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2083f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(2.88f, 4.98f, 13.68f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(1.91f, 3.77f, 14.03f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083f, KeyframeAnimations.degreeVec(2.88f, 4.98f, 13.68f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(50.28f, -1.65f, 10.18f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4583f, KeyframeAnimations.degreeVec(18.87f, -0.76f, 10.29f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833f, KeyframeAnimations.degreeVec(14.61f, -1.65f, 10.18f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.7917f, KeyframeAnimations.degreeVec(50.25f, -1.65f, 10.18f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.2917f, KeyframeAnimations.degreeVec(67.78f, -1.65f, 10.18f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.625f, KeyframeAnimations.degreeVec(67.78f, -1.65f, 10.18f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2083f, KeyframeAnimations.degreeVec(-2.39f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(-2.39f, 2.61f, 2.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(3.2083f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.7917f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.2917f, KeyframeAnimations.posVec(0f, 2f, -5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2083f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(10.22f, -4.02f, -16.34f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(3.35f, -1.78f, -16.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083f, KeyframeAnimations.degreeVec(2.72f, -1.52f, -16.22f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(47.72f, -1.52f, -16.22f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4583f, KeyframeAnimations.degreeVec(19.3f, -2.91f, -16.03f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.2917f, KeyframeAnimations.degreeVec(68.85f, -1.52f, -16.22f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2083f, KeyframeAnimations.degreeVec(0.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(0.22f, -5f, -2.51f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(3.2083f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR))).build();
}
