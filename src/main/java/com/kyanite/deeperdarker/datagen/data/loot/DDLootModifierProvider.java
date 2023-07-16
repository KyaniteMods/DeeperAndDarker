package com.kyanite.deeperdarker.datagen.data.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class DDLootModifierProvider extends GlobalLootModifierProvider {
    public DDLootModifierProvider(PackOutput output) {
        super(output, DeeperDarker.MOD_ID);
    }

    @Override
    protected void start() {
        add("warden_upgrade_from_ancient_city", new AddItemModifier(new LootItemCondition[]{ new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build() }, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE.get()));
        add("warden_carapace_from_ancient_city", new AddItemModifier(new LootItemCondition[]{ new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(), LootItemRandomChanceCondition.randomChance(0.2f).build() }, DDItems.WARDEN_CARAPACE.get()));
        add("warden_carapace_from_warden", new AddItemModifier(new LootItemCondition[]{ new LootTableIdCondition.Builder(new ResourceLocation("entities/warden")).build() }, DDItems.WARDEN_CARAPACE.get()));
    }
}
