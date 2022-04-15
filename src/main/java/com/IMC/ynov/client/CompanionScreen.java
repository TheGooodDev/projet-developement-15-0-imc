package com.IMC.ynov.client;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.container.CompanionMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class CompanionScreen extends AbstractContainerScreen<CompanionMenu> {

    private final ResourceLocation gui = new ResourceLocation(CompanionMod.MODID, "textures/gui/companion_gui.png");

    public CompanionScreen(CompanionMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, TextComponent.EMPTY);
        imageHeight = 168;
    }

    @Override
    protected void init() {
        super.init();
        titleLabelX = font.width(title) / 2;
        titleLabelY = 5;
        inventoryLabelX = imageWidth - font.width(playerInventoryTitle) - 7;
        inventoryLabelY = imageHeight - 95;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
        RenderSystem.setShaderTexture(0, gui);

        int x = (width - imageWidth) / 2;
        int y = (height - imageWidth) / 2;
        blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight, 256, 256);
    }

}
