package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.joml.Vector3f;

public class ToxicAirBlock extends Block {
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;

    public ToxicAirBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(PERSISTENT, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PERSISTENT);
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        super.entityInside(blockState, level, blockPos, entity);
        if (entity.getType().is(DDTags.EntityTypes.TOXIC_AIR_IMMUNE) || !(entity instanceof LivingEntity)) return;
        entity.hurt(level.damageSources().magic(), 4);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!blockState.getValue(PERSISTENT)) return;
        serverLevel.removeBlock(blockPos, false);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        double d = blockPos.getX();
        double e = blockPos.getY();
        double f = blockPos.getZ();
        DustParticleOptions particleOptions = new DustParticleOptions(new Vector3f(0.1f, 0.8f, 0.0f), 1);
        level.addAlwaysVisibleParticle(particleOptions, d + 0.5, e + 0.5, f + 0.5, 0.0, 0.0, 0.0);
        level.addAlwaysVisibleParticle(particleOptions, d + (double)randomSource.nextFloat(), e + (double)randomSource.nextFloat(), f + (double)randomSource.nextFloat(), 0.0, 0.0, 0.0);
        level.addAlwaysVisibleParticle(particleOptions, d + (double)randomSource.nextFloat(), e + (double)randomSource.nextFloat(), f + (double)randomSource.nextFloat(), 0.0, 0.0, 0.0);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Shapes.empty();
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.INVISIBLE;
    }
}
