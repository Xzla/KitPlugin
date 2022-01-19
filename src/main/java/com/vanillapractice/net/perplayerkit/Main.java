package com.vanillapractice.net.perplayerkit;

import com.vanillapractice.net.perplayerkit.testcommands.KitCommand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Main extends JavaPlugin {
    public static HashMap<String, ItemStack[]> data = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("kit").setExecutor(new KitCommand());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
