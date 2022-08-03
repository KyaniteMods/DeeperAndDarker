package com.kyanite.deeperdarker.registry.sounds;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<SoundEvent> SCULK_STONE_BREAK = register("block.sculk_stone.break");
    public static final RegistryObject<SoundEvent> SCULK_STONE_FALL = register("block.sculk_stone.fall");

    public static final RegistryObject<SoundEvent> SCULK_SNAPPER_SNIFF = register("entity.snapper_sniff");
    public static final RegistryObject<SoundEvent> SCULK_SNAPPER_AMBIENT = register("entity.snapper_ambient");
    public static final RegistryObject<SoundEvent> SCULK_SNAPPER_HURT = register("entity.snapper_hurt");
    public static final RegistryObject<SoundEvent> SCULK_SNAPPER_BITE = register("entity.snapper_bite");
    public static final RegistryObject<SoundEvent> SCULK_STONE_HIT = register("block.sculk_stone.hit");
    public static final RegistryObject<SoundEvent> SCULK_STONE_PLACE = register("block.sculk_stone.place");
    public static final RegistryObject<SoundEvent> SCULK_STONE_STEP = register("block.sculk_stone.step");
    public static final ForgeSoundType SCULK_STONE = new ForgeSoundType(1, 1, SCULK_STONE_BREAK, SCULK_STONE_STEP, SCULK_STONE_PLACE, SCULK_STONE_HIT, SCULK_STONE_FALL);

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(DeeperAndDarker.MOD_ID, name)));
    }
}
