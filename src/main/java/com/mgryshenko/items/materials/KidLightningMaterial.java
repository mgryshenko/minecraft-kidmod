package com.mgryshenko.items.materials;

import com.mgryshenko.items.KidItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class KidLightningMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 455;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1.5F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(KidItems.STINKY_ITEM);
    }
}
