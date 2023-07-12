package com.kyanite.deeperdarker.items;

import com.kyanite.deeperdarker.entities.DeeperDarkerBoatEntity;
import com.kyanite.deeperdarker.entities.DeeperDarkerChestBoatEntity;
import net.minecraft.block.WoodType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.function.Predicate;

public class DeeperDarkerBoatItem extends BoatItem {
    private static final Predicate<Entity> RIDERS = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::canHit);
    private final String WOOD_TYPE;
    private final boolean chest;

    public DeeperDarkerBoatItem(boolean chest, WoodType type, Settings settings) {
        super(chest, BoatEntity.Type.MANGROVE, settings);
        this.WOOD_TYPE = type.name().split(":")[1];
        this.chest = chest;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult hitResult = BoatItem.raycast(world, user, RaycastContext.FluidHandling.ANY);
        if (((HitResult)hitResult).getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(itemStack);
        }
        Vec3d vec3d = user.getRotationVec(1.0f);
        List<Entity> list = world.getOtherEntities(user, user.getBoundingBox().stretch(vec3d.multiply(5.0)).expand(1.0), RIDERS);
        if (!list.isEmpty()) {
            Vec3d vec3d2 = user.getEyePos();
            for (Entity entity : list) {
                Box box = entity.getBoundingBox().expand(entity.getTargetingMargin());
                if (!box.contains(vec3d2)) continue;
                return TypedActionResult.pass(itemStack);
            }
        }
        if (((HitResult)hitResult).getType() == HitResult.Type.BLOCK) {
            BoatEntity boatEntity = this.createEntity(world, hitResult);
            if (boatEntity instanceof DeeperDarkerChestBoatEntity) {
                ((DeeperDarkerChestBoatEntity)boatEntity).setWoodType(WOOD_TYPE);
            } else {
                ((DeeperDarkerBoatEntity)boatEntity).setWoodType(WOOD_TYPE);
            }
            boatEntity.setYaw(user.getYaw());
            if (!world.isSpaceEmpty(boatEntity, boatEntity.getBoundingBox())) {
                return TypedActionResult.fail(itemStack);
            }
            if (!world.isClient) {
                world.spawnEntity(boatEntity);
                world.emitGameEvent((Entity)user, GameEvent.ENTITY_PLACE, hitResult.getPos());
                if (!user.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }
            }
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(itemStack, world.isClient());
        }
        return TypedActionResult.pass(itemStack);
    }

    private BoatEntity createEntity(World world, HitResult hitResult) {
        return this.chest ? new DeeperDarkerChestBoatEntity(world, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z, WOOD_TYPE) : new DeeperDarkerBoatEntity(world, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z, WOOD_TYPE);
    }
}
