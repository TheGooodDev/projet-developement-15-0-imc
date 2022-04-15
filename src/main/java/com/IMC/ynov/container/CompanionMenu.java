package com.IMC.ynov.container;

import com.IMC.ynov.entities.CompanionEntity;
import com.IMC.ynov.setup.Registration;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;

public class CompanionMenu extends AbstractContainerMenu {

    private final InvWrapper playerInvWrapper;
    private final ItemStackHandler companionInventory;
    private final CompanionEntity companion;

    public CompanionMenu(int pContainerId, Inventory inventory, CompanionEntity companion) {
        super(Registration.COMPANION_INVENTORY.get(), pContainerId);
        this.playerInvWrapper = new InvWrapper(inventory);
        this.companionInventory = companion.getInventory();
        this.companion = companion;

        setCompanionSlots();
        setPlayerSlots();
    }

    public CompanionEntity getCompanion() {
        return companion;
    }

    private void setCompanionSlots() {
        int inventoryX = 44;
        int inventoryY = 20;
        for (int i = 0; i < companionInventory.getSlots(); i++) {
            addSlot(new CompanionInventorySlot(this.companionInventory, i, inventoryX, inventoryY, companion));
        }

    }

    private void setPlayerSlots() {
        int i = 0;

        for (int j = 0; j < 9; j++) {
            addSlot(new SlotItemHandler(this.playerInvWrapper, i++, 8 + 18 * j, 140));
        }

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 9; l++) {
                addSlot(new SlotItemHandler(this.playerInvWrapper, i++, 8 + 18 * l, 82 + 18 * k));
            }
        }
    }

    public boolean stillValid(@NotNull Player pPlayer) {
        return this.companion.isAlive() && this.companion.distanceTo(pPlayer) < 8.0F;
    }
/*
    public @NotNull ItemStack quickMoveStack(@NotNull Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            int i = this.companionInventory.getSlots();
            if (pIndex < i) {
                if (!this.moveItemStackTo(itemstack1, i, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.getSlot(1).mayPlace(itemstack1) && !this.getSlot(1).hasItem()) {
                if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.getSlot(0).mayPlace(itemstack1)) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (i <= 2 || !this.moveItemStackTo(itemstack1, 2, i, false)) {
                int j = i + 27;
                int k = j + 9;
                if (pIndex >= j && pIndex < k) {
                    if (!this.moveItemStackTo(itemstack1, i, j, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= i && pIndex < j) {
                    if (!this.moveItemStackTo(itemstack1, j, k, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(itemstack1, j, j, false)) {
                    return ItemStack.EMPTY;
                }

                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    public void removed(@NotNull Player pPlayer) {
        super.removed(pPlayer);
        this.companionContainer.stopOpen(pPlayer);
    }
*/
}
