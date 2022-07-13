package me.dolphy69.helpercommands;

import me.dolphy69.helpercommands.Commands.FeedCommand;
import me.dolphy69.helpercommands.Commands.HealCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelperCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("heal").setExecutor(new HealCommand(this));
        getCommand("feed").setExecutor(new FeedCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
