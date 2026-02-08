package net.person552.cursedrelics.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.VaultBlockEntity;
import net.minecraft.block.spawner.EntityDetector;
import net.minecraft.block.vault.VaultConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTables;
import net.minecraft.util.math.BlockPos;
import net.person552.cursedrelics.entity.ModBlockEntities;
import net.person552.cursedrelics.item.ModItems;

import java.util.Optional;

public class CursedVaultBlockEntity extends VaultBlockEntity {
    public CursedVaultBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
        this.setConfig(new VaultConfig(LootTables.TRIAL_CHAMBERS_REWARD_CHEST,
                (double)4.0F,
                (double)4.5F,
                new ItemStack(ModItems.CURSED_KEY),
                Optional.empty(),
                EntityDetector.NON_SPECTATOR_PLAYERS,
                EntityDetector.Selector.IN_WORLD));
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.CURSED_VAULT_BE;
    }

    @Override
    public boolean supports(BlockState state) {
        return ModBlockEntities.CURSED_VAULT_BE.supports(state);
    }
}