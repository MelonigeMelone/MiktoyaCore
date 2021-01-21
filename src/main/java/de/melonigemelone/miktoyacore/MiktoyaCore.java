package de.melonigemelone.miktoyacore;

import de.melonigemelone.miktoyacore.commands.VanishCmd;
import de.melonigemelone.miktoyacore.listener.*;
import de.melonigemelone.miktoyacore.utils.Messages;
import de.melonigemelone.miktoyacore.utils.config.ConfigHandler;
import de.melonigemelone.miktoyacore.utils.config.ScoreBoardConfigHandler;
import de.melonigemelone.miktoyacore.utils.config.TablistConfigHandler;
import de.melonigemelone.miktoyacore.utils.model.CoreData;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class MiktoyaCore extends JavaPlugin {

    public static MiktoyaCore instance;

    public static CoreData coreData;

    public static ConfigHandler configHandler;
    public static ScoreBoardConfigHandler scoreBoardConfigHandler;
    public static TablistConfigHandler tablistConfigHandler;

    @Override
    public void onEnable() {
        instance = this;
        coreData = new CoreData();

        Messages.init();

        configHandler = new ConfigHandler();
        scoreBoardConfigHandler = new ScoreBoardConfigHandler();
        tablistConfigHandler = new TablistConfigHandler();

        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerChangeLanguageListener(), this);;
        Bukkit.getPluginManager().registerEvents(new PlayerJoinQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new TCPExploitListener(), this);
        Bukkit.getPluginManager().registerEvents(new UnknowCommandListener(), this);

        getCommand("vanish").setExecutor(new VanishCmd());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static MiktoyaCore getInstance() {
        return instance;
    }

    public static CoreData getCoreData() {
        return coreData;
    }
}
