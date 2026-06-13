package com.kyanite.deeperdarker.client.render.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;

public class CrystallizedAmberRenderState extends BlockEntityRenderState {
    public boolean fossilized;
    public boolean hasLeech;
    public EntityRenderState displayEntity;
    public ItemStackRenderState item;
}
