package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import net.minecraft.core.BlockPos;
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
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.experience = compoundTag.getInt("experience");
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putInt("experience", this.experience);
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
        amount = Math.min(player.totalExperience, amount);
        player.giveExperiencePoints(-amount);
        this.addExperience(amount);
    }
}
