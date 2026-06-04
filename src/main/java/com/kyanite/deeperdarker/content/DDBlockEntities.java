package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.entity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, DeeperDarker.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DDSignBlockEntity>> DEEPER_DARKER_SIGNS = BLOCK_ENTITIES.register("deeper_darker_signs", () -> new BlockEntityType<>(DDSignBlockEntity::new, DDBlocks.ECHO_SIGN.get(), DDBlocks.ECHO_WALL_SIGN.get(), DDBlocks.BLOOM_SIGN.get(), DDBlocks.BLOOM_WALL_SIGN.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DDHangingSignBlockEntity>> DEEPER_DARKER_HANGING_SIGNS = BLOCK_ENTITIES.register("deeper_darker_hanging_signs", () -> new BlockEntityType<>(DDHangingSignBlockEntity::new, DDBlocks.ECHO_HANGING_SIGN.get(), DDBlocks.ECHO_WALL_HANGING_SIGN.get(), DDBlocks.BLOOM_HANGING_SIGN.get(), DDBlocks.BLOOM_WALL_HANGING_SIGN.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CrystallizedAmberBlockEntity>> CRYSTALLIZED_AMBER = BLOCK_ENTITIES.register("crystallized_amber", () -> new BlockEntityType<>(CrystallizedAmberBlockEntity::new, DDBlocks.CRYSTALLIZED_AMBER.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GloomslatePotBlockEntity>> GLOOMSLATE_POT = BLOCK_ENTITIES.register("gloomslate_pot", () -> new BlockEntityType<>(GloomslatePotBlockEntity::new, DDBlocks.GLOOMSLATE_POT.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SculkJawBlockEntity>> SCULK_JAW = BLOCK_ENTITIES.register("sculk_jaw", () -> new BlockEntityType<>(SculkJawBlockEntity::new, DDBlocks.SCULK_JAW.get()));
}
