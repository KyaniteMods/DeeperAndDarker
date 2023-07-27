package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public class DDSounds {
    public static final SoundEvent PORTAL_GROAN = register("ambience.otherside_portal.groan");

    public static final SoundEvent SCULK_STONE_BREAK = register("block.sculk_stone.break");
    public static final SoundEvent SCULK_STONE_FALL = register("block.sculk_stone.fall");
    public static final SoundEvent SCULK_STONE_HIT = register("block.sculk_stone.hit");
    public static final SoundEvent SCULK_STONE_PLACE = register("block.sculk_stone.place");
    public static final SoundEvent SCULK_STONE_STEP = register("block.sculk_stone.step");
    public static final SoundType SCULK_STONE = new SoundType(1, 1, SCULK_STONE_BREAK, SCULK_STONE_STEP, SCULK_STONE_PLACE, SCULK_STONE_HIT, SCULK_STONE_FALL);

    public static final SoundEvent VASE_BREAK = register("block.ancient_vase.break");
    public static final SoundEvent VASE_FALL = register("block.ancient_vase.fall");
    public static final SoundEvent VASE_HIT = register("block.ancient_vase.hit");
    public static final SoundEvent VASE_PLACE = register("block.ancient_vase.place");
    public static final SoundEvent VASE_STEP = register("block.ancient_vase.step");
    public static final SoundType VASE = new SoundType(2, 1, VASE_BREAK, VASE_STEP, VASE_PLACE, VASE_HIT, VASE_FALL);

    public static final SoundEvent LEECH_HURT = register("entity.sculk_leech.hurt");

    public static final SoundEvent SNAPPER_AMBIENT = register("entity.sculk_snapper.ambient");
    public static final SoundEvent SNAPPER_BITE = register("entity.sculk_snapper.bite");
    public static final SoundEvent SNAPPER_HURT = register("entity.sculk_snapper.hurt");
    public static final SoundEvent SNAPPER_SNIFF = register("entity.sculk_snapper.sniff");

    public static final SoundEvent SHATTERED_AMBIENT = register("entity.shattered.ambient");
    public static final SoundEvent SHATTERED_DEATH = register("entity.shattered.death");
    public static final SoundEvent SHATTERED_HURT = register("entity.shattered.hurt");

    public static final SoundEvent SHRIEK_WORM_AMBIENT = register("entity.shriek_worm.ambient");
    public static final SoundEvent SHRIEK_WORM_DEATH = register("entity.shriek_worm.death");
    public static final SoundEvent SHRIEK_WORM_HURT = register("entity.shriek_worm.hurt");

    public static final SoundEvent TRANSMITTER_ERROR = register("item.sculk_transmitter.error");
    public static final SoundEvent TRANSMITTER_LINK = register("item.sculk_transmitter.link");
    public static final SoundEvent TRANSMITTER_OPEN = register("item.sculk_transmitter.open");
    public static final SoundEvent TRANSMITTER_UNLINK = register("item.sculk_transmitter.unlink");

    private static SoundEvent register(String id) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, new ResourceLocation(DeeperDarker.MOD_ID, id), SoundEvent.createVariableRangeEvent(new ResourceLocation(DeeperDarker.MOD_ID, id)));
    }

    private static Holder.Reference<SoundEvent> registerReference(String id) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, new ResourceLocation(DeeperDarker.MOD_ID, id), SoundEvent.createVariableRangeEvent(new ResourceLocation(DeeperDarker.MOD_ID, id)));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering sounds");
    }
}
