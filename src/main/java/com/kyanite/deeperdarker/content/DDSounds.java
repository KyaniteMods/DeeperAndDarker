package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, DeeperDarker.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_OTHERSIDE_ADDITIONS = register("ambient.otherside.additions");
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_BIOME_DEEPLANDS = register("music.otherside.deeplands");
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_BIOME_ECHOING_FOREST = register("music.otherside.echoing_forest");
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_BIOME_OVERCAST_COLUMNS = register("music.otherside.overcast_columns");

    public static final DeferredHolder<SoundEvent, SoundEvent> PORTAL_GROAN = register("ambient.portal.groan");

    public static final DeferredHolder<SoundEvent, SoundEvent> SCULK_STONE_BREAK = register("block.sculk_stone.break");
    public static final DeferredHolder<SoundEvent, SoundEvent> SCULK_STONE_FALL = register("block.sculk_stone.fall");
    public static final DeferredHolder<SoundEvent, SoundEvent> SCULK_STONE_HIT = register("block.sculk_stone.hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> SCULK_STONE_PLACE = register("block.sculk_stone.place");
    public static final DeferredHolder<SoundEvent, SoundEvent> SCULK_STONE_STEP = register("block.sculk_stone.step");
    public static final DeferredSoundType SCULK_STONE = new DeferredSoundType(1, 1, SCULK_STONE_BREAK, SCULK_STONE_STEP, SCULK_STONE_PLACE, SCULK_STONE_HIT, SCULK_STONE_FALL);

    public static final DeferredHolder<SoundEvent, SoundEvent> VASE_BREAK = register("block.vase.break");
    public static final DeferredHolder<SoundEvent, SoundEvent> VASE_FALL = register("block.vase.fall");
    public static final DeferredHolder<SoundEvent, SoundEvent> VASE_HIT = register("block.vase.hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> VASE_PLACE = register("block.vase.place");
    public static final DeferredHolder<SoundEvent, SoundEvent> VASE_STEP = register("block.vase.step");
    public static final DeferredSoundType VASE = new DeferredSoundType(2, 1, VASE_BREAK, VASE_STEP, VASE_PLACE, VASE_HIT, VASE_FALL);

    public static final DeferredHolder<SoundEvent, SoundEvent> ANGLER_FISH_DEATH = register("entity.angler_fish.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> ANGLER_FISH_FLOPS = register("entity.angler_fish.flop");
    public static final DeferredHolder<SoundEvent, SoundEvent> ANGLER_FISH_HURT = register("entity.angler_fish.hurt");

    public static final DeferredHolder<SoundEvent, SoundEvent> LEECH_HURT = register("entity.leech.hurt");

    public static final DeferredHolder<SoundEvent, SoundEvent> SNAPPER_AMBIENT = register("entity.snapper.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> SNAPPER_BITE = register("entity.snapper.bite");
    public static final DeferredHolder<SoundEvent, SoundEvent> SNAPPER_HURT = register("entity.snapper.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> SNAPPER_SNIFF = register("entity.snapper.sniff");

    public static final DeferredHolder<SoundEvent, SoundEvent> SHATTERED_AMBIENT = register("entity.shattered.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHATTERED_DEATH = register("entity.shattered.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHATTERED_HURT = register("entity.shattered.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHATTERED_NOTICE = register("entity.shattered.notice");

    public static final DeferredHolder<SoundEvent, SoundEvent> SHRIEK_WORM_AMBIENT = register("entity.shriek_worm.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHRIEK_WORM_DEATH = register("entity.shriek_worm.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHRIEK_WORM_HURT = register("entity.shriek_worm.hurt");

    public static final DeferredHolder<SoundEvent, SoundEvent> STALKER_AMBIENT = register("entity.stalker.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> STALKER_DEATH = register("entity.stalker.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> STALKER_HURT = register("entity.stalker.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> STALKER_NOTICE = register("entity.stalker.notice");

    public static final DeferredHolder<SoundEvent, SoundEvent> TRANSMITTER_ERROR = register("item.transmitter.error");
    public static final DeferredHolder<SoundEvent, SoundEvent> TRANSMITTER_LINK = register("item.transmitter.link");
    public static final DeferredHolder<SoundEvent, SoundEvent> TRANSMITTER_OPEN = register("item.transmitter.open");
    public static final DeferredHolder<SoundEvent, SoundEvent> TRANSMITTER_UNLINK = register("item.transmitter.unlink");

    private static DeferredHolder<SoundEvent, SoundEvent> register(String sound) {
        return SOUND_EVENTS.register(sound, () -> SoundEvent.createVariableRangeEvent(DeeperDarker.rl(sound)));
    }
}
