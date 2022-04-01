package com.IMC.ynov.world.gen;

import com.IMC.ynov.world.features.ModConfiguredFeatures;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import org.antlr.v4.misc.FrequencySet;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModTreeGeneration {
    public static PlacedFeature PEAR_TREE_PLACED = PlacementUtils.register("pear_tree_placement",
                ModConfiguredFeatures.PEARWOOD.placed(RarityFilter.onAverageOnceEvery(12),
                        InSquarePlacement.spread(),
                        //PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        PlacementUtils.HEIGHTMAP_TOP_SOLID,
                        BiomeFilter.biome()));
    }
