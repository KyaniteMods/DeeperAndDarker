package com.kyanite.deeperdarker.content.entities.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class OvercastPotAnimation {
    public static final AnimationDefinition SORROW_WALK = AnimationDefinition.Builder.withLength(1f).looping()
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(-7.5f, -12.5f, 1.5f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333f, KeyframeAnimations.degreeVec(-0.56f, -10.19f, 1.11f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-7.5f, 12.5f, 1.5f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333f, KeyframeAnimations.degreeVec(-0.56f, 10.19f, 1.11f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(-35f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(35f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).build();

    public static final AnimationDefinition ANGER_WALK = AnimationDefinition.Builder.withLength(1.5f).looping()
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, -3.5f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, -3.5f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0833f, KeyframeAnimations.degreeVec(5.0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)
            )).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-80.0145f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(80.0145f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(280.0145f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-80.0145f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(80.0145f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(280.0145f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)
            )).build();

    public static final AnimationDefinition ANGER_IDLE = AnimationDefinition.Builder.withLength(1f)
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 3.5f, 0f), AnimationChannel.Interpolations.LINEAR)
            )).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 3.5f, 0f), AnimationChannel.Interpolations.LINEAR)
            )).addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 3.5f, 0f), AnimationChannel.Interpolations.LINEAR)
            )).build();
}
