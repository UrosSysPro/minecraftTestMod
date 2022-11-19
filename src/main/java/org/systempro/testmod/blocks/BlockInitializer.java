package org.systempro.testmod.blocks;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.systempro.testmod.items.ItemInitializer;

public class BlockInitializer {
    public static Block COOL_BLOCK,DISCO_BLOCK;
    public static BlockItem COOL_BLOCK_ITEM,DISCO_BLOCK_ITEM;
    public static BlockEntityType<DiscoBlockEntity> DISCO_BLOCK_ENTITY;
    public static int[] colors={
        0x000f10,
        0x001f1e,
        0x002f2e,
        0x003f3e,

        0x004f4e,
        0x005f5e,
        0x006f6e,
        0x007f7e,

        0x008f8e,
        0x009f19,
        0x00af1a,
        0x00bf1b,

        0x00cf1c,
        0x00df1d,
        0x00ef1e,
        0x00ff1f,
    };

    public static void init(){
        COOL_BLOCK=new Block(FabricBlockSettings.of(Material.METAL).strength(4).jumpVelocityMultiplier(2).nonOpaque());
        Registry.register(Registry.BLOCK,new Identifier("test_mod","cool_block"),COOL_BLOCK);

        COOL_BLOCK_ITEM=new BlockItem(COOL_BLOCK,new FabricItemSettings().group(ItemInitializer.COOL_ITEMS));
        Registry.register(Registry.ITEM,new Identifier("test_mod","cool_block_item"),COOL_BLOCK_ITEM);

        DISCO_BLOCK=new DiscoBlock(FabricBlockSettings.of(Material.METAL).strength(4));
        Registry.register(Registry.BLOCK,new Identifier("test_mod","disco_block"),DISCO_BLOCK);

        DISCO_BLOCK_ENTITY=Registry.register(Registry.BLOCK_ENTITY_TYPE,
            new Identifier("test_mod","demo_block_entity"),
            FabricBlockEntityTypeBuilder.create(DiscoBlockEntity::new,DISCO_BLOCK).build()
        );

        DISCO_BLOCK_ITEM=new BlockItem(DISCO_BLOCK,new FabricItemSettings().group(ItemInitializer.COOL_ITEMS));

        Registry.register(Registry.ITEM,new Identifier("test_mod","disco_block_item"),DISCO_BLOCK_ITEM);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            int value=state.get(DiscoBlock.LIGHT);
            return colors[15];
        }, DISCO_BLOCK);
    }
}
