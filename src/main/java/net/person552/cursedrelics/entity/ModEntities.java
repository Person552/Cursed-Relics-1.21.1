package net.person552.cursedrelics.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.entity.custom.KataremiProjectileEntity;

public class ModEntities {
    public static final EntityType<KataremiProjectileEntity> KATAREMI_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CursedRelics.MOD_ID, "kataremi_projectile"),
            EntityType.Builder.<KataremiProjectileEntity>create(KataremiProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f).build());


    public static void registerModEntities() {
        CursedRelics.LOGGER.info("Registering Mod Entities for " + CursedRelics.MOD_ID);
    }
}
