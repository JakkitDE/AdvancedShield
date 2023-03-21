package de.tomstahlberg.advancedshield.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ShieldItem {
    ItemStack itemStack;


    public ShieldItem(){
        setItemStack();
    }
    private void setItemStack(){
        ItemStack itemStack = new ItemStack(Material.SHIELD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&lBonus Schild"));

        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Rechtsklick zum Einlösen."));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Du kannst maximal &e100"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&eSchild &7besitzen."));

        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);

        this.itemStack = itemStack;
    }

    public ItemStack getShieldItem(){
        return this.itemStack;
    }

    public boolean isShieldItem(ItemStack itemStack){
        if(this.itemStack.isSimilar(itemStack)){
            return true;
        }else{
            return false;
        }
    }
}
