package com.IMC.ynov.entities;

import com.IMC.ynov.setup.Registration;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;

public class CompanionInventoryMenu extends AbstractContainerMenu {
    private Container companionContainer;
    private CompanionEntity companion;
    private IItemHandler inventory;

    public CompanionInventoryMenu(int pContainerId, Inventory playerInventory, CompanionEntity companion) {
        super(Registration.COMPANION_INVENTORY.get(), pContainerId );
        this.companion = companion;
        this.companionContainer = companion.inventory;
        this.inventory = new InvWrapper(playerInventory);

        int i = 3;
        int j = -18;
        companionContainer.startOpen((Player) inventory);
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < companion.getInventoryColumns(); l++) {
                this.addSlot(new Slot(companionContainer, 2 + l + k * companion.getInventoryColumns(), 80 + l * 18, 18 + k * 18));
            }
        }

        for(int i1 = 0; i1 < 3; ++i1) {
            for(int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot((Container) inventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 102 + i1 * 18 + -18));
            }
        }
        for(int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot((Container) inventory, j1, 8 + j1 * 18, 142));
        }
    }

    public boolean stillValid(@NotNull Player pPlayer) {
        return this.companion.isAlive() && this.companion.distanceTo(pPlayer) < 8.0F;
    }

    public @NotNull ItemStack quickMoveStack(@NotNull Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            int i = this.companionContainer.getContainerSize();
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

}
