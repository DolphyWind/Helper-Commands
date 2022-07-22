package me.dolphy69.helpercommands.Commands;

import me.dolphy69.helpercommands.GlobalValues;
import me.dolphy69.helpercommands.HelperCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

public class DeathLocatorCommand implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0)
        {
            sender.sendMessage(ChatColor.RED + "Usage: /deathlocator enable/disable/toggle");
            return true;
        }
        else if(args[0].equalsIgnoreCase("enable"))
        {
            GlobalValues.isDeathLocatorEnabled = true;
            sender.sendMessage(ChatColor.GREEN + "DeathLocator enabled!");
        }
        else if(args[0].equalsIgnoreCase("disable"))
        {
            GlobalValues.isDeathLocatorEnabled = false;
            sender.sendMessage(ChatColor.GREEN + "DeathLocator disabled!");
        }
        else if(args[0].equalsIgnoreCase("toggle"))
        {
            GlobalValues.isDeathLocatorEnabled = !GlobalValues.isDeathLocatorEnabled;
            if(GlobalValues.isDeathLocatorEnabled)
                sender.sendMessage(ChatColor.GREEN + "DeathLocator enabled!");
            else
                sender.sendMessage(ChatColor.GREEN + "DeathLocator disabled!");
        }
        else if(args[0].equalsIgnoreCase("status"))
        {
            if(GlobalValues.isDeathLocatorEnabled)
                sender.sendMessage(ChatColor.AQUA + "Death locator is currently " + ChatColor.GREEN + "enabled" + ChatColor.AQUA + "!");
            else
                sender.sendMessage(ChatColor.AQUA + "Death locator is currently " + ChatColor.RED + "disabled" + ChatColor.AQUA + "!");
            return true;
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "Usage: /deathlocator <enable|disable|toggle|status>");
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1)
        {
            List<String> completions = new ArrayList<String>();
            completions.add("enable");
            completions.add("disable");
            completions.add("toggle");
            return completions;
        }
        return null;
    }
}
