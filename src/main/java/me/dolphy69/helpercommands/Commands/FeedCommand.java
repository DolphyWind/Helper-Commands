package me.dolphy69.helpercommands.Commands;

import me.dolphy69.helpercommands.HelperCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    HelperCommands hc;

    public FeedCommand(HelperCommands _hc)
    {
        hc = _hc;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0)
        {
            if(sender instanceof Player p)
            {
                p.setFoodLevel(20);
                hc.getServer().broadcastMessage(ChatColor.GREEN + "Bon Appétit!");
            }
            else
            {
                hc.getServer().broadcastMessage(ChatColor.RED + "This command can only be run on players!");
            }
        }
        else
        {
            String playerName = args[0];
            Player p2 = Bukkit.getPlayer(playerName);
            if(p2 != null)
            {
                p2.setHealth(20);
                hc.getServer().broadcastMessage(ChatColor.GREEN + playerName + "'s food level is set to 10 hearts.");
            }

            else
                hc.getServer().broadcastMessage(ChatColor.RED + "Player named " + playerName + " could not found!");
        }
        return true;
    }
}
