package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.config.DDConfig;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.ticks.TickPriority;

public class SculkJawBlock extends Block {
    public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");
    public DamageSource damageSource = new DamageSource("jaw");

    public SculkJawBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(ACTIVATED, false));
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pState.is(DDBlocks.SCULK_JAW.get())) return;
        if (pState.getValue(ACTIVATED)) return;

        if (pEntity instanceof Player plr) if (plr.isCreative() || plr.isSpectator() || plr.isCrouching()) return;

        pLevel.playSound(null, pPos, DDSounds.SCULK_JAW_CLOSE.get(), SoundSource.BLOCKS, 3.0f, 1f);
        pEntity.hurt(damageSource, 3);
        pLevel.setBlock(pPos, DDBlocks.SCULK_JAW.get().defaultBlockState().setValue(ACTIVATED, true), 3);
        pLevel.scheduleTick(pPos, DDBlocks.SCULK_JAW.get(), 35, TickPriority.EXTREMELY_HIGH);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pState.is(DDBlocks.SCULK_JAW.get())) return;

        if (pEntity instanceof ItemEntity itemEntity && DDConfig.SCULK_JAW_EATS_ITEMS.get()) {
            itemEntity.remove(Entity.RemovalReason.KILLED);
            return;
        }

        if (pEntity instanceof Player plr) {
            plr.giveExperiencePoints(-1);
        }

        if (pEntity instanceof LivingEntity livingEntity) {
            if (livingEntity.getMobType() == DDTypes.SCULK) return;
            else pEntity.hurt(damageSource, 3);
        }
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (blockState.getValue(SculkJawBlock.ACTIVATED)) {
            serverLevel.setBlock(blockPos, blockState.setValue(ACTIVATED, false), 3);
            serverLevel.playSound(null, blockPos, DDSounds.SCULK_JAW_RETRACT.get(), SoundSource.BLOCKS, 3.5f, 1f);
        }
    }


    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext
            pContext) {
        if (!pState.is(DDBlocks.SCULK_JAW.get())) return super.getCollisionShape(pState, pLevel, pPos, pContext);

        if (pState.getValue(ACTIVATED))
            return Block.box(0, 0, 0, 0, 0, 0);

        return super.getCollisionShape(pState, pLevel, pPos, pContext);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(ACTIVATED);
    }
}
