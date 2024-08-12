package com.kyanite.deeperdarker.content.enchantments;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.block.SculkSpreader;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("NullableProblems")
public record CatalyzeEnvironment(boolean bool) implements EnchantmentEntityEffect {
    public static final MapCodec<CatalyzeEnvironment> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(Codec.BOOL.fieldOf("bool").forGetter(CatalyzeEnvironment::bool)).apply(instance, CatalyzeEnvironment::new)
    );

    @Override
    public void apply(ServerLevel pLevel, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity pEntity, Vec3 pOrigin) {
        if(pEntity instanceof LivingEntity target) {
            if(target.isDeadOrDying()) {
                SculkSpreader spreader = SculkSpreader.createLevelSpreader();
                spreader.addCursors(new BlockPos((int) (target.position().x + 0.5 * Direction.UP.getNormal().getX()), (int) (target.position().y + 0.5 * Direction.UP.getNormal().getY()), (int) (target.position().z + 0.5 * Direction.UP.getNormal().getZ())), 20);
                for(int i = 0; i < (int) (10 * pEnchantmentLevel * 0.9); i++) {
                    spreader.updateCursors(target.level(), target.blockPosition(), target.getRandom(), true);
                }
                target.skipDropExperience();
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}