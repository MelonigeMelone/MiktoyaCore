package de.melonigemelone.miktoyacore.commands;

import de.melonigemelone.miktoyaapi.api.languagesystem.LanguageSystemAPI;
import de.melonigemelone.miktoyacore.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GamemodeCommandExecutor implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("miktoyacore.command.gamemode.survival") || p.hasPermission("miktoyacore.command.gamemode.creative") ||
                    p.hasPermission("miktoyacore.command.gamemode.adventure") || p.hasPermission("miktoyacore.command.gamemode.spectator") ||
                    p.hasPermission("miktoyacore.command.gamemode.survival.other") || p.hasPermission("miktoyacore.command.gamemode.creative.other") ||
                    p.hasPermission("miktoyacore.command.gamemode.adventure.other") || p.hasPermission("miktoyacore.command.gamemode.spectator.other")) {
                if (args.length == 1) {
                    switch (args[0]) {
                        case "0":
                        case "survival":
                        case "überleben":
                            if (p.hasPermission("miktoyacore.command.gamemode.survival")) {
                                p.sendMessage(LanguageSystemAPI.getPrefix(true) + "§7Du bist jetzt im §eÜberlebens-Modus§7!");
                                p.setGameMode(GameMode.SURVIVAL);
                            } else {
                                p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                            }
                            break;
                        case "1":
                        case "creative":
                        case "Kreativ":
                            if (p.hasPermission("miktoyacore.command.gamemode.creative")) {
                                p.sendMessage(LanguageSystemAPI.getPrefix(true) + "§7Du bist jetzt im §eKreativ-Modus§7!");
                                p.setGameMode(GameMode.CREATIVE);
                            } else {
                                p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                            }
                            break;
                        case "2":
                        case "adventure":
                        case "Abenteuer":
                            if (p.hasPermission("miktoyacore.command.gamemode.adventure")) {
                                p.sendMessage(LanguageSystemAPI.getPrefix(true) + "§7Du bist jetzt im §eAbenteuer-Modus§7!");
                                p.setGameMode(GameMode.ADVENTURE);
                            } else {
                                p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                            }
                            break;
                        case "3":
                        case "spectator":
                        case "Zuschauer":
                            if (p.hasPermission("miktoyacore.command.gamemode.spectator")) {
                                p.sendMessage(LanguageSystemAPI.getPrefix(true) + "§7Du bist jetzt im §eZuschauer-Modus§7!");
                                p.setGameMode(GameMode.SPECTATOR);
                            } else {
                                p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                            }
                            break;
                        default:
                            p.sendMessage(LanguageSystemAPI.getPrefix(true) + "§cNutze: §7/" + label + " (0|1|2|3) [Spieler]");
                            break;
                    }

                } else if (args.length == 2) {
                    if (p.hasPermission("miktoyacore.command.gamemode.survival.other") || p.hasPermission("miktoyacore.command.gamemode.creative.other") ||
                            p.hasPermission("miktoyacore.command.gamemode.adventure.other") || p.hasPermission("miktoyacore.command.gamemode.spectator.other")) {
                        Player t = Bukkit.getPlayerExact(args[1]);
                        if (t != null) {
                            String message = LanguageSystemAPI.getPrefix(true) + "&7Du hast den Spieler in den &e%gamemode%-Modus &7gesetzt!";
                            switch (args[0]) {
                                case "0":
                                case "survival":
                                case "überleben":
                                    if (p.hasPermission("miktoyacore.command.gamemode.survival.other")) {
                                        p.sendMessage(message.replaceAll("%gamemode%", "Überleben"));
                                        t.sendMessage(LanguageSystemAPI.getMessage(Messages.gameModeSurvival, t, true));
                                        t.setGameMode(GameMode.SURVIVAL);
                                    } else {
                                        p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                                    }
                                    break;
                                case "1":
                                case "creative":
                                case "Kreativ":
                                    if (p.hasPermission("miktoyacore.command.gamemode.creative.other")) {
                                        p.sendMessage(message.replaceAll("%gamemode%", "Kreativ"));
                                        t.sendMessage(LanguageSystemAPI.getMessage(Messages.gameModeCreative, t, true));
                                        t.setGameMode(GameMode.CREATIVE);
                                    } else {
                                        p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                                    }
                                    break;
                                case "2":
                                case "adventure":
                                case "Abenteuer":
                                    if (p.hasPermission("miktoyacore.command.gamemode.adventure.other")) {
                                        p.sendMessage(message.replaceAll("%gamemode%", "Abenteuert"));
                                        t.sendMessage(LanguageSystemAPI.getMessage(Messages.gameModeAdventure, t, true));
                                        t.setGameMode(GameMode.ADVENTURE);
                                    } else {
                                        p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                                    }
                                    break;
                                case "3":
                                case "spectator":
                                case "Zuschauer":
                                    if (p.hasPermission("miktoyacore.command.gamemode.spectator.other")) {
                                        p.sendMessage(LanguageSystemAPI.getPrefix(true) + "&7Du hast den Spieler in den &3Zuschauer-Modus &7gesetzt!");
                                        t.sendMessage(LanguageSystemAPI.getMessage(Messages.gameModeSpectator, t, true));
                                        t.setGameMode(GameMode.SPECTATOR);
                                    } else {
                                        p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                                    }
                                    break;
                                default:
                                    p.sendMessage(LanguageSystemAPI.getUseCommand(p, true).replaceAll("%command%", "/" + label + " (0|1|2|3) [Spieler]"));
                                    break;
                            }
                        } else {
                            p.sendMessage(LanguageSystemAPI.getPrefix(true) + "§cEs wurde kein Spieler mit diesem");
                        }
                    } else {
                        p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
                    }
                } else {
                    p.sendMessage(LanguageSystemAPI.getUseCommand(p, true).replaceAll("%command%", "/" + label + " (0|1|2|3) [Spieler]"));
                }
            } else {
                p.sendMessage(LanguageSystemAPI.getNoPerm(p, true));
            }
        } else {
            sender.sendMessage(LanguageSystemAPI.getOnlyPlayers(true));
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if (args.length == 1) {
                return Arrays.asList("0", "1", "2", "3", "survival", "creative", "spectator", "adventure").stream().filter(s -> s.startsWith(args[0].toLowerCase())).collect(Collectors.toList());
            }
        }
        return null;

    }


}
