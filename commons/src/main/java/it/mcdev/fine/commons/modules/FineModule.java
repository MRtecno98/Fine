package it.mcdev.fine.commons.modules;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.Optional;

public abstract class FineModule extends JavaPlugin {

    private FineModuleManager moduleManager;

    @Override
    public final void onLoad() {
        load();
    }

    public void load() {
    }

    @Override
    public final void onEnable() {
        moduleManager = Optional.ofNullable(getServer().getServicesManager().getRegistration(FineModuleManager.class))
                .map(RegisteredServiceProvider::getProvider)
                .orElseThrow(() -> new IllegalStateException("FineModuleManager can't be found!"));
        moduleManager.registerModule(this);
        enable();
    }

    public void enable() {
    }

    @Override
    public final void onDisable() {
        disable();
        moduleManager.registerModule(this);
    }

    public void disable() {
    }

    public Logger getModuleLogger() {
        return super.getSLF4JLogger();
    }

    @Deprecated
    public final java.util.logging.Logger getLogger() {
        return super.getLogger();
    }

    @Deprecated
    public final Logger getSLF4JLogger() {
        return super.getSLF4JLogger();
    }

    @NotNull
    protected FineModuleManager getModuleManager() {
        if (moduleManager == null) {
            throw new IllegalStateException("Not yet initialized!");
        }
        return moduleManager;
    }
}
