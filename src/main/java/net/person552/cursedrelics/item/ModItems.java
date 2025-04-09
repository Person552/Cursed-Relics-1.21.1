package net.person552.cursedrelics.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.item.Custom.CaliburnItem;

public class ModItems {

    public static final Item CURSED_FRAGMENT = registerItem("cursed_fragment", new Item(new Item.Settings()));
    public static final Item CALIBURN = registerItem("caliburn", new CaliburnItem(ModToolMaterials.RELIC, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 4, -2.6F))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CursedRelics.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CursedRelics.LOGGER.info("Registering Mod Items for " + CursedRelics.MOD_ID);
    }
}
