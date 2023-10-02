package com.kyanite.deeperdarker.content.entities.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class SculkCentipedeAnimation {
    public static final AnimationDefinition CRAWL = AnimationDefinition.Builder.withLength(1f).looping()
            .addAnimation("body_1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body_2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 12.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body_3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -12.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 12.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -12.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 27.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -32.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 27.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tail_1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -17.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 15f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -17.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tail_2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 12.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tail_3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_right_jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -52f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_left_jaw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_left_jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 52.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
}
