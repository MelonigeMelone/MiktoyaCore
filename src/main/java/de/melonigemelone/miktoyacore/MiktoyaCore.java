package de.melonigemelone.miktoyacore;

import de.melonigemelone.miktoyacore.commands.GamemodeCommandExecutor;
import de.melonigemelone.miktoyacore.utils.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public class MiktoyaCore extends JavaPlugin {

    @Override
    public void onEnable() {
        Messages.init();

        getCommand("gamemode").setExecutor(new GamemodeCommandExecutor());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
