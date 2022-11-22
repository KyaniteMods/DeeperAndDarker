package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.config.DDConfig;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class DDTiers {
    public static final Tier WARDEN = new Tier() {
        @Override
        public int getUses() {
            return DDConfig.WARDEN_TOOLS_DURABILITY.get();
        }

        @Override
        public float getSpeed() {
            return DDConfig.WARDEN_TOOLS_SPEED.get().floatValue();
        }

        @Override
        public float getAttackDamageBonus() {
            return DDConfig.WARDEN_TOOLS_DAMAGE.get().floatValue();
        }

        @Override
        public int getLevel() {
            return 4;
        }

        @Override
        public int getEnchantmentValue() {
            return 21;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get());
        }
    };

    public static void registerTypes() {
    }
}
