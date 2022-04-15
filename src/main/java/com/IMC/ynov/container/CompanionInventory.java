package com.IMC.ynov.container;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class CompanionInventory extends ItemStackHandler {

    public CompanionInventory(int inventorySize) {
        super (inventorySize);
    }

    @Override
    public void setSize(int inventorySize) {
        NonNullList<ItemStack> items = stacks;

        super.setSize(inventorySize);

        for (int i = 0; i < items.size(); i++) {
            stacks.set(i, items.get(i));
        }
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        return super.isItemValid(slot, stack);
    }

    @Override
    protected int getStackLimit(int slot, @NotNull ItemStack stack) {
        return super.getStackLimit(slot, stack);
    }
}
