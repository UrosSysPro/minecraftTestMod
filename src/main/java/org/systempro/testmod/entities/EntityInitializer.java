package org.systempro.testmod.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

public class EntityInitializer {
    public static EntityType<FlyingHammerEntity> FLYING_HAMMER_ENTITY_TYPE;
    public static void init(){
//        FLYING_HAMMER_ENTITY_TYPE= FabricEntityTypeBuilder.create(SpawnGroup.MISC,FlyingHammerEntity::new).build();
    }
}
