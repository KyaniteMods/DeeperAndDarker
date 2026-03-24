package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.scores.Team;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public abstract class AbstractGolemBoss extends AbstractGolem implements Enemy {
    private final ServerBossEvent bossEvent = (ServerBossEvent) new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);
    private GlobalPos homePos = null;

    public final short COOLDOWN_TIME = 20;
    protected short cooldown = 0;

    public final float MIN_SPEED = 1.0f;
    public final float MAX_SPEED = 5.0f;

    protected static final EntityDataAccessor<Boolean> DATA_SLEEPING_ID = SynchedEntityData.defineId(AbstractGolemBoss.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Boolean> DATA_SNAP_TO_BLOCKS_ID = SynchedEntityData.defineId(AbstractGolemBoss.class, EntityDataSerializers.BOOLEAN);

    public AbstractGolemBoss(EntityType<? extends AbstractGolem> entityType, Level level) {
        super(entityType, level);
        setGolemSleeping(true);
        blocksBuilding = true;
        setNoGravity(true);
    }

    @Override
    protected void registerGoals() {
        targetSelector.addGoal(1, new GolemBossHurtByTargetGoal(this));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.hasUUID("target") && level() instanceof ServerLevel serverLevel) {
            Entity entity = serverLevel.getEntity(compoundTag.getUUID("target"));
            if (entity instanceof LivingEntity livingEntity) {
                setTarget(livingEntity);
            }
        }
        if (compoundTag.contains("home_position", CompoundTag.TAG_COMPOUND)) {
            homePos = GlobalPos.CODEC.parse(NbtOps.INSTANCE, compoundTag.get("home_position")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(null);
        }
        setGolemSleeping(compoundTag.getBoolean("is_golem_sleeping"));
        setSnapToBlocks(compoundTag.getBoolean("snap_to_blocks"));
        cooldown = compoundTag.getShort("cooldown");
        if (hasCustomName()) {
            bossEvent.setName(getDisplayName());
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        if (homePos != null) {
            GlobalPos.CODEC.encodeStart(NbtOps.INSTANCE, homePos).resultOrPartial(DeeperDarker.LOGGER::error).ifPresent(tag -> compoundTag.put("home_position", tag));
        }
        if (getTarget() != null) {
            compoundTag.putUUID("target", getTarget().getUUID());
        }
        compoundTag.putBoolean("is_golem_sleeping", isGolemSleeping());
        compoundTag.putBoolean("snap_to_blocks", snapToBlocks());
        compoundTag.putShort("cooldown", cooldown);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_SLEEPING_ID, true);
        entityData.define(DATA_SNAP_TO_BLOCKS_ID, true);
    }

    @Override
    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
        bossEvent.setName(getDisplayName());
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    public void startSeenByPlayer(ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        bossEvent.addPlayer(serverPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        bossEvent.removePlayer(serverPlayer);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        bossEvent.setProgress(getHealth() / getMaxHealth());

        if (isGolemSleeping() || isDeadOrDying() || level().isClientSide()) return;

        if (getTarget() != null) {
            lookAt(getTarget(), 10.0f, 10.0f);
        }
        golemServerAiStep();
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    @Override
    public void push(Entity entity) {
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public void knockback(double strength, double x, double z) {
    }

    public boolean isGolemSleeping() {
        return entityData.get(DATA_SLEEPING_ID);
    }

    public void setGolemSleeping(boolean sleeping) {
        entityData.set(DATA_SLEEPING_ID, sleeping);
        bossEvent.setVisible(!sleeping);
        if (sleeping) {
            heal(getMaxHealth());
            setTarget(null);
        }
    }

    public GlobalPos getHomePos() {
        return homePos;
    }

    public void setHomePos(GlobalPos homePos) {
        this.homePos = homePos;
    }

    @Override
    public void tick() {
        super.tick();
        if (snapToBlocks()) {
            setPos(blockPosition().getX() + 0.5, blockPosition().getY(), blockPosition().getZ() + 0.5);
        }

        if (isOnCooldown()) {
            cooldown--;
            return;
        }

        if (homePos != null && (homePos.dimension() != level().dimension() || distanceToSqr(homePos.pos().getCenter()) > 4096)) {
            reset();
        }
    }

    protected abstract void golemServerAiStep();

    public void reset() {
        if (homePos != null && level().dimension() == homePos.dimension()) {
            if (level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, getParticleState()), getX(), getY(0.5), getZ(), 250, getBbWidth() / 4.0f, getBbHeight() / 4.0f, getBbWidth() / 4.0f, 0.05);
            }
            moveTo(homePos.pos().getX() + 0.5, homePos.pos().getY(), homePos.pos().getZ() + 0.5);
        }
        setCooldown(COOLDOWN_TIME);
        setGolemSleeping(true);
    }

    public abstract BlockState getParticleState();

    @Override
    public boolean fireImmune() {
        return isGolemSleeping() || isOnCooldown() || super.fireImmune();
    }

    @Override
    public boolean isInvulnerable() {
        return isGolemSleeping() || isOnCooldown() || super.isInvulnerable();
    }

    @Override
    public boolean shouldDropExperience() {
        return true;
    }

    public short getCooldown() {
        return cooldown;
    }

    public void setCooldown(short cooldown) {
        this.cooldown = cooldown;
    }

    public boolean snapToBlocks() {
        return entityData.get(DATA_SNAP_TO_BLOCKS_ID);
    }

    public void setSnapToBlocks(boolean snapToBlocks) {
        entityData.set(DATA_SNAP_TO_BLOCKS_ID, snapToBlocks);
    }

    public boolean isOnCooldown() {
        return getCooldown() > 0;
    }

    public static class GolemBossHurtByTargetGoal extends HurtByTargetGoal {
        public GolemBossHurtByTargetGoal(AbstractGolemBoss golem, Class<?>... classs) {
            super(golem, classs);
        }

        @Override
        public boolean canUse() {
            if (((AbstractGolemBoss) mob).isOnCooldown()) return false;

            if (((AbstractGolemBoss) mob).isGolemSleeping()) {
                return super.canUse();
            }
            List<Player> players = mob.level().getNearbyPlayers(TargetingConditions.forCombat().ignoreInvisibilityTesting(), mob, mob.getBoundingBox().inflate(30.0, 30.0, 30.0));
            if (players.isEmpty()) return false;
            for (Player player : players) {
                if (isEntityValidTarget(player)) {
                    mob.setLastHurtByMob(player);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity livingEntity = mob.getTarget();
            if (livingEntity == null) {
                livingEntity = targetMob;
            }
            if (!isEntityValidTarget(livingEntity)) {
                List<Player> players = mob.level().getNearbyPlayers(TargetingConditions.forCombat().ignoreInvisibilityTesting(), mob, mob.getBoundingBox().inflate(30.0, 30.0, 30.0));
                if (players.isEmpty()) return false;
                for (Player player : players) {
                    if (isEntityValidTarget(player)) {
                        livingEntity = player;
                        break;
                    }
                }
            }

            return livingEntity != null && !((AbstractGolemBoss) mob).isOnCooldown() && !((AbstractGolemBoss) mob).isGolemSleeping();
        }

        private boolean isEntityValidTarget(LivingEntity entity) {
            if (entity == null) {
                return false;
            }

            if (!mob.canAttack(entity)) {
                return false;
            }
            Team team = mob.getTeam();
            Team team2 = entity.getTeam();
            if (team != null && team2 == team) {
                return false;
            }
            double d = this.getFollowDistance();
            if (mob.distanceToSqr(entity) > d * d) {
                return false;
            }
            mob.setTarget(entity);
            return true;
        }

        @Override
        public void start() {
            super.start();
            ((AbstractGolemBoss) mob).setGolemSleeping(false);
        }

        @Override
        public void stop() {
            super.stop();
            ((AbstractGolemBoss) mob).reset();
            mob.setLastHurtByMob(null);
        }
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public boolean isAffectedByPotions() {
        return false;
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        int i;
        float f = (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
        float g = (float)this.getAttributeValue(Attributes.ATTACK_KNOCKBACK);
        if (entity instanceof LivingEntity) {
            f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(), ((LivingEntity)entity).getMobType());
            g += (float)EnchantmentHelper.getKnockbackBonus(this);
        }
        if ((i = EnchantmentHelper.getFireAspect(this)) > 0) {
            entity.setSecondsOnFire(i * 4);
        }
        boolean hurt = entity.hurt(this.damageSources().mobAttack(this), f);
        if (hurt) {
            if (g > 0.0f && entity instanceof LivingEntity livingEntity) {
                livingEntity.knockback(g * 0.5f, Mth.sin(livingEntity.getYRot() * (Mth.PI / 180.0f) + Mth.PI), -Mth.cos(this.getYRot() * (Mth.PI / 180.0f) + Mth.PI));
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 1.0, 0.6));
            }
            this.doEnchantDamageEffects(this, entity);
            this.setLastHurtMob(entity);
        }
        return hurt;
    }

    public void hurtPlayersInside() {
        level().getEntities(this, getBoundingBox().deflate(0.4), entity -> entity instanceof Player).forEach(this::doHurtTarget);
    }
}
