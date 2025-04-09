package net.person552.cursedrelics.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.person552.cursedrelics.block.ModBlocks;
import net.person552.cursedrelics.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_WALL, ModBlocks.CURSED_STONE_BRICKS);
        createStairsRecipe(ModBlocks.CURSED_STONE_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.CURSED_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.CURSED_STONE_BRICKS), conditionsFromItem(ModBlocks.CURSED_STONE_BRICKS))
                .offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_SLAB, ModBlocks.CURSED_STONE_BRICKS);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_SLAB, ModBlocks.CURSED_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_STAIRS, ModBlocks.CURSED_STONE_BRICKS, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_WALL, ModBlocks.CURSED_STONE_BRICKS, 1);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_CURSED_STONE_BRICKS, ModBlocks.CURSED_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_PILLAR, ModBlocks.CURSED_STONE_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_PILLAR, 2)
                .pattern("#")
                .pattern("#")
                .input('#', ModBlocks.CURSED_STONE_BRICKS)
                .criterion(hasItem(ModBlocks.CURSED_STONE_BRICKS), conditionsFromItem(ModBlocks.CURSED_STONE_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_CURSED_STONE_BRICKS, 1)
                .pattern("#")
                .pattern("#")
                .input('#', ModBlocks.CURSED_STONE_BRICK_SLAB)
                .criterion(hasItem(ModBlocks.CURSED_STONE_BRICKS), conditionsFromItem(ModBlocks.CURSED_STONE_BRICKS))
                .offerTo(exporter);
    }
}
