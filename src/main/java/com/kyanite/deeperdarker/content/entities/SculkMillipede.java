package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SculkMillipede extends Floater {
    public SculkMillipede(EntityType<? extends Vex> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier createSculkMillipedeAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 28.0).add(Attributes.ATTACK_DAMAGE, 12.0).add(Attributes.FOLLOW_RANGE, 64.0).build();
    }

    public static SculkMillipede generateBoss(int size, double x, double y, double z, ServerLevel level) {
        return generateWorm(DDEntities.SCULK_MILLIPEDE, size, x, y, z, level);
    }

    @Override
    public void tick() {
        super.tick();
        level().getEntities(this, getBoundingBox().deflate(0.2), entity -> entity instanceof Player).forEach(this::doHurtTarget);
    }
}
