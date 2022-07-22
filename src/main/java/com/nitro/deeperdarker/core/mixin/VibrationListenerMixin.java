package com.nitro.deeperdarker.core.mixin;

import com.nitro.deeperdarker.core.registry.other.DDTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.Nullable;

@Mixin(VibrationListener.class)
public abstract class VibrationListenerMixin implements GameEventListener {
    @Mixin(VibrationListener.VibrationListenerConfig.class)
    public interface VibrationListenerConfig {
        default TagKey<GameEvent> getListenableEvents() {
            return GameEventTags.VIBRATIONS;
        }

        default boolean canTriggerAvoidVibration() {
            return false;
        }

        default boolean isValidVibration(GameEvent p_223878_, GameEvent.Context p_223879_) {
            if (!p_223878_.is(this.getListenableEvents())) {
                return false;
            } else {
                Entity entity = p_223879_.sourceEntity();
                if (entity != null) {
                    if (entity.isSpectator()) {
                        return false;
                    }

                    if (entity.isSteppingCarefully() && p_223878_.is(GameEventTags.IGNORE_VIBRATIONS_SNEAKING)) {
                        if (this.canTriggerAvoidVibration() && entity instanceof ServerPlayer) {
                            ServerPlayer serverplayer = (ServerPlayer)entity;
                            CriteriaTriggers.AVOID_VIBRATION.trigger(serverplayer);
                        }

                        return false;
                    }

                    if (entity.dampensVibrations()) {
                        return false;
                    }

                    if (entity.getTags().contains(DDTags.EntityTypes.SCULK)) {
                        return false;
                    }
                }

                if (p_223879_.affectedState() != null) {
                    return !p_223879_.affectedState().is(BlockTags.DAMPENS_VIBRATIONS);
                }
                else {
                    return true;
                }
            }
        }

        boolean shouldListen(ServerLevel p_223872_, GameEventListener p_223873_, BlockPos p_223874_, GameEvent p_223875_, GameEvent.Context p_223876_);

        void onSignalReceive(ServerLevel p_223865_, GameEventListener p_223866_, BlockPos p_223867_, GameEvent p_223868_, @Nullable Entity p_223869_, @Nullable Entity p_223870_, float p_223871_);

        default void onSignalSchedule() {}
    }
}