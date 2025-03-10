package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.GameEventTagsProvider;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DDGameEventTagsProvider extends GameEventTagsProvider {
    public DDGameEventTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DeeperDarker.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(DDTags.Misc.CHEST_VIBRATIONS).add(GameEvent.BLOCK_ACTIVATE.key(), GameEvent.BLOCK_CLOSE.key(), GameEvent.BLOCK_DEACTIVATE.key(), GameEvent.BLOCK_DESTROY.key(), GameEvent.BLOCK_PLACE.key(), GameEvent.CONTAINER_CLOSE.key(), GameEvent.CONTAINER_OPEN.key());
        tag(DDTags.Misc.FEET_VIBRATIONS).add(GameEvent.HIT_GROUND.key(), GameEvent.STEP.key(), GameEvent.SWIM.key(), GameEvent.SPLASH.key());
    }
}
