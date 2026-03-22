package me.kiiya.spectatoroptions.support.bedwars2023;

import com.tomkeuper.bedwars.api.addon.Addon;
import me.kiiya.spectatoroptions.SpectatorOptions;
import me.kiiya.spectatoroptions.configuration.MainConfig;
import me.kiiya.spectatoroptions.configuration.bedwars2023.MessagesData;
import me.kiiya.spectatoroptions.listeners.bedwars2023.ArenaJoin;
import me.kiiya.spectatoroptions.listeners.bedwars2023.ArenaLeave;
import me.kiiya.spectatoroptions.listeners.bedwars2023.PlayerKill;
import me.kiiya.spectatoroptions.listeners.bedwars2023.SpectateEvent;
import me.kiiya.spectatoroptions.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import static me.kiiya.spectatoroptions.SpectatorOptions.bedWars2023API;

public class SpectatorOptionsAddon extends Addon {
    @Override
    public String getAuthor() {
        return SpectatorOptions.getInstance().getDescription().getAuthors().get(0);
    }

    @Override
    public Plugin getPlugin() {
        return SpectatorOptions.getInstance();
    }

    @Override
    public String getVersion() {
        return SpectatorOptions.getInstance().getDescription().getVersion();
    }

    @Override
    public String getName() {
        return "SpectatorOptions";
    }

    @Override
    public String getDescription() {
        return SpectatorOptions.getInstance().getDescription().getDescription();
    }

    @Override
    public void load() {
        Utils.log("&6&m--------------------------------");
        Utils.log("&aSpectatorOptions by &eKiiya");
        Utils.log("&aVersion: &e" + getVersion());
        Utils.log("&6&m--------------------------------");
        loadConfig();
        loadListeners();
    }

    @Override
    public void unload() {
        Bukkit.getPluginManager().disablePlugin(getPlugin());
    }

    private void loadListeners() {
        Utils.log("&eLoading listeners...");
        Bukkit.getPluginManager().registerEvents(new ArenaJoin(), getPlugin());
        Bukkit.getPluginManager().registerEvents(new ArenaLeave(), getPlugin());
        Bukkit.getPluginManager().registerEvents(new SpectateEvent(), getPlugin());
        Bukkit.getPluginManager().registerEvents(new PlayerKill(), getPlugin());
        Utils.log("&aListeners loaded!");
    }

    private void loadConfig() {
        Utils.log("&eLoading config...");
        SpectatorOptions.getInstance().mainConfig = new MainConfig(getPlugin(), "config", bedWars2023API.getAddonsPath() + "/SpectatorOptions");
        Utils.log("&aConfig loaded!");
        Utils.log("&eLoading messages...");
        new MessagesData();
        Utils.log("&aMessages loaded!");
    }
}
