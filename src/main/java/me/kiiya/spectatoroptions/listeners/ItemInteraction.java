package me.kiiya.spectatoroptions.listeners;

import me.kiiya.spectatoroptions.menus.OptionsMenu;
import me.kiiya.spectatoroptions.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static me.kiiya.spectatoroptions.configuration.paths.MessagePaths.*;

public class ItemInteraction implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        ItemStack item = e.getItem();
        if (item == null) return;
        if (item.getType() == null || item.getType().name().equals("AIR")) return;
        if (item.getItemMeta() == null) return;
        if (item.getItemMeta().getDisplayName() == null) return;

        if (item.getItemMeta().getDisplayName().equals(Utils.getMsg(e.getPlayer(), SPECTATOR_OPTIONS_ITEM_NAME))) {
            e.setCancelled(true);
            new OptionsMenu(e.getPlayer());
        }
    }
}
