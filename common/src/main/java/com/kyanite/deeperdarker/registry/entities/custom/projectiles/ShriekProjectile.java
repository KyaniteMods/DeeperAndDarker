package com.kyanite.deeperdarker.registry.entities.custom.projectiles;

import com.kyanite.deeperdarker.config.DDConfig;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SculkSpreader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Iterator;

public class ShriekProjectile extends AbstractArrow {
    private final SculkSpreader sculkSpreader;

    public ShriekProjectile(EntityType<? extends ShriekProjectile> entityType, Level level) {
        super(entityType, level);
        this.pickup = Pickup.DISALLOWED;
        this.sculkSpreader = SculkSpreader.createLevelSpreader();
    }

    public ShriekProjectile(Level level, LivingEntity owner) {
        super(DDEntities.SHRIEK_PROJECTILE.get(), owner, level);
        this.sculkSpreader = SculkSpreader.createLevelSpreader();
    }

    protected ShriekProjectile(EntityType<? extends ShriekProjectile> entityType, double x, double y, double z, Level world) {
        this(entityType, world);
    }

    protected ShriekProjectile(EntityType<? extends ShriekProjectile> entityType, LivingEntity owner, Level world) {
        this(entityType, owner.getX(), owner.getEyeY() - 0.10000000149011612D, owner.getZ(), world);
        this.setOwner(owner);
        if (owner instanceof Player) {
            this.pickup = AbstractArrow.Pickup.ALLOWED;
        }
    }

    @Override
    public void tick() {
        boolean bl = this.isNoPhysics();
        Vec3 vec3 = this.getDeltaMovement();
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            double d = vec3.horizontalDistance();
            this.setYRot((float)(Mth.atan2(vec3.x, vec3.z) * 57.2957763671875));
            this.setXRot((float)(Mth.atan2(vec3.y, d) * 57.2957763671875));
            this.yRotO = this.getYRot();
            this.xRotO = this.getXRot();
        }

        BlockPos blockPos = this.blockPosition();
        BlockState blockState = this.level.getBlockState(blockPos);
        Vec3 vec32;
        if (!blockState.isAir() && !bl) {
            VoxelShape voxelShape = blockState.getCollisionShape(this.level, blockPos);
            if (!voxelShape.isEmpty()) {
                vec32 = this.position();
                Iterator var7 = voxelShape.toAabbs().iterator();

                while(var7.hasNext()) {
                    AABB aABB = (AABB)var7.next();
                    if (aABB.move(blockPos).contains(vec32)) {
                        this.inGround = true;
                        break;
                    }
                }
            }
        }

        if (this.shakeTime > 0) {
            --this.shakeTime;
        }

        if (this.isInWaterOrRain() || blockState.is(Blocks.POWDER_SNOW)) {
            this.clearFire();
        }

        if (this.inGround && !bl) {
            ++this.inGroundTime;
        } else {
            this.inGroundTime = 0;
            Vec3 vec33 = this.position();
            vec32 = vec33.add(vec3);
            HitResult hitResult = this.level.clip(new ClipContext(vec33, vec32, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
            if (((HitResult)hitResult).getType() != HitResult.Type.MISS) {
                vec32 = ((HitResult)hitResult).getLocation();
            }

            while(!this.isRemoved()) {
                EntityHitResult entityHitResult = this.findHitEntity(vec33, vec32);
                if (entityHitResult != null) {
                    hitResult = entityHitResult;
                }

                if (hitResult != null && ((HitResult)hitResult).getType() == HitResult.Type.ENTITY) {
                    Entity entity = ((EntityHitResult)hitResult).getEntity();
                    Entity entity2 = this.getOwner();
                    if (entity instanceof Player && entity2 instanceof Player && !((Player)entity2).canHarmPlayer((Player)entity)) {
                        hitResult = null;
                        entityHitResult = null;
                    }
                }

                if (hitResult != null && !bl) {
                    this.onHit((HitResult)hitResult);
                    this.hasImpulse = true;
                }

                if (entityHitResult == null || this.getPierceLevel() <= 0) {
                    break;
                }

                hitResult = null;
            }

            vec3 = this.getDeltaMovement();
            double e = vec3.x;
            double f = vec3.y;
            double g = vec3.z;
            if (this.isCritArrow()) {
                for(int i = 0; i < 4; ++i) {
                    this.level.addParticle(ParticleTypes.CRIT, this.getX() + e * (double)i / 4.0, this.getY() + f * (double)i / 4.0, this.getZ() + g * (double)i / 4.0, -e, -f + 0.2, -g);
                }
            }

            double h = this.getX() + e;
            double j = this.getY() + f;
            double k = this.getZ() + g;
            double l = vec3.horizontalDistance();
            if (bl) {
                this.setYRot((float)(Mth.atan2(-e, -g) * 57.2957763671875));
            } else {
                this.setYRot((float)(Mth.atan2(e, g) * 57.2957763671875));
            }

            this.setXRot((float)(Mth.atan2(f, l) * 57.2957763671875));
            this.setXRot(lerpRotation(this.xRotO, this.getXRot()));
            this.setYRot(lerpRotation(this.yRotO, this.getYRot()));
            float m = 0.99F;
            float n = 0.05F;
            if (this.isInWater()) {
                for(int o = 0; o < 4; ++o) {
                    float p = 0.25F;
                    this.level.addParticle(ParticleTypes.BUBBLE, h - e * 0.25, j - f * 0.25, k - g * 0.25, e, f, g);
                }

                m = this.getWaterInertia();
            }

            this.setDeltaMovement(vec3.scale((double)m));
            if (!this.isNoGravity() && !bl) {
                Vec3 vec34 = this.getDeltaMovement();
                this.setDeltaMovement(vec34.x, vec34.y - 0.05000000074505806, vec34.z);
            }

            this.setPos(h, j, k);
            this.checkInsideBlocks();
        }

        if(level.isClientSide()) {
            getLevel().addParticle(ParticleTypes.SONIC_BOOM, position().x, position().y, position().z, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public void move(MoverType moverType, Vec3 vec3) {
        super.move(moverType, vec3);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.SCULK_SHRIEKER_SHRIEK;
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        //super.onHitEntity(entityHitResult);
        if(!level.isClientSide) {
            entityHitResult.getEntity().playSound(SoundEvents.SCULK_SHRIEKER_SHRIEK, 3, 1);
            if(entityHitResult.getEntity() instanceof LivingEntity living) {
                living.hurt(DamageSource.MAGIC, DDConfig.TRANSMITTER_DAMAGE.get().floatValue());
                if(living.getHealth() <= 0) {
                    living.skipDropExperience();
                    if(getOwner() instanceof Player player) {
                        player.giveExperiencePoints(living.getExperienceReward());
                    }
                }
            }

            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        if(!level.isClientSide) {
            this.discard();
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(Items.AIR);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean shouldRenderAtSqrDistance(double distance) {
        return true;
    }
}
