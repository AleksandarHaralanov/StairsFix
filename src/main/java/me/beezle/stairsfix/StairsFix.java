package me.beezle.stairsfix;

import org.bukkit.plugin.java.JavaPlugin;

public class StairsFix extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockHandler(), this);
        System.out.print("[StairsFix] Enabled.");
    }

    @Override
    public void onDisable() {
        System.out.print("[StairsFix] Disabled.");
    }
}
