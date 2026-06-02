package com.trish.factory;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FactoryCoreBlockEntity extends BlockEntity {
    private boolean built = false;
    private BuildingType type = BuildingType.FACTORY;
    private BlockPos chestPos = BlockPos.ZERO;
    private int timer = 0;

    public FactoryCoreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FACTORY_CORE.get(), pos, state);
        if (state.getBlock() instanceof BuildingCoreBlock block) {
            this.type = block.getBuildingType();
        }
    }

    public boolean isBuilt() {
        return built;
    }

    public void activate(BuildingType type, BlockPos chestPos) {
        this.built = true;
        this.type = type;
        this.chestPos = chestPos;
        this.timer = 0;
        setChanged();
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, FactoryCoreBlockEntity core) {
        if (!core.built) return;
        core.timer++;
        if (core.timer < core.type.intervalTicks) return;
        core.timer = 0;

        BlockEntity chestEntity = level.getBlockEntity(core.chestPos);
        if (!(chestEntity instanceof Container container)) return;

        ItemStack loot = core.type.randomLoot(level.random);
        addToContainer(container, loot);
        core.setChanged();
    }

    private static void addToContainer(Container container, ItemStack stack) {
        for (int slot = 0; slot < container.getContainerSize(); slot++) {
            ItemStack current = container.getItem(slot);
            if (!current.isEmpty() && ItemStack.isSameItemSameTags(current, stack) && current.getCount() < current.getMaxStackSize()) {
                int move = Math.min(stack.getCount(), current.getMaxStackSize() - current.getCount());
                current.grow(move);
                stack.shrink(move);
                container.setChanged();
                if (stack.isEmpty()) return;
            }
        }
        for (int slot = 0; slot < container.getContainerSize(); slot++) {
            if (container.getItem(slot).isEmpty()) {
                container.setItem(slot, stack.copy());
                stack.setCount(0);
                container.setChanged();
                return;
            }
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        built = tag.getBoolean("Built");
        timer = tag.getInt("Timer");
        if (tag.contains("Type")) type = BuildingType.valueOf(tag.getString("Type"));
        if (tag.contains("ChestPos")) chestPos = BlockPos.of(tag.getLong("ChestPos"));
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("Built", built);
        tag.putInt("Timer", timer);
        tag.putString("Type", type.name());
        tag.putLong("ChestPos", chestPos.asLong());
    }
}
