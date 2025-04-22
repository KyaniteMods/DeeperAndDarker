package com.kyanite.deeperdarker.content.blocks.entity;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("NullableProblems")
public class SculkJawBlockEntity extends BlockEntity {
    private int experience;

    public SculkJawBlockEntity(BlockPos pos, BlockState blockState) {
        super(DDBlockEntities.SCULK_JAW.get(), pos, blockState);
    }

    public void stealXP(Player player, int xp) {
        if(player.experienceLevel == 0 && player.totalExperience < xp) {
            experience += player.totalExperience;
            player.totalExperience = 0;
        } else {
            experience += xp;
            player.giveExperiencePoints(-xp);
        }
    }

    public int storedXP() {
        return experience;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if(tag.contains("experience")) experience = tag.getInt("experience");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("experience", experience);
    }
}
