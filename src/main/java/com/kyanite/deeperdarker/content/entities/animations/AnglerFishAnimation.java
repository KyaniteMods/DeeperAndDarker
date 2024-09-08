package com.kyanite.deeperdarker.content.entities.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class AnglerFishAnimation {
    public static final AnimationDefinition SWIM = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0.5f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0.5f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0.5f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(10.04f, -4.92f, -0.87f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(10.04f, 4.92f, 0.87f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(10.04f, -4.92f, -0.87f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(10.04f, 4.92f, 0.87f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(10.04f, -4.92f, -0.87f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("hook", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0.25f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, 0.25f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 0.25f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("hook", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5.02f, 4.98f, 0.44f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(5.02f, -4.98f, -0.44f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(5.02f, 4.98f, 0.44f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(5.02f, -4.98f, -0.44f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(5.02f, 4.98f, 0.44f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -10f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 10f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -10f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 10f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, -10f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leftFin", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("rightFin", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, -9.88f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, 9.88f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, -9.88f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(0f, 9.88f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("caudalFin", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -25f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, -18.33f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, 18.33f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -25f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, -18.33f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625f, KeyframeAnimations.degreeVec(0f, 18.33f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, -25f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leftTail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("rightTail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("dorsalFin", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM))).build();

    public static final AnimationDefinition BITE = AnimationDefinition.Builder.withLength(0.75f)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.125f, KeyframeAnimations.posVec(0f, -1f, 2.79f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2916767f, KeyframeAnimations.posVec(0f, 0f, 2.5f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583433f, KeyframeAnimations.posVec(0f, 0f, -2.5f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5834334f, KeyframeAnimations.posVec(0f, 0f, -2.5f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0.5f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0.5f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(10.04f, 0f, -0.87f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(27.54f, 0f, -0.87f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(15.04f, 0f, -0.87f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(7.54f, 0f, -0.87f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(7.54f, 0f, -0.87f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(10.04f, 0f, -0.87f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("hook", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0.25f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0.25f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("hook", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5.02f, 0f, 0.44f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(-17.48f, 0f, 0.44f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(21.16f, 0f, 0.44f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(10.02f, 0f, 0.44f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-7.48f, 0f, 0.44f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(5.02f, 0f, 0.44f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(-67.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-67.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(18.61f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leftFin", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("rightFin", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("caudalFin", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftTail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("rightTail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("dorsalFin", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
}
