package de.melonigemelone.miktoyacore.commands;

import de.melonigemelone.miktoyaapi.api.languagesystem.LanguageSystemAPI;
import de.melonigemelone.miktoyacore.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WalkSpeedCommandExecutor implements CommandExecutor {

    public static String cmdUse = "/walkspeed (1-10) [Spieler]";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("essentials.command.walkspeed")) {
                if(args.length == 1) {
                    try {
                        float speed = (Float.parseFloat(args[0]) / 10);
                        if (speed >= 0 && speed <= 1) {
                            p.setWalkSpeed(speed);
                            p.sendMessage(LanguageSystemAPI.getPrefix(true) + "§7Du hast deine Geschwindigkeit geändert!");
                        } else {
                            p.sendMessage(LanguageSystemAPI.getUseCommand(p, true).replaceAll("%command%", cmdUse));
                        }
                    } catch(NumberFormatException e) {
                        p.sendMessage(LanguageSystemAPI.getPrefix(true) + "§cDie Geschwindigkeit muss eine Zahl zwischen 1 und 10 sein!");
                    }
                } else if(args.length == 2) {
                    if(p.hasPermission("essentials.command.walkspeed")) {
                        Player t = Bukkit.getPlayerExact(args[1]);
                        if (t != null) {
                            try {
                                float speed = (Float.parseFloat(args[0]) / 10);
                                if (speed >= 0 && speed <= 1) {
                                    t.setWalkSpeed(speed);
                                    t.sendMessage(LanguageSystemAPI.getMessage(Messages.walkSpeedChanged, t, true).replaceAll("%walkspeed%", String.valueOf(speed * 10)));
                                    p.sendMessage(LanguageSystemAPI.getPrefix(true) + "§7Du hast die Geschwindigkeit für den Spieler geändert!");
                                } else {
                                    p.sendMessage(LanguageSystemAPI.getUseCommand(p, true).replaceAll("%command%", cmdUse));
                                }
                            } catch (NumberFormatException e) {
                                p.sendMessage(LanguageSystemAPI.getPrefix(true) + "§cDie Geschwindigkeit muss eine Zahl zwischen 1 und 10 sein!");
                            }
                        } else {
                            p.sendMessage(LanguageSystemAPI.getNoPlayerFound(p, true));
                        }
                    } else {
                        p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                    }
                } else {
                    p.sendMessage(LanguageSystemAPI.getUseCommand(p, true).replaceAll("%command%", cmdUse));
                }
            } else {
                p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
            }
        } else {
            sender.sendMessage(LanguageSystemAPI.getOnlyPlayers(true));
        }
        return false;
    }
}
