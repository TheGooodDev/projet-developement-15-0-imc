package com.IMC.ynov.entities;

import com.IMC.ynov.CompanionMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class CompanionRenderer extends HumanoidMobRenderer<CompanionEntity, CompanionModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(CompanionMod.MODID, "textures/entity/companion.png");

    public CompanionRenderer(EntityRendererProvider.Context context) {
        super(context, new CompanionModel(context.bakeLayer(CompanionModel.COMPANION_LAYER)), 1f);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(CompanionEntity entity) {
        return TEXTURE;
    }
}
