package com.kyanite.deeperdarker.entities;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import net.minecraft.block.WoodType;
import net.minecraft.util.StringIdentifiable;

public enum DeeperDarkerBoatTypes implements StringIdentifiable {
    ECHO("echo", DeeperDarkerBlocks.ECHO_WOOD_TYPE);

    private final String name;
    private final WoodType woodType;

    DeeperDarkerBoatTypes(String name, WoodType woodType) {
        this.name = name;
        this.woodType = woodType;
    }

    @Override
    public String asString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public WoodType getWoodType() {
        return this.woodType;
    }

    public static DeeperDarkerBoatTypes getFromWoodType(WoodType type) {
        for (DeeperDarkerBoatTypes t : DeeperDarkerBoatTypes.values()) {
            if (t.getWoodType() == type) {
                return t;
            }
        }
        return ECHO;
    }

    public static DeeperDarkerBoatTypes getFromString(String name) {
        try {
            return Enum.valueOf(DeeperDarkerBoatTypes.class, name);
        } catch (IllegalArgumentException e) {
            return ECHO;
        }
    }
}
