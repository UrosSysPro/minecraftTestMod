package org.systempro.testmod.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ModArmorMaterial implements ArmorMaterial {

    public static final ModArmorMaterial EMERALD_ARMOR_MATERIAL=new ModArmorMaterial(
        new int[]{13,14,16,13},
        new int[]{3,4,6,3},
        20,
        SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
        Ingredient.ofItems(Items.EMERALD),
        "emerald",
        2,2
    );

    public int[] baseDurability;
    public int[] protectionValue;
    public int enchantability;
    public SoundEvent soundEvent;
    public Ingredient repairIngredient;
    public String name;
    public float toughness;
    public float knockbackResistance;

    public ModArmorMaterial(
        int[] baseDurability,
        int[] protectionValue,
        int enchantability,
        SoundEvent soundEvent,
        Ingredient repairIngredient,
        String name,
        float toughness,
        float knockbackResistance
    ){
        this.protectionValue=protectionValue;
        this.baseDurability=baseDurability;
        this.enchantability=enchantability;
        this.soundEvent=soundEvent;
        this.repairIngredient=repairIngredient;
        this.name=name;
        this.toughness=toughness;
        this.knockbackResistance=knockbackResistance;
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return baseDurability[slot.getEntitySlotId()]*100;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protectionValue[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
