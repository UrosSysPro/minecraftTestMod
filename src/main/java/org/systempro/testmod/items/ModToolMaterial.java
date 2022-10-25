package org.systempro.testmod.items;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ModToolMaterial implements ToolMaterial {

    public static final ModToolMaterial EMERALD_TOOL_MATERIAL=new ModToolMaterial(
        500,
        2,
        5,
        3,
        20,
        Ingredient.ofItems(Items.EMERALD)
    );
    public int durability;
    public float miningSpeedMultiplier;
    public float attackDamage;
    public int miningLevel;
    public int enchantability;
    public Ingredient repairIngredient;

    public ModToolMaterial(
        int durability,
        float miningSpeedMultiplier,
        float attackDamage,
        int miningLevel,
        int enchantability,
        Ingredient repairIngredient
    ){
        this.durability=durability;
        this.miningSpeedMultiplier=miningSpeedMultiplier;
        this.attackDamage=attackDamage;
        this.miningLevel=miningLevel;
        this.enchantability=enchantability;
        this.repairIngredient=repairIngredient;
    }
    @Override
    public int getDurability() {
        return durability;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeedMultiplier;
    }
    @Override
    public float getAttackDamage() {
        return attackDamage;
    }
    @Override
    public int getMiningLevel() {
        return miningLevel;
    }
    @Override
    public int getEnchantability() {
        return enchantability;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }
}
