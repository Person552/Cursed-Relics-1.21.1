package net.person552.cursedrelics.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;

public class ModItems {

    public static final Item CURSED_FRAGMENT = registerItem("cursed_fragment", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CursedRelics.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CursedRelics.LOGGER.info("Registering Mod Items for " + CursedRelics.MOD_ID);
    }
}
