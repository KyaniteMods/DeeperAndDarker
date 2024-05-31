package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.util.DDDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation, NullableProblems")
public class SculkJawBlock extends Block {
    public static final BooleanProperty BITING = BooleanProperty.create("biting");
    public static final BooleanProperty CAN_BITE = BooleanProperty.create("can_bite");

    public SculkJawBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITING, false).setValue(CAN_BITE, true));
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof Player player && (player.isCreative() || player.isCrouching())) return;
        if(pEntity instanceof Monster monster && monster.getMobType() == DDMobType.SCULK) return;
        if(pState.getValue(CAN_BITE) && pEntity instanceof LivingEntity entity) {
            pLevel.setBlock(pPos, pState.setValue(BITING, true), 3);
            entity.hurt(DDDamageTypes.source(pLevel, DDDamageTypes.BITE, entity, null), 3);
            if (pEntity instanceof Player player) player.giveExperiencePoints(-4);
            pLevel.scheduleTick(pPos, this, 35);
        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pState.getValue(BITING)) pLevel.setBlock(pPos, pState.setValue(BITING, false), 3);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if(pEntity instanceof LivingEntity entity) entity.hurt(DDDamageTypes.source(pLevel, DDDamageTypes.BITE, entity, null), 3);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(BITING) ? Block.box(0, 0, 0, 0, 0, 0) : super.getCollisionShape(pState, pLevel, pPos, pContext);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BITING, CAN_BITE);
    }
}
