package com.kyanite.deeperdarker.datagen.data.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.loot.AddItemModifier;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class DDLootModifierProvider extends GlobalLootModifierProvider {
    public DDLootModifierProvider(DataGenerator generator) {
        super(generator, DeeperDarker.MOD_ID);
    }

    @Override
    protected void start() {
        add("warden_carapace_from_ancient_city", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("chests/ancient_city")).build(), LootItemRandomChanceCondition.randomChance(0.2f).build() }, DDItems.WARDEN_CARAPACE.get()));
        add("warden_carapace_from_warden", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/warden")).build() }, DDItems.WARDEN_CARAPACE.get(), 3));
        add("warden_heart_from_warden", new AddItemModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/warden")).build() }, DDItems.HEART_OF_THE_DEEP.get()));
    }
}
