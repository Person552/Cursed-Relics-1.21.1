package net.person552.cursedrelics.item;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.item.custom.CaliburnItem;
import net.person552.cursedrelics.item.custom.LaceractItem;
import net.person552.cursedrelics.item.custom.XiphanoxItem;

public class ModItems {

    public static final Item CURSED_RUNE = registerItem("cursed_rune", new Item(new Item.Settings()));
    public static final Item CURSED_FRAGMENT = registerItem("cursed_fragment", new Item(new Item.Settings()));
    public static final Item CURSED_HANDLE = registerItem("cursed_handle", new Item(new Item.Settings()));
    public static final Item CURSED_INGOT = registerItem("cursed_ingot", new Item(new Item.Settings()));


    public static final Item CURSED_KEY = registerItem("cursed_key", new Item(new Item.Settings()));
    
    public static final Item CALIBURN = registerItem("caliburn", new CaliburnItem(ModToolMaterials.RELIC, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RELIC, 6, -3F))));
    public static final Item XIPHANOX = registerItem("xiphanox", new XiphanoxItem(ModToolMaterials.RELIC, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RELIC, 6, -3F))));
    public static final Item LACERACT = registerItem("laceract", new LaceractItem(ModToolMaterials.RELIC, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RELIC, 0, -2F))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CursedRelics.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CursedRelics.LOGGER.info("Registering Mod Items for " + CursedRelics.MOD_ID);
    }
}
