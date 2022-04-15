package com.IMC.ynov.datagen;

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
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_SLAB.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("###")
                .define('#', Registration.PEAR_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_STAIRS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', Registration.PEAR_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern(" ##")
                .define('#', Registration.PEAR_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_TRAPDOOR.get())
                .pattern("   ")
                .pattern("###")
                .pattern("###")
                .define('#', Registration.PEAR_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.PEAR_DOOR.get())
                .pattern(" ##")
                .pattern(" ##")
                .pattern(" ##")
                .define('#', Registration.PEAR_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(Registration.PEAR_PLANKS.get())
                .requires(Registration.PEAR_LOG.get(), 4)
                .group("ynov")
                .save(consumer);


        ShapelessRecipeBuilder.shapeless(Registration.BANANA_BUTTON.get())
                .requires(Registration.BANANA_PLANKS.get(), 1)
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_SLAB.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("###")
                .define('#', Registration.BANANA_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_STAIRS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', Registration.BANANA_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern(" ##")
                .define('#', Registration.BANANA_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_TRAPDOOR.get())
                .pattern("   ")
                .pattern("###")
                .pattern("###")
                .define('#', Registration.BANANA_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.BANANA_DOOR.get())
                .pattern(" ##")
                .pattern(" ##")
                .pattern(" ##")
                .define('#', Registration.BANANA_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(Registration.BANANA_PLANKS.get())
                .requires(Registration.BANANA_LOG.get(), 4)
                .group("ynov")
                .save(consumer);


        ShapelessRecipeBuilder.shapeless(Registration.ORANGE_BUTTON.get())
                .requires(Registration.ORANGE_PLANKS.get(), 1)
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_SLAB.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("###")
                .define('#', Registration.ORANGE_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_STAIRS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', Registration.ORANGE_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern(" ##")
                .define('#', Registration.ORANGE_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_TRAPDOOR.get())
                .pattern("   ")
                .pattern("###")
                .pattern("###")
                .define('#', Registration.ORANGE_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.ORANGE_DOOR.get())
                .pattern(" ##")
                .pattern(" ##")
                .pattern(" ##")
                .define('#', Registration.ORANGE_PLANKS.get())
                .group("ynov")
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(Registration.ORANGE_PLANKS.get())
                .requires(Registration.ORANGE_LOG.get(), 4)
                .group("ynov")
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
                .group("ynov")
                .save(consumer);
    }
}
