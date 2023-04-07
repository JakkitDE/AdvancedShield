package de.tomstahlberg.advancedshield.functions;

import de.tomstahlberg.advancedshield.AdvancedShield;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PlaceHolderSet extends PlaceholderExpansion {
    private Plugin plugin;
    @Override
    public String getIdentifier() {
        return "player_shield";
    }

    @Override
    public String getAuthor() {
        return "kadnick";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    public PlaceHolderSet(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("player_shield")) {
            return String.valueOf(getPlayerShieldAmount(player));
        }

        return null; // Placeholder is unknown by the Expansion
    }
    private int getPlayerShieldAmount(OfflinePlayer player){
        return AdvancedShield.playerdata.getInt(player.getUniqueId().toString());
    }
}

