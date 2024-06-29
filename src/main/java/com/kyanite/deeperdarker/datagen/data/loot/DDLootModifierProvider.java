package com.kyanite.deeperdarker.datagen.data.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class DDLootModifierProvider extends GlobalLootModifierProvider {
    public DDLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DeeperDarker.MOD_ID);
    }

    @Override
    protected void start() {
        add("warden_carapace_from_ancient_city", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build(), LootItemRandomChanceCondition.randomChance(0.2f).build() }, DDItems.WARDEN_CARAPACE.get()));
        add("warden_carapace_from_warden", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("entities/warden")).build() }, DDItems.WARDEN_CARAPACE.get(), 3));
        add("warden_heart_from_warden", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("entities/warden")).build() }, DDItems.HEART_OF_THE_DEEP.get()));
        add("warden_upgrade_from_ancient_city", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build(), LootItemRandomChanceCondition.randomChance(0.45f).build()  }, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE.get()));
    }
}
