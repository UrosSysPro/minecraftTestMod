package org.systempro.testmod.items;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpongeFractal extends Item {

    public SpongeFractal(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        BlockPos blockPos= user.getBlockPos();

        int stepen=4;

        int size=1;
        for(int i=0;i<stepen;i++)size*=3;
        for(int k=0;k<size;k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    BlockPos pos = blockPos.add(i-size/2, k-size/2, j-size/2);
                    int s = size;
                    s /= 3;
                    boolean isAir = false;
                    while (s > 0) {
                        int ostatak1=0;
                        if((i / s) % 3 == 1)ostatak1++;
                        if((j / s) % 3 == 1)ostatak1++;
                        if((k / s) % 3 == 1)ostatak1++;
                        if (ostatak1>=2) {
                            isAir = true;
                            break;
                        }
                        s /= 3;
                    }
                    if (isAir) {
                        world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    } else {
                        world.setBlockState(pos, Blocks.STONE.getDefaultState());
                    }
                }
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
