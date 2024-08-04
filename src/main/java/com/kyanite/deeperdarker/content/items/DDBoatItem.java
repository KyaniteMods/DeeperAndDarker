package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.content.entities.DDBoat;
import com.kyanite.deeperdarker.content.entities.DDChestBoat;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("NullableProblems")
public class DDBoatItem extends BoatItem {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final String WOOD_TYPE;
    private final boolean HAS_CHEST;

    public DDBoatItem(boolean hasChest, Properties properties, WoodType woodType) {
        super(hasChest, Boat.Type.MANGROVE, properties);
        this.WOOD_TYPE = woodType.name();
        this.HAS_CHEST = hasChest;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        HitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        if(hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            Vec3 vec3 = player.getViewVector(1);
            List<Entity> list = level.getEntities(player, player.getBoundingBox().expandTowards(vec3.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if(!list.isEmpty()) {
                Vec3 vec31 = player.getEyePosition();

                for(Entity entity : list) {
                    AABB aabb = entity.getBoundingBox().inflate(entity.getPickRadius());
                    if(aabb.contains(vec31)) {
                        return InteractionResultHolder.pass(itemstack);
                    }
                }
            }

            if(hitresult.getType() == HitResult.Type.BLOCK) {
                Boat boat = getBoat(level, hitresult);
                boat.setYRot(player.getYRot());
                if(!level.noCollision(boat, boat.getBoundingBox())) {
                    return InteractionResultHolder.fail(itemstack);
                } else {
                    if(!level.isClientSide) {
                        level.addFreshEntity(boat);
                        level.gameEvent(player, GameEvent.ENTITY_PLACE, hitresult.getLocation());
                        if(!player.getAbilities().instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
                }
            } else {
                return InteractionResultHolder.pass(itemstack);
            }
        }
    }

    private Boat getBoat(Level level, HitResult hitResult) {
        return HAS_CHEST ? new DDChestBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z, WOOD_TYPE) : new DDBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z, WOOD_TYPE);
    }
}
