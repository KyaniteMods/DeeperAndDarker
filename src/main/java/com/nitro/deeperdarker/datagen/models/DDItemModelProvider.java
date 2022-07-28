package com.nitro.deeperdarker.datagen.models;

import com.nitro.deeperdarker.DeeperAndDarker;
import com.nitro.deeperdarker.registry.blocks.DDBlocks;
import com.nitro.deeperdarker.registry.items.DDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DDItemModelProvider extends ItemModelProvider {
    private final ModelFile GENERATED = getExistingFile(mcLoc("item/generated"));

    public DDItemModelProvider(DataGenerator pGenerator, ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, DeeperAndDarker.MOD_ID, pExistingFileHelper);
    }

    @Override
    protected void registerModels() {
        // BLOCKS
        blockModel(DDBlocks.BONE_PLANKS);
        blockModel(DDBlocks.BONE_SLAB);
        blockModel(DDBlocks.BONE_STAIRS);
        blockModel(DDBlocks.BONE_FENCE, "inventory");
        blockModel(DDBlocks.BONE_BUTTON, "inventory");
        blockModel(DDBlocks.BONE_PRESSURE_PLATE);
        doorModel(DDBlocks.BONE_DOOR);
        blockModel(DDBlocks.BONE_TRAPDOOR, "bottom");
        blockModel(DDBlocks.BONE_FENCE_GATE);

        blockModel(DDBlocks.SCULK_BONE_BLOCK);
        blockModel(DDBlocks.SCULK_BONE_PLANKS);
        blockModel(DDBlocks.SCULK_BONE_SLAB);
        blockModel(DDBlocks.SCULK_BONE_STAIRS);
        blockModel(DDBlocks.SCULK_BONE_FENCE, "inventory");
        blockModel(DDBlocks.SCULK_BONE_BUTTON, "inventory");
        blockModel(DDBlocks.SCULK_BONE_PRESSURE_PLATE);
        doorModel(DDBlocks.SCULK_BONE_DOOR);
        blockModel(DDBlocks.SCULK_BONE_TRAPDOOR, "bottom");
        blockModel(DDBlocks.SCULK_BONE_FENCE_GATE);

        // ITEMS
        itemModel(DDItems.WARDEN_CARAPACE, GENERATED);
        itemModel(DDItems.WARDEN_HELMET, GENERATED);
        itemModel(DDItems.WARDEN_CHESTPLATE, GENERATED);
        itemModel(DDItems.WARDEN_LEGGINGS, GENERATED);
        itemModel(DDItems.WARDEN_BOOTS, GENERATED);
    }

    public void blockModel(RegistryObject<? extends Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    public void blockModel(RegistryObject<? extends Block> block, String suffix) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath() + "_" + suffix));
    }

    public void itemModel(RegistryObject<Item> item, ModelFile modelFile) {
        getBuilder(item.getId().getPath()).parent(modelFile).texture("layer0", "item/" + item.getId().getPath());
    }

    public void doorModel(RegistryObject<? extends Block> block) {
        getBuilder(block.getId().getPath()).parent(GENERATED).texture("layer0", "item/" + block.getId().getPath());
    }
}
