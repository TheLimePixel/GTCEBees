package gtcebees;

import net.minecraftforge.common.config.Config;

@Config(modid = GTCEBees.MODID)
public class GTCEBeesConfig {
    @Config.Comment("Config options for generated recipes")
    public static Recipes Recipes = new Recipes();

    public static class Recipes {
        @Config.Comment("Generate a recipe in the GT Centrifuge for every recipe in the Forestry Centrifuge")
        public boolean GenerateCentrifugeRecipes = true;

        @Config.Comment("Generate a recipe in the Fluid Extractor for every recipe in the Squeezer")
        public boolean GenerateExtractorRecipes = true;

        @Config.Comment("Add Autoclave recipes for the Combs")
        public boolean AutoclaverRecipes = true;

        @Config.Comment("Add Chemical Reactor recipes for the Combs")
        public boolean ReactorRecipes = true;

        @Config.Comment("Add Assembling Machine recipes for Impregnated items")
        public boolean AssemblerRecipes = true;
    }
}
