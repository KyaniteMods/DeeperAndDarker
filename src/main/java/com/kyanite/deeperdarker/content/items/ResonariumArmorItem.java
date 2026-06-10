package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;

@SuppressWarnings("NullableProblems")
public class ResonariumArmorItem extends Item {
    public ResonariumArmorItem(Properties properties, ArmorMaterial material, ArmorType type) {
        super(humanoidArmor(properties, material, type));
    }

    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return super.supportsEnchantment(stack, enchantment) && !enchantment.is(DDTags.Misc.RESONARIUM_EXCLUDES);
    }

    private static Item.Properties humanoidArmor(Item.Properties properties, ArmorMaterial material, ArmorType type) {
        return properties.durability(type.getDurability(material.durability()))
                .attributes(material.createAttributes(type))
                .component(DataComponents.EQUIPPABLE, Equippable.builder(type.getSlot()).setEquipSound(material.equipSound()).setAsset(material.assetId()).build())
                .repairable(material.repairIngredient());
    }
}
