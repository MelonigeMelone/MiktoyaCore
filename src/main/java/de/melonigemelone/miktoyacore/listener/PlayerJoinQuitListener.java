package de.melonigemelone.miktoyacore.listener;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.api.coinssysteme.coins.CoinsAPI;
import de.melonigemelone.miktoyaapi.api.coinssysteme.economy.EconomyAPI;
import de.melonigemelone.miktoyaapi.api.coinssysteme.rbx.RBXAPI;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerDataAPI;
import de.melonigemelone.miktoyaapi.api.scoreboard.ScoreBoardAPI;
import de.melonigemelone.miktoyaapi.api.vanish.VanishAPI;
import de.melonigemelone.miktoyaapi.api.vault.groups.GroupAPI;
import de.melonigemelone.miktoyaapi.repository.lib.minecraft.inventorybuilder.InventoryBuilder;
import de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder.tablist.TablistAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

public class PlayerJoinQuitListener implements Listener {

   // int germany = 522;
   // 18554

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        String uuid = p.getUniqueId().toString();

        PlayerDataAPI.playerJoins(p);

        //CoinsAPI.loadCoinsDataFromDataBase(uuid);
        //EconomyAPI.loadEconomyDataFromDataBase(uuid);
        //RBXAPI.loadRBXDataFromDataBase(uuid);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.setJoinMessage(null);

        VanishAPI.handlePlayerJoined(p);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        String uuid = p.getUniqueId().toString();

        e.setQuitMessage(null);

        PlayerDataAPI.removePlayerDataFromLocalStorage(uuid);

        CoinsAPI.removeCoinsDataFromLocalStorgae(uuid);
        EconomyAPI.removeEconomyDataFromLocalStorgae(uuid);
        RBXAPI.removeRBXDataFromLocalStorgae(uuid);

        Bukkit.getScheduler().runTaskLater(MiktoyaAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                ScoreBoardAPI.updateScoreBoard();
            }
        }, 100L);
    }





}
