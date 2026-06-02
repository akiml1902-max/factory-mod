package com.trish.factory;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FactoryMod.MODID);

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRUDE_OIL = ITEMS.register("crude_oil", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_PARTS = ITEMS.register("machine_parts", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_WIRE = ITEMS.register("copper_wire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STONE_CRATE = ITEMS.register("stone_crate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUPPLY_CRATE = ITEMS.register("supply_crate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FERTILIZER_BAG = ITEMS.register("fertilizer_bag", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERGY_CELL = ITEMS.register("energy_cell", () -> new Item(new Item.Properties()));
}
