package votingplugin.votingplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.*;


public class vote implements CommandExecutor {

    static void annouceVote(String player, String voteOn, String voteValue){
        getServer().broadcastMessage(player + " started a vote to set the " + voteOn + " to: " + voteValue );
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // First we check if the sender of the command is a player and not the console
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command, you silly admin");
            return true;
        }

        Player player = (Player) sender;
        World world = getWorlds().get(0);

        // command: /vote
        if(command.getName().equalsIgnoreCase("vote")) {
            if(args.length != 2){
                player.sendMessage("§c(Server): You have to add what the vote is for!");
                player.sendMessage("§c(Server): example: /vote weather clear");
                player.sendMessage("§c(Server): example: /vote time day");
            }else{
                if(args[0].equalsIgnoreCase("time")){
                    switch(args[1]){
                        case "day":
                            world.setTime(1000);
                            break;
                        case "noon":
                            world.setTime(6000);
                            break;
                        case "sunset":
                            world.setTime(12000);
                            break;
                        case "night":
                            world.setTime(13000);
                            break;
                        case "midnight":
                            world.setTime(18000);
                            break;
                        case "sunrise":
                            world.setTime(23000);
                            break;
                        default:
                            player.sendMessage("§c(Server): Wrong argument, options:");
                            player.sendMessage("§c(Server): day, noon, sunset, night, midnight, sunrise");
                            break;
                    }
                    annouceVote(player.getDisplayName(), "time", args[1]);
                }else if(args[0].equalsIgnoreCase("weather")){
                    getServer().broadcastMessage(player.getDisplayName() + " started a vote to set the weather to: " + args[1]);
                }else{
                    player.sendMessage("§c(Server): Invalid arguments, please use the command like the following examples!");
                    player.sendMessage("§c(Server): example: /vote weather clear");
                    player.sendMessage("§c(Server): example: /vote time day");
                }
            }
        }



        return true;
    }
}