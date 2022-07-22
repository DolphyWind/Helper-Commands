package me.dolphy69.helpercommands;

import me.dolphy69.helpercommands.Commands.DeathLocatorCommand;
import me.dolphy69.helpercommands.Commands.FeedCommand;
import me.dolphy69.helpercommands.Commands.HealCommand;
import me.dolphy69.helpercommands.Listeners.PlayerDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelperCommands extends JavaPlugin {

    private Object getFromCFG(String path, Object defaultValue)
    {
        if(!getConfig().contains(path))
        {
            getConfig().set(path, defaultValue);
            return defaultValue;
        }
        return getConfig().get(path);
    }

    @Override
    public void onEnable() {

        GlobalValues.isDeathLocatorEnabled = (boolean) getFromCFG(GlobalValues.isDeathLocatorEnabledPath, false);

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("deathlocator").setExecutor(new DeathLocatorCommand());

        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);

    }

    @Override
    public void onDisable() {
        getConfig().set(GlobalValues.isDeathLocatorEnabledPath, GlobalValues.isDeathLocatorEnabled);
        saveConfig();
    }
}
