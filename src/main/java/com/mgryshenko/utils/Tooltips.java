package com.mgryshenko.utils;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import static com.mgryshenko.Kidmod.NAMESPACE;

public class Tooltips {

    private static final String TOOLTIP_TEMPLATE = "%s." + NAMESPACE + ".%s.tooltip";
    private static final String ITEM_PREFIX = "item";
    private static final String BLOCK_PREFIX = "block";

    public static Text itemTooltip(String id) {
        return format(Text.translatable(TOOLTIP_TEMPLATE.formatted(ITEM_PREFIX, id)));
    }

    public static Text blockTooltip(String id) {
        return format(Text.translatable(TOOLTIP_TEMPLATE.formatted(BLOCK_PREFIX, id)));
    }

    private static Text format(MutableText text) {
        return text.formatted(Formatting.GOLD);
    }
}
