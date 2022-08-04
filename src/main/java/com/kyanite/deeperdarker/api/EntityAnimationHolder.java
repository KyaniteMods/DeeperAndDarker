package com.kyanite.deeperdarker.api;

public class EntityAnimationHolder {
    public String animationId;
    public int lengthInTicks;
    public boolean loop;
    public boolean countTicks;

    public EntityAnimationHolder(String animationId, int lengthInTicks, boolean loop, boolean countTicks) {
        this.animationId = animationId;
        this.lengthInTicks = lengthInTicks;
        this.loop = loop;
        this.countTicks = countTicks;
    }
}