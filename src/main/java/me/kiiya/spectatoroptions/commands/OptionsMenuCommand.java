package me.kiiya.spectatoroptions.commands;

import me.kiiya.spectatoroptions.menus.OptionsMenu;
import me.kiiya.spectatoroptions.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class OptionsMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("§cThis command can only be executed by players.");
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("bw.spectatoroptions")) {
            p.sendMessage(Utils.getMsg(p, "cmd-not-found").replace("%bw_prefix%", Utils.getMsg(p, "prefix")).replace("{prefix}", Utils.getMsg(p, "prefix")));
            return false;
        }
        new OptionsMenu(p);
        return false;
    }
}
