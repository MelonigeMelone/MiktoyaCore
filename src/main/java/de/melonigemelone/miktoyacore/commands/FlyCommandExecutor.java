package de.melonigemelone.miktoyacore.commands;

import de.melonigemelone.miktoyaapi.api.languagesystem.LanguageSystemAPI;
import de.melonigemelone.miktoyacore.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("essentials.command.fly")) {
               if(args.length == 0) {
                   if(p.isFlying()) {

                       disableFly(p);
                   } else {

                      activateFly(p);
                   }
               } else if(args.length == 1) {
                   if(p.hasPermission("essentials.command.fly.other")) {
                       Player t = Bukkit.getPlayerExact(args[0]);
                       if (t != null) {
                           if (t.isFlying()) {

                               disableFly(t);
                               p.sendMessage(LanguageSystemAPI.getMessage(Messages.flyModeDisabledOther, p,true));
                           } else {

                               activateFly(t);
                               p.sendMessage(LanguageSystemAPI.getMessage(Messages.flyModeEnabledOther, p,true));
                           }
                       } else {
                           p.sendMessage(LanguageSystemAPI.getNoPlayerFound(p, true));
                       }
                   } else {
                       p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                   }
               } else {
                   p.sendMessage(LanguageSystemAPI.getUseCommand(p, true).replaceAll("%command%", "/fly [Spieler]"));
               }
            } else {
                p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
            }
        } else {
            sender.sendMessage(LanguageSystemAPI.getOnlyPlayers(true));
        }
        return false;
    }

    public static void activateFly(Player p) {
        p.setAllowFlight(true);
        p.setFlying(true);
        p.sendMessage(LanguageSystemAPI.getMessage(Messages.flyModeEnabled, p,true));
    }

    public static void disableFly(Player p) {
        p.setFlying(false);
        p.setAllowFlight(false);
        p.sendMessage(LanguageSystemAPI.getMessage(Messages.flyModeDisabled, p,true));
    }
}
