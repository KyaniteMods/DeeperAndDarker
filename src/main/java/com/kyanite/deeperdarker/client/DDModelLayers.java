package com.kyanite.deeperdarker.client;

import com.google.common.collect.Sets;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import java.util.Set;

public class DDModelLayers {
    private static final String MAIN = "main";
    private static final Set<ModelLayerLocation> LAYERS = Sets.newHashSet();

    public static ModelLayerLocation WARDEN_HELMET;
    public static ModelLayerLocation ECHO_BOAT;
    public static ModelLayerLocation ECHO_CHEST_BOAT;
    public static ModelLayerLocation BLOOM_BOAT;
    public static ModelLayerLocation BLOOM_CHEST_BOAT;
    public static ModelLayerLocation SCULK_SNAPPER;
    public static ModelLayerLocation SHATTERED;
    public static ModelLayerLocation SCULK_LEECH;
    public static ModelLayerLocation SHRIEK_WORM;
    public static ModelLayerLocation STALKER;
    public static ModelLayerLocation SCULK_CENTIPEDE;

    private static ModelLayerLocation registerMain(String id) {
        return register(id, "main");
    }

    private static ModelLayerLocation register(String id, String layer) {
        ModelLayerLocation entityModelLayer = create(id, layer);
        if (!LAYERS.add(entityModelLayer)) {
            throw new IllegalStateException("Duplicate registration for " + entityModelLayer);
        } else {
            return entityModelLayer;
        }
    }

    private static ModelLayerLocation create(String id, String layer) {
        return new ModelLayerLocation(new ResourceLocation(DeeperDarker.MOD_ID, id), layer);
    }

    public static ModelLayerLocation createBoat(String type) {
        return create("boat/" + type, MAIN);
    }

    public static ModelLayerLocation createChestBoat(String type) {
        return create("chest_boat/" + type, MAIN);
    }

    public static void init() {
        DeeperDarker.LOGGER.info("Initializing model layers");
        WARDEN_HELMET = registerMain("warden_helmet");
        ECHO_BOAT = createBoat(new ResourceLocation(DDBlocks.ECHO.name()).getPath());
        ECHO_CHEST_BOAT = createChestBoat(new ResourceLocation(DDBlocks.ECHO.name()).getPath());
        BLOOM_BOAT = createBoat(new ResourceLocation(DDBlocks.BLOOM.name()).getPath());
        BLOOM_CHEST_BOAT = createChestBoat(new ResourceLocation(DDBlocks.BLOOM.name()).getPath());
        SCULK_SNAPPER = registerMain("sculk_snapper");
        SHATTERED = registerMain("shattered");
        SCULK_LEECH = registerMain("sculk_leech");
        SHRIEK_WORM = registerMain("shriek_worm");
        STALKER = registerMain("stalker");
        SCULK_CENTIPEDE = registerMain("sculk_centipede");
    }
}