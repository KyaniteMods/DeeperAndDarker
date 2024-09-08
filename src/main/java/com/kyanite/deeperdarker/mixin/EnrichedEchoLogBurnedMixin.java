package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(FireBlock.class)
public class EnrichedEchoLogBurnedMixin {
    @Inject(method = "checkBurnOut", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void deeperdarker$dropKyanitePasteWhenEchoLogBurns(Level level, BlockPos blockPos, int i, RandomSource randomSource, int j, CallbackInfo ci, int k, BlockState blockState) {
        if (blockState.is(DDBlocks.ENRICHED_ECHO_LOG)) {
            level.addFreshEntity(new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(DDItems.RESONARIUM)));
        }
    }
}
