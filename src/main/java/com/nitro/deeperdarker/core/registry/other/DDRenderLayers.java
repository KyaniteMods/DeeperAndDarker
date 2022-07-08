package com.nitro.deeperdarker.core.registry.other;

import com.nitro.deeperdarker.core.registry.DDBlocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class DDRenderLayers {

    public static void setupRenderLayers() {
        setRenderLayer(DDBlocks.BONE_DOOR.get(), RenderType.translucent());
        setRenderLayer(DDBlocks.BONE_TRAPDOOR.get(), RenderType.translucent());
        setRenderLayer(DDBlocks.BONE_LADDER.get(), RenderType.cutout());
        setRenderLayer(DDBlocks.BONE_POST.get(), RenderType.cutout());
        setRenderLayer(DDBlocks.SCULK_BONE_DOOR.get(), RenderType.translucent());
        setRenderLayer(DDBlocks.SCULK_BONE_TRAPDOOR.get(), RenderType.translucent());
        setRenderLayer(DDBlocks.SCULK_BONE_LADDER.get(), RenderType.cutout());
        setRenderLayer(DDBlocks.SCULK_BONE_POST.get(), RenderType.cutout());
    }

    private static void setRenderLayer(Block block, RenderType type) {
        ItemBlockRenderTypes.setRenderLayer(block, type::equals);
    }
}