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

public class HeartOfTheDeepItem extends Item {
    public HeartOfTheDeepItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack pItemStack, Level pLevel, Entity pEntity, int i, boolean bl) {
        if (pLevel instanceof ServerLevel serverLevel) {
            BlockPos pos = serverLevel.findNearestMapStructure(DDTags.Structures.WARDEN_HEART_PULSES, pEntity.blockPosition(), 100, false);
            if (pos != null) {
                float probability = Mth.sqrt((float) pos.distSqr(pEntity.blockPosition())) == 0 ? 1 : (float) Mth.clamp(1.0f / (Math.log(Mth.sqrt((float) pos.distSqr(pEntity.blockPosition())) * 4.0f + 1)), 0.0f, 1.0f);
                probability /= 5;
                if (pEntity instanceof Player player && RandomSource.create().nextFloat() < probability) {
                    player.playNotifySound(SoundEvents.WARDEN_HEARTBEAT, SoundSource.AMBIENT, 1.7f, 1f);
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
