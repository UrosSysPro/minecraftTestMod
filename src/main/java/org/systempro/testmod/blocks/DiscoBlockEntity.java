package org.systempro.testmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class DiscoBlockEntity extends BlockEntity {
    public DiscoBlockEntity(BlockPos pos, BlockState state) {
        super(BlockInitializer.DISCO_BLOCK_ENTITY, pos, state);
    }

    public static <T extends BlockEntity> void tick(World world, BlockPos pos, BlockState state, T discoBlockEntity) {

        boolean entity_on_top=state.get(DiscoBlock.ENTITY_ON_TOP);
        BlockState state1=BlockInitializer.DISCO_BLOCK.getDefaultState();
        if(entity_on_top){
            state1.with(DiscoBlock.ENTITY_ON_TOP,false);
        }else{
            int light=state.get(DiscoBlock.LIGHT);
            light--;
            if(light<0)light=0;
            state1.with(DiscoBlock.LIGHT,light);
        }
        world.setBlockState(pos,state1);
        world.updateListeners(pos,state,state1, Block.NOTIFY_LISTENERS);
    }


    @Override
    protected void writeNbt(NbtCompound nbt) {

        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {

        super.readNbt(nbt);
    }


    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
