package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class WardenDropSculkBoneShardMixin {
    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    private void deeperdarker$shearWardenRib(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        Mob mob = (Mob) (Object) this;
        if (!(mob instanceof Warden warden)) return;
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.is(Items.SHEARS)) {
            if (!warden.level().isClientSide()) {
                shear(SoundSource.PLAYERS);
                mob.gameEvent(GameEvent.SHEAR, player);
                itemStack.hurtAndBreak(Items.SHEARS.getMaxDamage(), player, p -> p.broadcastBreakEvent(interactionHand));
                cir.setReturnValue(InteractionResult.SUCCESS);
                return;
            }
            cir.setReturnValue(InteractionResult.CONSUME);
        }
    }

    @Unique
    private void shear(SoundSource soundSource) {
        Mob mob = ((Mob) (Object) this);
        mob.level().playSound(null, mob, DDSounds.WARDEN_SHEAR, soundSource, 1.0f, 1.0f);
        RandomSource random = mob.getRandom();
        int i = 1 + random.nextInt(3);
        for (int j = 0; j < i; ++j) {
            ItemEntity itemEntity = mob.spawnAtLocation(DDItems.SCULK_BONE_SHARD, 1);
            if (itemEntity == null) continue;
            itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((random.nextFloat() - random.nextFloat()) * 0.1f, random.nextFloat() * 0.05f, (random.nextFloat() - random.nextFloat()) * 0.1f));
        }
    }
}
