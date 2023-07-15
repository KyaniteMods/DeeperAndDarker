package com.kyanite.deeperdarker.sound;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class DeeperDarkerSounds {
    public static final SoundEvent OTHERSIDE_PORTAL_AMBIENT = register("ambient.otherside_portal.groan");

    public static final SoundEvent SCULK_STONE_BREAK = register("block.sculk_stone.break");
    public static final SoundEvent SCULK_STONE_FALL = register("block.sculk_stone.fall");
    public static final SoundEvent SCULK_STONE_HIT = register("block.sculk_stone.hit");
    public static final SoundEvent SCULK_STONE_PLACE = register("block.sculk_stone.place");
    public static final SoundEvent SCULK_STONE_STEP = register("block.sculk_stone.step");
    public static final BlockSoundGroup SCULK_STONE = new BlockSoundGroup(1.0f, 1.0f, SCULK_STONE_BREAK, SCULK_STONE_FALL, SCULK_STONE_HIT, SCULK_STONE_PLACE, SCULK_STONE_STEP);

    public static final SoundEvent ANCIENT_VASE_BREAK = register("block.ancient_vase.break");
    public static final SoundEvent ANCIENT_VASE_FALL = register("block.ancient_vase.fall");
    public static final SoundEvent ANCIENT_VASE_HIT = register("block.ancient_vase.hit");
    public static final SoundEvent ANCIENT_VASE_PLACE = register("block.ancient_vase.place");
    public static final SoundEvent ANCIENT_VASE_STEP = register("block.ancient_vase.step");
    public static final BlockSoundGroup ANCIENT_VASE = new BlockSoundGroup(1.0f, 1.0f, ANCIENT_VASE_BREAK, ANCIENT_VASE_FALL, ANCIENT_VASE_HIT, ANCIENT_VASE_PLACE, ANCIENT_VASE_STEP);

    public static final SoundEvent SCULK_SNAPPER_AMBIENT = register("entity.sculk_snapper.ambient");
    public static final SoundEvent SCULK_SNAPPER_BITE = register("entity.sculk_snapper.bite");
    public static final SoundEvent SCULK_SNAPPER_HURT = register("entity.sculk_snapper.hurt");
    public static final SoundEvent SCULK_SNAPPER_SNIFF = register("entity.sculk_snapper.sniff");

    public static final SoundEvent SCULK_TRANSMITTER_ERROR = register("item.sculk_transmitter.error");
    public static final SoundEvent SCULK_TRANSMITTER_LINK = register("item.sculk_transmitter.link");
    public static final SoundEvent SCULK_TRANSMITTER_UNLINK = register("item.sculk_transmitter.unlink");
    public static final SoundEvent SCULK_TRANSMITTER_OPEN = register("item.sculk_transmitter.open");

    private static SoundEvent register(String id) {
        return Registry.register(Registries.SOUND_EVENT, new Identifier(DeeperDarker.MOD_ID, id), SoundEvent.of(new Identifier(DeeperDarker.MOD_ID, id)));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker sounds");
    }
}
