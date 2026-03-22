package me.kiiya.spectatoroptions.listeners.bedwars2023;

import com.tomkeuper.bedwars.BedWars;
import com.tomkeuper.bedwars.api.events.spectator.SpectatorTeleportToPlayerEvent;
import me.kiiya.spectatoroptions.SpectatorOptions;
import me.kiiya.spectatoroptions.player.CachedOptions;
import me.kiiya.spectatoroptions.player.SpectatorManager;
import me.kiiya.spectatoroptions.tasks.PlayerFollowPlayerTask;
import me.kiiya.spectatoroptions.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SpectateEvent implements Listener {
    @EventHandler
    public void onTeleport(SpectatorTeleportToPlayerEvent e) {
        Player p = e.getSpectator();
        Player target = e.getTarget();

        CachedOptions cachedOptions = SpectatorManager.getInstance().getCachedOptions(p);
        if (cachedOptions == null) return;

        if (cachedOptions.isFirstPerson()) {
            p.setGameMode(GameMode.SPECTATOR);
            p.setSpectatorTarget(target);
            BedWars.nms.sendTitle(p, Utils.getMsg(p, "spectator-first-person-enter-title").replace("%bw_player%", target.getDisplayName()), Utils.getMsg(p, "spectator-first-person-enter-subtitle").replace("{player}", target.getDisplayName()), 0, 20, 0);
            cachedOptions.setFollowingPlayer(null);
            if (cachedOptions.getFollowingTaskId() != -1) {
                Bukkit.getScheduler().cancelTask(cachedOptions.getFollowingTaskId());
                cachedOptions.setFollowingTaskId(-1);
            }
            return;
        }

        if (cachedOptions.isAutoTeleport()) {
            cachedOptions.setFollowingPlayer(target);

            if (target != cachedOptions.getLastFollowingPlayer()) {
                cachedOptions.setLastFollowingPlayer(null);
                if (cachedOptions.getFollowingTaskId() != -1) {
                    Bukkit.getScheduler().cancelTask(cachedOptions.getFollowingTaskId());
                    cachedOptions.setFollowingTaskId(-1);
                }
                return;
            }

            if (cachedOptions.getFollowingTaskId() != -1) {
                Bukkit.getScheduler().cancelTask(cachedOptions.getFollowingTaskId());
                cachedOptions.setFollowingTaskId(-1);
            }

            int followTaskId = Bukkit.getScheduler().runTaskTimerAsynchronously(SpectatorOptions.getInstance(), new PlayerFollowPlayerTask(p, cachedOptions.getFollowingPlayer()), 0, 60L).getTaskId();
            cachedOptions.setFollowingTaskId(followTaskId);
        }
    }
}
