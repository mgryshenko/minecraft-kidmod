package com.mgryshenko.blocks;

import com.mgryshenko.items.KidItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.PillarBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;
import static net.minecraft.block.Blocks.DIRT;
import static net.minecraft.block.Blocks.OAK_LOG;

public class KidBlocks {

    public static final Block DEMO_BLOCK = new Block(AbstractBlock.Settings
            .copy(DIRT)
            .sounds(BlockSoundGroup.GRASS)
    );
    public static final Block DEMO_PILLAR_BLOCK = new PillarBlock(AbstractBlock.Settings
            .copy(OAK_LOG)
            .sounds(BlockSoundGroup.WOOD)
    );
    public static final Block DEMO_LAMP_BLOCK = new KidLampBlock(AbstractBlock.Settings
            .create()
            .sounds(BlockSoundGroup.LANTERN)
            .luminance(KidLampBlock::getLuminance)
    );

    public static void registerAll() {
        register(DEMO_BLOCK, "demo_block");
        register(DEMO_PILLAR_BLOCK, "demo_pillar_block");
        register(DEMO_LAMP_BLOCK, "demo_lamp_block");
    }

    public static void register(Block block, String path) {
        // Register the block and its item.
        Identifier id = new Identifier(NAMESPACE, path);

        Registry.register(Registries.BLOCK, id, block);
        KidItems.register(id, block);
    }

}
