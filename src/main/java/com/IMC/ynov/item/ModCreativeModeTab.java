package com.IMC.ynov.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    public static final CreativeModeTab YNOV_TAB = new CreativeModeTab("ynov") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Moditems.hugo.get());
        }
    };
}
