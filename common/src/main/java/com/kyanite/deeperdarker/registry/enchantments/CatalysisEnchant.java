package com.kyanite.deeperdarker.registry.enchantments;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerPlayer;
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
//                sculkSpreader.addCursors(new BlockPos(living.position().relative(Direction.UP, 0.5)), 20);
                sculkSpreader.addCursors(new BlockPos(new Vec3i((int) (living.position().x + 0.5 * Direction.UP.getNormal().getX()), (int) (living.position().y + 0.5 * Direction.UP.getNormal().getY()), (int) (living.position().z + 0.5 * Direction.UP.getNormal().getZ()))), 20);
                for (int i2 = 0; i2 < 10; i2++) {
                    sculkSpreader.updateCursors(living.level(), living.blockPosition(), living.getRandom(), true);
                }
                living.skipDropExperience();
                living.level().setBlock(living.blockPosition(), Blocks.SCULK_CATALYST.defaultBlockState(), 3);
                if (living.level().getBlockState(living.blockPosition()).getValue(SculkCatalystBlock.PULSE)) {
                    living.level().setBlock(living.blockPosition(), living.level().getBlockState(living.blockPosition()).setValue(SculkCatalystBlock.PULSE, false), 3);
                }
                CriteriaTriggers.KILL_MOB_NEAR_SCULK_CATALYST.trigger((ServerPlayer) livingEntity, entity, entity.damageSources().playerAttack((Player) livingEntity));
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
