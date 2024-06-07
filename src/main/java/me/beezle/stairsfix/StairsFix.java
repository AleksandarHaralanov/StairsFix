package me.beezle.stairsfix;

import org.bukkit.plugin.java.JavaPlugin;

public class StairsFix extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockHandler(), this);
        System.out.print("[StairsFix v1.0.0] Enabled.");
    }

    @Override
    public void onDisable() {
        System.out.print("[StairsFix v1.0.0] Disabled.");
    }
}
