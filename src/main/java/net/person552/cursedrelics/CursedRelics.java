package net.person552.cursedrelics;

import net.fabricmc.api.ModInitializer;

import net.person552.cursedrelics.block.ModBlocks;
import net.person552.cursedrelics.component.ModDataComponentTypes;
import net.person552.cursedrelics.effect.ModEffects;
import net.person552.cursedrelics.item.ModItemGroups;
import net.person552.cursedrelics.item.ModItems;
import net.person552.cursedrelics.particle.ModParticles;
import net.person552.cursedrelics.sound.ModSounds;
import net.person552.cursedrelics.util.ModModelPredicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CursedRelics implements ModInitializer {
	public static final String MOD_ID = "cursedrelics";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerEffects();
		ModParticles.registerParticles();
		ModSounds.registerModSounds();
		ModDataComponentTypes.registerDataComponentTypes();
		ModModelPredicates.registerModelPredicates();
	}
}