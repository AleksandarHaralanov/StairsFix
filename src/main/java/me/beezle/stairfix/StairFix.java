package me.beezle.stairfix;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class StairFix extends JavaPlugin
{
    public void onEnable()
    {
        Bukkit.getServer().getPluginManager().registerEvents(new BlockHandler(), this);
        System.out.println("[StairFix] Enabled.");
    }

    public void onDisable()
    {
        System.out.println("[StairFix] Disabled.");
    }
}
