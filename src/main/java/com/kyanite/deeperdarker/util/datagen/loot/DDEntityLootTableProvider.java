package com.kyanite.deeperdarker.util.datagen.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlockItems;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.util.SetPaintingVariantFunction;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SlimePredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
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
    public static final ResourceKey<LootTable> SLUDGE = ResourceKey.create(Registries.LOOT_TABLE, BuiltInRegistries.ENTITY_TYPE.getKey(DDEntities.SLUDGE).withPrefix("entities/"));
    public static final ResourceKey<LootTable> STALKER = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/stalker"));
    public static final ResourceKey<LootTable> BLOOMING_GOLEM = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/blooming_golem"));
    public static final ResourceKey<LootTable> POTTY = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/potty"));
    public static final ResourceKey<LootTable> POT = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/pot"));
    public static final ResourceKey<LootTable> POTTER = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/potter"));
    public static final ResourceKey<LootTable> OVERCAST_VESSEL = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/overcast_vessel"));
    public static final ResourceKey<LootTable> ACID_SPRITE = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/acid_sprite"));
    public static final ResourceKey<LootTable> OVERSEER = ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.id("entities/overseer"));

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
        biConsumer.accept(SCULK_CENTIPEDE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(Items.STRING)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0, 1)))
                )
        ));
        biConsumer.accept(SCULK_LEECH, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.SOUL_DUST)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0, 1)))
                )
        ));
        biConsumer.accept(SCULK_SNAPPER, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.SOUL_DUST)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0, 1))))
        ));
        biConsumer.accept(SHATTERED, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.SCULK_BONE)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0, 1))))
        ));
        biConsumer.accept(SHRIEK_WORM, LootTable.lootTable());
        biConsumer.accept(SLUDGE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.RESONARIUM)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0, 1)))
                ).when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().subPredicate(SlimePredicate.sized(MinMaxBounds.Ints.exactly(1)))))
        ));
        biConsumer.accept(STALKER, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.SOUL_CRYSTAL)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0, 1))))
        ));

        biConsumer.accept(BLOOMING_GOLEM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(DDItems.KEYBRAND))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(DDBlockItems.PATIENCE_SOUL))));

        biConsumer.accept(OVERCAST_VESSEL, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(DDBlockItems.FORTITUDE_SOUL))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem().setWeight(2))
                        .add(LootItem.lootTableItem(Items.PAINTING)
                                .apply(SetPaintingVariantFunction.withTag(DDTags.Paintings.ANCIENT)))
                )
        );
        biConsumer.accept(POTTY, LootTable.lootTable());
        biConsumer.accept(POT, LootTable.lootTable());
        biConsumer.accept(POTTER, LootTable.lootTable());
        biConsumer.accept(ACID_SPRITE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem().setWeight(5))
                        .add(LootItem.lootTableItem(DDItems.FIZZ).setWeight(1)
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(provider, 0.25f, 0.03125f)))));

        biConsumer.accept(OVERSEER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(DDBlockItems.CORRUPTION_SOUL))
                )
        );
    }
}
