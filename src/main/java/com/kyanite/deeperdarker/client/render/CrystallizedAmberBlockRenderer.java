package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import com.kyanite.deeperdarker.content.entities.blocks.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberContent;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberContentType;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberEntity;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberItemStack;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class CrystallizedAmberBlockRenderer implements BlockEntityRenderer<CrystallizedAmberBlockEntity> {
    private final EntityRenderDispatcher entityRenderer;
    private final ItemRenderer itemRenderer;
    private final Map<EntityType<?>, Entity> cachedEntities = new HashMap<>();

    public CrystallizedAmberBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = context.getEntityRenderer();
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(CrystallizedAmberBlockEntity blockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if(!blockEntity.getBlockState().getValue(CrystallizedAmberBlock.FOSSILIZED)) return;

        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 0.5f, 0.5f);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(-40.0f));
        CrystallizedAmberContent<?> content = blockEntity.getContent();
        if (content != null) {
            CrystallizedAmberContentType<?> type = content.getType();
            if (type == CrystallizedAmberContentType.ENTITY) {
                EntityType<?> entityType = ((CrystallizedAmberEntity) content).type();

                pPoseStack.mulPose(Axis.YP.rotationDegrees(((CrystallizedAmberEntity) content).rotation()));
                pPoseStack.scale(0.9f, 0.9f, 0.9f);

                Entity entity = getEntityFromType(blockEntity.hasLevel() ? blockEntity.getLevel() : Minecraft.getInstance().level, entityType);
                if (entity != null) {
                    entityRenderer.render(entity, 0, 0, 0, 0, 0.0f, pPoseStack, pBuffer, pPackedLight);
                }
            } else if (type == CrystallizedAmberContentType.ITEM_STACK) {
                pPoseStack.mulPose(Axis.YP.rotationDegrees(((CrystallizedAmberItemStack) content).rotation()));
                pPoseStack.scale(0.6f, 0.6f, 0.6f);
                itemRenderer.renderStatic(((CrystallizedAmberItemStack) content).stack(), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, blockEntity.getLevel(), 0);
            }
        }

        pPoseStack.popPose();
    }

    @Nullable
    private Entity getEntityFromType(Level level, EntityType<?> type) {
        if (!cachedEntities.containsKey(type) && level != null) {
            cachedEntities.put(type, type.create(level));
        }
        return cachedEntities.get(type);
    }
}
