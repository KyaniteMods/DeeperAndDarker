package com.kyanite.deeperdarker.util.datagen.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

public class DDEntityLootTableProvider extends SimpleFabricLootTableProvider {
    public static final ResourceKey<LootTable> ANGLER_FISH = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/angler_fish"));
    public static final ResourceKey<LootTable> SCULK_CENTIPEDE = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/sculk_centipede"));
    public static final ResourceKey<LootTable> SCULK_LEECH = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/sculk_leech"));
    public static final ResourceKey<LootTable> SCULK_SNAPPER = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/sculk_snapper"));
    public static final ResourceKey<LootTable> SHATTERED = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/shattered"));
    public static final ResourceKey<LootTable> SHRIEK_WORM = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/shriek_worm"));
    public static final ResourceKey<LootTable> STALKER = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/stalker"));

    private final HolderLookup.Provider provider;

    public DDEntityLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup, LootContextParamSets.ENTITY);
        try {
            this.provider = registryLookup.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(ANGLER_FISH, LootTable.lootTable());
        biConsumer.accept(SCULK_CENTIPEDE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(Items.STRING)).apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.provider, UniformGenerator.between(0, 1)))));
        biConsumer.accept(SCULK_LEECH, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST).apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.provider, UniformGenerator.between(0, 1))))));
        biConsumer.accept(SCULK_SNAPPER, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.provider, UniformGenerator.between(0, 1))))));
        biConsumer.accept(SHATTERED, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SCULK_BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.provider, UniformGenerator.between(0, 1))))));
        biConsumer.accept(SHRIEK_WORM, LootTable.lootTable());
        biConsumer.accept(STALKER, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_CRYSTAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));
    }
}
