package com.kyanite.deeperdarker.world.otherside;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;

public class OthersideBiomes {
    public static final ResourceKey<Biome> DEEPLANDS = createKey("deeplands");
    public static final ResourceKey<Biome> ECHOING_FOREST = createKey("echoing_forest");
    public static final ResourceKey<Biome> OVERCAST_COLUMNS = createKey("overcast_columns");

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
