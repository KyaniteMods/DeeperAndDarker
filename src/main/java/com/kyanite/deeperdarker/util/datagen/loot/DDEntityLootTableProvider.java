package com.kyanite.deeperdarker.util.datagen.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class DDEntityLootTableProvider extends SimpleFabricLootTableProvider {
    public static final ResourceLocation ANGLER_FISH = new ResourceLocation(DeeperDarker.MOD_ID, "entities/angler_fish");
    public static final ResourceLocation SCULK_CENTIPEDE = new ResourceLocation(DeeperDarker.MOD_ID, "entities/sculk_centipede");
    public static final ResourceLocation SCULK_LEECH = new ResourceLocation(DeeperDarker.MOD_ID, "entities/sculk_leech");
    public static final ResourceLocation SCULK_SNAPPER = new ResourceLocation(DeeperDarker.MOD_ID, "entities/sculk_snapper");
    public static final ResourceLocation SHATTERED = new ResourceLocation(DeeperDarker.MOD_ID, "entities/shattered");
    public static final ResourceLocation SHRIEK_WORM = new ResourceLocation(DeeperDarker.MOD_ID, "entities/shriek_worm");
    public static final ResourceLocation STALKER = new ResourceLocation(DeeperDarker.MOD_ID, "entities/stalker");

    public DDEntityLootTableProvider(FabricDataOutput output) {
        super(output, LootContextParamSets.ENTITY);
    }

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        biConsumer.accept(ANGLER_FISH, LootTable.lootTable());
        biConsumer.accept(SCULK_CENTIPEDE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(Items.STRING)).apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))));
        biConsumer.accept(SCULK_LEECH, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST).apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        biConsumer.accept(SCULK_SNAPPER, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        biConsumer.accept(SHATTERED, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SCULK_BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        biConsumer.accept(SHRIEK_WORM, LootTable.lootTable());
        biConsumer.accept(STALKER, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_CRYSTAL).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
    }
}
