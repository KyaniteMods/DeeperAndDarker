package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.content.blocks.DDSoulFireBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class SoulItem extends BlockItem {
    private final ParticleOptions particle;

    public SoulItem(Block block, Properties properties, ParticleOptions particle) {
        super(block, properties);
        this.particle = particle;
    }

    public ParticleOptions getParticle() {
        return particle;
    }

    @Override
    public String getDescriptionId() {
        return getOrCreateDescriptionId();
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        BlockPos blockPos2 = blockPos.relative(useOnContext.getClickedFace());
        if (!DDSoulFireBlock.canBePlacedAt(level, blockPos2, useOnContext.getHorizontalDirection())) return InteractionResult.FAIL;
        return super.useOn(useOnContext);
    }
}
