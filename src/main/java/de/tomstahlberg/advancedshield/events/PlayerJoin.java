package de.tomstahlberg.advancedshield.events;

import de.tomstahlberg.advancedshield.AdvancedShield;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.*;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',"&8\uD83D\uDEE1 &7lädt ... &8\uD83D\uDEE1")));
        if(!(AdvancedShield.playerdata.contains(player.getUniqueId().toString()))){
            AdvancedShield.playerdata.set(player.getUniqueId().toString(), 0);
        }
    }
}
