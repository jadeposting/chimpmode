package dev.jadeposting.chimpmode.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = "chimpmode")
public class ChimpConfig implements ConfigData {

    @ConfigEntry.Gui.Excluded
    private static ConfigHolder<ChimpConfig> configHolder;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("offhand")
    public boolean hideOffhandItems;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("offhand")
    @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
    public int offHandItemScale = 100;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("toolActions")
    public boolean disableShovelPathing;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("toolActions")
    public boolean disableLogStripping;

    public static void register() {
        if (configHolder != null) throw new IllegalStateException("ChimpConfig has already been initialized.");
        configHolder = AutoConfig.register(ChimpConfig.class, GsonConfigSerializer::new);
    }

    public static ChimpConfig instance() {
        if (configHolder == null) throw new IllegalStateException("ChimpConfig has not yet been initialized.");
        return configHolder.getConfig();
    }
}
