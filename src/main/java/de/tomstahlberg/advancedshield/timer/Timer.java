package de.tomstahlberg.advancedshield.timer;

import de.tomstahlberg.advancedshield.AdvancedShield;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Timer {
    public static void startTimer(){
        Bukkit.getScheduler().runTaskTimer(AdvancedShield.plugin, new Runnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()){

                    String timerText = PlaceholderAPI.setPlaceholders(player, "%advancedshield_player_shield% ist dein Shield.");
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
