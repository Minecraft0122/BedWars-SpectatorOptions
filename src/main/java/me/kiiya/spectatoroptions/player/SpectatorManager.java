package me.kiiya.spectatoroptions.player;

import me.kiiya.spectatoroptions.SpectatorOptions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class SpectatorManager implements Listener {
    private static SpectatorManager instance;
    private final HashMap<Player, SpectatorPlayer> spectatorPlayers;
    private SpectatorManager() {
        instance = this;
        spectatorPlayers = new HashMap<>();
    }
    public static void init() {
        new SpectatorManager();
        Bukkit.getPluginManager().registerEvents(instance, SpectatorOptions.getInstance());
    }
    public static SpectatorManager getInstance() {
        if (instance == null) new SpectatorManager();
        return instance;
    }

    public SpectatorPlayer getSpectatorPlayer(Player p) {
        if (!spectatorPlayers.containsKey(p)) {
            spectatorPlayers.put(p, new SpectatorPlayer(p));
        }
        return spectatorPlayers.get(p);
    }

    public CachedOptions getCachedOptions(Player p) {
        return getSpectatorPlayer(p).getCachedOptions();
    }

    public void destroySpectatorPlayer(Player p) {
        SpectatorPlayer sp = spectatorPlayers.remove(p);
        if (sp != null) {
            sp.destroy();
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        this.spectatorPlayers.put(e.getPlayer(), new SpectatorPlayer(e.getPlayer()));
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        destroySpectatorPlayer(e.getPlayer());
    }
}
