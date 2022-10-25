package org.systempro.testmod.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.mixin.item.group.ItemGroupMixin;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemInitializer {
    public static ItemGroup COOL_ITEMS;
    public static ToolItem EMERALD_PICKAXE;
    public static ToolItem EMERALD_SHOVEL;
    public static ToolItem EMERALD_SWORD;
    public static ToolItem EMERALD_AXE;
    public static ToolItem EMERALD_HOE;

    public static void init(){
        COOL_ITEMS= FabricItemGroupBuilder.build(
            new Identifier("test_mod", "cool_items"),
            ()->new ItemStack(Items.EMERALD)
        );

        EMERALD_SHOVEL=new ShovelItem(
            ModToolMaterial.EMERALD_TOOL_MATERIAL,
            2,3,
            new FabricItemSettings().group(COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","emerald_shovel"),EMERALD_SHOVEL);

        EMERALD_SWORD=new EmeraldSword(
            ModToolMaterial.EMERALD_TOOL_MATERIAL,
            5,3,
            new FabricItemSettings().group(COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","emerald_sword"),EMERALD_SWORD);

        EMERALD_PICKAXE=new PickaxeItem(
            ModToolMaterial.EMERALD_TOOL_MATERIAL,
            5,3,
            new FabricItemSettings().group(COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","emerald_pickaxe"),EMERALD_PICKAXE);

        EMERALD_AXE=new AxeItem(
            ModToolMaterial.EMERALD_TOOL_MATERIAL,
            5,3,
            new FabricItemSettings().group(COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","emerald_axe"),EMERALD_AXE);

        EMERALD_HOE=new PickaxeItem(
            ModToolMaterial.EMERALD_TOOL_MATERIAL,
            5,3,
            new FabricItemSettings().group(COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","emerald_hoe"),EMERALD_HOE);

    }
}
