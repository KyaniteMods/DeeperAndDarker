package com.kyanite.deeperdarker.enchantments;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.SculkCatalystBlock;
import net.minecraft.block.entity.SculkSpreadManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;

public class CatalysisEnchantment extends Enchantment {
    public CatalysisEnchantment(Rarity rarity, EquipmentSlot... applicableSlots) {
        super(rarity, EnchantmentTarget.WEAPON, applicableSlots);
    }

    @Override
    public void onTargetDamaged(LivingEntity attacker, Entity target, int level) {
        if(target instanceof LivingEntity entity) {
            if (entity.isDead()) {
                SculkSpreadManager spreader = SculkSpreadManager.create();
                spreader.spread(new BlockPos(new Vec3i((int) (entity.getPos().x + 0.5 * Direction.UP.getVector().getX()), (int) (entity.getPos().y + 0.5 * Direction.UP.getVector().getY()), (int) (entity.getPos().z + 0.5 * Direction.UP.getVector().getZ()))), 20);
                for (int i2 = 0; i2 < 10; i2++) {
                    spreader.tick(entity.getWorld(), entity.getBlockPos(), entity.getRandom(), true);
                }
                entity.disableExperienceDropping();
                if (entity.getWorld().getBlockState(entity.getBlockPos()).get(SculkCatalystBlock.BLOOM)) {
                    entity.getWorld().setBlockState(entity.getBlockPos(), entity.getWorld().getBlockState(entity.getBlockPos()).with(SculkCatalystBlock.BLOOM, false), 3);
                }

                Criteria.KILL_MOB_NEAR_SCULK_CATALYST.trigger((ServerPlayerEntity) attacker, target, target.getDamageSources().playerAttack((PlayerEntity) attacker));
            }
        }
    }

    @Override
    public int getMinPower(int level) {
        return level * 20;
    }

    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }
}