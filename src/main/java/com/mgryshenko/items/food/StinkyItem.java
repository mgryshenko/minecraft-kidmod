package com.mgryshenko.items.food;

import com.mgryshenko.effects.KidEffects;
import com.mgryshenko.utils.Tooltips;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StinkyItem extends Item {

    public StinkyItem() {
        this(new FabricItemSettings().food(new FoodComponent.Builder()
                .alwaysEdible()
                .snack()
                // The duration is in ticks, 20 ticks = 1 second
                .statusEffect(new StatusEffectInstance(KidEffects.STINKY_EFFECT, 6 * 20, 1), 1.0f)
                .build()));
    }

    public StinkyItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Tooltips.itemTooltip("stinky_item"));
    }
}
