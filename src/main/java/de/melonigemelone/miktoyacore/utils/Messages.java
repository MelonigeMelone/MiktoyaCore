package de.melonigemelone.miktoyacore.utils;

import de.melonigemelone.miktoyaapi.api.languagesystem.MultiLanguageMessage;

public class Messages {

    public static MultiLanguageMessage unknowCmd;

    public static MultiLanguageMessage vanishEnabled;
    public static MultiLanguageMessage vanishDisabled;

    public static void init() {
        unknowCmd = new MultiLanguageMessage("MiktoyaCore.UnknowCmd",
                "&8[&eMiktoya&8] &cDieser Befehl existiert nicht!",
                "&8[&eMiktoya&8] &cThis command doesnt exist!");

    }


}
