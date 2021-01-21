package de.melonigemelone.miktoyacore.utils.config;

import de.melonigemelone.miktoyaapi.api.scoreboard.ScoreBoardAPI;
import de.melonigemelone.miktoyaapi.api.scoreboard.ScoreBoardData;
import de.melonigemelone.miktoyaapi.repository.lib.configuration.yaml.YamlFileBuilder;
import de.melonigemelone.miktoyacore.MiktoyaCore;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoardConfigHandler extends YamlFileBuilder {

    public ScoreBoardConfigHandler() {
        super(MiktoyaCore.getInstance().getDataFolder().toString(), "scoreBoard.yml");
        setDefaultValues();
        load();
    }

    public void setDefaultValues() {

        setIfNotExists("ScoreBoard.Settings.Enable", true);

        setIfNotExists("ScoreBoard.Settings.DisplayName", "&e&lMiktoyaNet");

        setIfNotExists("ScoreBoard.Settings.German.Lines.1", " ");
        setIfNotExists("ScoreBoard.Settings.German.Lines.2", "&7Spieler Online §");
        setIfNotExists("ScoreBoard.Settings.German.Lines.3", "&8&l-> &e%playerlist_online,normal,yes,amount%");
        setIfNotExists("ScoreBoard.Settings.German.Lines.4", "  ");

        setIfNotExists("ScoreBoard.Settings.Englisch.Lines.1", " ");
        setIfNotExists("ScoreBoard.Settings.Englisch.Lines.2", "&7Players Online");
        setIfNotExists("ScoreBoard.Settings.Englisch.Lines.3", "&8&l-> &e%playerlist_online,normal,yes,amount%");
        setIfNotExists("ScoreBoard.Settings.Englisch.Lines.4", "  ");

        save();
    }

    public void load() {
        boolean enabled = getBoolean("ScoreBoard.Settings.Enable");

        if(enabled) {
            List<String> germanLines = new ArrayList<>();
            List<String> englischLines = new ArrayList<>();

            String displayName = getString("ScoreBoard.Settings.DisplayName").replaceAll("&", "§");

            ConfigurationSection german = getConfigurationSection("ScoreBoard.Settings.German.Lines");
            for(String s : german.getKeys(true)) {
                germanLines.add(german.getString(s).replaceAll("&", "§"));
            }

            ConfigurationSection englisch = getConfigurationSection("ScoreBoard.Settings.Englisch.Lines");
            for(String s : englisch.getKeys(true)) {
                englischLines.add(englisch.getString(s).replaceAll("&", "§"));
            }

            ScoreBoardAPI.setScoreBoardData(new ScoreBoardData(displayName, germanLines, englischLines));
        }
    }
}
