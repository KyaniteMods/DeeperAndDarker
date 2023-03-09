package com.kyanite.deeperdarker.forge.datagen.tags;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class DDEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public DDEntityTypeTagsProvider(DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        super(pGenerator, DeeperAndDarker.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        // tag(EntityTypeTags) For Minecraft tags.

        tag(DDTags.Entities.SCULK).add(DDEntities.SHATTERED.get(), DDEntities.SCULK_LEECH.get(), DDEntities.SCULK_SNAPPER.get(), DDEntities.SCULK_WORM.get(), DDEntities.SCULK_CENTIPEDE.get(), DDEntities.STALKER.get(), DDEntities.ECHOER.get());

        tag(Tags.EntityTypes.BOSSES).add(DDEntities.STALKER.get());
    }

    @NotNull
    @Override
    public String getName() {
        return "Entity Type Tags";
    }
}
