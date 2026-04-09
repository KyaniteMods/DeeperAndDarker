package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.content.DDEffects;
import com.kyanite.deeperdarker.content.entities.DDMobType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public class VirtueSoulItem extends SoulItem implements ShieldAugmentItem {
    private final Multimap<Attribute, AttributeModifier> augmentModifiers;

    public VirtueSoulItem(Block block, Properties properties, ParticleOptions particle) {
        super(block, properties, particle);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier("Augment modifier", 0.05, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR, new AttributeModifier("Augment modifier", 2.0, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier("Augment modifier", 2.0, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.LUCK, new AttributeModifier("Augment modifier", 1.0, AttributeModifier.Operation.ADDITION));
        augmentModifiers = builder.build();
    }

    @Override
    public void onShieldDefended(LivingEntity entity, DamageSource source, float amount) {
        if (source.getDirectEntity() instanceof Mob mob && mob.getMobType() == DDMobType.SCULK) {
            mob.hurt(entity.damageSources().thorns(entity), 4);
        }
        entity.heal(1.0f);
    }

    @Override
    public Optional<Multimap<Attribute, AttributeModifier>> getAugmentAttributeModifiers(EquipmentSlot equipmentSlot, boolean defending) {
        return equipmentSlot == EquipmentSlot.OFFHAND ? Optional.of(augmentModifiers) : Optional.empty();
    }

    @Override
    public void onAugmentAdded(ItemStack shield, ItemStack previousStack, Slot slot, Player player) {
    }

    @Override
    public void onAugmentRemoved(ItemStack shield, Slot slot, Player player) {

    }

    @Override
    public void augmentTick(ItemStack shield, Level level, Entity entity, int index, boolean selected) {
        if (entity instanceof LivingEntity livingEntity && level.getGameTime() % 80L == 0L) {
            livingEntity.addEffect(new MobEffectInstance(DDEffects.PURITY, 210, 0, false, false, true));
        }
    }
}
