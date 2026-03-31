package com.kyanite.deeperdarker.content.fluids;

public interface EntityInAcid {
    default boolean deeperdarker$isInAcid() {
        return false;
    }
    default void deeperdarker$acidHurt() {
    }
    default boolean deeperdarker$acidImmune() {
        return false;
    }
}
