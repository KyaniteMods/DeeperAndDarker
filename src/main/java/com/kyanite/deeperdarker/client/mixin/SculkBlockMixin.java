package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.List;

@Mixin(SculkBlock.class)
public class SculkBlockMixin extends DropExperienceBlock {
    public SculkBlockMixin(Properties p_221083_) {
        super(p_221083_, ConstantInt.of(1));
    }

    @Nullable
    @Override
    public List<ItemStack> getDrops(BlockState pState, LootContext.Builder pBuilder) {
        if(pBuilder.getLevel().dimension() == DDDimensions.OTHERSIDE_LEVEL)
            return null;

        return super.getDrops(pState, pBuilder);
    }
}
