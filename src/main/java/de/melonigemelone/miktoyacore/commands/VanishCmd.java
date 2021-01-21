package de.melonigemelone.miktoyacore.commands;

import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import de.melonigemelone.miktoyaapi.api.languagesystem.LanguageSystemAPI;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerData;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerDataAPI;
import de.melonigemelone.miktoyaapi.api.vanish.VanishAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            PlayerData playerData = PlayerDataAPI.getPlayerDataFromUUIDFromOlinePlayers(p.getUniqueId().toString());

            if(p.hasPermission("core.command.vanish") || p.hasPermission("core.command.vanish.other")) {
                if(args.length == 0) {
                    if(playerData.isVanish()) {
                        VanishAPI.removePlayerFromVanish(playerData);
                    } else {
                        VanishAPI.addPlayerToVanish(playerData);
                    }
                } else if(args.length == 1) {

                } else {

                }
            } else {
                p.sendMessage(LanguageSystemAPI.getNoPerm().getMessage(playerData, true));
            }

        } else {
            sender.sendMessage(LanguageSystemAPI.getOnlyPlayers().getMessage(Language.GERMAN, true));
        }
        return false;
    }
}
