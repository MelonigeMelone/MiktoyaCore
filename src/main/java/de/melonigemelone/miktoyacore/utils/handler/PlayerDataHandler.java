package de.melonigemelone.miktoyacore.utils.handler;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerDataAPI;
import de.melonigemelone.miktoyaapi.api.scoreboard.ScoreBoardAPI;
import de.melonigemelone.miktoyaapi.api.vanish.VanishAPI;
import de.melonigemelone.miktoyaapi.api.vault.groups.GroupAPI;
import de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder.tablist.TablistAPI;
import org.bukkit.entity.Player;

public class PlayerDataHandler {

    public void playerJoins(Player p) {
        String uuid = p.getUniqueId().toString();

        MiktoyaAPI.getPlayerDataMySQL().getDataFromUUID(uuid, playerData -> {
            playerData.setPlayer(p);
            PlayerDataAPI.getPlayerDataHashMapWithUUID().put(uuid, playerData);
            PlayerDataAPI.getPlayerDataHashMapWithName().put(playerData.getName(), playerData);

            GroupAPI.getGroupFromPlayer(p).addPlayerToTeam(p);
            ScoreBoardAPI.sendScoreBoardToPlayer(p);
            TablistAPI.send(p);

            if(playerData.isVanish()) {
                MiktoyaAPI.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(MiktoyaAPI.getInstance(), () -> {
                    VanishAPI.addPlayerToVanish(playerData);
                });
            }

            if(!playerData.isSelectedLanguage()) {
                MiktoyaAPI.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(MiktoyaAPI.getInstance(), () -> {

                });
            }
        });
    }
}
