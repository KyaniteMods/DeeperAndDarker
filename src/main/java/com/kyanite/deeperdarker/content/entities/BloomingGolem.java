package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.util.DDUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BloomingGolem extends AbstractGolem implements Enemy {
    private final ServerBossEvent bossEvent = (ServerBossEvent) new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);
    private GlobalPos homePos = null;
    private Set<BlockPos> visitedPositions = new HashSet<>();

    private final short COOLDOWN_TIME = 10;
    private short cooldown = 0;

    private final int TIMER_RESET_TIME = 50;
    private int moveTimer = TIMER_RESET_TIME;

    private final float MIN_SPEED = 1.0f;
    private final float MAX_SPEED = 5.0f;

    private static final EntityDataAccessor<Boolean> DATA_SLEEPING_ID = SynchedEntityData.defineId(BloomingGolem.class, EntityDataSerializers.BOOLEAN);

    public BloomingGolem(EntityType<? extends AbstractGolem> entityType, Level level) {
        super(entityType, level);
        setBloomingGolemSleeping(true);
        blocksBuilding = true;
        noPhysics = true;
        xpReward = 50;
    }

    public BloomingGolem(Level level, double x, double y, double z) {
        this(DDEntities.BLOOMING_GOLEM, level);
        setPos(x, y, z);
        xo = x;
        yo = y;
        zo = z;
    }

    @Override
    protected void registerGoals() {
        targetSelector.addGoal(1, new BloomingGolemHurtByTargetGoal(this));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("home_position", CompoundTag.TAG_COMPOUND)) {
            homePos = GlobalPos.CODEC.parse(NbtOps.INSTANCE, compoundTag.get("home_position")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(null);
        }
        setBloomingGolemSleeping(compoundTag.getBoolean("is_blooming_golem_sleeping"));
        moveTimer = compoundTag.getInt("move_timer");
        cooldown = compoundTag.getShort("cooldown");
        if (compoundTag.contains("visited_positions", CompoundTag.TAG_LIST)) {
            visitedPositions = BlockPos.CODEC.listOf().xmap(HashSet::new, ArrayList::new).parse(NbtOps.INSTANCE, compoundTag.get("visited_positions")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(null);
        }
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
        compoundTag.putBoolean("is_blooming_golem_sleeping", isBloomingGolemSleeping());
        compoundTag.putInt("move_timer", moveTimer);
        compoundTag.putShort("cooldown", cooldown);
        BlockPos.CODEC.listOf().<Set<BlockPos>>xmap(HashSet::new, ArrayList::new).encodeStart(NbtOps.INSTANCE, visitedPositions).resultOrPartial(DeeperDarker.LOGGER::error).ifPresent(tag -> compoundTag.put("visited_positions", tag));
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

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 500).add(Attributes.ATTACK_DAMAGE, 22).add(Attributes.MOVEMENT_SPEED, 0.3f).add(Attributes.ARMOR, 4).add(Attributes.KNOCKBACK_RESISTANCE, 1).build();
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        bossEvent.setProgress(getHealth() / getMaxHealth());
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

    public boolean isBloomingGolemSleeping() {
        return entityData.get(DATA_SLEEPING_ID);
    }

    public void setBloomingGolemSleeping(boolean sleeping) {
        entityData.set(DATA_SLEEPING_ID, sleeping);
        bossEvent.setVisible(!sleeping);
        if (sleeping) heal(getMaxHealth());
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
        visitedPositions.add(blockPosition());
        setPos(blockPosition().getX() + 0.5, blockPosition().getY(), blockPosition().getZ() + 0.5);

        if (cooldown > 0) {
            cooldown--;
            heal(getMaxHealth());
            setTarget(null);
            setBloomingGolemSleeping(true);
            return;
        }

        if (homePos != null && (homePos.dimension() != level().dimension() || distanceToSqr(homePos.pos().getCenter()) > 4096)) {
            reset();
            return;
        }

        if (isBloomingGolemSleeping() || isDeadOrDying() || level().isClientSide()) return;
        moveTimer -= getGolemMoveSpeed();
        if (moveTimer <= 0) {
            moveTimer = TIMER_RESET_TIME;
            BlockPos initialPos = blockPosition();
            AABB boundingBox = getBoundingBox();
            boolean found = false;
            List<Direction> list = new ArrayList<>(Direction.Plane.HORIZONTAL.shuffledCopy(getRandom()));
            list.addAll(Direction.Plane.VERTICAL.stream().toList());
            for (Direction direction : list) {
                BlockPos position = initialPos.offset(Mth.floor(direction.getStepX() * getBbWidth()), Mth.floor(direction.getStepY() * getBbHeight()), Mth.floor(direction.getStepZ() * getBbWidth()));
                if (visitedPositions.contains(position)) continue;

                Vec3 vec3 = new Vec3(direction.getStepX() * getBbWidth(), direction.getStepY() * getBbHeight(), direction.getStepZ() * getBbWidth());

                if (BlockPos.betweenClosedStream(boundingBox.deflate(1.0E-7).move(vec3)).allMatch(pos -> {
                    BlockState state = level().getBlockState(pos);
                    return state.isAir() || state.canBeReplaced() || state.is(DDTags.Blocks.BLOOMING_GOLEM_CAN_WALK_THROUGH);
                })) {
                    setPos(initialPos.getX() + 0.5 + vec3.x, initialPos.getY() + vec3.y, initialPos.getZ() + 0.5 + vec3.z);
                    found = true;
                    break;
                }
            }
            if (!found) {
                reset();
                return;
            }
            BlockPos.betweenClosedStream(boundingBox.deflate(1.0E-7)).forEach(pos -> {
                BlockState state = level().getBlockState(pos);
                if (state.isAir() || state.canBeReplaced()) {
                    level().setBlock(pos, DDBlocks.TOXIC_AIR.defaultBlockState(), Block.UPDATE_CLIENTS);
                }
            });
        }
    }

    public void reset() {
        if (homePos != null && level().dimension() == homePos.dimension()) {
            if (level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, DDBlocks.SCULK_GRIME_BRICKS.defaultBlockState()), getX(), getY(0.5), getZ(), 250, getBbWidth() / 4.0f, getBbHeight() / 4.0f, getBbWidth() / 4.0f, 0.05);
            }
            moveTo(homePos.pos().getX() + 0.5, homePos.pos().getY(), homePos.pos().getZ() + 0.5);
        }
        heal(getMaxHealth());
        cooldown = COOLDOWN_TIME;
        moveTimer = TIMER_RESET_TIME;
        setBloomingGolemSleeping(true);
        setTarget(null);
        visitedPositions.clear();
    }

    public int getGolemMoveSpeed() {
        return (int) DDUtil.lerpLog(getHealth() / getMaxHealth(), MIN_SPEED, MAX_SPEED);
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (damageSource.getEntity() instanceof LivingEntity livingEntity && livingEntity.getMainHandItem().is(ItemTags.PICKAXES)) f *= 2.5f;
        return super.hurt(damageSource, f);
    }

    public static class BloomingGolemHurtByTargetGoal extends HurtByTargetGoal {
        public BloomingGolemHurtByTargetGoal(BloomingGolem golem, Class<?>... classs) {
            super(golem, classs);
        }

        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse() && ((BloomingGolem) mob).cooldown == 0;
        }

        @Override
        public void start() {
            super.start();
            ((BloomingGolem) mob).setBloomingGolemSleeping(false);
        }

        @Override
        public void stop() {
            super.stop();
            ((BloomingGolem) mob).reset();
        }
    }

    @Override
    public boolean shouldDropExperience() {
        return true;
    }
}
