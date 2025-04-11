package net.person552.cursedrelics.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;

public class ModParticles {
     public static final SimpleParticleType HOLY_FIRE_PARTICLE =
             registerParticle("holy_fire_particle", FabricParticleTypes.simple(false));

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(CursedRelics.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        CursedRelics.LOGGER.info("Registering Particles for " + CursedRelics.MOD_ID);
    }
}
