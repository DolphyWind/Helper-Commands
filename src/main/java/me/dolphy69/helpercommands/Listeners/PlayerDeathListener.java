package me.dolphy69.helpercommands.Listeners;

import me.dolphy69.helpercommands.GlobalValues;
import me.dolphy69.helpercommands.HelperCommands;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener
{
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        if(!GlobalValues.isDeathLocatorEnabled) return;
        Player p = e.getEntity();
        Location loc = p.getLocation();
        World world = p.getWorld();
        String message = String.format(ChatColor.YELLOW + "You died in %s at X:%.3f Y:%.3f Z:%.3f", world.getName(), loc.getX(), loc.getY(), loc.getZ());
        p.sendMessage(message);
    }
}
