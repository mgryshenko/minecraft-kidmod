package com.mgryshenko.items;

import com.mgryshenko.utils.Tooltips;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KidBlockItem extends BlockItem {

    private final String id;

    public KidBlockItem(Block block, Settings settings, String id) {
        super(block, settings);
        this.id = id;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Tooltips.blockTooltip(id));
    }
}
