package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class DDTiers {
    public static final ForgeTier WARDEN = new ForgeTier(4, 2464, 11f, 5f, 20, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()));
}
