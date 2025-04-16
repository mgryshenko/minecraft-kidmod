package com.mgryshenko.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class DemoItem extends Item {

    public DemoItem() {
        this(new FabricItemSettings());
    }

    public DemoItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        playUseSound(user);
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity user = context.getPlayer();
        if (Objects.nonNull(user)) {
            playUseSound(user);
        }

        return ActionResult.PASS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        // Ensure we don't spawn the lightning only on the client.
        // This is to prevent desync.
        if (entity.getWorld().isClient) {
            return ActionResult.PASS;
        }
        playUseSound(user);

        BlockPos entityPos = entity.getBlockPos();

        // Spawn the lightning bolt.
        LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, entity.getWorld());
        lightningBolt.setPosition(entityPos.toCenterPos());
        entity.getWorld().spawnEntity(lightningBolt);

        // Nothing has changed to the item stack,
        // so we just return it how it was.
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.kidmod.demo_item.tooltip").formatted(Formatting.GOLD));
    }

    private void playUseSound(PlayerEntity user) {
        user.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, 1.0F, 1.0F);
    }
}
