package com.nitro.deeperdarker.core.registry.properties;

import com.nitro.deeperdarker.core.DeeperAndDarker;
import com.nitro.deeperdarker.core.registry.DDItems;
import com.teamabnormals.blueprint.core.api.BlueprintArmorMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;

public final class DDArmorMaterials {
    public static final BlueprintArmorMaterial WARDEN_CARAPACE = new BlueprintArmorMaterial((new ResourceLocation(DeeperAndDarker.MODID, "warden")), 45, new int[]{3, 6, 8, 3}, 19, () -> SoundEvents.SCULK_BLOCK_PLACE, 0F, 0F, () -> Ingredient.of(DDItems.WARDEN_CARAPACE.get()));
}