package net.person552.cursedrelics.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup CURSED_RELICS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CursedRelics.MOD_ID, "cursed_relics_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CURSED_RUNE))
                    .displayName(Text.translatable("itemgroup.cursedrelics.cursed_relics_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CURSED_RUNE);
                        entries.add(ModItems.CURSED_FRAGMENT);
                        entries.add(ModItems.CURSED_HANDLE);
                        entries.add(ModItems.CURSED_INGOT);

                        entries.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                        entries.add(ModItems.SAPPHIRE);

                        entries.add(ModItems.CURSED_KEY);
                        entries.add(ModItems.INERT_KATAREMI);
                        entries.add(ModItems.INERT_SANCTEMI);

                        entries.add(ModItems.CALIBURN);
                        entries.add(ModItems.XIPHANOX);
                        entries.add(ModItems.LACERACT);
                        entries.add(ModItems.MAIN_HAND_DAGGER);

                        entries.add(ModBlocks.CURSED_STONE_BRICKS);
                        entries.add(ModBlocks.CURSED_STONE_BRICK_STAIRS);
                        entries.add(ModBlocks.CURSED_STONE_BRICK_SLAB);
                        entries.add(ModBlocks.CURSED_STONE_BRICK_WALL);
                        entries.add(ModBlocks.CURSED_STONE_BRICK_PRESSURE_PLATE);

                        entries.add(ModBlocks.SMOOTH_CURSED_STONE);
                        entries.add(ModBlocks.SMOOTH_CURSED_STONE_STAIRS);
                        entries.add(ModBlocks.SMOOTH_CURSED_STONE_SLAB);
                        entries.add(ModBlocks.SMOOTH_CURSED_STONE_PRESSURE_PLATE);

                        entries.add(ModBlocks.CURSED_STONE_BRICK_PILLAR);
                        entries.add(ModBlocks.CHISELED_CURSED_STONE_BRICKS);

                        entries.add(ModBlocks.CURSED_TRIAL_SPAWNER);
                    }).build());


    public static void registerItemGroups() {
        CursedRelics.LOGGER.info("Registering Mod Item Groups for " + CursedRelics.MOD_ID);
    }
}
