package net.person552.cursedrelics.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class CursedCollapseEffect extends StatusEffect {
    public CursedCollapseEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            ServerWorld world = (ServerWorld) entity.getWorld();
            world.spawnParticles(ParticleTypes.EXPLOSION, entity.getX(), entity.getY(), entity.getZ(), 1, 0.0, 0.0, 0.0, 1.0);
            world.playSoundFromEntity(null, entity, SoundEvents.BLOCK_DECORATED_POT_SHATTER, SoundCategory.NEUTRAL, 3f, 1f);
        }

        entity.damage(entity.getDamageSources().magic(), (amplifier * 4f)+4f);

        entity.removeStatusEffect(ModEffects.CURSED_COLLAPSE);
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) { return duration <=5; }
}

