package com.kyanite.deeperdarker.datagen.data.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.misc.AddItemModifier;
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
        add("resonarium_upgrade_from_ancient_city", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build(), LootItemRandomChanceCondition.randomChance(0.44721f).build() }, DDItems.RESONARIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("resonarium_upgrade_from_common_trial_chambers", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/trial_chambers/reward_common")).build(), LootItemRandomChanceCondition.randomChance(0.28285f).build() }, DDItems.RESONARIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("resonarium_upgrade_from_stronghold_corridor", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/stronghold_corridor")).build(), LootItemRandomChanceCondition.randomChance(0.31623f).build() }, DDItems.RESONARIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("warden_upgrade_from_ancient_city", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build(), LootItemRandomChanceCondition.randomChance(0.44721f).build() }, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE.get()));
    }
}
