package com.kyanite.deeperdarker.content.entities.overcastvessel;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.entities.boss.BossPhaseManager;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselIdlePhase;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselPhase;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselSliderPhase;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselUseItemPhase;
import com.mojang.serialization.Codec;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class OvercastVesselPhaseManager extends BossPhaseManager<OvercastVessel, OvercastVesselPhase> {
    public OvercastVesselPhaseManager(OvercastVessel vessel, Codec<OvercastVesselPhase> phaseCodec) {
        super(vessel, phaseCodec);
    }

    @Override
    public boolean populatePhases() {
        float healthPercentage = getBoss().getHealth() / getBoss().getMaxHealth();
        if (healthPercentage > 0.8f) {
            getPhases().add(new OvercastVesselUseItemPhase(DDItems.POTTY_SPAWN_EGG.getDefaultInstance()));
            getPhases().add(new OvercastVesselIdlePhase(300));
            getPhases().add(new OvercastVesselSliderPhase(400));
            getPhases().add(new OvercastVesselIdlePhase(140));
            getPhases().add(new OvercastVesselUseItemPhase(Items.BRICK.getDefaultInstance()));
            return true;
        } else if (healthPercentage > 0.5f) {
            getPhases().add(new OvercastVesselUseItemPhase(List.of(DDItems.POTTY_SPAWN_EGG.getDefaultInstance(), DDItems.POT_SPAWN_EGG.getDefaultInstance(), DDItems.POTTER_SPAWN_EGG.getDefaultInstance()), 10));
            getPhases().add(new OvercastVesselIdlePhase(1400));
            getPhases().add(new OvercastVesselSliderPhase(400));
            getPhases().add(new OvercastVesselIdlePhase(120));
            getPhases().add(new OvercastVesselUseItemPhase(Items.BRICK.getDefaultInstance()));
            return true;
        } else {
            getPhases().add(new OvercastVesselUseItemPhase(List.of(DDItems.POTTY_SPAWN_EGG.getDefaultInstance(), DDItems.POTTY_SPAWN_EGG.getDefaultInstance(), DDItems.POT_SPAWN_EGG.getDefaultInstance(), DDItems.POTTER_SPAWN_EGG.getDefaultInstance()), 10));
            getPhases().add(new OvercastVesselIdlePhase(1400));
            getPhases().add(new OvercastVesselSliderPhase(600));
            getPhases().add(new OvercastVesselIdlePhase(100));
            Optional<Holder<Item>> optional = Util.getRandomSafe(new ArrayList<>(StreamSupport.stream(BuiltInRegistries.ITEM.getTagOrEmpty(ItemTags.DECORATED_POT_SHERDS).spliterator(), false).collect(Collectors.toSet())), getBoss().getRandom());
            if (optional.isPresent()) {
                getPhases().add(new OvercastVesselUseItemPhase(optional.get().value().getDefaultInstance()));
            } else {
                getPhases().add(new OvercastVesselUseItemPhase(Items.BRICK.getDefaultInstance()));
            }
            return true;
        }
    }
}
