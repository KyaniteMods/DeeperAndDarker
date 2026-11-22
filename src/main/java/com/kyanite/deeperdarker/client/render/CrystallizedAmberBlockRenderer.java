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
import java.util.function.Function;

public class CrystallizedAmberBlockRenderer implements BlockEntityRenderer<CrystallizedAmberBlockEntity> {
    private final EntityRenderDispatcher entityRenderer;
    private final ItemRenderer itemRenderer;
    private static final Map<EntityType<?>, Entity> CACHED_ENTITIES = new HashMap<>();
    private static final Map<CrystallizedAmberContentType<?>, CrystallizedAmberContentRenderer<?>> CONTENT_RENDERERS = new HashMap<>();

    public CrystallizedAmberBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = context.getEntityRenderer();
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(CrystallizedAmberBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        if(!blockEntity.getBlockState().getValue(CrystallizedAmberBlock.FOSSILIZED)) return;

        poseStack.pushPose();
        CrystallizedAmberContent<?> content = blockEntity.getContent();
        if (content != null) {
            renderContent(content, partialTick, poseStack, buffer, light, overlay);
        }

        poseStack.popPose();
    }

    @Nullable
    public static Entity getEntityFromType(Level level, EntityType<?> type) {
        if (!CACHED_ENTITIES.containsKey(type) && level != null) {
            CACHED_ENTITIES.put(type, type.create(level));
        }
        return CACHED_ENTITIES.get(type);
    }

    public static <T extends CrystallizedAmberContent<T>> CrystallizedAmberContentRenderer<T> renderEntityType(final Function<T, EntityType<?>> function) {
        return (content, partialTick, poseStack, buffer, light, overlay) -> {
            Entity entity = getEntityFromType(Minecraft.getInstance().level, function.apply(content));

            if (entity == null) return;

            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.XP.rotationDegrees(-40.0f));
            poseStack.translate(0.0f, -entity.getBbHeight() / 2.0f, 0.0f);
            poseStack.mulPose(Axis.YP.rotationDegrees(((CrystallizedAmberEntity) content).rotation()));
            poseStack.scale(0.9f, 0.9f, 0.9f);

            Minecraft.getInstance().getEntityRenderDispatcher().render(entity, 0, 0, 0, 0, 0.0f, poseStack, buffer, light);
        };
    }

    public static <T extends CrystallizedAmberContent<T>> void addContentRenderer(CrystallizedAmberContentType<T> type, CrystallizedAmberContentRenderer<T> renderer) {
        if (!CONTENT_RENDERERS.containsKey(type)) {
            CONTENT_RENDERERS.put(type, renderer);
        }
    }

    public static <T extends CrystallizedAmberContent<T>> CrystallizedAmberContentRenderer<T> getContentRenderer(CrystallizedAmberContentType<T> type) {
        if (CONTENT_RENDERERS.containsKey(type)) {
            return (CrystallizedAmberContentRenderer<T>) CONTENT_RENDERERS.get(type);
        }
        throw new IllegalArgumentException("No content renderer registered for " + type.toString());
    }

    public static <T extends CrystallizedAmberContent<T>> void renderContent(CrystallizedAmberContent<T> content, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        CrystallizedAmberContentRenderer<T> renderer = getContentRenderer(content.getType());
        renderer.render((T) content, partialTick, poseStack, buffer, light, overlay);
    }

    public interface CrystallizedAmberContentRenderer<T extends CrystallizedAmberContent<T>> {
        void render(T content, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay);
    }
}
