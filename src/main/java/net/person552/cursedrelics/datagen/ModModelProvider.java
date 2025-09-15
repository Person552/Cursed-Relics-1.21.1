package net.person552.cursedrelics.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.person552.cursedrelics.block.ModBlocks;
import net.person552.cursedrelics.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        BlockStateModelGenerator.BlockTexturePool cursedStoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CURSED_STONE_BRICKS);
        cursedStoneBricksPool.stairs(ModBlocks.CURSED_STONE_BRICK_STAIRS);
        cursedStoneBricksPool.slab(ModBlocks.CURSED_STONE_BRICK_SLAB);
        cursedStoneBricksPool.wall(ModBlocks.CURSED_STONE_BRICK_WALL);
        cursedStoneBricksPool.pressurePlate(ModBlocks.CURSED_STONE_BRICK_PRESSURE_PLATE);

        BlockStateModelGenerator.BlockTexturePool smoothCursedStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_CURSED_STONE);
        smoothCursedStonePool.stairs(ModBlocks.SMOOTH_CURSED_STONE_STAIRS);
        smoothCursedStonePool.slab(ModBlocks.SMOOTH_CURSED_STONE_SLAB);
        smoothCursedStonePool.pressurePlate(ModBlocks.SMOOTH_CURSED_STONE_PRESSURE_PLATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CURSED_RUNE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURSED_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURSED_HANDLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CURSED_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);

        itemModelGenerator.register(ModItems.CURSED_KEY, Models.GENERATED);
    }

}

