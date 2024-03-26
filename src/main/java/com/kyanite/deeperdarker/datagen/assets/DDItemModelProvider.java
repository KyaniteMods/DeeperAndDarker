package com.kyanite.deeperdarker.datagen.assets;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.items.DDItems;
import com.kyanite.deeperdarker.datagen.util.NameUtility;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DDItemModelProvider extends ItemModelProvider {

    public DDItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DeeperDarker.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(DDItems.HEART_OF_THE_DEEP.get());
        item(DDItems.WARDEN_CARAPACE.get());
        item(DDItems.REINFORCED_ECHO_SHARD.get());
        item(DDItems.SCULK_BONE.get());
        item(DDItems.SOUL_DUST.get());
        item(DDItems.SOUL_CRYSTAL.get());
    }

    private void item(Item item) {
        String name = NameUtility.getItemName(item);
        getBuilder(name).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "item/" + name);
    }
}
