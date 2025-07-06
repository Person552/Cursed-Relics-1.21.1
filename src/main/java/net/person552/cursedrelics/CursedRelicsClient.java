package net.person552.cursedrelics;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.person552.cursedrelics.block.ModBlocks;
import net.person552.cursedrelics.entity.ModEntities;
import net.person552.cursedrelics.entity.client.KataremiProjectileRenderer;
import net.person552.cursedrelics.particle.HolyFireParticle;
import net.person552.cursedrelics.particle.ModParticles;
import net.person552.cursedrelics.util.ModModelPredicates;

public class CursedRelicsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.HOLY_FIRE_PARTICLE, HolyFireParticle.Factory::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CURSED_TRIAL_SPAWNER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CURSED_VAULT, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();

        EntityRendererRegistry.register(ModEntities.KATAREMI_PROJECTILE, KataremiProjectileRenderer::new);
    }
}
