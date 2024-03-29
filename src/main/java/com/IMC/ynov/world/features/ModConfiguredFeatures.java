package com.IMC.ynov.world.features;


import com.IMC.ynov.setup.Registration;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import org.antlr.runtime.tree.Tree;


public class ModConfiguredFeatures {

    public static final ConfiguredFeature<TreeConfiguration, ?> PEARWOOD = register("pearwood", Registration.PEAR_TREE.get().configured(
            new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(Registration.PEAR_LOG.get().defaultBlockState()),
                    new StraightTrunkPlacer(5, 1, 2),
                    BlockStateProvider.simple(Registration.PEAR_LEAVES_BLOCK.get().defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 4),
                    new TwoLayersFeatureSize(1, 0, 1)).build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> BANANAWOOD = register("bananawood", Registration.BANANA_TREE.get().configured(
            new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(Registration.BANANA_LOG.get().defaultBlockState()),
                    new StraightTrunkPlacer(5, 1, 2),
                    BlockStateProvider.simple(Registration.BANANA_LEAVES_BLOCK.get().defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 4),
                    new TwoLayersFeatureSize(1, 0, 1)).build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> ORANGEWOOD = register("orangewood", Registration.ORANGE_TREE.get().configured(
            new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(Registration.ORANGE_LOG.get().defaultBlockState()),
                    new StraightTrunkPlacer(5, 1, 2),
                    BlockStateProvider.simple(Registration.ORANGE_LEAVES_BLOCK.get().defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 4),
                    new TwoLayersFeatureSize(1, 0, 1)).build()));



    private static <FC extends FeatureConfiguration>ConfiguredFeature<FC, ?>register(String name,
                                                                                     ConfiguredFeature<FC, ?>configuredFeature){
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, name, configuredFeature);
    }
}
