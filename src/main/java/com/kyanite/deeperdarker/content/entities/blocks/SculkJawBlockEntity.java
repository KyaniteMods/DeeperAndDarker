package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SculkJawBlockEntity extends BlockEntity {
    private int experience;

    public SculkJawBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(DDBlockEntities.SCULK_JAW, blockPos, blockState);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        this.experience = pTag.getInt("experience");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        pTag.putInt("experience", this.experience);
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void addExperience(int experience) {
        this.setExperience(this.getExperience() + experience);
    }

    public void stealExperienceFromPlayer(Player player, int amount) {
        player.giveExperiencePoints(-amount);
        this.addExperience(amount);
    }
}
