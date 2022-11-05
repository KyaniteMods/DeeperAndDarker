package com.kyanite.deeperdarker.client.rendering.block;

import com.kyanite.deeperdarker.registry.items.custom.AncientChestItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class AncientChestItemRenderer extends GeoItemRenderer<AncientChestItem> {
    public AncientChestItemRenderer() {
        super(new AncientChestItemModel());
    }
}
