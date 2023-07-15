package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DeeperDarker.MOD_ID);

    public static final RegistryObject<SoundEvent> PORTAL_GROAN = register("ambience.portal.groan");

    public static final RegistryObject<SoundEvent> SCULK_STONE_BREAK = register("block.sculk_stone.break");
    public static final RegistryObject<SoundEvent> SCULK_STONE_FALL = register("block.sculk_stone.fall");
    public static final RegistryObject<SoundEvent> SCULK_STONE_HIT = register("block.sculk_stone.hit");
    public static final RegistryObject<SoundEvent> SCULK_STONE_PLACE = register("block.sculk_stone.place");
    public static final RegistryObject<SoundEvent> SCULK_STONE_STEP = register("block.sculk_stone.step");
    public static final ForgeSoundType SCULK_STONE = new ForgeSoundType(1, 1, SCULK_STONE_BREAK, SCULK_STONE_STEP, SCULK_STONE_PLACE, SCULK_STONE_HIT, SCULK_STONE_FALL);

    public static final RegistryObject<SoundEvent> VASE_BREAK = register("block.vase.break");
    public static final RegistryObject<SoundEvent> VASE_FALL = register("block.vase.fall");
    public static final RegistryObject<SoundEvent> VASE_HIT = register("block.vase.hit");
    public static final RegistryObject<SoundEvent> VASE_PLACE = register("block.vase.place");
    public static final RegistryObject<SoundEvent> VASE_STEP = register("block.vase.step");
    public static final ForgeSoundType VASE = new ForgeSoundType(1, 1, VASE_BREAK, VASE_STEP, VASE_PLACE, VASE_HIT, VASE_FALL);

    public static final RegistryObject<SoundEvent> SNAPPER_AMBIENT = register("entity.snapper.ambient");
    public static final RegistryObject<SoundEvent> SNAPPER_BITE = register("entity.snapper.bite");
    public static final RegistryObject<SoundEvent> SNAPPER_HURT = register("entity.snapper.hurt");
    public static final RegistryObject<SoundEvent> SNAPPER_SNIFF = register("entity.snapper.sniff");

    public static final RegistryObject<SoundEvent> SHATTERED_AMBIENT = register("entity.shattered.ambient");
    public static final RegistryObject<SoundEvent> SHATTERED_DEATH = register("entity.shattered.death");
    public static final RegistryObject<SoundEvent> SHATTERED_HURT = register("entity.shattered.hurt");

    public static final RegistryObject<SoundEvent> TRANSMITTER_ERROR = register("item.transmitter.error");
    public static final RegistryObject<SoundEvent> TRANSMITTER_LINK = register("item.transmitter.link");
    public static final RegistryObject<SoundEvent> TRANSMITTER_OPEN = register("item.transmitter.open");
    public static final RegistryObject<SoundEvent> TRANSMITTER_UNLINK = register("item.transmitter.unlink");

    private static RegistryObject<SoundEvent> register(String sound) {
        return SOUND_EVENTS.register(sound, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DeeperDarker.MOD_ID, sound)));
    }
}
