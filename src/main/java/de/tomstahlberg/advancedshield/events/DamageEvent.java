package de.tomstahlberg.advancedshield.events;

import de.tomstahlberg.advancedshield.AdvancedShield;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {

    @EventHandler
    public void onPlayerGetsDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            int level = AdvancedShield.playerdata.getInt(player.getUniqueId().toString());
            if(
                    event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK ||
                    event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION ||
                    event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE
            ){
                double damage = event.getDamage();
                damage = damage-0.70*level/100*damage;

                player.damage(damage);
                event.setCancelled(true);
            }
        }
    }
}
