package com.kyanite.deeperdarker.mixin.containers;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MerchantScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MerchantMenu;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MerchantScreen.class)
public class MerchantScreenMixin extends AbstractContainerScreen<MerchantMenu> {
    @Shadow private int shopItem;

    @Shadow @Final private static ResourceLocation VILLAGER_LOCATION;

    public MerchantScreenMixin(MerchantMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
    }

    @Override
    public void renderBg(PoseStack poseStack, float f, int i, int j) {
        DeeperAndDarker.LOGGER.info(this.title.getString());
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, this.title.contains(Component.translatable("entity.deeperdarker.echoer")) ? new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/gui/echoer_ui.png") : VILLAGER_LOCATION);
        int k = (this.width - this.imageWidth) / 2;
        int l = (this.height - this.imageHeight) / 2;
        blit(poseStack, k, l, this.getBlitOffset(), 0.0F, 0.0F, this.imageWidth, this.imageHeight, 512, 256);
        MerchantOffers merchantOffers = ((MerchantMenu) this.menu).getOffers();
        if (!merchantOffers.isEmpty()) {
            int m = this.shopItem;
            if (m < 0 || m >= merchantOffers.size()) {
                return;
            }

            MerchantOffer merchantOffer = (MerchantOffer) merchantOffers.get(m);
            if (merchantOffer.isOutOfStock()) {
                RenderSystem.setShaderTexture(0, this.title.contains(Component.translatable("entity.deeperdarker.echoer")) ? new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/gui/echoer_ui.png") : VILLAGER_LOCATION);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                blit(poseStack, this.leftPos + 83 + 99, this.topPos + 35, this.getBlitOffset(), 311.0F, 0.0F, 28, 21, 512, 256);
            }
        }
    }
}
