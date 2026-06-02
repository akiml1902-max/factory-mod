package com.trish.factory;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BuildingStructures {
    public static BlockPos build(Level level, BlockPos origin, BuildingType type, Direction playerDirection) {
        return switch (type) {
            case FACTORY -> buildFactory(level, origin);
            case OIL_RIG -> buildOilRig(level, origin);
            case POWER_PLANT -> buildPowerPlant(level, origin);
            case QUARRY -> buildQuarry(level, origin);
            case WAREHOUSE -> buildWarehouse(level, origin);
            case GREENHOUSE -> buildGreenhouse(level, origin);
        };
    }

    private static BlockPos buildFactory(Level level, BlockPos o) {
        BlockPos chest = o.offset(0, 1, 5);
        box(level, o, -4, 0, 1, 4, 0, 8, Blocks.POLISHED_DEEPSLATE.defaultBlockState());
        hollow(level, o, -4, 1, 1, 4, 4, 8, Blocks.BRICKS.defaultBlockState());
        box(level, o, -4, 5, 1, 4, 5, 8, Blocks.IRON_BLOCK.defaultBlockState());
        box(level, o, -1, 1, 1, 1, 2, 1, Blocks.AIR.defaultBlockState());
        windows(level, o, Blocks.GLASS_PANE.defaultBlockState());
        box(level, o, 3, 5, 6, 3, 8, 6, Blocks.DEEPSLATE_BRICKS.defaultBlockState());
        set(level, o, 3, 9, 6, Blocks.CAMPFIRE.defaultBlockState());
        set(level, o, -3, 1, 7, Blocks.CRAFTING_TABLE.defaultBlockState());
        set(level, o, -2, 1, 7, Blocks.FURNACE.defaultBlockState());
        set(level, o, 2, 1, 7, Blocks.BLAST_FURNACE.defaultBlockState());
        set(level, o, chest, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH));
        return chest;
    }

    private static BlockPos buildOilRig(Level level, BlockPos o) {
        BlockPos chest = o.offset(0, 1, 4);
        box(level, o, -3, 0, 1, 3, 0, 7, Blocks.IRON_BLOCK.defaultBlockState());
        box(level, o, -3, 1, 1, 3, 1, 7, Blocks.IRON_BARS.defaultBlockState());
        box(level, o, -2, 1, 2, 2, 1, 6, Blocks.AIR.defaultBlockState());
        for (int y = 1; y <= 7; y++) {
            set(level, o, -2, y, 2, Blocks.IRON_BARS.defaultBlockState());
            set(level, o, 2, y, 2, Blocks.IRON_BARS.defaultBlockState());
            set(level, o, -2, y, 6, Blocks.IRON_BARS.defaultBlockState());
            set(level, o, 2, y, 6, Blocks.IRON_BARS.defaultBlockState());
        }
        box(level, o, -2, 7, 2, 2, 7, 6, Blocks.IRON_BLOCK.defaultBlockState());
        set(level, o, 0, 8, 4, Blocks.LIGHTNING_ROD.defaultBlockState());
        box(level, o, -1, 1, 3, 1, 3, 5, Blocks.BLACKSTONE.defaultBlockState());
        set(level, o, 0, 4, 4, Blocks.CHAIN.defaultBlockState());
        box(level, o, -4, 1, 7, -2, 3, 9, Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        set(level, o, -3, 1, 8, Blocks.BARREL.defaultBlockState());
        set(level, o, chest, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH));
        return chest;
    }

    private static BlockPos buildPowerPlant(Level level, BlockPos o) {
        BlockPos chest = o.offset(0, 1, 5);
        box(level, o, -4, 0, 1, 4, 0, 8, Blocks.SMOOTH_STONE.defaultBlockState());
        hollow(level, o, -4, 1, 1, 4, 4, 8, Blocks.STONE_BRICKS.defaultBlockState());
        box(level, o, -4, 5, 1, 4, 5, 8, Blocks.COPPER_BLOCK.defaultBlockState());
        box(level, o, -1, 1, 1, 1, 2, 1, Blocks.AIR.defaultBlockState());
        box(level, o, -2, 1, 4, 2, 3, 6, Blocks.CUT_COPPER.defaultBlockState());
        set(level, o, 0, 4, 5, Blocks.LIGHTNING_ROD.defaultBlockState());
        for (int x = -3; x <= 3; x += 2) set(level, o, x, 4, 2, Blocks.REDSTONE_LAMP.defaultBlockState());
        set(level, o, -3, 1, 7, Blocks.BLAST_FURNACE.defaultBlockState());
        set(level, o, chest, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH));
        return chest;
    }

    private static BlockPos buildQuarry(Level level, BlockPos o) {
        BlockPos chest = o.offset(-3, 1, 2);
        box(level, o, -5, 0, 1, 5, 0, 9, Blocks.STONE.defaultBlockState());
        box(level, o, -3, -1, 3, 3, -1, 8, Blocks.COBBLESTONE.defaultBlockState());
        box(level, o, -2, 1, 4, 2, 1, 8, Blocks.RAIL.defaultBlockState());
        box(level, o, -4, 1, 1, -2, 3, 3, Blocks.OAK_PLANKS.defaultBlockState());
        hollow(level, o, -4, 1, 1, -2, 3, 3, Blocks.OAK_LOG.defaultBlockState());
        box(level, o, -4, 4, 1, -2, 4, 3, Blocks.DARK_OAK_PLANKS.defaultBlockState());
        set(level, o, 0, 1, 6, Blocks.CAULDRON.defaultBlockState());
        set(level, o, 4, 1, 4, Blocks.COBBLESTONE_WALL.defaultBlockState());
        set(level, o, 4, 2, 4, Blocks.LANTERN.defaultBlockState());
        set(level, o, chest, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.EAST));
        return chest;
    }

    private static BlockPos buildWarehouse(Level level, BlockPos o) {
        BlockPos chest = o.offset(0, 1, 6);
        box(level, o, -5, 0, 1, 5, 0, 9, Blocks.OAK_PLANKS.defaultBlockState());
        hollow(level, o, -5, 1, 1, 5, 4, 9, Blocks.STRIPPED_SPRUCE_LOG.defaultBlockState());
        box(level, o, -5, 5, 1, 5, 5, 9, Blocks.DARK_OAK_PLANKS.defaultBlockState());
        box(level, o, -1, 1, 1, 1, 3, 1, Blocks.AIR.defaultBlockState());
        for (int x = -4; x <= 4; x += 2) {
            set(level, o, x, 1, 8, Blocks.BARREL.defaultBlockState());
            set(level, o, x, 2, 8, Blocks.BARREL.defaultBlockState());
        }
        set(level, o, -4, 1, 3, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH));
        set(level, o, 4, 1, 3, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH));
        set(level, o, chest, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH));
        return chest;
    }

    private static BlockPos buildGreenhouse(Level level, BlockPos o) {
        BlockPos chest = o.offset(0, 1, 6);
        box(level, o, -4, 0, 1, 4, 0, 8, Blocks.GRASS_BLOCK.defaultBlockState());
        hollow(level, o, -4, 1, 1, 4, 4, 8, Blocks.GLASS.defaultBlockState());
        box(level, o, -4, 5, 1, 4, 5, 8, Blocks.GLASS.defaultBlockState());
        box(level, o, -1, 1, 1, 1, 2, 1, Blocks.AIR.defaultBlockState());
        for (int z = 3; z <= 7; z++) {
            set(level, o, -3, 0, z, Blocks.FARMLAND.defaultBlockState());
            set(level, o, -2, 0, z, Blocks.FARMLAND.defaultBlockState());
            set(level, o, 0, 0, z, Blocks.FARMLAND.defaultBlockState());
            set(level, o, 2, 0, z, Blocks.FARMLAND.defaultBlockState());
            set(level, o, -2, 1, z, Blocks.WHEAT.defaultBlockState());
            set(level, o, 0, 1, z, Blocks.CARROTS.defaultBlockState());
            set(level, o, 2, 1, z, Blocks.POTATOES.defaultBlockState());
        }
        set(level, o, chest, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH));
        return chest;
    }

    private static void hollow(Level level, BlockPos o, int x1, int y1, int z1, int x2, int y2, int z2, BlockState wall) {
        box(level, o, x1, y1, z1, x2, y2, z2, wall);
        box(level, o, x1 + 1, y1, z1 + 1, x2 - 1, y2 - 1, z2 - 1, Blocks.AIR.defaultBlockState());
    }

    private static void windows(Level level, BlockPos o, BlockState glass) {
        for (int x = -3; x <= 3; x += 2) {
            set(level, o, x, 2, 1, glass);
            set(level, o, x, 2, 8, glass);
        }
        for (int z = 3; z <= 7; z += 2) {
            set(level, o, -4, 2, z, glass);
            set(level, o, 4, 2, z, glass);
        }
    }

    private static void box(Level level, BlockPos o, int x1, int y1, int z1, int x2, int y2, int z2, BlockState state) {
        for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++)
            for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++)
                for (int z = Math.min(z1, z2); z <= Math.max(z1, z2); z++)
                    set(level, o, x, y, z, state);
    }

    private static void set(Level level, BlockPos o, int x, int y, int z, BlockState state) {
        BlockPos p = o.offset(x, y, z);
        if (p.equals(o)) return;
        level.setBlock(p, state, 3);
    }

    private static void set(Level level, BlockPos origin, BlockPos pos, BlockState state) {
        if (pos.equals(origin)) return;
        level.setBlock(pos, state, 3);
    }
}
