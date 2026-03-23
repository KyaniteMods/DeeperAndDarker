package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum OvercastVesselPhaseType implements StringRepresentable {
    IDLE("idle", () -> OvercastVesselIdlePhase.CODEC),
    USE_ITEM("use_item", () -> OvercastVesselUseItemPhase.CODEC),
    SLIDER("slider", () -> OvercastVesselSliderPhase.CODEC);

    public static final Codec<OvercastVesselPhaseType> CODEC = StringRepresentable.fromEnum(OvercastVesselPhaseType::values);

    private final String name;
    private final Supplier<Codec<? extends OvercastVesselPhase>> codec;

    OvercastVesselPhaseType(String name, Supplier<Codec<? extends OvercastVesselPhase>> codec) {
        this.name = name;
        this.codec = codec;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }

    public Codec<? extends OvercastVesselPhase> getCodec() {
        return codec.get();
    }
}
