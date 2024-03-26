package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.DDBlocks;
import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DeeperDarker.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, DeeperDarker.MODID);

    public static final Supplier<CreativeModeTab> DEEPER_DARKER = CREATIVE_MODE_TABS.register(DeeperDarker.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + DeeperDarker.MODID))
            .icon(() -> new ItemStack(DDItems.HEART_OF_THE_DEEP.get()))
            .displayItems((params, output) -> {
                output.accept(DDItems.HEART_OF_THE_DEEP.get());
                output.accept(DDItems.WARDEN_CARAPACE.get());
                output.accept(DDItems.REINFORCED_ECHO_SHARD.get());
                output.accept(DDItems.SCULK_BONE.get());
                output.accept(DDItems.SOUL_DUST.get());
                output.accept(DDItems.SOUL_CRYSTAL.get());

                output.accept(DDItems.ECHO_LOG.get());
                output.accept(DDItems.ECHO_WOOD.get());
                output.accept(DDItems.STRIPPED_ECHO_LOG.get());
                output.accept(DDItems.STRIPPED_ECHO_WOOD.get());
                output.accept(DDItems.ECHO_PLANKS.get());
                output.accept(DDItems.ECHO_STAIRS.get());
                output.accept(DDItems.ECHO_SLAB.get());
                output.accept(DDItems.ECHO_FENCE.get());
                output.accept(DDItems.ECHO_FENCE_GATE.get());
                output.accept(DDItems.ECHO_DOOR.get());
                output.accept(DDItems.ECHO_TRAPDOOR.get());
                output.accept(DDItems.ECHO_PRESSURE_PLATE.get());
                output.accept(DDItems.ECHO_BUTTON.get());
                output.accept(DDItems.ECHO_LEAVES.get());

                output.accept(DDItems.BLOOM_PLANKS.get());
                output.accept(DDItems.BLOOM_STAIRS.get());
                output.accept(DDItems.BLOOM_SLAB.get());
                output.accept(DDItems.BLOOM_FENCE.get());
                output.accept(DDItems.BLOOM_FENCE_GATE.get());
                output.accept(DDItems.BLOOM_DOOR.get());
                output.accept(DDItems.BLOOM_TRAPDOOR.get());
                output.accept(DDItems.BLOOM_PRESSURE_PLATE.get());
                output.accept(DDItems.BLOOM_BUTTON.get());
            })
            .build()
    );

    // Warden Armor and Soul Elytra, plus materials
    public static final Supplier<Item> HEART_OF_THE_DEEP = ITEMS.registerItem("heart_of_the_deep", WardenHeartItem::new, new Item.Properties().rarity(Rarity.RARE).fireResistant());
    public static final Supplier<Item> WARDEN_CARAPACE = ITEMS.registerSimpleItem("warden_carapace", new Item.Properties().rarity(Rarity.RARE).fireResistant());
    public static final Supplier<Item> REINFORCED_ECHO_SHARD = ITEMS.registerSimpleItem("reinforced_echo_shard", new Item.Properties().rarity(Rarity.RARE).fireResistant());
    public static final Supplier<Item> SCULK_BONE = ITEMS.registerSimpleItem("sculk_bone", new Item.Properties().rarity(Rarity.RARE).fireResistant());
    public static final Supplier<Item> SOUL_DUST = ITEMS.registerSimpleItem("soul_dust", new Item.Properties().rarity(Rarity.RARE).fireResistant());
    public static final Supplier<Item> SOUL_CRYSTAL = ITEMS.registerSimpleItem("soul_crystal", new Item.Properties().rarity(Rarity.RARE).fireResistant());
    // TODO: Warden Upgrade Smithing Template, Gear

    // TODO: Sculk Transmitter, Sonorous Staff

    // TODO: Spawn Eggs

    // Echo wood set
    public static final Supplier<BlockItem> ECHO_LOG = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_LOG);
    public static final Supplier<BlockItem> ECHO_WOOD = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_WOOD);
    public static final Supplier<BlockItem> STRIPPED_ECHO_LOG = ITEMS.registerSimpleBlockItem(DDBlocks.STRIPPED_ECHO_LOG);
    public static final Supplier<BlockItem> STRIPPED_ECHO_WOOD = ITEMS.registerSimpleBlockItem(DDBlocks.STRIPPED_ECHO_WOOD);
    public static final Supplier<BlockItem> ECHO_PLANKS = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_PLANKS);
    public static final Supplier<BlockItem> ECHO_STAIRS = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_STAIRS);
    public static final Supplier<BlockItem> ECHO_SLAB = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_SLAB);
    public static final Supplier<BlockItem> ECHO_FENCE = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_FENCE);
    public static final Supplier<BlockItem> ECHO_FENCE_GATE = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_FENCE_GATE);
    public static final Supplier<BlockItem> ECHO_DOOR = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_DOOR);
    public static final Supplier<BlockItem> ECHO_TRAPDOOR = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_TRAPDOOR);
    public static final Supplier<BlockItem> ECHO_PRESSURE_PLATE = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_PRESSURE_PLATE);
    public static final Supplier<BlockItem> ECHO_BUTTON = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_BUTTON);
    public static final Supplier<BlockItem> ECHO_LEAVES = ITEMS.registerSimpleBlockItem(DDBlocks.ECHO_LEAVES);
    //TODO: Echo Sign, Hanging Sign, Boat, Chest Boat

    // Bloom wood set
    //TODO: Blooming Stem, Stripped Blooming Stem
    public static final Supplier<BlockItem> BLOOM_PLANKS = ITEMS.registerSimpleBlockItem(DDBlocks.BLOOM_PLANKS);
    public static final Supplier<BlockItem> BLOOM_STAIRS = ITEMS.registerSimpleBlockItem(DDBlocks.BLOOM_STAIRS);
    public static final Supplier<BlockItem> BLOOM_SLAB = ITEMS.registerSimpleBlockItem(DDBlocks.BLOOM_SLAB);
    public static final Supplier<BlockItem> BLOOM_FENCE = ITEMS.registerSimpleBlockItem(DDBlocks.BLOOM_FENCE);
    public static final Supplier<BlockItem> BLOOM_FENCE_GATE = ITEMS.registerSimpleBlockItem(DDBlocks.BLOOM_FENCE_GATE);
    public static final Supplier<BlockItem> BLOOM_DOOR = ITEMS.registerSimpleBlockItem(DDBlocks.BLOOM_DOOR);
    public static final Supplier<BlockItem> BLOOM_TRAPDOOR = ITEMS.registerSimpleBlockItem(DDBlocks.BLOOM_TRAPDOOR);
    public static final Supplier<BlockItem> BLOOM_PRESSURE_PLATE = ITEMS.registerSimpleBlockItem(DDBlocks.BLOOM_PRESSURE_PLATE);
    public static final Supplier<BlockItem> BLOOM_BUTTON = ITEMS.registerSimpleBlockItem(DDBlocks.BLOOM_BUTTON);
    //TODO: Bloom Sign, Hanging Sign, Boat, Chest Boat
}
