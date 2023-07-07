package com.kyanite.deeperdarker.client.entity.feature;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.entity.model.DeeperDarkerModelLayers;
import com.kyanite.deeperdarker.client.entity.model.WardenHelmetHornsModel;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import com.mojang.authlib.GameProfile;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.SkullBlockEntityModel;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LimbAnimator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;

public class WardenHelmetHornsFeatureRenderer<T extends LivingEntity, M extends BipedEntityModel<T>, A extends BipedEntityModel<T>> extends FeatureRenderer<T, M> {
    private final float scaleX;
    private final float scaleY;
    private final float scaleZ;
    private final EntityModelLoader modelLoader;

    public WardenHelmetHornsFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        this(context, loader, 1.0f, 1.0f, 1.0f);
    }

    public WardenHelmetHornsFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader, float scaleX, float scaleY, float scaleZ) {
        super(context);
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
        this.modelLoader = loader;
    }

    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, T livingEntity, float f, float g, float h, float j, float k, float l) {
        ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.HEAD);
        if (!itemStack.isEmpty()) {
            Item item = itemStack.getItem();
            matrixStack.push();
            matrixStack.scale(this.scaleX, this.scaleY, this.scaleZ);
            boolean bl = livingEntity instanceof ZombieVillagerEntity;
            if (livingEntity.isBaby()) {
                matrixStack.translate(0.0F, 0.03125F, 0.0F);
                matrixStack.scale(0.7F, 0.7F, 0.7F);
                matrixStack.translate(0.0F, 1.0F, 0.0F);
            }

            ((ModelWithHead)this.getContextModel()).getHead().rotate(matrixStack);
            if (item == DeeperDarkerItems.WARDEN_HELMET) {
                if (livingEntity.isBaby()) {
                    matrixStack.scale(1.3425f, 1.3425f, 1.3425f);
                    matrixStack.translate(0.0f, -0.803125f, 0.0f);
                } else {
                    matrixStack.scale(1.25f, 1.25f, 1.25f);
                    matrixStack.translate(0.0f, -0.825f, 0.0f);
                }
                if (bl) {
                    matrixStack.translate(0.0f, -0.1f, 0.0f);
                }
                WardenHelmetHornsModel<T> hornsModel = new WardenHelmetHornsModel<T>(this.modelLoader.getModelPart(DeeperDarkerModelLayers.WARDEN_HELMET));
                RenderLayer renderLayer = RenderLayer.getArmorCutoutNoCull(new Identifier(DeeperDarker.MOD_ID, "textures/models/armor/warden_horns.png"));
                RenderLayer glintRenderLayer = RenderLayer.getArmorGlint();
                hornsModel.render(matrixStack, vertexConsumerProvider.getBuffer(renderLayer), light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                if (item.hasGlint(itemStack)) {
                    hornsModel.render(matrixStack, vertexConsumerProvider.getBuffer(glintRenderLayer), light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                }
            }
            matrixStack.pop();
        }
    }
}
