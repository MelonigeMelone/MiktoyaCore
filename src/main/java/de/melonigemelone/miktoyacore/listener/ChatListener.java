package de.melonigemelone.miktoyacore.listener;

import de.melonigemelone.miktoyaapi.api.vault.groups.Group;
import de.melonigemelone.miktoyaapi.api.vault.groups.GroupAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        Group group = GroupAPI.getGroupFromPlayer(p);

        String displayName = group.getChatPrefix() + " " + group.getChatNameColors()[0] + p.getName() + group.getChatSuffix();

        String message = e.getMessage();

        if(p.hasPermission("miktoyacore.chatcolors")) {
            message = message.replaceAll("&", "§");
        }

        System.out.println(group.getChatFormat().replaceAll("%displayname%", displayName).replaceAll("%message%", message));
        e.setFormat(group.getChatFormat().replaceAll("%displayname%", displayName).replaceAll("%message%", message));
    }
}
