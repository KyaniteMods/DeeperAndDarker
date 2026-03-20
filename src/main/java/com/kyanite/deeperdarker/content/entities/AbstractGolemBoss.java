package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
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
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.Team;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public abstract class AbstractGolemBoss extends AbstractGolem implements Enemy {
    private final ServerBossEvent bossEvent = (ServerBossEvent) new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);
    private GlobalPos homePos = null;

    public final short COOLDOWN_TIME = 20;
    protected short cooldown = 0;

    public final float MIN_SPEED = 1.0f;
    public final float MAX_SPEED = 5.0f;

    protected static final EntityDataAccessor<Boolean> DATA_SLEEPING_ID = SynchedEntityData.defineId(AbstractGolemBoss.class, EntityDataSerializers.BOOLEAN);

    public AbstractGolemBoss(EntityType<? extends AbstractGolem> entityType, Level level) {
        super(entityType, level);
        setGolemSleeping(true);
        blocksBuilding = true;
        noPhysics = true;
    }

    @Override
    protected void registerGoals() {
        targetSelector.addGoal(1, new GolemBossHurtByTargetGoal(this));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("home_position", CompoundTag.TAG_COMPOUND)) {
            homePos = GlobalPos.CODEC.parse(NbtOps.INSTANCE, compoundTag.get("home_position")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(null);
        }
        setGolemSleeping(compoundTag.getBoolean("is_golem_sleeping"));
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
        compoundTag.putBoolean("is_golem_sleeping", isGolemSleeping());
        compoundTag.putShort("cooldown", cooldown);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_SLEEPING_ID, true);
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

        golemServerAiStep();
    }

    @Override
    public void aiStep() {
        super.aiStep();
        Vec3 vec3 = getDeltaMovement();
        if (!onGround() && vec3.y < 0.0) {
            setDeltaMovement(vec3.multiply(1.0, 0.0, 1.0));
        }
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
        setPos(blockPosition().getX() + 0.5, blockPosition().getY(), blockPosition().getZ() + 0.5);

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
                serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, DDBlocks.SCULK_GRIME_BRICKS.defaultBlockState()), getX(), getY(0.5), getZ(), 250, getBbWidth() / 4.0f, getBbHeight() / 4.0f, getBbWidth() / 4.0f, 0.05);
            }
            moveTo(homePos.pos().getX() + 0.5, homePos.pos().getY(), homePos.pos().getZ() + 0.5);
        }
        setCooldown(COOLDOWN_TIME);
        setGolemSleeping(true);
    }

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

    public boolean isOnCooldown() {
        return getCooldown() > 0;
    }

    public static class GolemBossHurtByTargetGoal extends HurtByTargetGoal {
        public GolemBossHurtByTargetGoal(AbstractGolemBoss golem, Class<?>... classs) {
            super(golem, classs);
        }

        @Override
        public boolean canUse() {
            return super.canUse() && !((AbstractGolemBoss) mob).isOnCooldown();
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity livingEntity = mob.getTarget();
            if (livingEntity == null) {
                livingEntity = targetMob;
            }
            if (livingEntity == null) {
                return false;
            }
            if (!mob.canAttack(livingEntity)) {
                return false;
            }
            Team team = mob.getTeam();
            Team team2 = livingEntity.getTeam();
            if (team != null && team2 == team) {
                return false;
            }
            double d = this.getFollowDistance();
            if (mob.distanceToSqr(livingEntity) > d * d) {
                return false;
            }
            mob.setTarget(livingEntity);
            return !((AbstractGolemBoss) mob).isOnCooldown() && !((AbstractGolemBoss) mob).isGolemSleeping();
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
}
