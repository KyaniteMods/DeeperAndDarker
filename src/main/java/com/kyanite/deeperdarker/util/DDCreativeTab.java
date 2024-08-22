package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;

public class DDCreativeTab {
    private static final CreativeModeTab.Builder ITEM_GROUP_BUILDER = FabricItemGroup.builder().title(Component.translatable("itemGroup.deeperdarker")).icon(() -> new ItemStack(DDItems.WARDEN_SWORD)).displayItems(((displayContext, entries) -> {
        entries.accept(DDBlocks.ECHO_LOG);
        entries.accept(DDBlocks.ECHO_WOOD);
        entries.accept(DDBlocks.STRIPPED_ECHO_LOG);
        entries.accept(DDBlocks.STRIPPED_ECHO_WOOD);
        entries.accept(DDBlocks.ECHO_PLANKS);
        entries.accept(DDBlocks.ECHO_STAIRS);
        entries.accept(DDBlocks.ECHO_SLAB);
        entries.accept(DDBlocks.ECHO_FENCE);
        entries.accept(DDBlocks.ECHO_FENCE_GATE);
        entries.accept(DDBlocks.ECHO_DOOR);
        entries.accept(DDBlocks.ECHO_TRAPDOOR);
        entries.accept(DDBlocks.ECHO_PRESSURE_PLATE);
        entries.accept(DDBlocks.ECHO_BUTTON);

        entries.accept(DDBlocks.BLOOMING_STEM);
        entries.accept(DDBlocks.STRIPPED_BLOOMING_STEM);
        entries.accept(DDBlocks.BLOOM_PLANKS);
        entries.accept(DDBlocks.BLOOM_STAIRS);
        entries.accept(DDBlocks.BLOOM_SLAB);
        entries.accept(DDBlocks.BLOOM_FENCE);
        entries.accept(DDBlocks.BLOOM_FENCE_GATE);
        entries.accept(DDBlocks.BLOOM_DOOR);
        entries.accept(DDBlocks.BLOOM_TRAPDOOR);
        entries.accept(DDBlocks.BLOOM_PRESSURE_PLATE);
        entries.accept(DDBlocks.BLOOM_BUTTON);

        entries.accept(DDBlocks.SCULK_STONE);
        entries.accept(DDBlocks.SCULK_STONE_STAIRS);
        entries.accept(DDBlocks.SCULK_STONE_SLAB);
        entries.accept(DDBlocks.SCULK_STONE_WALL);
        entries.accept(DDBlocks.COBBLED_SCULK_STONE);
        entries.accept(DDBlocks.COBBLED_SCULK_STONE_STAIRS);
        entries.accept(DDBlocks.COBBLED_SCULK_STONE_SLAB);
        entries.accept(DDBlocks.COBBLED_SCULK_STONE_WALL);
        entries.accept(DDBlocks.POLISHED_SCULK_STONE);
        entries.accept(DDBlocks.POLISHED_SCULK_STONE_STAIRS);
        entries.accept(DDBlocks.POLISHED_SCULK_STONE_SLAB);
        entries.accept(DDBlocks.POLISHED_SCULK_STONE_WALL);
        entries.accept(DDBlocks.SCULK_STONE_BRICKS);
        entries.accept(DDBlocks.SCULK_STONE_BRICK_STAIRS);
        entries.accept(DDBlocks.SCULK_STONE_BRICK_SLAB);
        entries.accept(DDBlocks.SCULK_STONE_BRICK_WALL);
        entries.accept(DDBlocks.SCULK_STONE_TILES);
        entries.accept(DDBlocks.SCULK_STONE_TILE_STAIRS);
        entries.accept(DDBlocks.SCULK_STONE_TILE_SLAB);
        entries.accept(DDBlocks.SCULK_STONE_TILE_WALL);
        entries.accept(DDBlocks.SMOOTH_SCULK_STONE);
        entries.accept(DDBlocks.SMOOTH_SCULK_STONE_STAIRS);
        entries.accept(DDBlocks.SMOOTH_SCULK_STONE_SLAB);
        entries.accept(DDBlocks.SMOOTH_SCULK_STONE_WALL);
        entries.accept(DDBlocks.CUT_SCULK_STONE);
        entries.accept(DDBlocks.CUT_SCULK_STONE_STAIRS);
        entries.accept(DDBlocks.CUT_SCULK_STONE_SLAB);
        entries.accept(DDBlocks.CUT_SCULK_STONE_WALL);
        entries.accept(DDBlocks.CHISELED_SCULK_STONE);

        entries.accept(DDBlocks.SCULK_GRIME);
        entries.accept(DDBlocks.SCULK_GRIME_BRICKS);
        entries.accept(DDBlocks.SCULK_GRIME_BRICK_STAIRS);
        entries.accept(DDBlocks.SCULK_GRIME_BRICK_SLAB);
        entries.accept(DDBlocks.SCULK_GRIME_BRICK_WALL);
        entries.accept(DDBlocks.BLOOMING_SCULK_STONE);
        entries.accept(DDBlocks.BLOOMING_MOSS_BLOCK);
        entries.accept(DDBlocks.ECHO_SOIL);

        entries.accept(DDBlocks.GLOOMSLATE);
        entries.accept(DDBlocks.GLOOMSLATE_STAIRS);
        entries.accept(DDBlocks.GLOOMSLATE_SLAB);
        entries.accept(DDBlocks.GLOOMSLATE_WALL);
        entries.accept(DDBlocks.COBBLED_GLOOMSLATE);
        entries.accept(DDBlocks.COBBLED_GLOOMSLATE_STAIRS);
        entries.accept(DDBlocks.COBBLED_GLOOMSLATE_SLAB);
        entries.accept(DDBlocks.COBBLED_GLOOMSLATE_WALL);
        entries.accept(DDBlocks.POLISHED_GLOOMSLATE);
        entries.accept(DDBlocks.POLISHED_GLOOMSLATE_STAIRS);
        entries.accept(DDBlocks.POLISHED_GLOOMSLATE_SLAB);
        entries.accept(DDBlocks.POLISHED_GLOOMSLATE_WALL);
        entries.accept(DDBlocks.GLOOMSLATE_BRICKS);
        entries.accept(DDBlocks.GLOOMSLATE_BRICK_STAIRS);
        entries.accept(DDBlocks.GLOOMSLATE_BRICK_SLAB);
        entries.accept(DDBlocks.GLOOMSLATE_BRICK_WALL);
        entries.accept(DDBlocks.GLOOMSLATE_TILES);
        entries.accept(DDBlocks.GLOOMSLATE_TILE_STAIRS);
        entries.accept(DDBlocks.GLOOMSLATE_TILE_SLAB);
        entries.accept(DDBlocks.GLOOMSLATE_TILE_WALL);
        entries.accept(DDBlocks.SMOOTH_GLOOMSLATE);
        entries.accept(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS);
        entries.accept(DDBlocks.SMOOTH_GLOOMSLATE_SLAB);
        entries.accept(DDBlocks.SMOOTH_GLOOMSLATE_WALL);
        entries.accept(DDBlocks.CUT_GLOOMSLATE);
        entries.accept(DDBlocks.CUT_GLOOMSLATE_STAIRS);
        entries.accept(DDBlocks.CUT_GLOOMSLATE_SLAB);
        entries.accept(DDBlocks.CUT_GLOOMSLATE_WALL);
        entries.accept(DDBlocks.CHISELED_GLOOMSLATE);

        entries.accept(DDBlocks.GLOOMY_SCULK);
        entries.accept(DDBlocks.GLOOMY_GEYSER);
        entries.accept(DDBlocks.CRYSTALLIZED_AMBER);
        entries.accept(DDBlocks.SCULK_GLEAM);
        entries.accept(DDBlocks.SOUNDPROOF_GLASS);

        entries.accept(DDBlocks.SCULK_STONE_COAL_ORE);
        entries.accept(DDBlocks.SCULK_STONE_IRON_ORE);
        entries.accept(DDBlocks.SCULK_STONE_COPPER_ORE);
        entries.accept(DDBlocks.SCULK_STONE_GOLD_ORE);
        entries.accept(DDBlocks.SCULK_STONE_REDSTONE_ORE);
        entries.accept(DDBlocks.SCULK_STONE_EMERALD_ORE);
        entries.accept(DDBlocks.SCULK_STONE_LAPIS_ORE);
        entries.accept(DDBlocks.SCULK_STONE_DIAMOND_ORE);
        entries.accept(DDBlocks.GLOOMSLATE_COAL_ORE);
        entries.accept(DDBlocks.GLOOMSLATE_IRON_ORE);
        entries.accept(DDBlocks.GLOOMSLATE_COPPER_ORE);
        entries.accept(DDBlocks.GLOOMSLATE_GOLD_ORE);
        entries.accept(DDBlocks.GLOOMSLATE_REDSTONE_ORE);
        entries.accept(DDBlocks.GLOOMSLATE_EMERALD_ORE);
        entries.accept(DDBlocks.GLOOMSLATE_LAPIS_ORE);
        entries.accept(DDBlocks.GLOOMSLATE_DIAMOND_ORE);

        entries.accept(DDBlocks.ECHO_LEAVES);
        entries.accept(DDBlocks.ECHO_SAPLING);
        entries.accept(DDBlocks.GLOWING_FLOWERS);
        entries.accept(DDBlocks.GLOWING_GRASS);
        entries.accept(DDBlocks.GLOOMY_GRASS);
        entries.accept(DDBlocks.GLOOMY_CACTUS);
        entries.accept(DDBlocks.SCULK_TENDRILS);
        entries.accept(DDBlocks.SCULK_VINES);
        entries.accept(DDBlocks.GLOWING_ROOTS);
        entries.accept(DDItems.ICE_LILY);
        entries.accept(DDItems.LILY_FLOWER);

        entries.accept(DDItems.ECHO_SIGN);
        entries.accept(DDItems.ECHO_HANGING_SIGN);
        entries.accept(DDItems.BLOOM_SIGN);
        entries.accept(DDItems.BLOOM_HANGING_SIGN);

        entries.accept(DDBlocks.ANCIENT_VASE);
        entries.accept(DDBlocks.INFESTED_SCULK);
        entries.accept(DDBlocks.SCULK_JAW);

        entries.accept(DDItems.BLOOM_BERRIES);

        entries.accept(DDItems.GRIME_BALL);
        entries.accept(DDItems.GRIME_BRICK);

        entries.accept(DDItems.SOUL_ELYTRA);
        entries.accept(DDItems.ECHO_BOAT);
        entries.accept(DDItems.ECHO_CHEST_BOAT);
        entries.accept(DDItems.BLOOM_BOAT);
        entries.accept(DDItems.BLOOM_CHEST_BOAT);

        entries.accept(DDItems.RESONARIUM_SHOVEL);
        entries.accept(DDItems.RESONARIUM_PICKAXE);
        entries.accept(DDItems.RESONARIUM_AXE);
        entries.accept(DDItems.RESONARIUM_HOE);
        entries.accept(DDItems.RESONARIUM_SWORD);
        entries.accept(DDItems.RESONARIUM_HELMET);
        entries.accept(DDItems.RESONARIUM_CHESTPLATE);
        entries.accept(DDItems.RESONARIUM_LEGGINGS);
        entries.accept(DDItems.RESONARIUM_BOOTS);

        entries.accept(DDItems.WARDEN_SHOVEL);
        entries.accept(DDItems.WARDEN_PICKAXE);
        entries.accept(DDItems.WARDEN_AXE);
        entries.accept(DDItems.WARDEN_HOE);
        entries.accept(DDItems.WARDEN_SWORD);
        entries.accept(DDItems.WARDEN_HELMET);
        entries.accept(DDItems.WARDEN_CHESTPLATE);
        entries.accept(DDItems.WARDEN_LEGGINGS);
        entries.accept(DDItems.WARDEN_BOOTS);

        entries.accept(DDItems.SCULK_BONE);
        entries.accept(DDItems.SOUL_DUST);
        entries.accept(DDItems.SOUL_CRYSTAL);
        entries.accept(DDItems.RESONARIUM);
        entries.accept(DDItems.RESONARIUM_PLATE);
        entries.accept(DDItems.HEART_OF_THE_DEEP);
        entries.accept(DDItems.WARDEN_CARAPACE);
        entries.accept(DDItems.REINFORCED_ECHO_SHARD);

        entries.accept(DDItems.SCULK_TRANSMITTER);
        entries.accept(DDItems.SONOROUS_STAFF);
        entries.accept(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE);

        entries.accept(DDItems.ANGLER_FISH_SPAWN_EGG);
        entries.accept(DDItems.SCULK_CENTIPEDE_SPAWN_EGG);
        entries.accept(DDItems.SCULK_LEECH_SPAWN_EGG);
        entries.accept(DDItems.SCULK_SNAPPER_SPAWN_EGG);
        entries.accept(DDItems.SHATTERED_SPAWN_EGG);
        entries.accept(DDItems.SHRIEK_WORM_SPAWN_EGG);
        entries.accept(DDItems.SLUDGE_SPAWN_EGG);
        entries.accept(DDItems.STALKER_SPAWN_EGG);
        displayContext.holders().lookupOrThrow(Registries.PAINTING_VARIANT).get(DDTags.Paintings.ANCIENT).ifPresent(holders -> {
            for (Holder<PaintingVariant> holder : holders) {
                CustomData customData = CustomData.EMPTY.update(displayContext.holders().createSerializationContext(NbtOps.INSTANCE), Painting.VARIANT_MAP_CODEC, holder).getOrThrow().update(compoundTag -> compoundTag.putString("id", "minecraft:painting"));
                ItemStack itemStack = new ItemStack(Items.PAINTING);
                itemStack.set(DataComponents.ENTITY_DATA, customData);
                entries.accept(itemStack);
            }
        });
//        entries.accept(DDItems.SHATTERED_HEAD);
    }));

    public static CreativeModeTab DEEPER_AND_DARKER;

    public static void init() {
        DEEPER_AND_DARKER = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, DeeperDarker.rl("deeper_and_darker"), ITEM_GROUP_BUILDER.build());
        DeeperDarker.LOGGER.debug("Registering creative tab");
    }
}
