package com.kyanite.deeperdarker.datagen.assets;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class DDSoundDefinitions extends SoundDefinitionsProvider {
    public DDSoundDefinitions(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DeeperDarker.MOD_ID, existingFileHelper);
    }

    @Override
    public void registerSounds() {
        add(DDSounds.AMBIENT_OTHERSIDE_ADDITIONS, subtitle("ambient.otherside.additions").with(sound("ambience/otherside/otherside1"), sound("ambience/otherside/otherside2"), sound("ambience/otherside/otherside3")));
        add(DDSounds.MUSIC_BIOME_DEEPLANDS, definition().with(sound("ambience/otherside/deeplands")));
        add(DDSounds.MUSIC_BIOME_ECHOING_FOREST, definition().with(sound("ambience/otherside/echoing_forest")));
        add(DDSounds.MUSIC_BIOME_OVERCAST_COLUMNS, definition().with(sound("ambience/otherside/overcast_columns")));
        add(DDSounds.PORTAL_GROAN, subtitle("ambient.portal.groan").with(sound("ambience/portal/groan1"), sound("ambience/portal/groan2"), sound("ambience/portal/groan3"), sound("ambience/portal/groan4")));
        add(DDSounds.SCULK_STONE_BREAK, subtitle("block.generic.break").with(sound("block/sculk_stone/break1"), sound("block/sculk_stone/break2"), sound("block/sculk_stone/break3"), sound("block/sculk_stone/break4"), sound("block/sculk_stone/break5"), sound("block/sculk_stone/break6"), sound("block/sculk_stone/break7")));
        add(DDSounds.SCULK_STONE_FALL, definition().with(sound("block/sculk_stone/step1"), sound("block/sculk_stone/step2"), sound("block/sculk_stone/step3"), sound("block/sculk_stone/step4"), sound("block/sculk_stone/step5"), sound("block/sculk_stone/step6")));
        add(DDSounds.SCULK_STONE_HIT, subtitle("block.generic.hit").with(sound("block/sculk_stone/step1"), sound("block/sculk_stone/step2"), sound("block/sculk_stone/step3"), sound("block/sculk_stone/step4"), sound("block/sculk_stone/step5"), sound("block/sculk_stone/step6")));
        add(DDSounds.SCULK_STONE_PLACE, subtitle("block.generic.place").with(sound("block/sculk_stone/place1"), sound("block/sculk_stone/place2"), sound("block/sculk_stone/place3"), sound("block/sculk_stone/place4"), sound("block/sculk_stone/place5")));
        add(DDSounds.SCULK_STONE_STEP, subtitle("block.generic.footsteps").with(sound("block/sculk_stone/step1"), sound("block/sculk_stone/step2"), sound("block/sculk_stone/step3"), sound("block/sculk_stone/step4"), sound("block/sculk_stone/step5"), sound("block/sculk_stone/step6")));
        add(DDSounds.VASE_BREAK, subtitle("block.generic.break").with(sound("block/vase/break1"), sound("block/vase/break2"), sound("block/vase/break3"), sound("block/vase/break4"), sound("block/vase/break5")));
        add(DDSounds.VASE_FALL, definition().with(sound("block/vase/step1"), sound("block/vase/step2"), sound("block/vase/step3")));
        add(DDSounds.VASE_HIT, subtitle("block.generic.hit").with(sound("block/vase/step1"), sound("block/vase/step2"), sound("block/vase/step3")));
        add(DDSounds.VASE_PLACE, subtitle("block.generic.place").with(sound("block/vase/place1"), sound("block/vase/place2"), sound("block/vase/place3"), sound("block/vase/place4")));
        add(DDSounds.VASE_STEP, subtitle("block.generic.footsteps").with(sound("block/vase/step1"), sound("block/vase/step2"), sound("block/vase/step3")));
        add(DDSounds.LEECH_HURT, subtitle("entity.leech.hurt").with(sound("entity/sculk_leech/hurt1"), sound("entity/sculk_leech/hurt2"), sound("entity/sculk_leech/hurt3")));
        add(DDSounds.SNAPPER_AMBIENT, subtitle("entity.snapper.ambient").with(sound("entity/sculk_snapper/ambient")));
        add(DDSounds.SNAPPER_BITE, subtitle("entity.snapper.bite").with(sound("entity/sculk_snapper/bite")));
        add(DDSounds.SNAPPER_HURT, subtitle("entity.snapper.hurt").with(sound("entity/sculk_snapper/hurt")));
        add(DDSounds.SNAPPER_SNIFF, subtitle("entity.snapper.sniff").with(sound("entity/sculk_snapper/sniff")));
        add(DDSounds.SHATTERED_AMBIENT, subtitle("entity.shattered.ambient").with(sound("entity/shattered/ambient1"), sound("entity/shattered/ambient2"), sound("entity/shattered/ambient3")));
        add(DDSounds.SHATTERED_DEATH, subtitle("entity.shattered.death").with(sound("entity/shattered/death")));
        add(DDSounds.SHATTERED_HURT, subtitle("entity.shattered.hurt").with(sound("entity/shattered/hurt1"), sound("entity/shattered/hurt2"), sound("entity/shattered/hurt3")));
        add(DDSounds.SHRIEK_WORM_AMBIENT, subtitle("entity.shriek_worm.ambient").with(sound("entity/shriek_worm/ambient1"), sound("entity/shriek_worm/ambient2"), sound("entity/shriek_worm/ambient3")));
        add(DDSounds.SHRIEK_WORM_DEATH, subtitle("entity.shriek_worm.death").with(sound("entity/shriek_worm/death")));
        add(DDSounds.SHRIEK_WORM_HURT, subtitle("entity.shriek_worm.hurt").with(sound("entity/shriek_worm/hurt1"), sound("entity/shriek_worm/hurt2"), sound("entity/shriek_worm/hurt3")));
        add(DDSounds.STALKER_AMBIENT, subtitle("entity.stalker.ambient").with(sound("entity/stalker/ambient1"), sound("entity/stalker/ambient2"), sound("entity/stalker/ambient3")));
        add(DDSounds.STALKER_DEATH, subtitle("entity.stalker.death").with(sound("entity/stalker/death")));
        add(DDSounds.STALKER_HURT, subtitle("entity.stalker.hurt").with(sound("entity/stalker/hurt1"), sound("entity/stalker/hurt2"), sound("entity/stalker/hurt3"), sound("entity/stalker/hurt4")));
        add(DDSounds.TRANSMITTER_ERROR, subtitle("item.transmitter.error").with(sound("item/transmitter/error")));
        add(DDSounds.TRANSMITTER_LINK, subtitle("item.transmitter.link").with(sound("item/transmitter/link")));
        add(DDSounds.TRANSMITTER_OPEN, subtitle("item.transmitter.open").with(sound("item/transmitter/open")));
        add(DDSounds.TRANSMITTER_UNLINK, subtitle("item.transmitter.unlink").with(sound("item/transmitter/unlink")));
    }

    private SoundDefinition subtitle(String subtitle) {
        return definition().subtitle("subtitles." + subtitle);
    }

    protected static SoundDefinition.Sound sound(String location) {
        return sound(DeeperDarker.rl(location));
    }
}
