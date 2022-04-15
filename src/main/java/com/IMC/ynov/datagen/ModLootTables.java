package com.IMC.ynov.datagen;

import com.IMC.ynov.setup.Registration;
import net.minecraft.data.DataGenerator;

public class ModLootTables extends BaseLootTableProvider {

    public ModLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(Registration.PEAR_LOG.get(), createStandardTable("pear log", Registration.PEAR_LOG.get()));
        lootTables.put(Registration.PEAR_PLANKS.get(), createStandardTable("pear planks", Registration.PEAR_PLANKS.get()));
        lootTables.put(Registration.PEAR_SAPLING.get(), createStandardTable("pear sapling", Registration.PEAR_SAPLING.get()));
        lootTables.put(Registration.PEAR_STAIRS.get(), createStandardTable("pear stairs", Registration.PEAR_STAIRS.get()));
        lootTables.put(Registration.PEAR_SLAB.get(), createStandardTable("pear slab", Registration.PEAR_SLAB.get()));
        lootTables.put(Registration.PEAR_DOOR.get(), createStandardTable("pear door", Registration.PEAR_DOOR.get()));
        lootTables.put(Registration.PEAR_TRAPDOOR.get(), createStandardTable("pear trapdoor", Registration.PEAR_TRAPDOOR.get()));
        lootTables.put(Registration.PEAR_BUTTON.get(), createStandardTable("pear button", Registration.PEAR_BUTTON.get()));
        lootTables.put(Registration.PEAR_FENCE_GATE.get(), createStandardTable("pear fence gate", Registration.PEAR_FENCE_GATE.get()));
        lootTables.put(Registration.PEAR_PRESSURE_PLATE.get(), createStandardTable("pear pressure plate", Registration.PEAR_PRESSURE_PLATE.get()));
        lootTables.put(Registration.PEAR_FENCE.get(), createStandardTable("pear fence", Registration.PEAR_FENCE.get()));


        lootTables.put(Registration.BANANA_LOG.get(), createStandardTable("banana log", Registration.BANANA_LOG.get()));
        lootTables.put(Registration.BANANA_PLANKS.get(), createStandardTable("banana planks", Registration.BANANA_PLANKS.get()));
        lootTables.put(Registration.BANANA_SAPLING.get(), createStandardTable("banana sapling", Registration.BANANA_SAPLING.get()));
        lootTables.put(Registration.BANANA_STAIRS.get(), createStandardTable("banana stairs", Registration.BANANA_STAIRS.get()));
        lootTables.put(Registration.BANANA_SLAB.get(), createStandardTable("banana slab", Registration.BANANA_SLAB.get()));
        lootTables.put(Registration.BANANA_DOOR.get(), createStandardTable("banana door", Registration.BANANA_DOOR.get()));
        lootTables.put(Registration.BANANA_TRAPDOOR.get(), createStandardTable("banana trapdoor", Registration.BANANA_TRAPDOOR.get()));
        lootTables.put(Registration.BANANA_BUTTON.get(), createStandardTable("banana button", Registration.BANANA_BUTTON.get()));
        lootTables.put(Registration.BANANA_FENCE_GATE.get(), createStandardTable("banana fence gate", Registration.BANANA_FENCE_GATE.get()));
        lootTables.put(Registration.BANANA_PRESSURE_PLATE.get(), createStandardTable("banana pressure plate", Registration.BANANA_PRESSURE_PLATE.get()));
        lootTables.put(Registration.BANANA_FENCE.get(), createStandardTable("banana fence", Registration.BANANA_FENCE.get()));


        lootTables.put(Registration.ORANGE_LOG.get(), createStandardTable("orange log", Registration.ORANGE_LOG.get()));
        lootTables.put(Registration.ORANGE_PLANKS.get(), createStandardTable("orange planks", Registration.ORANGE_PLANKS.get()));
        lootTables.put(Registration.ORANGE_SAPLING.get(), createStandardTable("orange sapling", Registration.ORANGE_SAPLING.get()));
        lootTables.put(Registration.ORANGE_STAIRS.get(), createStandardTable("orange stairs", Registration.ORANGE_STAIRS.get()));
        lootTables.put(Registration.ORANGE_SLAB.get(), createStandardTable("orange slab", Registration.ORANGE_SLAB.get()));
        lootTables.put(Registration.ORANGE_DOOR.get(), createStandardTable("orange door", Registration.ORANGE_DOOR.get()));
        lootTables.put(Registration.ORANGE_TRAPDOOR.get(), createStandardTable("orange trapdoor", Registration.ORANGE_TRAPDOOR.get()));
        lootTables.put(Registration.ORANGE_BUTTON.get(), createStandardTable("orange button", Registration.ORANGE_BUTTON.get()));
        lootTables.put(Registration.ORANGE_FENCE_GATE.get(), createStandardTable("orange fence gate", Registration.ORANGE_FENCE_GATE.get()));
        lootTables.put(Registration.ORANGE_PRESSURE_PLATE.get(), createStandardTable("orange pressure plate", Registration.ORANGE_PRESSURE_PLATE.get()));
        lootTables.put(Registration.ORANGE_FENCE.get(), createStandardTable("orange fence", Registration.ORANGE_FENCE.get()));


        lootTables.put(Registration.PEAR_LEAVES_BLOCK.get(), leaveTable("pear leave", Registration.PEAR.get(), Registration.PEAR_SAPLING.get()));
        lootTables.put(Registration.BANANA_LEAVES_BLOCK.get(), leaveTable("banana leave", Registration.BANANA.get(), Registration.BANANA_SAPLING.get()));
        lootTables.put(Registration.ORANGE_LEAVES_BLOCK.get(), leaveTable("orange leave", Registration.ORANGE.get(), Registration.ORANGE_SAPLING.get()));
    }
}
