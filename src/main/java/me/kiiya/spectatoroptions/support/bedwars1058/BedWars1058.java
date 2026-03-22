package me.kiiya.spectatoroptions.support.bedwars1058;

import me.kiiya.spectatoroptions.SpectatorOptions;
import me.kiiya.spectatoroptions.configuration.MainConfig;
import me.kiiya.spectatoroptions.configuration.bedwars1058.MessagesData;
import me.kiiya.spectatoroptions.listeners.bedwars1058.ArenaJoin;
import me.kiiya.spectatoroptions.listeners.bedwars1058.ArenaLeave;
import me.kiiya.spectatoroptions.listeners.bedwars1058.PlayerKill;
import me.kiiya.spectatoroptions.listeners.bedwars1058.SpectateEvent;
import me.kiiya.spectatoroptions.support.Support;
import me.kiiya.spectatoroptions.utils.Utils;
import org.bukkit.Bukkit;

import static me.kiiya.spectatoroptions.SpectatorOptions.bedWars1058API;

public class BedWars1058 {
    private final SpectatorOptions p = SpectatorOptions.getInstance();
    public BedWars1058() {
        start();
    }

    private void start() {
        p.setSupport(Support.BEDWARS1058);
        bedWars1058API = Bukkit.getServicesManager().getRegistration(com.andrei1058.bedwars.api.BedWars.class).getProvider();
        Utils.log("&6&m--------------------------------");
        Utils.log("&aSpectatorOptions by &eKiiya");
        Utils.log("&aVersion: &e" + p.getDescription().getVersion());
        Utils.log("&6&m--------------------------------");
        loadConfig();
        loadListeners();
    }

    private void loadConfig() {
        Utils.log("&eLoading config...");
        SpectatorOptions.getInstance().mainConfig = new MainConfig(p, "config", bedWars1058API.getAddonsPath() + "/SpectatorOptions");
        Utils.log("&aConfig loaded!");
        Utils.log("&eLoading messages...");
        new MessagesData();
        Utils.log("&aMessages loaded!");
    }

    private void loadListeners() {
        Utils.log("&eLoading listeners...");
        Bukkit.getPluginManager().registerEvents(new ArenaJoin(), p);
        Bukkit.getPluginManager().registerEvents(new ArenaLeave(), p);
        Bukkit.getPluginManager().registerEvents(new SpectateEvent(), p);
        Bukkit.getPluginManager().registerEvents(new PlayerKill(), p);
        Utils.log("&aListeners loaded!");
    }
}
