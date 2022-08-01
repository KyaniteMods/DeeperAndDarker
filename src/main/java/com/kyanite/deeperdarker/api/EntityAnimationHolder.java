package com.kyanite.deeperdarker.api;

public class EntityAnimationHolder {
    public String animationId;
    public int lengthInTicks;
    public boolean loop;

    public EntityAnimationHolder(String animationId, int lengthInTicks, boolean loop) {
        this.animationId = animationId;
        this.lengthInTicks = lengthInTicks;
        this.loop = loop;
    }
}
