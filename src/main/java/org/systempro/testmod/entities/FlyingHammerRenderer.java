package org.systempro.testmod.entities;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FlyingHammerRenderer extends GeoEntityRenderer<FlyingHammerEntity> {

    public FlyingHammerRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new FlyingHammerModel());
    }

    @Override
    public Identifier getTexture(FlyingHammerEntity entity) {
        return new Identifier("test_mod","textures/entity/flying_hammer/flying_hammer.png");
    }
}
