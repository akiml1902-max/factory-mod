package com.trish.factory;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FactoryMod.MODID);

    public static final RegistryObject<BlockEntityType<FactoryCoreBlockEntity>> FACTORY_CORE = BLOCK_ENTITIES.register("factory_core",
            () -> BlockEntityType.Builder.of(FactoryCoreBlockEntity::new,
                    ModBlocks.FACTORY_BUILDER.get(),
                    ModBlocks.OIL_RIG_BUILDER.get(),
                    ModBlocks.POWER_PLANT_BUILDER.get(),
                    ModBlocks.QUARRY_BUILDER.get(),
                    ModBlocks.WAREHOUSE_BUILDER.get(),
                    ModBlocks.GREENHOUSE_BUILDER.get()).build(null));
}
