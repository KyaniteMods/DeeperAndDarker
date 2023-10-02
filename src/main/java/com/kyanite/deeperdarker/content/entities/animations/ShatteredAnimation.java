package com.kyanite.deeperdarker.content.entities.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ShatteredAnimation {
    public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(1.5f).looping()
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(1.19f, -1.3f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-2.5f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.125f, KeyframeAnimations.degreeVec(1.3f, -1.19f, -2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.125f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.4375f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(3f).looping()
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0.22f, 2.49f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4167f, KeyframeAnimations.degreeVec(2.5f, 0.22f, 2.49f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833f, KeyframeAnimations.degreeVec(2.5f, 0.22f, 2.49f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-5f, 0.22f, 2.49f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(9.96f, -0.87f, 4.92f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(11.75f, -0.59f, 3.33f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4167f, KeyframeAnimations.degreeVec(14.91f, -1.51f, 7.34f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833f, KeyframeAnimations.degreeVec(14.91f, -1.51f, 7.34f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.25f, KeyframeAnimations.degreeVec(12.64f, -0.12f, 1.32f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(9.96f, -0.87f, 4.92f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.6667f, KeyframeAnimations.degreeVec(2.64f, -0.12f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4167f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4167f, KeyframeAnimations.degreeVec(2.94f, -0.13f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0.22f, -2.49f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.6667f, KeyframeAnimations.degreeVec(2.65f, -0.01f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4167f, KeyframeAnimations.degreeVec(0f, 0.22f, -2.49f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833f, KeyframeAnimations.degreeVec(0f, 0.22f, -2.49f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4167f, KeyframeAnimations.degreeVec(2.88f, 0.6f, -9.98f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(5f, 0.22f, -2.49f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(2.5f, 0f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(2.5f, 0f, 2.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, 0f, -2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(-2.5f, 0f, -2.5f), AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(0.5f)
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0.22f, 2.49f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.0833f, KeyframeAnimations.degreeVec(-15f, 0.22f, 2.49f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2083f, KeyframeAnimations.degreeVec(12.5f, 0.22f, 2.49f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-5f, 0.22f, 2.49f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(9.96f, -0.87f, 4.92f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.0833f, KeyframeAnimations.degreeVec(-7.54f, -0.87f, 4.92f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2083f, KeyframeAnimations.degreeVec(-2.54f, -0.87f, 4.92f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.3333f, KeyframeAnimations.degreeVec(19.43f, -0.87f, 4.92f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(9.96f, -0.87f, 4.92f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.0833f, KeyframeAnimations.degreeVec(24.67f, -4.21f, 9.08f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(13.47f, -6.96f, 27.22f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2083f, KeyframeAnimations.degreeVec(-55.91f, -5.1f, 31.44f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917f, KeyframeAnimations.degreeVec(-77.95f, -44.75f, 4.32f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0.22f, -2.49f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.0833f, KeyframeAnimations.degreeVec(19.68f, 3.62f, -11.9f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(16.55f, 3.62f, -11.9f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2083f, KeyframeAnimations.degreeVec(-35.32f, 3.62f, -11.9f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917f, KeyframeAnimations.degreeVec(-12.82f, 3.62f, -11.9f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(5f, 0.22f, -2.49f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(2.5f, 0f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(2.5f, 0f, 2.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, 0f, -2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-2.5f, 0f, -2.5f), AnimationChannel.Interpolations.LINEAR))).build();
}
