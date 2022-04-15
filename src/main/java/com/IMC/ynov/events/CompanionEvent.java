package com.IMC.ynov.events;

import com.IMC.ynov.entities.CompanionEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;

public class CompanionEvent extends Event {

    private final CompanionEntity companion;

    public CompanionEvent(CompanionEntity companion) {
        this.companion = companion;
    }

    public static class TakeItemStack extends CompanionEvent {

        private ItemStack itemStack;

        private final Player player;

        public TakeItemStack(CompanionEntity companion, ItemStack itemStack, Player player) {
            super(companion);
            this.itemStack = itemStack;
            this.player = player;
        }

        public ItemStack getItemStack() {
            return itemStack;
        }

        public void setItemStack(ItemStack itemStack) {
            this.itemStack = itemStack;
        }

        public Player getPlayer() {
            return player;
        }
    }

    public CompanionEntity getCompanion() {
        return companion;
    }
}
