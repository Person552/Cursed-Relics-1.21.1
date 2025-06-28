package net.person552.cursedrelics.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.person552.cursedrelics.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CHISELED_CURSED_STONE_BRICKS)
                .add(ModBlocks.CURSED_STONE_BRICKS)
                .add(ModBlocks.CURSED_STONE_BRICK_PILLAR)
                .add(ModBlocks.SMOOTH_CURSED_STONE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.CURSED_STONE_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.SMOOTH_CURSED_STONE_PRESSURE_PLATE)
                .add(ModBlocks.CURSED_STONE_BRICK_PRESSURE_PLATE);
    }
}
