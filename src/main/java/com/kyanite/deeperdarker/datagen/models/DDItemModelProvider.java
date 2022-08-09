package com.kyanite.deeperdarker.datagen.models;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.DataGenerator;
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
        itemModel(DDBlocks.BONE_DOOR, GENERATED);
        blockModel(DDBlocks.BONE_TRAPDOOR, "bottom");
        blockModel(DDBlocks.BONE_FENCE_GATE);
        itemModel(DDItems.BONE_SIGN, GENERATED);

        blockModel(DDBlocks.SCULK_BONE_BLOCK);
        blockModel(DDBlocks.SCULK_BONE_PLANKS);
        blockModel(DDBlocks.SCULK_BONE_SLAB);
        blockModel(DDBlocks.SCULK_BONE_STAIRS);
        blockModel(DDBlocks.SCULK_BONE_FENCE, "inventory");
        blockModel(DDBlocks.SCULK_BONE_BUTTON, "inventory");
        blockModel(DDBlocks.SCULK_BONE_PRESSURE_PLATE);
        itemModel(DDBlocks.SCULK_BONE_DOOR, GENERATED);
        blockModel(DDBlocks.SCULK_BONE_TRAPDOOR, "bottom");
        blockModel(DDBlocks.SCULK_BONE_FENCE_GATE);
        itemModel(DDItems.SCULK_BONE_SIGN, GENERATED);

        blockModel(DDBlocks.SCULK_STONE);
        blockModel(DDBlocks.SCULK_STONE_SLAB);
        blockModel(DDBlocks.SCULK_STONE_STAIRS);
        blockModel(DDBlocks.SCULK_STONE_WALL, "inventory");

        blockModel(DDBlocks.COBBLED_SCULK_STONE);
        blockModel(DDBlocks.COBBLED_SCULK_STONE_SLAB);
        blockModel(DDBlocks.COBBLED_SCULK_STONE_STAIRS);
        blockModel(DDBlocks.COBBLED_SCULK_STONE_WALL, "inventory");

        blockModel(DDBlocks.POLISHED_SCULK_STONE);
        blockModel(DDBlocks.POLISHED_SCULK_STONE_SLAB);
        blockModel(DDBlocks.POLISHED_SCULK_STONE_STAIRS);
        blockModel(DDBlocks.POLISHED_SCULK_STONE_WALL, "inventory");

        blockModel(DDBlocks.SCULK_STONE_BRICKS);
        blockModel(DDBlocks.SCULK_STONE_BRICK_SLAB);
        blockModel(DDBlocks.SCULK_STONE_BRICK_STAIRS);
        blockModel(DDBlocks.SCULK_STONE_BRICK_WALL, "inventory");

        blockModel(DDBlocks.SCULK_STONE_COAL_ORE);
        blockModel(DDBlocks.SCULK_STONE_IRON_ORE);
        blockModel(DDBlocks.SCULK_STONE_COPPER_ORE);
        blockModel(DDBlocks.SCULK_STONE_GOLD_ORE);
        blockModel(DDBlocks.SCULK_STONE_REDSTONE_ORE);
        blockModel(DDBlocks.SCULK_STONE_EMERALD_ORE);
        blockModel(DDBlocks.SCULK_STONE_LAPIS_ORE);
        blockModel(DDBlocks.SCULK_STONE_DIAMOND_ORE);
        blockModel(DDBlocks.GLOOM_GRASS);
        blockModel(DDBlocks.SCULK_TRANSMITTER);

        blockModel(DDBlocks.INFESTED_SCULK);
        blockModel(DDBlocks.SCULK_GLEAM);
        blockModel(DDBlocks.ANCIENT_VASE);
        getBuilder(DDBlocks.SCULK_VINES.getId().getPath()).parent(GENERATED).texture("layer0", "block/" + DDBlocks.SCULK_VINES_PLANT.getId().getPath());

        // ITEMS
        itemModel(DDItems.WARDEN_CARAPACE, GENERATED);
        itemModel(DDItems.WARDEN_HELMET, GENERATED);
        itemModel(DDItems.WARDEN_CHESTPLATE, GENERATED);
        itemModel(DDItems.WARDEN_LEGGINGS, GENERATED);
        itemModel(DDItems.WARDEN_BOOTS, GENERATED);
        itemModel(DDItems.HEART_OF_THE_DEEP, GENERATED);
        itemModel(DDItems.REINFORCED_ECHO_SHARD, GENERATED);
        itemModel(DDItems.GLOOM_BERRIES, GENERATED);

        withExistingParent(DDItems.SHRIEK_WORM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(DDItems.SCULK_LEECH_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(DDItems.SCULK_SNAPPER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(DDItems.SHATTERED_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    public void blockModel(RegistryObject<? extends Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    public void blockModel(RegistryObject<? extends Block> block, String suffix) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath() + "_" + suffix));
    }

    public <T> void itemModel(RegistryObject<T> item, ModelFile modelFile) {
        getBuilder(item.getId().getPath()).parent(modelFile).texture("layer0", "item/" + item.getId().getPath());
    }
}
