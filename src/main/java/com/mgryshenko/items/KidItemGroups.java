package com.mgryshenko.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;
import static com.mgryshenko.blocks.KidBlocks.*;
import static com.mgryshenko.items.KidItems.DEMO_ITEM;

public class KidItemGroups {

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            new Identifier(NAMESPACE)
    );
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(DEMO_ITEM))
            .displayName(Text.translatable("item.kidmod.item_group.name"))
            .entries((displayContext, entries) -> {
                    entries.add(DEMO_ITEM);
                    entries.add(DEMO_BLOCK.asItem());
                    entries.add(DEMO_PILLAR_BLOCK.asItem());
                    entries.add(DEMO_LAMP_BLOCK.asItem());
            })
            .build();

    public static void registerAll() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
    }
}
