package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.overseer.phase.OverseerPhase;
import net.minecraft.core.GlobalPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Overseer extends Monster {
    public static final String INVULNERABLE_TICKS_TAG = "invulnerable_ticks";
    public static final String ORIGIN_POSITION_TAG = "origin_position";

    private final OverseerPhaseManager phaseManager;
    private final Set<Entity> crystals = new HashSet<>();

    private static final EntityDataAccessor<Integer> DATA_ID_INVULNERABLE = SynchedEntityData.defineId(Overseer.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Optional<GlobalPos>> DATA_ID_ORIGIN = SynchedEntityData.defineId(Overseer.class, EntityDataSerializers.OPTIONAL_GLOBAL_POS);
    private static final int DEFAULT_INVULNERABLE_TICKS = 220;
    private final ServerBossEvent bossEvent = (ServerBossEvent) new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);

    public Overseer(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        moveControl = new FlyingMoveControl(this, 20, true);
        phaseManager = new OverseerPhaseManager(this, OverseerPhase.CODEC);
        xpReward = 50;
        setNoGravity(true);
        setPersistenceRequired();
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation flyingPathNavigation = new FlyingPathNavigation(this, level);
        flyingPathNavigation.setCanOpenDoors(false);
        flyingPathNavigation.setCanFloat(true);
        flyingPathNavigation.setCanPassDoors(true);
        return flyingPathNavigation;
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 1000).add(Attributes.ATTACK_DAMAGE, 40).add(Attributes.ARMOR, 15).add(Attributes.ARMOR_TOUGHNESS, 7).add(Attributes.FOLLOW_RANGE, 100).add(Attributes.ATTACK_KNOCKBACK, 10.0).add(Attributes.KNOCKBACK_RESISTANCE, 10.0).build();
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new OverseerDoNothingGoal());
        goalSelector.addGoal(1, new OverseerTickPhaseGoal());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_ID_INVULNERABLE, DEFAULT_INVULNERABLE_TICKS);
        entityData.define(DATA_ID_ORIGIN, Optional.of(GlobalPos.of(level().dimension(), blockPosition())));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt(INVULNERABLE_TICKS_TAG, getInvulnerableTicks());
        Optional<GlobalPos> originPos = getOriginPos();
        originPos.flatMap(globalPos -> GlobalPos.CODEC.encodeStart(NbtOps.INSTANCE, globalPos).resultOrPartial(DeeperDarker.LOGGER::error)).ifPresent(tag -> compoundTag.put(ORIGIN_POSITION_TAG, tag));
        phaseManager.save(compoundTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        setInvulnerableTicks(compoundTag.getInt(INVULNERABLE_TICKS_TAG));
        if (compoundTag.contains(ORIGIN_POSITION_TAG, CompoundTag.TAG_COMPOUND)) {
            setOriginPos(GlobalPos.CODEC.parse(NbtOps.INSTANCE, compoundTag.get(ORIGIN_POSITION_TAG)).resultOrPartial(DeeperDarker.LOGGER::error));
        }
        if (hasCustomName()) {
            bossEvent.setName(getDisplayName());
        }
        phaseManager.loadFrom(compoundTag);
    }

    @Override
    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
        bossEvent.setName(getDisplayName());
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
    }

    @Override
    public void tick() {
        setNoGravity(true);
        if (getInvulnerableTicks() > 0) {
            setInvulnerableTicks(getInvulnerableTicks() - 1);
            heal(getMaxHealth());
        }
        if (!isValidOrigin(getOriginPos())) {
            discard();
            return;
        }
        super.tick();
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (getInvulnerableTicks() > 0) return false;
        return super.hurt(damageSource, f);
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    public int getInvulnerableTicks() {
        return this.entityData.get(DATA_ID_INVULNERABLE);
    }

    public void setInvulnerableTicks(int i) {
        this.entityData.set(DATA_ID_INVULNERABLE, i);
    }

    public Optional<GlobalPos> getOriginPos() {
        return entityData.get(DATA_ID_ORIGIN);
    }

    public void setOriginPos(Optional<GlobalPos> pos) {
        entityData.set(DATA_ID_ORIGIN, pos);
    }

    public boolean isValidOrigin(Optional<GlobalPos> pos) {
        return pos.isEmpty() || pos.get().dimension().equals(level().dimension());
    }

    public boolean addCrystal(OverseerCrystal crystal) {
        return crystals.add(crystal);
    }

    public boolean removeCrystal(OverseerCrystal crystal) {
        return crystals.remove(crystal);
    }

    public Set<Entity> getCrystals() {
        return crystals;
    }

    @Override
    public boolean isCurrentlyGlowing() {
        return true;
    }

    class OverseerDoNothingGoal
            extends Goal {
        public OverseerDoNothingGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return Overseer.this.getInvulnerableTicks() > 0;
        }
    }

    class OverseerTickPhaseGoal
            extends Goal {
        public OverseerTickPhaseGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public void tick() {
            Overseer.this.phaseManager.tick();
        }
    }

    @Override
    public void push(Entity entity) {
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public void knockback(double strength, double x, double z) {
    }
}
