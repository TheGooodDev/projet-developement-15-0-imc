package com.IMC.ynov.datagen;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.setup.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends BlockTagsProvider {

    public ModBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, CompanionMod.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.LOGS)
                .add(Registration.PEAR_LOG.get())
                .add(Registration.BANANA_LOG.get())
                .add(Registration.ORANGE_LOG.get());
        tag(BlockTags.WOODEN_BUTTONS)
                .add(Registration.PEAR_BUTTON.get())
                .add(Registration.BANANA_BUTTON.get())
                .add(Registration.ORANGE_BUTTON.get());
        tag(BlockTags.WOODEN_DOORS)
                .add(Registration.PEAR_DOOR.get())
                .add(Registration.BANANA_DOOR.get())
                .add(Registration.ORANGE_DOOR.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(Registration.PEAR_PRESSURE_PLATE.get())
                .add(Registration.BANANA_PRESSURE_PLATE.get())
                .add(Registration.ORANGE_PRESSURE_PLATE.get());
        tag(BlockTags.SAPLINGS)
                .add(Registration.PEAR_SAPLING.get())
                .add(Registration.BANANA_SAPLING.get())
                .add(Registration.ORANGE_SAPLING.get());
        tag(BlockTags.WOODEN_SLABS)
                .add(Registration.PEAR_SLAB.get())
                .add(Registration.BANANA_SLAB.get())
                .add(Registration.ORANGE_SLAB.get());
        tag(BlockTags.PLANKS)
                .add(Registration.PEAR_PLANKS.get())
                .add(Registration.BANANA_PLANKS.get())
                .add(Registration.ORANGE_PLANKS.get());
        tag(BlockTags.LOGS)
                .add(Registration.PEAR_LOG.get())
                .add(Registration.BANANA_LOG.get())
                .add(Registration.ORANGE_LOG.get());
        tag(BlockTags.TRAPDOORS)
                .add(Registration.PEAR_TRAPDOOR.get())
                .add(Registration.BANANA_TRAPDOOR.get())
                .add(Registration.ORANGE_TRAPDOOR.get());
        tag(BlockTags.LEAVES)
                .add(Registration.PEAR_LEAVES_BLOCK.get())
                .add(Registration.BANANA_LEAVES_BLOCK.get())
                .add(Registration.ORANGE_LEAVES_BLOCK.get());

    }

    @Override
    public String getName() {
        return "Companion tag";
    }
}
