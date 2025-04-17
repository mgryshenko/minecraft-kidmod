package com.mgryshenko.items;

import com.mgryshenko.items.potions.KidPotions;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;
import static com.mgryshenko.blocks.KidBlocks.DEMO_BLOCK;
import static com.mgryshenko.blocks.KidBlocks.DEMO_LAMP_BLOCK;
import static com.mgryshenko.blocks.KidBlocks.DEMO_PILLAR_BLOCK;
import static com.mgryshenko.items.KidItems.LIGHTNING_STAFF;
import static com.mgryshenko.items.KidItems.STINKY_ITEM;

public class KidItemGroups {

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            new Identifier(NAMESPACE)
    );

    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(STINKY_ITEM))
            .displayName(Text.translatable("item.kidmod.item_group.name"))
            .entries((displayContext, entries) -> {
                    entries.add(DEMO_BLOCK.asItem());
                    entries.add(DEMO_PILLAR_BLOCK.asItem());
                    entries.add(DEMO_LAMP_BLOCK.asItem());
                    entries.add(STINKY_ITEM);
                    entries.add(LIGHTNING_STAFF);
                    entries.add(potionItemStack(KidPotions.STINKY_POTION));
            })
            .build();

    public static void registerAll() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
    }

    private static ItemStack potionItemStack(Potion potion) {
        Identifier potionId = Registries.POTION.getId(potion);
        Item potionItem = Registries.ITEM.get(potionId);

        return PotionUtil.setPotion(new ItemStack(potionItem), potion);
    }
}
