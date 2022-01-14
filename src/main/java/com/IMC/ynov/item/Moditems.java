package com.IMC.ynov.item;

import com.IMC.ynov.Start;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Start.MOD_ID);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP)
    public static final RegistryObject<Item> Hugo = ITEMS.register("hugo",
            () -> new Item())

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
