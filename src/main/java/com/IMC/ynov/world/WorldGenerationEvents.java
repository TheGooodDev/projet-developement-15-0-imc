package com.IMC.ynov.world;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.world.gen.ModTreeGeneration;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;


@Mod.EventBusSubscriber(modid = CompanionMod.MODID)
public class WorldGenerationEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
        if (types.contains(BiomeDictionary.Type.PLAINS)){
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModTreeGeneration.PEAR_TREE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModTreeGeneration.BANANA_TREE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModTreeGeneration.ORANGE_TREE_PLACED);
        }

    }
}
