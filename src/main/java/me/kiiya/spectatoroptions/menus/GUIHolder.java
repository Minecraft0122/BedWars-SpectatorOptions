package me.kiiya.spectatoroptions.menus;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public interface GUIHolder extends InventoryHolder {
    void onClick(InventoryClickEvent e);
}
