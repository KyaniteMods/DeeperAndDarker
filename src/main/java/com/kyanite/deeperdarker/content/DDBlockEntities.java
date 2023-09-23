package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.DDSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DeeperDarker.MOD_ID);

    public static final RegistryObject<BlockEntityType<DDSignBlockEntity>> DEEPER_DARKER_SIGNS = BLOCK_ENTITIES.register("deeper_darker_signs", () -> BlockEntityType.Builder.of(DDSignBlockEntity::new, DDBlocks.ECHO_SIGN.get(), DDBlocks.ECHO_WALL_SIGN.get()).build(null));
}
