package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.Keybinds;
import com.kyanite.deeperdarker.client.model.*;
import com.kyanite.deeperdarker.client.render.*;
import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.blocks.AncientVaseBlock;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import com.kyanite.deeperdarker.content.blocks.entity.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.blocks.vegetation.IceLilyBlock;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.content.items.SoulElytraItem;
import com.kyanite.deeperdarker.network.Messages;
import com.kyanite.deeperdarker.network.SoulElytraBoostPacket;
import com.kyanite.deeperdarker.network.SoulElytraClientPacket;
import com.kyanite.deeperdarker.network.UseTransmitterPacket;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.network.PacketDistributor;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = DeeperDarker.MOD_ID)
public class DeeperDarkerEvents {
    @SubscribeEvent
    public static void breakEvent(final BlockEvent.BreakEvent event) {
        boolean silktouch = event.getPlayer().getMainHandItem().getEnchantmentLevel(Enchantments.SILK_TOUCH) > 0;
        Level level = (Level) event.getLevel();
        BlockState state = event.getState();
        BlockPos pos = event.getPos();

        if(state.is(DDBlocks.CRYSTALLIZED_AMBER.get()) && level.getBlockEntity(pos) instanceof CrystallizedAmberBlockEntity blockEntity) {
            if(!silktouch && state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                if(blockEntity.fossilizedEntity && level instanceof ServerLevel serverLevel) DDEntities.SCULK_LEECH.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                else Block.popResource(level, pos, blockEntity.getLoot());
            } else if(silktouch && !level.isClientSide() && state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                CompoundTag tag = new CompoundTag();
                tag.put("item", blockEntity.getLoot().save(new CompoundTag()));
                tag.putBoolean("leech", blockEntity.fossilizedEntity);

                ItemStack stack = new ItemStack(DDBlocks.CRYSTALLIZED_AMBER.get());
                BlockItem.setBlockEntityData(stack, DDBlockEntities.CRYSTALLIZED_AMBER.get(), tag);
                Block.popResource(level, pos, stack);

                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                event.setCanceled(true);
            }
            return;
        }

        if(silktouch) return;

        if(state.is(DDBlocks.ICE_LILY.get())) {
            if(state.getValue(IceLilyBlock.HAS_FLOWER)) return;

            CompoundTag tag = new CompoundTag();
            tag.putBoolean("has_flower", false);

            ItemStack stack = new ItemStack(DDBlocks.ICE_LILY.get());
            stack.setTag(tag);
            Block.popResource(level, pos, stack);

            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            event.setCanceled(true);
        }

        if(state.is(DDBlocks.ANCIENT_VASE.get())) {
            if(level instanceof ServerLevel serverLevel) {
                RandomSource random = serverLevel.getRandom();
                if(level.getDifficulty() != Difficulty.PEACEFUL && !state.getValue(AncientVaseBlock.SAFE) && random.nextDouble() < DeeperDarkerConfig.fakeVaseChance) {
                    if(random.nextDouble() < 1 - DeeperDarkerConfig.stalkerSpawnChance) {
                        for(int i = 0; i < random.nextInt(1, 4); i++) {
                            DDEntities.SCULK_LEECH.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                        }
                    } else {
                        DDEntities.STALKER.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                    }
                    serverLevel.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void equipmentChangeEvent(final LivingEquipmentChangeEvent event) {
        if(!event.getSlot().isArmor()) return;
        if(!event.getTo().is(DDItems.SOUL_ELYTRA.get()) || event.getFrom().is(DDItems.SOUL_ELYTRA.get())) return;
        if(event.getEntity() instanceof ServerPlayer player) Messages.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new SoulElytraClientPacket());
    }

    @Mod.EventBusSubscriber(modid = DeeperDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                Sheets.addWoodType(DDBlocks.ECHO);
                Sheets.addWoodType(DDBlocks.BLOOM);
                ItemProperties.register(DDItems.SOUL_ELYTRA.get(), new ResourceLocation("broken"), (pStack, pLevel, pEntity, pSeed) -> SoulElytraItem.isFlyEnabled(pStack) ? 0 : 1);
                ItemProperties.register(DDItems.SCULK_TRANSMITTER.get(), DeeperDarker.rl("linked"), (pStack, pLevel, pEntity, pSeed) -> SculkTransmitterItem.isLinked(pStack) ? 1 : 0);
                ItemProperties.register(DDItems.SONOROUS_STAFF.get(), DeeperDarker.rl("charge"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.getUseItem() == pStack ? (pStack.getUseDuration() - pEntity.getUseItemRemainingTicks()) / 123f : 0);
            });

            BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_SIGNS.get(), SignRenderer::new);
            BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_HANGING_SIGNS.get(), HangingSignRenderer::new);
            EntityRenderers.register(DDEntities.BOAT.get(), (context) -> new DDBoatRenderer(context, false));
            EntityRenderers.register(DDEntities.CHEST_BOAT.get(), (context) -> new DDBoatRenderer(context, true));
            EntityRenderers.register(DDEntities.ANGLER_FISH.get(), AnglerFishRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_CENTIPEDE.get(), SculkCentipedeRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_LEECH.get(), SculkLeechRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
            EntityRenderers.register(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
            EntityRenderers.register(DDEntities.SHRIEK_WORM.get(), ShriekWormRenderer::new);
            EntityRenderers.register(DDEntities.STALKER.get(), StalkerRenderer::new);
        }

        @SubscribeEvent
        public static void registerKeybinds(final RegisterKeyMappingsEvent event) {
            event.register(Keybinds.BOOST);
            event.register(Keybinds.TRANSMIT);
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(DDBlockEntities.CRYSTALLIZED_AMBER.get(), CrystallizedAmberBlockRenderer::new);
        }

        @SubscribeEvent
        public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(DDBoatRenderer.ECHO_BOAT_MODEL, BoatModel::createBodyModel);
            event.registerLayerDefinition(DDBoatRenderer.ECHO_CHEST_BOAT_MODEL, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(DDBoatRenderer.BLOOM_BOAT_MODEL, BoatModel::createBodyModel);
            event.registerLayerDefinition(DDBoatRenderer.BLOOM_CHEST_BOAT_MODEL, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(AnglerFishRenderer.MODEL, AnglerFishModel::createBodyModel);
            event.registerLayerDefinition(SculkCentipedeRenderer.MODEL, SculkCentipedeModel::createBodyModel);
            event.registerLayerDefinition(SculkLeechRenderer.MODEL, SculkLeechModel::createBodyModel);
            event.registerLayerDefinition(SculkSnapperRenderer.MODEL, SculkSnapperModel::createBodyModel);
            event.registerLayerDefinition(ShatteredRenderer.MODEL, ShatteredModel::createBodyModel);
            event.registerLayerDefinition(ShriekWormRenderer.MODEL, ShriekWormModel::createBodyModel);
            event.registerLayerDefinition(StalkerRenderer.MODEL, StalkerModel::createBodyModel);
            event.registerLayerDefinition(WardenHelmetRenderer.MODEL, WardenHelmetModel::createBodyModel);
        }

        @SubscribeEvent
        public static void addLayers(final EntityRenderersEvent.AddLayers event) {
            event.getSkins().forEach(name -> {
                if(event.getSkin(name) instanceof PlayerRenderer renderer) {
                    renderer.addLayer(new SoulElytraRenderer<>(renderer, event.getEntityModels()));
                    renderer.addLayer(new WardenHelmetRenderer<>(renderer, event.getEntityModels()));
                }
            });
            if(event.getRenderer(EntityType.ARMOR_STAND) instanceof ArmorStandRenderer renderer) {
                renderer.addLayer(new SoulElytraRenderer<>(renderer, event.getEntityModels()));
                renderer.addLayer(new WardenHelmetRenderer<>(renderer, event.getEntityModels()));
            }
        }
    }

    @Mod.EventBusSubscriber(modid = DeeperDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ForgeClientEvents {
        @SubscribeEvent
        public static void keyInput(final InputEvent.Key event) {
            if(Keybinds.BOOST.consumeClick()) Messages.INSTANCE.sendToServer(new SoulElytraBoostPacket());
            if(Keybinds.TRANSMIT.consumeClick()) Messages.INSTANCE.sendToServer(new UseTransmitterPacket());
        }
    }
}
