package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SculkMillipede extends Floater {
    private ServerBossEvent bossEvent = (ServerBossEvent) new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);

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
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        bossEvent.setName(getDisplayName());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        bossEvent.setProgress(getTotalHealth() / getTotalMaxHealth());
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        bossEvent.removePlayer(serverPlayer);
    }

    protected void updateBossEvent() {
        if (level() instanceof ServerLevel serverLevel) {
            Set<ServerPlayer> set = new HashSet<>(bossEvent.getPlayers());
            List<ServerPlayer> list = serverLevel.players();

            if (getWormHead() == this) {
                for (ServerPlayer player : list) {
                    if (!set.contains(player)) {
                        bossEvent.addPlayer(player);
                    }
                }

                for (ServerPlayer player : set) {
                    if (!list.contains(player)) {
                        bossEvent.removePlayer(player);
                    }
                }
            } else {
                bossEvent.removeAllPlayers();
            }
        }
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource damageSource, int i, boolean bl) {
        super.dropCustomDeathLoot(damageSource, i, bl);
        if (isLastRemaining()) {
            spawnAtLocation(DDItems.VIRTUE_SOUL);
        }
    }

    @Override
    public void remove(RemovalReason removalReason, Floater oldHead, @Nullable Floater newHead) {
        super.remove(removalReason, oldHead, newHead);

        if (level().isClientSide()) return;

        if (oldHead == this && newHead instanceof SculkMillipede sculkMillipede && oldHead != newHead) {
            sculkMillipede.bossEvent = bossEvent;
        } else {
            bossEvent.setVisible(false);
            bossEvent.removeAllPlayers();
        }
    }

    @Override
    public void tick() {
        super.tick();
        updateBossEvent();
        level().getEntities(this, getBoundingBox().deflate(0.2), entity -> entity instanceof Player).forEach(this::doHurtTarget);
    }
}
