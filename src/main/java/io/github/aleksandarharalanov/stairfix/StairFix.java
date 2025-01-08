package io.github.aleksandarharalanov.stairfix;

import io.github.aleksandarharalanov.stairfix.listener.BlockBreakListener;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static io.github.aleksandarharalanov.stairfix.util.LoggerUtil.logInfo;
import static io.github.aleksandarharalanov.stairfix.util.UpdateUtil.checkForUpdates;

public class StairFix extends JavaPlugin {

    @Override
    public void onEnable() {
        checkForUpdates(this, "https://api.github.com/repos/AleksandarHaralanov/StairFix/releases/latest");

        PluginManager pluginManager = getServer().getPluginManager();
        final BlockBreakListener blockBreakListener = new BlockBreakListener();
        pluginManager.registerEvent(Event.Type.BLOCK_BREAK, blockBreakListener, Event.Priority.Normal, this);

        logInfo(String.format("[%s] v%s Enabled.", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        logInfo(String.format("[%s] v%s Disabled.", getDescription().getName(), getDescription().getVersion()));
    }
}