package com.kyanite.deeperdarker.compat;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.simibubi.create.content.equipment.armor.BacktankBlock;
import com.simibubi.create.content.equipment.armor.BacktankItem;
import com.simibubi.create.content.equipment.armor.DivingHelmetItem;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DDCreateCompat {
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(DeeperDarker.MOD_ID).defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    public static class Blocks {
        public static final Block WARDEN_BACKTANK = DDBlocks.registerWithoutItem("warden_backtank", new BacktankBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.NETHERITE_BLOCK)));

        public static void init() {
            DeeperDarker.LOGGER.debug("Registering blocks (Create)");
            BlockStressDefaults.setDefaultImpact(BuiltInRegistries.BLOCK.getKey(WARDEN_BACKTANK), 4.0);
        }
    }

    public static class Items {
        public static final Item WARDEN_DIVING_HELMET = DDItems.register("warden_diving_helmet", new DivingHelmetItem(DDArmorMaterials.WARDEN, new Item.Properties(), new ResourceLocation(DeeperDarker.MOD_ID, "warden_diving")));
        public static final Item WARDEN_BACKTANK_PLACEABLE = DDItems.register("warden_backtank_placeable", new BacktankItem.BacktankBlockItem(Blocks.WARDEN_BACKTANK, () -> Items.WARDEN_BACKTANK, new Item.Properties()));
        public static final Item WARDEN_BACKTANK = DDItems.register("warden_backtank", new BacktankItem(DDArmorMaterials.WARDEN, new Item.Properties().fireResistant().durability(-1), new ResourceLocation(DeeperDarker.MOD_ID, "warden_backtank"), () -> (BacktankItem.BacktankBlockItem) WARDEN_BACKTANK_PLACEABLE));

        public static void init() {
            DeeperDarker.LOGGER.debug("Registering items (Create)");
        }
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Initializing Create compatibility");
    }
}
