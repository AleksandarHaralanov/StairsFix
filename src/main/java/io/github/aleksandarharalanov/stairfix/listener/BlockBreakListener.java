package io.github.aleksandarharalanov.stairfix.listener;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.getServer;

public class BlockBreakListener extends BlockListener {

    public void onBlockBreak(final BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (block.getType() != Material.COBBLESTONE_STAIRS && block.getType() != Material.WOOD_STAIRS) return;
        if (block.getData() > (byte) 3) return;

        if (block.getType() == Material.COBBLESTONE_STAIRS) {
            ItemStack itemInHand = player.getInventory().getItemInHand();
            if (itemInHand == null || !itemInHand.getType().toString().contains("PICKAXE")) return;
        }

        event.setCancelled(true);
        Material correctDrop = block.getType() == Material.WOOD_STAIRS ? Material.WOOD_STAIRS : Material.COBBLESTONE_STAIRS;

        // Check if WorldGuard is present and player can build in the region the stairs block is located
        WorldGuardPlugin worldGuard = (WorldGuardPlugin) getServer().getPluginManager().getPlugin("WorldGuard");
        if (worldGuard != null && worldGuard.isEnabled()) {
            if (worldGuard.canBuild(player, block.getLocation())) {
                block.setType(Material.AIR);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(correctDrop, 1));
            } else player.sendMessage(ChatColor.DARK_RED + "You don't have permission for this area.");
            return;
        }

        // If WorldGuard is not present, process normally
        block.setType(Material.AIR);
        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(correctDrop, 1));
    }
}
