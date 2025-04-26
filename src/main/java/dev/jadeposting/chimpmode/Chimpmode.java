package dev.jadeposting.chimpmode;

import dev.jadeposting.chimpmode.config.ChimpConfig;
import net.fabricmc.api.ClientModInitializer;

public class Chimpmode implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ChimpConfig.register();
    }
}
