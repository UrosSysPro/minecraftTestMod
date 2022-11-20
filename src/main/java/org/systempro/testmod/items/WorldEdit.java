package org.systempro.testmod.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class WorldEdit extends Item {
    public WorldEdit(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient&&hand==Hand.MAIN_HAND) {
            user.getStackInHand(Hand.OFF_HAND);

            float pitch = user.getPitch();
            float yaw = user.getYaw();
            float roll = user.getRoll();

            float f = -MathHelper.sin(yaw * ((float) Math.PI / 180)) * MathHelper.cos(pitch * ((float) Math.PI / 180));
            float g = -MathHelper.sin((pitch + roll) * ((float) Math.PI / 180));
            float h = MathHelper.cos(yaw * ((float) Math.PI / 180)) * MathHelper.cos(pitch * ((float) Math.PI / 180));

            float l=(float)Math.sqrt(f*f+g*g+h*h);
            f/=l;
            g/=l;
            h/=l;

            float x = (float) user.getX();
            float y = (float) user.getY()+1.6f;
            float z = (float) user.getZ();

            for (int i = 0; i < 32; i++) {
                float px=x+i*f;
                float py=y+i*g;
                float pz=z+i*h;
                BlockPos pos = new BlockPos(px,py,pz);
                BlockState state = world.getBlockState(pos);
                if (state.getBlock() != Blocks.AIR) {

                    pos=new BlockPos(px-f,py-g,pz-h);
                    world.setBlockState(pos,Blocks.NETHERRACK.getDefaultState());
                    break;
                }
            }
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
