package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class DeeperDarkerModelProvider extends FabricModelProvider {
    public DeeperDarkerModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(DeeperDarkerBlocks.ECHO_LOG).log(DeeperDarkerBlocks.ECHO_LOG).wood(DeeperDarkerBlocks.ECHO_WOOD);
        blockStateModelGenerator.registerLog(DeeperDarkerBlocks.STRIPPED_ECHO_LOG).log(DeeperDarkerBlocks.STRIPPED_ECHO_LOG).wood(DeeperDarkerBlocks.STRIPPED_ECHO_WOOD);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_HOE, Models.HANDHELD);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.REINFORCED_ECHO_SHARD, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_CARAPACE, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.HEART_OF_THE_DEEP, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.SOUL_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.SOUL_DUST, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.SCULK_BONE, Models.GENERATED);
    }
}
