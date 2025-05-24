package net.person552.cursedrelics.entity.custom;

import com.mojang.logging.LogUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrialSpawnerBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.Spawner;
import net.minecraft.block.entity.TrialSpawnerBlockEntity;
import net.minecraft.block.enums.TrialSpawnerState;
import net.minecraft.block.spawner.EntityDetector;
import net.minecraft.block.spawner.TrialSpawnerLogic;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.entity.ModBlockEntities;
import org.slf4j.Logger;

public class CursedTrialSpawnerBlockEntity extends BlockEntity implements Spawner, TrialSpawnerLogic.TrialSpawner{
    private static final Logger LOGGER = CursedRelics.LOGGER;
    private TrialSpawnerLogic spawner;

    public CursedTrialSpawnerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CURSED_TRIAL_SPAWNER_BE, pos, state);
        EntityDetector entityDetector = EntityDetector.SURVIVAL_PLAYERS;
        EntityDetector.Selector selector = EntityDetector.Selector.IN_WORLD;
        this.spawner = new TrialSpawnerLogic(this, entityDetector, selector);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        if (nbt.contains("normal_config")) {
            NbtCompound nbtCompound = nbt.getCompound("normal_config").copy();
            nbt.put("ominous_config", nbtCompound.copyFrom(nbt.getCompound("ominous_config")));
        }

        this.spawner.codec().parse(NbtOps.INSTANCE, nbt).resultOrPartial(LOGGER::error).ifPresent(spawner -> this.spawner = spawner);
        if (this.world != null) {
            this.updateListeners();
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        this.spawner
                .codec()
                .encodeStart(NbtOps.INSTANCE, this.spawner)
                .ifSuccess(nbtx -> nbt.copyFrom((NbtCompound)nbtx))
                .ifError(error -> LOGGER.warn("Failed to encode TrialSpawner {}", error.message()));
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return this.spawner.getData().getSpawnDataNbt(this.getCachedState().get(TrialSpawnerBlock.TRIAL_SPAWNER_STATE));
    }

    @Override
    public boolean copyItemDataRequiresOperator() {
        return true;
    }

    @Override
    public void setEntityType(EntityType<?> type, Random random) {
        this.spawner.getData().setEntityType(this.spawner, random, type);
        this.markDirty();
    }

    public TrialSpawnerLogic getSpawner() {
        return this.spawner;
    }

    @Override
    public TrialSpawnerState getSpawnerState() {
        return !this.getCachedState().contains(Properties.TRIAL_SPAWNER_STATE)
                ? TrialSpawnerState.INACTIVE
                : this.getCachedState().get(Properties.TRIAL_SPAWNER_STATE);
    }

    @Override
    public void setSpawnerState(World world, TrialSpawnerState spawnerState) {
        this.markDirty();
        world.setBlockState(this.pos, this.getCachedState().with(Properties.TRIAL_SPAWNER_STATE, spawnerState));
    }

    @Override
    public void updateListeners() {
        this.markDirty();
        if (this.world != null) {
            this.world.updateListeners(this.pos, this.getCachedState(), this.getCachedState(), Block.NOTIFY_ALL);
        }
    }
}
