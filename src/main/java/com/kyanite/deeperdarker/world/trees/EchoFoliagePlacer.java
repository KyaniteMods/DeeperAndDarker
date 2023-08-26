package com.kyanite.deeperdarker.world.trees;

import com.kyanite.deeperdarker.world.DDFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.BiConsumer;

public class EchoFoliagePlacer
        extends FoliagePlacer {
    public static final Codec<EchoFoliagePlacer> CODEC = RecordCodecBuilder.create(instance -> EchoFoliagePlacer.foliagePlacerParts(instance).and(instance.group((IntProvider.codec(4, 16).fieldOf("height")).forGetter(cherryFoliagePlacer -> cherryFoliagePlacer.height), (Codec.floatRange(0.0f, 1.0f).fieldOf("wide_bottom_layer_hole_chance")).forGetter(cherryFoliagePlacer -> cherryFoliagePlacer.wideBottomLayerHoleChance), (Codec.floatRange(0.0f, 1.0f).fieldOf("corner_hole_chance")).forGetter(cherryFoliagePlacer -> cherryFoliagePlacer.wideBottomLayerHoleChance), (Codec.floatRange(0.0f, 1.0f).fieldOf("hanging_leaves_chance")).forGetter(cherryFoliagePlacer -> cherryFoliagePlacer.hangingLeavesChance), (Codec.floatRange(0.0f, 1.0f).fieldOf("hanging_leaves_extension_chance")).forGetter(cherryFoliagePlacer -> cherryFoliagePlacer.hangingLeavesExtensionChance))).apply(instance, EchoFoliagePlacer::new));
    private final IntProvider height;
    private final float wideBottomLayerHoleChance;
    private final float cornerHoleChance;
    private final float hangingLeavesChance;
    private final float hangingLeavesExtensionChance;

    public EchoFoliagePlacer(IntProvider intProvider, IntProvider intProvider2, IntProvider intProvider3, float f, float g, float h, float i) {
        super(intProvider, intProvider2);
        this.height = intProvider3;
        this.wideBottomLayerHoleChance = f;
        this.cornerHoleChance = g;
        this.hangingLeavesChance = h;
        this.hangingLeavesExtensionChance = i;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return DDFoliagePlacerTypes.ECHO_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, TreeConfiguration treeConfiguration, int i, FoliageAttachment foliageAttachment, int j, int k, int l) {
        boolean bl = foliageAttachment.doubleTrunk();
        BlockPos blockPos = foliageAttachment.pos().above(l);
        int m = k + foliageAttachment.radiusOffset() - 1;
        this.placeLeavesRow(levelSimulatedReader, biConsumer, randomSource, treeConfiguration, blockPos, m - 2, j - 3, bl);
        this.placeLeavesRow(levelSimulatedReader, biConsumer, randomSource, treeConfiguration, blockPos, m - 1, j - 4, bl);
        for (int n = j - 5; n >= 0; --n) {
            this.placeLeavesRow(levelSimulatedReader, biConsumer, randomSource, treeConfiguration, blockPos, m, n, bl);
        }
        this.placeLeavesRowWithHangingLeavesBelow(levelSimulatedReader, biConsumer, randomSource, treeConfiguration, blockPos, m, -1, bl, this.hangingLeavesChance, this.hangingLeavesExtensionChance);
        this.placeLeavesRowWithHangingLeavesBelow(levelSimulatedReader, biConsumer, randomSource, treeConfiguration, blockPos, m - 1, -2, bl, this.hangingLeavesChance, this.hangingLeavesExtensionChance);
    }

    protected final void placeLeavesRowWithHangingLeavesBelow(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, TreeConfiguration treeConfiguration, BlockPos blockPos, int i, int j, boolean bl, float f, float g) {
        this.placeLeavesRow(levelSimulatedReader, biConsumer, randomSource, treeConfiguration, blockPos, i, j, bl);
        int k = bl ? 1 : 0;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            Direction direction2 = direction.getClockWise();
            int l = direction2.getAxisDirection() == Direction.AxisDirection.POSITIVE ? i + k : i;
            mutableBlockPos.setWithOffset(blockPos, 0, j - 1, 0).move(direction2, l).move(direction, -i);
            for (int m = -i; m < i + k; ++m) {
                boolean bl2 = !treeConfiguration.foliageProvider.getState(randomSource, mutableBlockPos.move(Direction.UP)).isAir();
                mutableBlockPos.move(Direction.DOWN);
                if (bl2) {
                    mutableBlockPos.move(Direction.DOWN);
                    FoliagePlacer.tryPlaceLeaf(levelSimulatedReader, biConsumer, randomSource, treeConfiguration, mutableBlockPos);
                    mutableBlockPos.move(Direction.UP);
                }
                mutableBlockPos.move(direction);
            }
        }
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return this.height.sample(randomSource);
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int i, int j, int k, int l, boolean bl) {
        boolean bl3;
        if (j == -1 && (i == l || k == l) && randomSource.nextFloat() < this.wideBottomLayerHoleChance) {
            return true;
        }
        boolean bl2 = i == l && k == l;
        boolean bl4 = bl3 = l > 2;
        if (bl3) {
            return bl2 || i + k > l * 2 - 2 && randomSource.nextFloat() < this.cornerHoleChance;
        }
        return bl2 && randomSource.nextFloat() < this.cornerHoleChance;
    }
}

