package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.Keybinds;
import com.kyanite.deeperdarker.client.model.*;
import com.kyanite.deeperdarker.client.render.*;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.blocks.AncientVaseBlock;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import com.kyanite.deeperdarker.content.blocks.entity.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.blocks.vegetation.IceLilyBlock;
import com.kyanite.deeperdarker.content.items.ResonariumArmorItem;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.content.items.SoulElytraItem;
import com.kyanite.deeperdarker.network.SoulElytraBoostPacket;
import com.kyanite.deeperdarker.network.SoulElytraClientPacket;
import com.kyanite.deeperdarker.network.UseTransmitterPacket;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringUtil;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.event.AnvilUpdateEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = DeeperDarker.MOD_ID)
public class DeeperDarkerEvents {
    @SubscribeEvent
    public static void registerBrewingRecipes(final RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();
        builder.addMix(Potions.AWKWARD, DDItems.SOUL_CRYSTAL.get(), DDPotions.SCULK_AFFINITY);
        builder.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.SCULK_AFFINITY);
        builder.addMix(DDPotions.SCULK_AFFINITY, Items.REDSTONE, DDPotions.LONG_SCULK_AFFINITY);
        builder.addMix(Potions.LONG_INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.LONG_SCULK_AFFINITY);
    }

    @SubscribeEvent
    public static void breakEvent(final BlockEvent.BreakEvent event) {
        Level level = (Level) event.getLevel();
        BlockState state = event.getState();
        BlockPos pos = event.getPos();
        HolderLookup.RegistryLookup<Enchantment> lookup = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
        boolean silktouch = event.getPlayer().getMainHandItem().getEnchantmentLevel(lookup.getOrThrow(Enchantments.SILK_TOUCH)) > 0;

        if(state.is(DDBlocks.CRYSTALLIZED_AMBER) && level.getBlockEntity(pos) instanceof CrystallizedAmberBlockEntity blockEntity) {
            if(!silktouch && state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                if(blockEntity.fossilizedEntity && level instanceof ServerLevel serverLevel) DDEntities.SCULK_LEECH.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                else Block.popResource(level, pos, blockEntity.getLoot());
            } else if(silktouch && !level.isClientSide() && state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                CompoundTag tag = new CompoundTag();
                tag.put("item", blockEntity.getLoot().saveOptional(level.registryAccess()));
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

        if(state.is(DDBlocks.ICE_LILY)) {
            if(state.getValue(IceLilyBlock.HAS_FLOWER)) return;

            CompoundTag tag = new CompoundTag();
            tag.putBoolean("has_flower", false);
            tag.putString("id", "deeperdarker:ice_lily");

            ItemStack stack = new ItemStack(DDBlocks.ICE_LILY);
            stack.set(DataComponents.ENTITY_DATA, CustomData.of(tag));
            stack.set(DataComponents.ITEM_NAME, Component.translatable("block." + DeeperDarker.MOD_ID + ".flowerless_ice_lily"));
            Block.popResource(level, pos, stack);

            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            event.setCanceled(true);
        }

        if(state.is(DDBlocks.ANCIENT_VASE)) {
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
    public static void livingDamageEvent(final LivingDamageEvent.Pre event) {
        if(event.getSource().is(DamageTypeTags.BYPASSES_ARMOR)) return;

        LivingEntity entity = event.getEntity();
        float incoming = event.getNewDamage();
        float reduction = incoming / 4;

        for(ItemStack stack : entity.getArmorSlots()) {
            if(stack.getItem() instanceof ArmorItem armor && stack.is(DDTags.Items.RESONARIUM_ARMOR)) {
                incoming -= reduction;
                stack.hurtAndBreak((int) (event.getOriginalDamage() / 1.5f), entity, armor.getEquipmentSlot());
            }
        }

        event.setNewDamage(incoming);
    }

    @SubscribeEvent
    public static void armorHurtEvent(final ArmorHurtEvent event) {
        event.getArmorMap().forEach((equipmentSlot, armorEntry) -> {
            if(event.getArmorItemStack(equipmentSlot).getItem() instanceof ArmorItem armor && armor.getMaterial().is(DDArmorMaterials.RESONARIUM.getId())) {
                armorEntry.newDamage = 0;
            }
        });
    }

    @SubscribeEvent
    public static void equipmentChangeEvent(final LivingEquipmentChangeEvent event) {
        if(!event.getSlot().isArmor()) return;
        if(!event.getTo().is(DDItems.SOUL_ELYTRA.get()) || event.getFrom().is(DDItems.SOUL_ELYTRA.get())) return;
        if(event.getEntity() instanceof ServerPlayer player) PacketDistributor.sendToPlayer(player, new SoulElytraClientPacket(true));
    }

    @SubscribeEvent
    public static void anvilEvent(final AnvilUpdateEvent event) {
        ItemStack input = event.getLeft();
        ItemStack addition = event.getRight();

        if(!(input.getItem() instanceof ResonariumArmorItem)) return;
        if(addition.is(DDItems.RESONARIUM)) {
            ItemStack output = input.copy();
            int diff = Math.min(output.getDamageValue(), output.getMaxDamage() / 4);
            int cost = 0;
            for(int i = 0; diff > 0 && i < addition.getCount(); i++) {
                int damage = output.getDamageValue() - diff;
                output.setDamageValue(damage);
                diff = Math.min(damage, output.getMaxDamage() / 4);
                cost++;
            }

            event.setOutput(output);
            event.setCost(nameCost(event.getName(), input, cost, output));
            return;
        }
        if(!addition.is(Items.ENCHANTED_BOOK)) return;
        boolean client = event.getPlayer().level().isClientSide;

        ItemEnchantments inputEnchants = EnchantmentHelper.getEnchantmentsForCrafting(input);
        ItemEnchantments bookEnchants = EnchantmentHelper.getEnchantmentsForCrafting(addition);
        ItemEnchantments.Mutable finalEnchants = new ItemEnchantments.Mutable(inputEnchants);
        int cost = 0;

        boolean noChange = true;
        for(Object2IntMap.Entry<Holder<Enchantment>> entry : bookEnchants.entrySet()) {
            Holder<Enchantment> enchantment = entry.getKey();
            Enchantment enchant = enchantment.value();
            int level = entry.getIntValue();
            int existingLevel = inputEnchants.getLevel(enchantment);
            level = level == existingLevel ? level + 1 : Math.max(level, existingLevel);
            level = Math.min(level, enchant.getMaxLevel());

            if(enchant.canEnchant(input) && !enchantment.is(DDTags.Misc.RESONARIUM_EXCLUDES)) {
                finalEnchants.set(enchantment, level);
                cost += enchant.getAnvilCost() * level;
                noChange = false;
            }
        }

        if(noChange) {
            event.setCanceled(true);
            return;
        }

        int inputRepair = input.getOrDefault(DataComponents.REPAIR_COST, 0);
        int additionRepair = addition.getOrDefault(DataComponents.REPAIR_COST, 0);
        int newRepairCost = AnvilMenu.calculateIncreasedRepairCost(Math.max(inputRepair, additionRepair));
        cost = Math.clamp(cost + inputRepair + additionRepair, 0, Integer.MAX_VALUE);

        ItemStack output = input.copy();
        output.set(DataComponents.REPAIR_COST, newRepairCost);
        EnchantmentHelper.setEnchantments(output, finalEnchants.toImmutable());

        cost = nameCost(event.getName(), input, cost, output);

        event.setOutput(output);
        event.setCost(cost / 2);
    }

    private static int nameCost(String name, ItemStack input, int cost, ItemStack output) {
        if(name != null && !StringUtil.isBlank(name)) {
            if(!name.equals(input.getHoverName().getString())) {
                cost++;
                output.set(DataComponents.CUSTOM_NAME, Component.literal(name));
            }
        } else if(input.has(DataComponents.CUSTOM_NAME)) {
            cost++;
            output.remove(DataComponents.CUSTOM_NAME);
        }
        return cost;
    }

    @EventBusSubscriber(modid = DeeperDarker.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                Sheets.addWoodType(DDBlocks.ECHO);
                Sheets.addWoodType(DDBlocks.BLOOM);
                ItemProperties.register(DDItems.SOUL_ELYTRA.get(), ResourceLocation.withDefaultNamespace("broken"), (pStack, pLevel, pEntity, pSeed) -> SoulElytraItem.isFlyEnabled(pStack) ? 0 : 1);
                ItemProperties.register(DDItems.SCULK_TRANSMITTER.get(), DeeperDarker.rl("linked"), (pStack, pLevel, pEntity, pSeed) -> SculkTransmitterItem.isLinked(pStack) ? 1 : 0);
                ItemProperties.register(DDItems.SONOROUS_STAFF.get(), DeeperDarker.rl("charge"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.getUseItem() == pStack ? (pStack.getUseDuration(pEntity) - pEntity.getUseItemRemainingTicks()) / 123f : 0);
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
            EntityRenderers.register(DDEntities.SLUDGE.get(), SludgeRenderer::new);
            EntityRenderers.register(DDEntities.STALKER.get(), StalkerRenderer::new);
        }

        @SubscribeEvent
        public static void registerDimensionEffects(final RegisterDimensionSpecialEffectsEvent event) {
            event.register(OthersideDimension.OTHERSIDE_EFFECTS, new DimensionSpecialEffects.NetherEffects());
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
            event.registerLayerDefinition(SludgeRenderer.MODEL, SludgeModel::createInnerBodyModel);
            event.registerLayerDefinition(SludgeOuterLayer.OUTER_MODEL, SludgeModel::createOuterBodyModel);
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

    @EventBusSubscriber(modid = DeeperDarker.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
    public static class NeoForgeClientEvents {
        @SubscribeEvent
        public static void keyInput(final InputEvent.Key event) {
            if(Keybinds.BOOST.consumeClick()) PacketDistributor.sendToServer(new SoulElytraBoostPacket(true));
            else if(Keybinds.TRANSMIT.consumeClick()) PacketDistributor.sendToServer(new UseTransmitterPacket(true));
        }
    }
}
