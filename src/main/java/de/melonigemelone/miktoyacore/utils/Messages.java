package de.melonigemelone.miktoyacore.utils;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.api.languagesystem.LanguageSystemAPI;

public class Messages {

    public static String gameModeSurvival = "MiktoyaCore.GameMode_Survival";
    public static String gameModeCreative = "MiktoyaCore.GameMode_Creative";
    public static String gameModeAdventure = "MiktoyaCore.GameMode_Adventure";
    public static String gameModeSpectator = "MiktoyaCore.GameMode_Spectator";

    public static String flyModeDisabled = "MiktoyaCore.FlyMode_Disabled";
    public static String flyModeEnabled = "MiktoyaCore.FlyMode_Enabled";
    public static String flyModeDisabledOther = "MiktoyaCore.FlyMode_Disabled_Other";
    public static String flyModeEnabledOther = "MiktoyaCore.FlyMode_Enabled_Other";

    public static String flySpeedChanged = "MiktoyaCore.FlySpeed_Changed";

    public static String walkSpeedChanged = "MiktoyaCore.WalkSpeed_Changed";

    public static void init() {
        LanguageSystemAPI.addMessage(gameModeSurvival,
                LanguageSystemAPI.getPrefix(false) + "&7Du bist nun im &eUeberlebens-Modus&7!",
                LanguageSystemAPI.getPrefix(false) + "&7You are now in &eSurvival-Mode&7!");

        LanguageSystemAPI.addMessage(gameModeCreative,
                LanguageSystemAPI.getPrefix(false) + "&7Du bist nun im &eKreativ-Modus&7!",
                LanguageSystemAPI.getPrefix(false) + "&7You are now in the &eCreative-Mode&7!");

        LanguageSystemAPI.addMessage(gameModeAdventure,
                LanguageSystemAPI.getPrefix(false) + "&7Du bist nun im &eAbenteuer-Modus&7!",
                LanguageSystemAPI.getPrefix(false) + "&7You are now in the &eAdventure-Mode&7!");

        LanguageSystemAPI.addMessage(gameModeSpectator,
                LanguageSystemAPI.getPrefix(false) + "&7Du bist nun im &eZuschauer-Modus&7!",
                LanguageSystemAPI.getPrefix(false) + "&7You are now in the &eSpectator-Mode&7!");

        LanguageSystemAPI.addMessage(flyModeDisabled,
                LanguageSystemAPI.getPrefix(false) + "&7Der Flugmodus wurde &cdeaktiviert&7!",
                LanguageSystemAPI.getPrefix(false) + "&7The Fly-Mode was &cidisabled&7!");

        LanguageSystemAPI.addMessage(flyModeEnabled,
                LanguageSystemAPI.getPrefix(false) + "&7Der Flugmodus wurde &aaktiviert&7!",
                LanguageSystemAPI.getPrefix(false) + "&7The Fly-Mode was &aenabled&7!");

        LanguageSystemAPI.addMessage(flyModeDisabledOther,
                LanguageSystemAPI.getPrefix(false) + "&7Du hast den Flugmodus für den Spieler &cdeaktiviert&7!",
                LanguageSystemAPI.getPrefix(false) + "&7You have &cidisabeld &7flightmode for the player!");

        LanguageSystemAPI.addMessage(flyModeEnabledOther,
                LanguageSystemAPI.getPrefix(false) + "&7Du hast den Flugmodus für den Spieler &aaktiviert&7!",
                LanguageSystemAPI.getPrefix(false) + "&Y7ou have &aenabeld &7flightmode for the player!");

        LanguageSystemAPI.addMessage(flySpeedChanged,
                LanguageSystemAPI.getPrefix(false) + "&7Deine Fluggeschwindigkeit wurde auf &e%speed% &7gesetzt!",
                LanguageSystemAPI.getPrefix(false) + "&7Your Flyspeed was set to &e%speed%!");

        LanguageSystemAPI.addMessage(walkSpeedChanged,
                LanguageSystemAPI.getPrefix(false) + "&7Deine Geschwindigkeit wurde auf &e%speed% &7gesetzt!",
                LanguageSystemAPI.getPrefix(false) + "&7Your Speed was set to &e%speed%!");
    }
}
