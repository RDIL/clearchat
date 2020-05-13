package rocks.rdil.clearchat;

import rocks.rdil.clearchat.commands.ClearChatCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClearChat extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("clearchat").setExecutor(new ClearChatCommand(this));
    }
}
