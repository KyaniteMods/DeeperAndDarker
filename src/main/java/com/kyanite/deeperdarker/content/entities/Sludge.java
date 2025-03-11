package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("NullableProblems")
public class Sludge extends Slime {
    public Sludge(EntityType<? extends Slime> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16).add(Attributes.ATTACK_DAMAGE, 4).add(Attributes.MOVEMENT_SPEED, 0.6).build();
    }

    @Override
    protected void dealDamage(LivingEntity livingEntity) {
        if (this.isAlive() && this.isWithinMeleeAttackRange(livingEntity) && this.hasLineOfSight(livingEntity)) {
            DamageSource source = this.damageSources().mobAttack(this);
            if (livingEntity.hurt(source, this.getAttackDamage())) {
                this.playSound(DDSounds.SLUDGE_ATTACK.get(), 1f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1f);
                if (this.level() instanceof ServerLevel level) {
                    EnchantmentHelper.doPostAttackEffects(level, livingEntity, source);
                }
            }
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.isTiny() ? DDSounds.SLUDGE_DEATH_SMALL.get() : DDSounds.SLUDGE_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.isTiny() ? DDSounds.SLUDGE_HURT_SMALL.get() : DDSounds.SLUDGE_HURT.get();
    }

    @Override
    protected SoundEvent getJumpSound() {
        return this.isTiny() ? DDSounds.SLUDGE_JUMP_SMALL.get() : DDSounds.SLUDGE_JUMP.get();
    }

    @Override
    protected SoundEvent getSquishSound() {
        return this.isTiny() ? DDSounds.SLUDGE_SQUISH_SMALL.get() : DDSounds.SLUDGE_SQUISH.get();
    }

    @Override
    protected @NotNull ParticleOptions getParticleType() {
        return new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(DDBlocks.BLOOMING_MOSS_BLOCK));
    }
}
