package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import dev.kyanitemods.kyaniteportals.KyanitePortals;
import dev.kyanitemods.kyaniteportals.content.Portal;
import dev.kyanitemods.kyaniteportals.content.testers.PortalTester;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class SculkFireBlock extends BaseFireBlock {
    public SculkFireBlock(Properties properties) {
        super(properties, 2.0f);
    }

    @Override
    protected boolean canBurn(BlockState blockState) {
        return true;
    }

    public static boolean canBePlacedAt(Level level, BlockPos blockPos, Direction direction) {
        BlockState blockState = level.getBlockState(blockPos);
        if (!blockState.isAir()) {
            return false;
        }
        return level.getBlockState(blockPos.below()).isFaceSturdy(level, blockPos.below(), Direction.UP) || isPortal(level, blockPos);
    }

    private static boolean isPortal(Level level, BlockPos blockPos) {
        Optional<HolderLookup.RegistryLookup<Portal>> lookup = level.registryAccess().lookup(KyanitePortals.RESOURCE_KEY);
        if (lookup.isEmpty()) return false;
        Optional<Holder.Reference<Portal>> portal = lookup.get().get(DeeperDarker.OTHERSIDE_PORTAL);
        if (portal.isEmpty()) return false;
        Optional<PortalTester<?>> tester = portal.get().value().tester();
        return tester.map(portalTester -> portalTester.test(level, blockPos).isSuccess()).orElse(false);
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        super.onPlace(blockState, level, blockPos, blockState2, bl);
        level.scheduleTick(blockPos, this, getFireTickDelay(level.random));
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        serverLevel.scheduleTick(blockPos, this, getFireTickDelay(serverLevel.random));
        if (!serverLevel.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            return;
        }
        if (!blockState.canSurvive(serverLevel, blockPos)) {
            serverLevel.removeBlock(blockPos, false);
        }
        BlockState below = serverLevel.getBlockState(blockPos.below());
        if (!below.is(serverLevel.dimensionType().infiniburn()) && serverLevel.dimension() != OthersideDimension.OTHERSIDE_LEVEL) {
            if (randomSource.nextInt(8) == 0) {
                serverLevel.setBlock(blockPos, Blocks.SOUL_FIRE.defaultBlockState(), UPDATE_ALL);
            }
        }
    }

    private static int getFireTickDelay(RandomSource randomSource) {
        return 30 + randomSource.nextInt(10);
    }
}
