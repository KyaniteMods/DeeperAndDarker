package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDDamageTypes;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.entities.overseer.OverseerCrystalProjectile;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class SculkMillipede extends Floater implements RangedAttackMob {
    private static final UUID HEAD_ATTACK_DAMAGE_MODIFIER_UUID = UUID.fromString("3b3c6298-6096-463d-8fbb-304dfe9f075a");
    private static final UUID HEAD_ARMOR_MODIFIER_UUID = UUID.fromString("d37aa9cd-3d8d-4be3-9dd8-8ed5df4e1f3f");
    public static final AttributeModifier HEAD_ATTACK_DAMAGE_MODIFIER = new AttributeModifier(HEAD_ATTACK_DAMAGE_MODIFIER_UUID, "Sculk millipede head attack damage bonus", 1.15, AttributeModifier.Operation.MULTIPLY_TOTAL);
    public static final AttributeModifier HEAD_ARMOR_MODIFIER = new AttributeModifier(HEAD_ARMOR_MODIFIER_UUID, "Sculk millipede head armor bonus", 1.25, AttributeModifier.Operation.MULTIPLY_TOTAL);
    public static final TargetingConditions TARGETING_CONDITIONS = TargetingConditions.forNonCombat().range(64.0).ignoreLineOfSight().ignoreInvisibilityTesting();
    private ServerBossEvent bossEvent = (ServerBossEvent) new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);

    public SculkMillipede(EntityType<? extends Vex> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier createSculkMillipedeAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FLYING_SPEED, 1.2).add(Attributes.MAX_HEALTH, 56.0).add(Attributes.ATTACK_DAMAGE, 36.0).add(Attributes.FOLLOW_RANGE, 128.0).build();
    }

    public static SculkMillipede generateBoss(int size, double x, double y, double z, ServerLevel level) {
        return generateWorm(DDEntities.SCULK_MILLIPEDE, size, x, y, z, level);
    }

    @Override
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        bossEvent.setName(getDisplayName());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        bossEvent.setProgress(getTotalHealth() / getTotalMaxHealth());
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        bossEvent.removePlayer(serverPlayer);
    }

    protected void updateBossEvent() {
        if (level() instanceof ServerLevel serverLevel) {
            Set<ServerPlayer> set = new HashSet<>(bossEvent.getPlayers());
            List<ServerPlayer> list = serverLevel.players();

            if (getWormHead() == this) {
                for (ServerPlayer player : list) {
                    if (!set.contains(player)) {
                        bossEvent.addPlayer(player);
                    }
                }

                for (ServerPlayer player : set) {
                    if (!list.contains(player)) {
                        bossEvent.removePlayer(player);
                    }
                }
            } else {
                bossEvent.removeAllPlayers();
            }
        }
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource damageSource, int i, boolean bl) {
        super.dropCustomDeathLoot(damageSource, i, bl);
        if (isLastRemaining()) {
            spawnAtLocation(DDItems.VIRTUE_SOUL);
        }
    }

    @Override
    public void remove(RemovalReason removalReason, Floater oldHead, @Nullable Floater newHead) {
        super.remove(removalReason, oldHead, newHead);

        if (level().isClientSide()) return;

        if (oldHead == this && newHead instanceof SculkMillipede sculkMillipede && oldHead != newHead) {
            sculkMillipede.bossEvent = bossEvent;
        } else {
            bossEvent.setVisible(false);
            bossEvent.removeAllPlayers();
        }
    }

    @Override
    public void tick() {
        super.tick();
        updateBossEvent();
        level().getEntities(this, getBoundingBox().deflate(0.2), entity -> entity instanceof Player).forEach(this::doHurtTarget);
        if (getWormHead() == this && level().getNearbyPlayers(TARGETING_CONDITIONS, this, getBoundingBox().inflate(64.0, 64.0, 64.0)).isEmpty()) {
            executeOnEveryConnectedWormPart(Entity::discard);
        }

        if (isBody() && level().getDifficulty() == Difficulty.HARD) {
            Player nearestPlayer = level().getNearestPlayer(this, 128.0f);
            if (nearestPlayer != null && getRandom().nextInt(200 * (getWormParts().size() + 1)) == 0) {
                performRangedAttack(nearestPlayer, 1.0f);
            }
        }
    }

    @Override
    protected @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return SoundEvents.HOSTILE_HURT;
    }

    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.HOSTILE_DEATH;
    }

    @Override
    public int chargeDelay() {
        return 1;
    }

    @Override
    public double chargeMinimumDistance() {
        return random.nextInt(10) == 0 ? 4.0 - level().getDifficulty().getId() : 8.0 - level().getDifficulty().getId();
    }

    @Override
    public OptionalInt getMaxAge() {
        return OptionalInt.empty();
    }

    @Override
    public void updateIsBody() {
        super.updateIsBody();
        if (!isBody()) {
            AttributeInstance attackDamage = getAttribute(Attributes.ATTACK_DAMAGE);
            AttributeInstance armor = getAttribute(Attributes.ARMOR);
            if (!attackDamage.hasModifier(HEAD_ATTACK_DAMAGE_MODIFIER)) {
                attackDamage.addTransientModifier(HEAD_ATTACK_DAMAGE_MODIFIER);
            }
            if (!armor.hasModifier(HEAD_ARMOR_MODIFIER)) {
                armor.addTransientModifier(HEAD_ARMOR_MODIFIER);
            }
        } else {
            getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(HEAD_ATTACK_DAMAGE_MODIFIER_UUID);
            getAttribute(Attributes.ARMOR).removeModifier(HEAD_ARMOR_MODIFIER_UUID);
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return super.isInvulnerableTo(damageSource) || damageSource.is(DDDamageTypes.OVERSEER_CRYSTAL) || damageSource.is(DamageTypes.EXPLOSION);
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float f) {
        performRangedAttackAround(livingEntity, 12 - this.level().getDifficulty().getId() * 4);
    }

    public void performRangedAttackAround(LivingEntity entity, int precision) {
        double x = getX();
        double y = getY() + getEyeHeight();
        double z = getZ();

        double powerX = entity.getX() + getRandom().nextIntBetweenInclusive(-precision, precision) - x;
        double powerY = entity.getY() + getRandom().nextIntBetweenInclusive(-precision, precision) + entity.getEyeHeight() * 0.5 - y;
        double powerZ = entity.getZ() + getRandom().nextIntBetweenInclusive(-precision, precision) - z;

        performRangedAttack(powerX, powerY, powerZ);
    }

    public void performRangedAttack(double powerX, double powerY, double powerZ) {
        OverseerCrystalProjectile crystal = new OverseerCrystalProjectile(level(), this, powerX, powerY, powerZ);
        crystal.setOwner(this);
        crystal.setPosRaw(getX(), getY() + getEyeHeight(), getZ());
        crystal.setDamage(20.0f);
        level().addFreshEntity(crystal);
    }
}
