package com.kyanite.deeperdarker.forge.datagen.tags;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DDEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public DDEntityTypeTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, completableFuture, DeeperAndDarker.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(DDTags.Entities.SCULK).add(DDEntities.SHATTERED.get(), DDEntities.SCULK_LEECH.get(), DDEntities.SCULK_SNAPPER.get(), DDEntities.SCULK_WORM.get(), DDEntities.SCULK_CENTIPEDE.get(), DDEntities.STALKER.get(), DDEntities.ECHOER.get());

        tag(Tags.EntityTypes.BOSSES).add(DDEntities.STALKER.get());
    }

    @NotNull
    @Override
    public String getName() {
        return "Entity Type Tags";
    }
}
