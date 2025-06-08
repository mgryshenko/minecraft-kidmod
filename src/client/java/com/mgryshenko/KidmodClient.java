package com.mgryshenko;

import com.mgryshenko.entities.KidEntities;
import com.mgryshenko.particles.KidParticles;
import com.mgryshenko.render.CubeEntityModel;
import com.mgryshenko.render.CubeEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.particle.EndRodParticle;

import static com.mgryshenko.render.CubeEntityModel.MODEL_CUBE_LAYER;

public class KidmodClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		registerParticles();
		registerEntities();
	}

	private void registerParticles() {
		// For this example, we will use the end rod particle behaviour.
		ParticleFactoryRegistry.getInstance().register(KidParticles.FLY_PARTICLE, EndRodParticle.Factory::new);
	}

	private void registerEntities() {
		EntityRendererRegistry.register(KidEntities.CUBE, CubeEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, CubeEntityModel::getTexturedModelData);
	}
}