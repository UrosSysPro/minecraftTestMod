package org.systempro.testmod.entities;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FlyingMobRenderer extends GeoEntityRenderer<FlyingMobEntity> {
    public FlyingMobRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new FlyingMobModel());
    }

    @Override
    public Identifier getTexture(FlyingMobEntity entity) {
        return new Identifier("test_mod","textures/entity/flying_mob/flying_mob.png");
    }
}
