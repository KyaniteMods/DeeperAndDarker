package com.kyanite.deeperdarker.content.entities.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ShriekWormAnimation {
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(4f).looping()
            .addAnimation("segment_1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_6", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_7", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_8", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(50f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(55f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(50f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -10f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -10f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(1f)
            .addAnimation("segment_1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917f, KeyframeAnimations.degreeVec(40f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(47.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(-30f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_6", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_7", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_8", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(50f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.125f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(50f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917f, KeyframeAnimations.degreeVec(0f, 0f, -45f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917f, KeyframeAnimations.degreeVec(0f, 0f, 65f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -10f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(0f, 0f, -10f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917f, KeyframeAnimations.degreeVec(-52.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition ASLEEP = AnimationDefinition.Builder.withLength(4f).looping()
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, -10f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(0.1f, 0.1f, 0.1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("base", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, -97f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, -1.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 12.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition EMERGE = AnimationDefinition.Builder.withLength(7.8f)
            .addAnimation("base", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, -129f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("base", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -10f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4f, KeyframeAnimations.degreeVec(0f, 12.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.6f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 12.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.2f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4f, KeyframeAnimations.degreeVec(0f, 10f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6f, KeyframeAnimations.degreeVec(0f, -12.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, -12.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.2f, KeyframeAnimations.degreeVec(0f, -25f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4f, KeyframeAnimations.degreeVec(0f, -15f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.6f, KeyframeAnimations.degreeVec(0f, 12.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.8f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2f, KeyframeAnimations.degreeVec(0f, 12.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.4f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.6f, KeyframeAnimations.degreeVec(0f, -15f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.8f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("rib_1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.2f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.3f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.4f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("rib_2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.2f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.3f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.4f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("rib_3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.2f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.3f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.4f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_6", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("rib_4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.2f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.2f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.3f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.4f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.6f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.7f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.8f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.9f, KeyframeAnimations.degreeVec(0f, 5f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_7", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_8", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, -1.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2f, KeyframeAnimations.degreeVec(8.6f, -16.36f, -1.99f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(1.93f, -9.99f, -0.34f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.8f, KeyframeAnimations.degreeVec(3.68f, 9.88f, 5.71f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1f, KeyframeAnimations.degreeVec(6f, -9.57f, -3.62f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.3f, KeyframeAnimations.degreeVec(11.57f, 16.83f, 7.36f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6f, KeyframeAnimations.degreeVec(8.42f, -6.05f, -9.48f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8f, KeyframeAnimations.degreeVec(11.56f, -8.71f, 10.65f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.1f, KeyframeAnimations.degreeVec(10.1f, 12.3f, -3.24f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4f, KeyframeAnimations.degreeVec(6.74f, -32.17f, 1.59f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.7f, KeyframeAnimations.degreeVec(39.31f, -19.08f, -14.04f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(39.44f, -2.32f, -9.94f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.3f, KeyframeAnimations.degreeVec(51.41f, -5.76f, -4.77f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.7f, KeyframeAnimations.degreeVec(55.55f, -2.24f, -1.85f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(50f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-6.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 16.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -16.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -10f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(8.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(3.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition DESCEND = AnimationDefinition.Builder.withLength(4.125f)
            .addAnimation("base", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.posVec(0f, -129f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("base", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_6", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_7", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("segment_8", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, -1.5f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(50f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-6.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("front_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 16.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -16.25f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -10f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 15f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_bottom_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_middle_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(8.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("back_top_flap", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(3.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
}
