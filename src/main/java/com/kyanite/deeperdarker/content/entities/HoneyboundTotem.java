package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEffects;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HoneyboundTotem extends Entity {
    private static final EntityDataAccessor<Byte> DATA_HONEY_AMOUNT;
    private static final EntityDataAccessor<Long> DATA_HONEY_TIME;

    public HoneyboundTotem(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.blocksBuilding = true;
    }

    @Override
    protected void defineSynchedData() {
        this.getEntityData().define(DATA_HONEY_AMOUNT, (byte)0);
        this.getEntityData().define(DATA_HONEY_TIME, 0L);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        this.setHoneyAmount(compoundTag.getByte("honey_amount"));
        this.setHoneyTime(compoundTag.getLong("honey_time"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putByte("honey_amount", this.getHoneyAmount());
        compoundTag.putLong("honey_time", this.getHoneyTime());
    }

    public byte getHoneyAmount() {
        return this.getEntityData().get(DATA_HONEY_AMOUNT);
    }

    public boolean setHoneyAmount(byte amount) {
        if (this.getHoneyAmount() + amount > this.getMaxHoneyAmount() || this.getHoneyAmount() + amount < 0) return false;
        this.getEntityData().set(DATA_HONEY_AMOUNT, (byte)(amount % 4));
        return true;
    }

    public long getHoneyTime() {
        return this.getEntityData().get(DATA_HONEY_TIME);
    }

    private void setHoneyTime(long value) {
        this.getEntityData().set(DATA_HONEY_TIME, value);
    }

    public boolean isMaxHoneyAmount() {
        return this.getHoneyAmount() == this.getMaxHoneyAmount();
    }

    public int getMaxHoneyAmount() {
        return 3;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isMaxHoneyAmount()) {
            for (Player player : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(10.0f))) {
                player.addEffect(new MobEffectInstance(DDEffects.SCULK_AFFINITY, 130, 0, true, true));
            }
            this.setHoneyTime(this.getHoneyTime() + 1);
        } else {
            this.setHoneyTime(0);
        }


        if (!this.isNoGravity() && !this.isMaxHoneyAmount()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.04, 0.0));
        }
        if (this.isColliding(this.getOnPos().above(), this.level().getBlockState(this.getOnPos().above())) && !this.isColliding(this.getOnPos().above(2), this.level().getBlockState(this.getOnPos().above(2)))) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.3125, 0.0));
        }

        this.move(MoverType.SELF, this.getDeltaMovement());
        if (this.onGround() && this.level().getBlockState(this.getOnPos().above()).getCollisionShape(this.level(), this.getOnPos().above()).isEmpty()) {
            Vec3 newPos = this.getOnPos().getCenter();
            newPos = new Vec3(newPos.x(), this.getY(), newPos.z());
            this.setPos(newPos);
        }
        this.setRot((float)Math.floor(this.getYRot() / 90.0f) * 90.0f, (float)Math.floor(this.getXRot() / 90.0f) * 90.0f);
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Nullable
    @Override
    public ItemStack getPickResult() {
        return DDItems.HONEYBOUND_TOTEM.getDefaultInstance();
    }

    @Override
    public @NotNull InteractionResult interact(Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.is(Items.HONEY_BOTTLE) && !this.isMaxHoneyAmount()) {
            player.playSound(SoundEvents.HONEY_DRINK, 1.0f, 1.0f);
            this.setHoneyAmount((byte) (this.getHoneyAmount() + 1));

            itemStack.shrink(1);
            if (itemStack.isEmpty()) {
                player.setItemInHand(interactionHand, new ItemStack(Items.GLASS_BOTTLE));
            } else if (!player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE))) {
                player.drop(new ItemStack(Items.GLASS_BOTTLE), false);
            }

            if (this.isMaxHoneyAmount()) {
                this.playSound(SoundEvents.CONDUIT_ACTIVATE, 1.0f, 1.0f);
            }
            return InteractionResult.sidedSuccess(this.level().isClientSide());
        } else if (itemStack.is(Items.GLASS_BOTTLE) && this.getHoneyAmount() > 0) {
            if (this.isMaxHoneyAmount()) {
                this.playSound(SoundEvents.CONDUIT_DEACTIVATE, 1.0f, 1.0f);
            }
            player.playSound(SoundEvents.BOTTLE_FILL, 1.0F, 1.0F);
            this.setHoneyAmount((byte) (this.getHoneyAmount() - 1));

            itemStack.shrink(1);
            if (itemStack.isEmpty()) {
                player.setItemInHand(interactionHand, new ItemStack(Items.HONEY_BOTTLE));
            } else if (!player.getInventory().add(new ItemStack(Items.HONEY_BOTTLE))) {
                player.drop(new ItemStack(Items.HONEY_BOTTLE), false);
            }

            return InteractionResult.sidedSuccess(this.level().isClientSide());
        }
        return super.interact(player, interactionHand);
    }

    public boolean skipAttackInteraction(Entity entity) {
        if (entity instanceof Player player) {
            return !this.level().mayInteract(player, this.getOnPos()) || this.hurt(this.damageSources().playerAttack(player), 0.0F);
        } else {
            return false;
        }
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (!this.level().isClientSide && !this.isRemoved()) {
            if (damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                this.kill();
                return false;
            } else if (!this.isInvulnerableTo(damageSource) && damageSource.isCreativePlayer()) {
                this.showBreakingParticles();
                this.playBrokenSound();
                this.kill();
                return true;
            }
        }
        return false;
    }

    private void playBrokenSound() {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.DEEPSLATE_BREAK, this.getSoundSource(), 1.0F, 1.0F);
    }

    private void showBreakingParticles() {
        if (this.level() instanceof ServerLevel) {
            ((ServerLevel)this.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, DDBlocks.GLOOMSLATE_BRICKS.defaultBlockState()), this.getX(), this.getY(0.6666666666666666), this.getZ(), 10, this.getBbWidth() / 4.0F, this.getBbHeight() / 4.0F, this.getBbWidth() / 4.0F, 0.05);
        }
    }

    static {
        DATA_HONEY_AMOUNT = SynchedEntityData.defineId(HoneyboundTotem.class, EntityDataSerializers.BYTE);
        DATA_HONEY_TIME = SynchedEntityData.defineId(HoneyboundTotem.class, EntityDataSerializers.LONG);
    }
}
