package org.systempro.testmod;

import net.fabricmc.api.ModInitializer;
import org.systempro.testmod.items.ItemInitializer;

public class TestModInitializer implements ModInitializer {

    @Override
    public void onInitialize() {
        ItemInitializer.init();
    }
}
