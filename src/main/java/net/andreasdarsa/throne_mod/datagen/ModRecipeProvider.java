package net.andreasdarsa.throne_mod.datagen;

import net.andreasdarsa.throne_mod.block.ModBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.THRONE.get())
                .pattern(" G ")
                .pattern("WRW")
                .pattern("WWW")
                .define('G', Items.GOLD_INGOT)
                .define('W', Items.SPRUCE_PLANKS)
                .define('R', Items.RED_WOOL)
                .unlockedBy(getHasName(Items.RED_WOOL), has(Items.RED_WOOL)).save(pRecipeOutput);
    }
}
