package me.kiiya.spectatoroptions;

import com.tomkeuper.bedwars.api.BedWars;
import me.kiiya.spectatoroptions.commands.OptionsMenuCommand;
import me.kiiya.spectatoroptions.configuration.MainConfig;
import me.kiiya.spectatoroptions.listeners.InventoryInteraction;
import me.kiiya.spectatoroptions.listeners.ItemInteraction;
import me.kiiya.spectatoroptions.player.SpectatorManager;
import me.kiiya.spectatoroptions.support.Support;
import me.kiiya.spectatoroptions.support.bedwars1058.BedWars1058;
import me.kiiya.spectatoroptions.support.bedwars2023.BedWars2023;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpectatorOptions extends JavaPlugin {

    private static SpectatorOptions instance;
    private Support support;
    public MainConfig mainConfig;
    public static BedWars bedWars2023API;
    public static com.andrei1058.bedwars.api.BedWars bedWars1058API;
    private boolean disabled = false;

    @Override
    public void onEnable() {
        instance = this;
        SpectatorManager.init();

        loadSupport();
        if (disabled) return;
        loadListeners();
        loadCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadSupport() {
        if (getServer().getPluginManager().getPlugin("BedWars1058") != null) {
            new BedWars1058();
        } else if (getServer().getPluginManager().getPlugin("BedWars2023") != null) {
            new BedWars2023();
        } else {
            getLogger().severe("BedWars1058 or BedWars2023 not found! Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
            disabled = true;
        }
    }

    private void loadListeners() {
        getServer().getPluginManager().registerEvents(new InventoryInteraction(), this);
        getServer().getPluginManager().registerEvents(new ItemInteraction(), this);
    }

    private void loadCommands() {
        getCommand("bwso").setExecutor(new OptionsMenuCommand());
    }

    public static SpectatorOptions getInstance() {
        return instance;
    }

    public BedWars getBedWars2023API() {
        return bedWars2023API;
    }

    public com.andrei1058.bedwars.api.BedWars getBedWars1058API() {
        return bedWars1058API;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public Support getSupport() {
        return support;
    }

    public MainConfig getMainConfig() {
        return mainConfig;
    }
}
