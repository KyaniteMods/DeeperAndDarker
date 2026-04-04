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
    public static ModelLayerLocation SCULK_SPRUCE_BOAT;
    public static ModelLayerLocation SCULK_SPRUCE_CHEST_BOAT;
    public static ModelLayerLocation ANGLER_FISH;
    public static ModelLayerLocation SCULK_SNAPPER;
    public static ModelLayerLocation SHATTERED;
    public static ModelLayerLocation SCULK_LEECH;
    public static ModelLayerLocation SHRIEK_WORM;
    public static ModelLayerLocation STALKER;
    public static ModelLayerLocation SLUDGE;
    public static ModelLayerLocation SLUDGE_OUTER;
    public static ModelLayerLocation SCULK_CENTIPEDE;
    public static ModelLayerLocation BLOOMING_GOLEM;
    public static ModelLayerLocation POTTY;
    public static ModelLayerLocation POT;
    public static ModelLayerLocation POTTER;
    public static ModelLayerLocation OVERCAST_VESSEL;
    public static ModelLayerLocation ACID_SPRITE;
    public static ModelLayerLocation BUBBLOX;
    public static ModelLayerLocation SHATTERED_HEAD;
    public static ModelLayerLocation SUNGLASSES;
    public static ModelLayerLocation DEAD_MANS_CHEST;
    public static ModelLayerLocation DOUBLE_DEAD_MANS_CHEST_LEFT;
    public static ModelLayerLocation DOUBLE_DEAD_MANS_CHEST_RIGHT;

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
        SCULK_SPRUCE_BOAT = createBoat(new ResourceLocation(DDBlocks.SCULK_SPRUCE.name()).getPath());
        SCULK_SPRUCE_CHEST_BOAT = createChestBoat(new ResourceLocation(DDBlocks.SCULK_SPRUCE.name()).getPath());
        ANGLER_FISH = registerMain("angler_fish");
        SCULK_SNAPPER = registerMain("sculk_snapper");
        SHATTERED = registerMain("shattered");
        SCULK_LEECH = registerMain("sculk_leech");
        SHRIEK_WORM = registerMain("shriek_worm");
        STALKER = registerMain("stalker");
        SLUDGE = registerMain("sludge");
        SLUDGE_OUTER = register("sludge", "outer");
        SCULK_CENTIPEDE = registerMain("sculk_centipede");
        BLOOMING_GOLEM = registerMain("blooming_golem");
        POTTY = register("overcast_pot", "potty");
        POT = register("overcast_pot", "pot");
        POTTER = register("overcast_pot", "potter");
        OVERCAST_VESSEL = registerMain("overcast_vessel");
        ACID_SPRITE = registerMain("acid_sprite");
        BUBBLOX = registerMain("bubblox");
        SHATTERED_HEAD = registerMain("shattered_head");
        SUNGLASSES = registerMain("sunglasses");
        DEAD_MANS_CHEST = registerMain("dead_mans_chest");
        DOUBLE_DEAD_MANS_CHEST_LEFT = registerMain("double_dead_mans_chest_left");
        DOUBLE_DEAD_MANS_CHEST_RIGHT = registerMain("double_dead_mans_chest_right");
    }
}