package gtcebees.Recipes;

import forestry.core.ModuleCore;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTUtility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;
import java.util.stream.Collectors;

public class GTMachineRecipes {
    public static void init() {
        List<ItemStack> allWoodLogs = OreDictionary.getOres("logWood").stream()
                .flatMap(stack -> ModHandler.getAllSubItems(stack).stream())
                .collect(Collectors.toList());

        for (ItemStack wood : allWoodLogs) {
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().EUt(8).duration(16).circuitMeta(1).inputs(GTUtility.copyAmount(8, wood)).fluidInputs(Materials.SeedOil.getFluid(250)).outputs(ModuleCore.getItems().impregnatedCasing.getItemStack()).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().EUt(16).duration(64).circuitMeta(8).inputs(CountableIngredient.from(wood)).fluidInputs(Materials.SeedOil.getFluid(50)).outputs(ModuleCore.getItems().stickImpregnated.getItemStack()).buildAndRegister();
        }
        RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().EUt(128).duration(256).inputs(ModuleCore.getItems().phosphor.getItemStack()).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Phosphor)).fluidOutputs(Materials.Lava.getFluid(800)).buildAndRegister();
    }
}
