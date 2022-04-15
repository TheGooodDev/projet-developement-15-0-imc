package com.IMC.ynov.container;

import com.IMC.ynov.entities.CompanionEntity;
import com.IMC.ynov.events.CompanionEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class CompanionInventorySlot extends SlotItemHandler {
    private final CompanionEntity companion;

    public CompanionInventorySlot(ItemStackHandler companionInventory, int i, int inventoryX, int inventoryY, CompanionEntity companion) {
        super(companionInventory, i, inventoryX, inventoryY);
        this.companion = companion;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public void onTake(Player pPlayer, ItemStack pStack) {
        CompanionEvent.TakeItemStack takeItemStack = new CompanionEvent.TakeItemStack(companion, pStack, pPlayer);
        MinecraftForge.EVENT_BUS.post(takeItemStack);
        super.onTake(pPlayer, takeItemStack.getItemStack());
    }
}
