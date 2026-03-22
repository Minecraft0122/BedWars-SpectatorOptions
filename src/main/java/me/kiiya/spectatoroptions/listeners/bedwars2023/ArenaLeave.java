package me.kiiya.spectatoroptions.listeners.bedwars2023;

import com.tomkeuper.bedwars.api.events.player.PlayerLeaveArenaEvent;
import me.kiiya.spectatoroptions.SpectatorOptions;
import me.kiiya.spectatoroptions.player.CachedOptions;
import me.kiiya.spectatoroptions.player.SpectatorManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ArenaLeave implements Listener {
    @EventHandler
    public void onArenaLeave(PlayerLeaveArenaEvent e) {
        Player p = e.getPlayer();

        if (!e.isSpectator()) return;
        if (!p.getActivePotionEffects().isEmpty()) {
            Bukkit.getScheduler().runTaskLater(SpectatorOptions.getInstance(), () -> {
                p.getActivePotionEffects().forEach(potionEffect -> p.removePotionEffect(potionEffect.getType()));
            }, 20L);
        }

        CachedOptions cachedOptions = SpectatorManager.getInstance().getCachedOptions(p);
        if (cachedOptions == null) return;
        cachedOptions.setFollowingPlayer(null);
        cachedOptions.setLastFollowingPlayer(null);

        if (cachedOptions.getFollowingTaskId() != -1) {
            Bukkit.getScheduler().cancelTask(cachedOptions.getFollowingTaskId());
            cachedOptions.setFollowingTaskId(-1);
        }
    }
}
