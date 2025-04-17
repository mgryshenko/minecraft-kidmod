package com.mgryshenko.items;

import com.mgryshenko.items.food.StinkyItem;
import com.mgryshenko.items.potions.KidPotions;
import com.mgryshenko.items.tools.LightningStaff;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;

public class KidItems {

    public static final Item STINKY_ITEM = new StinkyItem();
    public static final Item LIGHTNING_STAFF = new LightningStaff();

    public static void registerAll() {
        KidPotions.registerAll();
        register("stinky_item", STINKY_ITEM);
        register("lightning_staff", LIGHTNING_STAFF);
    }

    public static void registerBlockItem(Identifier identifier, Block block) {
        register(identifier, new KidBlockItem(block, new Item.Settings(), identifier.getPath()));
    }

    public static void registerPotionItem(Identifier identifier) {
        register(identifier, new KidPotionItem(new Item.Settings(), identifier.getPath()));
    }

    public static void register(String path, Item item) {
        register(new Identifier(NAMESPACE, path), item);
    }

    public static void register(Identifier identifier, Item item) {
        Registry.register(Registries.ITEM, identifier, item);
    }
}
