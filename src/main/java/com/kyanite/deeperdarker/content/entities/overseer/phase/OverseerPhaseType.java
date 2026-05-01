package com.kyanite.deeperdarker.content.entities.overseer.phase;

import com.kyanite.deeperdarker.content.entities.boss.BossPhaseType;
import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum OverseerPhaseType implements StringRepresentable, BossPhaseType<Overseer, OverseerPhaseType, OverseerPhase> {
    IDLE("idle", () -> OverseerIdlePhase.CODEC),
    CRYSTALS("crystals", () -> OverseerCrystalsPhase.CODEC),
    LASERS("lasers", () -> OverseerLasersPhase.CODEC);

    public static final Codec<OverseerPhaseType> CODEC = StringRepresentable.fromEnum(OverseerPhaseType::values);

    private final String name;
    private final Supplier<Codec<? extends OverseerPhase>> codec;

    OverseerPhaseType(String name, Supplier<Codec<? extends OverseerPhase>> codec) {
        this.name = name;
        this.codec = codec;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }

    public Codec<? extends OverseerPhase> getCodec() {
        return codec.get();
    }
}
