package com.kyanite.deeperdarker.datagen.data.tags;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDEnchantments;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DDEnchantmentTagsProvider extends EnchantmentTagsProvider {
    public DDEnchantmentTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DeeperDarker.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(EnchantmentTags.DAMAGE_EXCLUSIVE).add(DDEnchantments.SCULK_SMITE);
        tag(EnchantmentTags.TREASURE).add(DDEnchantments.CATALYSIS);
        tag(EnchantmentTags.NON_TREASURE).add(DDEnchantments.SCULK_SMITE, DDEnchantments.VOLUME, DDEnchantments.REVERBERATION);

        tag(Tags.Enchantments.WEAPON_DAMAGE_ENHANCEMENTS).add(DDEnchantments.SCULK_SMITE);
        tag(DDTags.Misc.RESONARIUM_EXCLUDES).add(Enchantments.PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.FIRE_PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.MENDING);
    }
}
