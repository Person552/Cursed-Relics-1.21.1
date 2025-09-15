package net.person552.cursedrelics.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.person552.cursedrelics.block.ModBlocks;
import net.person552.cursedrelics.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //Cursed stone bricks set
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_WALL, ModBlocks.CURSED_STONE_BRICKS);
        createStairsRecipe(ModBlocks.CURSED_STONE_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.CURSED_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.CURSED_STONE_BRICKS), conditionsFromItem(ModBlocks.CURSED_STONE_BRICKS))
                .offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_SLAB, ModBlocks.CURSED_STONE_BRICKS);
        offerPressurePlateRecipe(exporter, ModBlocks.CURSED_STONE_BRICK_PRESSURE_PLATE, ModBlocks.CURSED_STONE_BRICKS);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_SLAB, ModBlocks.CURSED_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_STAIRS, ModBlocks.CURSED_STONE_BRICKS, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_BRICK_WALL, ModBlocks.CURSED_STONE_BRICKS, 1);

        //Smooth cursed stone set
        createStairsRecipe(ModBlocks.SMOOTH_CURSED_STONE_STAIRS, Ingredient.ofItems(ModBlocks.SMOOTH_CURSED_STONE))
                .criterion(hasItem(ModBlocks.SMOOTH_CURSED_STONE), conditionsFromItem(ModBlocks.SMOOTH_CURSED_STONE))
                .offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_CURSED_STONE_SLAB, ModBlocks.SMOOTH_CURSED_STONE);
        offerPressurePlateRecipe(exporter, ModBlocks.SMOOTH_CURSED_STONE_PRESSURE_PLATE, ModBlocks.SMOOTH_CURSED_STONE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_CURSED_STONE_SLAB, ModBlocks.SMOOTH_CURSED_STONE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_CURSED_STONE_STAIRS, ModBlocks.SMOOTH_CURSED_STONE, 1);

        //Other cursed stone stuffs
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

        //Kataremi & Sanctemi
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MAIN_HAND_DAGGER)
                .input(ModItems.INERT_KATAREMI)
                .input(ModItems.INERT_SANCTEMI)
                .criterion(hasItem(ModItems.INERT_KATAREMI), conditionsFromItem(ModItems.INERT_KATAREMI))
                .criterion(hasItem(ModItems.INERT_SANCTEMI), conditionsFromItem(ModItems.INERT_SANCTEMI))
                .offerTo(exporter);

        //Sapphire smelting
        List<ItemConvertible> SAPPHIRE_SMELTABLES = List.of(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        offerSmelting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, 1.0f, 200, "sapphire");
        offerBlasting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, 1.0f, 100, "sapphire");
    }
}
