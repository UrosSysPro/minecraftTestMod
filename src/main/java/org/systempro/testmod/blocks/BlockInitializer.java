package org.systempro.testmod.blocks;

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
    public static void init(){
        COOL_BLOCK=new Block(FabricBlockSettings.of(Material.METAL).strength(4).jumpVelocityMultiplier(2).nonOpaque());
        Registry.register(Registry.BLOCK,new Identifier("test_mod","cool_block"),COOL_BLOCK);

        COOL_BLOCK_ITEM=new BlockItem(COOL_BLOCK,new FabricItemSettings().group(ItemInitializer.COOL_ITEMS));
        Registry.register(Registry.ITEM,new Identifier("test_mod","cool_block_item"),COOL_BLOCK_ITEM);

//        DISCO_BLOCK=new DiscoBlock(FabricBlockSettings.of(Material.METAL).strength(4));
//        Registry.register(Registry.BLOCK,new Identifier("test_mod","disco_block"),DISCO_BLOCK);
//
//        DISCO_BLOCK_ENTITY=Registry.register(Registry.BLOCK_ENTITY_TYPE,
//            new Identifier("test_mod","demo_block_entity"),
//            FabricBlockEntityTypeBuilder.create(DiscoBlockEntity::new,DISCO_BLOCK).build()
//        );

//        DISCO_BLOCK_ITEM=new BlockItem(DISCO_BLOCK,new FabricItemSettings().group(ItemInitializer.COOL_ITEMS));
//        Registry.register(Registry.ITEM,new Identifier("test_mod","disco_block_item"),DISCO_BLOCK_ITEM);
    }
}
