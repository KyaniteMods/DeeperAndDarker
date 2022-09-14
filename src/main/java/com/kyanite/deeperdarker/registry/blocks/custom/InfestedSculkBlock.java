package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.ShriekWormEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SculkBlock;
import net.minecraft.world.level.block.state.BlockState;

public class InfestedSculkBlock extends SculkBlock {
    public InfestedSculkBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof Player player) {
            pLevel.setBlock(pPos, Blocks.SCULK.defaultBlockState(), 3);
            player.knockback(1, 1, 1);
            ShriekWormEntity entity = DDEntities.SHRIEK_WORM.get().create(pLevel);
            entity.setState(ShriekWormEntity.EMERGE);
            pLevel.addFreshEntity(entity);
            entity.moveTo(pPos.above(), 0, 0);
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        if(!isBlockBeside(level, this, pos) && !noSpace(level, pos, 6)) return true;
        return super.isValidSpawn(state, level, pos, type, entityType);
    }

    public boolean isBlockBeside(BlockGetter level, Block targetBlock, BlockPos origin) {
        return level.getBlockState(origin.north()).is(targetBlock) || level.getBlockState(origin.east()).is(targetBlock) || level.getBlockState(origin.south()).is(targetBlock) || level.getBlockState(origin.west()).is(targetBlock);
    }

    public boolean noSpace(BlockGetter getter, BlockPos origin, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!getter.getBlockState(origin.above(i)).is(Blocks.AIR)) return true;
        }
        return false;
    }
}
