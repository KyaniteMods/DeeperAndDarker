package com.kyanite.deeperdarker.content.entities.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class SculkLeechAnimation {
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(2f).looping().build();
    public static final AnimationDefinition MOVE = AnimationDefinition.Builder.withLength(0.66667f).looping()
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -20f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.3333f, KeyframeAnimations.degreeVec(0f, 22.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.6667f, KeyframeAnimations.degreeVec(0f, -20f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -12.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.3333f, KeyframeAnimations.degreeVec(0f, 17.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.6667f, KeyframeAnimations.degreeVec(0f, -12.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 17.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.3333f, KeyframeAnimations.degreeVec(0f, -40f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.6667f, KeyframeAnimations.degreeVec(0f, 17.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 17.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.3333f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.6667f, KeyframeAnimations.degreeVec(0f, 17.5f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
}
