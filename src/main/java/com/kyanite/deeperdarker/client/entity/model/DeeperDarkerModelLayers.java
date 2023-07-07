package com.kyanite.deeperdarker.client.entity.model;

import com.google.common.collect.Sets;
import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

import java.util.Set;

public class DeeperDarkerModelLayers {
    private static final String MAIN = "main";
    private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();

    public static final EntityModelLayer WARDEN_HELMET = registerMain("warden_helmet");

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
}
