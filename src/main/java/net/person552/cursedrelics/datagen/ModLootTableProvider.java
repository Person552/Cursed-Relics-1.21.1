package net.person552.cursedrelics.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.person552.cursedrelics.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHISELED_CURSED_STONE_BRICKS);
        addDrop(ModBlocks.CURSED_STONE_BRICKS);
        addDrop(ModBlocks.CURSED_STONE_BRICK_PILLAR);
        addDrop(ModBlocks.CURSED_STONE_BRICK_STAIRS);
        addDrop(ModBlocks.CURSED_STONE_BRICK_WALL);
        addDrop(ModBlocks.CURSED_STONE_BRICK_SLAB, slabDrops(ModBlocks.CURSED_STONE_BRICK_SLAB));
    }
}
