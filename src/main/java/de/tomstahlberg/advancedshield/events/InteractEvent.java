package de.tomstahlberg.advancedshield.events;

import de.tomstahlberg.advancedshield.AdvancedShield;
import de.tomstahlberg.advancedshield.item.ShieldItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(player.getInventory().getItemInMainHand().getType() != null && player.getInventory().getItemInMainHand().getType() == Material.SHIELD){
            if(new ShieldItem().isShieldItem(player.getInventory().getItemInMainHand())){
                int level = AdvancedShield.playerdata.getInt(player.getUniqueId().toString());
                if(level < 100){
                    level = level + 1;
                    AdvancedShield.playerdata.set(player.getUniqueId().toString(), level);
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &aDu hast &e+1 Schild &aerhalten."));
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cDu hast bereits dein maximales Schild erreicht."));
                }
                event.setCancelled(true);
            }
        }
    }
}
