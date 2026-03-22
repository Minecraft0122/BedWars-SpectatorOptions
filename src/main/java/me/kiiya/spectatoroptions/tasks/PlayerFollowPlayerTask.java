package me.kiiya.spectatoroptions.tasks;

import me.kiiya.spectatoroptions.player.CachedOptions;
import me.kiiya.spectatoroptions.player.SpectatorManager;
import org.bukkit.entity.Player;

public class PlayerFollowPlayerTask implements Runnable {
    private final Player p;
    private final Player target;
    public PlayerFollowPlayerTask(Player p, Player target) {
        this.p = p;
        this.target = target;
    }
    @Override
    public void run() {
        if (p == null || target == null) return;

        CachedOptions cachedOptions = SpectatorManager.getInstance().getCachedOptions(p);
        if (cachedOptions == null) return;
        if (cachedOptions.getFollowingPlayer() == null) return;
        if (cachedOptions.getFollowingPlayer() != target) return;
        if (cachedOptions.isFirstPerson()) return;

        if (p.isOnline() && target.isOnline()) {
            if (p.getWorld() != target.getWorld()) return;
            p.teleport(target);
        }
    }
}
