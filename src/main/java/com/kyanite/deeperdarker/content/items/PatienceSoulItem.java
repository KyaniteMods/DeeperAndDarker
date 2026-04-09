package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.Multimap;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public class PatienceSoulItem extends SoulItem implements ShieldAugmentItem {
    public PatienceSoulItem(Block block, Properties properties, ParticleOptions particle) {
        super(block, properties, particle);
    }

    @Override
    public void onShieldDefended(LivingEntity entity, DamageSource source, float amount) {
        if (!entity.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1));
        }
    }

    @Override
    public Optional<Multimap<Attribute, AttributeModifier>> getAugmentAttributeModifiers(EquipmentSlot equipmentSlot, boolean defending) {
        return Optional.empty();
    }

    @Override
    public void onAugmentAdded(ItemStack shield, ItemStack previousStack, Slot slot, Player player) {

    }

    @Override
    public void onAugmentRemoved(ItemStack shield, Slot slot, Player player) {

    }
}
