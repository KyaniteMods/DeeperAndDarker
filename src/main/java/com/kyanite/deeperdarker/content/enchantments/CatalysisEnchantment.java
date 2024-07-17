package com.kyanite.deeperdarker.content.enchantments;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
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
        if (pAttacker instanceof ServerPlayer player && pTarget instanceof LivingEntity target) {
            if (target.isDeadOrDying()) {
                SculkSpreader spreader = SculkSpreader.createLevelSpreader();
                BlockPos pos = target.blockPosition();
                for (int i = 0; i < 3 * pLevel; i++) {
                    spreader.addCursors(pos, target.getExperienceReward());
                }
                for (int i = 0; i < 8 * pLevel; i++) {
                    spreader.updateCursors(player.level(), pos, player.getRandom(), true);
                }

                target.skipDropExperience();
                CriteriaTriggers.KILL_MOB_NEAR_SCULK_CATALYST.trigger(player, pTarget, pTarget.damageSources().playerAttack(player));
            }
        }
    }

    @Override
    public int getMinCost(int pLevel) {
        return pLevel * 20 - 10;
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
