package com.kyanite.deeperdarker.fabric.client.warden_armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib3.util.GeoUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ArmorRenderer<T extends ArmorItem & GeoAnimatable> implements GeoRenderer<T>, net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer {
    public static final Map<Class<? extends ArmorItem>, ArmorRenderer<?>> renderers = new ConcurrentHashMap<>();

    static {
        AnimationController.addModelFetcher((GeoAnimatable object) -> {
            if(object instanceof ArmorItem) {
                ArmorRenderer renderer = renderers.get(object.getClass());
                return renderer == null ? null : renderer.getGeoModel();
            }
            return null;
        });
    }

    protected GeoModel<T> modelProvider;
    protected ItemStack currentItemStack;

    // Set these to the names of your armor's bones, or null if you aren't using
    // them
    public String headBone = "armorHead";
    public String bodyBone = "armorBody";
    public String rightArmBone = "armorRightArm";
    public String leftArmBone = "armorLeftArm";
    public String rightLegBone = "armorRightLeg";
    public String leftLegBone = "armorLeftLeg";
    public String rightBootBone = "armorRightBoot";
    public String leftBootBone = "armorLeftBoot";

    private T currentArmorItem;
    private LivingEntity entityLiving;
    private ItemStack itemStack;
    public EquipmentSlot armorSlot;
    public HumanoidModel baseModel;

    public ArmorRenderer(GeoModel<T> modelProvider) {
        this.modelProvider = modelProvider;
    }

    public void setModel(GeoModel<T> model) {
        this.modelProvider = model;
    }

    public static <E extends Entity> void registerArmorRenderer(ArmorRenderer renderer, Item... items) {
        for(Item item : items) {
            registerArmorRenderer(renderer, item);
        }
    }

    public static void registerArmorRenderer(Class<? extends ArmorItem> itemClass, ArmorRenderer instance) {
        for(Constructor<?> c : instance.getClass().getConstructors()) {
            if(c.getParameterCount() == 0) {
                try {
                    registerArmorRenderer(itemClass, (ArmorRenderer) c.newInstance());
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException("If you still use the registration using instances, please give it a no-args constructor!");
            }
        }
    }

    public static <E extends Entity> void registerArmorRenderer(ArmorRenderer renderer, Item item) {
        if(item instanceof ArmorItem) {
            renderers.put((Class<? extends ArmorItem>) item.getClass(), renderer);
            net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer.register(renderer, item);
        }
    }

    public static ArmorRenderer getRenderer(Class<? extends ArmorItem> item) {
        final ArmorRenderer renderer = renderers.get(item);
        if(renderer == null) {
            throw new IllegalArgumentException("Renderer not registered for item " + item);
        }
        return renderer;
    }

    public void render(PoseStack matrices, MultiBufferSource vertexConsumers, ItemStack stack,
                       LivingEntity entity, EquipmentSlot slot, int light, HumanoidModel<LivingEntity> contextModel) {
        setCurrentItem(entity, stack, slot, contextModel);
        this.render(matrices, vertexConsumers, light);
    }

    public void render(float partialTicks, PoseStack stack, VertexConsumer bufferIn, int packedLightIn) {
        stack.translate(0.0D, 1.497F, 0.0D);
        stack.scale(-1.005F, -1.0F, 1.005F);
        GeoModel<T> model = modelProvider;

        AnimationState<T> itemEvent = new AnimationState<>(this.currentArmorItem, 0, 0, Minecraft.getInstance().getFrameTime(), false);
        modelProvider.setCustomAnimations(currentArmorItem, this.getInstanceId(this.currentArmorItem), itemEvent);

        this.fitToBiped();
        this.applySlot(armorSlot);
        stack.pushPose();
        Minecraft.getInstance().getTextureManager().bindForSetup(getTextureLocation(currentArmorItem));
        Color renderColor = getRenderColor(currentArmorItem, partialTicks, stack, null, bufferIn, packedLightIn);
        RenderType renderType = getRenderType(currentArmorItem, partialTicks, stack, null, bufferIn, packedLightIn,
                getTextureLocation(currentArmorItem));
        render(model, currentArmorItem, partialTicks, renderType, stack, null, bufferIn, packedLightIn,
                OverlayTexture.NO_OVERLAY, (float) renderColor.getRed() / 255f, (float) renderColor.getGreen() / 255f,
                (float) renderColor.getBlue() / 255f, (float) renderColor.getAlpha() / 255);

        stack.popPose();
        stack.scale(-1.005F, -1.0F, 1.005F);
        stack.translate(0.0D, -1.497F, 0.0D);
    }

    public void render(PoseStack stack, MultiBufferSource bufferIn, int packedLightIn) {
        stack.translate(0.0D, 1.497F, 0.0D);
        stack.scale(-1.005F, -1.0F, 1.005F);
        GeoModel<T> model = modelProvider;

        AnimationState<T> itemEvent = new AnimationState<>(this.currentArmorItem, 0, 0, Minecraft.getInstance().getFrameTime(), false);
        modelProvider.setCustomAnimations(currentArmorItem, this.getInstanceId(this.currentArmorItem), itemEvent);

        this.fitToBiped();
        this.applySlot(armorSlot);
        stack.pushPose();
        Minecraft.getInstance().getTextureManager().bindForSetup(getTextureLocation(currentArmorItem));
        Color renderColor = getRenderColor(currentArmorItem, 0, stack, bufferIn, null, packedLightIn);
        RenderType renderType = getRenderType(currentArmorItem, 0, stack, bufferIn, null, packedLightIn,
                getTextureLocation(currentArmorItem));
        render(model, currentArmorItem, 0, renderType, stack, bufferIn, null, packedLightIn, OverlayTexture.NO_OVERLAY,
                (float) renderColor.getRed() / 255f, (float) renderColor.getGreen() / 255f,
                (float) renderColor.getBlue() / 255f, (float) renderColor.getAlpha() / 255);

        stack.popPose();
        stack.scale(-1.005F, -1.0F, 1.005F);
        stack.translate(0.0D, -1.497F, 0.0D);
    }

    public void fitToBiped() {
        if(this.headBone != null) {
            GeoBone headBone = this.modelProvider.getBone(this.headBone).get();
            GeoUtils.copyRotations(baseModel.head, headBone);
            headBone.setPosX(baseModel.head.x);
            headBone.setPosY(-baseModel.head.y);
            headBone.setPosZ(baseModel.head.z);
        }

        if(this.bodyBone != null) {
            GeoBone bodyBone = this.modelProvider.getBone(this.bodyBone).get();
            GeoUtils.copyRotations(baseModel.body, bodyBone);
            bodyBone.setPosX(baseModel.body.x);
            bodyBone.setPosY(-baseModel.body.y);
            bodyBone.setPosZ(baseModel.body.z);
        }
        if(this.rightArmBone != null) {
            GeoBone rightArmBone = this.modelProvider.getBone(this.rightArmBone).get();
            GeoUtils.copyRotations(baseModel.rightArm, rightArmBone);
            rightArmBone.setPosX(baseModel.rightArm.x + 5);
            rightArmBone.setPosY(2 - baseModel.rightArm.y);
            rightArmBone.setPosZ(baseModel.rightArm.z);
        }

        if(this.leftArmBone != null) {
            GeoBone leftArmBone = this.modelProvider.getBone(this.leftArmBone).get();
            GeoUtils.copyRotations(baseModel.leftArm, leftArmBone);
            leftArmBone.setPosX(baseModel.leftArm.x - 5);
            leftArmBone.setPosY(2 - baseModel.leftArm.y);
            leftArmBone.setPosZ(baseModel.leftArm.z);
        }
        if(this.rightLegBone != null) {
            GeoBone rightLegBone = this.modelProvider.getBone(this.rightLegBone).get();
            GeoUtils.copyRotations(baseModel.rightLeg, rightLegBone);
            rightLegBone.setPosX(baseModel.rightLeg.x + 2);
            rightLegBone.setPosY(12 - baseModel.rightLeg.y);
            rightLegBone.setPosZ(baseModel.rightLeg.z);
            if(this.rightBootBone != null) {
                GeoBone rightBootBone = this.modelProvider.getBone(this.rightBootBone).get();
                GeoUtils.copyRotations(baseModel.rightLeg, rightBootBone);
                rightBootBone.setPosX(baseModel.rightLeg.x + 2);
                rightBootBone.setPosY(12 - baseModel.rightLeg.y);
                rightBootBone.setPosZ(baseModel.rightLeg.z);
            }
        }
        if(this.leftLegBone != null) {
            GeoBone leftLegBone = this.modelProvider.getBone(this.leftLegBone).get();
            GeoUtils.copyRotations(baseModel.leftLeg, leftLegBone);
            leftLegBone.setPosX(baseModel.leftLeg.x - 2);
            leftLegBone.setPosY(12 - baseModel.leftLeg.y);
            leftLegBone.setPosZ(baseModel.leftLeg.z);
            if(this.leftBootBone != null) {
                GeoBone leftBootBone = this.modelProvider.getBone(this.leftBootBone).get();
                GeoUtils.copyRotations(baseModel.leftLeg, leftBootBone);
                leftBootBone.setPosX(baseModel.leftLeg.x - 2);
                leftBootBone.setPosY(12 - baseModel.leftLeg.y);
                leftBootBone.setPosZ(baseModel.leftLeg.z);
            }
        }
    }

    @Override
    public GeoModel<T> getGeoModel() {
        return this.modelProvider;
    }

    @Override
    public T getAnimatable() {
        return ;
    }

    @Override
    public ResourceLocation getTextureLocation(T instance) {
        return this.modelProvider.getTextureResource(instance);
    }

    /**
     * Everything after this point needs to be called every frame before rendering
     */
    public ArmorRenderer<T> setCurrentItem(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel model) {
        this.entityLiving = entityLiving;
        this.itemStack = itemStack;
        this.armorSlot = armorSlot;
        this.currentArmorItem = (T) itemStack.getItem();
        this.baseModel = model;

        return this;
    }

    @SuppressWarnings("incomplete-switch")
    public ArmorRenderer<T> applySlot(EquipmentSlot boneSlot) {
        modelProvider.getModel(modelProvider.getModelResource(currentArmorItem));

        GeoBone headBone = this.getAndHideBone(this.headBone);
        GeoBone bodyBone = this.getAndHideBone(this.bodyBone);
        GeoBone rightArmBone = this.getAndHideBone(this.rightArmBone);
        GeoBone leftArmBone = this.getAndHideBone(this.leftArmBone);
        GeoBone rightLegBone = this.getAndHideBone(this.rightLegBone);
        GeoBone leftLegBone = this.getAndHideBone(this.leftLegBone);
        GeoBone rightBootBone = this.getAndHideBone(this.rightBootBone);
        GeoBone leftBootBone = this.getAndHideBone(this.leftBootBone);

        switch (boneSlot) {
            case HEAD:
                if(headBone != null)
                    headBone.setHidden(false);
                break;
            case CHEST:
                if(bodyBone != null)
                    bodyBone.setHidden(false);
                if(rightArmBone != null)
                    rightArmBone.setHidden(false);
                if(leftArmBone != null)
                    leftArmBone.setHidden(false);
                break;
            case LEGS:
                if(rightLegBone != null)
                    rightLegBone.setHidden(false);
                if(leftLegBone != null)
                    leftLegBone.setHidden(false);
                break;
            case FEET:
                if(rightBootBone != null)
                    rightBootBone.setHidden(false);
                if(leftBootBone != null)
                    leftBootBone.setHidden(false);
                break;
        }
        return this;
    }

    protected GeoBone getAndHideBone(String boneName) {
        if(boneName != null) {
            final GeoBone bone = this.modelProvider.getBone(boneName).get();
            bone.setHidden(true);
            return bone;
        }
        return null;
    }

    @Override
    public long getInstanceId(T animatable) {
        return Objects.hash(this.armorSlot, itemStack.getItem(), itemStack.getCount(), itemStack.hasTag() ? itemStack.getTag().toString() : 1, this.entityLiving.getUUID().toString());
    }

    @Override
    public void fireCompileRenderLayersEvent() {

    }

    @Override
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return false;
    }

    @Override
    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {

    }

    @Override
    public void updateAnimatedTextureFrame(T animatable) {

    }
}
