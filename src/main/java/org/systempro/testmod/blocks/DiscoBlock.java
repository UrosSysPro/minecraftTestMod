package org.systempro.testmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DiscoBlock extends Block implements BlockEntityProvider {

    public static final IntProperty LIGHT=IntProperty.of("light",0,3);
    public static final BooleanProperty ENTITY_ON_TOP=BooleanProperty.of("entity_on_top");

    public DiscoBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(LIGHT,0).with(ENTITY_ON_TOP,false));
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        int value=state.get(LIGHT);
        value++;
        if(value>3)value=3;
        world.setBlockState(pos,state.with(LIGHT,value).with(ENTITY_ON_TOP,true));
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIGHT).add(ENTITY_ON_TOP);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return DiscoBlockEntity::tick;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DiscoBlockEntity(pos,state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
