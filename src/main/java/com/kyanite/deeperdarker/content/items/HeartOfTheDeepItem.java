package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.util.DDTags;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.kyrptonaught.customportalapi.portal.PortalPlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3d;
import org.joml.Vector3i;

public class HeartOfTheDeepItem extends Item {
    public HeartOfTheDeepItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack pItemStack, Level pLevel, Entity pEntity, int i, boolean bl) {
        if (pLevel instanceof ServerLevel serverLevel && pEntity instanceof Player player && player.isHolding(stack -> stack == pItemStack)) {
            BlockPos pos = serverLevel.findNearestMapStructure(DDTags.Structures.WARDEN_HEART_PULSES, pEntity.blockPosition(), 100, false);
            if (pos != null) {
                Vec3 vec3i = pos.subtract(pEntity.getOnPos()).getCenter().normalize();
                double dotProduct = pEntity.getLookAngle().dot(vec3i);
                if (dotProduct >= 0) {
                    float period = 10.0f / (float) dotProduct;
                    if (pLevel.getGameTime() % Math.ceil(period) == 0) {
                        player.playNotifySound(SoundEvents.WARDEN_HEARTBEAT, SoundSource.AMBIENT, 1.7f, 1f);
                    }
                }
            }
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        if (useOnContext.getLevel().getBlockState(useOnContext.getClickedPos()).is(Blocks.SCULK_VEIN) && PortalPlacer.attemptPortalLight(useOnContext.getLevel(), useOnContext.getClickedPos(), PortalIgnitionSource.ItemUseSource(useOnContext.getItemInHand().getItem()).withPlayer(useOnContext.getPlayer()))) {
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
