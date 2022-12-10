package com.kyanite.deeperdarker.registry.blocks;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.blocks.custom.entity.AncientChestEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class DDBlockEntityTypes {
    //public static final Supplier<BlockEntityType<AncientChestEntity>> ANCIENT_CHEST = RegistryHelper.registerBlockEntity("ancient_chest", () -> BlockEntityType.Builder.of(AncientChestEntity::new, DDBlocks.ANCIENT_CHEST.get()).build(null));
    //public static final Supplier<BlockEntityType<AncientChestEntity>> DEEPSLATE_CHEST = RegistryHelper.registerBlockEntity("deepslate_chest", () -> BlockEntityType.Builder.of(AncientChestEntity::new, DDBlocks.DEEPSLATE_CHEST.get()).build(null));

    public static void registerBlockEntities() {
        DeeperAndDarker.LOGGER.info("Deeper and Darker block entities have been registered");
    }
}
