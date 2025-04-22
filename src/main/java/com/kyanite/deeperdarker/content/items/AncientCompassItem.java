package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.content.DDDataComponents;
import com.kyanite.deeperdarker.content.datacomponents.TempleTracker;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Optional;

@SuppressWarnings("NullableProblems")
public class AncientCompassItem extends Item {
    public AncientCompassItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(!(entity instanceof Player player)) return;
        if(stack.has(DDDataComponents.TEMPLE_TRACKER)) return;

        if(level instanceof ServerLevel serverLevel && serverLevel.dimension() == OthersideDimension.OTHERSIDE_LEVEL) {
            BlockPos pos = serverLevel.findNearestMapStructure(DDTags.Misc.ANCIENT_TEMPLE, player.blockPosition(), 5, true);
            TempleTracker tracker;
            if(pos == null) tracker = TempleTracker.empty();
            else tracker = new TempleTracker(Optional.of(GlobalPos.of(serverLevel.dimension(), pos)));
            stack.set(DDDataComponents.TEMPLE_TRACKER, tracker);
        }
    }
}
