package gtcebees.Items;

import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;

import java.awt.*;
import java.util.Locale;


public enum GTCombs implements IStringSerializable {
    LIGNITE(new Color(0x906237), new Color(0x58300b)),
    COAL(new Color(0x666666), new Color(0x525252)),
    RUBBERY(new Color(0x277b4e), new Color(0xdcc289)),
    OIL(new Color(0x414141), new Color(0x333333)),
    STONE(new Color(0x6e6e6e), new Color(0x999999)),
    CERTUS(new Color(0x4bb2d8), new Color(0xbbeeff)),
    REDSTONE(new Color(0x7d0f0f), new Color(0xd11919)),
    LAPIS(new Color(0x153db3), new Color(0x476cda)),
    RUBY(new Color(0xc5004f), new Color(0xcc0052)),
    SAPPHIRE(new Color(0x002caf), new Color(0x00248f)),
    DIAMOND(new Color(0xafdbdb), new Color(0xa3cccc)),
    OLIVINE(new Color(0x248f24), new Color(0xccffcc)),
    EMERALD(new Color(0x1f7b1f), new Color(0x2eb82e)),
    SLAG(new Color(0xb6b6b6), new Color(0x58300b)),
    COPPON(new Color(0xdb5800), new Color(0xe65c00)),
    TINE(new Color(0xb6b6b6), new Color(0xdddddd)),
    PLUMBIA(new Color(0x585883), new Color(0xa3a3cc)),
    FERRU(new Color(0xbb7d3d), new Color(0xde9c59)),
    STEELDUST(new Color(0x6e6e6e), new Color(0x999999)),
    NICKELDUST(new Color(0x727295), new Color(0x9d9dbd)),
    GALVANIA(new Color(0xcebfce), new Color(0xf2e1f2)),
    ARGENTIA(new Color(0xa7a7b8), new Color(0xcecede)),
    AURELIA(new Color(0xc59e00), new Color(0xcfa600)),
    BAUXIA(new Color(0x00769e), new Color(0xd6d6ff)),
    PYROLUSIUM(new Color(0xb7b7b7), new Color(0xaaaaaa)),
    TITANIUM(new Color(0xaf83db), new Color(0xdbb8ff)),
    CHROMIUM(new Color(0xca8aca), new Color(0xf2c3f2)),
    SCHEELINIUM(new Color(0x54545e), new Color(0x050508)),
    PLATINA(new Color(0xc5c5c5), new Color(0xffffcc)),
    QUANTARIA(new Color(0xbbbbbb), new Color(0xd1d1e0)),
    URANIA(new Color(0x159615), new Color(0x169e16)),
    PLUTONIUM(new Color(0x2c4f2c), new Color(0x6b8f00)),
    STARGATIUM(new Color(0x002c00), new Color(0x002400));

    public static final GTCombs[] VALUES = values();

    public final String name;
    public final int primaryColor;
    public final int secondaryColor;
    private final boolean secret;

    public static GTCombItem combItem = new GTCombItem();

    GTCombs(Color primary, Color secondary) {
        this(primary, secondary, false);
    }

    GTCombs(Color primary, Color secondary, boolean secret) {
        this.name = toString().toLowerCase(Locale.ENGLISH);
        this.primaryColor = primary.getRGB();
        this.secondaryColor = secondary.getRGB();
        this.secret = secret;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isSecret() {
        return secret;
    }

    public static GTCombs get(int meta) {
        if (meta >= VALUES.length) {
            meta = 0;
        }
        return VALUES[meta];
    }
}
