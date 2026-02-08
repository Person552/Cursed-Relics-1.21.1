package net.person552.cursedrelics.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.person552.cursedrelics.entity.ModBlockEntities;
import net.person552.cursedrelics.entity.custom.CursedTrialSpawnerBlockEntity;
import org.jetbrains.annotations.Nullable;

public class CursedTrialSpawnerBlock extends TrialSpawnerBlock {
    public CursedTrialSpawnerBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CursedTrialSpawnerBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world instanceof ServerWorld serverWorld
                ? validateTicker(
                type,
                ModBlockEntities.CURSED_TRIAL_SPAWNER_BE,
                (worldx, pos, statex, blockEntity) -> blockEntity.getSpawner().tickServer(serverWorld, pos, (Boolean)statex.getOrEmpty(Properties.OMINOUS).orElse(false))
        )
                : validateTicker(
                type,
                ModBlockEntities.CURSED_TRIAL_SPAWNER_BE,
                (worldx, pos, statex, blockEntity) -> blockEntity.getSpawner().tickClient(worldx, pos, (Boolean)statex.getOrEmpty(Properties.OMINOUS).orElse(false))
        );
    }
}
