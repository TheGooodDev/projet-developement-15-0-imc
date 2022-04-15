package com.IMC.ynov.world;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.entities.CompanionEntity;
import com.IMC.ynov.setup.Registration;
import com.IMC.ynov.world.gen.ModTreeGeneration;
import com.sun.jna.Structure;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.VillagePools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.StructureSpawnManager;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.StructureSpawnListGatherEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

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

    @SubscribeEvent
    public static void StructureSpawnEvent(final StructureSpawnListGatherEvent event){
        System.out.println(event.getStructure().getFeatureName());
        System.out.println(event.getStructure() == StructureFeature.VILLAGE);
        if(event.getStructure() == StructureFeature.VILLAGE){
            System.out.println("test");
            event.addEntitySpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(Registration.COMPANION.get(),200,5,10));

        }
    }
}
