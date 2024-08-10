package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.blocks.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.entities.blocks.DDHangingSignBlockEntity;
import com.kyanite.deeperdarker.content.entities.blocks.DDSignBlockEntity;
import com.mojang.datafixers.types.Type;
import com.kyanite.deeperdarker.content.entities.blocks.DDSkullBlockEntity;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class DDBlockEntities {
    public static final BlockEntityType<DDHangingSignBlockEntity> HANGING_SIGN;
    public static final BlockEntityType<DDSignBlockEntity> SIGN;
    public static final BlockEntityType<CrystallizedAmberBlockEntity> CRYSTALLIZED_AMBER;
    public static final BlockEntityType<DDSkullBlockEntity> SKULL;

    static {
        HANGING_SIGN = create("hanging_sign", BlockEntityType.Builder.of(
                DDHangingSignBlockEntity::new,
                DDBlocks.ECHO_HANGING_SIGN, DDBlocks.ECHO_WALL_HANGING_SIGN,
                DDBlocks.BLOOM_HANGING_SIGN, DDBlocks.BLOOM_WALL_HANGING_SIGN
        ));
        SIGN = create("sign", BlockEntityType.Builder.of(
                DDSignBlockEntity::new,
                DDBlocks.ECHO_SIGN, DDBlocks.ECHO_WALL_SIGN,
                DDBlocks.BLOOM_SIGN, DDBlocks.BLOOM_WALL_SIGN
        ));
        CRYSTALLIZED_AMBER = create("crystallized_amber", BlockEntityType.Builder.of(
                CrystallizedAmberBlockEntity::new,
                DDBlocks.CRYSTALLIZED_AMBER
        ));
        SKULL = create("skull", BlockEntityType.Builder.of(
                DDSkullBlockEntity::new,
                DDBlocks.SHATTERED_HEAD,
                DDBlocks.SHATTERED_WALL_HEAD
        ));
    }

    private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, id);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, DeeperDarker.rl(id), builder.build(type));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering block entities");
    }
}
