package com.kyanite.deeperdarker.client.render.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class ShriekWormRenderState extends LivingEntityRenderState {
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState asleepAnimationState = new AnimationState();
    public final AnimationState descendAnimationState = new AnimationState();
    public final AnimationState emergeAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
}
