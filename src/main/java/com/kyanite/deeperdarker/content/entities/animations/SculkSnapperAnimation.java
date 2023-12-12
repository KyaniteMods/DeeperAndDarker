package com.kyanite.deeperdarker.content.entities.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class SculkSnapperAnimation {
    public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(1f).looping()
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_front_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-37.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(1.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(1.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-37.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_front_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(1.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-37.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(1.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_back_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(1.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-37.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(1.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_back_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(1.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(1.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(4f).looping()
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition BITE = AnimationDefinition.Builder.withLength(0.5f)
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1667f, KeyframeAnimations.degreeVec(30f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1667f, KeyframeAnimations.degreeVec(-70f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition SIT = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_front_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 2f, -1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_front_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_front_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 2f, -1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_front_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_back_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(1f, 0.4f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_back_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_back_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(-1f, 0.4f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_back_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
}
