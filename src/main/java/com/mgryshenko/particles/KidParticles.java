package com.mgryshenko.particles;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;

public class KidParticles {

    // This DefaultParticleType gets called when you want to use your particle in code.
    public static final DefaultParticleType FLY_PARTICLE = FabricParticleTypes.simple();

    public static void registerAll() {
        register("fly_particle", FLY_PARTICLE);
    }

    private static void register(String path, DefaultParticleType particleType) {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(NAMESPACE, path), particleType);
    }
}
