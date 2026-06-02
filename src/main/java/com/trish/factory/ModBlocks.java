package com.trish.factory;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FactoryMod.MODID);

    public static final RegistryObject<Block> FACTORY_BUILDER = registerBuilding("factory_builder", BuildingType.FACTORY);
    public static final RegistryObject<Block> OIL_RIG_BUILDER = registerBuilding("oil_rig_builder", BuildingType.OIL_RIG);
    public static final RegistryObject<Block> POWER_PLANT_BUILDER = registerBuilding("power_plant_builder", BuildingType.POWER_PLANT);
    public static final RegistryObject<Block> QUARRY_BUILDER = registerBuilding("quarry_builder", BuildingType.QUARRY);
    public static final RegistryObject<Block> WAREHOUSE_BUILDER = registerBuilding("warehouse_builder", BuildingType.WAREHOUSE);
    public static final RegistryObject<Block> GREENHOUSE_BUILDER = registerBuilding("greenhouse_builder", BuildingType.GREENHOUSE);

    private static RegistryObject<Block> registerBuilding(String name, BuildingType type) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new BuildingCoreBlock(type,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.METAL)
                        .strength(3.0F, 6.0F)
                        .sound(SoundType.METAL)
                        .requiresCorrectToolForDrops()));
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}
