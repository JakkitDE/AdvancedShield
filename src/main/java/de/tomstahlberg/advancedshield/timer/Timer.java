package de.tomstahlberg.advancedshield.timer;

import de.tomstahlberg.advancedshield.AdvancedShield;
import de.tomstahlberg.advancedshield.functions.PlaceHolderSet;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Timer {
    public static void startTimer(){
        Bukkit.getScheduler().runTaskTimer(AdvancedShield.plugin, new Runnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()){

                    PlaceHolderSet placeHolderSet = new PlaceHolderSet(AdvancedShield.plugin);
                    placeHolderSet.onRequest(player, "player_shield");

                    String timerText = PlaceholderAPI.setPlaceholders(player, "%player_shield% %advancedshield_player_shield% ist dein Shield.");
                    player.sendMessage(timerText);
                }
            }
        }, 40, 40);
    }

    public static void startBackupTimer(){
        Bukkit.getScheduler().runTaskTimer(AdvancedShield.plugin, new Runnable() {
            @Override
            public void run() {
                try {
                    AdvancedShield.configurator.saveConfig();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 6000, 6000);
    }
}
