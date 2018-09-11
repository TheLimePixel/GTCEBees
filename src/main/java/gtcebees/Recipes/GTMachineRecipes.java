package gtcebees.Recipes;

import forestry.core.ModuleCore;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTUtility;
import gtcebees.Items.GTCombItem;
import gtcebees.Items.GTCombs;
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

        //Comb Autoclave Recipes
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(1280).inputs(GTCombItem.getComb(GTCombs.LIGNITE, 16)).fluidInputs(Materials.UUMatter.getFluid(1)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Lignite)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(3072).inputs(GTCombItem.getComb(GTCombs.COAL, 16)).fluidInputs(Materials.UUMatter.getFluid(3)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Coal)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(12544).inputs(GTCombItem.getComb(GTCombs.OIL, 16)).fluidInputs(Materials.UUMatter.getFluid(10)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Oilsands)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(2304).inputs(GTCombItem.getComb(GTCombs.STONE, 16)).fluidInputs(Materials.UUMatter.getFluid(2)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Soapstone)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(12544).inputs(GTCombItem.getComb(GTCombs.CERTUS, 16)).fluidInputs(Materials.UUMatter.getFluid(10)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Cerium)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(10880).inputs(GTCombItem.getComb(GTCombs.REDSTONE, 16)).fluidInputs(Materials.UUMatter.getFluid(9)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Redstone)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(3584).inputs(GTCombItem.getComb(GTCombs.LAPIS, 16)).fluidInputs(Materials.UUMatter.getFluid(3)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Lapis)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(3200).inputs(GTCombItem.getComb(GTCombs.RUBY, 16)).fluidInputs(Materials.UUMatter.getFluid(3)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Ruby)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(2560).inputs(GTCombItem.getComb(GTCombs.SAPPHIRE, 16)).fluidInputs(Materials.UUMatter.getFluid(2)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Sapphire)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(98300).inputs(GTCombItem.getComb(GTCombs.DIAMOND, 16)).fluidInputs(Materials.UUMatter.getFluid(77)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Diamond)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(3584).inputs(GTCombItem.getComb(GTCombs.OLIVINE, 16)).fluidInputs(Materials.UUMatter.getFluid(3)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Olivine)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(2304).inputs(GTCombItem.getComb(GTCombs.EMERALD, 16)).fluidInputs(Materials.UUMatter.getFluid(2)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Emerald)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(3584).inputs(GTCombItem.getComb(GTCombs.SLAG, 16)).fluidInputs(Materials.UUMatter.getFluid(3)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Salt)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(8064).inputs(GTCombItem.getComb(GTCombs.COPPON, 16)).fluidInputs(Materials.UUMatter.getFluid(7)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Copper)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(15104).inputs(GTCombItem.getComb(GTCombs.TINE, 16)).fluidInputs(Materials.UUMatter.getFluid(12)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Tin)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(26496).inputs(GTCombItem.getComb(GTCombs.PLUMBIA, 16)).fluidInputs(Materials.UUMatter.getFluid(21)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Lead)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(7168).inputs(GTCombItem.getComb(GTCombs.FERRU, 16)).fluidInputs(Materials.UUMatter.getFluid(6)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Iron)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(7168).inputs(GTCombItem.getComb(GTCombs.STEELDUST, 16)).fluidInputs(Materials.UUMatter.getFluid(6)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Iron)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(7424).inputs(GTCombItem.getComb(GTCombs.NICKELDUST, 16)).fluidInputs(Materials.UUMatter.getFluid(6)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Nickel)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(8320).inputs(GTCombItem.getComb(GTCombs.GALVANIA, 16)).fluidInputs(Materials.UUMatter.getFluid(7)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Zinc)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(13696).inputs(GTCombItem.getComb(GTCombs.ARGENTIA, 16)).fluidInputs(Materials.UUMatter.getFluid(11)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Silver)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(25088).inputs(GTCombItem.getComb(GTCombs.AURELIA, 16)).fluidInputs(Materials.UUMatter.getFluid(20)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Gold)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(3328).inputs(GTCombItem.getComb(GTCombs.BAUXIA, 16)).fluidInputs(Materials.UUMatter.getFluid(3)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Aluminium)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(7040).inputs(GTCombItem.getComb(GTCombs.PYROLUSIUM, 16)).fluidInputs(Materials.UUMatter.getFluid(6)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Manganese)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(6144).inputs(GTCombItem.getComb(GTCombs.TITANIUM, 16)).fluidInputs(Materials.UUMatter.getFluid(5)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Titanium)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(4736).inputs(GTCombItem.getComb(GTCombs.SCHEELINIUM, 16)).fluidInputs(Materials.UUMatter.getFluid(4)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Tungsten)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(24960).inputs(GTCombItem.getComb(GTCombs.PLATINA, 16)).fluidInputs(Materials.UUMatter.getFluid(20)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Platinum)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(24576).inputs(GTCombItem.getComb(GTCombs.QUANTARIA, 16)).fluidInputs(Materials.UUMatter.getFluid(20)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Iridium)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(30464).inputs(GTCombItem.getComb(GTCombs.URANIA, 16)).fluidInputs(Materials.UUMatter.getFluid(24)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Uranium)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(31488).inputs(GTCombItem.getComb(GTCombs.PLUTONIUM, 16)).fluidInputs(Materials.UUMatter.getFluid(25)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Plutonium)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().EUt(384).duration(12544).inputs(GTCombItem.getComb(GTCombs.STARGATIUM, 16)).fluidInputs(Materials.UUMatter.getFluid(10)).outputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Naquadah)).buildAndRegister();
    }
}
