package com.kyanite.deeperdarker.client;

import com.google.common.collect.Sets;
import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import java.util.Set;

public class DDModelLayers {
    private static final String MAIN = "main";
    private static final Set<ModelLayerLocation> LAYERS = Sets.newHashSet();

    public static final ModelLayerLocation WARDEN_HELMET = registerMain("warden_helmet");
    public static final ModelLayerLocation ECHO_BOAT = createBoat("echo");
    public static final ModelLayerLocation ECHO_CHEST_BOAT = createChestBoat("echo");
    public static final ModelLayerLocation SCULK_SNAPPER = registerMain("sculk_snapper");
    public static final ModelLayerLocation SHATTERED = registerMain("shattered");
    public static final ModelLayerLocation SCULK_LEECH = registerMain("sculk_leech");
    public static final ModelLayerLocation SHRIEK_WORM = registerMain("shriek_worm");
    public static final ModelLayerLocation STALKER = registerMain("stalker");

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
}