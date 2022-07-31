package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SculkBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class InfestedSculk extends SculkBlock {
    public InfestedSculk(Properties p_222063_) {
        super(p_222063_);
    }
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof Player) {
            Player player = (Player)pEntity;
            pLevel.setBlock(pPos, Blocks.SCULK.defaultBlockState(), 3);
            player.knockback(1.2, 1.2, 1.2);
            Entity entity = DDEntities.SCULK_WORM.get().create(pLevel);
            SculkWormEntity sculkWormEntity = (SculkWormEntity)entity;
            sculkWormEntity.setState(SculkWormEntity.SculkWormState.EMERGING);
            pLevel.addFreshEntity(sculkWormEntity);
            sculkWormEntity.setPosRaw(pPos.above().getX(), pPos.above().getY(), pPos.above().getZ());
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
