package com.kyanite.deeperdarker.util.datagen.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.util.SetPaintingVariantFunction;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SlimePredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class DDEntityLootTableProvider extends SimpleFabricLootTableProvider {
    public static final ResourceLocation ANGLER_FISH = DeeperDarker.id("entities/angler_fish");
    public static final ResourceLocation SCULK_CENTIPEDE = DeeperDarker.id("entities/sculk_centipede");
    public static final ResourceLocation SCULK_LEECH = DeeperDarker.id("entities/sculk_leech");
    public static final ResourceLocation SCULK_SNAPPER = DeeperDarker.id("entities/sculk_snapper");
    public static final ResourceLocation SHATTERED = DeeperDarker.id("entities/shattered");
    public static final ResourceLocation SHRIEK_WORM = DeeperDarker.id("entities/shriek_worm");
    public static final ResourceLocation SLUDGE = BuiltInRegistries.ENTITY_TYPE.getKey(DDEntities.SLUDGE).withPrefix("entities/");
    public static final ResourceLocation STALKER = DeeperDarker.id("entities/stalker");
    public static final ResourceLocation BLOOMING_GOLEM = DeeperDarker.id("entities/blooming_golem");
    public static final ResourceLocation POTTY = DeeperDarker.id("entities/potty");
    public static final ResourceLocation POT = DeeperDarker.id("entities/pot");
    public static final ResourceLocation POTTER = DeeperDarker.id("entities/potter");
    public static final ResourceLocation OVERCAST_VESSEL = DeeperDarker.id("entities/overcast_vessel");
    public static final ResourceLocation ACID_SPRITE = DeeperDarker.id("entities/acid_sprite");
    public static final ResourceLocation OVERSEER = DeeperDarker.id("entities/overseer");

    public DDEntityLootTableProvider(FabricDataOutput output) {
        super(output, LootContextParamSets.ENTITY);
    }

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        biConsumer.accept(ANGLER_FISH, LootTable.lootTable());
        biConsumer.accept(SCULK_CENTIPEDE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(Items.STRING)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))
                )
        ));
        biConsumer.accept(SCULK_LEECH, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.SOUL_DUST)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))
                )
        ));
        biConsumer.accept(SCULK_SNAPPER, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.SOUL_DUST)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))
        ));
        biConsumer.accept(SHATTERED, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.SCULK_BONE)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))
        ));
        biConsumer.accept(SHRIEK_WORM, LootTable.lootTable());
        biConsumer.accept(SLUDGE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.RESONARIUM)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))
                ).when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().subPredicate(SlimePredicate.sized(MinMaxBounds.Ints.exactly(1)))))
        ));
        biConsumer.accept(STALKER, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.SOUL_CRYSTAL)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))
        ));

        biConsumer.accept(BLOOMING_GOLEM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(DDItems.KEYBRAND))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(DDItems.PATIENCE_SOUL))));

        biConsumer.accept(OVERCAST_VESSEL, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(DDItems.FORTITUDE_SOUL))
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
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.25f, 0.03125f)))));

        biConsumer.accept(OVERSEER, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(DDItems.CORRUPTION_SOUL))
                )
        );
    }
}
