package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.util.DDUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BloomingGolem extends AbstractGolemBoss {
    public final int TIMER_RESET_TIME = 50;
    private int moveTimer = TIMER_RESET_TIME;

    private Set<BlockPos> visitedPositions = new HashSet<>();

    public BloomingGolem(EntityType<? extends AbstractGolem> entityType, Level level) {
        super(entityType, level);
        xpReward = 50;
        noPhysics = true;
    }

    public BloomingGolem(Level level, double x, double y, double z) {
        this(DDEntities.BLOOMING_GOLEM, level);
        setPos(x, y, z);
        xo = x;
        yo = y;
        zo = z;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        moveTimer = compoundTag.getInt("move_timer");
        if (compoundTag.contains("visited_positions", CompoundTag.TAG_LIST)) {
            visitedPositions = BlockPos.CODEC.listOf().xmap(HashSet::new, ArrayList::new).parse(NbtOps.INSTANCE, compoundTag.get("visited_positions")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(null);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("move_timer", moveTimer);
        BlockPos.CODEC.listOf().<Set<BlockPos>>xmap(HashSet::new, ArrayList::new).encodeStart(NbtOps.INSTANCE, visitedPositions).resultOrPartial(DeeperDarker.LOGGER::error).ifPresent(tag -> compoundTag.put("visited_positions", tag));
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 800).add(Attributes.ATTACK_DAMAGE, 40).add(Attributes.ARMOR, 12).add(Attributes.ARMOR_TOUGHNESS, 4).add(Attributes.FOLLOW_RANGE, 100).add(Attributes.ATTACK_KNOCKBACK, 10.0).build();
    }

    @Override
    protected void golemServerAiStep() {
        visitedPositions.add(blockPosition());

        hurtPlayersInside();

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

                if (!BlockPos.betweenClosedStream(boundingBox.deflate(1.0E-7).move(vec3)).allMatch(pos -> {
                    BlockState state = level().getBlockState(pos);
                    return state.isAir() || state.canBeReplaced() || state.is(DDTags.Blocks.BLOOMING_GOLEM_CAN_WALK_THROUGH);
                })) continue;

                setPos(initialPos.getX() + 0.5 + vec3.x, initialPos.getY() + vec3.y, initialPos.getZ() + 0.5 + vec3.z);
                BlockPos.betweenClosedStream(boundingBox.deflate(1.0E-7).move(vec3)).forEach(pos -> {
                    BlockState state = level().getBlockState(pos);
                    if (state.canBeReplaced() || state.is(DDTags.Blocks.BLOOMING_GOLEM_CAN_DESTROY)) level().destroyBlock(pos, true);
                });
                found = true;
                break;
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

    @Override
    public void reset() {
        super.reset();
        moveTimer = TIMER_RESET_TIME;
        visitedPositions.clear();
    }

    @Override
    public BlockState getParticleState() {
        return DDBlocks.SCULK_GRIME_BRICKS.defaultBlockState();
    }

    public int getGolemMoveSpeed() {
        return (int) DDUtil.lerpLog(getHealth() / getMaxHealth(), MIN_SPEED, MAX_SPEED);
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (damageSource.getEntity() instanceof LivingEntity livingEntity && livingEntity.getMainHandItem().is(ItemTags.PICKAXES)) f *= 2.5f;
        return super.hurt(damageSource, f);
    }
}
