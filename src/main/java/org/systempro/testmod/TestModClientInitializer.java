package org.systempro.testmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import org.systempro.testmod.entities.EntityInitializer;
import org.systempro.testmod.entities.FlyingHammerEntity;
import org.systempro.testmod.entities.FlyingHammerRenderer;
import org.systempro.testmod.entities.FlyingMobRenderer;

public class TestModClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityInitializer.init();
        EntityRendererRegistry.register(EntityInitializer.FLYING_MOB, FlyingMobRenderer::new);
//        EntityRendererRegistry.register(EntityInitializer.FLYING_HAMMER_ENTITY, FlyingHammerRenderer::new);
    }
}
