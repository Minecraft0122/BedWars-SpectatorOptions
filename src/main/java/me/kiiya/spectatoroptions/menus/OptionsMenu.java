package me.kiiya.spectatoroptions.menus;

import me.kiiya.spectatoroptions.SpectatorOptions;
import me.kiiya.spectatoroptions.configuration.MainConfig;
import me.kiiya.spectatoroptions.player.CachedOptions;
import me.kiiya.spectatoroptions.player.SpectatorManager;
import me.kiiya.spectatoroptions.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.ArrayList;
import java.util.List;

import static me.kiiya.spectatoroptions.configuration.paths.MessagePaths.*;
import static me.kiiya.spectatoroptions.configuration.paths.ConfigPaths.*;

public class OptionsMenu implements GUIHolder {
    private Player p;
    private Inventory inv;
    private final CachedOptions cachedOptions;

    public OptionsMenu(Player p) {
        this.p = p;
        this.cachedOptions = SpectatorManager.getInstance().getCachedOptions(p);
        createInventory();
        addContents();
        p.openInventory(inv);
    }

    private void createInventory() {
        inv = Bukkit.createInventory(this, 9 * SpectatorOptions.getInstance().getMainConfig().getInt("options-menu.rows"), Utils.getMsg(p, OPTIONS_MENU_NAME));
    }

    private void addContents() {
        MainConfig mc = SpectatorOptions.getInstance().getMainConfig();
        ItemStack noSpeed = new ItemStack(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_NO_SPEED_MATERIAL)), 1, (short) mc.getInt(OPTIONS_MENU_ITEM_NO_SPEED_DATA));
        if (noSpeed.getType().toString().equals("SKULL_ITEM") || noSpeed.getType().toString().equals("LEGACY_SKULL_ITEM") && noSpeed.getDurability() == 3) {
            noSpeed = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_NO_SPEED_SKULL_URL));
        }
        ItemMeta noSpeedMeta = noSpeed.getItemMeta();
        noSpeedMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_NO_SPEED_NAME));
        noSpeedMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_NO_SPEED_LORE));
        noSpeedMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ENCHANTS);
        noSpeed.setItemMeta(noSpeedMeta);

        ItemStack speedI = new ItemStack(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_SPEED_I_MATERIAL)), 1, (short) mc.getInt(OPTIONS_MENU_ITEM_SPEED_I_DATA));
        if (speedI.getType().toString().equals("SKULL_ITEM") || speedI.getType().toString().equals("LEGACY_SKULL_ITEM") && speedI.getDurability() == 3) {
            speedI = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_SPEED_I_SKULL_URL));
        }
        ItemMeta speedIMeta = speedI.getItemMeta();
        speedIMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_SPEED_I_NAME));
        speedIMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_SPEED_I_LORE));
        speedIMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ENCHANTS);
        speedI.setItemMeta(speedIMeta);

        ItemStack speedII = new ItemStack(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_SPEED_II_MATERIAL)), 1, (short) mc.getInt(OPTIONS_MENU_ITEM_SPEED_II_DATA));
        if (speedII.getType().toString().equals("SKULL_ITEM") || speedII.getType().toString().equals("LEGACY_SKULL_ITEM") && speedII.getDurability() == 3) {
            speedII = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_SPEED_II_SKULL_URL));
        }
        ItemMeta speedIIMeta = speedII.getItemMeta();
        speedIIMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_SPEED_II_NAME));
        speedIIMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_SPEED_II_LORE));
        speedIIMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ENCHANTS);
        speedII.setItemMeta(speedIIMeta);

        ItemStack speedIII = new ItemStack(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_SPEED_III_MATERIAL)), 1, (short) mc.getInt(OPTIONS_MENU_ITEM_SPEED_III_DATA));
        if (speedIII.getType().toString().equals("SKULL_ITEM") || speedIII.getType().toString().equals("LEGACY_SKULL_ITEM") && speedIII.getDurability() == 3) {
            speedIII = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_SPEED_III_SKULL_URL));
        }
        ItemMeta speedIIIMeta = speedIII.getItemMeta();
        speedIIIMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_SPEED_III_NAME));
        speedIIIMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_SPEED_III_LORE));
        speedIIIMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ENCHANTS);
        speedIII.setItemMeta(speedIIIMeta);

        ItemStack speedIV = new ItemStack(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_SPEED_IV_MATERIAL)), 1, (short) mc.getInt(OPTIONS_MENU_ITEM_SPEED_IV_DATA));
        if (speedIV.getType().toString().equals("SKULL_ITEM") || speedIV.getType().toString().equals("LEGACY_SKULL_ITEM") && speedIV.getDurability() == 3) {
            speedIV = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_SPEED_IV_SKULL_URL));
        }
        ItemMeta speedIVMeta = speedIV.getItemMeta();
        speedIVMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_SPEED_IV_NAME));
        speedIVMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_SPEED_IV_LORE));
        speedIVMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ENCHANTS);
        speedIV.setItemMeta(speedIVMeta);

        ItemStack autoTeleport = new ItemStack(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_AUTOTELEPORT_ENABLED_MATERIAL)), 1, (short) mc.getInt(OPTIONS_MENU_ITEM_AUTOTELEPORT_ENABLED_DATA));
        ItemMeta autoTeleportMeta = autoTeleport.getItemMeta();
        if (!cachedOptions.isAutoTeleport()) {
            if (autoTeleport.getType().toString().equals("SKULL_ITEM") || autoTeleport.getType().toString().equals("LEGACY_SKULL_ITEM") && autoTeleport.getDurability() == 3) {
                autoTeleport = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_AUTOTELEPORT_ENABLED_SKULL_URL));
            } else {
                autoTeleport.setType(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_AUTOTELEPORT_ENABLED_MATERIAL)));
            }
            autoTeleportMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_AUTOTELEPORT_ENABLED_NAME));
            autoTeleportMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_AUTOTELEPORT_ENABLED_LORE));
        } else {
            if (autoTeleport.getType().toString().equals("SKULL_ITEM") || autoTeleport.getType().toString().equals("LEGACY_SKULL_ITEM") && autoTeleport.getDurability() == 3) {
                autoTeleport = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_AUTOTELEPORT_DISABLED_SKULL_URL));
            } else {
                autoTeleport.setType(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_AUTOTELEPORT_DISABLED_MATERIAL)));
            }
            autoTeleportMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_AUTOTELEPORT_DISABLED_NAME));
            autoTeleportMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_AUTOTELEPORT_DISABLED_LORE));
        }
        autoTeleportMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ENCHANTS);
        autoTeleport.setItemMeta(autoTeleportMeta);

        ItemStack nightVision = new ItemStack(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_NIGHT_VISION_ENABLED_MATERIAL)), 1, (short) mc.getInt(OPTIONS_MENU_ITEM_NIGHT_VISION_ENABLED_DATA));
        ItemMeta nightVisionMeta = nightVision.getItemMeta();
        if (!cachedOptions.isNightVision()) {
            if (nightVision.getType().toString().equals("SKULL_ITEM") || nightVision.getType().toString().equals("LEGACY_SKULL_ITEM") && nightVision.getDurability() == 3) {
                nightVision = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_NIGHT_VISION_ENABLED_SKULL_URL));
            } else {
                nightVision.setType(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_NIGHT_VISION_ENABLED_MATERIAL)));
            }
            nightVisionMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_NIGHT_VISION_ENABLED_NAME));
            nightVisionMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_NIGHT_VISION_ENABLED_LORE));
        } else {
            if (nightVision.getType().toString().equals("SKULL_ITEM") || nightVision.getType().toString().equals("LEGACY_SKULL_ITEM") && nightVision.getDurability() == 3) {
                nightVision = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_NIGHT_VISION_DISABLED_SKULL_URL));
            } else {
                nightVision.setType(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_NIGHT_VISION_DISABLED_MATERIAL)));
            }
            nightVisionMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_NIGHT_VISION_DISABLED_NAME));
            nightVisionMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_NIGHT_VISION_DISABLED_LORE));
        }
        nightVisionMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ENCHANTS);
        nightVision.setItemMeta(nightVisionMeta);

        ItemStack firstPerson = new ItemStack(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_FIRST_PERSON_ENABLED_MATERIAL)), 1, (short) mc.getInt(OPTIONS_MENU_ITEM_FIRST_PERSON_ENABLED_DATA));
        ItemMeta firstPersonMeta = firstPerson.getItemMeta();
        if (!cachedOptions.isFirstPerson()) {
            if (firstPerson.getType().toString().equals("SKULL_ITEM") || firstPerson.getType().toString().equals("LEGACY_SKULL_ITEM") && firstPerson.getDurability() == 3) {
                firstPerson = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_FIRST_PERSON_ENABLED_SKULL_URL));
            } else {
                firstPerson.setType(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_FIRST_PERSON_ENABLED_MATERIAL)));
            }
            firstPersonMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_FIRST_PERSON_ENABLED_NAME));
            firstPersonMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_FIRST_PERSON_ENABLED_LORE));
        } else {
            if (firstPerson.getType().toString().equals("SKULL_ITEM") || firstPerson.getType().toString().equals("LEGACY_SKULL_ITEM") && firstPerson.getDurability() == 3) {
                firstPerson = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_FIRST_PERSON_DISABLED_SKULL_URL));
            } else {
                firstPerson.setType(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_FIRST_PERSON_DISABLED_MATERIAL)));
            }
            firstPersonMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_FIRST_PERSON_DISABLED_NAME));
            firstPersonMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_FIRST_PERSON_DISABLED_LORE));
        }
        firstPersonMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ENCHANTS);
        firstPerson.setItemMeta(firstPersonMeta);

        ItemStack toggleSpectators = new ItemStack(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_ENABLED_MATERIAL)), 1, (short) mc.getInt(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_ENABLED_DATA));
        ItemMeta toggleSpectatorsMeta = toggleSpectators.getItemMeta();
        if (!cachedOptions.isHideSpectators()) {
            if (toggleSpectators.getType().toString().equals("SKULL_ITEM") || toggleSpectators.getType().toString().equals("LEGACY_SKULL_ITEM") && toggleSpectators.getDurability() == 3) {
                toggleSpectators = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_ENABLED_SKULL_URL));
            } else {
                toggleSpectators.setType(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_ENABLED_MATERIAL)));
            }
            toggleSpectatorsMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_TOGGLE_SPECTATORS_ENABLED_NAME));
            toggleSpectatorsMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_TOGGLE_SPECTATORS_ENABLED_LORE));
        } else {
            if (toggleSpectators.getType().toString().equals("SKULL_ITEM") || toggleSpectators.getType().toString().equals("LEGACY_SKULL_ITEM") && toggleSpectators.getDurability() == 3) {
                toggleSpectators = Utils.getSkull(mc.getString(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_DISABLED_SKULL_URL));
            } else {
                toggleSpectators.setType(Material.getMaterial(mc.getString(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_DISABLED_MATERIAL)));
            }
            toggleSpectatorsMeta.setDisplayName(Utils.getMsg(p, OPTIONS_ITEM_TOGGLE_SPECTATORS_DISABLED_NAME));
            toggleSpectatorsMeta.setLore(Utils.getListMsg(p, OPTIONS_ITEM_TOGGLE_SPECTATORS_DISABLED_LORE));
        }
        toggleSpectatorsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ENCHANTS);
        toggleSpectators.setItemMeta(toggleSpectatorsMeta);

        if (mc.getBoolean(ENABLE_NO_SPEED)) {
            inv.setItem(mc.getInt(OPTIONS_MENU_ITEM_NO_SPEED_SLOT), noSpeed);
        }
        if (mc.getBoolean(ENABLE_SPEED_I)) {
            inv.setItem(mc.getInt(OPTIONS_MENU_ITEM_SPEED_I_SLOT), speedI);
        }
        if (mc.getBoolean(ENABLE_SPEED_II)) {
            inv.setItem(mc.getInt(OPTIONS_MENU_ITEM_SPEED_II_SLOT), speedII);
        }
        if (mc.getBoolean(ENABLE_SPEED_III)) {
            inv.setItem(mc.getInt(OPTIONS_MENU_ITEM_SPEED_III_SLOT), speedIII);
        }
        if (mc.getBoolean(ENABLE_SPEED_IV)) {
            inv.setItem(mc.getInt(OPTIONS_MENU_ITEM_SPEED_IV_SLOT), speedIV);
        }
        if (mc.getBoolean(ENABLE_AUTOTELEPORT)) {
            inv.setItem(mc.getInt(OPTIONS_MENU_ITEM_AUTOTELEPORT_SLOT), autoTeleport);
        }
        if (mc.getBoolean(ENABLE_NIGHT_VISION)) {
            inv.setItem(mc.getInt(OPTIONS_MENU_ITEM_NIGHT_VISION_SLOT), nightVision);
        }
        if (mc.getBoolean(ENABLE_FIRST_PERSON)) {
            inv.setItem(mc.getInt(OPTIONS_MENU_ITEM_FIRST_PERSON_SLOT), firstPerson);
        }
        if (mc.getBoolean(ENABLE_TOGGLE_SPECTATORS)) {
            inv.setItem(mc.getInt(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_SLOT), toggleSpectators);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        int slot = e.getSlot();
        MainConfig mc = SpectatorOptions.getInstance().getMainConfig();

        if (slot == mc.getInt(OPTIONS_MENU_ITEM_NO_SPEED_SLOT)) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_SPEED_CHANGED).replace("{value}", Utils.getMsg(p, OPTIONS_MESSAGES_SPEED_MEANINGS_NO_SPEED)));
        } else if (slot == mc.getInt(OPTIONS_MENU_ITEM_SPEED_I_SLOT)) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, true, false));
            p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_SPEED_CHANGED).replace("{value}", Utils.getMsg(p, OPTIONS_MESSAGES_SPEED_MEANINGS_SPEED_I)));
        } else if (slot == mc.getInt(OPTIONS_MENU_ITEM_SPEED_II_SLOT)) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));
            p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_SPEED_CHANGED).replace("{value}", Utils.getMsg(p, OPTIONS_MESSAGES_SPEED_MEANINGS_SPEED_II)));
        } else if (slot == mc.getInt(OPTIONS_MENU_ITEM_SPEED_III_SLOT)) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2, true, false));
            p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_SPEED_CHANGED).replace("{value}", Utils.getMsg(p, OPTIONS_MESSAGES_SPEED_MEANINGS_SPEED_III)));
        } else if (slot == mc.getInt(OPTIONS_MENU_ITEM_SPEED_IV_SLOT)) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3, true, false));
            p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_SPEED_CHANGED).replace("{value}", Utils.getMsg(p, OPTIONS_MESSAGES_SPEED_MEANINGS_SPEED_IV)));
        } else if (slot == mc.getInt(OPTIONS_MENU_ITEM_AUTOTELEPORT_SLOT)) {
            cachedOptions.setAutoTeleport(!cachedOptions.isAutoTeleport());
            if (cachedOptions.isAutoTeleport()) {
                p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_AUTOTELEPORT_ENABLED));
            } else {
                p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_AUTOTELEPORT_DISABLED));
            }
        } else if (slot == mc.getInt(OPTIONS_MENU_ITEM_NIGHT_VISION_SLOT)) {
            cachedOptions.setNightVision(!cachedOptions.isNightVision());
            if (cachedOptions.isNightVision()) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
                p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_NIGHT_VISION_ENABLED));
            } else {
                p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_NIGHT_VISION_DISABLED));
            }
        } else if (slot == mc.getInt(OPTIONS_MENU_ITEM_FIRST_PERSON_SLOT)) {
            cachedOptions.setFirstPerson(!cachedOptions.isFirstPerson());
            if (cachedOptions.isFirstPerson()) {
                p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_FIRST_PERSON_ENABLED));
            } else {
                p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_FIRST_PERSON_DISABLED));
            }
        } else if (slot == mc.getInt(OPTIONS_MENU_ITEM_TOGGLE_SPECTATORS_SLOT)) {
            cachedOptions.setHideSpectators(!cachedOptions.isHideSpectators());
            List<Player> spectators = new ArrayList<>();
            switch (SpectatorOptions.getInstance().getSupport()) {
                case BEDWARS1058:
                    com.andrei1058.bedwars.api.arena.IArena arena1058 = SpectatorOptions.getInstance().getBedWars1058API().getArenaUtil().getArenaByPlayer(p);
                    if (arena1058 != null) {
                        spectators = arena1058.getSpectators();
                    }
                    break;
                case BEDWARS2023:
                    com.tomkeuper.bedwars.api.arena.IArena arena2023 = SpectatorOptions.getInstance().getBedWars2023API().getArenaUtil().getArenaByPlayer(p);
                    if (arena2023 != null) {
                        spectators = arena2023.getSpectators();
                    }
                    break;
            }

            if (!cachedOptions.isHideSpectators()) {
                for (Player spectator : spectators) {
                    p.showPlayer(spectator);
                }
                p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_TOGGLE_SPECTATORS_DISABLED));
            } else {
                for (Player spectator : spectators) {
                    p.hidePlayer(spectator);
                }
                p.sendMessage(Utils.getMsg(p, OPTIONS_MESSAGES_TOGGLE_SPECTATORS_ENABLED));
            }
        }
        new OptionsMenu(p);
    }
}
