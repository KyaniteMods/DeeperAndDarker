package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SculkJaw extends Block {
    public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");
    public DamageSource damageSource = new DamageSource("jaw");

    public SculkJaw(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(ACTIVATED, false));
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(!pState.is(DDBlocks.SCULK_JAW.get())) return;
        if(pState.getValue(ACTIVATED) == true) return;

        if(pEntity instanceof Player plr) {
            if(plr.isCreative() || plr.isSpectator() || plr.isCrouching()) return;
        }

        if(pEntity instanceof LivingEntity mob)
        {
            mob.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80));
            mob.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 1));
        }

        pEntity.hurt(damageSource, 4); // they take damage even if they dont fall in
        pEntity.setDeltaMovement(Vec3.ZERO);
        pLevel.setBlock(pPos, DDBlocks.SCULK_JAW.get().defaultBlockState().setValue(ACTIVATED, true), 3);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if(!pState.is(DDBlocks.SCULK_JAW.get())) return;

        pEntity.hurt(damageSource, 3);
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        if(!isBlockBeside(level, this, pos)) return true;
        return super.isValidSpawn(state, level, pos, type, entityType);
    }

    public boolean isBlockBeside(BlockGetter level, Block targetBlock, BlockPos origin) {
        return level.getBlockState(origin.north()).is(targetBlock) || level.getBlockState(origin.east()).is(targetBlock) || level.getBlockState(origin.south()).is(targetBlock) || level.getBlockState(origin.west()).is(targetBlock);
    }

    @Override
    public void randomTick(BlockState p_222954_, ServerLevel p_222955_, BlockPos p_222956_, RandomSource p_222957_) {
        if(!p_222954_.is(DDBlocks.SCULK_JAW.get())) return;
        if(p_222954_.getValue(ACTIVATED) == false) return;

        if(p_222957_.nextInt(0, 30) == 0) {
            p_222955_.setBlock(p_222956_, p_222954_.setValue(ACTIVATED, false), 3);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if(!pState.is(DDBlocks.SCULK_JAW.get())) return super.getCollisionShape(pState, pLevel, pPos, pContext);

        if(pState.getValue(ACTIVATED) == true)
            return Block.box(0, 0, 0, 0, 0, 0);

        return super.getCollisionShape(pState, pLevel, pPos, pContext);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(ACTIVATED);
    }
}
