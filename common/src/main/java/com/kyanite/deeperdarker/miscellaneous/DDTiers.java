package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.config.DDConfig;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class DDTiers {
    public static Tier WARDEN;

    public static void registerTypes() {
        WARDEN = new ConfigurableTier(4, DDConfig.WARDEN_TOOLS_USES, DDConfig.WARDEN_TOOLS_SPEED, DDConfig.WARDEN_TOOLS_DAMAGE, 21,
                BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()));
    }
}
