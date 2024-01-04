package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.entity.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.blocks.entity.DDHangingSignBlockEntity;
import com.kyanite.deeperdarker.content.blocks.entity.DDSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DeeperDarker.MOD_ID);

    public static final RegistryObject<BlockEntityType<DDSignBlockEntity>> DEEPER_DARKER_SIGNS = BLOCK_ENTITIES.register("deeper_darker_signs", () -> BlockEntityType.Builder.of(DDSignBlockEntity::new, DDBlocks.ECHO_SIGN.get(), DDBlocks.ECHO_WALL_SIGN.get(), DDBlocks.BLOOM_SIGN.get(), DDBlocks.BLOOM_WALL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<DDHangingSignBlockEntity>> DEEPER_DARKER_HANGING_SIGNS = BLOCK_ENTITIES.register("deeper_darker_hanging_signs", () -> BlockEntityType.Builder.of(DDHangingSignBlockEntity::new, DDBlocks.ECHO_HANGING_SIGN.get(), DDBlocks.ECHO_WALL_HANGING_SIGN.get(), DDBlocks.BLOOM_HANGING_SIGN.get(), DDBlocks.BLOOM_WALL_HANGING_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<CrystallizedAmberBlockEntity>> CRYSTALLIZED_AMBER = BLOCK_ENTITIES.register("crystallized_amber", () -> BlockEntityType.Builder.of(CrystallizedAmberBlockEntity::new, DDBlocks.CRYSTALLIZED_AMBER.get()).build(null));
}
