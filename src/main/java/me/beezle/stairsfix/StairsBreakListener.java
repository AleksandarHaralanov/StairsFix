package me.beezle.stairsfix;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class StairsBreakListener implements Listener {

    @EventHandler
    public void onStairsBreak(final BlockBreakEvent event) {
        byte value = 3;
        if (event.getBlock().getData() <= value) {
            switch (event.getBlock().getType()) {
                case WOOD_STAIRS:
                    event.setCancelled(true);
                    event.getBlock().getWorld().getBlockAt(event.getBlock().getLocation()).setType(Material.AIR);
                    event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.WOOD_STAIRS, 1));
                    break;
                case COBBLESTONE_STAIRS:
                    if (isType(event.getPlayer().getItemInHand(), Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE, Material.GOLD_PICKAXE)) {
                        event.setCancelled(true);
                        event.getBlock().getWorld().getBlockAt(event.getBlock().getLocation()).setType(Material.AIR);
                        event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COBBLESTONE_STAIRS, 1));
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public boolean isType(ItemStack itemStack, Material... materials) {
        for (Material mat : materials) {
            if (itemStack.getType() == mat) {
                return true;
            }
        }
        return false;
    }
}
