package com.kyanite.deeperdarker.api;

public class EntityState {
    public String name;
    public boolean doAnimate;
    public EntityAnimationHolder animationHolder;
    public EntityState(String name, boolean doAnimate, EntityAnimationHolder animationHolder) {
        this.name = name;
        this.doAnimate = doAnimate;
        this.animationHolder = animationHolder;
    }
}
