package net.person552.cursedrelics.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;

import java.util.Objects;

public class HolyFireEffect extends StatusEffect {
    public HolyFireEffect(StatusEffectCategory category, int color) {
        super(category, color, ParticleTypes.LAVA);
    }


    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(entity.getDamageSources().onFire(), amplifier * 3f);

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 25 == 0;
    }
}
