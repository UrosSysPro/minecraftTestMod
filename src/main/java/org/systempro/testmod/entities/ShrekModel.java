package org.systempro.testmod.entities;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ShrekModel extends AnimatedGeoModel<ShrekEntity> {

    @Override
    public Identifier getModelResource(ShrekEntity object) {
        return new Identifier("test_mod","geo/shrek.geo.json");
    }

    @Override
    public Identifier getTextureResource(ShrekEntity object) {
        return new Identifier("test_mod","textures/entity/shrek/texture.png");
    }

    @Override
    public Identifier getAnimationResource(ShrekEntity animatable) {
        return new Identifier("test_mod","animations/shrek.animation.json");
    }

    @Override
    public void setLivingAnimations(ShrekEntity animatable, Integer instanceId, AnimationEvent animationEvent) {
        super.setLivingAnimations(animatable, instanceId, animationEvent);
        IBone head=getAnimationProcessor().getBone("head");

        EntityModelData extraData=(EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        if(head!=null){
            head.setRotationX(extraData.headPitch*(float) Math.PI/180);
            head.setRotationY(extraData.netHeadYaw*(float) Math.PI/180);
        }
    }
}
