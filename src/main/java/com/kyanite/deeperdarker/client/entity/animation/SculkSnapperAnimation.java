package com.kyanite.deeperdarker.client.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class SculkSnapperAnimation {
    public static final Animation WALK = Animation.Builder.create(1.0f).looping()
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-37.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(1.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(1.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-37.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(1.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-37.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(1.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(20f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_back_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(35f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(1.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-37.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(1.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(35f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_back_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(1.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(20f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(1.25f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-17.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("root", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 2.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation IDLE = Animation.Builder.create(4f).looping()
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(2f, AnimationHelper.createRotationalVector(-17.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("root", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation BITE = Animation.Builder.create(0.5f)
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.1667f, AnimationHelper.createRotationalVector(30f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.1667f, AnimationHelper.createRotationalVector(-70f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("root", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation SNIFF = Animation.Builder.create(1.5f)
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(25.14f, -19.47f, -7.35f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(21.23f, 12.47f, 13.8f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-40f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1f, AnimationHelper.createRotationalVector(-32.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("root", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation DIG = Animation.Builder.create(3f)
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.0833f, AnimationHelper.createRotationalVector(-32.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("root", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.0833f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createTranslationalVector(0f, -18f, -7f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("root", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.0833f, AnimationHelper.createRotationalVector(40f, 0f, 0f), Transformation.Interpolations.LINEAR))).build();

    public static final Animation EMERGE = Animation.Builder.create(0.75f)
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-27.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(10f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-32.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5833f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-77.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(-62.29f, -0.13f, 2.32f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_back_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(37.5f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_back_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(30f, 0f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("root", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -18f, 18f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("root", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f), Transformation.Interpolations.LINEAR))).build();
}
