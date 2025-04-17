package com.mgryshenko.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KidLampBlock extends Block {

    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    public KidLampBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(ACTIVATED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        // Skip if the player isn't allowed to modify the world.
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.PASS;
        }

        // Get the current value of the "activated" property
        boolean activated = state.get(ACTIVATED);

        // Flip the value of activated and save the new block state.
        world.setBlockState(pos, state.with(ACTIVATED, !activated));

        // Play a click sound to emphasise the interaction.
        world.playSound(player, pos, SoundEvents.BLOCK_COMPARATOR_CLICK, SoundCategory.BLOCKS, 1.0F, 1.0F);

        return ActionResult.SUCCESS;
    }

    public static int getLuminance(BlockState state) {
        // Get the value of the "activated" property.
        boolean activated = state.get(ACTIVATED);

        // Return a light level if activated = true
        return activated ? 15 : 0;
    }
}
