package com.mgryshenko;

import com.mgryshenko.blocks.KidBlocks;
import com.mgryshenko.effects.KidEffects;
import com.mgryshenko.entities.KidEntities;
import com.mgryshenko.items.KidItemGroups;
import com.mgryshenko.items.KidItems;
import com.mgryshenko.particles.KidParticles;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kidmod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("kidmod");
	public static final String NAMESPACE = "kidmod";


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		KidParticles.registerAll();
		KidBlocks.registerAll();
		KidItems.registerAll();
		KidItemGroups.registerAll();
		KidEffects.registerAll();
		KidEntities.registerAll();
	}
}