package com.mgryshenko.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KidPotionItem extends PotionItem {

    private final String id;

    public KidPotionItem(Settings settings, String id) {
        super(settings);
        this.id = id;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable(getTooltipId()).formatted(Formatting.GOLD));
    }

    private String getTooltipId() {
        return "potion.kidmod." + id + ".tooltip";
    }
}
