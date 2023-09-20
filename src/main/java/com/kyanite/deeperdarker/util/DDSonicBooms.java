package com.kyanite.deeperdarker.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class DDSonicBooms {
    public static int range = 40;
    public static float damage = 10F;
    public static double knockback = 1;
    // Defined in seconds.
    public static int cooldown = 10;
    public static void sonicBoom(ServerLevel pLevel, Player pPlayer) {
        Vec3 eyePos = pPlayer.getEyePosition();
        for (int i = 0; i < range; i++) {
            Vec3 particleSpawnPos = eyePos.add((pPlayer.getForward().x * i), (pPlayer.getForward().y * i), (pPlayer.getForward().z * i));
            BlockPos hitBlockPos = new BlockPos((int) particleSpawnPos.x, (int) particleSpawnPos.y, (int) particleSpawnPos.z);
            BlockState hitBlock = pLevel.getBlockState(hitBlockPos);
            if (hitBlock.isAir() || !hitBlock.canOcclude()) {
                pLevel.sendParticles((ParticleOptions) ParticleTypes.SONIC_BOOM, particleSpawnPos.x, particleSpawnPos.y, particleSpawnPos.z, 1, 0.0, 0.0, 0.0, 0.0);
                AABB aabb = (new AABB(hitBlockPos)).inflate(0.4);
                List<LivingEntity> targets = pLevel.getEntitiesOfClass(LivingEntity.class, aabb);
                for (LivingEntity target : targets) {
                    if (target != pPlayer) {
                        target.hurt(pLevel.damageSources().sonicBoom(pPlayer), damage);
                        double horizontalResistance = 0.5 * (1 - target.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                        double verticalResistance = 2.5 * (1 - target.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                        target.push((pPlayer.getForward().x * knockback * horizontalResistance), (pPlayer.getForward().y * knockback * verticalResistance), (pPlayer.getForward().z * knockback * horizontalResistance));
                    }
                }
            }
            else i = range;
        }
        pPlayer.playSound(SoundEvents.WARDEN_SONIC_BOOM);
    }
}
