package com.mgryshenko.effects;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;

public class KidEffects {

    public static final DemoEffect DEMO_EFFECT = new DemoEffect();

    public static void registerAll() {
        register("demo_effect", DEMO_EFFECT);
    }

    public static void register(String path, DemoEffect effect) {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(NAMESPACE, path), effect);
    }
}
