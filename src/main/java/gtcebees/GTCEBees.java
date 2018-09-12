package gtcebees;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.Material;
import gregtech.common.blocks.BlockCompressed;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = GTCEBees.MODID,
        name = GTCEBees.NAME,
        version = GTCEBees.VERSION,
        dependencies = "required-after:gregtech;required-after:forestry"
)
public class GTCEBees {
    public static final String MODID = "gtcebees";
    public static final String NAME = "GTCE Bees";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(
            modId = MODID,
            clientSide = "gtcebees.ClientProxy",
            serverSide = "gtcebees.CommonProxy"
    )
    public static CommonProxy proxy;

    private static Logger logger;

    public GTCEBees() {
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

    public static IBlockState getStateFromMaterial(Material material)
    {
        return MetaBlocks.COMPRESSED.get(material).getStateFromMeta(((BlockCompressed)MetaBlocks.COMPRESSED.get(material)).variantProperty.getAllowedValues().indexOf(material));
    }
}
