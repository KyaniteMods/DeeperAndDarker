package com.kyanite.deeperdarker.blocks.entity;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.mojang.datafixers.types.Type;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class DeeperDarkerBlockEntityTypes {
    public static final BlockEntityType<DeeperDarkerHangingSignBlockEntity> HANGING_SIGN;
    public static final BlockEntityType<DeeperDarkerSignBlockEntity> SIGN;

    static {
        HANGING_SIGN = create("hanging_sign", FabricBlockEntityTypeBuilder.create(
                DeeperDarkerHangingSignBlockEntity::new, DeeperDarkerBlocks.ECHO_HANGING_SIGN, DeeperDarkerBlocks.ECHO_WALL_HANGING_SIGN));
        SIGN = create("sign", FabricBlockEntityTypeBuilder.create(
                DeeperDarkerSignBlockEntity::new, DeeperDarkerBlocks.ECHO_SIGN, DeeperDarkerBlocks.ECHO_WALL_SIGN));
    }

    private static <T extends BlockEntity> BlockEntityType<T> create(String id, FabricBlockEntityTypeBuilder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DeeperDarker.MOD_ID, id), builder.build(type));
    }
}
