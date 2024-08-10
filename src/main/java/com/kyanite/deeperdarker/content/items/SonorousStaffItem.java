package com.kyanite.deeperdarker.content.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class SonorousStaffItem extends Item {
    public double dropOffFactor = 1/3.0;

    public SonorousStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
        if(!(livingEntity instanceof Player player)) return;

        int timeUsed = getUseDuration(stack, player) - timeCharged;
        int damage = (int) Math.round(50 / (1 + 16 / Math.exp(0.06 * timeUsed)));
        int range = (int) Math.min(40, Math.round(3 * Math.log(timeUsed + 1)));

        Vec3 eyePos = player.getEyePosition();
        Vec3 facing = player.getForward();
        for(int i = 0; i < range; i++) {
            Vec3 scanVec = eyePos.add(facing.scale(i));
            BlockPos targetPos = new BlockPos((int) scanVec.x, (int) scanVec.y, (int) scanVec.z);
            BlockState targetState = level.getBlockState(targetPos);

            if(!targetState.isAir() && targetState.canOcclude()) break;
            if(level.isClientSide() && i % 2 == 0) level.addParticle(ParticleTypes.SONIC_BOOM, scanVec.x, scanVec.y, scanVec.z, 1, 0, 0);

            AABB aabb = new AABB(targetPos).inflate(0.4);
            List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, aabb);
            for(LivingEntity entity : targets) {
                if(entity.is(player)) continue;

                int finalDamage = (int) (damage * (1 - dropOffFactor * Math.pow((double) i / range, 2)));
                entity.hurt(level.damageSources().sonicBoom(player), finalDamage);
                double horizontalResistance = 1 - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
                double verticalResistance = 1 - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
                entity.push(facing.x * horizontalResistance, facing.y * verticalResistance, facing.z * horizontalResistance);
            }
        }

        player.playSound(SoundEvents.WARDEN_SONIC_BOOM);
        stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
        player.awardStat(Stats.ITEM_USED.get(this));
        player.getCooldowns().addCooldown(this, 20);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        player.startUsingItem(usedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player) {
            CompoundTag tag;
            if(stack.has(DataComponents.CUSTOM_DATA)) tag = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
            else tag = new CompoundTag();
            tag.putBoolean("charged", player.getUseItem() == stack && stack.getUseDuration(player) - player.getUseItemRemainingTicks() >= 123);
            stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        }
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return super.isFoil(stack) || (stack.has(DataComponents.CUSTOM_DATA) && stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("charged"));
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity livingEntity) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
}
