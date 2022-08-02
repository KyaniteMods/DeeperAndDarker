package com.kyanite.deeperdarker.registry.blocks.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.entity.custom.DDSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<BlockEntityType<DDSignBlockEntity>> SIGN_BLOCK_ENTITIES = BLOCK_ENTITY_TYPES.register("sign_block_entities", ()-> BlockEntityType.Builder.of(DDSignBlockEntity::new, DDBlocks.BONE_WALL_SIGN.get(), DDBlocks.BONE_SIGN.get(), DDBlocks.SCULK_BONE_WALL_SIGN.get(), DDBlocks.SCULK_BONE_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}