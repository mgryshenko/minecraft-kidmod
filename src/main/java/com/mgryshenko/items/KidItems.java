package com.mgryshenko.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;

public class KidItems {

    public static final Item DEMO_ITEM = new DemoItem();

    public static void registerAll() {
        register("demo_item", DEMO_ITEM);
    }

    public static void register(String path, Item item) {
		Registry.register(Registries.ITEM, new Identifier(NAMESPACE, path), item);
    }
}
