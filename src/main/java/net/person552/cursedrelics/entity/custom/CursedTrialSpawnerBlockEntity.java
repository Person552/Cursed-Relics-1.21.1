package net.person552.cursedrelics.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.TrialSpawnerBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.person552.cursedrelics.entity.ModBlockEntities;


public class CursedTrialSpawnerBlockEntity extends TrialSpawnerBlockEntity {

    public CursedTrialSpawnerBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.CURSED_TRIAL_SPAWNER_BE;
    }

    @Override
    public boolean supports(BlockState state) {
        return ModBlockEntities.CURSED_TRIAL_SPAWNER_BE.supports(state);
    }
}

