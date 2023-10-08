package com.kyanite.deeperdarker.content.enchantments;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.block.SculkSpreader;

public class CatalysisEnchantment extends Enchantment {
    public CatalysisEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, EnchantmentCategory.WEAPON, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if(pTarget instanceof LivingEntity targetEntity && pAttacker instanceof ServerPlayer playerAttacker) {
            if(targetEntity.isDeadOrDying()) {
                SculkSpreader spreader = SculkSpreader.createLevelSpreader();
                spreader.addCursors(new BlockPos((int) (targetEntity.position().x + 0.5 * Direction.UP.getNormal().getX()), (int) (targetEntity.position().y + 0.5 * Direction.UP.getNormal().getY()), (int) (targetEntity.position().z + 0.5 * Direction.UP.getNormal().getZ())), 20);
                for(int i = 0; i < (int) (10 * pLevel * 0.9); i++) {
                    spreader.updateCursors(targetEntity.level(), targetEntity.blockPosition(), targetEntity.getRandom(), true);
                }
                targetEntity.skipDropExperience();
                CriteriaTriggers.KILL_MOB_NEAR_SCULK_CATALYST.trigger(playerAttacker, pTarget, pTarget.damageSources().playerAttack((Player) pAttacker));
            }
        }
    }

    @Override
    public int getMinCost(int pLevel) {
        return pLevel * 20;
    }

    @Override
    public int getMaxCost(int pLevel) {
        return (int) (getMinCost(pLevel) * 1.5);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof AxeItem || super.canEnchant(pStack);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
