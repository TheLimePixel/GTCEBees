package gtcebees.Bees;

import forestry.api.apiculture.*;
import forestry.api.genetics.AlleleSpeciesRegisterEvent;
import forestry.api.genetics.IAllele;
import forestry.apiculture.ModuleApiculture;
import forestry.apiculture.genetics.Bee;
import forestry.apiculture.genetics.BeeDefinition;
import forestry.apiculture.genetics.IBeeDefinition;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.core.genetics.alleles.AlleleHelper;
import gtcebees.Items.GTCombItem;
import gtcebees.Items.GTCombs;
import mezz.jei.config.Constants;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import org.apache.commons.lang3.text.WordUtils;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;
import java.util.Locale;

public enum GTBees implements IBeeDefinition {
    //Fuels
    CLAY(GTBranches.FUEL, "clay", true, new Color(0x19d0ec), new Color(0xe0c113)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.3f);
            beeSpecies.addProduct(new ItemStack(Items.CLAY_BALL), 0.45f);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
        }

        @Override
        protected void registerMutations() {
            registerMutation(BeeDefinition.INDUSTRIOUS, BeeDefinition.DILIGENT, 20);
        }
    },
    SLIME(GTBranches.FUEL, "slime", true, new Color(0x4e9e55), new Color(0x00e012)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(GTCombItem.getComb(GTCombs.RUBBERY, 1), 0.3f);
            beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.MOSSY, 1), 0.3f);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
        }

        @Override
        protected void registerMutations() {
            registerMutation(CLAY, BeeDefinition.MARSHY, 15);
        }
    },
    LIGNITE(GTBranches.FUEL, "lignite", true, new Color(0x906237), new Color(0x522d0a)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.15f);
            beeSpecies.addProduct(GTCombItem.getComb(GTCombs.LIGNITE, 1), 0.3f);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
        }

        @Override
        protected void registerMutations() {
            registerMutation(CLAY, BeeDefinition.RURAL, 20);
        }
    },;
    private final GTBranches branch;
    private final IAlleleBeeSpecies species;

    @Nullable
    private IAllele[] template;
    @Nullable
    private IBeeGenome genome;

    GTBees(GTBranches branch, String binomial, boolean dominant, Color primary, Color secondary) {
        String lowercaseName = this.toString().toLowerCase(Locale.ENGLISH);
        String species = "species" + WordUtils.capitalize(lowercaseName);

        String modId = Constants.MOD_ID;
        String uid = modId + '.' + species;
        String description = "for.description." + species;
        String name = "for.bees.species." + lowercaseName;

        this.branch = branch;
        IAlleleBeeSpeciesBuilder speciesBuilder = BeeManager.beeFactory.createSpecies(modId, uid, dominant, "Sengir", name, description, branch.getBranch(), binomial, primary.getRGB(), secondary.getRGB());
        if (isSecret()) {
            speciesBuilder.setIsSecret();
        }
        setSpeciesProperties(speciesBuilder);
        this.species = speciesBuilder.build();
    }

    protected abstract void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies);

    protected abstract void setAlleles(IAllele[] template);

    protected abstract void registerMutations();

    protected boolean isSecret() {
        return false;
    }

    public static void initBees() {
        for (GTBees bee : values()) {
            bee.init();
        }
        for (GTBees bee : values()) {
            bee.registerMutations();
        }
    }

    public static void preInit() {
        MinecraftForge.EVENT_BUS.post(new AlleleSpeciesRegisterEvent<>(BeeManager.beeRoot, IAlleleBeeSpecies.class));
    }

    private void init() {
        template = branch.getTemplate();
        AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPECIES, species);
        setAlleles(template);

        genome = BeeManager.beeRoot.templateAsGenome(template);

        BeeManager.beeRoot.registerTemplate(template);
    }

    protected final IBeeMutationBuilder registerMutation(GTBees parent1, GTBees parent2, int chance) {
        return BeeManager.beeMutationFactory.createMutation(parent1.species, parent2.species, getTemplate(), chance);
    }

    protected final IBeeMutationBuilder registerMutation(BeeDefinition parent1, BeeDefinition parent2, int chance) {
        return BeeManager.beeMutationFactory.createMutation(parent1.getGenome().getPrimary(), parent2.getGenome().getPrimary(), getTemplate(), chance);
    }

    protected final IBeeMutationBuilder registerMutation(GTBees parent1, BeeDefinition parent2, int chance) {
        return BeeManager.beeMutationFactory.createMutation(parent1.species, parent2.getGenome().getPrimary(), getTemplate(), chance);
    }

    @Override
    public final IAllele[] getTemplate() {
        return Arrays.copyOf(template, template.length);
    }

    @Override
    public final IBeeGenome getGenome() {
        return genome;
    }

    @Override
    public final IBee getIndividual() {
        return new Bee(genome);
    }

    @Override
    public final ItemStack getMemberStack(EnumBeeType beeType) {
        IBee bee = getIndividual();
        return BeeManager.beeRoot.getMemberStack(bee, beeType);
    }
}
