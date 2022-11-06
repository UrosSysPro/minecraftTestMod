package org.systempro.testmod.entities;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.systempro.testmod.items.ItemInitializer;

public class EntityInitializer {
    public static EntityType<FlyingHammerEntity> FLYING_HAMMER_ENTITY;
    public static EntityType<FlyingMobEntity> FLYING_MOB;
    public static SpawnEggItem FLYING_MOB_SPAWN_EGG;
    public static void init(){
//        FLYING_HAMMER_ENTITY=Registry.register(
//            Registry.ENTITY_TYPE,
//            new Identifier("test_mod","flying_hammer"),
//            FabricEntityTypeBuilder.create(
//                SpawnGroup.MISC,
//                FlyingHammerEntity::new
//            ).dimensions(
//                EntityDimensions.fixed(0.5f,0.5f)
//            ).build()
//        );
        FLYING_MOB= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("test_mod","flying_mob"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,FlyingMobEntity::new)
                .dimensions(EntityDimensions.fixed(0.4f,0.3f)).build()
        );
        FLYING_MOB_SPAWN_EGG=new SpawnEggItem(
            FLYING_MOB,
            0x00ef7f,
            0x505050,
            new FabricItemSettings()
                .group(ItemInitializer.COOL_ITEMS)
        );
        Registry.register(Registry.ITEM,
            new Identifier("test_mod","flying_mob_spawn_egg"),
            FLYING_MOB_SPAWN_EGG
        );
        registerAttributes();
    }
    public static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(FLYING_MOB,FlyingMobEntity.setAttributes());
//        FabricDefaultAttributeRegistry.register(FLYING_HAMMER_ENTITY,FlyingHammerEntity.setAttributes());
    }
}
