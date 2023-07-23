package com.kyanite.deeperdarker.client.entity.model;

import com.google.common.collect.Sets;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import net.minecraft.block.WoodType;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;

import java.util.Set;

public class DeeperDarkerModelLayers {
    private static final String MAIN = "main";
    private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();

    public static final EntityModelLayer WARDEN_HELMET = registerMain("warden_helmet");
    public static final EntityModelLayer ECHO_BOAT = createBoat("echo");
    public static final EntityModelLayer ECHO_CHEST_BOAT = createChestBoat("echo");
    public static final EntityModelLayer SCULK_SNAPPER = registerMain("sculk_snapper");
    public static final EntityModelLayer SHATTERED = registerMain("shattered");
    public static final EntityModelLayer SCULK_LEECH = registerMain("sculk_leech");
    public static final EntityModelLayer SHRIEK_WORM = registerMain("shriek_worm");
    public static final EntityModelLayer STALKER = registerMain("stalker");

    private static EntityModelLayer registerMain(String id) {
        return register(id, "main");
    }

    private static EntityModelLayer register(String id, String layer) {
        EntityModelLayer entityModelLayer = create(id, layer);
        if (!LAYERS.add(entityModelLayer)) {
            throw new IllegalStateException("Duplicate registration for " + entityModelLayer);
        } else {
            return entityModelLayer;
        }
    }

    private static EntityModelLayer create(String id, String layer) {
        return new EntityModelLayer(new Identifier(DeeperDarker.MOD_ID, id), layer);
    }

    public static EntityModelLayer createBoat(String type) {
        return create("boat/" + type, MAIN);
    }

    public static EntityModelLayer createChestBoat(String type) {
        return create("chest_boat/" + type, MAIN);
    }
}