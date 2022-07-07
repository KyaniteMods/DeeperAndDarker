package com.nitro.deeperdarker.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class DDProperties {
    public static final BlockBehaviour.Properties BONE_WOOD = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().strength(1.5F, 6F).sound(SoundType.BONE_BLOCK);
    public static final BlockBehaviour.Properties BONE_WOOD_NOT_SOLID = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().strength(1.5F, 6F).sound(SoundType.BONE_BLOCK).noOcclusion();
    public static final BlockBehaviour.Properties SCULK_BONE_WOOD = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(1.5F, 6F).sound(SoundType.SCULK);
    public static final BlockBehaviour.Properties SCULK_BONE_WOOD_NOT_SOLID = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(1.5F, 6F).sound(SoundType.SCULK).noOcclusion();

    public static BlockBehaviour.Properties getBoneWood(boolean ticksRandomly, boolean doesNotBlockMovement) {
        Block.Properties bone_wood = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().strength(1.5F, 6F).sound(SoundType.BONE_BLOCK);
        if (ticksRandomly) {
            bone_wood.randomTicks();
        }
        if (doesNotBlockMovement) {
            bone_wood.noCollission();
        }
        return bone_wood;
    }

    public static BlockBehaviour.Properties getSculkBoneWood(boolean ticksRandomly, boolean doesNotBlockMovement) {
        Block.Properties bone_wood = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(1.5F, 6F).sound(SoundType.SCULK);
        if (ticksRandomly) {
            bone_wood.randomTicks();
        }
        if (doesNotBlockMovement) {
            bone_wood.noCollission();
        }
        return bone_wood;
    }
}