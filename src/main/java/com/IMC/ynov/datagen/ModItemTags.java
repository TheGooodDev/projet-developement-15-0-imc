package com.IMC.ynov.datagen;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends ItemTagsProvider {

    public ModItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, CompanionMod.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(Registration.MYSTERIOUS_ORE_OVERWORLD_ITEM.get())
                .add(Registration.MYSTERIOUS_ORE_NETHER_ITEM.get())
                .add(Registration.MYSTERIOUS_ORE_END_ITEM.get())
                .add(Registration.MYSTERIOUS_ORE_DEEPSLATE_ITEM.get());
        tag(Tags.Items.FENCE_GATES_WOODEN)
                .add(Registration.PEAR_FENCE_GATE_ITEM.get())
                .add(Registration.BANANA_FENCE_GATE_ITEM.get())
                .add(Registration.ORANGE_FENCE_GATE_ITEM.get());
        tag(Tags.Items.FENCES_WOODEN)
                .add(Registration.BANANA_FENCE_ITEM.get())
                .add(Registration.PEAR_FENCE_ITEM.get())
                .add(Registration.ORANGE_FENCE_ITEM.get());


//        tag(Registration.MYSTERIOUS_ORE_ITEM)
//                .add(Registration.MYSTERIOUS_ORE_OVERWORLD_ITEM.get())
//                .add(Registration.MYSTERIOUS_ORE_NETHER_ITEM.get())
//                .add(Registration.MYSTERIOUS_ORE_END_ITEM.get())
//                .add(Registration.MYSTERIOUS_ORE_DEEPSLATE_ITEM.get());
    }

    @Override
    public String getName() {
        return "Tutorial Tags";
    }
}
