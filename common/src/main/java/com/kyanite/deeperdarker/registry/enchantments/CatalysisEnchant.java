package com.kyanite.deeperdarker.registry.enchantments;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SculkCatalystBlock;
import net.minecraft.world.level.block.SculkSpreader;

public class CatalysisEnchant extends Enchantment {
    protected CatalysisEnchant(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot[] equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public void doPostAttack(LivingEntity livingEntity, Entity entity, int i) {
        if(entity instanceof LivingEntity living) {
            if(living.isDeadOrDying()) {
                SculkSpreader sculkSpreader = SculkSpreader.createLevelSpreader();
                sculkSpreader.addCursors(new BlockPos(living.position().relative(Direction.UP, 0.5)), 20);
                for (int i2 = 0; i2 < 10; i2++) {
                    sculkSpreader.updateCursors(living.level, living.blockPosition(), living.getRandom(), true);
                }
                living.skipDropExperience();
                living.level.setBlock(living.blockPosition(), Blocks.SCULK_CATALYST.defaultBlockState(), 3);
                SculkCatalystBlock.bloom((ServerLevel) living.level, living.blockPosition(), living.level.getBlockState(living.blockPosition()), living.level.getRandom());
                CriteriaTriggers.KILL_MOB_NEAR_SCULK_CATALYST.trigger((ServerPlayer) livingEntity, entity, DamageSource.playerAttack((Player) livingEntity));
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }
}
