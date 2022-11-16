package org.systempro.testmod.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.function.Function;

public class FlyingHammerModel extends AnimatedGeoModel<FlyingHammerEntity> {

    @Override
    public Identifier getModelResource(FlyingHammerEntity object) {
        return new Identifier("test_mod","geo/flying_hammer.geo.json");
    }

    @Override
    public Identifier getTextureResource(FlyingHammerEntity object) {
        return new Identifier("test_mod","textures/entity/flying_hammer/flying_hammer.png");
    }

    @Override
    public Identifier getAnimationResource(FlyingHammerEntity animatable) {
        return new Identifier("test_mod","animations/flying_hammer.animation.json");
    }
}
