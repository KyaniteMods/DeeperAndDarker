package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SculkBlock;
import net.minecraft.world.level.block.state.BlockState;

public class InfestedSculk extends SculkBlock {
    public InfestedSculk(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof Player player) {
            pLevel.setBlock(pPos, Blocks.SCULK.defaultBlockState(), 3);
            player.knockback(1.2, 1.2, 1.2);
            Entity entity = DDEntities.SCULK_WORM.get().create(pLevel);
            SculkWormEntity sculkWormEntity = (SculkWormEntity)entity;
            pLevel.addFreshEntity(sculkWormEntity);
            sculkWormEntity.moveTo(pPos.above(), 0, 0);
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}