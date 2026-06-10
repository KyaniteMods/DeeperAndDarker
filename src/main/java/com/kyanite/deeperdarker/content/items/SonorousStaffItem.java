package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.content.DDEnchantments;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class SonorousStaffItem extends Item {
    public double dropOffFactor = 1/3.0;

    public SonorousStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entity, int remainingTime) {
        if(!(entity instanceof Player player)) return false;

        HolderLookup.RegistryLookup<Enchantment> lookup = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
        int volume = stack.getEnchantmentLevel(lookup.getOrThrow(DDEnchantments.VOLUME));
        int reverberation = stack.getEnchantmentLevel(lookup.getOrThrow(DDEnchantments.REVERBERATION));

        int timeUsed = getUseDuration(stack, player) - remainingTime;
        int damage = (int) Math.round(50 * (volume / 4.0 + 1) / (1 + 16 / Math.exp(0.06 * timeUsed)));
        int range = (int) Math.min(80, Math.round(4.5 * (2 * reverberation / 3.0 + 1) * Math.log(timeUsed + 1)));

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
            for(LivingEntity target : targets) {
                if(target.is(player)) continue;

                int finalDamage = (int) Math.round(damage * (1 - dropOffFactor * Math.pow((double) i / range, 2)));
                target.hurt(level.damageSources().sonicBoom(player), finalDamage);

                double horizontalResistance = 1 - target.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
                double verticalResistance = 1 - target.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
                target.push(facing.x * horizontalResistance, facing.y * verticalResistance, facing.z * horizontalResistance);
            }
        }

        player.playSound(DDSounds.STAFF_SONIC_BOOM.get());
        stack.hurtAndBreak(1, player, player.getUsedItemHand());
        player.awardStat(Stats.ITEM_USED.get(this));
        player.getCooldowns().addCooldown(stack, 20);
        return true;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        player.awardStat(Stats.ITEM_USED.get(this));
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        if(owner instanceof Player player) {
            CompoundTag tag;
            if(itemStack.has(DataComponents.CUSTOM_DATA)) tag = itemStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
            else tag = new CompoundTag();
            tag.putBoolean("charged", player.getUseItem() == itemStack && itemStack.getUseDuration(player) - player.getUseItemRemainingTicks() >= 128);
            itemStack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        }
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return super.isFoil(stack) || (stack.has(DataComponents.CUSTOM_DATA) && stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("charged", false));
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity livingEntity) {
        return 72000;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.BOW;
    }
}
