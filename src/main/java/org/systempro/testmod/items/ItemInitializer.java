package org.systempro.testmod.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.mixin.item.group.ItemGroupMixin;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ItemInitializer {
    public static ItemGroup COOL_ITEMS;

    public static ToolItem EMERALD_PICKAXE, EMERALD_SHOVEL, EMERALD_SWORD,EMERALD_AXE,EMERALD_HOE;
    public static ToolItem HAMMER;
    public static Stoner STONER;
    public static VoidItem VOID_ITEM;
    public static SpongeFractal SPONGE_FRACTAL;
    public static WorldEdit WORLD_EDIT;
    public static ArmorItem EMERALD_HELMET,EMERALD_CHESTPLATE,EMERALD_LEGGINGS,EMERALD_BOOTS;
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

        EMERALD_HOE=new ModHoeItem(
            ModToolMaterial.EMERALD_TOOL_MATERIAL,
            5,3,
            new FabricItemSettings().group(COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","emerald_hoe"),EMERALD_HOE);

        EMERALD_HELMET=new ArmorItem(
            ModArmorMaterial.EMERALD_ARMOR_MATERIAL,
            EquipmentSlot.HEAD,
            new FabricItemSettings().group(COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","emerald_helmet"),EMERALD_HELMET);

        EMERALD_CHESTPLATE=new ArmorItem(
            ModArmorMaterial.EMERALD_ARMOR_MATERIAL,
            EquipmentSlot.CHEST,
            new FabricItemSettings().group(COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","emerald_chestplate"),EMERALD_CHESTPLATE);

        EMERALD_LEGGINGS=new ArmorItem(
            ModArmorMaterial.EMERALD_ARMOR_MATERIAL,
            EquipmentSlot.LEGS,
            new FabricItemSettings().group(COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","emerald_leggings"),EMERALD_LEGGINGS);

        EMERALD_BOOTS=new ArmorItem(
            ModArmorMaterial.EMERALD_ARMOR_MATERIAL,
            EquipmentSlot.FEET,
            new FabricItemSettings().group(COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","emerald_boots"),EMERALD_BOOTS);

        HAMMER=new Hammer(ModToolMaterial.IRON_BLOCK_TOOL_MATERIAL,new FabricItemSettings().group(COOL_ITEMS));
        Registry.register(Registry.ITEM,new Identifier("test_mod","hammer"),HAMMER);

        STONER=new Stoner(new FabricItemSettings()
            .group(COOL_ITEMS)
            .maxCount(1)
            .rarity(Rarity.EPIC)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","stoner"),STONER);

        VOID_ITEM=new VoidItem(new FabricItemSettings()
            .group(COOL_ITEMS)
            .maxCount(1)
            .rarity(Rarity.RARE)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","void_item"),VOID_ITEM);

        SPONGE_FRACTAL=new SpongeFractal(new FabricItemSettings()
            .group(COOL_ITEMS)
            .maxCount(1)
            .rarity(Rarity.RARE)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","sponge_fractal"),SPONGE_FRACTAL);

        WORLD_EDIT=new WorldEdit(new FabricItemSettings()
            .group(COOL_ITEMS)
            .maxCount(1)
            .rarity(Rarity.RARE)
        );
        Registry.register(Registry.ITEM,new Identifier("test_mod","world_edit"),WORLD_EDIT);

    }
}
