package net.person552.cursedrelics;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.person552.cursedrelics.particle.HolyFireParticle;
import net.person552.cursedrelics.particle.ModParticles;

public class CursedRelicsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.HOLY_FIRE_PARTICLE, HolyFireParticle.Factory::new);
    }
}
