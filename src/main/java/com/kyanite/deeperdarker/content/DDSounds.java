package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public class DDSounds {
    public static final SoundEvent PORTAL_GROAN = register("ambience.portal.groan");

    public static final SoundEvent SCULK_STONE_BREAK = register("block.sculk_stone.break");
    public static final SoundEvent SCULK_STONE_FALL = register("block.sculk_stone.fall");
    public static final SoundEvent SCULK_STONE_HIT = register("block.sculk_stone.hit");
    public static final SoundEvent SCULK_STONE_PLACE = register("block.sculk_stone.place");
    public static final SoundEvent SCULK_STONE_STEP = register("block.sculk_stone.step");
    public static final SoundType SCULK_STONE = new SoundType(1, 1, SCULK_STONE_BREAK, SCULK_STONE_STEP, SCULK_STONE_PLACE, SCULK_STONE_HIT, SCULK_STONE_FALL);

    public static final SoundEvent VASE_BREAK = register("block.vase.break");
    public static final SoundEvent VASE_FALL = register("block.vase.fall");
    public static final SoundEvent VASE_HIT = register("block.vase.hit");
    public static final SoundEvent VASE_PLACE = register("block.vase.place");
    public static final SoundEvent VASE_STEP = register("block.vase.step");
    public static final SoundType VASE = new SoundType(2, 1, VASE_BREAK, VASE_STEP, VASE_PLACE, VASE_HIT, VASE_FALL);

    public static final SoundEvent LEECH_HURT = register("entity.leech.hurt");

    public static final SoundEvent SNAPPER_AMBIENT = register("entity.snapper.ambient");
    public static final SoundEvent SNAPPER_BITE = register("entity.snapper.bite");
    public static final SoundEvent SNAPPER_HURT = register("entity.snapper.hurt");
    public static final SoundEvent SNAPPER_SNIFF = register("entity.snapper.sniff");

    public static final SoundEvent SHATTERED_AMBIENT = register("entity.shattered.ambient");
    public static final SoundEvent SHATTERED_DEATH = register("entity.shattered.death");
    public static final SoundEvent SHATTERED_HURT = register("entity.shattered.hurt");
    public static final SoundEvent SHATTERED_NOTICE = register("entity.shattered.notice");

    public static final SoundEvent SHRIEK_WORM_AMBIENT = register("entity.shriek_worm.ambient");
    public static final SoundEvent SHRIEK_WORM_DEATH = register("entity.shriek_worm.death");
    public static final SoundEvent SHRIEK_WORM_HURT = register("entity.shriek_worm.hurt");

    public static final SoundEvent STALKER_AMBIENT = register("entity.stalker.ambient");
    public static final SoundEvent STALKER_DEATH = register("entity.stalker.death");
    public static final SoundEvent STALKER_HURT = register("entity.stalker.hurt");
    public static final SoundEvent STALKER_NOTICE = register("entity.stalker.notice");

    public static final SoundEvent TRANSMITTER_ERROR = register("item.transmitter.error");
    public static final SoundEvent TRANSMITTER_LINK = register("item.transmitter.link");
    public static final SoundEvent TRANSMITTER_OPEN = register("item.transmitter.open");
    public static final SoundEvent TRANSMITTER_UNLINK = register("item.transmitter.unlink");

    public static final Holder.Reference<SoundEvent> NOTE_BLOCK_IMITATE_SHATTERED = registerReference("block.note_block.imitate.shattered");

    public static final Holder.Reference<SoundEvent> AMBIENT_OTHERSIDE_ADDITIONS = registerReference("ambient.otherside.additions");
    public static final Holder.Reference<SoundEvent> MUSIC_BIOME_DEEPLANDS = registerReference("music.otherside.deeplands");
    public static final Holder.Reference<SoundEvent> MUSIC_BIOME_ECHOING_FOREST = registerReference("music.otherside.echoing_forest");
    public static final Holder.Reference<SoundEvent> MUSIC_BIOME_OVERCAST_COLUMNS = registerReference("music.otherside.overcast_columns");

    private static SoundEvent register(String id) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, DeeperDarker.rl(id), SoundEvent.createVariableRangeEvent(DeeperDarker.rl(id)));
    }

    private static Holder.Reference<SoundEvent> registerReference(String id) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, DeeperDarker.rl(id), SoundEvent.createVariableRangeEvent(DeeperDarker.rl(id)));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering sounds");
    }
}
