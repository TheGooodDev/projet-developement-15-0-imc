package com.IMC.ynov.item;

import com.IMC.ynov.Mod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mod.MOD_ID);

    public static final RegistryObject<Item> hugo = ITEMS.register("hugo",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.YNOV_TAB)));

    public static final RegistryObject<Item> thomas = ITEMS.register("thomas",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.YNOV_TAB)));

    public static final RegistryObject<Item> PEAR = ITEMS.register("pear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.YNOV_TAB).food(ModFoods.PEAR)));

    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.YNOV_TAB).food(ModFoods.ORANGE)));

    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.YNOV_TAB).food(ModFoods.BANANA)));

    public static final RegistryObject<Item> FRUIT_SALAD = ITEMS.register("fruit_salad",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.YNOV_TAB).food(ModFoods.FRUIT_SALAD)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
