package com.IMC.ynov.setup;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.entities.CompanionModel;
import com.IMC.ynov.entities.CompanionRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CompanionMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CompanionModel.COMPANION_LAYER, CompanionModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registration.COMPANION.get(), CompanionRenderer::new);
    }
}
