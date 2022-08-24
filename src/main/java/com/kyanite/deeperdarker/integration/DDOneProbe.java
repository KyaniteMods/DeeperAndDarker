package com.kyanite.deeperdarker.integration;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.custom.StalkerEntity;
import com.kyanite.deeperdarker.registry.items.DDItems;
import mcjty.theoneprobe.api.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Function;

public class DDOneProbe implements IProbeInfoProvider, Function<ITheOneProbe, Void> {
    @Override
    public Void apply(ITheOneProbe iTheOneProbe) {
        iTheOneProbe.registerProvider(this);
        return null;
    }

    @Override
    public ResourceLocation getID() {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "data");
    }

    @Override public void addProbeInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, Player player, Level level, BlockState blockState, IProbeHitData iProbeHitData) {
    }
}
