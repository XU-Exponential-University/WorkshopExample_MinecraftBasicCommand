package com.xu.example.simpleCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class SpigotPlugin extends JavaPlugin {

    @Override
    public void onDisable() {

        // Wird ausgeführt wenn das Plugin deaktiviert wird (zum Beispiel bei einem Reload oder einem Neustart)

    }

    @Override
    public void onEnable() {

        // Wird ausgeführt wenn das Plugin aktiviert wird (zum Beispiel beim Start des Servers)

        // Hier teilen wir den Server mit das es ab jetzt auf einen neuen Command reagieren soll. So kann dieser zum Beispiel von der automatischen Vervollständigung erkannt werden.
        getCommand("beispiel").setExecutor(new BeispielCommand(this));
        getCommand("boom").setExecutor(new ExplosionCommand(this));

    }

}

