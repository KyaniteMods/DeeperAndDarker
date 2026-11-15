package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.kyanite.deeperdarker.content.entities.boss.BossPhaseType;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum OvercastVesselPhaseType implements StringRepresentable, BossPhaseType<OvercastVessel, OvercastVesselPhaseType, OvercastVesselPhase> {
    IDLE("idle", () -> OvercastVesselIdlePhase.CODEC),
    USE_ITEM("use_item", () -> OvercastVesselUseItemPhase.CODEC),
    SLIDER("slider", () -> OvercastVesselSliderPhase.CODEC);

    public static final Codec<OvercastVesselPhaseType> CODEC = StringRepresentable.fromEnum(OvercastVesselPhaseType::values);

    private final String name;
    private final Supplier<MapCodec<? extends OvercastVesselPhase>> codec;

    OvercastVesselPhaseType(String name, Supplier<MapCodec<? extends OvercastVesselPhase>> codec) {
        this.name = name;
        this.codec = codec;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }

    public MapCodec<? extends OvercastVesselPhase> getCodec() {
        return codec.get();
    }
}
