package net.person552.cursedrelics.item;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.item.Custom.CaliburnItem;
import net.person552.cursedrelics.item.Custom.XiphanoxItem;

public class ModItems {

    public static final Item CURSED_RUNE = registerItem("cursed_rune", new Item(new Item.Settings()));
    public static final Item CURSED_KEY = registerItem("cursed_key", new Item(new Item.Settings()));
    
    public static final Item CALIBURN = registerItem("caliburn", new CaliburnItem(ModToolMaterials.RELIC, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RELIC, 6, -3F))));
    public static final Item XIPHANOX = registerItem("xiphanox", new XiphanoxItem(ModToolMaterials.RELIC, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RELIC, 6, -3F))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CursedRelics.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CursedRelics.LOGGER.info("Registering Mod Items for " + CursedRelics.MOD_ID);
    }
}
