package net.person552.cursedrelics.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.item.custom.*;

public class ModItems {

    public static final Item CURSED_RUNE = registerItem("cursed_rune", new Item(new Item.Settings()));
    public static final Item CURSED_FRAGMENT = registerItem("cursed_fragment", new Item(new Item.Settings()));
    public static final Item CURSED_HANDLE = registerItem("cursed_handle", new Item(new Item.Settings()));
    public static final Item CURSED_INGOT = registerItem("cursed_ingot", new Item(new Item.Settings()));
    public static final Item INERT_KATAREMI = registerItem("inert_kataremi", new Item(new Item.Settings()));
    public static final Item INERT_SANCTEMI = registerItem("inert_sanctemi", new Item(new Item.Settings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings().maxDamage(3)));

    public static final Item CURSED_KEY = registerItem("cursed_key", new Item(new Item.Settings()));

    protected static final Item.Settings UNBREAKABLE_SETTINGS = new Item.Settings()
            .maxCount(1)
            .maxDamage(0)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));

    public static final Item CALIBURN = registerItem("caliburn", new CaliburnItem(ModToolMaterials.RELIC,
            UNBREAKABLE_SETTINGS
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RELIC, 6, -3F))));

    public static final Item XIPHANOX = registerItem("xiphanox", new XiphanoxItem(ModToolMaterials.RELIC,
            UNBREAKABLE_SETTINGS
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RELIC, 6, -3F))));

    public static final Item LACERACT = registerItem("laceract", new LaceractItem(ModToolMaterials.RELIC,
            UNBREAKABLE_SETTINGS
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RELIC, 0, -2F))));

    public static final Item MAIN_HAND_DAGGER = registerItem("main_hand_dagger", new MainHandDaggerItem(
            UNBREAKABLE_SETTINGS
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RELIC, 0, -2F))
                    .component(DataComponentTypes.TOOL, TridentItem.createToolComponent())));

    public static final Item OFF_HAND_DAGGER = registerItem("off_hand_dagger", new OffHandDaggerItem(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CursedRelics.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CursedRelics.LOGGER.info("Registering Mod Items for " + CursedRelics.MOD_ID);
    }
}
