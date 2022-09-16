package com.kyanite.deeperdarker.registry.sounds;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDSoundType;
import com.kyanite.deeperdarker.platform.PlatformHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

import java.util.function.Supplier;

public class DDSounds {
    public static final Supplier<SoundEvent> SCULK_STONE_BREAK = register("block.sculk_stone.break");
    public static final Supplier<SoundEvent> SCULK_STONE_FALL = register("block.sculk_stone.fall");
    public static final Supplier<SoundEvent> SCULK_STONE_HIT = register("block.sculk_stone.hit");
    public static final Supplier<SoundEvent> SCULK_STONE_PLACE = register("block.sculk_stone.place");
    public static final Supplier<SoundEvent> SCULK_STONE_STEP = register("block.sculk_stone.step");

    public static final SoundType SCULK_STONE = new DDSoundType(5, 1, SCULK_STONE_BREAK, SCULK_STONE_STEP, SCULK_STONE_PLACE, SCULK_STONE_HIT, SCULK_STONE_FALL);

    // Vase
    public static final Supplier<SoundEvent> VASE_BREAK = register("block.vase.break");
    public static final Supplier<SoundEvent> VASE_FALL = register("block.vase.fall");
    public static final Supplier<SoundEvent> VASE_HIT = register("block.vase.hit");
    public static final Supplier<SoundEvent> VASE_PLACE = register("block.vase.place");
    public static final Supplier<SoundEvent> VASE_STEP = register("block.vase.step");
    public static final SoundType VASE = new DDSoundType(5, 1, VASE_BREAK, VASE_STEP, VASE_PLACE, VASE_HIT, VASE_FALL);

    // Sculk Snapper
    public static final Supplier<SoundEvent> SCULK_SNAPPER_AMBIENT = register("entity.snapper.ambient");
    public static final Supplier<SoundEvent> SCULK_SNAPPER_BITE = register("entity.snapper.bite");
    public static final Supplier<SoundEvent> SCULK_SNAPPER_HURT = register("entity.snapper.hurt");
    public static final Supplier<SoundEvent> SCULK_SNAPPER_SNIFF = register("entity.snapper.sniff");

    // Portal
    public static final Supplier<SoundEvent> PORTAL_GROAN = register("ambience.portal.groan");

    // Item
    public static final Supplier<SoundEvent> SCULK_LINK = register("item.transmitter.link");
    public static final Supplier<SoundEvent> SCULK_TRANSMIT = register("item.transmitter.transmit");

    public static void registerSounds() {
        DeeperAndDarker.LOGGER.info("Deeper And Darker sounds have been registered");
    }

    private static Supplier<SoundEvent> register(String name) {
        return PlatformHelper.registerSound(name, () -> new SoundEvent(new ResourceLocation(DeeperAndDarker.MOD_ID, name)));
    }
}
