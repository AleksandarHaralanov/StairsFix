package me.beezle.stairsfix;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class StairsFix extends JavaPlugin
{
    public void onEnable()
    {
        Bukkit.getServer().getPluginManager().registerEvents(new BlockHandler(), this);
        System.out.print("[StairsFix] Enabled.");
    }

    public void onDisable()
    {
        System.out.print("[StairsFix] Disabled.");
    }
}
