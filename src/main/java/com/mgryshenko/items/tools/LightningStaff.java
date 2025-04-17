package com.mgryshenko.items.tools;

import com.mgryshenko.items.materials.KidMaterials;
import com.mgryshenko.utils.Tooltips;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class LightningStaff extends SwordItem {

    public LightningStaff() {
        this(KidMaterials.LIGHTNING_MATERIAL,
                2,
                0.5F,
                new FabricItemSettings()
        );
    }

    public LightningStaff(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
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
        tooltip.add(Tooltips.itemTooltip("lightning_staff"));
    }

    private void playUseSound(PlayerEntity user) {
        user.playSound(SoundEvents.BLOCK_SLIME_BLOCK_HIT, 1.0F, 1.0F);
    }
}
