package com.mgryshenko.items.potions;

import com.mgryshenko.effects.KidEffects;
import com.mgryshenko.items.KidItems;
import com.mgryshenko.mixin.BrewingRecipeRegistryInvoker;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;

public class KidPotions {

    public static final Potion STINKY_POTION =new Potion(new StatusEffectInstance(
            KidEffects.STINKY_EFFECT,
            3600,
            0
    ));

    public static void registerAll() {
        register("stinky_potion", STINKY_POTION, KidItems.STINKY_ITEM);
    }

    public static void register(String path, Potion potion, Item recipeItem) {
        Identifier id = new Identifier(NAMESPACE, path);

        Registry.register(Registries.POTION, id, potion);
        KidItems.registerPotionItem(id);

        // Mixin invoker to avoid using Fabric API
        BrewingRecipeRegistryInvoker.invokeRegisterPotionRecipe(Potions.WATER, recipeItem, potion);
    }
}
