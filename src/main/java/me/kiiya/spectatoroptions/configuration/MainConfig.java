package me.kiiya.spectatoroptions.configuration;

import me.kiiya.spectatoroptions.SpectatorOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import static me.kiiya.spectatoroptions.configuration.paths.ConfigPaths.*;

public class MainConfig extends ConfigManager {

    public MainConfig(Plugin plugin, String name, String dir) {
        super(plugin, name, dir);
        YamlConfiguration yml = getYml();
        yml.options().header("SpectatorOptions by Kiiya\n" +
                "--------------------------------\n" +
                "BedWars: " + SpectatorOptions.getInstance().getSupport() + "\n" +
                "Support: https://discord.gg/n5yNavRvrP\n" +
                "Version: " + plugin.getDescription().getVersion() + "\n" +
                "--------------------------------\n");

        // Options menu item
        yml.addDefault("options-item.material", "REDSTONE_COMPARATOR");
        yml.addDefault("options-item.amount", 1);
        yml.addDefault("options-item.data", 0);
        yml.addDefault("options-item.enchanted", false);
        yml.addDefault("options-item.skull-url", "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault("options-item.slot", 4);

        // Toggle options
        yml.addDefault(ENABLE_NO_SPEED, true);
        yml.addDefault(ENABLE_SPEED_I, true);
        yml.addDefault(ENABLE_SPEED_II, true);
        yml.addDefault(ENABLE_SPEED_III, true);
        yml.addDefault(ENABLE_SPEED_IV, true);
        yml.addDefault(ENABLE_AUTOTELEPORT, true);
        yml.addDefault(ENABLE_NIGHT_VISION, true);
        yml.addDefault(ENABLE_FIRST_PERSON, true);
        yml.addDefault(ENABLE_TOGGLE_SPECTATORS, true);

        // Options menu contents
        yml.addDefault(OPTIONS_MENU_ROWS, 4);
        yml.addDefault(OPTIONS_MENU_ITEM_NO_SPEED_MATERIAL, "LEATHER_BOOTS");
        yml.addDefault(OPTIONS_MENU_ITEM_NO_SPEED_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_NO_SPEED_SLOT, 11);
        yml.addDefault(OPTIONS_MENU_ITEM_NO_SPEED_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_I_MATERIAL, "CHAINMAIL_BOOTS");
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_I_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_I_SLOT, 12);
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_I_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_II_MATERIAL, "IRON_BOOTS");
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_II_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_II_SLOT, 13);
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_II_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_III_MATERIAL, "GOLD_BOOTS");
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_III_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_III_SLOT, 14);
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_III_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_IV_MATERIAL, "DIAMOND_BOOTS");
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_IV_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_IV_SLOT, 15);
        yml.addDefault(OPTIONS_MENU_ITEM_SPEED_IV_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_AUTOTELEPORT_SLOT, 20);
        yml.addDefault(OPTIONS_MENU_ITEM_AUTOTELEPORT_ENABLED_MATERIAL, "COMPASS");
        yml.addDefault(OPTIONS_MENU_ITEM_AUTOTELEPORT_ENABLED_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_AUTOTELEPORT_ENABLED_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_AUTOTELEPORT_DISABLED_MATERIAL, "COMPASS");
        yml.addDefault(OPTIONS_MENU_ITEM_AUTOTELEPORT_DISABLED_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_AUTOTELEPORT_DISABLED_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_NIGHT_VISION_SLOT, 21);
        yml.addDefault(OPTIONS_MENU_ITEM_NIGHT_VISION_ENABLED_MATERIAL, "EYE_OF_ENDER");
        yml.addDefault(OPTIONS_MENU_ITEM_NIGHT_VISION_ENABLED_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_NIGHT_VISION_ENABLED_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_NIGHT_VISION_DISABLED_MATERIAL, "ENDER_PEARL");
        yml.addDefault(OPTIONS_MENU_ITEM_NIGHT_VISION_DISABLED_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_NIGHT_VISION_DISABLED_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_FIRST_PERSON_SLOT, 23);
        yml.addDefault(OPTIONS_MENU_ITEM_FIRST_PERSON_ENABLED_MATERIAL, "WATCH");
        yml.addDefault(OPTIONS_MENU_ITEM_FIRST_PERSON_ENABLED_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_FIRST_PERSON_ENABLED_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_FIRST_PERSON_DISABLED_MATERIAL, "WATCH");
        yml.addDefault(OPTIONS_MENU_ITEM_FIRST_PERSON_DISABLED_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_FIRST_PERSON_DISABLED_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_SLOT, 24);
        yml.addDefault(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_ENABLED_MATERIAL, "REDSTONE");
        yml.addDefault(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_ENABLED_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_ENABLED_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.addDefault(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_DISABLED_MATERIAL, "GLOWSTONE_DUST");
        yml.addDefault(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_DISABLED_DATA, 0);
        yml.addDefault(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_DISABLED_SKULL_URL, "http://textures.minecraft.net/texture/<yourValue>");
        yml.options().copyDefaults(true);
        save();
    }
}
