package com.kyanite.deeperdarker.fabric;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDCreativeModeTab;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.GenerationStep;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

import java.util.HashMap;
import java.util.Map;

public class DeeperAndDarkerFabric implements ModInitializer {
    public static OthersidePortalBlock PORTAL_BLOCK = new OthersidePortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).lightLevel(state -> 5).noLootTable());
    public static Item HEART = new Item(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).stacksTo(1).rarity(Rarity.EPIC).fireResistant());

    @Override
    public void onInitialize() {
        DeeperAndDarker.init(() -> {
            Map<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> attributes = new HashMap<>();
            DeeperAndDarker.attributes(attributes);
            attributes.forEach(FabricDefaultAttributeRegistry::register);
            DeeperAndDarker.spawnPlacements();

            CustomPortalBuilder.beginPortal()
                    .frameBlock(Blocks.REINFORCED_DEEPSLATE)
                    .customIgnitionSource(PortalIgnitionSource.ItemUseSource(DDItems.HEART_OF_THE_DEEP.get()))
                    .destDimID(new ResourceLocation(DeeperAndDarker.MOD_ID, "otherside"))
                    .tintColor(5, 98, 93)
                    .customPortalBlock(PORTAL_BLOCK)
                    .forcedSize(20, 6)
                    .registerPortal();

            GeckoLibMod.DISABLE_IN_DEV = true;
            GeckoLib.initialize();

            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(Biomes.DEEP_DARK),
                    GenerationStep.Decoration.VEGETAL_DECORATION,
                    ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, "sculk_tendrils")));

            ComposterBlock.COMPOSTABLES.put(DDBlocks.ECHO_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_VINES.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_TENDRILS.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_GLEAM.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.GLOOM_SCULK.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.GLOOM_CACTUS.get().asItem(), 0.4f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.GLOOMY_GRASS.get().asItem(), 0.2f);
        });
    }
}
