package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class DDDamageTypes {
    public static final ResourceKey<DamageType> BITE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, "bite"));
    public static final ResourceKey<DamageType> RING = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, "ring"));
}
