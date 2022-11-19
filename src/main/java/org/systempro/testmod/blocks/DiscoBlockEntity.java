package org.systempro.testmod.blocks;

import net.fabricmc.fabric.api.rendering.data.v1.RenderAttachmentBlockEntity;
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

public class DiscoBlockEntity extends BlockEntity implements RenderAttachmentBlockEntity {

    public DiscoBlockEntity(BlockPos pos, BlockState state)
    {
        super(BlockInitializer.DISCO_BLOCK_ENTITY, pos, state);
    }


    public static <T extends BlockEntity> void tick(World world, BlockPos pos, BlockState state, T discoBlockEntity) {
        int value=state.get(DiscoBlock.LIGHT);
        value=(value+1)%16;
        state.with(DiscoBlock.LIGHT,value);
//        world.setBlockState(pos,state,Block.REDRAW_ON_MAIN_THREAD);
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

    @Override
    public @org.jetbrains.annotations.Nullable Object getRenderAttachmentData() {
        return null;
    }
}
