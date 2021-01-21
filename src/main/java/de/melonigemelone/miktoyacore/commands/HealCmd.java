package de.melonigemelone.miktoyacore.commands;

import de.melonigemelone.miktoyaapi.api.playerdata.PlayerDataAPI;
import de.melonigemelone.miktoyacore.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class HealCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(sender instanceof Player) {

        } else if (sender instanceof ConsoleCommandSender) {
            if(args.length == 1) {
                String playerName = args[0];
                if(PlayerDataAPI.isPlayerOnlineWithName(playerName)) {
                    Player target = Bukkit.getPlayerExact(playerName);
                    target.setHealth(target.getMaxHealth());

                    sender.sendMessage("§aDu hast den Spieler geheilt!");
                } else {
                    sender.sendMessage("§cDer Spieler ist nicht online!");
                }
            } else {
                sender.sendMessage("§cNutze: /heal (Spieler)");
            }
        }
        return false;
    }
}
