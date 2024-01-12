package com.kyanite.deeperdarker.util.datagen.tags;

import com.kyanite.deeperdarker.util.DDTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.GameEventTags;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.concurrent.CompletableFuture;

public class DDGameEventTagProvider extends FabricTagProvider.GameEventTagProvider {
    public DDGameEventTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(DDTags.GameEvents.STALKER_CAN_LISTEN).forceAddTag(GameEventTags.WARDEN_CAN_LISTEN).add(GameEvent.JUKEBOX_PLAY);
    }
}
