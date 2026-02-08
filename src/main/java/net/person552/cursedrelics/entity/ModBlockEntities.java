package net.person552.cursedrelics.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.block.ModBlocks;
import net.person552.cursedrelics.entity.custom.CursedTrialSpawnerBlockEntity;
import net.person552.cursedrelics.entity.custom.CursedVaultBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<CursedTrialSpawnerBlockEntity> CURSED_TRIAL_SPAWNER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(CursedRelics.MOD_ID, "cursed_trial_spawner_be"),
                    BlockEntityType.Builder.create(CursedTrialSpawnerBlockEntity::new, ModBlocks.CURSED_TRIAL_SPAWNER).build(null));

    public static final BlockEntityType<CursedVaultBlockEntity> CURSED_VAULT_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(CursedRelics.MOD_ID, "cursed_vault_be"),
                    BlockEntityType.Builder.create(CursedVaultBlockEntity::new, ModBlocks.CURSED_VAULT).build(null));

    public static void registerBlockEntities() {
        CursedRelics.LOGGER.info("Registering Mod Block Entities for " + CursedRelics.MOD_ID);
    }
}
