package com.IMC.ynov.client;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.container.CompanionMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CompanionScreen extends AbstractContainerScreen<CompanionMenu> {

    private final ResourceLocation GUI = new ResourceLocation(CompanionMod.MODID, "textures/gui/companion_gui.png");

    public CompanionScreen(CompanionMenu container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShaderTexture(0, GUI);
        int relX = (this.width - this.imageWidth) / 2;
        int relY = (this.height - this.imageHeight) / 2;
        this.blit(pPoseStack, relX, relY, 0, 0, this.imageWidth, this.imageHeight);

    }
}
