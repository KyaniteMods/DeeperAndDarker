package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDDataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IceLilyItem extends PlaceOnWaterBlockItem {
    public IceLilyItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @NotNull TooltipContext pContext, @NotNull List<Component> pTooltip, @NotNull TooltipFlag pFlag) {
        if(!pStack.getOrDefault(DDDataComponents.HAS_FLOWER, false)) pTooltip.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".ice_lily.flowerless").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pContext, pTooltip, pFlag);
    }
}
