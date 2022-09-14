package com.kyanite.deeperdarker.registry.blocks.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<BlockEntityType<DDSignBlockEntity>> SIGN_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("sign_block_entity", ()-> BlockEntityType.Builder.of(DDSignBlockEntity::new, DDBlocks.ECHO_WALL_SIGN.get(), DDBlocks.ECHO_SIGN.get()).build(null));
}
