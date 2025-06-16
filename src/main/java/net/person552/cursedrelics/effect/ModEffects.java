package net.person552.cursedrelics.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> HOLY_FIRE = registerStatusEffect("holy_fire",
            new HolyFireEffect(StatusEffectCategory.HARMFUL,  0xffea96));

    public static final RegistryEntry<StatusEffect> CURSED_COLLAPSE = registerStatusEffect("cursed_collapse",
            new CursedCollapseEffect(StatusEffectCategory.HARMFUL,  0x262217));

    public static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(CursedRelics.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        CursedRelics.LOGGER.info("Registering Mod Effects for " + CursedRelics.MOD_ID);
    }
}
