package org.systempro.testmod.entities;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ShrekRenderer extends GeoEntityRenderer<ShrekEntity> {
    public ShrekRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ShrekModel());
    }

    @Override
    public Identifier getTexture(ShrekEntity entity) {
        return new Identifier("test_mod","textures/entity/shrek/texture.png");
    }
}
