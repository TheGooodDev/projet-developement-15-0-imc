package com.IMC.ynov.datagen;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModels extends ItemModelProvider {

    public ModItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CompanionMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ResourceLocation rl = new ResourceLocation(CompanionMod.MODID, "name");

        withExistingParent(Registration.ORANGE_BUTTON_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_button"));
        withExistingParent(Registration.ORANGE_DOOR_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_door_bottom"));
        withExistingParent(Registration.ORANGE_FENCE_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_fence_post"));
        withExistingParent(Registration.ORANGE_FENCE_GATE_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_fence_gate"));
        withExistingParent(Registration.ORANGE_LEAVES_BLOCK_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_leaves_block"));
        withExistingParent(Registration.ORANGE_LOG_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_log"));
        withExistingParent(Registration.ORANGE_PLANKS_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_planks"));
        withExistingParent(Registration.ORANGE_PRESSURE_PLATE_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_pressure_plate"));
        withExistingParent(Registration.ORANGE_SAPLING_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_sapling"));
        withExistingParent(Registration.ORANGE_SLAB_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_slab"));
        withExistingParent(Registration.ORANGE_STAIRS_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_stairs"));
        withExistingParent(Registration.ORANGE_TRAPDOOR_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_trapdoor_top"));
//        withExistingParent(Registration.ORANGE_WOOD_ITEM.get().getRegistryName().getPath(), modLoc("block/orange_wood"));
        withExistingParent(Registration.PEAR_BUTTON_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_button"));
        withExistingParent(Registration.PEAR_DOOR_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_door_bottom"));
        withExistingParent(Registration.PEAR_FENCE_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_fence_post"));
        withExistingParent(Registration.PEAR_FENCE_GATE_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_fence_gate"));
        withExistingParent(Registration.PEAR_LEAVES_BLOCK_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_leaves_block"));
        withExistingParent(Registration.PEAR_LOG_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_log"));
        withExistingParent(Registration.PEAR_PLANKS_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_planks"));
        withExistingParent(Registration.PEAR_PRESSURE_PLATE_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_pressure_plate"));
        withExistingParent(Registration.PEAR_SAPLING_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_sapling"));
        withExistingParent(Registration.PEAR_SLAB_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_slab"));
        withExistingParent(Registration.PEAR_STAIRS_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_stairs"));
        withExistingParent(Registration.PEAR_TRAPDOOR_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_trapdoor_top"));
//        withExistingParent(Registration.PEAR_WOOD_ITEM.get().getRegistryName().getPath(), modLoc("block/pear_wood"));
        withExistingParent(Registration.BANANA_BUTTON_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_button"));
        withExistingParent(Registration.BANANA_DOOR_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_door_bottom"));
        withExistingParent(Registration.BANANA_FENCE_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_fence_post"));
        withExistingParent(Registration.BANANA_FENCE_GATE_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_fence_gate"));
        withExistingParent(Registration.BANANA_LEAVES_BLOCK_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_leaves_block"));
        withExistingParent(Registration.BANANA_LOG_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_log"));
        withExistingParent(Registration.BANANA_PLANKS_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_planks"));
        withExistingParent(Registration.BANANA_PRESSURE_PLATE_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_pressure_plate"));
        withExistingParent(Registration.BANANA_SAPLING_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_sapling"));
        withExistingParent(Registration.BANANA_SLAB_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_slab"));
        withExistingParent(Registration.BANANA_STAIRS_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_stairs"));
        withExistingParent(Registration.BANANA_TRAPDOOR_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_trapdoor_top"));
//        withExistingParent(Registration.BANANA_WOOD_ITEM.get().getRegistryName().getPath(), modLoc("block/banana_wood"));

        singleTexture(Registration.PEAR.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/pear"));

        singleTexture(Registration.BANANA.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/banana"));

        singleTexture(Registration.ORANGE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/orange"));

        singleTexture(Registration.FRUIT_SALAD.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/fruit_salad"));

        withExistingParent(Registration.COMPANION_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));

    }
}
