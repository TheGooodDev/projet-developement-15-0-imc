package com.IMC.ynov.datagen;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModels extends ItemModelProvider {

    public ModItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CompanionMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        withExistingParent(Registration.COMPANION_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));

    }
}
