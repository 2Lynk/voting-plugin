package votingplugin.votingplugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import votingplugin.votingplugin.commands.vote;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // Then we load all the commands we have made
        getCommand("vote").setExecutor(new vote());

        // When all is done we print a message to the console
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Vote plugin] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Vote plugin] Plugin disabled!");
    }
}
