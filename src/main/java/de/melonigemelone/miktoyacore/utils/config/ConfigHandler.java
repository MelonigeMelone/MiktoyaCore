package de.melonigemelone.miktoyacore.utils.config;

import de.melonigemelone.miktoyaapi.repository.lib.configuration.yaml.YamlFileBuilder;
import de.melonigemelone.miktoyacore.MiktoyaCore;

public class ConfigHandler extends YamlFileBuilder {

    public ConfigHandler() {
        super(MiktoyaCore.getInstance().getDataFolder().toString(), "config.yml");
        setDefaultValues();
        load();
    }

    public void setDefaultValues() {
        setIfNotExists("Settings.Systems.CoinSystem", true);
        setIfNotExists("Settings.Systems.EconomySystem", true);
        setIfNotExists("Settings.Systems.RBXSystem", true);

        save();
    }

    public void load() {
        boolean coins = getBoolean("Settings.Systems.CoinSystem");
        boolean economy = getBoolean("Settings.Systems.EconomySystem");
        boolean rbx = getBoolean("Settings.Systems.RBXSystem");

        MiktoyaCore.getCoreData().setCoinsSystemEnabled(coins);
        MiktoyaCore.getCoreData().setEconomySystemEnabled(economy);
        MiktoyaCore.getCoreData().setRbxSystemEnabled(rbx);
    }
}
