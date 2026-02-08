package net.person552.cursedrelics.block.custom;


import net.minecraft.block.BlockState;
import net.minecraft.block.VaultBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.VaultBlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.person552.cursedrelics.entity.ModBlockEntities;
import net.person552.cursedrelics.entity.custom.CursedVaultBlockEntity;
import org.jetbrains.annotations.Nullable;

public class CursedVaultBlock extends VaultBlock {

    public CursedVaultBlock(Settings settings) {
        super(settings);
    }

    @Override
    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CursedVaultBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        BlockEntityTicker var10000;
        if (world instanceof ServerWorld serverWorld) {
            var10000 = validateTicker(type, ModBlockEntities.CURSED_VAULT_BE, (worldx, pos, statex, blockEntity) -> VaultBlockEntity.Server.tick(serverWorld, pos, statex, blockEntity.getConfig(), blockEntity.getServerData(), blockEntity.getSharedData()));
        } else {
            var10000 = validateTicker(type, ModBlockEntities.CURSED_VAULT_BE, (worldx, pos, statex, blockEntity) -> VaultBlockEntity.Client.tick(worldx, pos, statex, blockEntity.getClientData(), blockEntity.getSharedData()));
        }

        return var10000;
    }
}
