package com.mgryshenko.effects;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;

public class KidEffects {

    public static final StinkyEffect STINKY_EFFECT = new StinkyEffect();

    public static void registerAll() {
        register("stinky_effect", STINKY_EFFECT);
    }

    public static void register(String path, StinkyEffect effect) {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(NAMESPACE, path), effect);
    }
}
