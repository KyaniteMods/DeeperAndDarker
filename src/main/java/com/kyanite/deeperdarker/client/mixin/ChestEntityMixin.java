package com.kyanite.deeperdarker.client.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ContainerOpenersCounter.class)
public abstract class ChestEntityMixin  {
    @Shadow protected abstract int getOpenCount(Level pLevel, BlockPos pPos);

    @Shadow private int openCount;

    @Shadow protected abstract void onOpen(Level pLevel, BlockPos pPos, BlockState pState);

    @Shadow protected abstract void onClose(Level pLevel, BlockPos pPos, BlockState pState);

    @Shadow protected abstract void openerCountChanged(Level pLevel, BlockPos pPos, BlockState pState, int pCount, int pOpenCount);

    @Shadow
    protected static void scheduleRecheck(Level pLevel, BlockPos pPos, BlockState pState) {
    }

    @Inject(method = "recheckOpeners", at = @At("HEAD"), cancellable = true)
    public void recheckOpen(Level pLevel, BlockPos pPos, BlockState pState, CallbackInfo ci) {
        ci.cancel();
        int i = this.getOpenCount(pLevel, pPos);
        int j = this.openCount;
        if (j != i) {
            boolean flag = i != 0;
            boolean flag1 = j != 0;
            if (flag && !flag1) {
                this.onOpen(pLevel, pPos, pState);
                pLevel.gameEvent((Entity)null, GameEvent.CONTAINER_OPEN, pPos);
            } else if (!flag) {
                this.onClose(pLevel, pPos, pState);
                pLevel.gameEvent((Entity)null, GameEvent.CONTAINER_CLOSE, pPos);
            }

            this.openCount = i;
        }

      //  this.openerCountChanged(pLevel, pPos, pState, j, i);
    }
}
