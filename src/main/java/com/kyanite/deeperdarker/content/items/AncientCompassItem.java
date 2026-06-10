package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.content.DDDataComponents;
import com.kyanite.deeperdarker.content.data.TempleTracker;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.kyanite.deeperdarker.world.structures.DDStructures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

@SuppressWarnings("NullableProblems")
public class AncientCompassItem extends Item {
    public AncientCompassItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        if(!(owner instanceof Player player)) return;
        if(itemStack.has(DDDataComponents.TEMPLE_TRACKER)) return;

        if(level.dimension() == OthersideDimension.OTHERSIDE_LEVEL) {
            var temple = level.registryAccess().lookupOrThrow(Registries.STRUCTURE).getOrThrow(DDStructures.ANCIENT_TEMPLE);
            var result = level.getChunkSource().getGenerator().findNearestMapStructure(level, HolderSet.direct(temple), player.blockPosition(), 100, true);
            BlockPos pos = result == null ? null : result.getFirst();
            TempleTracker tracker;
            if (pos == null) tracker = TempleTracker.empty();
            else tracker = new TempleTracker(Optional.of(GlobalPos.of(level.dimension(), pos)));
            itemStack.set(DDDataComponents.TEMPLE_TRACKER, tracker);
        }
    }
}
