package com.kyanite.deeperdarker.fabric;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.potions.DDPotions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.HashMap;
import java.util.Map;

public class DeeperAndDarkerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        DeeperAndDarker.init();
        Map<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> attributes = new HashMap<>();
        DeeperAndDarker.attributes(attributes);
        attributes.forEach(FabricDefaultAttributeRegistry::register);

        ComposterBlock.COMPOSTABLES.put(DDBlocks.ECHO_LEAVES.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_GLEAM.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_VINES.get().asItem(), 0.5f);
        PotionBrewing.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.SCULK_AFFINITY.get());
        SpawnPlacements.register(DDEntities.SCULK_SNAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(DDEntities.SHATTERED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }
}