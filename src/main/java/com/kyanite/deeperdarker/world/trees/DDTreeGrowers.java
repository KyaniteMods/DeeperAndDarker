package com.kyanite.deeperdarker.world.trees;

import com.kyanite.deeperdarker.world.DDConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class DDTreeGrowers {
    public static final TreeGrower ECHO = new TreeGrower("echo", Optional.empty(), Optional.of(DDConfiguredFeatures.TREE_ECHO), Optional.empty());
}
