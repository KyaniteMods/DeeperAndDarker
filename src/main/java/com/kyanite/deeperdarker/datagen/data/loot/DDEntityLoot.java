package com.kyanite.deeperdarker.datagen.data.loot;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SlimePredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class DDEntityLoot extends EntityLootSubProvider {
    protected DDEntityLoot(HolderLookup.Provider pRegistries) {
        super(FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    public void generate() {
        add(DDEntities.ANGLER_FISH.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(DDItems.ANGLER_FISH.get())
                        .apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot()))
                )
        ));
        add(DDEntities.ANGER_POT.get(), potLootTable(2));
        add(DDEntities.FEAR_POT.get(), potLootTable(2));
        add(DDEntities.SORROW_POT.get(), potLootTable(1));
        add(DDEntities.SCULK_CENTIPEDE.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(Items.STRING)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                )
        ));
        add(DDEntities.SCULK_LEECH.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(DDItems.SOUL_DUST)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                )
        ));
        add(DDEntities.SCULK_SNAPPER.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(DDItems.SOUL_DUST)
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                )
        ));
        add(DDEntities.SHATTERED.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(DDItems.SCULK_BONE)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                )
        ));
        add(DDEntities.SHRIEK_WORM.get(), LootTable.lootTable());
        add(DDEntities.SLUDGE.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(DDItems.RESONARIUM)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                ).when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().subPredicate(SlimePredicate.sized(MinMaxBounds.Ints.exactly(1)))))
        ));
        add(DDEntities.STALKER.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(DDItems.SOUL_CRYSTAL)
                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
                )
        ));
    }

    private static LootTable.Builder potLootTable(float max) {
        NumberProvider rolls = max == 1 ? ConstantValue.exactly(1) : UniformGenerator.between(1, max);
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(rolls)
                .add(LootItem.lootTableItem(DDItems.GLOOMSHERD))
                .add(LootItem.lootTableItem(DDItems.BRITTLE_GLOOMSHERD))
                .add(LootItem.lootTableItem(DDItems.DARK_HEART_GLOOMSHERD))
                .add(LootItem.lootTableItem(DDItems.LISTENER_GLOOMSHERD))
                .add(LootItem.lootTableItem(DDItems.SNAPPER_GLOOMSHERD))
                .add(LootItem.lootTableItem(DDItems.TEMPLE_GLOOMSHERD))
                .add(LootItem.lootTableItem(DDItems.TRANSMISSION_GLOOMSHERD))
                .add(LootItem.lootTableItem(DDItems.WARD_GLOOMSHERD))
                .add(LootItem.lootTableItem(DDItems.WAYFINDER_GLOOMSHERD))
        );
    }

    @Override
    protected @NotNull Stream<EntityType<?>> getKnownEntityTypes() {
        return DDEntities.ENTITIES.getEntries().stream().map(DeferredHolder::get);
    }
}
