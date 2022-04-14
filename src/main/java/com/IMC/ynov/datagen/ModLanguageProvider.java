package com.IMC.ynov.datagen;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.IMC.ynov.setup.ModSetup.TAB_NAME;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, CompanionMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "Tutorial");

        add(Registration.MYSTERIOUS_ORE_OVERWORLD.get(), "Mysterious ore");
        add(Registration.MYSTERIOUS_ORE_NETHER.get(), "Mysterious ore");
        add(Registration.MYSTERIOUS_ORE_END.get(), "Mysterious ore");
        add(Registration.MYSTERIOUS_ORE_DEEPSLATE.get(), "Mysterious ore");
        add(Registration.THIEF_EGG.get(), "Companion egg");
        add(Registration.BANANA_LOG.get(), "Banana log");
        add(Registration.BANANA_WOOD.get(), "Banana wood");
        add(Registration.BANANA_FENCE.get(), "Banana fence");
        add(Registration.BANANA_FENCE_GATE.get(), "Banana fence gate");
        add(Registration.BANANA_TRAPDOOR.get(), "Banana trapdoor");
        add(Registration.BANANA_SLAB.get(), "Banana slab");
        add(Registration.BANANA_STAIRS.get(), "Banana stairs");
        add(Registration.BANANA_SAPLING.get(), "Banana sapling");
        add(Registration.BANANA_BUTTON.get(), "Banana button");
        add(Registration.BANANA_PLANKS.get(), "Banana planks");
        add(Registration.BANANA_PRESSURE_PLATE.get(), "Banana pressure plate");
        add(Registration.BANANA_LEAVES_BLOCK.get(), "Banana leaves block");
        add(Registration.BANANA_DOOR.get(), "Banana door");
        add(Registration.PEAR_LOG.get(), "Pear log");
        add(Registration.PEAR_WOOD.get(), "Pear wood");
        add(Registration.PEAR_FENCE.get(), "Pear fence");
        add(Registration.PEAR_FENCE_GATE.get(), "Pear fence gate");
        add(Registration.PEAR_TRAPDOOR.get(), "Pear trapdoor");
        add(Registration.PEAR_SLAB.get(), "Pear slab");
        add(Registration.PEAR_STAIRS.get(), "Pear stairs");
        add(Registration.PEAR_SAPLING.get(), "Pear sapling");
        add(Registration.PEAR_BUTTON.get(), "Pear button");
        add(Registration.PEAR_PLANKS.get(), "Pear planks");
        add(Registration.PEAR_PRESSURE_PLATE.get(), "Pear pressure plate");
        add(Registration.PEAR_LEAVES_BLOCK.get(), "Pear leaves block");
        add(Registration.PEAR_DOOR.get(), "Pear door");
        add(Registration.ORANGE_LOG.get(), "Orange log");
        add(Registration.ORANGE_WOOD.get(), "Orange wood");
        add(Registration.ORANGE_FENCE.get(), "Orange fence");
        add(Registration.ORANGE_FENCE_GATE.get(), "Orange fence gate");
        add(Registration.ORANGE_TRAPDOOR.get(), "Orange trapdoor");
        add(Registration.ORANGE_SLAB.get(), "Orange slab");
        add(Registration.ORANGE_STAIRS.get(), "Orange stairs");
        add(Registration.ORANGE_SAPLING.get(), "Orange sapling");
        add(Registration.ORANGE_BUTTON.get(), "Orange button");
        add(Registration.ORANGE_PLANKS.get(), "Orange planks");
        add(Registration.ORANGE_PRESSURE_PLATE.get(), "Orange pressure plate");
        add(Registration.ORANGE_LEAVES_BLOCK.get(), "Orange leaves block");
        add(Registration.ORANGE_DOOR.get(), "Orange door");

        add(Registration.PEAR.get(), "Pear");
        add(Registration.BANANA.get(), "Banana");
        add(Registration.ORANGE.get(), "Orange");
        add(Registration.FRUIT_SALAD.get(), "Salad fruit");

        add(Registration.THIEF.get(), "Companion");

    }
}
