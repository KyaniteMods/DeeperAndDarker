package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class DDLootModifierProvider extends GlobalLootModifierProvider {
    public DDLootModifierProvider(PackOutput output) {
        super(output, DeeperDarker.MOD_ID);
    }

    @Override
    protected void start() {
        add("warden_upgrade_from_ancient_city", new AddItemModifier(new LootItemCondition[]{ new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build() }, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE.get()));
    }
}
