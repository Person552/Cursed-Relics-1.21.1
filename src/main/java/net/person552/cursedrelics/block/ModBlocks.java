package net.person552.cursedrelics.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.block.custom.CursedTrialSpawnerBlock;
import net.person552.cursedrelics.block.custom.CursedVaultBlock;

public class ModBlocks {
    public static final Block CURSED_STONE_BRICKS = registerBlock("cursed_stone_bricks",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.5f, 6f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE_BRICKS)
                    .instrument(NoteBlockInstrument.BASEDRUM)));

    public static final Block CURSED_STONE_BRICK_STAIRS = registerBlock("cursed_stone_brick_stairs",
            new StairsBlock(ModBlocks.CURSED_STONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(CURSED_STONE_BRICKS)));

    public static final Block CURSED_STONE_BRICK_SLAB = registerBlock("cursed_stone_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(CURSED_STONE_BRICKS)));

    public static final Block CURSED_STONE_BRICK_WALL = registerBlock("cursed_stone_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(CURSED_STONE_BRICKS)));

    public static final Block CURSED_STONE_BRICK_PRESSURE_PLATE = registerBlock("cursed_stone_brick_pressure_plate",
            new PressurePlateBlock(BlockSetType.STONE, AbstractBlock.Settings.copy(CURSED_STONE_BRICKS)));


    public static final Block CURSED_STONE_BRICK_PILLAR = registerBlock("cursed_stone_brick_pillar",
            new PillarBlock(AbstractBlock.Settings.copy(CURSED_STONE_BRICKS)
                    .luminance(state -> 5)));

    public static final Block CHISELED_CURSED_STONE_BRICKS = registerBlock("chiseled_cursed_stone_bricks",
            new Block(AbstractBlock.Settings.copy(CURSED_STONE_BRICKS)
                    .luminance(state -> 5)));


    public static final Block SMOOTH_CURSED_STONE = registerBlock("smooth_cursed_stone",
            new Block(AbstractBlock.Settings.copy(CURSED_STONE_BRICKS)
                    .strength(4f, 6f)
                    .sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block SMOOTH_CURSED_STONE_STAIRS = registerBlock("smooth_cursed_stone_stairs",
            new StairsBlock(ModBlocks.SMOOTH_CURSED_STONE.getDefaultState(), AbstractBlock.Settings.copy(SMOOTH_CURSED_STONE)));

    public static final Block SMOOTH_CURSED_STONE_SLAB = registerBlock("smooth_cursed_stone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(SMOOTH_CURSED_STONE)));

    public static final Block SMOOTH_CURSED_STONE_PRESSURE_PLATE = registerBlock("smooth_cursed_stone_pressure_plate",
            new PressurePlateBlock(BlockSetType.STONE, AbstractBlock.Settings.copy(SMOOTH_CURSED_STONE)));


    public static final CursedTrialSpawnerBlock CURSED_TRIAL_SPAWNER = (CursedTrialSpawnerBlock) registerBlock("cursed_trial_spawner",
            new CursedTrialSpawnerBlock(AbstractBlock.Settings.copy(Blocks.TRIAL_SPAWNER)));

    public static final CursedVaultBlock CURSED_VAULT = (CursedVaultBlock) registerBlock("cursed_vault",
            new CursedVaultBlock(AbstractBlock.Settings.copy(Blocks.VAULT)));

    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_EMERALD_ORE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CursedRelics.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CursedRelics.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        CursedRelics.LOGGER.info("Registering Mod Blocks for " + CursedRelics.MOD_ID);
    }
}
