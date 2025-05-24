package net.person552.cursedrelics.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.block.enums.TrialSpawnerState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.person552.cursedrelics.entity.ModBlockEntities;
import net.person552.cursedrelics.entity.custom.CursedTrialSpawnerBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CursedTrialSpawnerBlock extends BlockWithEntity {
    public static final MapCodec<TrialSpawnerBlock> CODEC = createCodec(TrialSpawnerBlock::new);
    public static final EnumProperty<TrialSpawnerState> TRIAL_SPAWNER_STATE = Properties.TRIAL_SPAWNER_STATE;
    public static final BooleanProperty OMINOUS = Properties.OMINOUS;

    @Override
    public MapCodec<TrialSpawnerBlock> getCodec() {
        return CODEC;
    }

    public CursedTrialSpawnerBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(TRIAL_SPAWNER_STATE, TrialSpawnerState.INACTIVE).with(OMINOUS, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TRIAL_SPAWNER_STATE, OMINOUS);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
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

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        super.appendTooltip(stack, context, tooltip, options);
        Spawner.appendSpawnDataToTooltip(stack, tooltip, "spawn_data");
    }
}
