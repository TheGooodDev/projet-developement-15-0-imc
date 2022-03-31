package com.IMC.ynov.entities;

import com.IMC.ynov.CompanionMod;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;

public class CompanionModel extends HumanoidModel<CompanionEntity> {

    public static final String BODY = "body";

    public static ModelLayerLocation COMPANION_LAYER = new ModelLayerLocation(new ResourceLocation(CompanionMod.MODID, "companion"), BODY);

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = createMesh(CubeDeformation.NONE, 0.6f);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public CompanionModel(ModelPart part) {
        super(part);
    }
}
