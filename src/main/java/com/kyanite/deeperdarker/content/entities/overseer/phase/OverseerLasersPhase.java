package com.kyanite.deeperdarker.content.entities.overseer.phase;

import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.kyanite.deeperdarker.content.entities.overseer.OverseerLaser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.UUIDUtil;
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
    private static final UUID ARMOR_ATTRIBUTE_MODIFIER_UUID = UUID.fromString("9b42b41c-32df-4880-9ce8-5374a175dc35");
    private static final AttributeModifier ARMOR_ATTRIBUTE_MODIFIER = new AttributeModifier(ARMOR_ATTRIBUTE_MODIFIER_UUID, "Overseer lasers armor", 10000, AttributeModifier.Operation.ADDITION);
    private static final UUID ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_UUID = UUID.fromString("8fa4349e-f9f4-4f40-b2a4-15279cd00493");
    private static final AttributeModifier ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER = new AttributeModifier(ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_UUID, "Overseer lasers armor toughness", 10000, AttributeModifier.Operation.ADDITION);

    public static final Codec<OverseerLasersPhase> CODEC = RecordCodecBuilder.create(instance -> instance.group(
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
        this.laserListUUID = laserListUUID;
    }

    public OverseerLasersPhase(int lasers, int idleTime) {
        this.lasers = lasers;
        this.idleTime = idleTime;
        this.ticksLeft = idleTime;
    }

    @Override
    public void start(Overseer boss) {
        AttributeInstance armor = boss.getAttribute(Attributes.ARMOR);
        if (armor != null) {
            armor.removePermanentModifier(ARMOR_ATTRIBUTE_MODIFIER_UUID);
            armor.addPermanentModifier(ARMOR_ATTRIBUTE_MODIFIER);
        }
        AttributeInstance armorToughness = boss.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (armorToughness != null) {
            armorToughness.removePermanentModifier(ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_UUID);
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
            armor.removePermanentModifier(ARMOR_ATTRIBUTE_MODIFIER_UUID);
        }
        AttributeInstance armorToughness = boss.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (armorToughness != null) {
            armorToughness.removePermanentModifier(ARMOR_TOUGHNESS_ATTRIBUTE_MODIFIER_UUID);
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
    public Codec<? extends OverseerPhase> codec() {
        return CODEC;
    }

    @Override
    public OverseerPhaseType getType() {
        return OverseerPhaseType.LASERS;
    }
}
