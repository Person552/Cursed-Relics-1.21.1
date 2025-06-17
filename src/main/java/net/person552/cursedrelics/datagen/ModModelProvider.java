package net.person552.cursedrelics.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.person552.cursedrelics.block.ModBlocks;
import net.person552.cursedrelics.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool cursedStoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CURSED_STONE_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SMOOTH_CURSED_STONE);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.CURSED_STONE_BRICK_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);

        cursedStoneBricksPool.stairs(ModBlocks.CURSED_STONE_BRICK_STAIRS);
        cursedStoneBricksPool.slab(ModBlocks.CURSED_STONE_BRICK_SLAB);
        cursedStoneBricksPool.wall(ModBlocks.CURSED_STONE_BRICK_WALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CURSED_RUNE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURSED_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURSED_HANDLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CURSED_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.CURSED_KEY, Models.GENERATED);
    }


}

