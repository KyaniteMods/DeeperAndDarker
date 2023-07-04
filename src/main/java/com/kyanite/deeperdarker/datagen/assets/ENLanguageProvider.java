package com.kyanite.deeperdarker.datagen.assets;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.registries.DDBlocks;
import com.kyanite.deeperdarker.registries.DDItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ENLanguageProvider extends LanguageProvider {
    public ENLanguageProvider(PackOutput output) {
        super(output, DeeperDarker.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + DeeperDarker.MOD_ID, "Deeper And Darker");
        add("entity." + DeeperDarker.MOD_ID + ".deeper_darker_chest_boat", "Boat with Chest");

        DDBlocks.BLOCKS.getEntries().forEach(block -> add(block, "block"));
        DDItems.ITEMS.getEntries().stream().filter(item -> !(item.get() instanceof BlockItem)).forEach(item -> add(item, "item"));
    }

    private void add(RegistryObject<?> entry, String prefix) {
        if(filter(entry)) return;
        String key = entry.getId().getPath();
        add(prefix + "." + DeeperDarker.MOD_ID + "." + key, convertToName(key));
    }

    private boolean filter(RegistryObject<?> entry) {
        return entry.get() instanceof WallSignBlock || entry.get() instanceof WallHangingSignBlock;
    }

    private String convertToName(String key) {
        StringBuilder builder = new StringBuilder(key.substring(0, 1).toUpperCase() + key.substring(1));
        for(int i = 1; i < builder.length(); i++) {
            if(builder.charAt(i) == '_') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, " " + Character.toUpperCase(builder.charAt(i)));
            }
        }

        String name = builder.toString();
        if(name.contains("Chest")) name = name.replace("Chest ", "") + " With Chest";
        if(name.contains(" Block")) name = "Block of " + name.replace(" Block", "");

        return name;
    }
}
