package me.kiiya.spectatoroptions.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.clip.placeholderapi.PlaceholderAPI;
import me.kiiya.spectatoroptions.SpectatorOptions;
import me.kiiya.spectatoroptions.configuration.MainConfig;
import me.kiiya.spectatoroptions.configuration.paths.MessagePaths;
import me.kiiya.spectatoroptions.support.Support;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Utils {
    public static String c(String var) {
        return ChatColor.translateAlternateColorCodes('&', var);
    }

    public static List<String> c(List<String> var) {
        return var.stream().map(Utils::c).collect(Collectors.toList());
    }

    public static String p(Player p, String var) {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            return c(PlaceholderAPI.setPlaceholders(p, var));
        }
        return c(var);
    }

    public static String getMsg(Player p, String path) {
        if (SpectatorOptions.getInstance().getSupport() == Support.BEDWARS1058)
            return p(p, SpectatorOptions.bedWars1058API.getPlayerLanguage(p).getString(path));
        else if (SpectatorOptions.getInstance().getSupport() == Support.BEDWARS2023)
            return p(p, SpectatorOptions.bedWars2023API.getPlayerLanguage(p).getString(path));
        else return "MISSING_MESSAGE";
    }

    public static List<String> getListMsg(Player p, String path) {
        if (SpectatorOptions.getInstance().getSupport() == Support.BEDWARS1058)
            return SpectatorOptions.bedWars1058API.getPlayerLanguage(p).getList(path).stream().map(s -> p(p, s)).collect(Collectors.toList());
        else if (SpectatorOptions.getInstance().getSupport() == Support.BEDWARS2023)
            return SpectatorOptions.bedWars2023API.getPlayerLanguage(p).getList(path).stream().map(s -> p(p, s)).collect(Collectors.toList());
        else return Arrays.asList("MISSING_MESSAGE");
    }

    public static void log(String var) {
        SpectatorOptions.getInstance().getLogger().info(c(var));
    }

    public static ItemStack getOptionsItem(Player p) {
    MainConfig con = SpectatorOptions.getInstance().getMainConfig();
    ItemStack item;
    String materialName = con.getString("options-item.material");

    // 处理配置缺失或无效材料
    if (materialName == null || materialName.isEmpty()) {
        Bukkit.getLogger().warning("[SpectatorOptions] 'options-item.material' is missing in config! Using COMPASS.");
        materialName = "COMPASS";
    }

    Material material = Material.getMaterial(materialName);
    if (material == null) {
        Bukkit.getLogger().warning("[SpectatorOptions] Invalid material: " + materialName + " in config. Using COMPASS.");
        material = Material.COMPASS;
    }

    // 修正逻辑：只有 SKULL_ITEM 或 LEGACY_SKULL_ITEM 且 data 为 3 时才使用头颅
    if ((materialName.equals("SKULL_ITEM") || materialName.equals("LEGACY_SKULL_ITEM")) && con.getInt("options-item.data") == 3) {
        item = getSkull(con.getString("options-item.skull-url"));
    } else {
        // 注意：data 值在高版本中已不常用，但保留原逻辑
        item = new ItemStack(material, con.getInt("options-item.amount"), (short) con.getInt("options-item.data"));
    }

    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(getMsg(p, MessagePaths.SPECTATOR_OPTIONS_ITEM_NAME));
    meta.setLore(getListMsg(p, MessagePaths.SPECTATOR_OPTIONS_ITEM_LORE));
    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
    item.setItemMeta(meta);

    if (con.getBoolean("options-item.enchanted")) item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

    return item;
}

    public static ItemStack getSkull(String url) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);

        if (url == null || url.isEmpty())
            return skull;

        ItemMeta skullMeta = skull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField;

        try {
            profileField = skullMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            throw new RuntimeException(e);
        }

        profileField.setAccessible(true);

        try {
            profileField.set(skullMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        skull.setItemMeta(skullMeta);
        return skull;
    }
}
