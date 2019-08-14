package it.mcdev.fine.core;

import ch.jalu.injector.Injector;
import ch.jalu.injector.InjectorBuilder;
import it.mcdev.fine.commons.modules.FineModuleManager;
import it.mcdev.fine.core.locale.CoreLocale;
import it.mcdev.fine.core.locale.CoreLocaleFolder;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

import java.io.File;

public final class Fine extends JavaPlugin {

    private Logger logger;
    private Injector injector;
    private CoreLocale locale;
    private FineModuleManager moduleManager;

    @Override
    public void onEnable() {
        logger = getSLF4JLogger();
        injector = new InjectorBuilder()
                .addDefaultHandlers("it.mcdev.fine")
                .create();
        injector.register(Server.class, getServer());
        injector.register(Injector.class, injector);
        injector.provide(CoreLogger.class, logger);
        injector.provide(CoreLocaleFolder.class, new File(getDataFolder(), "locale"));
        locale = injector.getSingleton(CoreLocale.class);
        moduleManager = injector.getSingleton(FineModuleManager.class);
    }

    @Override
    public void onDisable() {
    }
}
