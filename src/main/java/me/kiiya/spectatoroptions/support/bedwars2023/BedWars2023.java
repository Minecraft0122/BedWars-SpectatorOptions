package me.kiiya.spectatoroptions.support.bedwars2023;

import com.tomkeuper.bedwars.api.BedWars;
import me.kiiya.spectatoroptions.SpectatorOptions;
import me.kiiya.spectatoroptions.support.Support;
import org.bukkit.Bukkit;

import static me.kiiya.spectatoroptions.SpectatorOptions.bedWars2023API;

public class BedWars2023 {
    private final SpectatorOptions p = SpectatorOptions.getInstance();
    public BedWars2023() {
        start();
    }

    private void start() {
        p.setSupport(Support.BEDWARS2023);
        bedWars2023API = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();
        bedWars2023API.getAddonsUtil().registerAddon(new SpectatorOptionsAddon());
    }
}
