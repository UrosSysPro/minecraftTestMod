package org.systempro.testmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import org.systempro.testmod.entities.EntityInitializer;
import org.systempro.testmod.entities.FlyingHammerEntity;
import org.systempro.testmod.entities.FlyingHammerRenderer;

public class TestModClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

    }
}
