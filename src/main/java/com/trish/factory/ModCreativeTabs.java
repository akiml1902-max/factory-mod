package com.trish.factory;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FactoryMod.MODID);

    public static final RegistryObject<CreativeModeTab> FACTORY_TAB = CREATIVE_TABS.register("factory_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.factory"))
                    .icon(() -> new ItemStack(ModBlocks.FACTORY_BUILDER.get()))
                    .displayItems((params, output) -> {
                        output.accept(ModBlocks.FACTORY_BUILDER.get());
                        output.accept(ModBlocks.OIL_RIG_BUILDER.get());
                        output.accept(ModBlocks.POWER_PLANT_BUILDER.get());
                        output.accept(ModBlocks.QUARRY_BUILDER.get());
                        output.accept(ModBlocks.WAREHOUSE_BUILDER.get());
                        output.accept(ModBlocks.GREENHOUSE_BUILDER.get());
                        output.accept(ModItems.STEEL_INGOT.get());
                        output.accept(ModItems.CRUDE_OIL.get());
                        output.accept(ModItems.MACHINE_PARTS.get());
                        output.accept(ModItems.COPPER_WIRE.get());
                        output.accept(ModItems.STONE_CRATE.get());
                        output.accept(ModItems.SUPPLY_CRATE.get());
                        output.accept(ModItems.FERTILIZER_BAG.get());
                        output.accept(ModItems.ENERGY_CELL.get());
                    }).build());
}
