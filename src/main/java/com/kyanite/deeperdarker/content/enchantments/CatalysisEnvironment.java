package com.kyanite.deeperdarker.content.enchantments;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Optionull;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.block.SculkSpreader;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("NullableProblems")
public record CatalysisEnvironment(boolean dropXp) implements EnchantmentEntityEffect {
    public static final MapCodec<CatalysisEnvironment> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(Codec.BOOL.fieldOf("drop_xp").forGetter(CatalysisEnvironment::dropXp)).apply(instance, CatalysisEnvironment::new)
    );

    @Override
    public void apply(ServerLevel pLevel, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity pEntity, Vec3 pOrigin) {
        if (pEntity instanceof LivingEntity target) {
            if (target.isDeadOrDying() && !target.wasExperienceConsumed()) {
                SculkSpreader spreader = SculkSpreader.createLevelSpreader();
                Entity attacker = Optionull.map(target.getLastDamageSource(), DamageSource::getEntity);
                if (!(attacker instanceof ServerPlayer serverPlayer)) return;

                BlockPos pos = new BlockPos((int) pOrigin.x, (int) pOrigin.y, (int) pOrigin.z);
                for (int i = 0; i < 3 * pEnchantmentLevel; i++) {
                    spreader.addCursors(pos, target.getExperienceReward(pLevel, attacker));
                }
                for (int i = 0; i < 8 * pEnchantmentLevel; i++) {
                    spreader.updateCursors(pLevel, pos, pLevel.getRandom(), true);
                }

                if (!dropXp) target.skipDropExperience();
                CriteriaTriggers.KILL_MOB_NEAR_SCULK_CATALYST.trigger(serverPlayer, target, target.damageSources().playerAttack(serverPlayer));
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
