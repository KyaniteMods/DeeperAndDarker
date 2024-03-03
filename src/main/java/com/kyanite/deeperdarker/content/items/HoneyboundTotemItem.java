package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.HoneyboundTotem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class HoneyboundTotemItem extends Item {
    public HoneyboundTotemItem(Properties properties) {
        super(properties);
    }

    public @NotNull InteractionResult useOn(UseOnContext useOnContext) {
        Direction direction = useOnContext.getClickedFace();
        if (direction == Direction.DOWN) {
            return InteractionResult.FAIL;
        } else {
            Level level = useOnContext.getLevel();
            BlockPlaceContext blockPlaceContext = new BlockPlaceContext(useOnContext);
            BlockPos blockPos = blockPlaceContext.getClickedPos();
            ItemStack itemStack = useOnContext.getItemInHand();
            Vec3 vec3 = Vec3.atBottomCenterOf(blockPos);
            AABB aABB = DDEntities.HONEYBOUND_TOTEM.getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
            if (level.noCollision(null, aABB) && level.getEntities(null, aABB).isEmpty()) {
                if (level instanceof ServerLevel serverLevel) {
                    Consumer<HoneyboundTotem> consumer = EntityType.createDefaultStackConfig(serverLevel, itemStack, useOnContext.getPlayer());
                    HoneyboundTotem totem = DDEntities.HONEYBOUND_TOTEM.create(serverLevel, itemStack.getTag(), consumer, blockPos, MobSpawnType.SPAWN_EGG, true, true);
                    if (totem == null) {
                        return InteractionResult.FAIL;
                    }

                    float f = (float) Mth.floor((Mth.wrapDegrees(useOnContext.getRotation() - 180.0F) + 22.5F) / 90.0F) * 90.0F;
                    totem.moveTo(totem.getX(), totem.getY(), totem.getZ(), f, 0.0F);
                    serverLevel.addFreshEntityWithPassengers(totem);
                    level.playSound(null, totem.getX(), totem.getY(), totem.getZ(), SoundEvents.DEEPSLATE_PLACE, SoundSource.BLOCKS, 0.75F, 0.8F);
                    totem.gameEvent(GameEvent.ENTITY_PLACE, useOnContext.getPlayer());
                }

                itemStack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.FAIL;
            }
        }
    }
}
