package de.tomstahlberg.advancedshield.timer;

import de.tomstahlberg.advancedshield.AdvancedShield;
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
                    int shield = AdvancedShield.playerdata.getInt(player.getUniqueId().toString());
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',"&8\uD83D\uDEE1 &7"+shield+" &8\uD83D\uDEE1")));
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
