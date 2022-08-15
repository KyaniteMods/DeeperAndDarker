package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SculkBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

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
