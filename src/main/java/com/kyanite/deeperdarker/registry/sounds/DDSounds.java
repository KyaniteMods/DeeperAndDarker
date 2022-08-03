package com.kyanite.deeperdarker.registry.sounds;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DeeperAndDarker.MOD_ID);

    // Sculk Stone
    public static final RegistryObject<SoundEvent> SCULK_STONE_BREAK = registerSoundEvent("sculk_stone_break");
    public static final RegistryObject<SoundEvent> SCULK_STONE_STEP = registerSoundEvent("sculk_stone_step");
    public static final RegistryObject<SoundEvent> SCULK_STONE_PLACE = registerSoundEvent("sculk_stone_place");
    public static final RegistryObject<SoundEvent> SCULK_STONE_HIT = registerSoundEvent("sculk_stone_hit");
    public static final RegistryObject<SoundEvent> SCULK_STONE_FALL = registerSoundEvent("sculk_stone_fall");
    public static final ForgeSoundType SCULK_STONE = new ForgeSoundType(1, 1, SCULK_STONE_BREAK, SCULK_STONE_STEP, SCULK_STONE_PLACE, SCULK_STONE_HIT, SCULK_STONE_FALL);


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(DeeperAndDarker.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}