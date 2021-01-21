package de.melonigemelone.miktoyacore.listener;

import de.melonigemelone.miktoyaapi.api.scoreboard.ScoreBoardAPI;
import de.melonigemelone.miktoyaapi.events.PlayerChangeLanguageEvent;
import de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder.tablist.TablistAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerChangeLanguageListener implements Listener {

    @EventHandler
    public void onLanguageChange(PlayerChangeLanguageEvent e) {
        Player p = e.getPlayer();
        ScoreBoardAPI.updateScoreBoard(p);
        TablistAPI.send(p);
    }
}
