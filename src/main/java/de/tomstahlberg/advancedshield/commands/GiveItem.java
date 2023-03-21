package de.tomstahlberg.advancedshield.commands;

import de.tomstahlberg.advancedshield.item.ShieldItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.Executor;

public class GiveItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender.hasPermission("shield.give") || commandSender.isOp()){
            if(args.length == 3){
                if(args[0].equalsIgnoreCase("give")){
                    try{
                        Player player = Bukkit.getPlayer(args[1]);
                        for(int i = 0;i<Integer.valueOf(args[2]); i++){
                            player.getInventory().addItem(new ShieldItem().getShieldItem());
                        }
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &aDer Spieler hat &e"+args[2]+"x &adas Schild Item erhalten."));
                    }catch(Exception e){
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cDer Spieler existiert nicht oder ist nicht online."));
                    }

                }else{
                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &e/shield give <name> <anzahl>"));
                }
            }else{
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &e/shield give <name> <anzahl>"));
            }
        }


        return false;
    }
}
