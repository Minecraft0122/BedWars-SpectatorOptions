package me.kiiya.spectatoroptions.player;

import org.bukkit.entity.Player;

public class SpectatorPlayer {
    private final Player p;
    private final CachedOptions cachedOptions;

    protected SpectatorPlayer(Player p) {
        this.p = p;
        cachedOptions = new CachedOptions(p);
    }

    public Player getPlayer() {
        return p;
    }

    public CachedOptions getCachedOptions() {
        return cachedOptions;
    }

    public void clearCachedOptions() {
        cachedOptions.destroy();
    }

    public void destroy() {
        clearCachedOptions();
    }

}
