package org.systempro.testmod.items;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.systempro.testmod.entities.FlyingHammerEntity;

import java.util.List;

public class Hammer extends ToolItem {
    public Hammer(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player=context.getPlayer();
        World world=context.getWorld();
        BlockPos pos=context.getBlockPos();
        if(!world.isClient()&&player!=null){
            player.sendMessage(Text.literal("use on block"));
            player.sendMessage(world.getBlockState(pos).getBlock().getName().copy());
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(!user.world.isClient){
            user.sendMessage(Text.literal("use on entity"));
            user.sendMessage(entity.getName().copy());
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        System.out.println("use");
        return TypedActionResult.success(user.getStackInHand(hand),true);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity&& !attacker.world.isClient){
            attacker.sendMessage(Text.literal("post hit"));
        }
        return true;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 70000;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if(user instanceof PlayerEntity&&!user.world.isClient){
            user.sendMessage(Text.literal("stopped using"));
        }
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Jako kul cekic"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
