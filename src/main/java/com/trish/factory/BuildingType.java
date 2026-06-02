package com.trish.factory;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Supplier;

public enum BuildingType {
    FACTORY("Factory", 20 * 35, List.of(
            new LootEntry(ModItems.STEEL_INGOT, 1, 4),
            new LootEntry(ModItems.MACHINE_PARTS, 1, 2),
            new LootEntry(ModItems.COPPER_WIRE, 2, 5)
    )),
    OIL_RIG("Oil Rig", 20 * 40, List.of(
            new LootEntry(ModItems.CRUDE_OIL, 2, 5),
            new LootEntry(ModItems.MACHINE_PARTS, 1, 1)
    )),
    POWER_PLANT("Power Plant", 20 * 45, List.of(
            new LootEntry(ModItems.ENERGY_CELL, 1, 3),
            new LootEntry(ModItems.COPPER_WIRE, 1, 4),
            new LootEntry(ModItems.STEEL_INGOT, 1, 2)
    )),
    QUARRY("Quarry", 20 * 30, List.of(
            new LootEntry(ModItems.STONE_CRATE, 2, 6),
            new LootEntry(ModItems.STEEL_INGOT, 1, 2)
    )),
    WAREHOUSE("Warehouse", 20 * 50, List.of(
            new LootEntry(ModItems.SUPPLY_CRATE, 1, 4),
            new LootEntry(ModItems.MACHINE_PARTS, 1, 2),
            new LootEntry(ModItems.FERTILIZER_BAG, 1, 3)
    )),
    GREENHOUSE("Greenhouse", 20 * 35, List.of(
            new LootEntry(ModItems.FERTILIZER_BAG, 2, 5),
            new LootEntry(ModItems.SUPPLY_CRATE, 1, 2)
    ));

    public final String displayName;
    public final int intervalTicks;
    private final List<LootEntry> loot;

    BuildingType(String displayName, int intervalTicks, List<LootEntry> loot) {
        this.displayName = displayName;
        this.intervalTicks = intervalTicks;
        this.loot = loot;
    }

    public ItemStack randomLoot(RandomSource random) {
        LootEntry entry = loot.get(random.nextInt(loot.size()));
        int count = entry.min + random.nextInt(entry.max - entry.min + 1);
        return new ItemStack(entry.item.get(), count);
    }

    private record LootEntry(Supplier<Item> item, int min, int max) {}
}
