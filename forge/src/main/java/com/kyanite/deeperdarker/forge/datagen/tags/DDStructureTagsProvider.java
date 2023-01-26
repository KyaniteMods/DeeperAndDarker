package com.kyanite.deeperdarker.forge.datagen.tags;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDTags;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class DDStructureTagsProvider extends TagsProvider<Structure> {
    public DDStructureTagsProvider(DataGenerator arg, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, BuiltinRegistries.STRUCTURES, DeeperAndDarker.MOD_ID, existingFileHelper);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTags() {
        tag(DDTags.Others.ALL_STRUCTURES).addTags(StructureTags.VILLAGE).addTags(StructureTags.RUINED_PORTAL).addTags(StructureTags.SHIPWRECK)
                .add(BuiltinStructures.WOODLAND_MANSION, BuiltinStructures.END_CITY, BuiltinStructures.FORTRESS,
                        BuiltinStructures.BASTION_REMNANT, BuiltinStructures.DESERT_PYRAMID, BuiltinStructures.BURIED_TREASURE);
    }
}
