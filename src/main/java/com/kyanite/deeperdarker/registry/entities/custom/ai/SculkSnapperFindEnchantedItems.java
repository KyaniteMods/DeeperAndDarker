package com.kyanite.deeperdarker.registry.entities.custom.ai;

import com.kyanite.deeperdarker.registry.entities.custom.SculkSnapperEntity;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;

import java.util.EnumSet;
import java.util.List;

public class SculkSnapperFindEnchantedItems extends Goal {
    private SculkSnapperEntity sculkSnapper;
    public SculkSnapperFindEnchantedItems(SculkSnapperEntity sculkSnapper) {
        this.sculkSnapper = sculkSnapper;
    }
    @Override
    public boolean canUse() {
        List<ItemEntity> list = sculkSnapper.level.getEntitiesOfClass(ItemEntity.class,
                sculkSnapper.getBoundingBox().inflate(8.0D, 8.0D, 8.0D),
                itemEntity -> !itemEntity.getItem().getAllEnchantments().isEmpty());
        return !list.isEmpty();
    }

    @Override
    public void tick() {
        List<ItemEntity> list = sculkSnapper.level.getEntitiesOfClass(ItemEntity.class,
                sculkSnapper.getBoundingBox().inflate(12, 12, 12),
                itemEntity -> !itemEntity.getItem().getAllEnchantments().isEmpty());
        if(!list.isEmpty() && !sculkSnapper.isPerformingAction()) {
            sculkSnapper.getNavigation().moveTo(list.get(0), 0.45f);
        }
    }

    @Override
    public void start() {
        List<ItemEntity> list = sculkSnapper.level.getEntitiesOfClass(ItemEntity.class,
                sculkSnapper.getBoundingBox().inflate(12, 12, 12),
                itemEntity -> !itemEntity.getItem().getAllEnchantments().isEmpty());
        if(!list.isEmpty() && !sculkSnapper.isPerformingAction()) {
            sculkSnapper.getNavigation().moveTo(list.get(0), 0.45f);
        }
    }
}
