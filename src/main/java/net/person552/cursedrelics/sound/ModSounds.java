package net.person552.cursedrelics.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;

public class ModSounds {
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(CursedRelics.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {
        CursedRelics.LOGGER.info("Registering Mod Sounds for " + CursedRelics.MOD_ID);
    }
}
