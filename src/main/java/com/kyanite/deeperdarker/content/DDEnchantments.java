package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.misc.CatalyzeEnvironment;
import com.kyanite.deeperdarker.util.DDTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.EntityTypePredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDEnchantments {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENCHANTMENT_EFFECTS = DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, DeeperDarker.MOD_ID);
    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<CatalyzeEnvironment>> CATALYZE_ENVIRONMENT = ENCHANTMENT_EFFECTS.register("catalyze_environment", () -> CatalyzeEnvironment.CODEC);

    public static final ResourceKey<Enchantment> CATALYSIS = create("catalysis");
    public static final ResourceKey<Enchantment> SCULK_SMITE = create("sculk_smite");
    public static final ResourceKey<Enchantment> VOLUME = create("volume");
    public static final ResourceKey<Enchantment> REVERBERATION = create("reverberation");

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<Item> items = context.lookup(Registries.ITEM);
        HolderGetter<Enchantment> enchantments = context.lookup(Registries.ENCHANTMENT);

        context.register(CATALYSIS, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE), items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE),
                        4, 3,
                        Enchantment.dynamicCost(10, 20), Enchantment.dynamicCost(15, 30), 3,
                        EquipmentSlotGroup.MAINHAND
                ))
                .withEffect(
                        EnchantmentEffectComponents.POST_ATTACK,
                        EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM,
                        new CatalyzeEnvironment(false)
                ).build(CATALYSIS.identifier())
        );

        context.register(SCULK_SMITE, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE), items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE),
                        5, 5,
                        Enchantment.dynamicCost(5, 8), Enchantment.dynamicCost(25, 8), 2,
                        EquipmentSlotGroup.MAINHAND
                ))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.DAMAGE,
                        new AddValue(LevelBasedValue.perLevel(2.5f)),
                        LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(context.lookup(Registries.ENTITY_TYPE), DDTags.Misc.SENSITIVE_TO_SCULK_SMITE)))
                ).build(SCULK_SMITE.identifier())
        );

        context.register(VOLUME, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(DDTags.Items.SONIC_WEAPON),
                        5, 4,
                        Enchantment.dynamicCost(10, 9), Enchantment.dynamicCost(45, 9), 3,
                        EquipmentSlotGroup.MAINHAND
                )).build(VOLUME.identifier())
        );

        context.register(REVERBERATION, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(DDTags.Items.SONIC_WEAPON),
                        2, 3,
                        Enchantment.dynamicCost(10, 8), Enchantment.dynamicCost(25, 8), 2,
                        EquipmentSlotGroup.MAINHAND
                )).build(REVERBERATION.identifier())
        );
    }

    private static ResourceKey<Enchantment> create(String name) {
        return ResourceKey.create(Registries.ENCHANTMENT, DeeperDarker.rl(name));
    }
}
