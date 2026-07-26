package com.kyanite.deeperdarker.content.entities.overcastvessel;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDEntities;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OvercastVesselItem extends Entity implements TraceableEntity {
    public static final String TIME_TO_USE_TAG = "time_to_use";
    public static final String GOLEM_TAG = "golem";
    public static final String ITEM_STACK_TAG = "item_stack";
    public static final String TARGET_POSITION_TAG = "target_position";

    private static final EntityDataAccessor<ItemStack> DATA_ITEM = SynchedEntityData.defineId(OvercastVesselItem.class, EntityDataSerializers.ITEM_STACK);
    private int timeToUse = 30;
    @Nullable
    private UUID golem;
    private Vec3 target;
    private Vec3 oldDeltaMovement = getDeltaMovement();

    public OvercastVesselItem(EntityType<? extends OvercastVesselItem> entityType, Level level) {
        super(entityType, level);
    }

    public OvercastVesselItem(Level level, ItemStack stack, @Nullable OvercastVessel vessel) {
        this(DDEntities.OVERCAST_VESSEL_ITEM, level);
        setItem(stack);
        if (vessel != null) {
            setGolem(vessel.getUUID());
            setPos(vessel.position().add(0.0, vessel.getBbHeight() - getBbHeight(), 0.0));
            setTarget(vessel.position().add(0.0, vessel.getBbHeight() + 0.5, 0.0));
        }
    }

    @Override
    @Nullable
    public Entity getOwner() {
        Level level;
        if (this.golem != null && (level = this.level()) instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)level;
            return serverLevel.getEntity(this.golem);
        }
        return null;
    }

    @Override
    protected void defineSynchedData() {
        this.getEntityData().define(DATA_ITEM, ItemStack.EMPTY);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putInt(TIME_TO_USE_TAG, timeToUse);
        if (this.golem != null) {
            compoundTag.putUUID(GOLEM_TAG, this.golem);
        }
        if (!this.getItem().isEmpty()) {
            compoundTag.put(ITEM_STACK_TAG, this.getItem().save(new CompoundTag()));
        }
        if (target != null) {
            Vec3.CODEC.encodeStart(NbtOps.INSTANCE, this.getTarget()).resultOrPartial(DeeperDarker.LOGGER::error).ifPresent(tag -> compoundTag.put(TARGET_POSITION_TAG, tag));
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        timeToUse = compoundTag.getInt(TIME_TO_USE_TAG);
        if (compoundTag.hasUUID(GOLEM_TAG)) {
            golem = compoundTag.getUUID(GOLEM_TAG);
        }
        CompoundTag compoundTag2 = compoundTag.getCompound(ITEM_STACK_TAG);
        setItem(ItemStack.of(compoundTag2));
        if (getItem().isEmpty()) {
            discard();
        }
        if (compoundTag.contains(TARGET_POSITION_TAG, CompoundTag.TAG_LIST)) {
            setTarget(Vec3.CODEC.parse(NbtOps.INSTANCE, compoundTag.get(TARGET_POSITION_TAG)).resultOrPartial(DeeperDarker.LOGGER::error).orElse(null));
        }
    }

    @Override
    public Component getName() {
        Component component = this.getCustomName();
        if (component != null) {
            return component;
        }
        return Component.translatable(this.getItem().getDescriptionId());
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    public ItemStack getItem() {
        return this.getEntityData().get(DATA_ITEM);
    }

    public void setItem(ItemStack itemStack) {
        this.getEntityData().set(DATA_ITEM, itemStack);
    }

    public void setGolem(@Nullable UUID uUID) {
        this.golem = uUID;
    }

    public void setTarget(Vec3 target) {
        this.target = target;
    }

    public Vec3 getTarget() {
        return target;
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
        super.onSyncedDataUpdated(entityDataAccessor);
        if (DATA_ITEM.equals(entityDataAccessor)) {
            this.getItem().setEntityRepresentation(this);
        }
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    @Override
    public void tick() {
        if (this.getItem().isEmpty()) {
            this.discard();
            return;
        }
        super.tick();
        pushVesselItems();

        this.xo = this.getX();
        this.yo = this.getY();
        this.zo = this.getZ();
        Vec3 vec3 = this.getDeltaMovement();
        oldDeltaMovement = vec3;
        if (getTarget() != null) {
            Vec3 targetCenter = getTarget();
            float moveAmount = Math.min(0.64f, Mth.sqrt((float) distanceToSqr(targetCenter)) / 8.0f);
            setDeltaMovement(targetCenter.subtract(position()).normalize().scale(moveAmount));
            move(MoverType.SELF, getDeltaMovement());
        }
        if (this.level().isClientSide()) {
            this.noPhysics = false;
        } else {
            this.noPhysics = !this.level().noCollision(this, this.getBoundingBox().deflate(1.0E-7));
        }
        if (this.getDeltaMovement().horizontalDistanceSqr() > (double)1.0E-5f || (this.tickCount + this.getId()) % 4 == 0) {
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.98f));
        }
        if (!this.level().isClientSide && this.getDeltaMovement().subtract(vec3).lengthSqr() > 0.01) {
            this.hasImpulse = true;
        }
        timeToUse--;
        if (timeToUse <= 0) {
            useItem();
        }
    }

    public float getTilt(float f) {
        float velocityX = (float) Mth.lerp(f, oldDeltaMovement.x(), getDeltaMovement().x());
        float velocityY = (float) Mth.lerp(f, oldDeltaMovement.y(), getDeltaMovement().y());
        float velocityZ = (float) Mth.lerp(f, oldDeltaMovement.z(), getDeltaMovement().z());
        float length = Mth.sqrt(velocityX * velocityX + velocityY * velocityY + velocityZ * velocityZ);
        return Math.min(Mth.HALF_PI, length * 4.0f);
    }

    public void useItem() {
        if (level().isClientSide()) {
            for (int i = 0; i < 5; ++i) {
                this.level().addParticle(ParticleTypes.LARGE_SMOKE, this.getRandomX(1.5), this.getRandomY(), this.getRandomZ(1.5), 0.0, 0.0, 0.0);
            }
            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, getItem()), this.getX(), this.getY(), this.getZ(), random.nextGaussian() * 0.15, random.nextDouble() * 0.2, random.nextGaussian() * 0.15);
            }
            return;
        }
        if ((getItem().is(Items.BRICK) || getItem().is(ItemTags.DECORATED_POT_SHERDS)) && getOwner() instanceof OvercastVessel vessel) {
            vessel.repairCracks();
        }
        UseOnContext ctx = new UseOnContext(level(), null, InteractionHand.MAIN_HAND, getItem(), new BlockHitResult(position(), Direction.UP, blockPosition(), true));
        getItem().useOn(ctx);
        discard();
    }

    public void pushVesselItems() {
        Vec3 target = getTarget();
        if (target == null) return;
        List<Entity> list = level().getEntities(this, getBoundingBox().move(target.subtract(position())), entity -> entity instanceof OvercastVesselItem);
        if (!list.isEmpty()) {
            List<Entity> listWithThis = new ArrayList<>(list);
            listWithThis.add(list.size() / 2, this);
            double baseX = target.x();
            for (int i = 0; i < listWithThis.size(); i++) {
                OvercastVesselItem entity = (OvercastVesselItem) listWithThis.get(i);
                Vec3 itemTarget = getTarget();
                entity.setTarget(new Vec3(baseX + (i - (listWithThis.size() - 1) / 2.0) * (getBbWidth() + 0.75), itemTarget.y(), itemTarget.z()));
            }
        }
    }
}
