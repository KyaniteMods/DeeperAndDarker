package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDConfig;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class SoulElytraItem extends ElytraItem implements FabricElytraItem {
    private final Multimap<Attribute, AttributeModifier> MODIFIERS;

    public SoulElytraItem(Properties pProperties) {
        super(pProperties);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ARMOR, new AttributeModifier("Soul Elytra armor", 3, AttributeModifier.Operation.ADDITION));
        this.MODIFIERS = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.CHEST ? this.MODIFIERS : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(DDItems.SOUL_CRYSTAL);
    }

    @Override
    public void doVanillaElytraTick(LivingEntity entity, ItemStack chestStack) {
        FabricElytraItem.super.doVanillaElytraTick(entity, chestStack);
        if (entity instanceof Player player && player.getCooldowns().getCooldownPercent(this.asItem(), 0.0f) == 0.0f && player.isCrouching()) {
            player.getCooldowns().addCooldown(this.asItem(), DDConfig.HANDLER.instance().soulElytraCooldown);
            player.addDeltaMovement(player.getViewVector(0.0f).multiply(DDConfig.HANDLER.instance().soulElytraBoostStrength, DDConfig.HANDLER.instance().soulElytraBoostStrength, DDConfig.HANDLER.instance().soulElytraBoostStrength));
            if (entity.level().isClientSide()) {
                Vec3 particlePos = player.getPosition(0.0f).add(player.getViewVector(0.0f).reverse());
                entity.level().addParticle(ParticleTypes.SONIC_BOOM, particlePos.x, particlePos.y, particlePos.z, 1.0, 0.0, 0.0);
                particlePos = particlePos.add(player.getViewVector(0.0f).multiply(2.0, 2.0, 2.0).reverse());
                entity.level().addParticle(ParticleTypes.SONIC_BOOM, particlePos.x, particlePos.y, particlePos.z, 1.0, 0.0, 0.0);
            }
        }
    }
}
