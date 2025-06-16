package net.person552.cursedrelics.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.entry.RegistryEntry;
import net.person552.cursedrelics.particle.ModParticles;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.Map;

public class CursedCollapseEffect extends StatusEffect {
    public CursedCollapseEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(entity.getDamageSources().magic(), (amplifier * 4f)+4f);

        entity.removeStatusEffect(ModEffects.CURSED_COLLAPSE);
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) { return duration <=5; }
}

