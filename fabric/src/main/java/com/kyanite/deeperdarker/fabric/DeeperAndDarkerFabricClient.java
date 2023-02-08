package com.kyanite.deeperdarker.fabric;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.client.rendering.entity.*;
import com.kyanite.deeperdarker.config.DDClientConfig;
import com.kyanite.deeperdarker.fabric.client.FabricBoatModels;
import com.kyanite.deeperdarker.fabric.client.SoulElytraItem;
import com.kyanite.deeperdarker.fabric.client.elytra.SoulElytraArmorStandLayer;
import com.kyanite.deeperdarker.fabric.client.elytra.SoulElytraLayer;
import com.kyanite.deeperdarker.fabric.client.warden_armor.ArmorRenderer;
import com.kyanite.deeperdarker.fabric.client.warden_armor.WardenArmorRenderer;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.paragon.api.ConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class DeeperAndDarkerFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ConfigManager.register("deeperdarker", new DDClientConfig());

        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.ECHO_DOOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.ECHO_TRAPDOOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.SCULK_VINES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.SCULK_VINES_PLANT.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.SCULK_TENDRILS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.SCULK_TENDRILS_PLANT.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.CRYSTALLIZED_AMBER.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.GLOOMY_GRASS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.GLOOM_CACTUS.get(), RenderType.cutout());

        EntityRendererRegistry.register(DDEntities.SHRIEK_PROJECTILE.get(), context -> new ShriekRenderer(context));
        EntityRendererRegistry.register(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_LEECH.get(), SculkLeechRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
        EntityRendererRegistry.register(DDEntities.ECHOER.get(), EchoerRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_WORM.get(), SculkWormRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_CENTIPEDE.get(), CentipedeRenderer::new);
        EntityRendererRegistry.register(DDEntities.STALKER.get(), StalkerRenderer::new);
     //   EntityRendererRegistry.register(DDEntities.SCAVENGER.get(), ScavengerRenderer::new);

        //GeoItemRenderer.registerItemRenderer(DDItems.ANCIENT_CHEST.get(), new AncientChestItemRenderer());
        //GeoItemRenderer.registerItemRenderer(DDItems.DEEPSLATE_CHEST.get(), new AncientChestItemRenderer());

        FabricBoatModels.registerLayers();

        EntityRendererRegistry.register(DDEntities.BOAT.get(), context -> new DDBoatRenderer<>(context, false));
        EntityRendererRegistry.register(DDEntities.CHEST_BOAT.get(), context -> new DDBoatRenderer<>(context, true));
        
        //BlockEntityRendererRegistry.register(DDBlockEntityTypes.ANCIENT_CHEST.get(), context -> new AncientChestRenderer());
        //BlockEntityRendererRegistry.register(DDBlockEntityTypes.DEEPSLATE_CHEST.get(), context -> new AncientChestRenderer());

        FabricModelPredicateProviderRegistry.register(DDItems.SOUL_ELYTRA.get(), new ResourceLocation(DeeperAndDarker.MOD_ID, "broken"),
                (stack, arg1, arg2, arg3) -> SoulElytraItem.isUsable(stack) ? 0 : 1);

        ArmorRenderer.registerArmorRenderer(new WardenArmorRenderer(), DDItems.WARDEN_HELMET.get(),
                DDItems.WARDEN_CHESTPLATE.get(), DDItems.WARDEN_LEGGINGS.get(), DDItems.WARDEN_BOOTS.get());

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if(entityRenderer instanceof PlayerRenderer playerRenderer) {
                registrationHelper.register(new SoulElytraLayer(playerRenderer, context.getModelSet()));
            } else if(entityRenderer instanceof ArmorStandRenderer armorStandRenderer) {
                registrationHelper.register(new SoulElytraArmorStandLayer(armorStandRenderer, context.getModelSet()));
            }
        });
    }
}
