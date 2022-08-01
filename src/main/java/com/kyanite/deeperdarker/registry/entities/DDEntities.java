package com.kyanite.deeperdarker.registry.entities;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<EntityType<SculkWormEntity>> SCULK_WORM = ENTITY_TYPES.register("shriek_worm",
            () -> EntityType.Builder.of(SculkWormEntity::new, MobCategory.MISC).sized(0.8F, 10).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "shriek_worm").toString()));
}
