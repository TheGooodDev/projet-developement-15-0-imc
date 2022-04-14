package com.IMC.ynov;

import com.IMC.ynov.setup.ModSetup;
import com.IMC.ynov.setup.ClientSetup;
import com.IMC.ynov.setup.Registration;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CompanionMod.MODID)
public class CompanionMod {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "ynov";

    public CompanionMod() {

        // Register the deferred registry
        Registration.init();

        // Register the setup method for modloading
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        modbus.addListener(this::clientSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));

    }

    private void clientSetup(final FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(Registration.PEAR_SAPLING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(Registration.PEAR_LEAVES_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Registration.BANANA_SAPLING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(Registration.PEAR_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(Registration.PEAR_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(Registration.BANANA_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(Registration.BANANA_TRAPDOOR.get(), RenderType.translucent());
    }
}
