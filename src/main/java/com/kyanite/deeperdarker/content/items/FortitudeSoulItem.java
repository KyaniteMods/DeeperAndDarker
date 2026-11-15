package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public class FortitudeSoulItem extends SoulItem implements ShieldAugmentItem {
    public static final ResourceLocation FORTITUDE_SOUL_MOVEMENT_SPEED_ID = DeeperDarker.id("fortitude_soul.movement_speed");
    private final Multimap<Holder<Attribute>, AttributeModifier> augmentModifiers;

    public FortitudeSoulItem(Block block, Properties properties, ParticleOptions particle) {
        super(block, properties, particle);
        ImmutableMultimap.Builder<Holder<Attribute>, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(FORTITUDE_SOUL_MOVEMENT_SPEED_ID, 0.1, AttributeModifier.Operation.ADD_VALUE));
        augmentModifiers = builder.build();
    }

    @Override
    public void onShieldDefended(LivingEntity entity, DamageSource source, float amount) {

    }

    @Override
    public Optional<Multimap<Holder<Attribute>, AttributeModifier>> getAugmentAttributeModifiers(EquipmentSlot equipmentSlot, boolean defending) {
        return (equipmentSlot == EquipmentSlot.OFFHAND && defending) ? Optional.of(augmentModifiers) : Optional.empty();
    }

    @Override
    public void onAugmentAdded(ItemStack shield, ItemStack previousStack, Slot slot, Player player) {
    }

    @Override
    public void onAugmentRemoved(ItemStack shield, Slot slot, Player player) {
    }

    @Override
    public void augmentTick(ItemStack shield, Level level, Entity entity, int index, boolean selected) {

    }
}
