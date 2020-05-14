package rocks.rdil.clearchat.commands;

import rocks.rdil.clearchat.ClearChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {
    private String message;

    public ClearChatCommand(ClearChat plugin) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 99; i++) {
            str.append("\n");
            str.append(" ");
        }
        str.append("\n");
        str.append(plugin.getConfig().getString("cleared-message"));
        message = ChatColor.translateAlternateColorCodes('&', str.toString());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String caller = "Console";
        if (sender instanceof Player) {
            Player plr = (Player) sender;
            caller = plr.getName();
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message.replace("{player}", caller));
        }
        return true;
    }
}
