package dev.jadeposting.chimpmode.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.jadeposting.chimpmode.config.ChimpConfig;
import me.shedaniel.autoconfig.AutoConfig;

public class ChimpmodeModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(ChimpConfig.class, parent).get();
    }
}
