package com.kyanite.deeperdarker.forge.datagen.tags;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DDStructureTagsProvider extends TagsProvider<Structure> {
    public DDStructureTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, Registries.STRUCTURE, completableFuture, DeeperAndDarker.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(DDTags.Others.ALL_STRUCTURES).addTags(StructureTags.VILLAGE).addTags(StructureTags.RUINED_PORTAL).addTags(StructureTags.SHIPWRECK)
                .add(BuiltinStructures.WOODLAND_MANSION, BuiltinStructures.END_CITY, BuiltinStructures.FORTRESS,
                        BuiltinStructures.BASTION_REMNANT, BuiltinStructures.DESERT_PYRAMID, BuiltinStructures.BURIED_TREASURE);
    }
}
