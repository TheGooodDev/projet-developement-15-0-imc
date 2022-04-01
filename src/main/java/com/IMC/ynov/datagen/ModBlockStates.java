package com.IMC.ynov.datagen;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStates extends BlockStateProvider {

    public ModBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, CompanionMod.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Registration.MYSTERIOUS_ORE_OVERWORLD.get());
        simpleBlock(Registration.MYSTERIOUS_ORE_NETHER.get());
        simpleBlock(Registration.MYSTERIOUS_ORE_END.get());
        simpleBlock(Registration.MYSTERIOUS_ORE_DEEPSLATE.get());
        simpleBlock(Registration.BANANA_LEAVES_BLOCK.get());
        simpleBlock(Registration.BANANA_BUTTON.get());
        simpleBlock(Registration.BANANA_DOOR.get());
        simpleBlock(Registration.BANANA_FENCE.get());
        simpleBlock(Registration.BANANA_FENCE_GATE.get());
        simpleBlock(Registration.BANANA_LOG.get());
        simpleBlock(Registration.BANANA_PLANKS.get());
        simpleBlock(Registration.BANANA_PRESSURE_PLATE.get());
        simpleBlock(Registration.BANANA_SAPLING.get());
        simpleBlock(Registration.BANANA_SLAB.get());
        simpleBlock(Registration.BANANA_STAIRS.get());
        simpleBlock(Registration.BANANA_TRAPDOOR.get());
        simpleBlock(Registration.BANANA_WOOD.get());
        simpleBlock(Registration.PEAR_BUTTON.get());
        simpleBlock(Registration.PEAR_LEAVES_BLOCK.get());
        simpleBlock(Registration.PEAR_DOOR.get());
        simpleBlock(Registration.PEAR_FENCE.get());
        simpleBlock(Registration.PEAR_FENCE_GATE.get());
        simpleBlock(Registration.PEAR_LOG.get());
        simpleBlock(Registration.PEAR_PLANKS.get());
        simpleBlock(Registration.PEAR_PRESSURE_PLATE.get());
        simpleBlock(Registration.PEAR_SAPLING.get());
        simpleBlock(Registration.PEAR_SLAB.get());
        simpleBlock(Registration.PEAR_STAIRS.get());
        simpleBlock(Registration.PEAR_TRAPDOOR.get());
        simpleBlock(Registration.PEAR_WOOD.get());
    }
}
