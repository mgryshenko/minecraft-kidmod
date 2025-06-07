package com.mgryshenko;

import com.mgryshenko.particles.KidParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.EndRodParticle;

public class KidmodClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		registerParticles();
	}

	private void registerParticles() {
		// For this example, we will use the end rod particle behaviour.
		ParticleFactoryRegistry.getInstance().register(KidParticles.FLY_PARTICLE, EndRodParticle.Factory::new);
	}
}