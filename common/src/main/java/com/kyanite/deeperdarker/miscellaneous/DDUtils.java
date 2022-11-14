package com.kyanite.deeperdarker.miscellaneous;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class DDUtils {
    public static int secondsToTicks(float seconds) {
        return (int) (20 * seconds);
    }
    public static BlockPos getNearestStructure(BlockPos pos, ServerLevel level) {
        return level.findNearestMapStructure(DDTags.Others.ALL_STRUCTURES, pos, 150, false);
    }

    public static void soulElytraTick(LivingEntity entity) {
        // One thirtieth chance of boost per tick.
        // Uncontrollable at 1/3, needs to be balanced to allow control and not be too OP.
        // 29f/30f same as 0 in roll of 20
        if(entity.level.getRandom().nextFloat() > 29f/30f) {
            entity.level.gameEvent(entity, GameEvent.ITEM_INTERACT_START, entity.blockPosition());
            Vec3 vec31 = entity.getLookAngle();
            Vec3 vec32 = entity.getDeltaMovement();
            entity.setDeltaMovement(vec32.add(vec31.x * 0.1 + (vec31.x * 2 - vec32.x) * 0.5, vec31.y * 0.1 + (vec31.y * 2 - vec32.y) * 0.5, vec31.z * 0.1 + (vec31.z * 2 - vec32.z) * 0.5));
            if(entity.level.isClientSide()) {
                entity.level.playSound((Player) entity, entity.blockPosition(), SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS, 1, 1);
                for(int i = 0; i < 5; i++) {
                    entity.level.addParticle(ParticleTypes.SCULK_CHARGE_POP, entity.getRandomX(5), entity.position().y, entity.getRandomZ(5), 0.2d, -0.2d, 0.2d);
                }
                return;
            }
        }

        // One fifth chance of particle per tick.
        // It's way too absurd at 1/2 chance per tick. Lag issues on high particle settings and shaders.
        if(entity.level.isClientSide() && entity.level.getRandom().nextFloat() > 4f/5f) {
            entity.level.addParticle(ParticleTypes.SCULK_SOUL, entity.getRandomX(1), entity.position().y, entity.getRandomZ(1), 0, -0.2d, 0);
            entity.level.playSound((Player) entity, entity.blockPosition(), SoundEvents.SCULK_BLOCK_SPREAD, SoundSource.BLOCKS, 1, 1);
        }
    }
}
