package com.kyanite.deeperdarker.content.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class SonorousStaffItem extends Item {
    public static int range = 40;
    public static float damage = 10f;
    public static double knockback = 1;

    public SonorousStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.getCooldowns().addCooldown(this, 40);

        Vec3 eyePos = pPlayer.getEyePosition();
        for (int i = 0; i < range; i++) {
            Vec3 particleSpawnPos = eyePos.add(pPlayer.getForward().x * i, pPlayer.getForward().y * i, pPlayer.getForward().z * i);
            BlockPos hitBlockPos = new BlockPos((int) particleSpawnPos.x, (int) particleSpawnPos.y, (int) particleSpawnPos.z);
            BlockState hitBlock = pLevel.getBlockState(hitBlockPos);
            if (hitBlock.isAir() || !hitBlock.canOcclude()) {
                if(pLevel.isClientSide()) pLevel.addParticle(ParticleTypes.SONIC_BOOM, particleSpawnPos.x, particleSpawnPos.y, particleSpawnPos.z, 1, 0, 0);

                AABB aabb = new AABB(hitBlockPos).inflate(0.4);
                List<Entity> targets = pLevel.getEntitiesOfClass(Entity.class, aabb);
                for (Entity target : targets) {
                    if (target != pPlayer) {
                        target.hurt(pLevel.damageSources().sonicBoom(pPlayer), damage);
                        if (target instanceof LivingEntity livingEntity) {
                            double horizontalResistance = 0.5 * (1 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                            double verticalResistance = 2.5 * (1 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                            target.push(pPlayer.getForward().x * knockback * horizontalResistance, pPlayer.getForward().y * knockback * verticalResistance, pPlayer.getForward().z * knockback * horizontalResistance);
                        }
                    }
                }
            } else i = range;
        }

        pPlayer.playSound(SoundEvents.WARDEN_SONIC_BOOM);

        return InteractionResultHolder.success(stack);
    }
}
