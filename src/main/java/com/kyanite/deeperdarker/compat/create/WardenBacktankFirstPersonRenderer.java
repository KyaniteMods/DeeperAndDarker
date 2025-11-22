package com.kyanite.deeperdarker.compat.create;

import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;

public class WardenBacktankFirstPersonRenderer {
    private static final ResourceLocation BACKTANK_ARMOR_LOCATION =
            new ResourceLocation(DeeperDarker.MOD_ID, "textures/models/armor/warden_diving_arm.png");

    private static boolean rendererActive = false;

    public static void clientTick() {
        Minecraft mc = Minecraft.getInstance();
        rendererActive = mc.player != null && mc.player.getItemBySlot(EquipmentSlot.CHEST).is(DDCreateCompat.Items.WARDEN_BACKTANK.get());
    }

    public static boolean onRenderPlayerHand(PoseStack poseStack, MultiBufferSource buffer, int packedLight, AbstractClientPlayer player, HumanoidArm arm) {
        if (!rendererActive)
            return false;

        Minecraft mc = Minecraft.getInstance();
        if (!(mc.getEntityRenderDispatcher()
                .getRenderer(player) instanceof PlayerRenderer pr))
            return false;

        PlayerModel<AbstractClientPlayer> model = pr.getModel();
        model.attackTime = 0.0F;
        model.crouching = false;
        model.swimAmount = 0.0F;
        model.setupAnim(player, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        ModelPart armPart = arm == HumanoidArm.LEFT ? model.leftSleeve : model.rightSleeve;
        armPart.xRot = 0.0F;
        armPart.render(poseStack, buffer.getBuffer(RenderType.entitySolid(BACKTANK_ARMOR_LOCATION)),
                LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY);
        return true;
    }
}
