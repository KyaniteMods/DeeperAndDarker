package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class DDTiers {
    public static final ForgeTier WARDEN = new ForgeTier(4, 2464, 11f, 7f, 21, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()));
}
