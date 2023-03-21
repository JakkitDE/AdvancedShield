package de.tomstahlberg.advancedshield.configurator;

import de.tomstahlberg.advancedshield.AdvancedShield;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configurator {
    private File playerdataFile = new File(AdvancedShield.plugin.getDataFolder(), "playerdata.yml");
    private FileConfiguration playerdata;

    public Configurator() throws IOException {
        createIfNotExists();
    }

    private void createIfNotExists() throws IOException {
        if(playerdataFile.exists()){
            playerdata = YamlConfiguration.loadConfiguration(playerdataFile);
        }else{
            playerdata = new YamlConfiguration();
            playerdata.save(playerdataFile);
        }
    }

    public FileConfiguration getConfig(){
        return this.playerdata;
    }
    public void saveConfig() throws IOException {
        this.playerdata.save(this.playerdataFile);
    }
}

