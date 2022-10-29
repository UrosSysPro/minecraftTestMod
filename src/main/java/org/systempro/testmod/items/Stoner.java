package org.systempro.testmod.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Stoner extends Item {

    public Stoner(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos=context.getBlockPos();
        PlayerEntity player=context.getPlayer();
        World world=context.getWorld();
        BlockState blockState=world.getBlockState(pos);
        if(!world.isClient&&player!=null){
            world.setBlockState(pos, Blocks.STONE.getDefaultState());
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("ovo je kul ajtem koji sve pretvara u kamen"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
