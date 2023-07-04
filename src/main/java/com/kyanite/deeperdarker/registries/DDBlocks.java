package com.kyanite.deeperdarker.registries;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.registries.blocks.*;
import com.kyanite.deeperdarker.registries.entities.DDHangingSignBlockEntity;
import com.kyanite.deeperdarker.registries.entities.DDSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class DDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DeeperDarker.MOD_ID);

    private static final BlockSetType ECHO_SET = BlockSetType.register(new BlockSetType("echo"));
    public static final WoodType ECHO = WoodType.register(new WoodType("echo", ECHO_SET));
    public static final RegistryObject<RotatedPillarBlock> ECHO_LOG = register("echo_log", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_LIGHT_GRAY : MapColor.DEEPSLATE), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> ECHO_WOOD = register("echo_wood", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).mapColor(MapColor.DEEPSLATE), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ECHO_LOG = register("stripped_echo_log", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_LIGHT_GRAY), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ECHO_WOOD = register("stripped_echo_wood", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_LIGHT_GRAY), 5, 5));
    public static final RegistryObject<Block> ECHO_PLANKS = register("echo_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<StairBlock> ECHO_STAIRS = register("echo_stairs", () -> new FlammableStairBlock(() -> ECHO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<SlabBlock> ECHO_SLAB = register("echo_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<FenceBlock> ECHO_FENCE = register("echo_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<FenceGateBlock> ECHO_FENCE_GATE = register("echo_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO, 20, 5));
    public static final RegistryObject<DoorBlock> ECHO_DOOR = register("echo_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO_SET));
    public static final RegistryObject<TrapDoorBlock> ECHO_TRAPDOOR = register("echo_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO_SET));
    public static final RegistryObject<PressurePlateBlock> ECHO_PRESSURE_PLATE = register("echo_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO_SET));
    public static final RegistryObject<ButtonBlock> ECHO_BUTTON = register("echo_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), ECHO_SET, 30, true));
    public static final RegistryObject<LeavesBlock> ECHO_LEAVES = register("echo_leaves", () -> new FlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), 60, 30));
    public static final RegistryObject<StandingSignBlock> ECHO_SIGN = BLOCKS.register("echo_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallSignBlock> ECHO_WALL_SIGN = BLOCKS.register("echo_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).lootFrom(ECHO_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<CeilingHangingSignBlock> ECHO_HANGING_SIGN = BLOCKS.register("echo_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallHangingSignBlock> ECHO_WALL_HANGING_SIGN = BLOCKS.register("echo_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).lootFrom(ECHO_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> pBlock) {
        RegistryObject<T> block = BLOCKS.register(name, pBlock);
        DDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}
