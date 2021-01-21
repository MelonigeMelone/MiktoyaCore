package de.melonigemelone.miktoyacore.utils.model;

public class CoreData {

    private boolean coinsSystemEnabled;
    private boolean economySystemEnabled;
    private boolean rbxSystemEnabled;

    public CoreData() {

    }

    public boolean isCoinsSystemEnabled() {
        return coinsSystemEnabled;
    }

    public void setCoinsSystemEnabled(boolean coinsSystemEnabled) {
        this.coinsSystemEnabled = coinsSystemEnabled;
    }

    public boolean isEconomySystemEnabled() {
        return economySystemEnabled;
    }

    public void setEconomySystemEnabled(boolean economySystemEnabled) {
        this.economySystemEnabled = economySystemEnabled;
    }

    public boolean isRbxSystemEnabled() {
        return rbxSystemEnabled;
    }

    public void setRbxSystemEnabled(boolean rbxSystemEnabled) {
        this.rbxSystemEnabled = rbxSystemEnabled;
    }
}
