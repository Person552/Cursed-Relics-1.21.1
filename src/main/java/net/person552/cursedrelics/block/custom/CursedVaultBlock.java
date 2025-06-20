package net.person552.cursedrelics.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.VaultBlockEntity;
import net.minecraft.block.enums.VaultState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.person552.cursedrelics.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class CursedVaultBlock extends BlockWithEntity {
    public static final MapCodec<VaultBlock> CODEC = createCodec(VaultBlock::new);
    public static final Property<VaultState> VAULT_STATE = Properties.VAULT_STATE;
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty OMINOUS = Properties.OMINOUS;

    @Override
    public MapCodec<VaultBlock> getCodec() {
        return CODEC;
    }

    public CursedVaultBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(VAULT_STATE, VaultState.INACTIVE).with(OMINOUS, false));
    }

    @Override
    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isEmpty() || state.get(VAULT_STATE) != VaultState.ACTIVE) {
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else if (world instanceof ServerWorld serverWorld) {
            if (serverWorld.getBlockEntity(pos) instanceof VaultBlockEntity vaultBlockEntity) {
                VaultBlockEntity.Server.tryUnlock(
                        serverWorld, pos, state, vaultBlockEntity.getConfig(), vaultBlockEntity.getServerData(), vaultBlockEntity.getSharedData(), player, stack
                );
                return ItemActionResult.SUCCESS;
            } else {
                return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
        } else {
            return ItemActionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new VaultBlockEntity(pos, state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, VAULT_STATE, OMINOUS);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world instanceof ServerWorld serverWorld
                ? validateTicker(
                type,
                BlockEntityType.VAULT,
                (worldx, pos, statex, blockEntity) -> VaultBlockEntity.Server.tick(
                        serverWorld, pos, statex, blockEntity.getConfig(), blockEntity.getServerData(), blockEntity.getSharedData()
                )
        )
                : validateTicker(
                type,
                BlockEntityType.VAULT,
                (worldx, pos, statex, blockEntity) -> VaultBlockEntity.Client.tick(worldx, pos, statex, blockEntity.getClientData(), blockEntity.getSharedData())
        );
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
