package com.kyanite.deeperdarker.compat.create;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.compat.create.client.DDCreatePartialModels;
import com.kyanite.deeperdarker.compat.create.client.WardenBacktankRenderer;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.equipment.armor.*;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.SingleAxisRotatingVisual;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.model.Models;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DDCreateCompat {
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(DeeperDarker.MOD_ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null)
            .setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                    .andThen(TooltipModifier.mapNull(KineticStats.create(item))));

    public static class Blocks {
        public static final Block WARDEN_BACKTANK = DDBlocks.registerWithoutItem("warden_backtank", new BacktankBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.NETHERITE_BLOCK)) {
            @Override
            public BlockEntityType<? extends BacktankBlockEntity> getBlockEntityType() {
                return BlockEntities.BACKTANK.get();
            }
        });

        public static void init() {
            DeeperDarker.LOGGER.debug("Registering blocks (Create)");
        }
    }

    public static class Items {
        public static final ItemEntry<? extends DivingHelmetItem> WARDEN_DIVING_HELMET = REGISTRATE.item("warden_diving_helmet", (properties) -> new DivingHelmetItem(DDArmorMaterials.WARDEN, properties, DeeperDarker.id("warden_diving")))
                .properties(p -> p.fireResistant().rarity(Rarity.RARE))
                .register();
        public static final ItemEntry<? extends DivingBootsItem> WARDEN_DIVING_BOOTS = REGISTRATE.item("warden_diving_boots", (properties) -> new DivingBootsItem(DDArmorMaterials.WARDEN, properties, DeeperDarker.id("warden_diving")))
                .properties(p -> p.fireResistant().rarity(Rarity.RARE))
                .register();
        public static final ItemEntry<BacktankItem.BacktankBlockItem> WARDEN_BACKTANK_PLACEABLE = REGISTRATE.item("warden_backtank_placeable", (properties) -> new BacktankItem.BacktankBlockItem(Blocks.WARDEN_BACKTANK, Items.WARDEN_BACKTANK::get, properties))
                .properties(p -> p.fireResistant().rarity(Rarity.RARE))
                .register();
        public static final ItemEntry<? extends BacktankItem> WARDEN_BACKTANK = REGISTRATE.item("warden_backtank", (properties) -> new BacktankItem.Layered(DDArmorMaterials.WARDEN, properties, DeeperDarker.id("warden_diving"), WARDEN_BACKTANK_PLACEABLE))
                .properties(p -> p.fireResistant().rarity(Rarity.RARE).durability(-1))
                .register();

        public static void init() {
            DeeperDarker.LOGGER.debug("Registering items (Create)");
        }
    }

    public static class BlockEntities {
        public static final BlockEntityEntry<BacktankBlockEntity> BACKTANK;

        static {
            BACKTANK = REGISTRATE.blockEntity("backtank", BacktankBlockEntity::new)
                    .visual(() -> BlockEntities::backtank)
                    .validBlock(() -> Blocks.WARDEN_BACKTANK)
                    .renderer(() -> WardenBacktankRenderer::new)
                    .register();
        }

        public static <T extends KineticBlockEntity> SingleAxisRotatingVisual<T> backtank(VisualizationContext context, T blockEntity, float partialTick) {
            var model = Models.partial(DDCreatePartialModels.SHAFT_MODEL);
            return new SingleAxisRotatingVisual<>(context, blockEntity, partialTick, model);
        }

        public static void init() {
            DeeperDarker.LOGGER.debug("Registering block entities (Create)");
        }
    }

    public static void lavaSwimming(LivingEntity entity) {
        ItemStack bootsStack = DivingBootsItem.getWornItem(entity);
        if (DDCreateCompat.Items.WARDEN_DIVING_BOOTS.isIn(bootsStack))
            entity.setDeltaMovement(entity.getDeltaMovement().multiply(DivingBootsItem.getMovementMultiplier(entity)));
    }

    public static void init() {
        DDCreateCompat.BlockEntities.init();
        DDCreateCompat.Blocks.init();
        DDCreateCompat.Items.init();
        DeeperDarker.LOGGER.debug("Initializing Create compatibility");
    }
}
