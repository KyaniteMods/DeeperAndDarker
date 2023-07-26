package com.kyanite.deeperdarker.client.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class SculkLeechAnimation {
    public static final Animation MOVE = Animation.Builder.create(0.66667f).looping()
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -20f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.3333f, AnimationHelper.createRotationalVector(0f, 22.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createRotationalVector(0f, -20f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -12.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.3333f, AnimationHelper.createRotationalVector(0f, 17.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createRotationalVector(0f, -12.5f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 17.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.3333f, AnimationHelper.createRotationalVector(0f, -40f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createRotationalVector(0f, 17.5f, 0f), Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back_tail", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 17.5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.3333f, AnimationHelper.createRotationalVector(0f, -5f, 0f), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.6667f, AnimationHelper.createRotationalVector(0f, 17.5f, 0f), Transformation.Interpolations.LINEAR))).build();
}
