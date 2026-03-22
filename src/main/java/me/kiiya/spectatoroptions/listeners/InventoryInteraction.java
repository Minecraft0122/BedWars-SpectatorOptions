package me.kiiya.spectatoroptions.listeners;

import me.kiiya.spectatoroptions.menus.GUIHolder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryInteraction implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) return;
        if (e.getClickedInventory().getHolder() == null) return;
        if (e.getWhoClicked() == null) return;
        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if (e.getClickedInventory().getHolder() instanceof GUIHolder) {
            e.setCancelled(true);
            ((GUIHolder) e.getClickedInventory().getHolder()).onClick(e);
        }
    }
}
