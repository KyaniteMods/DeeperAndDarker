package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Sludge extends Slime {
    public Sludge(EntityType<? extends Slime> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16).add(Attributes.ATTACK_DAMAGE, 4).add(Attributes.MOVEMENT_SPEED, 0.6).build();
    }

    @Override
    protected @NotNull ParticleOptions getParticleType() {
        return new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(DDBlocks.BLOOMING_MOSS_BLOCK));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        if (this.isTiny()) {
            return DDSounds.SLUDGE_HURT_SMALL;
        }
        return DDSounds.SLUDGE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        if (this.isTiny()) {
            return DDSounds.SLUDGE_DEATH_SMALL;
        }
        return DDSounds.SLUDGE_DEATH;
    }

    protected SoundEvent getSquishSound() {
        if (this.isTiny()) {
            return DDSounds.SLUDGE_SQUISH_SMALL;
        }
        return DDSounds.SLUDGE_SQUISH;
    }

    @Override
    protected SoundEvent getJumpSound() {
        if (this.isTiny()) {
            return DDSounds.SLUDGE_JUMP_SMALL;
        }
        return DDSounds.SLUDGE_JUMP;
    }
}
