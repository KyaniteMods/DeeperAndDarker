package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.ItemAbilities;

@SuppressWarnings("NullableProblems")
public class PorousSculkGleamBlock extends Block {
    public static final IntegerProperty GEL_LEVEL = IntegerProperty.create("gel_level", 0, 6);

    public PorousSculkGleamBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(GEL_LEVEL, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(GEL_LEVEL);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int gelAmount = state.getValue(GEL_LEVEL);
        if(gelAmount < 6) level.setBlock(pos, state.setValue(GEL_LEVEL, gelAmount + 1), 3);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(state.getValue(GEL_LEVEL) >= 6) {
            if(stack.canPerformAction(ItemAbilities.SHEARS_HARVEST)) {
                level.playSound(player, pos, DDSounds.POROUS_SCULK_GLEAM_SHEAR.get(), SoundSource.BLOCKS, 0.8f, level.getRandom().nextFloat() * 0.2f + 0.8f);
                popResource(level, pos, new ItemStack(DDItems.GLEAM_GEL.get(), 2));
                stack.hurtAndBreak(1, player, hand);
                level.gameEvent(player, GameEvent.SHEAR, pos);

                if(!level.isClientSide()) player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                level.setBlock(pos, state.setValue(GEL_LEVEL, 0), 3);
            }
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        return state.getValue(GEL_LEVEL);
    }
}
