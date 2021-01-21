package de.melonigemelone.miktoyacore.utils.config;

import de.melonigemelone.miktoyaapi.repository.lib.configuration.yaml.YamlFileBuilder;
import de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder.tablist.TablistAPI;
import de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder.tablist.TablistData;
import de.melonigemelone.miktoyacore.MiktoyaCore;

public class TablistConfigHandler extends YamlFileBuilder {

    public TablistConfigHandler() {
        super(MiktoyaCore.getInstance().getDataFolder().toString(), "tablist.yml");
        setDefaultValues();
        load();
    }

    public void setDefaultValues() {

        setIfNotExists("Tablist.Settings.Enable", true);

        setIfNotExists("Tablist.Settings.German.Header", "\n &e&lMiktoya.net \n");
        setIfNotExists("Tablist.Settings.German.Footer", "\n &cIn Entwicklung \n");

        setIfNotExists("Tablist.Settings.Englisch.Header", "\n &e&lMiktoya.net \n");
        setIfNotExists("Tablist.Settings.Englisch.Footer", "\n &cIn Development \n");

        save();
    }

    public void load() {
        boolean enabled = getBoolean("Tablist.Settings.Enable");
        if(enabled) {
            String headerG = getString("Tablist.Settings.German.Header").replaceAll("&", "§");
            String footerG = getString("Tablist.Settings.German.Footer").replaceAll("&", "§");

            String headerE = getString("Tablist.Settings.Englisch.Header").replaceAll("&", "§");
            String footerE = getString("Tablist.Settings.Englisch.Footer").replaceAll("&", "§");

            TablistAPI.setTablistData(new TablistData(headerG, footerG, headerE, footerE));
        }
    }
}
