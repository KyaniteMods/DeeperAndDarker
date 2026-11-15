package com.kyanite.deeperdarker.content.entities.overseer.phase;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.kyanite.deeperdarker.content.entities.overseer.OverseerLaser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.UUIDUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;

import java.util.*;

public class OverseerLasersPhase extends OverseerPhase {
    private static final ResourceLocation ARMOR_ATTRIBUTE_MODIFIER_ID = DeeperDarker.id("overseer.overseer_lasers_armor");
    private static final AttributeModifier ARMOR_ATTRIBUTE_MODIFIER = new AttributeModifier(ARMOR_ATTRIBUTE_MODIFIER_ID, 10000, AttributeModifier.Operation.ADD_VALUE);
    private static final ResourceLocation ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_ID = DeeperDarker.id("overseer.overseer_lasers_armor_toughness");
    private static final AttributeModifier ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER = new AttributeModifier(ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_ID, 10000, AttributeModifier.Operation.ADD_VALUE);

    public static final MapCodec<OverseerLasersPhase> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.INT.fieldOf("lasers").forGetter(phase -> phase.lasers),
            Codec.INT.fieldOf("idle_time").forGetter(phase -> phase.idleTime),
            Codec.INT.fieldOf("ticks_left").forGetter(phase -> phase.ticksLeft),
            UUIDUtil.CODEC.listOf().fieldOf("laser_list").forGetter(phase -> phase.laserListUUID)
    ).apply(instance, OverseerLasersPhase::new));

    private final int lasers;
    private final int idleTime;
    private int ticksLeft;
    private List<UUID> laserListUUID = new ArrayList<>();
    private List<OverseerLaser> laserList = new ArrayList<>();

    protected OverseerLasersPhase(int lasers, int idleTime, int ticksLeft, List<UUID> laserListUUID) {
        this.lasers = lasers;
        this.idleTime = idleTime;
        this.ticksLeft = ticksLeft;
        this.laserListUUID = new ArrayList<>(laserListUUID);
    }

    public OverseerLasersPhase(int lasers, int idleTime) {
        this.lasers = lasers;
        this.idleTime = idleTime;
        this.ticksLeft = idleTime;
    }

    @Override
    public void start(Overseer boss) {
        AttributeInstance armor = boss.getAttribute(Attributes.ARMOR);
        if (armor != null && !armor.hasModifier(ARMOR_ATTRIBUTE_MODIFIER_ID)) {
            armor.addPermanentModifier(ARMOR_ATTRIBUTE_MODIFIER);
        }
        AttributeInstance armorToughness = boss.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (armorToughness != null && !armorToughness.hasModifier(ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_ID)) {
            armorToughness.addPermanentModifier(ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER);
        }

        for (int i = 0; i < lasers; i++) {
            OverseerLaser laser = new OverseerLaser(boss);
            laser.updatePosition(boss);
            laser.setLasers(lasers);
            laser.setLaserIndex(i);
            laser.setRotationSpeed(10.0f);
            boss.level().addFreshEntity(laser);
            laserListUUID.add(laser.getUUID());
        }
    }

    @Override
    public boolean shouldContinue(Overseer overseer) {
        return ticksLeft > 0 && laserListUUID.size() == lasers;
    }

    @Override
    public void end(Overseer boss) {
        updateLaserList(boss);
        for (OverseerLaser laser : laserList) {
            laser.setDespawning();
        }

        AttributeInstance armor = boss.getAttribute(Attributes.ARMOR);
        if (armor != null) {
            armor.removeModifier(ARMOR_ATTRIBUTE_MODIFIER_ID);
        }
        AttributeInstance armorToughness = boss.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (armorToughness != null) {
            armorToughness.removeModifier(ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_ID);
        }
    }

    @Override
    public void tick(Overseer boss) {
        ticksLeft--;
        updateLaserList(boss);
    }

    protected void updateLaserList(Overseer boss) {
        ServerLevel serverLevel = (ServerLevel) boss.level();
        if (laserList.isEmpty()) {
            for (UUID uuid : laserListUUID) {
                Entity entity = serverLevel.getEntity(uuid);
                if (entity instanceof OverseerLaser laser) {
                    laserList.add(laser);
                }
            }
        }
    }

    @Override
    public MapCodec<? extends OverseerPhase> codec() {
        return CODEC;
    }

    @Override
    public OverseerPhaseType getType() {
        return OverseerPhaseType.LASERS;
    }
}
