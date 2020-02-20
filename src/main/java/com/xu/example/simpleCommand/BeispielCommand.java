package com.xu.example.simpleCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BeispielCommand implements CommandExecutor {

    SpigotPlugin plugin;

    public BeispielCommand(SpigotPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String cmdName = cmd.getName().toLowerCase();

        if (!cmdName.equals("beispiel")) {
            return false;
        }

        sender.sendMessage("Successfully used example command!");
        return true;

    }
}
