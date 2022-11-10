package com.kyanite.deeperdarker.miscellaneous;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class DDSoundType extends SoundType {
    private final Supplier<SoundEvent> breakSound;
    private final Supplier<SoundEvent> stepSound;
    private final Supplier<SoundEvent> placeSound;
    private final Supplier<SoundEvent> hitSound;
    private final Supplier<SoundEvent> fallSound;

    public DDSoundType(float volumeIn, float pitchIn, Supplier<SoundEvent> breakSoundIn, Supplier<SoundEvent> stepSoundIn, Supplier<SoundEvent> placeSoundIn, Supplier<SoundEvent> hitSoundIn, Supplier<SoundEvent> fallSoundIn) {
        super(volumeIn, pitchIn, null, null, null, null, null);
        this.breakSound = breakSoundIn;
        this.stepSound = stepSoundIn;
        this.placeSound = placeSoundIn;
        this.hitSound = hitSoundIn;
        this.fallSound = fallSoundIn;
    }

    @NotNull
    @Override
    public SoundEvent getBreakSound() {
        return breakSound.get();
    }

    @NotNull
    @Override
    public SoundEvent getStepSound() {
        return stepSound.get();
    }

    @NotNull
    @Override
    public SoundEvent getPlaceSound() {
        return placeSound.get();
    }

    @NotNull
    @Override
    public SoundEvent getHitSound() {
        return hitSound.get();
    }

    @NotNull
    @Override
    public SoundEvent getFallSound() {
        return fallSound.get();
    }
}
