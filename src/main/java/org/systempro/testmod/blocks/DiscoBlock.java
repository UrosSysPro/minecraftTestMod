package org.systempro.testmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DiscoBlock extends Block {

    public static final IntProperty LIGHT=IntProperty.of("light",0,15);

    public DiscoBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(LIGHT,0));
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        int value=state.get(LIGHT);
        value++;
        if(value>15)value=15;
        if((entity instanceof PlayerEntity)&&(!world.isClient)){
            System.out.println(value);
            entity.sendMessage(Text.literal("light state: "+value));
        }
        world.setBlockState(pos,state.with(LIGHT,value),NOTIFY_ALL);
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIGHT);
    }
}
