package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.blocks.DDHangingSignBlockEntity;
import com.kyanite.deeperdarker.content.entities.blocks.DDSignBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import com.mojang.datafixers.types.Type;

public class DDBlockEntities {
    public static final BlockEntityType<DDHangingSignBlockEntity> HANGING_SIGN;
    public static final BlockEntityType<DDSignBlockEntity> SIGN;

    static {
        HANGING_SIGN = create("hanging_sign", FabricBlockEntityTypeBuilder.create(
                DDHangingSignBlockEntity::new,
                DDBlocks.ECHO_HANGING_SIGN, DDBlocks.ECHO_WALL_HANGING_SIGN,
                DDBlocks.BLOOM_HANGING_SIGN, DDBlocks.BLOOM_WALL_HANGING_SIGN
        ));
        SIGN = create("sign", FabricBlockEntityTypeBuilder.create(
                DDSignBlockEntity::new,
                DDBlocks.ECHO_SIGN, DDBlocks.ECHO_WALL_SIGN,
                DDBlocks.BLOOM_SIGN, DDBlocks.BLOOM_WALL_SIGN
        ));
    }

    private static <T extends BlockEntity> BlockEntityType<T> create(String id, FabricBlockEntityTypeBuilder<T> builder) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, id);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, id), builder.build(type));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering block entities");
    }
}
