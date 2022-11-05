package org.systempro.testmod.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.systempro.testmod.items.ItemInitializer;

public class BlockInitializer {
    public static Block COOL_BLOCK,DISCO_BLOCK;
    public static BlockItem COOL_BLOCK_ITEM,DISCO_BLOCK_ITEM;
    public static void init(){
        COOL_BLOCK=new Block(FabricBlockSettings.of(Material.METAL).strength(4).jumpVelocityMultiplier(2).nonOpaque());
        Registry.register(Registry.BLOCK,new Identifier("test_mod","cool_block"),COOL_BLOCK);

        COOL_BLOCK_ITEM=new BlockItem(COOL_BLOCK,new FabricItemSettings().group(ItemInitializer.COOL_ITEMS));
        Registry.register(Registry.ITEM,new Identifier("test_mod","cool_block_item"),COOL_BLOCK_ITEM);

        DISCO_BLOCK=new Block(FabricBlockSettings.of(Material.METAL).strength(4));
        Registry.register(Registry.BLOCK,new Identifier("test_mod","disco_block"),DISCO_BLOCK);

        DISCO_BLOCK_ITEM=new BlockItem(DISCO_BLOCK,new FabricItemSettings().group(ItemInitializer.COOL_ITEMS));
        Registry.register(Registry.ITEM,new Identifier("test_mod","disco_block_item"),DISCO_BLOCK_ITEM);
    }
}
