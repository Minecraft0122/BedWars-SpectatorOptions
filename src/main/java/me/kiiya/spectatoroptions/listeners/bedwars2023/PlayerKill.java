package me.kiiya.spectatoroptions.listeners.bedwars2023;

import com.tomkeuper.bedwars.api.events.player.PlayerKillEvent;
import me.kiiya.spectatoroptions.SpectatorOptions;
import me.kiiya.spectatoroptions.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PlayerKill implements Listener {
    @EventHandler
    public void onPlayerKill(PlayerKillEvent e) {
        Player p = e.getVictim();
        ItemStack item = Utils.getOptionsItem(p);
        int slot = SpectatorOptions.getInstance().getMainConfig().getInt("options-item.slot");

        if (!e.getCause().isFinalKill()) return;
        if (!p.hasPermission("bw.spectatoroptions")) return;

        Bukkit.getScheduler().runTaskLater(SpectatorOptions.getInstance(), () -> {
            if (slot == -1) return;
            p.getInventory().setItem(slot, item);
        }, 20L);
    }
}
