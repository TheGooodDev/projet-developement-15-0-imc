package com.IMC.ynov.datagen;

import com.IMC.ynov.CompanionMod;
import com.IMC.ynov.setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.client.gui.screens.recipebook.RecipeButton;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.NBTIngredient;

import java.util.function.Consumer;

public class ModRecipes extends RecipeProvider {

    public ModRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(Registration.PEAR_BUTTON.get())
                .requires(Registration.PEAR_PLANKS.get(), 1)
                .group("ynov")
                .unlockedBy("pear",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.PEAR_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_SLAB.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("###")
                .define('#', Registration.PEAR_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("pear",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.PEAR_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_FENCE_GATE.get(), 3)
                .pattern("   ")
                .pattern("a#a")
                .pattern("a#a")
                .define('#', Registration.PEAR_PLANKS.get())
                .define('a', Items.STICK)
                .group(CompanionMod.MODID)
                .unlockedBy("pear",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.PEAR_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_FENCE.get(), 3)
                .pattern("   ")
                .pattern("#a#")
                .pattern("#a#")
                .define('#', Registration.PEAR_PLANKS.get())
                .define('a', Items.STICK)
                .group(CompanionMod.MODID)
                .unlockedBy("pear",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.PEAR_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_STAIRS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', Registration.PEAR_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("pear",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.PEAR_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern(" ##")
                .define('#', Registration.PEAR_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("pear",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.PEAR_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_TRAPDOOR.get())
                .pattern("   ")
                .pattern("###")
                .pattern("###")
                .define('#', Registration.PEAR_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("pear",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.PEAR_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_DOOR.get())
                .pattern(" ##")
                .pattern(" ##")
                .pattern(" ##")
                .define('#', Registration.PEAR_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("pear",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.PEAR_LOG.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(Registration.PEAR_PLANKS.get(),  4)
                .requires(Registration.PEAR_LOG.get())
                .group(CompanionMod.MODID)
                .unlockedBy("pear",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.PEAR_LOG.get()))
                .save(consumer);


        ShapelessRecipeBuilder.shapeless(Registration.BANANA_BUTTON.get())
                .requires(Registration.BANANA_PLANKS.get(), 1)
                .group(CompanionMod.MODID)
                .unlockedBy("banana",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BANANA_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_SLAB.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("###")
                .define('#', Registration.BANANA_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("banana",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BANANA_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_FENCE_GATE.get(), 3)
                .pattern("   ")
                .pattern("a#a")
                .pattern("a#a")
                .define('#', Registration.BANANA_PLANKS.get())
                .define('a', Items.STICK)
                .group(CompanionMod.MODID)
                .unlockedBy("banana",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BANANA_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_FENCE.get(), 3)
                .pattern("   ")
                .pattern("#a#")
                .pattern("#a#")
                .define('#', Registration.BANANA_PLANKS.get())
                .define('a', Items.STICK)
                .group(CompanionMod.MODID)
                .unlockedBy("banana",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BANANA_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_STAIRS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', Registration.BANANA_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("banana",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BANANA_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern(" ##")
                .define('#', Registration.BANANA_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("banana",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BANANA_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_TRAPDOOR.get())
                .pattern("   ")
                .pattern("###")
                .pattern("###")
                .define('#', Registration.BANANA_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("banana",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BANANA_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_DOOR.get())
                .pattern(" ##")
                .pattern(" ##")
                .pattern(" ##")
                .define('#', Registration.BANANA_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("banana",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BANANA_LOG.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(Registration.BANANA_PLANKS.get(),4)
                .requires(Registration.BANANA_LOG.get())
                .group(CompanionMod.MODID)
                .unlockedBy("banana",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BANANA_LOG.get()))
                .save(consumer);


        ShapelessRecipeBuilder.shapeless(Registration.ORANGE_BUTTON.get())
                .requires(Registration.ORANGE_PLANKS.get(), 1)
                .group(CompanionMod.MODID)
                .unlockedBy("orange",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ORANGE_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_SLAB.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("###")
                .define('#', Registration.ORANGE_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("orange",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ORANGE_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_FENCE_GATE.get(), 3)
                .pattern("   ")
                .pattern("a#a")
                .pattern("a#a")
                .define('#', Registration.ORANGE_PLANKS.get())
                .define('a', Items.STICK)
                .group(CompanionMod.MODID)
                .unlockedBy("orange",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ORANGE_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_FENCE.get(), 3)
                .pattern("   ")
                .pattern("#a#")
                .pattern("#a#")
                .define('#', Registration.ORANGE_PLANKS.get())
                .define('a', Items.STICK)
                .group(CompanionMod.MODID)
                .unlockedBy("orange",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ORANGE_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_STAIRS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', Registration.ORANGE_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("orange",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ORANGE_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern(" ##")
                .define('#', Registration.ORANGE_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("orange",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ORANGE_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_TRAPDOOR.get())
                .pattern("   ")
                .pattern("###")
                .pattern("###")
                .define('#', Registration.ORANGE_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("orange",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ORANGE_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_DOOR.get())
                .pattern(" ##")
                .pattern(" ##")
                .pattern(" ##")
                .define('#', Registration.ORANGE_PLANKS.get())
                .group(CompanionMod.MODID)
                .unlockedBy("orange",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ORANGE_LOG.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(Registration.ORANGE_PLANKS.get(),4)
                .requires(Registration.ORANGE_LOG.get())
                .group(CompanionMod.MODID)
                .unlockedBy("orange",InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ORANGE_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.FRUIT_SALAD.get())
                .pattern(" # ")
                .pattern("abc")
                .pattern(" d ")
                .define('#', Items.APPLE)
                .define('a', Registration.BANANA.get())
                .define('b', Registration.PEAR.get())
                .define('c', Registration.ORANGE.get())
                .define('d', Items.BOWL)
                .group(CompanionMod.MODID)
                .unlockedBy("orange",InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOWL))
                .save(consumer);
    }
}
