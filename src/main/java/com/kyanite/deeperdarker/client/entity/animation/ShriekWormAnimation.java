package com.kyanite.deeperdarker.client.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ShriekWormAnimation {
    public static final Animation IDLE = Animation.Builder.create(4f).looping()
            .addBoneAnimation("segment_1", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_3", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_4", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_5", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_6", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_7", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_8", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(27.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(25f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(50f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(55f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(50f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, -7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -7.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 17.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 17.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -17.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, -7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -17.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -10f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, -5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -10f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation ATTACK = Animation.Builder.create(1f)
            .addBoneAnimation("segment_1", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2917f, AnimationHelper.createRotationalVector(40f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_3", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(27.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_4", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(47.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_5", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(-30f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_6", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_7", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(-17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_8", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(25f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(50f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.125f, AnimationHelper.createRotationalVector(2.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(50f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2917f, AnimationHelper.createRotationalVector(42.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2917f, AnimationHelper.createRotationalVector(0f, 0f, -45f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, -7.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 17.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(0f, 0f, 17.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2917f, AnimationHelper.createRotationalVector(0f, 0f, 65f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -17.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, -17.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -10f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(0f, 0f, -10f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2917f, AnimationHelper.createRotationalVector(-52.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4167f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation ASLEEP = Animation.Builder.create(4f).looping()
            .addBoneAnimation("root", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -10f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("root", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(0.1f, 0.1f, 0.1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("base", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -97f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, -1.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, -12.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, -17.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, -17.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 12.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 17.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 17.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation EMERGE = Animation.Builder.create(7.8f)
            .addBoneAnimation("base", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -129f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("base", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_1", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -10f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4f, AnimationHelper.createRotationalVector(0f, 12.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.8f, AnimationHelper.createRotationalVector(0f, 2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 12.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.2f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4f, AnimationHelper.createRotationalVector(0f, 10f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.6f, AnimationHelper.createRotationalVector(0f, -12.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.8f, AnimationHelper.createRotationalVector(0f, 7.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, -12.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.2f, AnimationHelper.createRotationalVector(0f, -25f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4f, AnimationHelper.createRotationalVector(0f, -15f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.6f, AnimationHelper.createRotationalVector(0f, 12.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.8f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2f, AnimationHelper.createRotationalVector(0f, 12.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.4f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.6f, AnimationHelper.createRotationalVector(0f, -15f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.8f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_3", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("rib_1", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.1f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.2f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.3f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.1f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.3f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.4f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_4", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("rib_2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.1f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.2f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.3f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.1f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.3f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.4f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_5", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("rib_3", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.1f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.2f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.3f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.1f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.3f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.4f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_6", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("rib_4", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.1f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.2f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.3f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.1f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.2f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.3f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.4f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.6f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.7f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.8f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.9f, AnimationHelper.createRotationalVector(0f, 5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_7", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_8", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(25f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, -1.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2f, AnimationHelper.createRotationalVector(8.6f, -16.36f, -1.99f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(1.93f, -9.99f, -0.34f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.8f, AnimationHelper.createRotationalVector(3.68f, 9.88f, 5.71f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.1f, AnimationHelper.createRotationalVector(6f, -9.57f, -3.62f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.3f, AnimationHelper.createRotationalVector(11.57f, 16.83f, 7.36f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.6f, AnimationHelper.createRotationalVector(8.42f, -6.05f, -9.48f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.8f, AnimationHelper.createRotationalVector(11.56f, -8.71f, 10.65f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.1f, AnimationHelper.createRotationalVector(10.1f, 12.3f, -3.24f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.4f, AnimationHelper.createRotationalVector(6.74f, -32.17f, 1.59f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.7f, AnimationHelper.createRotationalVector(39.31f, -19.08f, -14.04f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3f, AnimationHelper.createRotationalVector(39.44f, -2.32f, -9.94f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.3f, AnimationHelper.createRotationalVector(51.41f, -5.76f, -4.77f), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.7f, AnimationHelper.createRotationalVector(55.55f, -2.24f, -1.85f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(50f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-6.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -7.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 16.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 17.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, -16.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -17.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -10f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(8.75f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(3.75f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation DESCEND = Animation.Builder.create(4.125f)
            .addBoneAnimation("base", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createTranslationalVector(0f, -129f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("base", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_3", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_4", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_5", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_6", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_7", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("segment_8", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createTranslationalVector(0f, 0f, -1.5f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(50f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-6.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("front_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 17.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 16.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 7.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -17.5f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, -16.25f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -10f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_bottom_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_middle_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(8.75f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_top_flap", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(12.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(3.75f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(-15f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();
}