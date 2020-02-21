package com.xu.example.simpleCommand;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class ExplosionCommand implements CommandExecutor {

    SpigotPlugin plugin;

    public ExplosionCommand(SpigotPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String cmdName = cmd.getName().toLowerCase();

        // Schaut ob der Name des Commands dem Erwarteten entspricht
        if (!cmdName.equals("boom")) {
            // Meldet das der Command nicht erfolgreich ausführt wurde
            // wenn der Command nicht "boom" ist
            return false;
        } else if(!(sender instanceof Player)){ // Überprüft ob der Command von einem Spieler kam
            sender.sendMessage("Dieser Befehl kann nur von Spielern ausgeführt werden");
            return false;
        } else {
            if(args.length != 1){ // Überprüft ob genau ein Parameter für den Befehl angegeben wurde
                sender.sendMessage("Bitte gib alle benötigeten Argumente für diesem Befehl an!");
                return false;
            } else { // Alles gut, Befehl wird augeführt

                // Greift auf den Spieler zu dessen Name mit dem Befehl angegeben wurde
                Player target = getServer().getPlayer(args[0]);

                if(target == null){ // Überprüft ob der Spieler gefunden werden kann
                    sender.sendMessage("Der Spieler '" + args[0] + "' ist nicht Online!");
                    return false;
                } else { // Ziel-Spieler gefunden, gleich machts bumm!

                    // Legt die Stärke der Explosion fest
                    float explosionPower = 4F;

                    // Schaut wo sich das Ziel befindet
                    Location targetLocation = target.getLocation();

                    // Erzeugt eine Explosion beim Spieler
                    target.getWorld().createExplosion(targetLocation, explosionPower);

                    // Setzt die Lebenspunkte des Spielers auf 0
                    target.setHealth(0.0D);

                    // Meldet das Command erfolgreich ausgeführt wurde
                    return true;
                }
            }
        }
    }
}
