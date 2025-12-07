package com.kyanite.deeperdarker.world.otherside.structures.maze;

import net.minecraft.resources.ResourceLocation;

public record Room(ResourceLocation id, Pos pos, Pos entrance) {
}
