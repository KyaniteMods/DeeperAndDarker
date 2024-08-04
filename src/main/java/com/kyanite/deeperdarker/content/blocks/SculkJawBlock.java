package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.util.DDDamageTypes;
import com.kyanite.deeperdarker.util.DDTags;
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

@SuppressWarnings("NullableProblems")
public class SculkJawBlock extends Block {
    public static final BooleanProperty BITING = BooleanProperty.create("biting");
    public static final BooleanProperty CAN_BITE = BooleanProperty.create("can_bite");

    public SculkJawBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITING, false).setValue(CAN_BITE, true));
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof Player player && (player.isCreative() || player.isCrouching())) return;
        if(entity instanceof Monster monster && monster.getType().is(DDTags.Misc.SCULK)) return;
        if(state.getValue(CAN_BITE) && entity instanceof LivingEntity living) {
            level.setBlock(pos, state.setValue(BITING, true), 3);
            living.hurt(DDDamageTypes.source(level, DDDamageTypes.BITE, living, null), 3);
            if (living instanceof Player player) player.giveExperiencePoints(-4);
            level.scheduleTick(pos, this, 35);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(state.getValue(BITING)) level.setBlock(pos, state.setValue(BITING, false), 3);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof LivingEntity living) living.hurt(DDDamageTypes.source(level, DDDamageTypes.BITE, living, null), 3);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(BITING) ? Block.box(0, 0, 0, 0, 0, 0) : super.getCollisionShape(state, level, pos, context);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BITING, CAN_BITE);
    }
}
