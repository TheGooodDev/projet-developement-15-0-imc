package com.IMC.ynov.world;

import com.IMC.ynov.world.gen.ModTreeGeneration;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = com.IMC.ynov.Mod.MOD_ID)
public class WorldGenerationEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){
        event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModTreeGeneration.PEAR_TREE_PLACED);
    }
}
