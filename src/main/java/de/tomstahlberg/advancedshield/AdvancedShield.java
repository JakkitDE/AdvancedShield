package de.tomstahlberg.advancedshield;

import de.tomstahlberg.advancedshield.commands.GiveItem;
import de.tomstahlberg.advancedshield.configurator.Configurator;
import de.tomstahlberg.advancedshield.events.DamageEvent;
import de.tomstahlberg.advancedshield.events.InteractEvent;
import de.tomstahlberg.advancedshield.events.PlayerJoin;
import de.tomstahlberg.advancedshield.timer.Timer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class AdvancedShield extends JavaPlugin {
    public static Plugin plugin;
    public static FileConfiguration playerdata;
    public static Configurator configurator;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new DamageEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new InteractEvent(), this);

        getServer().getPluginCommand("shield").setExecutor(new GiveItem());
        Timer.startTimer();
        Timer.startBackupTimer();
        try {
            configurator = new Configurator();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        playerdata = configurator.getConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        try {
            configurator.saveConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
