package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.OthersideReceivingLevelScreen;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.blocks.AncientVaseBlock;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import com.kyanite.deeperdarker.content.blocks.entity.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.blocks.vegetation.IceLilyBlock;
import com.kyanite.deeperdarker.content.misc.PortalData;
import com.kyanite.deeperdarker.network.SoulElytraClientPacket;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.structures.DDStructures;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.WinScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.AddAttributeTooltipsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.entity.living.LivingUseTotemEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = DeeperDarker.MOD_ID)
public class DeeperDarkerEvents {
    @SubscribeEvent
    public static void registerBrewingRecipes(final RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, DDItems.GLEAM_GEL.get(), DDPotions.GLOWING);

        builder.addMix(Potions.AWKWARD, DDItems.SOUL_CRYSTAL.get(), DDPotions.SCULK_AFFINITY);
        builder.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.SCULK_AFFINITY);
        builder.addMix(DDPotions.SCULK_AFFINITY, Items.REDSTONE, DDPotions.LONG_SCULK_AFFINITY);
        builder.addMix(Potions.LONG_INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.LONG_SCULK_AFFINITY);
    }

    @SubscribeEvent
    public static void playerTickEvent(final PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if(player.level() instanceof ServerLevel level && player.hasEffect(MobEffects.BAD_OMEN)) {
            StructureStart structureStart = level.structureManager().getStructureWithPieceAt(player.blockPosition(), structureHolder -> structureHolder.is(DDStructures.ANCIENT_TEMPLE));
            if(!structureStart.isValid()) return;

            int amplifier = player.getEffect(MobEffects.BAD_OMEN).getAmplifier();
            player.removeEffect(MobEffects.BAD_OMEN);
            player.addEffect(new MobEffectInstance(DDEffects.SCULK_OMEN, 18000, amplifier));
        }
    }

    @SubscribeEvent
    public static void clientTickEvent(final ClientTickEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        Screen screen = minecraft.screen;

        if(player == null) return;
        if(screen instanceof OthersideReceivingLevelScreen) return;

        PortalData data = player.getData(DDDataAttachments.PORTAL_DATA);
        data.oPortalIntensity = data.portalIntensity;
        float f = 0f;

        if(player.portalProcess != null && player.portalProcess.isInsidePortalThisTick() && player.portalProcess.isSamePortal(DDBlocks.OTHERSIDE_PORTAL.get())) {
            if(screen != null && !screen.isPauseScreen() && !(screen instanceof DeathScreen) && !(screen instanceof WinScreen)) {
                if(screen instanceof AbstractContainerScreen) player.closeContainer();
                minecraft.setScreen(null);
            }

            if(data.portalIntensity == 0) player.playSound(SoundEvents.PORTAL_TRIGGER, player.getRandom().nextFloat() * 0.4f + 0.8f, 0.25f);

            f = 0.0125f;
            player.portalProcess.setAsInsidePortalThisTick(false);
        } else if(data.portalIntensity > 0) {
            f = -0.05f;
        }

        data.portalIntensity = Mth.clamp(data.portalIntensity + f, 0f, 1f);
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
                if(blockEntity.hasLeech() && level instanceof ServerLevel serverLevel) DDEntities.SCULK_LEECH.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                else Block.popResource(level, pos, blockEntity.getLoot());
            } else if(silktouch && !level.isClientSide() && state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                CompoundTag tag = new CompoundTag();
                tag.put("item", blockEntity.getLoot().saveOptional(level.registryAccess()));
                tag.putBoolean("leech", blockEntity.hasLeech());

                ItemStack stack = new ItemStack(DDBlocks.CRYSTALLIZED_AMBER.get());
                BlockItem.setBlockEntityData(stack, DDBlockEntities.CRYSTALLIZED_AMBER.get(), tag);
                Block.popResource(level, pos, stack);

                level.removeBlock(pos, false);
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

            level.removeBlock(pos, false);
            event.setCanceled(true);
        }

        if(state.is(DDBlocks.ANCIENT_VASE)) {
            if(level instanceof ServerLevel serverLevel) {
                Player player = event.getPlayer();
                double multiplier = 1;
                if(player.hasEffect(DDEffects.SCULK_OMEN)) {
                    multiplier = player.getEffect(DDEffects.SCULK_OMEN).getAmplifier() + 1.1;
                    multiplier = Math.pow(multiplier, 8 / 9.0);
                }

                RandomSource random = serverLevel.getRandom();
                if(level.getDifficulty() != Difficulty.PEACEFUL && level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING) && !state.getValue(AncientVaseBlock.SAFE) && random.nextDouble() < DeeperDarkerConfig.CONFIG.fakeVaseChance.get() * multiplier) {
                    if(random.nextDouble() < 1 - DeeperDarkerConfig.CONFIG.stalkerSpawnChance.get()) {
                        for(int i = 0; i < random.nextInt(1, 4); i++) {
                            DDEntities.SCULK_LEECH.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                        }
                    } else {
                        DDEntities.STALKER.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                    }

                    serverLevel.removeBlock(pos, false);
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
                stack.hurtAndBreak((int) (event.getOriginalDamage() / 2f), entity, armor.getEquipmentSlot());
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
    public static void useTotemEvent(final LivingUseTotemEvent event) {
        MobEffectInstance effect = new MobEffectInstance(DDEffects.SCULK_AFFINITY, 600);
        effect.getCures().clear();
        event.getEntity().addEffect(effect);
    }

    @SubscribeEvent
    public static void attributeTooltipsEvent(final AddAttributeTooltipsEvent event) {
        if(event.getStack().is(DDTags.Items.DAMPENS_VIBRATIONS)) {
            event.addTooltipLines(Component.translatable("item." + DeeperDarker.MOD_ID + ".dampens_vibrations").withStyle(ChatFormatting.BLUE));
        }
    }
}
