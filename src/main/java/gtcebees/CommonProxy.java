package gtcebees;

import forestry.api.recipes.ICentrifugeRecipe;
import forestry.api.recipes.ISqueezerRecipe;
import forestry.api.recipes.RecipeManagers;
import forestry.core.items.ItemFluidContainerForestry;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gtcebees.Items.GTCombs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = GTCEBees.MODID)
public class CommonProxy {

    public void preInit() {

    }

    public void postInit() {
        for (ICentrifugeRecipe recipe : RecipeManagers.centrifugeManager.recipes()) {
            SimpleRecipeBuilder builder = RecipeMaps.CENTRIFUGE_RECIPES.recipeBuilder();
            builder.inputs(recipe.getInput().copy());
            for (ItemStack stack : recipe.getAllProducts().keySet()) {
                builder.chancedOutput(stack.copy(), (int) (recipe.getAllProducts().get(stack) * (float) Recipe.getMaxChancedValue()));
            }
            builder.EUt(5);
            builder.duration(128);
            builder.buildAndRegister();
        }

        for (ISqueezerRecipe recipe : RecipeManagers.squeezerManager.recipes()) {
            if (recipe.getResources().size() != 1 || recipe.getResources().get(0).getItem() instanceof ItemFluidContainerForestry)
                continue;
            if (RecipeMaps.FLUID_EXTRACTION_RECIPES.findRecipe(Integer.MAX_VALUE, recipe.getResources(), Collections.EMPTY_LIST) != null)
                continue;
            SimpleRecipeBuilder builder = RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder();
            builder.inputs(recipe.getResources().get(0).copy());
            if (!recipe.getRemnants().isEmpty())
                builder.chancedOutput(recipe.getRemnants().copy(), (int) (recipe.getRemnantsChance() * (float) Recipe.getMaxChancedValue()));
            if (recipe.getFluidOutput() != null)
                builder.fluidOutputs(recipe.getFluidOutput());
            builder.EUt(5);
            builder.duration(128);
            builder.buildAndRegister();
        }
    }


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(GTCombs.combItem);
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return itemBlock;
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
    }
}
