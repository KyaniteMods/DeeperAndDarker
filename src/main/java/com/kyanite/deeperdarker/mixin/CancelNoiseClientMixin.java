package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientLevel.class)
public class CancelNoiseClientMixin {
    @Inject(method = "playSound", at = @At("HEAD"), cancellable = true)
    private void deeperdarker$cancelNoiseClient(double x, double y, double z, SoundEvent soundEvent, SoundSource soundSource, float volume, float pitch, boolean distanceDelay, long seed, CallbackInfo ci) {
        if (!DeeperDarker.CONFIG.client.noiseCancelerCancelsSounds()) return;
        boolean canceled = false;
        int xInt = (int) x;
        int yInt = (int) y;
        int zInt = (int) z;
        int noiseCancelerRadius = DeeperDarker.CONFIG.server.noiseCancelerRadius();

        for (int blockX = xInt - noiseCancelerRadius; blockX <= x + noiseCancelerRadius; blockX++) {
            for (int blockY = yInt - noiseCancelerRadius; blockY <= y + noiseCancelerRadius; blockY++) {
                for (int blockZ = zInt - noiseCancelerRadius; blockZ <= z + noiseCancelerRadius; blockZ++) {
                    int xd = blockX - xInt;
                    int yd = blockY - yInt;
                    int zd = blockZ - zInt;
                    if (xd * xd + yd * yd + zd * zd > noiseCancelerRadius * noiseCancelerRadius) continue;
                    BlockState state = ((ClientLevel)(Object) this).getBlockState(new BlockPos(blockX, blockY, blockZ));
                    if (state.is(DDBlocks.NOISE_CANCELER) && state.getValue(BlockStateProperties.POWERED)) {
                        canceled = true;
                        ((ClientLevel)(Object) this).addParticle(ParticleTypes.SONIC_BOOM, blockX + 0.5, blockY + 0.5, blockZ + 0.5, 0.0, 0.0, 0.0);
                    }
                }
            }
        }
        if (canceled) ci.cancel();
    }
}
