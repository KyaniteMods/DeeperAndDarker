package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.items.*;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

public class DDBlockItems {
    public static final Item ECHO_SIGN = DDItems.register("echo_sign", new SignItem(new Item.Properties().stacksTo(16), DDBlocks.ECHO_SIGN, DDBlocks.ECHO_WALL_SIGN));
    public static final Item ECHO_HANGING_SIGN = DDItems.register("echo_hanging_sign", new HangingSignItem(DDBlocks.ECHO_HANGING_SIGN, DDBlocks.ECHO_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item BLOOM_SIGN = DDItems.register("bloom_sign", new SignItem(new Item.Properties().stacksTo(16), DDBlocks.BLOOM_SIGN, DDBlocks.BLOOM_WALL_SIGN));
    public static final Item BLOOM_HANGING_SIGN = DDItems.register("bloom_hanging_sign", new HangingSignItem(DDBlocks.BLOOM_HANGING_SIGN, DDBlocks.BLOOM_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item SCULK_SPRUCE_SIGN = DDItems.register("sculk_spruce_sign", new SignItem(new Item.Properties().stacksTo(16), DDBlocks.SCULK_SPRUCE_SIGN, DDBlocks.SCULK_SPRUCE_WALL_SIGN));
    public static final Item SCULK_SPRUCE_HANGING_SIGN = DDItems.register("sculk_spruce_hanging_sign", new HangingSignItem(DDBlocks.SCULK_SPRUCE_HANGING_SIGN, DDBlocks.SCULK_SPRUCE_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));

    public static final Item BLOOM_BERRIES = DDItems.register("bloom_berries", new ItemNameBlockItem(DDBlocks.GLOWING_VINES, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).effect(new MobEffectInstance(MobEffects.GLOWING, 100, 0), 0.8f).build())));
    public static final Item SCULK_BERRY_SPROUT = DDItems.register("sculk_berry_sprout", new ItemNameBlockItem(DDBlocks.SCULK_BERRY, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build())));

    public static final Item SHATTERED_HEAD = DDItems.register("shattered_head", new StandingAndWallBlockItem(DDBlocks.SHATTERED_HEAD, DDBlocks.SHATTERED_WALL_HEAD, new Item.Properties().rarity(Rarity.UNCOMMON), Direction.DOWN));

    public static final Item SCULK_TORCH = DDItems.register("sculk_torch", new StandingAndWallBlockItem(DDBlocks.SCULK_TORCH, DDBlocks.SCULK_WALL_TORCH, new Item.Properties(), Direction.DOWN));

    public static final Item PATIENCE_SOUL = DDItems.register("patience_soul", new PatienceSoulItem(DDBlocks.PATIENCE_SOUL_FIRE, new Item.Properties().rarity(Rarity.RARE).fireResistant(), DDParticleTypes.PATIENCE_SOUL));
    public static final Item FORTITUDE_SOUL = DDItems.register("fortitude_soul", new FortitudeSoulItem(DDBlocks.FORTITUDE_SOUL_FIRE, new Item.Properties().rarity(Rarity.RARE).fireResistant(), DDParticleTypes.FORTITUDE_SOUL));
    public static final Item CORRUPTION_SOUL = DDItems.register("corruption_soul", new CorruptionSoulItem(DDBlocks.CORRUPTION_SOUL_FIRE, new Item.Properties().rarity(Rarity.RARE).fireResistant(), DDParticleTypes.CORRUPTION_SOUL));
    public static final Item PURITY_SOUL = DDItems.register("purity_soul", new PuritySoulItem(DDBlocks.PURITY_SOUL_FIRE, new Item.Properties().rarity(Rarity.RARE).fireResistant(), DDParticleTypes.PURITY_SOUL));
    public static final Item VIRTUE_SOUL = DDItems.register("virtue_soul", new VirtueSoulItem(DDBlocks.VIRTUE_SOUL_FIRE, new Item.Properties().rarity(Rarity.RARE).fireResistant(), DDParticleTypes.VIRTUE_SOUL));

    public static final Item ICE_LILY = DDItems.register("ice_lily", new IceLilyItem(DDBlocks.ICE_LILY, new Item.Properties()));
    public static final Item LILY_FLOWER = DDItems.register("lily_flower", new LilyFlowerItem(DDBlocks.LILY_FLOWER, new Item.Properties()));

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering block items");
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.ECHO_SAPLING.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.ECHO_LEAVES.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.GLOWING_FLOWERS.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.GLOWING_ROOTS.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(BLOOM_BERRIES, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.SCULK_TENDRILS.asItem(), 0.5f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.GLOWING_GRASS.asItem(), 0.5f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.SCULK_VINES.asItem(), 0.5f);
    }
}
