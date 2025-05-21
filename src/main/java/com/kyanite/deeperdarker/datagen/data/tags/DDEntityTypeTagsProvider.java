package com.kyanite.deeperdarker.datagen.data.tags;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DDEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public DDEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DeeperDarker.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(DDTags.Misc.SCULK).add(EntityType.PHANTOM, EntityType.WARDEN, DDEntities.ANGLER_FISH.get(), DDEntities.SCULK_CENTIPEDE.get(), DDEntities.SCULK_LEECH.get(), DDEntities.SCULK_SNAPPER.get(), DDEntities.SHATTERED.get(), DDEntities.SHRIEK_WORM.get(), DDEntities.SLUDGE.get(), DDEntities.STALKER.get());
        tag(DDTags.Misc.SENSITIVE_TO_SCULK_SMITE).addTag(DDTags.Misc.SCULK);
    }
}
