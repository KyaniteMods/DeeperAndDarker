package com.kyanite.deeperdarker.content.blocks.entity;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

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
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("experience", experience);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        experience = input.getIntOr("experience", 0);
    }
}
