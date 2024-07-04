package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.client.CustomPortalsModClient;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class OthersidePortalBlock extends CustomPortalBlock {
    public OthersidePortalBlock(Properties settings) {
        super(settings);
    }

    // This is just to make the portal emit our custom sound instead of the vanilla Nether portal sound
    @Override
    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (random.nextInt(100) == 0) {
            world.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D,
                    DDSounds.PORTAL_GROAN, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double d = (double) pos.getX() + random.nextDouble();
            double e = (double) pos.getY() + random.nextDouble();
            double f = (double) pos.getZ() + random.nextDouble();
            double g = ((double) random.nextFloat() - 0.5) * 0.5;
            double h = ((double) random.nextFloat() - 0.5) * 0.5;
            double j = ((double) random.nextFloat() - 0.5) * 0.5;
            int k = random.nextInt(2) * 2 - 1;

            if (state.getValue(AXIS) == Direction.Axis.Y) {
                h = random.nextFloat() * 2.0f * (float) k;
            } else {
                if (world.getBlockState(pos.west()).is(this) || world.getBlockState(pos.east()).is(this)) {
                    f = (double) pos.getZ() + 0.5 + 0.25 * (double) k;
                    j = random.nextFloat() * 2.0f * (float) k;
                } else {
                    d = (double) pos.getX() + 0.5 + 0.25 * (double) k;
                    g = random.nextFloat() * 2.0f * (float) k;
                }
            }
            world.addParticle(new BlockParticleOption(
                    CustomPortalsModClient.CUSTOMPORTALPARTICLE, getPortalBase(world, pos).defaultBlockState()), d, e, f, g, h, j);
        }
    }
}
