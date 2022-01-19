package com.vanillapractice.net.perplayerkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class KitManager {

    public static boolean savekit(UUID uuid, int slot){

        if(Bukkit.getPlayer(uuid)!=null) {
            Player player = Bukkit.getPlayer(uuid);
            if (player != null) {


             //   ItemStack[] items = player.getInventory().getContents();
             //   Main.data.put(uuid.toString()+slot,items);
                boolean notEmpty=false;
                for(ItemStack i: player.getInventory().getContents()){
                    if(i!=null) {
                        if(!notEmpty) {
                            notEmpty = true;
                        }
                    }
                }

                if(notEmpty) {
                    Main.data.put(uuid.toString() + slot, player.getInventory().getContents());

                    return true;
                }else{
                    player.sendMessage(ChatColor.RED+"You cant save an empty kit!");
                }
            }
        }
return false;
    }

    public static boolean loadkit(UUID uuid, int slot){

        if(Bukkit.getPlayer(uuid)!=null) {
            Player player = Bukkit.getPlayer(uuid);
            if (player != null) {
               // ItemStack[] items = Main.data.get(uuid.toString()+slot);
              // player.getInventory().setContents(items);
                if(Main.data.get(uuid.toString()+slot)!=null){
                player.getInventory().setContents(Main.data.get(uuid.toString()+slot));
               return true;
                }
                else{
                    player.sendMessage(ChatColor.RED+"Kit "+slot+" does not exist!");
                }
            }
        }
        return false;
    }
}
