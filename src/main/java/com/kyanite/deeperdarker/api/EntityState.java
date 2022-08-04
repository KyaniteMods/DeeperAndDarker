package com.kyanite.deeperdarker.api;

public class EntityState {
    public String name;
    public boolean doAnimate;
    public EntityAnimationHolder animationHolder;

    public EntityState(boolean doAnimate, EntityAnimationHolder animationHolder) {
        this.doAnimate = doAnimate;
        this.animationHolder = animationHolder;
    }
}