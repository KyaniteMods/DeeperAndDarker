package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.entities.goals.StraightPathGoal;
import com.kyanite.deeperdarker.mixin.MobRotationAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class OvercastVessel extends PathfinderMob implements Enemy {
    private final ServerBossEvent bossEvent = (ServerBossEvent) new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);
    private boolean asleep = true;
    private static final EntityDataAccessor<Vector3f> DATA_SPAWN_POSITION = SynchedEntityData.defineId(OvercastVessel.class, EntityDataSerializers.VECTOR3);

    public OvercastVessel(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.blocksBuilding = true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new StraightPathGoal(this, 1.0));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_SPAWN_POSITION, Vec3.ZERO.toVector3f());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        CompoundTag pos = new CompoundTag();
        pos.putFloat("x", this.getSpawnPosition().x);
        pos.putFloat("y", this.getSpawnPosition().y);
        pos.putFloat("z", this.getSpawnPosition().z);
        compoundTag.put("spawn_position", pos);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        CompoundTag pos = compoundTag.getCompound("spawn_position");
        this.setSpawnPosition(new Vector3f(pos.getFloat("x"), pos.getFloat("y"), pos.getFloat("z")));
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        this.setSpawnPosition(this.position().toVector3f());
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200).add(Attributes.ATTACK_DAMAGE, 22).add(Attributes.MOVEMENT_SPEED, 0.3f).add(Attributes.ARMOR, 4).add(Attributes.KNOCKBACK_RESISTANCE, 1).build();
    }

    @Override
    public void tick() {
        super.tick();
        this.asleep = false;
        this.bossEvent.setVisible(!this.asleep);
        if (this.asleep) this.setTarget(null);
        if (!this.isNoAi() && !this.asleep) {
            this.level().getEntities(EntityTypeTest.forClass(LivingEntity.class), this.getBoundingBox().inflate(0.1), (entity) -> entity.isAlive() && entity.getType() != this.getType())
                    .forEach((entity) -> {
                        if (this.doHurtTarget(entity)) {
                            entity.knockback(this.getBbWidth(), Mth.sin(this.getYRot() * ((float) Math.PI / 180)), -Mth.cos(this.getYRot() * ((float) Math.PI / 180)));
                        }
                    });
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void startSeenByPlayer(ServerPlayer pServerPlayer) {
        super.startSeenByPlayer(pServerPlayer);
        this.bossEvent.addPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        this.bossEvent.removePlayer(pServerPlayer);
    }

    @Override
    public void setCustomName(@Nullable Component pName) {
        super.setCustomName(pName);
        this.bossEvent.setName(this.getDisplayName());
    }

    @Override
    public void knockback(double d, double e, double f) {
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    public Vector3f getSpawnPosition() {
        return this.entityData.get(DATA_SPAWN_POSITION);
    }

    public void setSpawnPosition(Vector3f pos) {
        this.entityData.set(DATA_SPAWN_POSITION, pos);
    }

    @Override
    public void checkDespawn() {
    }

    @Override
    protected float getWaterSlowDown() {
        return 1.0f;
    }

    public void lookAt(Entity targetEntity, float pitchSpeed, float yawSpeed) {
        double heightDifference;
        double deltaX = targetEntity.getX() - this.getX();
        double deltaZ = targetEntity.getZ() - this.getZ();
        if (targetEntity instanceof LivingEntity livingTarget) {
            heightDifference = livingTarget.getEyeY() - this.getEyeY();
        } else {
            heightDifference = (targetEntity.getBoundingBox().minY + targetEntity.getBoundingBox().maxY) / 2.0 - this.getEyeY();
        }
        double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

        float yaw = (float)(Mth.atan2(deltaZ, deltaX) * 57.2957763671875) - 90.0f;
        float pitch = (float)(-(Mth.atan2(heightDifference, distance) * 57.2957763671875));

        this.setXRot(((MobRotationAccessor)this).deeperdarker$rotlerpAccessor(this.getXRot(), Math.round(pitch / 90.0f) * 90.0f, yawSpeed));
        this.setYRot(((MobRotationAccessor)this).deeperdarker$rotlerpAccessor(this.getYRot(), Math.round(yaw / 90.0f) * 90.0f, pitchSpeed));
    }
}