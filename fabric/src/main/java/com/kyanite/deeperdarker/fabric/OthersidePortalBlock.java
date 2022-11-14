package com.kyanite.deeperdarker.fabric;

import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class OthersidePortalBlock extends CustomPortalBlock {
    public OthersidePortalBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pRandom.nextFloat() < 0.0007) {
            pLevel.playLocalSound(pPos.getX() + 0.5d, pPos.getY() + 0.5d, pPos.getZ() + 0.5d, DDSounds.PORTAL_GROAN.get(), SoundSource.BLOCKS, 0.2f, pRandom.nextFloat() * 0.2f + 0.9f, false);
        }
    }
}
