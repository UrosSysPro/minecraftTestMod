package org.systempro.testmod.entities;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class FlyingMobModel extends AnimatedGeoModel<FlyingMobEntity> {

    @Override
    public Identifier getModelResource(FlyingMobEntity object) {
        return new Identifier("test_mod","geo/flying_mob.geo.json");
    }

    @Override
    public Identifier getTextureResource(FlyingMobEntity object) {
        return new Identifier("test_mod","textures/entity/flying_mob/flying_mob.png");
    }

    @Override
    public Identifier getAnimationResource(FlyingMobEntity animatable) {
        return new Identifier("test_mod","animations/flying_mob.animation.json");
    }

    @Override
    public void setLivingAnimations(FlyingMobEntity animatable, Integer instanceId, AnimationEvent animationEvent) {
        super.setLivingAnimations(animatable, instanceId, animationEvent);
        IBone head=getAnimationProcessor().getBone("head");

        EntityModelData extraData=(EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        if(head!=null){
            head.setRotationX(extraData.headPitch*(float) Math.PI/180);
            head.setRotationY(extraData.netHeadYaw*(float) Math.PI/180);
        }
    }
}
