package com.IMC.ynov;


import com.IMC.ynov.setup.Registration;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@net.minecraftforge.fml.common.Mod(Mod.MOD_ID)
public class Mod
{
    public static final String MOD_ID = "ynov";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Mod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();


        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
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

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}