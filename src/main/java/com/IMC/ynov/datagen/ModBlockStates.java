package com.IMC.ynov.datagen;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.lang.ref.Reference;

public class ModBlockStates extends BlockStateProvider {

    public ModBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, CompanionMod.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {

        buttonBlock(Registration.PEAR_BUTTON.get(),modLoc("block/pear_button"));
        doorBlock(Registration.PEAR_DOOR.get(),modLoc("block/pear_door_bottom"),modLoc("block/pear_door_top"));
        logBlock(Registration.PEAR_LOG.get());
        simpleBlock(Registration.PEAR_PLANKS.get());
        pressurePlateBlock(Registration.PEAR_PRESSURE_PLATE.get(),modLoc("block/pear_button"));
        simpleBlock(Registration.PEAR_SAPLING.get());
        slabBlock(Registration.PEAR_SLAB.get(),modLoc("block/pear_planks"),modLoc("block/pear_planks"));
        stairsBlock(Registration.PEAR_STAIRS.get(),modLoc("block/pear_planks"));
        trapdoorBlock(Registration.PEAR_TRAPDOOR.get(),modLoc("block/pear_trapdoor"),true);
        simpleBlock(Registration.PEAR_LEAVES_BLOCK.get());
        fenceBlock(Registration.PEAR_FENCE.get(),modLoc("block/pear_planks"));
        fenceGateBlock(Registration.PEAR_FENCE_GATE.get(),modLoc("block/pear_planks"));
//        simpleBlock(Registration.PEAR_WOOD.get());
        buttonBlock(Registration.BANANA_BUTTON.get(),modLoc("block/banana_button"));
        doorBlock(Registration.BANANA_DOOR.get(),modLoc("block/banana_door_bottom"),modLoc("block/banana_door_top"));
        logBlock(Registration.BANANA_LOG.get());
        simpleBlock(Registration.BANANA_PLANKS.get());
        pressurePlateBlock(Registration.BANANA_PRESSURE_PLATE.get(),modLoc("block/banana_button"));
        simpleBlock(Registration.BANANA_SAPLING.get());
        slabBlock(Registration.BANANA_SLAB.get(),modLoc("block/banana_planks"),modLoc("block/banana_planks"));
        stairsBlock(Registration.BANANA_STAIRS.get(),modLoc("block/banana_planks"));
        trapdoorBlock(Registration.BANANA_TRAPDOOR.get(),modLoc("block/banana_trapdoor"),true);
        simpleBlock(Registration.BANANA_LEAVES_BLOCK.get());
        fenceBlock(Registration.BANANA_FENCE.get(),modLoc("block/banana_planks"));
        fenceGateBlock(Registration.BANANA_FENCE_GATE.get(),modLoc("block/banana_planks"));
//        simpleBlock(Registration.BANANA_WOOD.get());
        buttonBlock(Registration.ORANGE_BUTTON.get(),modLoc("block/orange_button"));
        doorBlock(Registration.ORANGE_DOOR.get(),modLoc("block/orange_door_bottom"),modLoc("block/orange_door_top"));
        logBlock(Registration.ORANGE_LOG.get());
        simpleBlock(Registration.ORANGE_PLANKS.get());
        pressurePlateBlock(Registration.ORANGE_PRESSURE_PLATE.get(),modLoc("block/orange_button"));
        simpleBlock(Registration.ORANGE_SAPLING.get());
        slabBlock(Registration.ORANGE_SLAB.get(),modLoc("block/orange_planks"),modLoc("block/orange_planks"));
        stairsBlock(Registration.ORANGE_STAIRS.get(),modLoc("block/orange_planks"));
        trapdoorBlock(Registration.ORANGE_TRAPDOOR.get(),modLoc("block/orange_trapdoor"),true);
        simpleBlock(Registration.ORANGE_LEAVES_BLOCK.get());
        fenceBlock(Registration.ORANGE_FENCE.get(),modLoc("block/orange_planks"));
        fenceGateBlock(Registration.ORANGE_FENCE_GATE.get(),modLoc("block/orange_planks"));
//        simpleBlock(Registration.ORANGE_WOOD.get());
    }


}
