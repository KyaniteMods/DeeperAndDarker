package com.kyanite.deeperdarker.datagen.assets;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DDItemModelProvider extends ItemModelProvider {
    private final ModelFile GENERATED = getExistingFile(mcLoc("item/generated"));
    private final ModelFile HANDHELD = getExistingFile(mcLoc("item/handheld"));

    public DDItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DeeperDarker.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        blockModel(DDBlocks.ECHO_LOG);
        blockModel(DDBlocks.ECHO_WOOD);
        blockModel(DDBlocks.STRIPPED_ECHO_LOG);
        blockModel(DDBlocks.STRIPPED_ECHO_WOOD);
        blockModel(DDBlocks.ECHO_PLANKS);
        blockModel(DDBlocks.ECHO_STAIRS);
        blockModel(DDBlocks.ECHO_SLAB);
        blockModel(DDBlocks.ECHO_FENCE, "inventory");
        blockModel(DDBlocks.ECHO_FENCE_GATE);
        itemModel(DDBlocks.ECHO_DOOR, GENERATED).renderType("translucent");
        blockModel(DDBlocks.ECHO_TRAPDOOR, "bottom");
        blockModel(DDBlocks.ECHO_PRESSURE_PLATE);
        blockModel(DDBlocks.ECHO_BUTTON, "inventory");
        blockModel(DDBlocks.ECHO_LEAVES);

        blockModel(DDBlocks.SCULK_STONE);
        blockModel(DDBlocks.SCULK_STONE_STAIRS);
        blockModel(DDBlocks.SCULK_STONE_SLAB);
        blockModel(DDBlocks.SCULK_STONE_WALL, "inventory");
        blockModel(DDBlocks.COBBLED_SCULK_STONE);
        blockModel(DDBlocks.COBBLED_SCULK_STONE_STAIRS);
        blockModel(DDBlocks.COBBLED_SCULK_STONE_SLAB);
        blockModel(DDBlocks.COBBLED_SCULK_STONE_WALL, "inventory");
        blockModel(DDBlocks.POLISHED_SCULK_STONE);
        blockModel(DDBlocks.POLISHED_SCULK_STONE_STAIRS);
        blockModel(DDBlocks.POLISHED_SCULK_STONE_SLAB);
        blockModel(DDBlocks.POLISHED_SCULK_STONE_WALL, "inventory");
        blockModel(DDBlocks.SCULK_STONE_BRICKS);
        blockModel(DDBlocks.SCULK_STONE_BRICK_STAIRS);
        blockModel(DDBlocks.SCULK_STONE_BRICK_SLAB);
        blockModel(DDBlocks.SCULK_STONE_BRICK_WALL, "inventory");
        blockModel(DDBlocks.SCULK_STONE_TILES);
        blockModel(DDBlocks.SCULK_STONE_TILE_STAIRS);
        blockModel(DDBlocks.SCULK_STONE_TILE_SLAB);
        blockModel(DDBlocks.SCULK_STONE_TILE_WALL, "inventory");
        blockModel(DDBlocks.SMOOTH_SCULK_STONE);
        blockModel(DDBlocks.SMOOTH_SCULK_STONE_STAIRS);
        blockModel(DDBlocks.SMOOTH_SCULK_STONE_SLAB);
        blockModel(DDBlocks.SMOOTH_SCULK_STONE_WALL, "inventory");
        blockModel(DDBlocks.CUT_SCULK_STONE);
        blockModel(DDBlocks.CUT_SCULK_STONE_STAIRS);
        blockModel(DDBlocks.CUT_SCULK_STONE_SLAB);
        blockModel(DDBlocks.CUT_SCULK_STONE_WALL, "inventory");
        blockModel(DDBlocks.CHISELED_SCULK_STONE);

        blockModel(DDBlocks.SCULK_GRIME);
        blockModel(DDBlocks.SCULK_GRIME_BRICKS);
        blockModel(DDBlocks.SCULK_GRIME_BRICK_STAIRS);
        blockModel(DDBlocks.SCULK_GRIME_BRICK_SLAB);
        blockModel(DDBlocks.SCULK_GRIME_BRICK_WALL, "inventory");

        blockModel(DDBlocks.GLOOMSLATE);
        blockModel(DDBlocks.GLOOMSLATE_STAIRS);
        blockModel(DDBlocks.GLOOMSLATE_SLAB);
        blockModel(DDBlocks.GLOOMSLATE_WALL, "inventory");
        blockModel(DDBlocks.COBBLED_GLOOMSLATE);
        blockModel(DDBlocks.COBBLED_GLOOMSLATE_STAIRS);
        blockModel(DDBlocks.COBBLED_GLOOMSLATE_SLAB);
        blockModel(DDBlocks.COBBLED_GLOOMSLATE_WALL, "inventory");
        blockModel(DDBlocks.POLISHED_GLOOMSLATE);
        blockModel(DDBlocks.POLISHED_GLOOMSLATE_STAIRS);
        blockModel(DDBlocks.POLISHED_GLOOMSLATE_SLAB);
        blockModel(DDBlocks.POLISHED_GLOOMSLATE_WALL, "inventory");
        blockModel(DDBlocks.GLOOMSLATE_BRICKS);
        blockModel(DDBlocks.GLOOMSLATE_BRICK_STAIRS);
        blockModel(DDBlocks.GLOOMSLATE_BRICK_SLAB);
        blockModel(DDBlocks.GLOOMSLATE_BRICK_WALL, "inventory");
        blockModel(DDBlocks.GLOOMSLATE_TILES);
        blockModel(DDBlocks.GLOOMSLATE_TILE_STAIRS);
        blockModel(DDBlocks.GLOOMSLATE_TILE_SLAB);
        blockModel(DDBlocks.GLOOMSLATE_TILE_WALL, "inventory");
        blockModel(DDBlocks.SMOOTH_GLOOMSLATE);
        blockModel(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS);
        blockModel(DDBlocks.SMOOTH_GLOOMSLATE_SLAB);
        blockModel(DDBlocks.SMOOTH_GLOOMSLATE_WALL, "inventory");
        blockModel(DDBlocks.CUT_GLOOMSLATE);
        blockModel(DDBlocks.CUT_GLOOMSLATE_STAIRS);
        blockModel(DDBlocks.CUT_GLOOMSLATE_SLAB);
        blockModel(DDBlocks.CUT_GLOOMSLATE_WALL, "inventory");
        blockModel(DDBlocks.CHISELED_GLOOMSLATE);

        blockModel(DDBlocks.ECHO_SOIL);
        blockModel(DDBlocks.GLOOMY_SCULK);
        blockModel(DDBlocks.GLOOMY_GEYSER);
        blockModel(DDBlocks.CRYSTALLIZED_AMBER);
        blockModel(DDBlocks.SCULK_GLEAM);
        blockModel(DDBlocks.SCULK_JAW);

        blockModel(DDBlocks.SCULK_STONE_COAL_ORE);
        blockModel(DDBlocks.SCULK_STONE_IRON_ORE);
        blockModel(DDBlocks.SCULK_STONE_COPPER_ORE);
        blockModel(DDBlocks.SCULK_STONE_GOLD_ORE);
        blockModel(DDBlocks.SCULK_STONE_REDSTONE_ORE);
        blockModel(DDBlocks.SCULK_STONE_EMERALD_ORE);
        blockModel(DDBlocks.SCULK_STONE_LAPIS_ORE);
        blockModel(DDBlocks.SCULK_STONE_DIAMOND_ORE);

        getBuilder(DDBlocks.GLOOMY_GRASS.getId().getPath()).parent(GENERATED).texture("layer0", "block/" + DDBlocks.GLOOMY_GRASS.getId().getPath());
        blockModel(DDBlocks.GLOOMY_CACTUS);
        getBuilder(DDBlocks.SCULK_TENDRILS.getId().getPath()).parent(GENERATED).texture("layer0", "block/" + DDBlocks.SCULK_TENDRILS_PLANT.getId().getPath());
        getBuilder(DDBlocks.SCULK_VINES.getId().getPath()).parent(GENERATED).texture("layer0", "block/" + DDBlocks.SCULK_VINES_PLANT.getId().getPath());

        blockModel(DDBlocks.ANCIENT_VASE);

        withExistingParent(DDBlocks.INFESTED_SCULK.getId().getPath(), mcLoc("block/sculk"));

        itemModelWithSuffix(DDItems.SOUL_ELYTRA, GENERATED, "broken");
        itemModel(DDItems.ECHO_SIGN, GENERATED);
        itemModel(DDItems.ECHO_HANGING_SIGN, GENERATED);
        itemModel(DDItems.ECHO_BOAT, GENERATED);
        itemModel(DDItems.ECHO_CHEST_BOAT, GENERATED);

        itemModel(DDItems.GRIME_BALL, GENERATED);
        itemModel(DDItems.GRIME_BRICK, GENERATED);

        itemModel(DDItems.WARDEN_SHOVEL, HANDHELD);
        itemModel(DDItems.WARDEN_PICKAXE, HANDHELD);
        itemModel(DDItems.WARDEN_AXE, HANDHELD);
        itemModel(DDItems.WARDEN_HOE, HANDHELD);
        itemModel(DDItems.WARDEN_SWORD, HANDHELD);
        itemModel(DDItems.WARDEN_HELMET, GENERATED);
        itemModel(DDItems.WARDEN_CHESTPLATE, GENERATED);
        itemModel(DDItems.WARDEN_LEGGINGS, GENERATED);
        itemModel(DDItems.WARDEN_BOOTS, GENERATED);

        itemModel(DDItems.SCULK_BONE, GENERATED);
        itemModel(DDItems.SOUL_DUST, GENERATED);
        itemModel(DDItems.SOUL_CRYSTAL, GENERATED);
        itemModel(DDItems.HEART_OF_THE_DEEP, GENERATED);
        itemModel(DDItems.WARDEN_CARAPACE, GENERATED);
        itemModel(DDItems.REINFORCED_ECHO_SHARD, GENERATED);

        itemModelWithSuffix(DDItems.SCULK_TRANSMITTER, GENERATED, "on");
        itemModel(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, GENERATED);

        spawnEggModel(DDItems.SCULK_CENTIPEDE_SPAWN_EGG);
        spawnEggModel(DDItems.SCULK_LEECH_SPAWN_EGG);
        spawnEggModel(DDItems.SCULK_SNAPPER_SPAWN_EGG);
        spawnEggModel(DDItems.SHATTERED_SPAWN_EGG);
        spawnEggModel(DDItems.SHRIEK_WORM_SPAWN_EGG);
        spawnEggModel(DDItems.STALKER_SPAWN_EGG);
    }

    private void spawnEggModel(RegistryObject<Item> egg) {
        withExistingParent(egg.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    public void blockModel(RegistryObject<? extends Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    public void blockModel(RegistryObject<? extends Block> block, String suffix) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath() + "_" + suffix));
    }

    public ItemModelBuilder itemModel(RegistryObject<?> item, ModelFile modelFile) {
        return getBuilder(item.getId().getPath()).parent(modelFile).texture("layer0", "item/" + item.getId().getPath());
    }

    public void itemModelWithSuffix(RegistryObject<?> item, ModelFile modelFile, String suffix) {
        getBuilder(item.getId().getPath() + "_" + suffix).parent(modelFile).texture("layer0", "item/" + item.getId().getPath() + "_" + suffix);
    }
}
