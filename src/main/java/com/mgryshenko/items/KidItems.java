package com.mgryshenko.items;

import net.minecraft.block.Block;
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
        register(new Identifier(NAMESPACE, path), item);
    }

    public static void register(Identifier identifier, Item item) {
        Registry.register(Registries.ITEM, identifier, item);
    }

    public static void register(Identifier identifier, Block block) {
        register(identifier, new KidBlockItem(block, new Item.Settings(), identifier.getPath()));
    }
}
