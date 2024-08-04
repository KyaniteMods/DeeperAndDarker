package com.kyanite.deeperdarker;

import com.chocohead.mm.api.ClassTinkerers;
import com.kyanite.deeperdarker.content.DDSounds;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import java.lang.reflect.Field;

public class DeeperDarkerEarlyRisers implements Runnable {
    @Override
    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

        String instrument = remapper.mapClassName("intermediary", "net.minecraft.class_2766");
        String type = remapper.mapClassName("intermediary", "net.minecraft.class_2766$class_7994");
        String holder = remapper.mapClassName("intermediary", "net.minecraft.class_6880");
        String mobHead = remapper.mapFieldName("intermediary", "net.minecraft.class_2766$class_7994", "field_41607", "Lnet/minecraft/world/level/block/state/properties/NoteBlockInstrument$Type;");
        try {
            Field field = Class.forName(type).getDeclaredField("MOB_HEAD");
            field.setAccessible(true);
            Object obj = field.get(null);
            ClassTinkerers.enumBuilder(instrument, "Ljava/lang/String;", "L" + holder + ";", "L" + type + ";").addEnum("deeperdarker$SHATTERED", "deeperdarker_shattered", Holder.direct(SoundEvent.createVariableRangeEvent(new ResourceLocation(DeeperDarker.MOD_ID, "block.note_block.imitate.shattered"))), obj).build();
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
